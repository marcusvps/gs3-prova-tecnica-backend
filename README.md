# Execução do projeto

1. Ao baixar o projeto execute `mvn clean install` para realizar o download das  do projeto.
2. Para realizar o start da aplicação, execute o comando `mvn spring-boot:run`

> *A porta padrão do projeto é 8080, sendo o endereço completo: `http://localhost:8080`*


----
# Collection Postman
Estou deixando aqui a collection do postman com o intuito de realizar os testes da api:

[Acessar Collection](https://github.com/marcusvps/gs3-prova-tecnica-backend/blob/main/GS3%20-%20PROVA%20TÉCNICA%20-%20API.postman_collection.json "Acessar Collection")
[Download Arquivo Collection](https://files.fm/u/nttkus7n2 "ownload Arquivo Collection")

----
# Banco de Dados H2
A aplicação utiliza o H2Database, sendo um banco de dados em memória, cujo link para acesso a console é:

http://localhost:8080/h2-console

Dados de acesso:

```json
driver class: org.h2.Driver
jbcb url: jdbc:h2:mem:gs3ProvaTecnica
user: admin
pass: 123456
```

