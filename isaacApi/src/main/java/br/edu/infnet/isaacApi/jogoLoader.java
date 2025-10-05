package br.edu.infnet.isaacApi;

import br.edu.infnet.isaacApi.model.domain.Jogo;
import br.edu.infnet.isaacApi.model.enumerator.Genero;
import br.edu.infnet.isaacApi.model.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class jogoLoader implements ApplicationRunner {

    private final JogoService jogoService;

    public jogoLoader(JogoService jogoService){
        this.jogoService = jogoService;
    }

    @Override
    @Order(0)
    public void run(ApplicationArguments args){
        try{
            //Leitura do arquivo,txt
            FileReader file = new FileReader("Api_Jogos\\isaacApi\\arquivos\\Jogos.txt");
            BufferedReader reader = new BufferedReader(file);
            String linha = reader.readLine();

            //inicio do carregamento
            int linhasCarregadas = 0;
            System.out.println("⏱\uFE0F\u200BIniciando processso de inserção⏱\uFE0F\u200B");

            while (linha != null){

                //Separação da linha do arquivo para um array
                String[] linhaDividida = linha.split(";");


                //Criação do jogo através do arquivo
                String nome = linhaDividida[0];
                Double preco = Double.parseDouble(linhaDividida[1]);
                Integer classificacaoIndicativa = Integer.parseInt(linhaDividida[2]);
                Boolean acessoAntecipado = Boolean.parseBoolean(linhaDividida[3]);
                Genero genero = Genero.valueOf(linhaDividida[4]);

                //Inclusão do jogo no banco
                jogoService.incluir(new Jogo(nome,preco,classificacaoIndicativa,acessoAntecipado,genero));

                linhasCarregadas++;
                linha = reader.readLine();
            }
            System.out.println("✅\u200BProcesso de inserção terminado✅\u200B");
            System.out.println("\uD83D\uDD0E\u200BForam carregados "+linhasCarregadas+" jogos\uD83D\uDD0E\u200B");

            for(Jogo jogo : jogoService.obterLista()){
                System.out.println(jogo);
            }

            //Tratamento de possíveis excessões
        }catch (FileNotFoundException e){
            System.err.println("Arquivo não encontrado: " + e.getMessage());
        }catch (IOException e){
            System.err.println("Problemas na abertura/fechamento do arquivo: " + e.getMessage());
        }catch (NumberFormatException e){
            System.err.println("Problemas na conversão númerica dos dados do arquivo: " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.err.println("Problemas na conversão de dados recebidos do arquivo: " + e.getMessage());
        }catch (Exception e){
            System.err.println("Ocorreu problemas na adição dos dados no banco: " + e.getMessage());
        }


    }
}
