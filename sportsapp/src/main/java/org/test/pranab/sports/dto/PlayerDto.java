package org.test.pranab.sports.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PlayerDto {

    private String playerName;
    private LocalDateTime birthDate;
    private LocalDateTime teamJoiningDate;
}
