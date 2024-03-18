package papillon.colibri.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SauterelleDao {
    public static List<Sauterelle> getAllUsers() throws SQLException {
        List<Sauterelle> users = new ArrayList<>();

        // Chargez le pilote JDBC approprié
        String driver = "com.mysql.cj.jdbc.Driver";
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        /* Pour une table crée comme ceci
        CREATE TABLE `sauterelle` (
        `id` int NOT NULL AUTO_INCREMENT,
        `naissance` date DEFAULT NULL,
        `couleur` varchar(50) NOT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
        */

        // Connectez-vous à la base de données que vous avez crée
        // Dans le container docker il faudra utiliser jdbc:mysql://host.docker.internal:3306/[nom de votre base]
        // Dans le terminal d'une machine locale il faudra utiliser jdbc:mysql://localhost:3306/[nom de votre base]
        String url = "jdbc:mysql://host.docker.internal:3306/jpa";
        String username = "root";
        String password = "Zp3pbrya";
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
            Sauterelle user = new Sauterelle(id, naissance, couleur);
            users.add(user);
        }

        // Fermez les ressources
        resultSet.close();
        statement.close();
        connection.close();

        return users;
    }
}
