package com.arthur.sistema_agendamentos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//elimina necessidade do @ResponseBody
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> tratarMethodArgumentNotValid(MethodArgumentNotValidException e) {

        //pega o primeiro erro de validação encontrado
        FieldError campoErro = e.getBindingResult().getFieldError();
        if (campoErro != null) {
            return criarErro(campoErro.getDefaultMessage());
        }
        return criarErro("Erro de validação.");
    }

    @ExceptionHandler({
            HorarioIndisponivelException.class,
            TipoServicoDuplicadoException.class,
            TipoServicoEmUsoException.class
    })
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> tratarConflitos(RuntimeException e) {
        return criarErro(e.getMessage());
    }

    @ExceptionHandler({
            TipoServicoNaoEncontradoException.class,
            AgendamentoNaoEncontradoException.class
    })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> tratarNotFound(RuntimeException e) {
        return criarErro(e.getMessage());

    }

    @ExceptionHandler({
            DataInvalidaException.class,
            HorarioFuncionamentoException.class,
            PeriodoInvalidoException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> tratarBadRequest(RuntimeException e) {
        return criarErro(e.getMessage());
    }

    private Map<String, String> criarErro(String mensagem) {
        Map<String, String> erro = new HashMap<>();
        erro.put("erro", mensagem);
        return erro;
    }

}
