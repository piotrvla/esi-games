
#Réponses aux TDs

## TD1

### Q n°1:

1. La position (0.0, 0,0) puis la position apres move, du coup (2.0, 2.0)
2. Il peut y avoir une seule class public dans une meme classe java.
3. Que la classe devrait s'appeler TestPoint et non pas Point
4.

### Q n°2: 
1. Une erreur liée à la lisibilité, c'est-à-dire qu'on essaye d'acceder à un
attribut private qui est uniquement visible dans la classe, elle meme.
2. Le programme affiche "méthode move(int, int)"
3. La visibilité et le type des arguments n'intervient pas à la surdéfinition
des méthodes.

### Q n°3:
1.Que le this devrait etre utilise en premier.
2.
-Car création d'une instance sans arguments en parametres n'est pas possible.
-Car il existe un constructeur par défaut, qui mettra x et y à 0.
3. X et Y sont instanciés à 10 au début, puis apres le move X et Y passe à
 12 et 12

### Q n°4:
1. Trois position differentes du meme cercle.
2. Une seule

### Q n°5:
1. 
-Du coup circle affiche est notre circle instancié au début avec son centre à X 0 Y 0
et son radius instancié à la valeur donné.
-le point du circle est bougé à la position X 2, Y 5 et le centre est le radius est le meme
-Puis en effectuant une copie de la référence d'objet Circle c en assignant la position du centre à un autre objet point. Ceci nous permet de le modifier du coup la position du centre passe à X 0 Y 0, radius reste le meme.

2.Il existe une instance du circle, 2 instances Point, p et p2.p pointe vers la meme référence d'attribut centre du Circle c. Plus contretement p2 pointe vers la reference d'objet p.

3.L'objet p dans ce cas inutile car il n'est pas utilisé du tout. Une nouvelle instance est crée dans le constructeur. Objet p2 copie son référence comme précedemment.

4. Maintenant il n'affiche toujours la position X 0 Y 0 pour chaque sout du circle.
Il n'est que possible de move le circle en utilisant la méthode de la classe.

5.
-Il n'y a qu'une seule instance Circle, tandis que il y a 3 instances crées pendant l'éxecution du programme
-p référence toujours sa position de départ c-à-d X 0 Y 0 tandis que p2 n'est qu'une copie du centre d circle.
-L'attribut center référence un nouveau point avec les valeurs de X et Y du point p.

# TD 2 - Héritage, polymorphisme


## Question 1:

### #N°1:

- Le programme affiche grace à la méthode toString la position du point coloré et sa couleur.

#### N°2:

- Point p n'a pas d'acces aux méthodes d'enfants, meme si son constructeur a était utilisé lors d'instanciation.

#### N°3:

- Non, car il s'agit d'une instanciation dans le mauvais sens.

### N°4: 

- Non, car la classe ColoredPoint en elle meme ne possede pas d'attributs X et Y, du coup c'est nécessaire de faire appel avec un mot-clé "super" aux attributs de la classe parent.

### N°5:

- Manque de sens, Point ne peut pas etre au meme temps parent et enfant de la classe ColoredPoint. Héritage est representé en tant qu'une arbre et non pas un cycle.

### N°6
 
- Il est impossible d'hériter d'une classe finale, mais une classe finale peut ériter d'une autre.



## Question 2

### N°1

- Oui, car tout les classes héritent de la classe Object.

### N°2

- Pareil pour la classe ColoredPoint, c'est une classe enfant de la classe Object.

### N°3

- Méthode hashCode est défini dans la classe parent de tout les classes, c'est-àdire dans la classe Object.

## Question 3:

### N°1 

- Parce que l'appel au mot-clé super doit se faire en premier lieu.

### N°2

- Super fait appel au constructeur de la classe parent, si on supprime ce super, aucun appel au constructeur n'aura lieu.

### N°3

- Non, la classe ColoredPoint fera appel au constructeur sans parametres de la classe parent, c-à-d classe Point.

## Question 4:

### N°1
 
- Le programme affiche les 3 messages se trouvant dans le constructeur.

### N°2

- Affiche seulement les 2 messages, c'est-à-dire du constructeur classe A et B, car par défaut il fait appel au constructeur de la classe parent.

### N°3

- On obtient le meme résultat que précedemment, super() fera un appel au constructeur de la classe B, classe B à la classe A et la classe A au constructeur de la classe Object.

### N°4

- 

## Question 5: 

### N°1:

- Programme affiche  

### N°2: 

- Méthode move de la classe PinnablePoint est utilisé car l'objet est déclaré comme un objet PinnablePoint.

### N° 3

- Que la méthode de la classe parent n'a pas d'exception.

### N° 4

### TD 3 - Questions

## Question 1

# 1.1:
La taille de fenetre est modifié

# 1.2:
Le texte est transparant, autrement dit invisible.
-DECORATED
-UNDECORATED
-TRANSPARENT
-UTILITY

# 1.3:
Le texte se déplace sur la fenetre selon la méthode appelé.

## Question 2:

# 2.1:
Au début 1er checkbox est coché par défaut et peut etre décoché.
2eme est neutre, peut etre coché et décoché.
3eme est indeterminé et peut etre coché et décoché.

# 2.2:
Les checkbox ne seront plus alignés.

## Question 3:

# 3.1:
Le texte entré dans le champ est masqué par des étoiles.

# 3.2:
Apres avoir appuyé sur la touche enter, le texte inséré dans le champ n'est plus modifiable.

## Question 4:

Apres avoir appuyé sur le button, le texte inséré dans le champ est géré par la méthode handle qui reçois l'evenement en parametres et l'affiche dans la console.
## Question 5:

la méthode getChildren() retourne une liste de Node. Cette peut etre utiliser pour obtenir les composants de la classe enfant.

## Question 6:

# 6.2: 
Oui, cela est possible. addAll() permet de ajouter plusieurs compossants au meme temps.

# 6.3:
Il y a une méthode qui peut empecher ceci: setVgrow()

## Question 7:

# 7.1:
? ?
# 7.2:
Le texte du label est centré entre la bordure de la fenetre et le champ de texte.
# 7.3:
Le champ de texte de mot de passe est repartie sur toute la longeur de la fenetre.






