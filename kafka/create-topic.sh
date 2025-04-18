#!/bin/bash


echo "Enter Kafka's directory: "
read kafkaDirectory

cd kafkaDirectory

echo "Enter name of topic: "
read topicName

./bin/kafka-topics.sh \
	--create \
	--topic $topicName \
	--bootstrap-server localhost:9092
