package com.appsflyer.game.mapper;

import com.appsflyer.game.dto.TeamAnswerDTO;
import com.appsflyer.game.entities.TeamAnswer;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    uses = {QuestionMapper.class, TeamMapper.class, GameMapper.class},
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TeamAnswerMapper {
    TeamAnswerDTO convertToDto(TeamAnswer teamAnswer);
}
