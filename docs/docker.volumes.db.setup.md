Pour dockeriser une application Spring Boot avec une base de données MySQL embarquée, vous devez suivre plusieurs étapes. Voici un exemple pas à pas, incluant la création d'un `Dockerfile` pour l'application Spring Boot, un fichier `docker-compose.yml` pour orchestrer l'application et la base de données MySQL, et les commandes pour construire et lancer les conteneurs.

### Étape 1: Créer le Dockerfile pour l'application Spring Boot

Créez un fichier `Dockerfile` dans le répertoire racine de votre projet Spring Boot avec le contenu suivant :

```Dockerfile
# Utiliser une image de base Java avec Alpine pour sa légèreté
FROM openjdk:17-jdk-alpine

# Copier le fichier JAR construit dans l'image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Exposer le port sur lequel l'application va tourner
EXPOSE 8080

# Lancer l'application Spring Boot
ENTRYPOINT ["java","-jar","/app.jar"]
```

### Étape 2: Créer le fichier docker-compose.yml

Créez un fichier `docker-compose.yml` à la racine de votre projet avec le contenu suivant :

```yaml
version: '3.8'
services:
  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - mysql
    environment:
      - SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/db_example
      - SPRING_DATASOURCE_USERNAME=root
      - SPRING_DATASOURCE_PASSWORD=pass
  mysql:
    image: mysql:5.7
    environment:
      MYSQL_DATABASE: 'db_example'
      MYSQL_ROOT_PASSWORD: 'pass'
    ports:
      - "3306:3306"
    volumes:
      - db-data:/var/lib/mysql

volumes:
  db-data:
```

Ce fichier définit deux services : `app` pour l'application Spring Boot et `mysql` pour la base de données MySQL. Le service `app` construit l'image à partir du `Dockerfile` et le service `mysql` utilise une image MySQL prédéfinie. Les variables d'environnement pour Spring Boot sont définies pour se connecter à la base de données MySQL.

### Étape 3: Construire et lancer les conteneurs

Exécutez les commandes suivantes pour construire l'image de votre application et lancer les conteneurs :

```bash
# Construire l'image de l'application Spring Boot
docker-compose build

# Lancer les services définis dans le fichier docker-compose.yml
docker-compose up
```

Après avoir exécuté ces commandes, Docker va construire l'image de votre application Spring Boot et démarrer les conteneurs pour l'application et la base de données MySQL. L'application sera accessible sur `http://localhost:8080` et MySQL sur le port `3306`.

### Notes supplémentaires

- Assurez-vous que votre application Spring Boot est configurée pour utiliser les variables d'environnement `SPRING_DATASOURCE_URL`, `SPRING_DATASOURCE_USERNAME`, et `SPRING_DATASOURCE_PASSWORD` pour se connecter à la base de données.
- Vous pouvez personnaliser les versions des images Docker et les configurations selon vos besoins.
- Si vous avez besoin de données initiales dans votre base de données, vous pouvez ajouter un script SQL dans le volume de MySQL ou configurer votre application pour exécuter des scripts de données au démarrage.

En suivant ces étapes, vous aurez une application Spring Boot dockerisée fonctionnant avec une base de données MySQL embarquée.

Citations:
[1] https://spring.io/guides/topicals/spring-boot-docker
[2] https://www.docker.com/blog/9-tips-for-containerizing-your-spring-boot-code/
[3] https://opensource.stackexchange.com/questions/6572/can-i-deploy-a-docker-compose-yml-that-uses-mysql-commercially
[4] https://stackoverflow.com/questions/45775476/developing-a-spring-boot-application-with-docker-on-windows-but-run-the-docker-c
[5] https://www.baeldung.com/dockerizing-spring-boot-application
[6] https://www.youtube.com/watch?v=RVIbMuNs1aw
[7] https://dev.mysql.com/blog-archive/docker-compose-and-app-deployment-with-mysql/
[8] https://www.youtube.com/watch?v=YAEK_CrZB3I
[9] https://anywhere.epam.com/en/blog/how-to-dockerize-spring-boot-application
[10] https://stackoverflow.com/questions/50219798/keycloak-mysql-on-docker-compose-no-data-saved
[11] https://foojay.io/today/starting-docker-desktop-with-spring-boot/
[12] https://www.docker.com/blog/kickstart-your-spring-boot-application-development/
[13] https://numericaideas.com/blog/docker-compose-springboot-mysql/
[14] https://howtodoinjava.com/devops/dockerize-spring-boot-application/
[15] https://dockerize.io/guides/docker-spring-boot-guide
[16] https://dev.mysql.com/blog-archive/docker-compose-setup-for-innodb-cluster/
[17] https://www.geeksforgeeks.org/how-to-dockerize-a-spring-boot-application-with-maven/
[18] https://www.bogotobogo.com/DevOps/Docker/Docker-Compose-MySQL.php
[19] https://gist.github.com/davidovs/19602595b3b19544c33adfeaca7a16a4
[20] https://forums.docker.com/t/spring-boot-microservices-docker-compose-failed-to-configure-a-datasource-issue/127409