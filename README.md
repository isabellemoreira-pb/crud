# CRUD de Clientes com Spring Boot

## Descrição

Este projeto consiste em uma API REST desenvolvida em Spring Boot para gerenciamento de clientes e avaliação de elegibilidade.

O objetivo é reproduzir, de forma simplificada e didática, o comportamento de um sistema já existente na empresa, permitindo o aprendizado prático de conceitos como integração via API, persistência de dados em banco relacional e implementação de regras de negócio.

O sistema foi inspirado em um projeto real da empresa (Merchant/Micro Merchant) e possibilita o cadastro e manutenção de clientes Pessoa Física (PF) e Pessoa Jurídica (PJ), além da análise de elegibilidade para participação em um programa específico.

---

## Objetivo do Projeto

O projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento backend utilizando Spring Boot, incluindo:

- Desenvolvimento de APIs REST
- Persistência de dados com JPA
- Integração com PostgreSQL
- Validações com Spring Validation
- Tratamento de exceções
- Documentação com Swagger/OpenAPI
- Implementação de regras de negócio
- Arquitetura em camadas

---

## Funcionalidades

### Cadastro de Clientes

- Criar cliente
- Consultar todos os clientes
- Consultar cliente por ID
- Consultar cliente por CPF/CNPJ
- Atualizar cliente
- Excluir cliente

---

## Arquitetura

A aplicação segue a arquitetura em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Banco de Dados
```

### Controller

Responsável por receber e responder requisições HTTP.

### Service

Responsável pelas regras de negócio.

### Repository

Responsável pelo acesso ao banco de dados.

### Entidades auxiliares

#### Entity

Representa os dados persistidos no banco de dados.

#### DTO


### Avaliação de Elegibilidade

A API possui um endpoint dedicado para análise de elegibilidade.

A partir de um CPF ou CNPJ previamente cadastrado, o sistema avalia as regras de negócio e informa se o cliente está apto ou não para participar do programa.

---

## Dados Recebidos pela API

Cada cliente possui as seguintes informações:

| Campo | Descrição |
|---------|---------|
| Document | CPF ou CNPJ |
| Indication Document Type | PF ou PJ |
| Customer Company Flag | Indica se o CPF possui vínculo com pessoa jurídica (ex.: MEI) |
| MCC | Merchant Category Code |
| Annual TPV | Volume anual de transações |

---

## Persistência

Os dados são armazenados em banco de dados relacional utilizando PostgreSQL.

### Campos não alteráveis após o cadastro

- Documento (CPF/CNPJ)
- Tipo de documento (PF/PJ)

### Campos permitidos para atualização

- MCC
- Annual TPV
- Customer Company Flag

---

## Operações CRUD

### Create

Cadastro de novos clientes.

### Read

Consulta de clientes por ID, CPF/CNPJ ou listagem geral.

### Update

Atualização dos campos permitidos:

- MCC
- Annual TPV
- Customer Company Flag

### Delete

Exclusão de clientes por identificador interno.

---

## Documentação

- Swagger/OpenAPI integrado

---

## Tecnologias Utilizadas

- Java 21
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Docker
- Gradle
- Swagger / OpenAPI

---

## Estrutura do Projeto

```text
src/main/java/com/isabelle/crud

├── controller
├── dto
├── eligibility
├── entity
├── exception
├── repository
├── service
└── CrudApplication
```

---

## Banco de Dados

O projeto utiliza PostgreSQL.

Exemplo de configuração:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/cruddb
spring.datasource.username=admin
spring.datasource.password=admin123

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Ajuste os valores conforme seu ambiente.

---

## Executando o Projeto

### 1. Iniciar o PostgreSQL

Caso esteja utilizando Docker:

```bash
docker start postgres-crud
```

### 2. Clonar o projeto

```bash
git clone <url-do-repositorio>
```

### 3. Abrir no IntelliJ IDEA

Importar o projeto Gradle.

### 4. Executar a aplicação

Executar a classe:

```java
CrudApplication
```

A aplicação será iniciada na porta:

```text
http://localhost:8080
```

---

## Swagger

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui/index.html
```

---

## Endpoints

### Clientes

| Método | Endpoint | Descrição |
|----------|----------|----------|
| POST | /customers | Criar cliente |
| GET | /customers | Listar clientes |
| GET | /customers/{id} | Buscar cliente por ID |
| GET | /customers/document/{document} | Buscar cliente por CPF/CNPJ |
| PUT | /customers/{id} | Atualizar cliente |
| DELETE | /customers/{id} | Excluir cliente |

### Elegibilidade

O endpoint recebe um CPF ou CNPJ previamente cadastrado e aplica as regras de negócio para determinar se o cliente é elegível ao programa.

| Método | Endpoint | Descrição |
|----------|----------|----------|
| GET | /eligibility/{document} | Consultar elegibilidade |

---

## Regras de Elegibilidade

Um cliente é considerado elegível quando:

- O tipo de documento é PF
- Não possui vínculo empresarial
- Possui MCC permitido
- Possui TPV anual menor ou igual a 30.000

Caso qualquer uma das regras não seja atendida, o cliente será considerado não elegível.

---

## Autor

Projeto desenvolvido por Isabelle Moreira Maciel como parte do processo de aprendizado e capacitação em desenvolvimento backend com Spring Boot.
