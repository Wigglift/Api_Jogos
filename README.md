# Projeto Api de Jogos

Esse projeto foi desenvolvido para a matéria de Desenvolvimento de Serviços Web e Testes com Java
no 2 semestre de 2025

## Teste da api
Para o teste dessa api foi criado um Workspace no Postman que pode ser acessado pelo seguinte link:
>[Link do Workspace](https://www.postman.com/isaacrodrigues-1576462/dr3-tp3)

## Observações
Para rodar o endpoint de descrição é necessário rodar também o seguinte projeto:
>[Link do projeto](https://github.com/Wigglift/Api_Jogos_Auxiliar.git)

Feito com o apoio da api liberada pelo MMObomb
>[Link da api usada](https://www.mmobomb.com/api)

## Endpoints

### /descricao/{JogoNome}
Retorna a descrição completa do jogo para html de acordo com o nome passado, caso ache o jogo retornará um status 200
>/descricao/Tibia
```
{
    "title": "Tibia",
    "description": "<p style=\"text-align: justify;\"><strong>Tibia</strong> is a classic 2D medieval MMORPG created by CipSoft. Tibia can now be played in the browser, it is one of the oldest MMORPGs (released in January 1997) and was considered most noteworthy in its early years. For more than 10 years now, players have been visiting the world of Tibia. At present, more than 250,000 players from all over the  world inhabit the Tibian continent enjoying the numerous game features.</p>\r\n<p style=\"text-align: justify;\">It is a free to play game which is open to the public, though players  have the option to pay a fee in order to upgrade to a premium account,  granting special in-game benefits, including additional areas to  explore, access to vocation promotions, and extra spells.</p>\r\n<p style=\"text-align: justify;\">Gameplay  involves advancing levels while training to improve skill levels,  hunting monsters using weapons and magical spells, gathering treasure,  doing quests and exploring the Tibia world. Players interact with each  other in character for conversation, trade and group battles and partake  in guilds for more role-playing opportunities.</p>\r\n<p style=\"text-align: justify;\">On most of the game's  servers, players are also allowed to attack and kill each other,  although there is a system in place to keep hostile actions under  control called the skull system. Some servers do not allow such player  versus player combat at all, while others encourage it by rewarding  experience for kills.</p>"
}
```
Caso haja algum erro de digitação e não foi possível encontrar o jogo o status será 404
>/descricao/Tibi
```
{
    "mensagem": "[404] during [GET] to [http://localhost:8081/api/descricao/jogo/$Tibi] [FeighClientIsaacApiJogos#obterDescricao(String)]: []",
    "dataHora": "2025-10-05T14:24:30.5487156",
    "status": 404
}
```

### /obterJogos
Retorna uma lista com os jogos regitrados com o status http 200

```
  {
        "id": 1,
        "nome": "Warhammer 40k",
        "preco": 199.99,
        "clasificacaoIndicativa": 18,
        "acessoAntecipado": false,
        "genero": "ACAO"
    },
    {
        "id": 2,
        "nome": "Deep Rock Galatic",
        "preco": 57.99,
        "clasificacaoIndicativa": 14,
        "acessoAntecipado": false,
        "genero": "AVENTURA"
    },
    {
        "id": 3,
        "nome": "Path Of Exile 2",
        "preco": 79.8,
        "clasificacaoIndicativa": 16,
        "acessoAntecipado": true,
        "genero": "RPG"
    }
```


### /obterPorId/{id}
Retorna um jogo com o id passado pelo caminho

Com o ID existente no banco retorna um status http 200
>/obterPorId/{1}

```
  {
        "id": 1,
        "nome": "Warhammer 40k",
        "preco": 199.99,
        "clasificacaoIndicativa": 18,
        "acessoAntecipado": false,
        "genero": "ACAO"
    }
```


Com o ID inexistente no banco retorna um status http 404 com as informações de mensagem, quando ocorreu e o status
>/obterPorId/{4}

```
{
    "mensagem": "Jogo não encontrado",
    "dataHora": "2025-09-30T15:30:30.5843045",
    "status": 404
}
```


### /incluir
Inclui um jogo através de um objeto JSON passado pelo body e devolve um 201 com o jogo incluido com o id

>Enviando pelo body

```
 {
        "nome": "graveyard keeper",
        "preco": 11.99,
        "clasificacaoIndicativa": 10,
        "acessoAntecipado": false,
        "genero": "RPG"
    }
```


>Retorno da aplicação com o status 200

```
{
    "id": 4,
    "nome": "graveyard keeper",
    "preco": 11.99,
    "clasificacaoIndicativa": 10,
    "acessoAntecipado": false,
    "genero": "RPG"
}
```
**Possiveis erros iram devolver um status 400**
>Nome nulo
```
{
    "mensagem": "Titulo do jogo é nulo",
    "dataHora": "2025-09-30T15:39:40.8968018",
    "status": 400
}
```
>Nome vazio
```
{
    "mensagem": "Titulo do jogo não foi preenchido",
    "dataHora": "2025-09-30T15:44:38.0750863",
    "status": 400
}
```
>Preço menor que 0
```
{
    "mensagem": "Preço do jogo é menor que 0",
    "dataHora": "2025-09-30T15:44:57.1925398",
    "status": 400
}
```
>Classificação indicativa fora do range
```
{
    "mensagem": "A classificação indicativa do jogo não está no range definido",
    "dataHora": "2025-09-30T15:45:25.9937155",
    "status": 400
}
```
>Genero nulo
```
{
    "mensagem": "A classificação indicativa do jogo não está no range definido",
    "dataHora": "2025-09-30T15:46:38.3495328",
    "status": 400
}
```

### /excluir
Exclui um jogo do banco através do caminho e retorna um http status 204
>/excluir/2
-retorno de body vazio

**Caso o jogo não esteja no banco retorna um status 404**
>/excluir/5
```
{
    "mensagem": "Jogo não encontrado",
    "dataHora": "2025-09-30T15:31:45.5912228",
    "status": 404
}
```

### /alterar
Altera um jogo que está no banco com o ID passado através do caminho e novo jogo através do body, se for uma alteração bem sucedida devolve um status 200
>/alterar/3
```
{
        "nome": "PoE",
        "preco": 29,
        "clasificacaoIndicativa": 18,
        "acessoAntecipado": false,
        "genero" : "ACAO"
    }
```
**Os possíveis erros são os mesmos da inclusão, porém com a adição de erro caso o jogo não exista no banco
>/alterar/5
```
{
    "mensagem": "Jogo não encontrado",
    "dataHora": "2025-09-30T15:56:46.63256",
    "status": 404
}
```




