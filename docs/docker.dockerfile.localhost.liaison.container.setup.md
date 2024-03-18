Pour se connecter à une base de données en localhost depuis un conteneur Docker, vous pouvez utiliser plusieurs méthodes en fonction de votre configuration. Voici deux approches courantes pour établir cette connexion :

1. **Mapping de ports** :
    - Une méthode consiste à mapper le port de la base de données sur votre machine hôte au port du conteneur Docker. Par exemple, si votre base de données tourne sur le port 3306 en localhost, vous pouvez mapper ce port au conteneur Docker en utilisant la commande suivante lors du démarrage du conteneur :
      ```
      docker run -d --name nom_conteneur -p 3306:3306 nom_image
      ```
    - Après avoir effectué ce mapping, vous pourrez accéder à la base de données depuis le conteneur Docker en utilisant l'adresse http://localhost:3306.

2. **Utilisation de `extra_hosts` dans `docker-compose`** :
    - Une autre méthode consiste à utiliser le paramètre `extra_hosts` dans un fichier `docker-compose.yml`. Cela permet d'ajouter des noms d'hôtes supplémentaires et leurs adresses IP correspondantes au fichier `/etc/hosts` du conteneur.
    - Voici un exemple de configuration dans un fichier `docker-compose.yml` pour se connecter à localhost depuis un conteneur :
      ```yaml
      services:
        nom_service:
          extra_hosts:
            - "host.docker.internal:host-gateway"
      ```
    - En utilisant cette configuration, vous pourrez accéder à localhost depuis le conteneur Docker en utilisant le nom d'hôte `host.docker.internal`.

En suivant ces approches, vous devriez pouvoir établir une connexion à une base de données en localhost depuis un conteneur Docker.

Citations:
[1] https://odeven.fr/docker-prendre-en-main-le-gestionnaire-de-conteneurs/
[2] https://www.youtube.com/watch?v=BW6nNwbNyio
[3] https://huzaima.io/blog/connect-localhost-docker
[4] https://stackoverflow.com/questions/24319662/from-inside-of-a-docker-container-how-do-i-connect-to-the-localhost-of-the-mach
[5] https://kinsta.com/fr/blog/mariadb-docker/