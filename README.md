# User Service

Ce dépôt contient le microservice **user-service** de l'organisation **9riblek**[cite: 1, 2]. Il est responsable de la gestion des utilisateurs, incluant notamment l'authentification et l'inscription (sign-up / sign-in)[cite: 2].

---

## Stack Technique

* **Langage :** Java 17[cite: 2]
* **Framework :** Spring Boot (Version 3.5.14)[cite: 2]
* **Outil de build :** Maven[cite: 2]
* **Base de données :** Configurée (connexion active)[cite: 2]

---

## Structure du Projet

```text
user-service/
├── .mvn/wrapper/          # Wrapper Maven
├── src/                   # Code source de l'application (Java & ressources)
├── .gitattributes         # Attributs Git
├── .gitignore             # Fichiers ignorés par Git
├── mvnw                   # Script de lancement Maven (Linux/macOS)
├── mvnw.cmd               # Script de lancement Maven (Windows)
└── pom.xml                # Fichier de configuration et dépendances Maven
```

---

## Prérequis

Avant de lancer le projet, assurez-vous d'avoir installé sur votre machine :
* Java Development Kit (JDK) 17[cite: 2]
* Un client Git
* Une base de données configurée (selon les propriétés définies dans `src/main/resources/application.properties` ou `application.yml`)

---

## Installation et Lancement

1. Cloner le dépôt :
   ```bash
   git clone https://github.com/9riblek/user-service.git
   cd user-service
   ```

2. Lancer l'application avec le wrapper Maven :
   * Sur Linux / macOS :
     ```bash
     ./mvnw spring-boot:run
     ```
   * Sur Windows :
     ```cmd
     mvnw.cmd spring-boot:run
     ```

L'application démarrera par défaut sur le port configuré dans vos propriétés Spring Boot.

---

## Auteur

* **ELMIR-Ahmed** — Développement initial et configuration de la structure[cite: 2]
