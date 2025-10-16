DROP DATABASE CArvium;
CREATE DATABASE IF NOT EXISTS CArvium;
USE CArvium;


CREATE TABLE Carrello (

                          ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                          CostoTotale DECIMAL(10,2) NOT NULL,
                          Quantità INT NOT NULL
);


CREATE TABLE MarcaAuto (

                           ID VARCHAR(50) PRIMARY KEY
);


CREATE TABLE ModelloAuto(

                            ID VARCHAR(50),
                            ID_MarcaAuto VARCHAR(50) REFERENCES MarcaAuto (ID) ON DELETE CASCADE,
                            Prezzo DECIMAL(10, 2) NOT NULL,
                            Categoria VARCHAR(30) NOT NULL,
                            Descrizione VARCHAR(255) NOT NULL,
                            Anno INT NOT NULL,

                            PRIMARY KEY (ID, ID_MarcaAuto)
);


CREATE TABLE Ricambi (

                         ID VARCHAR(50) PRIMARY KEY,
                         Prezzo DECIMAL(10, 2) NOT NULL,
                         Categoria VARCHAR(30) NOT NULL,
                         Quantità BIGINT NOT NULL,
                         Anno INT NOT NULL,

                         ID_ModelloAuto VARCHAR(50),
                         ID_MarcaAuto VARCHAR(50),

                         FOREIGN KEY (ID_ModelloAuto, ID_MarcaAuto) REFERENCES ModelloAuto (ID, ID_MarcaAuto) ON DELETE CASCADE
);


CREATE TABLE Aggiungere (

                            ID_Carrello BIGINT NULL REFERENCES Carrello (ID) ON DELETE CASCADE,
                            ID_Ricambi VARCHAR(50) REFERENCES Ricambi (ID) ON DELETE CASCADE,
                            Quantità BIGINT NOT NULL,

                            UNIQUE(ID_Carrello, ID_Ricambi)
);


CREATE TABLE Utente (

                        ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                        Nome VARCHAR(30) NOT NULL,
                        Cognome VARCHAR(30) NOT NULL,
                        Email VARCHAR(50) NOT NULL UNIQUE,
                        Password VARCHAR(255) NOT NULL,
                        Nazione VARCHAR(2) NOT NULL,
                        Via VARCHAR (30) NOT NULL,
                        Civico INT NOT NULL,
                        CAP INT NOT NULL,
                        Admin BOOLEAN NOT NULL DEFAULT 0,
                        ID_Carrello BIGINT REFERENCES Carrello (ID) ON DELETE CASCADE
);


CREATE TABLE Ordine (

                        ID BIGINT AUTO_INCREMENT PRIMARY KEY,
                        Quantità INT NOT NULL,
                        CostoTotale DECIMAL(10, 2) NOT NULL,
                        Data DATE NOT NULL,

                        ID_Carrello BIGINT NULL REFERENCES Carrello (ID) ON DELETE CASCADE
);


CREATE TABLE Contenere (

                           ID_Ordine BIGINT REFERENCES Ordine (ID) ON DELETE CASCADE,
                           ID_Ricambi VARCHAR(50) NULL REFERENCES Ricambi (ID) ON DELETE CASCADE,
                           Quantità BIGINT NOT NULL,
                           PrezzoUnitario DECIMAL(10, 2) NOT NULL,

                           UNIQUE (ID_Ordine, ID_Ricambi)
);


CREATE TABLE Salvare (

                         ID_ModelloAuto VARCHAR(50),
                         ID_MarcaAuto VARCHAR(50),
                         ID_Utente BIGINT REFERENCES Utente (ID) ON DELETE CASCADE,

                         FOREIGN KEY (ID_ModelloAuto, ID_MarcaAuto) REFERENCES ModelloAuto (ID, ID_MarcaAuto) ON DELETE CASCADE,
                         PRIMARY KEY (ID_ModelloAuto, ID_MarcaAuto, ID_Utente)
);




