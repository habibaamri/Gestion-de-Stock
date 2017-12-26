# Gestion-de-Stock
L'application consiste a crée 2 ligne d'accès au stock  une ligne pour la production et l'autre pour la livraison en se basant sur l'architecture Rmi .
Afin de résoudre ce problème j'ai crée 3 interfaces,une global et les 2 autres une pour stokcer des cartons et l'autres pour la livraison.

Pour cela j'ai crée au debut une interface global IStock (cette interface étend Remote)dont la quelle j'ai stocké une variable global NombreMaxStock,et par la suite je vais utiliser cette valeur dans les 2 interfaces LivrasonRemote et IProductionRemote.

Ensuite j'ai déclaré dans l'interface ILivraison 2 méthodes:livrer(int quantité) et une autre pour récupérer la valeur  de la quantité livrer lors d'exécution du programme.
C'est parraille pour l'interface IProduction j'ai utilisé 2 méthode aussi une pour faire le stockage et l'autre pour récupérer la valeur enregistrer dnas le stock.

Après j'ai crée unee classe qui implement l'interface ILivraison dont la quelle j'ai redéfini les 2 méthodes,donc pour la méthod livrer je vais lui passer comme paramètre une valeur et elle va appeller une méthde preLivrer afin de tester si j'ai la possibilité de livrer ou nn,la méthode prélivrer au debut j'ai fait une instance de l'interface IProductioRemote pour récupérer la valeur existe dans le stock, puis je teste si ( la valeur de staock - la valeur ancienne qui est déja livrer + la nouvelle valeur que je veux insérer ) > =0 ,si j'ai encours des cartons à livrer  je  vais incrémenter la valeur L sinon j'affiche un message comme quoi le stock est vide.

Aussi dans le main de cette classe de livraison j'ai fait une instance de L'interface ILivraison afin de publier l'objet dnas l'annuaire,puis je fait appel à la méthode livrer avec une quantité saisi par l'utilisateur dans le console.

Concernant  la classe accesProuction  va me permettre d'incrémenter a chaque fois la valeur de stock tant que la nouvelle valeur de stock +l'ancienne moins la valeur de la livraison(je récupère cette valeur via une instance de l'interface ILivraisonRemote) <Nombre max de place.

Par la suite je lance au debut via termainale Rmiregistry puis les 2 classes en parallèle et j'insère dans la console de stock les valuers à stocker tant que l'entrer != de -1 et aussi pour la livraison.
