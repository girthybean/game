package com.appsflyer.game.mapper;

import com.appsflyer.game.dto.GameDTO;
import com.appsflyer.game.entities.Game;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    uses = TeamMapper.class,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface GameMapper {

    GameDTO convertToDto(Game game);
}
