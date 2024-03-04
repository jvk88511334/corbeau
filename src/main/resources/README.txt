dans le fichier application.properties
une fois l'application lancée une fois via le test contextLoads de CoccinelleApplicationTests
passer l'option spring.sql.init.mode de always à never
pensez à mettre le mot de passe d'accès a la base de donnée dans spring.datasource.password

explication
always : Cette option indique à Spring Boot d'exécuter toujours les scripts SQL, qu'ils aient déjà été exécutés auparavant ou non. C'est l'option par défaut. Cette option peut être utile pendant le développement, lorsque vous apportez fréquemment des modifications à votre schéma de base de données et que vous souhaitez que ces modifications soient toujours reflétées dans votre base de données.
never : Cette option indique à Spring Boot de ne jamais exécuter les scripts SQL. Cette option peut être utile lorsque vous déployez votre application en production et que vous ne voulez pas que Spring Boot apporte des modifications à votre base de données.

schema.sql : fichier est utilisé pour créer le schéma de la base de données
data.sql :  insérer des données dans la base de données

en cas de modification du schema.sql, penser à supprimer la base de donnée dans un client sql comme DBeaver
puis recréer la base de donnée
controler le nom de la base de donnée est correct dans le suffixe spring.datasource.url=jdbc:mysql://localhost:3306/ -> nom de la base de donnée
puis relancer une fois l'appli ou le test contextLoads pour recréer à nouveau les tables avec le nouveau schéma