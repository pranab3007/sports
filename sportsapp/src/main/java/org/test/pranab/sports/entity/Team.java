package org.test.pranab.sports.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String teamName;

    @OneToMany(targetEntity = Player.class)
    @JoinColumn(name="team_id", referencedColumnName = "id")
    private List<Player> players;
}
