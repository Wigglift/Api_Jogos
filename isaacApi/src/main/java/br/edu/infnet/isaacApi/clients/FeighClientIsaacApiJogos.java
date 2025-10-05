package br.edu.infnet.isaacApi.clients;

import br.edu.infnet.isaacApi.model.domain.JogoDescricao;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "feighClientIsaacApiJogos", url = "${IsaacApiJogos.url}")
public interface FeighClientIsaacApiJogos {

    @GetMapping("/api/descricao/jogo/${jogoNome}")
    JogoDescricao obterDescricao(@PathVariable String jogoNome);

}
