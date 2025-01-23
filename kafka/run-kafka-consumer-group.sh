#!/bin/bash

#########################################################
## Shell script to run Kafka Console Consumer on Group ##
#########################################################


echo "Enter Kafka's directory: "
read kafkaDirectory

cd kafkaDirectory

echo "Enter name of topic: "
read topicName

echo "Enter name of group: "
read groupName

./bin/kafka-console-consumer.sh \
	--topic $topicName \
	--from-beginning \
	--bootstrap-server localhost:9092 \
	--consumer-property group.id=$groupName
