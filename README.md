# Trabalho Final - Sistema de Gestão Imobiliária - Backend

O sistema é dividido em 5 módulos distintos que serão implementados por cada um dos grupos definidos em sala:
* Grupo 1 - Imóveis
* Grupo 2 - Usuários
* Grupo 3 - Contrato
* Grupo 4 - Agendamento de Visitas
* Grupo 5 - Pagamento de Aluguel

## Tecnologias utilizadas

- Java 8+
- Maven 3.6.3+
- Spring Boot
  - [Spring Web](https://docs.spring.io/spring-framework/docs/current/reference/html/web.html#spring-web)
  - [Spring Data](https://docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#reference) com Hibernate
- Banco SQL em memória com [H2](https://www.h2database.com/html/main.html)

## Executando o Projeto

### Pela Linha de Comando (CMD/bash)

Antes de qualquer coisa é necessário instalar as bibliotecas que são utilizadas no projeto para que esse possa ser executado, como se trata de um projeto Maven basta executar o seguinte comando na raiz do repositório:

```
$ mvn clean install
```

Após feita a instalação das bibliotecas basta usar o comando específico do Spring para que o sistema seja inicializado:

```
$ mvn spring-boot:run
```

### Com uma IDE (Eclipse/IntelliJ IDEA)

A premissa é que a IDE cuide do passo de instalação das bibliotecas automáticamente, caso isso não aconteça você pode tentar seguir o passo de instalação manual acima ou abrir um tópico de dúvida no fórum da disciplina.
Para inicializar o sistema nas duas IDEs basta executar o método `main()` dentro da classe `br.ufg.inf.imobiaria.SigImobiliariaApplication`.

> Caso você deseje é possível configurar a integração da IDE com o Spring, se configurado corretamente a IDE te dá alguns benefícios, como a detecção automática da classe a ser executada e algumas informações sobre o sistema em  tempo de execução.

## Guias Interessantes
* [Introdução a Spring Data JPA](https://www.baeldung.com/the-persistence-layer-with-spring-data-jpa)
* [Introdução Spring Web bom Spring Boot](https://www.baeldung.com/spring-boot-start)
* [Série REST com Spring](https://www.baeldung.com/rest-with-spring-series)
* [Tutoriais oficiais H2](http://www.h2database.com/html/tutorial.html)
