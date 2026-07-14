package com.arthur.sistema_agendamentos.exception;

public class PeriodoInvalidoException extends RuntimeException{
    public PeriodoInvalidoException() {
        super("O período informado é inválido");
    }
}
