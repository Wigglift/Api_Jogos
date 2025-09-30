package br.edu.infnet.isaacApi.auxiliares;

import br.edu.infnet.isaacApi.model.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JogoInexistenteException.class)
    public ResponseEntity<Object> handlerJogoInexistenteException(JogoInexistenteException e){
        Map<String , Object> body = new HashMap<String,Object>();

        body.put("dataHora", LocalDateTime.now());
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("mensagem", e.getMessage());


        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TituloNuloException.class)
    public ResponseEntity<Object> handlerTituloNuloException(TituloNuloException e){
        Map<String , Object> body = new HashMap<String,Object>();

        body.put("dataHora", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("mensagem", e.getMessage());


        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(TituloVazioException.class)
    public ResponseEntity<Object> handlerTItuloVazioException(TituloVazioException e){
        Map<String , Object> body = new HashMap<String,Object>();

        body.put("dataHora", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("mensagem", e.getMessage());


        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PrecoInvalidoException.class)
    public ResponseEntity<Object> handlerPrecoInvalidoException(PrecoInvalidoException e){
        Map<String , Object> body = new HashMap<String,Object>();

        body.put("dataHora", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("mensagem", e.getMessage());


        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GeneroInvalidoException.class)
    public ResponseEntity<Object> handlerGeneroInvalidoException(GeneroInvalidoException e){
        Map<String , Object> body = new HashMap<String,Object>();

        body.put("dataHora", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("mensagem", e.getMessage());


        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ClassificacaoIndicativaInvalidaException.class)
    public ResponseEntity<Object> handlerClassificacaoIndicativaInvalidaException(ClassificacaoIndicativaInvalidaException e){
        Map<String , Object> body = new HashMap<String,Object>();

        body.put("dataHora", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("mensagem", e.getMessage());


        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
