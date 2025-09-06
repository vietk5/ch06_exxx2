FROM tomcat:10.1-jdk17
COPY target/ch06_exx2-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war