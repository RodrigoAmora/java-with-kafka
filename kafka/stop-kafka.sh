#!/bin/bash

################################
## Shell script to stop Kafka ##
################################

echo "Enter Kafka's directory: "
read kafkaDirectory

cd kafkaDirectory

echo -e "\n"
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\033[01;32m### Stopping Kafka ###\033[01;32m"
echo -e "\033[01;32m######################\033[01;32m"
echo -e "\n"

rm -rf /tmp/kafka-logs /tmp/zookeeper
