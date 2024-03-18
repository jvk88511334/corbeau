# Deploiement docker
- Modification du code source = build de l'application
- penser aux identifiants de la base de donnée à modifier au besoin
- penser à contrôler la connexion à la bdd dans les applications.properties
```bash
mvn package
```
- Aller dans le Dockerfile pour créer une image docker
- contrôler dans le docker compose la concordance des identifiants de connexion à la base de donnée
- lancer la comande de build ayant en paramètre le nom de l'image désirée
```bash
docker build -t corbeauimage .
```
- la commande docker image ls listera l'image crée
```bash
REPOSITORY     TAG       IMAGE ID       CREATED          SIZE
corbeauimage   latest    152a9307a5c8   12 minutes ago   486MB
```
- ensuite il faudra lancer le docker compose qui pointe sur l'image crée et intègre (depends on) les dépendances necessaires au fonctionnement du container
```
  extra_hosts:
  - "host.docker.internal:host-gateway"
```

Permet de faire la liaison entre localhost et localhost dans le container docker (voir dossier docs)