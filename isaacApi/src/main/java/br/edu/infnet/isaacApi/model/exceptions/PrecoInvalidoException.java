package br.edu.infnet.isaacApi.model.exceptions;

public class PrecoInvalidoException extends RuntimeException{
    public PrecoInvalidoException() {
    }

    public PrecoInvalidoException(String s) {
        super(s);
    }
}
