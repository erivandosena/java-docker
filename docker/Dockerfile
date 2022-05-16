# docker build -f ./docker/Dockerfile -t erivando/java-web-demo:latest .
# docker push erivando/java-web-demo:latest
# docker run -d --rm --name app-java -p 8088:8080 erivando/java-web-demo:latest
# docker container logs -f app-java
# docker exec -ti app-java bash
# http://localhost:8088/app-demo/

FROM tomcat:latest

LABEL vendor="JAVA" maintainer="Erivando Sena<erivandosena@gmail.com>" description="Aplicação Java Web com Apache Tomcat" version="1.0.0"

# Ferramentas de depuração: Algumas maneiras de lidar com ferramentas de depuração. 
# Trade off é uma montagem de volume um pouco mais complexa versus manter o tamanho da imagem baixo.
RUN apt-get update && \
  apt-get install -y \
    net-tools \
    tree \
    maven \
    vim && \
  rm -rf /var/lib/apt/lists/* && apt-get clean && apt-get purge

RUN echo "export JAVA_OPTS=\"-Dapp.env=staging\"" > /usr/local/tomcat/bin/setenv.sh

WORKDIR /opt/app

COPY ./app/ .

# Cria target/app-demo.war
# brew install maven # for macosx
RUN mvn package 

RUN mv target/app-demo.war /usr/local/tomcat/webapps/app-demo.war

RUN chown -Rf www-data:www-data /usr/local/tomcat/webapps

RUN rm -rf target

EXPOSE 8080

CMD ["catalina.sh", "run"]