package com.appsflyer.game.service;

import com.appsflyer.game.dto.AnswerDTO;
import com.appsflyer.game.dto.GameDTO;
import com.appsflyer.game.dto.TeamAnswerDTO;
import com.appsflyer.game.dto.TeamDTO;
import com.appsflyer.game.entities.Game;
import com.appsflyer.game.entities.Question;
import com.appsflyer.game.entities.Team;
import com.appsflyer.game.entities.TeamAnswer;
import com.appsflyer.game.exceptions.WrongAnswerException;
import com.appsflyer.game.mapper.GameMapper;
import com.appsflyer.game.mapper.TeamAnswerMapper;
import com.appsflyer.game.mapper.TeamMapper;
import com.appsflyer.game.repository.GameRepository;
import com.appsflyer.game.repository.QuestionRepository;
import com.appsflyer.game.repository.TeamAnswerRepository;
import com.appsflyer.game.repository.TeamRepository;
import jakarta.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;
    private final TeamRepository teamRepository;
    private final QuestionRepository questionRepository;
    private final TeamAnswerRepository teamAnswerRepository;
    private final GameMapper gameMapper;
    private final TeamAnswerMapper teamAnswerMapper;
    private final TeamMapper teamMapper;

    @Transactional
    public TeamDTO registerNewTeam(String teamName) {
        if (teamRepository.existsByName(teamName.toLowerCase())) {
            throw new IllegalArgumentException("Team already exists");
        }
        Team team = new Team();
        team.setName(teamName.toLowerCase());
        return teamMapper.convertToDto(teamRepository.save(team));
    }

    @Transactional
    public GameDTO startGame(Long teamId) {
        Team team = teamRepository.findById(teamId)
            .orElseThrow(() -> new NoSuchElementException(teamId.toString()));
        Game existing = gameRepository.findGameByTeam(team)
            .orElse(null);
        if (existing != null) {
            return gameMapper.convertToDto(existing);
        }
        Game game = new Game();
        game.setTeam(team);
        List<Question> all = questionRepository.findAll();
        Collections.shuffle(all);
        game.getQuestions().addAll(all);
        Game savedGame = gameRepository.save(game);
        return gameMapper.convertToDto(savedGame);
    }

    @Transactional
    public TeamAnswerDTO checkAnswer(AnswerDTO answer) {
        Team team = teamRepository.findById(answer.teamId())
            .orElseThrow(() -> new NoSuchElementException(answer.teamId().toString()));
        Game game = gameRepository.findGameByTeam(team)
            .orElseThrow();
        Question question = questionRepository.findById(answer.questionId())
            .orElseThrow();
        if (!question.getAnswer().equalsIgnoreCase(answer.answer())) {
            throw new WrongAnswerException("Wrong answer: " + answer.answer());
        }
        TeamAnswer teamAnswer = createTeamAnswer(question, game, team);
        TeamAnswer saved = teamAnswerRepository.save(teamAnswer);
        game.getAnswers().add(saved);
        team.getAnswers().add(saved);
        return teamAnswerMapper.convertToDto(saved);
    }

    public List<TeamAnswerDTO> teamStats(Long teamId) {
        Team team = teamRepository.findById(teamId)
            .orElseThrow(() -> new NoSuchElementException(teamId.toString()));
        Game game = gameRepository.findGameByTeam(team)
            .orElseThrow();
        List<TeamAnswer> answers = game.getAnswers();
        return teamAnswerMapper.convertToDto(answers);
    }

    private static @NonNull TeamAnswer createTeamAnswer(Question question, Game game, Team team) {
        TeamAnswer teamAnswer = new TeamAnswer();
        teamAnswer.setIsDone(true);
        teamAnswer.setQuestion(question);
        teamAnswer.setGame(game);
        return teamAnswer;
    }

    public Map<Long, List<TeamAnswerDTO>> gameTotal() {

        return teamAnswerMapper.convertToDto(teamAnswerRepository.findAll())
            .stream()
            .collect(Collectors.groupingBy(teamAnswerDTO -> teamAnswerDTO.game().team().id()));
    }
}
