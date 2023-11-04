# Enigma

Enigma est un site web interactif vous permettant de résoudre une série d'énigmes plus ou moins farfelues.

## Déploiement

### Installation de la base de données

Nanana jsp c est le travail de Rémi ou Ugo

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