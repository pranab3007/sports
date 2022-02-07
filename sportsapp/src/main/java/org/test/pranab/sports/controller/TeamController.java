package org.test.pranab.sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.test.pranab.sports.dto.TeamDto;
import org.test.pranab.sports.entity.Team;
import org.test.pranab.sports.reponse.Response;
import org.test.pranab.sports.service.TeamService;

@RestController
@RequestMapping(path = "/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<Response> createTeam(@RequestBody TeamDto teamDto) {
        Team team = teamService.createTeam(teamDto);
        return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(), "Team Created",team),HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Response> updateTeam(@RequestBody TeamDto teamDto,@PathVariable Long id) {
        Team team = teamService.updateTeam(teamDto,id);
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Team Created",team),HttpStatus.OK);

    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response> getTeam(@PathVariable Long id) {
        Team team = teamService.getTeam(id);
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Team details fetched",team),HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Response> deleteTeam(@PathVariable Long id) {
        teamService.deleteteam(id);
        return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Team deleted successfully", null),
                HttpStatus.OK);

    }
}
