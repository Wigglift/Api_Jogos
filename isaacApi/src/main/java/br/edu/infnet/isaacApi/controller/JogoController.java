package br.edu.infnet.isaacApi.controller;

import br.edu.infnet.isaacApi.clients.FeighClientIsaacApiJogos;
import br.edu.infnet.isaacApi.model.domain.Jogo;
import br.edu.infnet.isaacApi.model.domain.JogoDescricao;
import br.edu.infnet.isaacApi.model.exceptions.JogoInexistenteException;
import br.edu.infnet.isaacApi.model.service.JogoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    private final JogoService jogoService;


    public JogoController(FeighClientIsaacApiJogos feighClientIsaacApiJogos){
        jogoService = new JogoService(feighClientIsaacApiJogos);
    }

    @GetMapping("/{jogoNome}")
    public ResponseEntity<JogoDescricao> obterDescricao(@PathVariable String jogoNome){

        JogoDescricao jogo = jogoService.obterDescricao(jogoNome);

        return new ResponseEntity<JogoDescricao>(jogo,HttpStatus.OK);

    }

    @GetMapping("/obterJogos")
    public ResponseEntity<List<Jogo>> obterLista(){
        List<Jogo> jogos = jogoService.obterLista();

        return new ResponseEntity<List<Jogo>>(jogos, HttpStatus.OK);
    }

    @GetMapping("/obterJogo/{id}")
    public ResponseEntity<Jogo> obterPorId(@PathVariable Integer id){
        Jogo jogo = jogoService.obterPorId(id).orElseThrow(() -> new JogoInexistenteException("Jogo não encontrado"));;

        return new ResponseEntity<Jogo>(jogo,HttpStatus.OK);
    }

    @PostMapping("/incluir")
    public ResponseEntity<Jogo> incluir(@RequestBody Jogo jogo){
        Jogo jogoIncluido = jogoService.incluir(jogo);

        return new ResponseEntity<Jogo>(jogoIncluido,HttpStatus.CREATED);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        jogoService.Excluir(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<Jogo> alterar(@PathVariable Integer id,@RequestBody Jogo jogo){
        Jogo jogoAlterado = jogoService.alterar(id,jogo);

        return new ResponseEntity<Jogo>(jogoAlterado,HttpStatus.OK);
    }

}
