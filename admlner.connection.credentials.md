Les identifiants de connexion à Adminer pour le Docker Compose fourni sont les suivants :
- Serveur : host.docker.internal:host-gateway
- Nom d'utilisateur : root
- Mot de passe : Zp3pbrya
- Base de données : jpa
- Port : 3306

L'erreur "Access denied for user 'root'@'172.21.0.2' (using password: YES)" indique un problème d'accès.
Attention ! C'est souvent un mauvais nom de serveur.

Citations:
[1] https://www.reddit.com/r/docker/comments/ys8oh1/docker_mysql_error_1045_28000_access_denied_for/
[2] https://forum.seatable.io/t/on-database-update-access-denied-for-user-root/1882
[3] https://forums.docker.com/t/how-to-fix-that-mysql-deny-in-docker-container-by-interaction/45627
[4] https://community.e.foundation/t/mariadb-issue-access-denied-for-user-root-localhost/24500
[5] https://www.geekyhacker.com/how-to-resolve-mysql-access-denied-in-docker-compose/