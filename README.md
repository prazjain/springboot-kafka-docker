### Setup

In this project, we will download and use Kafka using its docker image.  
No local installation of docker is required to run this application.  
This Spring Boot application will just expose an Http endpoint, which will post a Kafka message.  
The Kafka message will be read by a service in same application, and will output something in console, just to prove messaging worked.  

We will use `docker compose` (earlier it was docker-compose, but now it is `docker compose` and part of docker cli)  

#### Install Kafka
https://www.youtube.com/watch?v=WnlX7w4lHvM  

Steps  
`mvn clean package` to build our application jar file   
`docker compose build` to create docker image with our latest application jar file  
`docker compose -f docker-compose.yml up -d`, we use `-d` to run in detached mode, remove this flag to run in foreground mode  
`docker compose down` to stop kafka docker services  
Topic will be automatically created  

Test  
Send POST message from postman to http://localhost:80/publish
Set Body to form-data (as this a post request)  
Add key: message, value: Hello  
Once this is sent, it will be shown in terminal by our consumer.

Docker compose build will  
* Start Zookeeper service in a container (after downloading its public docker image)  
* Start kafka service in a container (after downloading its public image)  
* Build our Spring boot project's local image, and start service on local port 80 and redirect to container port 8080  

#### References  

Docker workshop  
https://github.com/gvilarino/docker-workshop  

Understand how docker Compose can be used for building  
https://zhao-li.medium.com/how-to-understand-building-images-with-docker-compose-24cbdbc0641f  

Spring Boot with Kafka Consumer and Producer  
https://www.youtube.com/watch?v=fCt0L4LwB9w  

Kafka Installation using Docker and Docker compose  
https://www.youtube.com/watch?v=WnlX7w4lHvM  

Good Link about Challenges of running kafka in docker  
https://medium.com/@marcelo.hossomi/running-kafka-in-docker-machine-64d1501d6f0b  
https://rmoff.net/2018/08/02/kafka-listeners-explained/  
https://gist.github.com/rmoff/fb7c39cc189fc6082a5fbd390ec92b3d  

https://github.com/wurstmeister/kafka-docker/issues/17  
https://jaceklaskowski.gitbooks.io/apache-kafka/content/kafka-docker.html  

Spin up kafka and zookeeper on docker  
https://www.youtube.com/watch?v=HX9RsIQktuQ  

https://www.confluent.io/blog/kafka-client-cannot-connect-to-broker-on-aws-on-docker-etc/  

 