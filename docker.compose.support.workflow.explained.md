1. Suppression de l'ensemble des fichiers application.properties.
2. Creation des containers : contaier app principal basé sur le build de l'application, base de donnée embarquée, dans un second container, adminer pour administration des données
3. Utilisation de la dépendance spring docker-compose-support
4. Lien de montage entre un script local init.sql qui va initialiser des données dans le base de donnée conteneurisée
5. Adaptation de la SauterelleDao pour prendre en compte postgresql et une nouvelle chaine de connection en localhost qui pourra se connecter a la base de donnée du container (remarque : lu'rl peut etre exploitée dans un client sql comme dbeaver)
6. Lancement de l'application en local qui automatiquement exploitera les containers au lieu d'une compilatio locale de l'application.

Remarque : ici on utilise un context local avec la variable build dans le container app, mais il aurait trés bien été possible de se brancher sur une image distante qui aurait contenu une base de donnée distante ou un build . local contenurisé qui aurait utilisé une bdd avec SPRING_DATASOURCE_URL

---

Avantage : on peut se passer complétement avec ce plugin d'une installation locale d'un SGBD pour faire des développements.