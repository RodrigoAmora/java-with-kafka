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

##
Para automatizar esse processo, basta executar o Shellscript <b>`docker_build_and_run.sh`</b>:
```shell script
./docker_build_and_run.sh
```

Kakfa:
------
<b>Rodando o Kafka:</b>
##
Para rodar o Kafka localmente, é precisao rodar primeiro o Zookeeper.<br>
<b>Rodando o Zookeeper:</b><br>
Execute o comando no terminal no diretório onde o Kafka:
```shell script
./bin/zookeeper-server-start.sh config/zookeeper.properties
```

<b>Rodando o Kafka:</b><br>
Execute o comando no terminal no diretório onde o Kafka estiver na sua máquina:
```shell script
./bin/kafka-server-start.sh config/server.properties
```
##
<b>Consumindo tópicos:</b><br>
Para consumir tópicos no Kafka, execute o comando no terminal no diretório onde do Kafka:
```shell script
./bin/kafka-console-consumer.sh \
	--topic topic_name \
	--bootstrap-server localhost:9092
```
