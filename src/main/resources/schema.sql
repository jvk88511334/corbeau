CREATE TABLE PANIER(
                       ID TINYINT,
                       NEUF BOOLEAN NOT NULL,
                       PRIMARY KEY(ID)
);

CREATE TABLE SAUTERELLE(
                           ID INT AUTO_INCREMENT,
                           COULEUR VARCHAR(50)  NOT NULL,
                           NAISSANCE DATE,
                           PRIMARY KEY(ID)
);

CREATE TABLE GRILLON(
                        ID TINYINT,
                        COULEUR VARCHAR(50)  NOT NULL,
                        NAISSANCE DATE,
                        ID_1 TINYINT,
                        ID_2 TINYINT NOT NULL,
                        PRIMARY KEY(ID),
                        UNIQUE(ID_1),
                        FOREIGN KEY(ID_1) REFERENCES GRILLON(ID),
                        FOREIGN KEY(ID_2) REFERENCES PANIER(ID)
);

CREATE TABLE PATTE(
                      ID TINYINT,
                      ID_1 TINYINT NOT NULL,
                      PRIMARY KEY(ID),
                      FOREIGN KEY(ID_1) REFERENCES GRILLON(ID)
);
