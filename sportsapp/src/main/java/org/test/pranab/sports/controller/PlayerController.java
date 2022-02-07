package org.test.pranab.sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.pranab.sports.dto.PlayerDto;
import org.test.pranab.sports.entity.Player;
import org.test.pranab.sports.reponse.Response;
import org.test.pranab.sports.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired
    private PlayerService playerService;


    @PostMapping
    public ResponseEntity<Response> createPlayer(@RequestBody PlayerDto playerDto,@RequestParam Long teamId) {
        Player player = playerService.createPlayer(playerDto,teamId);
        return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(), "Player created",player),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response>  updatePlayer(@RequestBody PlayerDto playerDto,@PathVariable Long id) {
        Player player  = playerService.updatePlayer(playerDto,id);
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Player updated",player),HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response>  getPlayer(@PathVariable Long id) {
        Player player = playerService.getPlayer(id);
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Player details fetched",player),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response> deletePlayer(Long id) {
        playerService.deletePlayer(id);
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Player deleted",null),HttpStatus.OK);
    }

}
