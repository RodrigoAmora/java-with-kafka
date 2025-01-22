#!/bin/bash

###################################
## Shell script to run Zookeeper ##
###################################

echo "Enter Kafka's directory: "
read kafkaDirectory

cd kafkaDirectory

echo -e "\n"
echo -e "\033[01;32m#########################\033[01;32m"
echo -e "\033[01;32m### Runnning Zookeeper ###\033[01;32m"
echo -e "\033[01;32m#########################\033[01;32m"
echo -e "\n"

./bin/zookeeper-server-start.sh config/zookeeper.properties
