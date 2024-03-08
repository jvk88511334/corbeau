Spécifier la version du plugin `maven-failsafe-plugin` dans votre pom.xml. En effet, si vous ne spécifiez pas de version, Maven peut avoir du mal à résoudre le plugin et à le télécharger depuis le référentiel distant. En spécifiant une version, vous indiquez à Maven quelle version du plugin utiliser et il peut alors la télécharger et l'utiliser correctement.

Voici un exemple de configuration du plugin avec la version spécifiée :
```
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-failsafe-plugin</artifactId>
    <version>3.1.2</version>
    <executions>
        <execution>
            <goals>
                <goal>integration-test</goal>
                <goal>verify</goal>
            </goals>
        </execution>
    </executions>
    <configuration>
        <trimStackTrace>false</trimStackTrace>
        <enableAssertions>true</enableAssertions>
    </configuration>
</plugin>
```
Il est recommandé de toujours spécifier la version des plugins dans votre pom.xml pour éviter les problèmes de résolution et pour garantir que vous utilisez la version souhaitée du plugin.