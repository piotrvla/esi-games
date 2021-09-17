
#Réponses aux TDs

##TD1

###Q n°1:

1. La position (0.0, 0,0) puis la position apres move, du coup (2.0, 2.0)
2. Il peut y avoir une seule class public dans une meme classe java.
3. Que la classe devrait s'appeler TestPoint et non pas Point
4.

###Q n°2: 
1. Une erreur liée à la lisibilité, c'est-à-dire qu'on essaye d'acceder à un
attribut private qui est uniquement visible dans la classe, elle meme.
2. Le programme affiche "méthode move(int, int)"
3. La visibilité et le type des arguments n'intervient pas à la surdéfinition
des méthodes.

###Q n°3:
1.Que le this devrait etre utilise en premier.
2.
-Car création d'une instance sans arguments en parametres n'est pas possible.
-Car il existe un constructeur par défaut, qui mettra x et y à 0.
3. X et Y sont instanciés à 10 au début, puis apres le move X et Y passe à
 12 et 12

###Q n°4:
1. Trois position differentes du meme cercle.
2. Une seule

###Q n°5:
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




