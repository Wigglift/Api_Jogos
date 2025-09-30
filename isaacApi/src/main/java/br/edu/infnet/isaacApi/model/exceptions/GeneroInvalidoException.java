package br.edu.infnet.isaacApi.model.exceptions;

import com.sun.jdi.InvalidTypeException;

public class GeneroInvalidoException extends RuntimeException {
    public GeneroInvalidoException() {
    }

    public GeneroInvalidoException(String s) {
        super(s);
    }
}
