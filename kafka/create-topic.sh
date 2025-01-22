#!/bin/bash

echo "Enter name of topic: "
read topicName

./bin/kafka-topics.sh \
	--create \
	--topic $topicName \
	--bootstrap-server localhost:9092
