/*INSERT INTO PANIER(ID, LIBELLE) VALUES
(1, 'Input 1'),
(2, 'Input 2'),
(3, 'Input 3');

INSERT INTO PRODUIT(ID, LIBELLE, PRIX, QUANTITE, PANIER_ID) VALUES
(1, 'livre', 12.49, 1, 1),
(2, 'CD musical', 14.99, 1, 1),
(3, 'barre de chocolat', 0.85, 1, 1),
(4, 'bo�te de chocolats import�e', 10, 1, 2),
(5, 'flacon de parfum import�', 47.50, 1, 2),
(6, 'flacon de parfum import�', 27.99, 1, 3),
(7, 'flacon de parfum', 18.99, 1, 3),
(8, 'bo�te de pilules contre la migraine', 9.75, 1, 3),
(9, 'bo�te de chocolats import�e', 11.25, 1, 3);

INSERT INTO TAXE(ID, LIBELLE, TAUX) VALUES
(1, 'TVA', 0.1),
(2, 'Taxe importation', 0.05);

INSERT INTO TAXE_PRODUIT(PRODUIT_ID, TAXE_ID) VALUES
(2, 1),
(4, 2),
(5, 1),
(5, 2),
(6, 1),
(6, 2),
(7, 1),
(9, 2);*/