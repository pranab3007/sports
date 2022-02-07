package org.test.pranab.sports.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.test.pranab.sports.dto.PlayerDto;
import org.test.pranab.sports.entity.Player;
import org.test.pranab.sports.entity.Team;
import org.test.pranab.sports.exception.SportsappException;
import org.test.pranab.sports.repository.PlayerRepository;
import org.test.pranab.sports.repository.TeamRepository;

@Service
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Player createPlayer(PlayerDto playerDto, Long teamid) {
        Team team = teamRepository.findById(teamid).orElseThrow(()->new SportsappException(HttpStatus.NOT_FOUND.value(),
                "Team not found"));
        Player player = new Player();
        BeanUtils.copyProperties(playerDto, player);
        player = playerRepository.save(player);
        team.getPlayers().add(player);
        teamRepository.save(team);
        return player;
    }

    @Override
    public Player updatePlayer(PlayerDto playerDto, Long id) {
        Player player = playerRepository.findById(id).orElseThrow(()->new SportsappException(HttpStatus.NOT_FOUND.value(),
                "Player not found"));
        BeanUtils.copyProperties(playerDto, player);
        return playerRepository.save(player);
    }

    @Override
    public Player getPlayer(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(()->new SportsappException(HttpStatus.NOT_FOUND.value(),
                "Player not found"));
        return player;
    }

    @Override
    public void deletePlayer(Long id) {
        Player player = playerRepository.findById(id).orElseThrow(()->new SportsappException(HttpStatus.NOT_FOUND.value(),
                "Player not found"));
        playerRepository.delete(player);
    }
}
