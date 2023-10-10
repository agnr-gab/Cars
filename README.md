# Projeto SpringBoot - CRUD de Carros

## Descrição do Projeto
Este projeto é uma aplicação SpringBoot que fornece endpoints REST para realizar operações CRUD (Create, Read, Update, Delete) em entidades relacionadas: Carros, Marcas e Modelos. A aplicação também oferece um endpoint para listar modelos em um formato específico para consumo pelo frontend.

## Modelo de Dados

### Marca
- `id`: Identificador único da marca.
- `nome_marca`: Nome da marca.

### Carro
- `id`: Identificador único do carro.
- `timestamp_cadastro`: Data e hora de cadastro do carro.
- `modelo_id`: Identificador do modelo associado.
- `ano`: Ano de fabricação do carro.
- `combustivel`: Tipo de combustível do carro.
- `num_portas`: Número de portas do carro.
- `cor`: Cor do carro.

### Modelo
- `id`: Identificador único do modelo.
- `marca_id`: Identificador da marca associada.
- `nome`: Nome do modelo.
- `valor_fipe`: Valor Fipe do modelo.

## Endpoints

### Listagem de Modelos
- **URL**: `/modelos`
- **Descrição**: Retorna uma lista de modelos em um formato específico para consumo pelo frontend.
- **Método HTTP**: GET
- **Formato de Resposta**:
  ```
  [
    {
      "id": 1,
      "marca": "Ford",
      "nome": "Mustang",
      "valor_fipe": 100000.0
    },
    {
      "id": 2,
      "marca": "Chevrolet",
      "nome": "Cruze",
      "valor_fipe": 80000.0
    },
    ...
  ]
  ```

### CRUD de Carros
- **URL**: `/carros`
- **Descrição**: Permite criar, listar, atualizar e excluir carros.
- **Métodos HTTP**:
    - POST: Cria um novo carro.
    - GET: Lista todos os carros.
- **Formato de Resposta (Listar Carros)**:
  ```
  [
    {
      "id": 1,
      "timestamp_cadastro": "2023-10-10T12:00:00",
      "modelo_id": 1,
      "ano": 2022,
      "combustivel": "Gasolina",
      "num_portas": 4,
      "cor": "Azul"
    },
    {
      "id": 2,
      "timestamp_cadastro": "2023-10-11T14:30:00",
      "modelo_id": 2,
      "ano": 2021,
      "combustivel": "Etanol",
      "num_portas": 2,
      "cor": "Vermelho"
    },
    ...
  ]
  ```

### CRUD de Marcas
- **URL**: `/marcas`
- **Descrição**: Permite criar, listar, atualizar e excluir marcas.
- **Métodos HTTP**:
    - POST: Cria uma nova marca.
    - GET: Lista todas as marcas.

### CRUD de Modelos
- **URL**: `/modelos`
- **Descrição**: Permite criar, listar, atualizar e excluir modelos.
- **Métodos HTTP**:
    - POST: Cria um novo modelo.
    - GET: Lista todos os modelos.

## Estrutura de Código e Organização
- O código está organizado de acordo com as melhores práticas do SpringBoot, seguindo o padrão MVC (Model-View-Controller).
- As entidades (Marca, Carro e Modelo) são representadas como classes Java anotadas com JPA para mapeamento de banco de dados.
- Os endpoints REST são definidos em classes de controladores.
- Para acesso a banco de dados, é utilizado o Spring Data JPA para facilitar a persistência e recuperação de dados.
- As operações de CRUD seguem os princípios RESTful, utilizando os métodos HTTP apropriados.
- O formato das respostas segue os padrões JSON.

## Decisões
- Utilizamos o SpringBoot devido à sua facilidade de configuração e desenvolvimento rápido de aplicativos Java.
- O uso do Spring Data JPA simplifica a interação com o banco de dados e reduz a quantidade de código boilerplate.
- Os endpoints foram projetados para seguir as melhores práticas RESTful e fornecer uma API intuitiva e fácil de usar para o frontend.
- O formato de resposta da listagem de modelos foi definido de acordo com os requisitos do frontend.
- A estrutura do projeto segue os padrões de organização recomendados pelo SpringBoot.

## Executando o Projeto
1. Clone o repositório.
2. Configure o banco de dados no arquivo `application.properties`.
3. Execute o aplicativo SpringBoot.
4. Acesse os endpoints conforme descrito acima.

Este README fornece uma visão geral do projeto e de suas principais funcionalidades. Para detalhes de implementação e configuração, consulte o código-fonte e a documentação do SpringBoot.
