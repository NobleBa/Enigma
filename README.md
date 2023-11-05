# Enigma

Enigma est un site web interactif vous permettant de résoudre une série d'énigmes plus ou moins farfelues.

## Déploiement

### Installation de la base de données

Notre base de données est sous MySQL, ouvrez MySQL depuis votre terminal ou PhpMyAdmin.

####MySQL depuis le terminal

Connectez vous à votre MySQL, remplacez *username* par votre identifiant
```
$ mysql -u username -p
```

Entrez votre mot de passe si demandé

Créez une base de données nommée *enigma* avec cette commande :
```
mysql> CREATE DATABASE enigma;
```

Sélectionnez cette base de données
```
 mysql> USE enigma;
```

Importez les données avec le fichier *enigma.sql*
```
mysql> SOURCE /chemin/du/fichier/enigma.sql.
```

####PhpMyAdmin

Connectez vous avec le même identifiant et mot de passe que MySQL

Créez une base de données sur le menu de gauche en le nommant *enigma*

Il y a deux possibilités pour la suite :

- Sélectionnez *SQL* sur la bar en haut est rentrez le contenu de *enigma.sql*

- Sélectionnez *Import* sur la bar en haut et soumettez le fichier *enigma.sql*

***

Ensuite une fois la BDD installée, a partir de la racine du dossier Enigma, exécutez la commande :
```
vi src/main/resources/application.properties
```
Puis a la ligne 5, après le = entrez l'identifiant de votre BDD.
Ainsi que votre mot de passe a la ligne 6.
Apres avoir cela vous pouvez quitter le fichier en sauvegardant.

### Lancement du site 

Après avoir fini l'installation de la BDD, exécutez la commande 
```
cd src/main/java/com/projetjee/enigma/
```
Puis ouvrez le fichier EnigmaApplication.java avec une application de type VS Code ou IntelliJ IDEA et exécutez le.

Une fois l'application exécuter, ouvrez votre navigateur internet et entrez l'adresse :
```
http://localhost:8081/
```

## Solutions

Pour les solutions aux énigmes, allez lire [SOLUTIONS.md](https://github.com/NobleBa/Enigma/blob/master/SOLUTIONS.md)

## Construit avec

* [Spring](https://spring.io/) - Le framework utilisé
* [Maven](https://maven.apache.org/) - Gestion des dépendances
* [phpMyAdmin](https://www.phpmyadmin.net/) - Gestion des bases de données

## Auteurs

* **Rémi Deprêter** - Création des bases de données et liaisons avec le back-end - [DEPRETER-REMI](https://github.com/DEPRETER-Remi)
* **Ugo Latry** - Back-end - [Ugolty](https://github.com/Ugolty)
* **Raphaël Jeanningros** - Front-end - [NobleBa](https://github.com/NobleBa)
