package org.test.pranab.sports.service;

import org.test.pranab.sports.dto.PlayerDto;
import org.test.pranab.sports.entity.Player;

public interface PlayerService {
    public Player createPlayer(PlayerDto playerDto, Long teamid);
    public Player updatePlayer(PlayerDto playerDto, Long id);
    public Player getPlayer(Long id);
    public void deletePlayer(Long id);
}
