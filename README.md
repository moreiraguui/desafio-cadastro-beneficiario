<h1 align="center">
  Cadastro Beneficiario
</h1>

API para fazer o cadastro de um beneficiario com seus respectivos documentos.

## Tecnologias
 
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Banco H2 Console](https://www.h2database.com/html/main.html)

## Práticas adotadas

- API REST
- Consultas com Spring Data JPA
- Injeção de Dependências
  
## Como Executar

- Clonar repositório git
- Construir o projeto:
```
$ ./mvnw clean package
```
- Executar a aplicação:
```
$ java -jar target/cadastro-beneficiario-0.0.1-SNAPSHOT.jar
```
- Ou com sua IDE preferida, fazer o build manualmente.

A API poderá ser acessada em [localhost:8080](http://localhost:8080).

## API Endpoints

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [Postman](https://www.postman.com/):

- Cadastrar um beneficiário junto com seus documentos.
```
POST -> http://localhost:8080/beneficiarios

{ 
    "nome": "Guilherme Moreira",
    "telefone": "(11) 12345-6789",
    "dataNascimento": "01-01-0001",
    "documentos": [{
        "tipoDocumento": "RG",
        "descricao": "11111111-11"
    },
    {
        "tipoDocumento": "CPF",
        "descricao": "11111111.11-11"
    }]
}
```
- Listar todos os beneficiários cadastrados.
```
GET -> http://localhost:8080/beneficiarios/listar
```
- Listar todos os documentos de um beneficiário a partir de seu id.
```
GET -> http://localhost:8080/documentos/{idBeneficiario}
```
- Atualizar os dados cadastrais de um beneficiário.
```
PUT -> http://localhost:8080/beneficiarios/{idBeneficiario}

{
    "nome": "Guilherme Moreira",
    "telefone": "(99) 99999-9999",
    "dataNascimento": "02/02/0002",
    "documentos": [
        {
            "id": "eeed05a6-2615-4bee-af35-8ff2d17bc45a",
            "tipoDocumento": "RG",
            "descricao": "11111111-11"
        },
        {
            "id": "9997f5a6-e30c-48aa-acaa-d96e46942e96",
            "tipoDocumento": "Reservista",
            "descricao": "22222222222222222"
        }
    ]
}
```
- Remover um beneficiário.
```
DELETE -> http://localhost:8080/beneficiarios/{idBeneficiario}
```

