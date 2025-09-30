package br.edu.infnet.isaacApi.model.service;

import br.edu.infnet.isaacApi.model.domain.Jogo;
import br.edu.infnet.isaacApi.model.exceptions.*;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class JogoService {

    private static final Map<Integer, Jogo> jogos = new HashMap<Integer,Jogo>();
    private static final AtomicInteger id = new AtomicInteger(1);

    public Jogo incluir(Jogo jogo) {

        //testando se o título não é nulo
        if(jogo.getNome() == null) throw new TituloNuloException("Titulo do jogo é nulo");

        //testando se o jogo inserido tem o nome preenchido
        if(jogo.getNome().isBlank())throw new TituloVazioException("Titulo do jogo não foi preenchido");

        //testando se o jogo tem um preço válido
        if(jogo.getPreco() < 0)throw new PrecoInvalidoException("Preço do jogo é menor que 0");

        //testando se a classe indicativa é válida
        if(jogo.getClasificacaoIndicativa() < 0 || jogo.getClasificacaoIndicativa()>18)throw new ClassificacaoIndicativaInvalidaException("A classificação indicativa do jogo não está no range definido");

        //testando se o genero é válido
        if(jogo.getGenero() == null) throw new  GeneroInvalidoException("Genero do jogo é inválido");

        //
        jogo.setId(id.getAndIncrement());

        jogos.put(jogo.getId(),jogo);

        return jogo;
    }

    public List<Jogo> obterLista(){
        return new ArrayList<Jogo>(jogos.values());
    }


    public Optional<Jogo> obterPorId(Integer id){
        return Optional.of(jogos.get(id));
    }

    public Jogo alterar(Integer id, Jogo jogoAtualizado){

        //teste para saber se o jogo existe
        if(jogos.get(id) == null) throw new JogoInexistenteException("Jogo não encontrado");

        //testando se o título não é nulo
        if(jogoAtualizado.getNome() == null) throw new TituloNuloException("Titulo do jogo é nulo");

        //testando se o jogo inserido tem o nome preenchido
        if(jogoAtualizado.getNome().isBlank())throw new TituloVazioException("Titulo do jogo não foi preenchido");

        //testando se o jogo tem um preço válido
        if(jogoAtualizado.getPreco() < 0)throw new PrecoInvalidoException("Preço do jogo é menor que 0");

        //testando se a classe indicativa é válida
        if(jogoAtualizado.getClasificacaoIndicativa() < 0 || jogoAtualizado.getClasificacaoIndicativa()>18)throw new ClassificacaoIndicativaInvalidaException("A classificação indicativa do jogo não está no range definido");

        //testando se o genero é válido
        if(jogoAtualizado.getGenero() != null) throw new GeneroInvalidoException("Genero do jogo é inválido");

        //alteração do objeto
        jogoAtualizado.setId(id);

        jogos.replace(id, jogos.get(id), jogoAtualizado);

        return jogoAtualizado;
    }

    public Jogo Excluir(Integer id){

        if(!jogos.containsKey(id)) throw new JogoInexistenteException("Jogo não encontrado");

        return jogos.remove(id);
    }

}
