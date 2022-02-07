package org.test.pranab.sports.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SportsappException extends RuntimeException{

    private static final long serialVersionUID = -2202404817330167264L;

    private int statusCode;

    private String statusMessage;
}
