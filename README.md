# Teaching-HEIGVD-AMT-2019-Project-One
## Objectif

L’objectif principal de ce projet est d’appliquer les modèles et les techniques présentés lors des cours et de créer une application simple à plusieurs niveaux dans Java EE.

## Déploiement de l'architecture



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
