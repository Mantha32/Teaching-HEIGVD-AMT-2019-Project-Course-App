# Teaching-HEIGVD-AMT-2019-Project-One
## Présentation

Planing est une appli web de gestion de l'emploi de temps d'une filiere de l'universite mais aussi la gestion des ressources
telles ques (les salle, les enseignants, les cours).

## Déploiement de l'architecture

* avoir le Xampp appache, intelliji, maven instalés sur votre ordinateur 
* Cloner le repos
* Créer et import la base de données sur phpmyadmin
* lancer Xampp appache en local et aller dans manageServers start MysqlDatabse et Apache Web Server
* Impot le projet depuis intelliji et configurer Jboss Server
* il reste plus qu'à le compiler et l'interface de l'application s'ouvrira sur chrome 
* vous pouvez vous loguer en tant que admin avec pour username: doriane et passeword: 12345


## Implémentation 
Routes et les opérations:

/Authentification : Permet à un utilisateur de se login

/logout : Permet à un utilisateur de fermer sa session donc se déconnecter

/courses: CRUD sur les cours

/lectures : CRUD sur les lectures

/roles : CRUD sur les rôles

/users : CRUD sur les user

/times : Consulter les planning

Concernant l'autehnfication, nous avons utiliser la méthode session.setAttribute pour l'utilisateur connecté. Nous avons utilisé l'algorithme Sha255.

Nous avons utilisé le filtre AuthFilter pour empêcher l’accès aux ressources sans être connecté au préalable. Bootstrap/sb-admin pour les UI et fullcalendar pour le calendrier.
