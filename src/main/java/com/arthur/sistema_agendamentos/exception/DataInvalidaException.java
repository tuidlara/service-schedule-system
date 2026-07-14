package com.arthur.sistema_agendamentos.exception;

public class DataInvalidaException extends RuntimeException{
    public DataInvalidaException() {
        super("Essa data não está mais disponível");
    }
}
