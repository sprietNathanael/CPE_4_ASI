# TP ASI - Atelier 2

## Membres du groupe

Thomas Descroix
Étienne Durousset
Basile Pracca
Florian Sanchis
Nathanaël Spriet

## Rendu

### Authentification

Le système d'authentification repose sur un échange de token entre le client javascript et le serveur Java. À la connexion, le serveur génère un token qu'il conserve en base de données et qu'il renvoie au client. 
Le client le conserve en session et demande au serveur de le tester à chaque page. Si le token n'est pas valide, il redirige l'utilisateur sur la page de connexion.

### Done 
Création utilisateur
Login 
Logout (au click sur l'icône de l'utilisateur à côté de son nom) 
Authentification avec token
Modification de la BDD pour prendre en compte le prix d'une carte et le cash d'un user (cf. SQL file)
Création d'une RequestMapping pour récupérer les cartes d'un user (id passé en param)
Redirection des vues front end 
Affichage du login du user après connexion 
Message d'erreur sur la page de connexion si user/pass faux
Création d'une contrainte d'unicité sur le couple surname/password pour rendre unique le user


