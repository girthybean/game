package com.appsflyer.game.mapper;

import com.appsflyer.game.dto.TeamDTO;
import com.appsflyer.game.entities.Team;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TeamMapper {
    TeamDTO convertToDto(Team team);
}
