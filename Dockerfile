FROM maven:3.9-amazoncorretto-21 as build-image
WORKDIR /build/

# FROM = a partir d'une image officielle va construire une image dérivée
# ATTENTION en cas de modification du code penser a systématiquement rebuilder l'application
COPY . /build/

# Exécuter la commande Maven package pour construire le JAR
RUN mvn clean package

FROM openjdk:17-alpine as api-image
WORKDIR /app/
# Copier le JAR construit dans l'image
COPY --from=build-image /build/target/*.jar /app/corbeau.jar

# Exposer le port et lancer l'application
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/corbeau.jar"]