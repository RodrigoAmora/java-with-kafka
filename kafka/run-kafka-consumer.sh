#!/bin/bash

################################################
## Shell script to run Kafka Console Consumer ##
################################################

echo "Enter Kafka's directory: "
read kafkaDirectory

cd kafkaDirectory

echo "Enter name of topic: "
read topicName

./bin/kafka-console-consumer.sh \
	--topic $topicName \
	--bootstrap-server localhost:9092

