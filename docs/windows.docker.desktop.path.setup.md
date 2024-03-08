### Docker ne fonctionne pas sur mon cmd avec docker --version

Il semble que le chemin d'accès à Docker ne soit pas correctement configuré dans votre système. Voici les étapes à suivre pour résoudre ce problème :

1. Vérifiez que Docker Desktop est bien installé et en cours d'exécution sur votre système.
2. Ouvrez le menu Démarrer, recherchez "Variables d'environnement" et sélectionnez "Modifier les variables d'environnement système".
3. Dans la fenêtre "Propriétés système", cliquez sur le bouton "Variables d'environnement".
4. Dans la section "Variables système", recherchez la variable "Path" et sélectionnez-la.
5. Cliquez sur le bouton "Modifier" et ajoutez le chemin d'accès à l'exécutable Docker à la liste des valeurs. Le chemin par défaut est `C:\Program Files\Docker\Docker\Resources\bin`.
6. Cliquez sur "OK" pour enregistrer les modifications et fermer toutes les fenêtres.
7. Ouvrez une nouvelle invite de commandes et vérifiez que Docker est maintenant reconnu en tapant `docker --version`.

Si vous avez suivi ces étapes et que Docker n'est toujours pas reconnu, il est possible que l'installation de Docker Desktop ait échoué ou qu'il y ait un autre problème avec votre système. Dans ce cas, je vous recommande de réinstaller Docker Desktop ou de contacter le support technique de Docker pour obtenir de l'aide.