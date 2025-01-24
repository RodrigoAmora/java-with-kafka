#!/bin/bash

echo -e "\033[01;32m#############################\033[01;32m"
echo -e "\033[01;32m##### Building Jar file #####\033[01;32m"
echo -e "\033[01;32m#############################\033[01;32m"
echo -e "\n\n"

### SHOP CONSUMER ###
echo -e "\033[01;32m#########################\033[01;32m"
echo -e "\033[01;32m##### Shop Consumer #####\033[01;32m"
echo -e "\033[01;32m#########################\033[01;32m"

echo -e "\n"
echo -e "\033[01;32mDeleting the image of Shop Consumer....\033[01;32m"
echo -e "\n"
docker rmi -f shop-consumer
echo -e "\n"

cd shop-api-consumer/
rm -rf target/
mvn clean install -DskipTests
#####################

cd ../
echo -e "\n\n"

### SHOP PRODUCER ###
echo -e "\033[01;32m#########################\033[01;32m"
echo -e "\033[01;32m##### Shop Producer #####\033[01;32m"
echo -e "\033[01;32m#########################\033[01;32m"

echo -e "\n"
echo -e "\033[01;32mDeleting the image of Shop Producer....\033[01;32m"
echo -e "\n"
docker rmi -f shop-producer
echo -e "\n"

cd shop-api-producer/
rm -rf target/
mvn clean install -DskipTests
#####################

cd ../
echo -e "\n\n"

### DOCKER ###
echo -e "\n"
echo -e "\033[01;32m##############\033[01;32m"
echo -e "\033[01;32m### Docker ###\033[01;32m"
echo -e "\033[01;32m##############\033[01;32m"
echo -e "\n"

echo -e "\033[01;32m###########################\033[01;32m"
echo -e "\033[01;32m### Building images.... ###\033[01;32m"
echo -e "\033[01;32m###########################\033[01;32m"
echo -e "\n\n"

sudo docker-compose build

echo -e "\n\n"
echo -e "\033[01;32m########################\033[01;32m"
echo -e "\033[01;32m### Uping containers ###\033[01;32m"
echo -e "\033[01;32m########################\033[01;32m"
echo -e "\n\n"

sudo docker-compose up -d

echo -e "\n\n"
echo -e "\033[01;32m###############################\033[01;32m"
echo -e "\033[01;32m### Application running!!!! ###\033[01;32m"
echo -e "\033[01;32m###############################\033[01;32m"
