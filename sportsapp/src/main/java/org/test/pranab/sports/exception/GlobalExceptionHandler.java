package org.test.pranab.sports.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.test.pranab.sports.reponse.Response;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SportsappException.class)
    public ResponseEntity<Response> handleFundooException(SportsappException ex){
        Response response = new Response(ex.getStatusCode(), ex.getStatusMessage(), null);
        return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
    }
}
