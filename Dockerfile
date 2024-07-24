FROM eclipse-temurin:21-alpine
WORKDIR /app
COPY ./target/deploy-demo-21-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "deploy-demo-21-0.0.1-SNAPSHOT.jar"]

# FROM linux/amd64
# WORKDIR /app
# COPY ./target/deploy-demo-21 /app/
# RUN chmod +x /app/deploy-demo-21
# ENTRYPOINT ["/app/deploy-demo-21"]