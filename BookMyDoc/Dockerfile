FROM tomcat:8.5.41-jre8
MAINTAINER Goutam Malakar
EXPOSE 8080
RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/BookMyDoc.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]

