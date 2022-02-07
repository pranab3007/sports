package org.test.pranab.sports.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.test.pranab.sports.dto.TeamDto;
import org.test.pranab.sports.entity.Team;
import org.test.pranab.sports.exception.SportsappException;
import org.test.pranab.sports.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team createTeam(TeamDto teamDto) {
        Team team = new Team();
        BeanUtils.copyProperties(teamDto,team);
        return teamRepository.save(team);
    }

    @Override
    public Team updateTeam(TeamDto teamDto, Long id) {
        Team team = teamRepository.findById(id).orElseThrow(()->new SportsappException(HttpStatus.NOT_FOUND.value(),
                "Team not found"));
        BeanUtils.copyProperties(teamDto, team);
        return teamRepository.save(team);
    }

    @Override
    public Team getTeam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(()->new SportsappException(HttpStatus.NOT_FOUND.value(),
                "Team not found"));
        return team;
    }

    @Override
    public void deleteteam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(()->new SportsappException(HttpStatus.NOT_FOUND.value(),
                "Team not found"));
        teamRepository.delete(team);
    }
}
