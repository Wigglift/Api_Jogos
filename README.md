# Projeto Api de Jogos

Esse projeto foi desenvolvido para a matéria de Desenvolvimento de Serviços Web e Testes com Java
no 2 semestre de 2025

## Teste da api
Para o teste dessa api foi criado um Workspace no Postman que pode ser acessado pelo seguinte link:
>[Link do Workspace](https://www.postman.com/isaacrodrigues-1576462/dr3-tp3)

## Endpoints

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




