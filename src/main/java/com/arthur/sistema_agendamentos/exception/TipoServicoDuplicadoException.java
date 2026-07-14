package com.arthur.sistema_agendamentos.exception;

public class TipoServicoDuplicadoException extends RuntimeException{
    public TipoServicoDuplicadoException(){
        super("Já existe um tipo de serviço com esse nome");
    }
}
