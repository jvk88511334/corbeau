CREATE DATABASE creme;
-- Connectez-vous à la base de données creme
\c creme;

-- Créez une table si elle n'existe pas déjà
CREATE TABLE IF NOT EXISTS sauterelle (
                                          id SERIAL PRIMARY KEY,
                                          nom VARCHAR(255) DEFAULT NULL,
                                          naissance DATE DEFAULT NULL,
                                          couleur VARCHAR(50) NOT NULL
);

-- Insérez des données dans la table
INSERT INTO sauterelle (nom, naissance, couleur) VALUES ('Grillonne', '2024-03-29', 'Vert');