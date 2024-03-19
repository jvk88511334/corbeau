FROM amazoncorretto:17
# FROM = a partir d'une image officielle va construire une image dérivée
# ATTENTION en cas de modification du code penser a systématiquement rebuilder l'application
# Copier le fichier JAR (qui à été préalablement construit dans un repertoire target crée par la commande mvn package) dans l'image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
# Exposer le port sur lequel l'application va tourner
EXPOSE 8080
# Lancer l'application Spring Boot
ENTRYPOINT ["java","-jar","/app.jar"]
# Le lien avec le docker-compose est fait dans la partie
#app:
# build: .