### Resolution
Placer la version du plugin sous son artifactId comme ceci
```
<artifactId>maven-failsafe-plugin</artifactId>
<version>3.1.2</version>
```

Pour vérifier que le plugin `maven-failsafe-plugin` est présent dans le référentiel distant de Maven, vous pouvez utiliser la commande suivante dans votre terminal :
```
mvn org.apache.maven.plugins:maven-failsafe-plugin:help
```
Cette commande devrait afficher l'aide du plugin, ce qui indique qu'il est présent dans le référentiel distant et qu'il a été correctement téléchargé.

Si le plugin n'est pas présent dans le référentiel distant, vous pouvez essayer de l'ajouter manuellement en le téléchargeant depuis le site officiel de Maven et en l'installant dans votre référentiel local en utilisant la commande suivante :
```
mvn install:install-file -Dfile=<chemin vers le fichier du plugin> -DgroupId=org.apache.maven.plugins -DartifactId=maven-failsafe-plugin -Dversion=<version du plugin> -Dpackaging=maven-plugin
```
Il est également possible de vérifier la présence du plugin dans le référentiel distant en utilisant un navigateur web et en accédant à l'adresse suivante :
```
https://repo1.maven.org/maven2/org/apache/maven/plugins/maven-failsafe-plugin/
```
Cette adresse devrait afficher la liste des versions du plugin disponibles dans le référentiel distant. Si le plugin n'est pas présent, vous pouvez essayer de rechercher un autre référentiel distant qui le contient.