Pour compiler un projet Vaadin avec Maven en mode production, vous devez suivre les étapes suivantes :

1. Ouvrez votre terminal et naviguez jusqu'au répertoire racine de votre projet Vaadin.
2. Assurez-vous que vous avez installé Maven et qu'il est correctement configuré sur votre système. Vous pouvez vérifier cela en tapant la commande suivante :
```
mvn -version
```
3. Une fois que vous êtes dans le répertoire racine de votre projet Vaadin, exécutez la commande suivante pour compiler votre projet en mode production :
```css
mvn clean install -Pproduction
```
La commande pour forcer le build en mode production est
```
mvn clean package -Pproduction -Dvaadin.force.production.build=true
```

Cette commande effectue les opérations suivantes :

* `clean` : supprime tous les fichiers générés précédemment dans le répertoire cible.
* `install` : compile le code source, exécute les tests et crée un fichier JAR ou WAR dans le répertoire cible.
* `-Pproduction` : active le profil Maven "production" qui est configuré dans le fichier `pom.xml` de votre projet Vaadin. Ce profil active les optimisations pour le mode production, telles que la minimisation des ressources et l'activation de la compression Gzip.
4. Une fois la compilation terminée avec succès, vous pouvez déployer votre application Vaadin sur votre serveur d'application préféré.

Notez que la commande `mvn clean install -Pproduction` peut prendre un certain temps pour s'exécuter, en fonction de la taille de votre projet Vaadin. Assurez-vous également que vous disposez des droits d'accès nécessaires pour écrire dans le répertoire cible.