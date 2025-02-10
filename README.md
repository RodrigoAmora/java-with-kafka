# java-with-kafka
Descrição:
----------
Projeto de uma API usando Java com Kafka.

Endpoints:
----------
A documentação dos endpoints pode ser vista através do Swagger e do Redoc.<br>

<b>Documentação dos endpoints de Pagamento via Swagger:</b>
```shell script
http://localhost:8082/pagamentos-ms/swagger-ui.html
```

<b>Documentação dos endpoints de Pagamento via Redoc:</b>
```shell script
http://localhost:8082/pagamentos-ms/redoc.html
```

##

<b>Documentação dos endpoints de Pedido via Swagger:</b>
```shell script
http://localhost:8083/pedidos-ms/swagger-ui.html
```

<b>Documentação dos endpoints de Pedido via Redoc:</b>
```shell script
http://localhost:8083/pedidos-ms/redoc.html
```

##
Na pasta <b>`Postman`</b> contém a collection para usar os endpoints via Postman.

Gerando o arquivo .jar:
-----------------------
Para gerar o arquivo <b>.jar</b>, execute o comando via terminal no diretório raiz de cada um dos projetos:
```shell script
mvn clean install -DskipTests
```

Kakfa:
------
Para rodar o Kafka localmente, é precisao rodar primeiro o Zookeeper.<br>
### Rodando o Zookeeper:
Execute o comando no terminal no diretório onde o Kafka:
```shell script
./bin/zookeeper-server-start.sh config/zookeeper.properties
```

### Rodando o Kafka:
Execute o comando no terminal no diretório onde o Kafka estiver na sua máquina:
```shell script
./bin/kafka-server-start.sh config/server.properties
```
##
### Consumindo tópicos:
Para consumir tópicos no Kafka, execute o comando no terminal no diretório onde do Kafka:
```shell script
./bin/kafka-console-consumer.sh \
	--topic topic_name \
	--bootstrap-server localhost:9092
```

Rodando o projeto localmente:
-----------------------------
Para rodar cada projeto localmente, execute o comando no diretório raiz de cada um dos projetos:
```shell script
mvn spring-boot:run
```

Rodando o projeto no Docker:
----------------------------
Para rodar o projeto no Docker, primeiro deve-se gerar o .jar de cada um dos projetos.<br>
Após isso, deve-se gerar o build das imagens e subir os containers do Docker.<br><br>
<b>Fazendo o build das imagens do Docker:</b>
```shell script
docker-compose build
```

<b>Subindo os containers do Docker:</b>
```shell script
docker-compose up -d
```

Ao subir o Docker, irá ser criado um container para a aplicação que envia mensagem o Kafka e para a aplicação que recebe mensagem do Kafka, um conainter do Zookeeper, um conainter do Kafka e um conainter para o banco de dados.

##
Para automatizar esse processo, basta executar o Shellscript <b>`docker_build_and_run.sh`</b>:
```shell script
./docker_build_and_run.sh
```

Autor:
------
<b>Rodrigo Amora</b>

LinkedIn: https://linkedin.com/in/rodrigoamora <br>
E-mail: rodrigo.amora.freitas@gmail.com
