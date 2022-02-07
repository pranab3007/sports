package org.test.pranab.sports.service;

import org.test.pranab.sports.dto.TeamDto;
import org.test.pranab.sports.entity.Team;

public interface TeamService {

    public Team createTeam(TeamDto teamDto);
    public Team updateTeam(TeamDto teamDto, Long id);
    public Team getTeam(Long id);
    public void deleteteam(Long id);
}
