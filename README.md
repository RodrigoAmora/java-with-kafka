# java-with-kafka
Projeto usando Java com Kafka.

Kakfa:
------
<b>Rodando o Kafka:</b>
##
Para rodar o Kafka localmente, é precisao rodar primeiro o Zookeeper.
<b>Rodando o Zookeeper:</b>
Execute o comando no terminal no diretório onde o Kafka:
```shell script
./bin/zookeeper-server-start.sh config/zookeeper.properties
```

<b>Rodando o Kafka:</b>
Execute o comando no terminal no diretório onde o Kafka estiver na sua máquina:
```shell script
./bin/kafka-server-start.sh config/server.properties
```

<b>Consumindo tópicos:</b>
Para consumir tópicos no Kafka, execute o comando no terminal no diretório onde do Kafka:
##
```shell script
./bin/kafka-console-consumer.sh \
	--topic topic_name \
	--bootstrap-server localhost:9092
```
