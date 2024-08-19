# PicPay Simplificado CRUD
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white) ![Jira](https://img.shields.io/badge/jira-%230A0FFF.svg?style=for-the-badge&logo=jira&logoColor=white)

Este projeto é uma API construída utilizando Java, Spring Boot, e H2 como banco de dados.
A API foi desenvolvida para simular funcionalidades básicas de uma aplicação semelhante ao PicPay, permitindo o gerenciamento de usuários e transações entre eles.
Apenas usuarios do tipo _COMMUN_ podem realizar transçãoes entre si, usuarios do tipo _MERCHANT_ só podem receber transações

## Índice
- [Instalação](#instalação)
- [Configuração](#configuração)
- [Uso](#uso)
- [Endpoints da API](#endpoints-da-api)
- [Banco de Dados](#banco-de-dados)
- [Tratamento de Exceções](#tratamento-de-exceções)
- [Contribuindo](#contribuindo)

  
## Instalação

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/picpay-simplificado-crud.git
   ```
2. Instale as dependências com o Maven:
   ```bash
   mvn install
   ```

## Configuração

1. Configure o banco de dados H2 no arquivo `application.properties`:
   ```properties
   spring.application.name=picpaysimplificado
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driver-class-name=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   spring.h2.console.enabled=true
   ```

2. Se necessário, ajuste outras configurações como a porta do servidor no mesmo arquivo.

## Uso

1. Inicie a aplicação com o Maven:
2. A API estará acessível em `http://localhost:8080`.

## Endpoints da API

A API fornece os seguintes endpoints:

### **GET /users**

Recupera uma lista de todos os usuários.
```json
[
    {
        "id": 1,
        "firstName": "Robert",
        "lastName": "Peterson",
        "document": "123456787",
        "email": "robert@example.com",
        "password": "senha",
        "balance": 20.00,
        "userType": "MERCHANT"
    },
    {
        "id": 4,
        "firstName": "Simon",
        "lastName": "Soares",
        "document": "123456783",
        "email": "simon@example.com",
        "password": "senha",
        "balance": 0.00,
        "userType": "COMMON"
    }
]
```

### **POST /users**

Registra um novo usuário no aplicativo.
```json
{
    "firstName": "Lucas",
    "lastName": "Silva",
    "password": "senha",
    "document": "123456783",
    "email": "lucas@example.com",
    "userType": "COMMON",
    "balance": 10
}
```

### **POST /transactions**

Registra uma nova transação entre usuários (COMMON para COMMON ou COMMON para MERCHANT).
```json
{
  "senderId": 4,
  "receiverId": 1,
  "value": 10
}
```

## Banco de Dados

O projeto utiliza o banco de dados em memoria H2. Certifique-se de que o banco de dados esteja configurado corretamente antes de iniciar a aplicação.

## Tratamento de Exceções

Nos arquivos é possivel encontrar o 'ControllerExceptionHandler' e nele tratamos as exceções de usuario ja castrado, usuario não encontrado e usurio do tipo merchant não esta permitido realizar transações. Exibindo diferentos Https status code para cada exceções.

## Contribuindo

Contribuições são bem-vindas! Se você tiver sugestões ou encontrar algum problema, sinta-se à vontade para abrir uma issue ou enviar um pull request.

---
