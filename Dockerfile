FROM java:8
EXPOSE 8080
ADD /target/hoursworkedback.jar hoursworkedback.jar
ENTRYPOINT ["java", "-jar", "hoursworkedback.jar", "-web -webAllowOthers -tcp -tcpAllowOthers -browser"]
