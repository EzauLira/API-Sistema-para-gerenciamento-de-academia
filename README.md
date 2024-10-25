# SGA - Sistema para Gerênciamento de Academia 🏋️‍♀️

Sistema para Gerêncimanto de Academia: Projeto Acadêmico Desenvolvido em **Java** com **Spring Boot**, **Spring Security**, **JWT**, **JDBCTemplate**, **PostgreSQL**, **Postman** e **Swagger** para a Disciplina de Desenvolvimento de Sistemas da *[Foursys](https://br.linkedin.com/company/foursys)*.

## Descrição 📋
O projeto ***Sistema para Gerêncimanto de Academia*** é um sistema de gerenciamento que permite aos usuários cadastrar, consultar, atualizar e excluir seus treinos.

## Créditos


✍ Projeto proposto pela ***Fourcamp - *[Foursys](https://br.linkedin.com/company/foursys)***, disciplinado e orientado pelos mestres: *[Bruno Martin](https://www.linkedin.com/in/brunoermacora/)* e *[Denilson Elias](https://www.linkedin.com/in/denilsonbitit/)*

## Equipe de desenvolvimento 👨‍💻
- Desenvolvedor - *[Ezaú Lira](https://www.linkedin.com/in/ezaulira/)*


## Tecnologias usadas 💻

- **JAVA**: linguagem de programação principal.


- **SPRING-BOOT**: Framework para desenvolvimento de aplicações Java.


- **POSTGRESQL**: Banco de dados relacional.


- **MAVEN**: Ferramenta principal utilizada para gerenciar essas aplicações em Java.


- **POSTMAN**: Ferramenta para testar e manipular os endpoints da API.


- **SWAGGER**: Documentação interativa dos endpoints.


- **INTELLIJ**: Ambiente de desenvolvimento.


<a href="https://www.oracle.com/java/technologies/downloads/#jdk22-windows"><img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original-wordmark.svg" width="50" height="50" /></a>
<a href="https://spring.io/projects/spring-boot"><img src="https://github.com/user-attachments/assets/2b843542-1437-44f2-b2f2-f33bae03b342" width="50" height="50" /></a>
<a href="https://www.postgresql.org/download/"><img src="https://github.com/user-attachments/assets/92f810dd-7297-4a86-b25f-3905fd976892" width="45" height="45" /></a>
<a href="https://maven.apache.org/download.cgi"><img src="https://github.com/user-attachments/assets/20c281e0-7784-46c2-b9c3-827979aa3391" width="45" height="45" /></a>
<a href="https://www.postman.com/downloads/"><img src="https://github.com/user-attachments/assets/3ead52df-8744-47a6-b932-e50ef1f86400" width="75" height="50" /></a>
<a href="https://swagger.io/tools/swagger-ui/"><img src="https://github.com/user-attachments/assets/d1358131-cdcc-4812-a72d-27426ef48bc6" width="120" height="50" /></a>
<a href="https://www.jetbrains.com/idea/download/"><img src="https://github.com/user-attachments/assets/7949db83-7fcb-4611-ba0e-ec37a4af28e3" width="40" height="40" /></a>



## Configurações de Banco de Dados 🗄️
O sistema está configurado para usar um banco de dados PostgreSQL. As configurações de conexão estão no arquivo `application.yaml`:

```properties
spring:
application:
name: Sistema para gerenciamento de academia

springdoc:
api-docs:
path: /v1/api-docs
swagger-ui:
path: /swagger-ui.html

datasource:
driverClassName: org.postgresql.Driver
url: jdbc:postgresql://localhost:5432/seu_banco_aqui?ApplicationName=SistemaParaGerenciamentoDeAcademia
username: seu_login
password: sua_senha

hikari:
maximumPoolSize: 3
minimumIdle: 2
idleTimeout: 20000
poolName: SistemaParaGerenciamentoDeAcademia

````
## Configuração do Swagger ⚙️
O Swagger está configurado para documentar e testar as APIs do sistema. A documentação do Swagger pode ser acessada em: *[Link do swagger.](http://localhost:27031/swagger-ui.html)*

## Como Executar o Projeto 🛠
1. Clone o repositório:
    - git clone *[repositório](https://github.com/EzauLira/Sistema-para-gerenciamento-de-academia2.git)*


2. Configure o banco de dados PostgreSQL e atualize as credenciais no ***application.properties.***


3. Execute o projeto usando Maven:
    - localizado na SgaApplication.
   <div align="">
   <img src="https://github.com/user-attachments/assets/b74a8277-febe-4249-a2be-e428e5fc8946" height="400" />
   </div>

## Scrip da base de dados, functions e postman ⚙️

- Link: *[Repositório base de dados](https://github.com/EzauLira/Sistema-para-academia-sql-postman.git)*

- **Observção**: Realizar a execução do script da base de dados primeiro, e logo apos realizar a execução dos scripts das functions
