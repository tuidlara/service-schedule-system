package com.arthur.sistema_agendamentos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody

    public Map<String, String> tratarIllegalArgumentException(IllegalArgumentException e) {

        Map<String, String> erro = new HashMap<>();

        erro.put("erro", e.getMessage());
        return erro;

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, String> tratarMethodArgumentNotValid(MethodArgumentNotValidException e) {

        Map<String, String> erro = new HashMap<>();

        //// pega o primeiro erro de validação encontrado
        FieldError campoErro = e.getBindingResult().getFieldError();
        if (campoErro != null) {
            erro.put("erro", campoErro.getDefaultMessage());
        }

        return erro;
    }

    @ExceptionHandler(HorarioIndisponivelException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public Map<String, String> tratarHorarioIndisponivelException(HorarioIndisponivelException e){

        Map<String, String> erro = new HashMap<>();
        erro.put("erro", e.getMessage());
        return erro;
    }

}
