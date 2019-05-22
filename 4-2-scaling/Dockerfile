FROM amazoncorretto:8u202
VOLUME /tmp
ADD /build/libs/4-2-scaling-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 80
ENTRYPOINT exec java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -XX:MaxRAMFraction=2 -Xms300M -Xmx3500M -Djava.security.egd=file:/dev/./urandom -jar /app.jar
