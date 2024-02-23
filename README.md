# SpringBoot-Strategies
Projeto de Spring Boot criado em pós graduação!

*** Projeto na branch MASTER ***
 
Objetivo:
- Praticar diversos conceitos do Spring Boot e explorar suas utilizadades.

Desenvolvido:
- API REST com notações do SpringBoot para um objeto de Estudantes.
- Classes de excessões.
- Upload e Download de arquivos.
- Conexão com banco de dados MySQL usando Spring Data JPA .

Dependências:
- Versão Java 11 -> pom.xml ->	<java.version>11</java.version>
- Lombok: responsável por gerar os códigos boilerplate para nós, como Getter e Setters.
- Spring Web: principal dependência para podermos desenvolver nossa aplicação. É composta por outras dependências, entre elas Spring MVC, REST e Tomcat como servidor padrão embutido. Ela já possui todas as configurações necessárias para que possamos rodar e testar nossa aplicação localmente, assim como nossa camada Controller.
- Spring Boot Dev Tools: Permite fazer alterações em nossa aplicação e testar logo em seguida sem precisar parar e rodar a aplicação novamente. Ou seja, ela detecta alterações no código e reinicializa a aplicação automaticamente.
- Spring Data JPA: Simplifica a implementação de repositórios baseados em JPA. Ele oferece funcionalidades para interagir facilmente com bancos de dados usando a API de Persistência Java (JPA)
- MySQL Driver: Para conexão da aplicação ao banco de dados MYSQL.

==============================================================

Spring Boot project created in the postgraduate course!

*** Project in the MASTER branch ***

Objective:
- Practice various Spring Boot concepts and explore their utilities.

Developed:
- REST API with Spring Boot annotations for a Student object.
- Exception classes.
- File upload and download.
- Connecting to MySQL database using Spring Data JPA.

Dependencies:
- Java version: 11 ->	pom.xml ->	<java.version>11</java.version>
- Lombok: responsible for generating boilerplate code for us, such as Getters and Setters.
- Spring Web: the main dependency for developing our application. It is composed of other dependencies, including Spring MVC, REST, and Tomcat as the default embedded server. It already has all the necessary configurations for us to run and test our application locally, as well as our Controller layer.
- Spring Boot Dev Tools: Allows making changes to our application and testing them immediately without needing to stop and rerun the application. In other words, it detects changes in the code and automatically restarts the application.
- Spring Data JPA: simplifies the implementation of repositories based on JPA. It offers functionalities to easily interact with databases using the Java Persistence API (JPA).
- MySQL Driver: For connecting the application to the MYSQL database.
