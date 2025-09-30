package br.edu.infnet.isaacApi.model.exceptions;

public class JogoInexistenteException extends RuntimeException{
    public JogoInexistenteException() {
    }

    public JogoInexistenteException(String s) {
        super(s);
    }
}
