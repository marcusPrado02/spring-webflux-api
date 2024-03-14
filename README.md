# API desenvolvida no curso da Digital Innovation One - Spring WebFlux

Este é um projeto demonstrativo desenvolvido durante uma sessão de live coding da Digital Innovation One, focada em Spring WebFlux. Ele utiliza uma série de tecnologias para construir uma API de heróis, proporcionando uma experiência prática e interativa para os participantes.

## Stack Utilizada

- **Java 8**: A linguagem de programação base para o desenvolvimento.
- **Spring WebFlux**: Um módulo do Spring Framework para criar aplicativos reativos da web.
- **Spring Data**: Facilita a integração com sistemas de armazenamento de dados, neste caso, utilizado com DynamoDB.
- **DynamoDB**: Um serviço de banco de dados NoSQL totalmente gerenciado pela AWS.
- **JUnit**: Um framework para escrever e executar testes automatizados em Java.
- **slf4j**: Uma API de logging para Java.
- **Reactor**: Uma biblioteca reativa para programação reativa no Java.

## Recursos Adicionais

- **Slides da Palestra**: [Slides da sessão de live coding](https://speakerdeck.com/kamilahsantos/live-coding-dio-api-de-herois-com-spring-webflux).
- **Palestra Gravada**: [Link para a gravação da palestra](https://www.youtube.com/live/1VllPZYn6RI?feature=share&t=145).

## Configuração do AWS DynamoDB

Para executar o DynamoDB localmente, você pode usar o Docker:

```bash
docker run -p 8000:8000 --name dynamodb amazon/dynamodb-local -jar DynamoDBLocal.jar -inMemory -sharedDb
```

Para listar as tabelas criadas:

```bash
aws dynamodb list-tables --endpoint-url http://localhost:8000
```

Para listar os conteúdos da tabela:

```bash
aws dynamodb scan --table-name Heroes_Table --endpoint-url http://localhost:8000
```

## Documentação da API

A documentação gerada pela aplicação pode ser acessada em:

[http://localhost:8080/swagger](http://localhost:8080/swagger)

## Execução do Projeto

Para executar o projeto, siga estas etapas:

1. Certifique-se de ter o Java 8 instalado em sua máquina.
2. Execute o comando para executar o DynamoDB localmente.
3. Clone este repositório.
4. Importe o projeto em sua IDE preferida.
5. Execute a classe principal ou utilize o Maven para construir e executar o projeto.
6. Acesse a documentação da API fornecida no link acima para explorar os endpoints disponíveis.

## Contribuições

Contribuições para este projeto são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request com suas sugestões, melhorias ou correções.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE).
