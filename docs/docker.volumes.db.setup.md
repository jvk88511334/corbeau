Pour persister les données de la base de données MySQL dans un volume Docker, vous pouvez utiliser l'option `volumes` dans le fichier `docker-compose.yml` pour monter un volume sur le répertoire de données MySQL dans le conteneur.

Voici un exemple de configuration de volume pour le service `db` dans votre fichier `docker-compose.yml` :
```yaml
version: '3'
services:
  db:
    image: mysql:8.0
    environment:
      MYSQL_DATABASE: mydb
      MYSQL_USER: myuser
      MYSQL_PASSWORD: mypassword
      MYSQL_ROOT_PASSWORD: rootpassword
    volumes:
      - mysqldata:/var/lib/mysql
    ports:
      - "3307:3306"
  app:
    image: myspringbootapp:latest
    build:
      context: .
      dockerfile: Dockerfile
    environment:
      SPRING_DATASOURCE_URL: jdbc:mysql://db:3306/mydb
      SPRING_DATASOURCE_USERNAME: myuser
      SPRING_DATASOURCE_PASSWORD: mypassword
    ports:
      - "8081:8080"
    depends_on:
      - db
volumes:
  mysqldata:
```
Dans cette configuration, nous avons ajouté une section `volumes` au niveau racine du fichier `docker-compose.yml` pour définir un volume nommé `mysqldata`. Nous avons également ajouté une section `volumes` au service `db` pour monter le volume `mysqldata` sur le répertoire `/var/lib/mysql` dans le conteneur MySQL. C'est dans ce répertoire que MySQL stocke les données de la base de données.

Lorsque vous démarrez le conteneur MySQL avec cette configuration, Docker monte le volume `mysqldata` sur le répertoire `/var/lib/mysql` dans le conteneur. Toutes les données de la base de données sont stockées dans ce répertoire et sont persistées dans le volume `mysqldata`. Si vous arrêtez et supprimez le conteneur MySQL, les données sont conservées dans le volume et peuvent être réutilisées lorsque vous redémarrez le conteneur.

Notez que vous pouvez également spécifier un chemin absolu sur l'hôte Docker pour monter le volume, au lieu d'utiliser un volume nommé. Par exemple :
```yaml
volumes:
  - /path/to/mysql/data:/var/lib/mysql
```
Cette configuration monte le répertoire `/path/to/mysql/data` sur l'hôte Docker sur le répertoire `/var/lib/mysql` dans le conteneur MySQL. Assurez-vous que le répertoire sur l'hôte existe et est accessible à Docker.