package papillon.colibri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SauterelleDao {
    public static List<Sauterelle> getAllUsers() throws SQLException {
        List<Sauterelle> users = new ArrayList<>();

        // Chargez le pilote JDBC approprié
        String driver = "org.postgresql.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("ici");
            e.printStackTrace();
            return null;
        }

        /* Pour une table crée comme ceci (necessite d'avoir installé une BDD nommée jpa dans cet exemple)
        CREATE TABLE `sauterelle` (
        `id` int NOT NULL AUTO_INCREMENT,
        `naissance` date DEFAULT NULL,
        `couleur` varchar(50) NOT NULL,
        PRIMARY KEY (`id`)
        )
        */

        // Connectez-vous à la base de données que vous avez crée
        // Dans le container docker il faudra utiliser jdbc:mysql://host.docker.internal:3306/[nom de votre base]

        /*
         IMPORTANT ! Pour se connecter
         Dans le terminal d'une machine locale il faudra utiliser jdbc:mysql://localhost:3306/[nom de votre base]
         Dans la cadre d'une image docker locale il faudra utiliser jdbc:mysql://host.docker.internal:3306/[nom de votre base]
         */
        String url = "jdbc:postgresql://localhost:5432/creme";
        String username = "root";
        String password = "Bacille";
        Connection connection = DriverManager.getConnection(url, username, password);

        // Exécutez la requête SQL pour récupérer les données de la table
        String sql = "SELECT * FROM sauterelle";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        // Parcourez le ResultSet et créez une liste d'objets User
        while (resultSet.next()) {
            int id = resultSet.getInt("ID");
            Date naissance = resultSet.getDate("NAISSANCE");
            String couleur = resultSet.getString("COULEUR");
            String nom = resultSet.getString("NOM");
            Sauterelle user = new Sauterelle(id, naissance, couleur, nom);
            users.add(user);
        }

        // Fermez les ressources
        resultSet.close();
        statement.close();
        connection.close();

        return users;
    }
}
