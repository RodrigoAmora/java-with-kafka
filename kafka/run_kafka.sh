#!/bin/bash

###############################
## Shell script to run Kafka ##
###############################

echo "Enter Kafka's directory: "
read kafkaDirectory

cd kafkaDirectory

echo -e "\n"
echo -e "\033[01;32m#########################\033[01;32m"
echo -e "\033[01;32m### Runnning Kafka ###\033[01;32m"
echo -e "\033[01;32m#########################\033[01;32m"
echo -e "\n"

./bin/kafka-server-start.sh config/server.properties
