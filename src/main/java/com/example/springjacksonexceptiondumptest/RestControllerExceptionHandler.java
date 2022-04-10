package com.example.springjacksonexceptiondumptest;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({JsonMappingException.class, InvalidDefinitionException.class})
    public ResponseEntity<Object> handleJsonMappingException(JsonMappingException e, HttpServletRequest request) {
        Map requestMap = null;
        try {
            requestMap = new ObjectMapper().readValue(request.getInputStream(), Map.class);
            log.error("request={}", requestMap);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        log.error(e.getMessage(), e);
        return ResponseEntity.badRequest().build();
    }

}
