Pour ajouter Adminer, un outil de gestion de base de données via une interface web, à votre configuration Docker existante, vous devez modifier le fichier `docker-compose.yml` pour inclure un service supplémentaire pour Adminer. Voici comment vous pouvez le faire :

### Étape 1: Mettre à jour le fichier docker-compose.yml

Ajoutez le service `adminer` à votre fichier `docker-compose.yml` existant :

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
  adminer:
    image: adminer
    restart: always
    ports:
      - "8081:8080"

volumes:
  db-data:
```

Dans cet exemple, le service `adminer` utilise l'image officielle `adminer` et expose le port `8081` sur votre machine hôte. Cela signifie que vous pourrez accéder à Adminer en ouvrant `http://localhost:8081` dans votre navigateur.

### Étape 2: Lancer les services avec Docker Compose

Après avoir mis à jour votre fichier `docker-compose.yml`, exécutez les commandes suivantes pour démarrer tous les services, y compris Adminer :

```bash
# Construire l'image de l'application Spring Boot si nécessaire
docker-compose build

# Lancer les services définis dans le fichier docker-compose.yml
docker-compose up
```

### Étape 3: Accéder à Adminer

Une fois que les conteneurs sont en cours d'exécution, ouvrez votre navigateur et allez à `http://localhost:8081`. Vous devriez voir l'interface web d'Adminer.

Pour vous connecter à votre base de données MySQL, utilisez les informations suivantes :

- **Système**: MySQL
- **Serveur**: mysql (le nom du service MySQL dans `docker-compose.yml`)
- **Utilisateur**: root (ou tout autre utilisateur que vous avez défini)
- **Mot de passe**: pass (le mot de passe que vous avez défini pour l'utilisateur MySQL)
- **Base de données**: db_example (le nom de la base de données que vous avez créé)

Après avoir entré ces informations, vous pourrez gérer votre base de données MySQL via l'interface Adminer.