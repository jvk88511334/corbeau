Voici un résumé de l'intérêt de cette page avec un exemple pas à pas :

## Résumé

Cette page présente la nouvelle fonctionnalité de prise en charge de Docker Compose dans Spring Boot 3.1. Cela simplifie grandement le déploiement d'applications Spring Boot avec des services externes comme des bases de données.

Auparavant, il fallait configurer manuellement les propriétés de connexion, lancer les conteneurs Docker séparément, etc. Avec Docker Compose dans Spring Boot 3.1, tout est automatisé :

- Spring Boot détecte le fichier docker-compose.yml et lance les services requis (bases de données, Redis, etc.)
- Il configure automatiquement les propriétés de connexion sans avoir à les spécifier
- Il arrête les conteneurs quand l'application s'arrête

Cela évite la duplication de configuration et facilite grandement le développement et le déploiement.

## Exemple pas à pas

1. Créer un fichier docker-compose.yml définissant les services requis, par exemple une base de données PostgreSQL :

```yaml
services:
  database:
    image: 'postgres:15.2'
    ports:
      - '5432'
    environment:
      - 'POSTGRES_USER=myuser'
      - 'POSTGRES_DB=mydatabase'
      - 'POSTGRES_PASSWORD=secret'
```

2. Dans votre application Spring Boot, ajouter la dépendance `spring-boot-docker-compose`

3. Lancer l'application Spring Boot. Elle détectera automatiquement le fichier docker-compose.yml, lancera le conteneur PostgreSQL et configurera la connexion à la base de données[2]

C'est tout ! Plus besoin de configurer les propriétés de connexion ou de lancer manuellement les conteneurs Docker. Spring Boot 3.1 gère tout pour vous.

Citations:
[1] https://www.baeldung.com/dockerizing-spring-boot-application
[2] https://spring.io/blog/2023/06/21/docker-compose-support-in-spring-boot-3-1/
[3] https://www.baeldung.com/docker-compose-support-spring-boot
[4] https://www.bezkoder.com/docker-compose-spring-boot-mysql/
[5] https://docs.docker.com/samples/spring/
[6] https://spring.io/blog/2023/06/21/docker-compose-support-in-spring-boot-3-1