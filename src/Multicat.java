import extensions.File;
import extensions.CSVFile;

class Multicat extends Program {

    final String FICHIER = "ressources/Scoreboard.csv";
    final int NBPARTIES = 5;
    final String TITRE = "ressources/Titre.txt";

    int random(int min, int max){
        return (int) (random()*(max-min)+min);
    }
    //Retourne un entier aléatoire compris entre une borne min et une borne max

    void testValidation(){
        assertEquals(true, validation("56"));
        assertEquals(false, validation("4g5"));
        assertEquals(false, validation(""));
        assertEquals(false, validation("gre"));
    }
    
    boolean validation(String rep){
        if (length(rep)==0){
            return false;
        }
        boolean nbOnly = true;
        int cpt = 0;
        while(cpt<length(rep) && nbOnly){
            char c = charAt(rep,cpt);
            if(c<='9' && c>='0'){
                cpt++;
            }else{
                nbOnly=false;
            }
        }
        return nbOnly;
    }
    //Permet de savoir si une chaîne de caractère est uniquement constituée de chiffres

    int propositionEleve(){
        String rep = readString();
        while(!validation(rep)){
            println("Entre uniquement des chiffres ! Recommence : ");
            rep = readString();
        }
        return stringToInt(rep);
    }
    //Permet de saisir la réponse aux questions et de vérifier si la saisie est correcte, si elle est incorrecte = redemande à l'élève de saisir une réponse valide

    Joueur newJoueur(String prenom, String nom){
        Joueur j = new Joueur();
        j.prenom = prenom;
        j.nom = nom;
        j.score = 0;
        j.nombreParties = 0; 
        return j;
    }
    //Création d'un nouveau Joueur ==> permet de créer un nouveau profil de joueur si celui-ci n'est pas trouvé dans le fichier CSV


    void niveau1(Joueur j){
        int score=0;
        int rep;

        for(int i=0;i<NBPARTIES;i++){
            int valeur1=random(0,11);
            int valeur2=random(0,11);

            multicat();
            delayMot("Combien font "+valeur1+"x"+valeur2+" ?");
            pseudo(j.prenom);
            rep=propositionEleve();
            if(rep!=valeur1*valeur2){
                multicat();
                delayMot("Mince ce n'est pas la bonne solution... Tu as le droit à un nouvel essai :");
                pseudo(j.prenom);
                rep=propositionEleve();
                if(rep==valeur1*valeur2){
                    multicat();
                    delayMot("Bonne réponse ! \n");
                    score++;
                }else{
                    multicat();
                    delayMot("Encore raté ! La bonne réponse était : "+(valeur1*valeur2)+"\n");
                }
            }else if(rep==valeur1*valeur2){
                multicat();
                delayMot("Bonne réponse ! \n");
                score++;
            }
        }

        j.score=j.score+score;
        j.nombreParties++;

        println("--------------------------------------------");
        multicat();
        delayMot("Ton score est de "+score+"/"+NBPARTIES+".");
        println();
        resultat(score); 

        multicat();
        delayMot("Voici ton profil mis à jour (Prénom, Nom, Score, Nombre de parties) : "+j.prenom+", "+j.nom+", "+j.score+", "+j.nombreParties+"\n");
    }
 
    void niveau2(Joueur j){
        int score=0;
        int rep;

        for(int i=0;i<NBPARTIES;i++){
            int valeur1 = random(10,100);
            int valeur2 =random(0,11);

            multicat();
            delayMot("Combien font "+valeur1+"x"+valeur2+" ?");
            pseudo(j.prenom);
            rep=propositionEleve();
            if(rep!=valeur1*valeur2){
                multicat();
                delayMot("Mince ce n'est pas la bonne solution... Tu as le droit à un nouvel essai :");
                pseudo(j.prenom);
                rep=propositionEleve();
                if(rep==valeur1*valeur2){
                    multicat();
                    delayMot("Bonne réponse ! \n");
                    score++;
                }else{
                    multicat();
                    delayMot("Encore raté ! La bonne réponse était : "+(valeur1*valeur2)+"\n");
                }
            }else if(rep==valeur1*valeur2){
                multicat();
                delayMot("Bonne réponse ! \n");
                score++;
            }
        }

        j.score=j.score+score;
        j.nombreParties++;

        println("--------------------------------------------");
        multicat();
        delayMot("Ton score est de "+score+"/"+NBPARTIES+".");
        println();
        resultat(score);

        multicat();
        delayMot("Voici ton profil mis à jour (Prénom, Nom, Score, Nombre de parties) : "+j.prenom+", "+j.nom+", "+j.score+", "+j.nombreParties+"\n");
    }

    void niveau3(Joueur j){
        int score=0;
        int rep;

        for(int i=0;i<NBPARTIES;i++){
            int valeur1 = random(10,100);
            int valeur2=random(10,100);

            multicat();
            delayMot("Combien font "+valeur1+"x"+valeur2+" ?");
            pseudo(j.prenom);
            rep=propositionEleve();
            if(rep!=valeur1*valeur2){
                multicat();
                delayMot("Mince ce n'est pas la bonne solution... Tu as le droit à un nouvel essai :");
                pseudo(j.prenom);
                rep=propositionEleve();
                if(rep==valeur1*valeur2){
                    multicat();
                    delayMot("Bonne réponse !\n");
                    score++;
                }else{
                    multicat();
                    delayMot("Encore raté ! La bonne réponse était : "+(valeur1*valeur2)+"\n");
                }
            }else if(rep==valeur1*valeur2){
                multicat();
                delayMot("Bonne réponse !\n");
                score++;
            }
        }

        j.score=j.score+score;
        j.nombreParties++;

        println("--------------------------------------------");
        multicat();
        delayMot("Ton score est de "+score+"/"+NBPARTIES+".");
        println();
        resultat(score);

        multicat();
        delayMot("Voici ton profil mis à jour (Prénom, Nom, Score, Nombre de parties) : "+j.prenom+", "+j.nom+", "+j.score+", "+j.nombreParties+"\n");
    }

    void niveau4(Joueur j){
        int score=0;
        int rep;

        for(int i=0;i<NBPARTIES;i++){
            int valeur1 = random(100,1000);
            int valeur2=random(10,100);

            multicat();
            delayMot("Combien font "+valeur1+"x"+valeur2+" ?");
            pseudo(j.prenom);
            rep=propositionEleve();
            if(rep!=valeur1*valeur2){
                multicat();
                delayMot("Mince ce n'est pas la bonne solution... Tu as le droit à un nouvel essai :");
                pseudo(j.prenom);
                rep=propositionEleve();
                if(rep==valeur1*valeur2){
                    multicat();
                    delayMot("Bonne réponse !\n");
                    score++;
                }else{
                    multicat();
                    delayMot("Encore raté ! La bonne réponse était : "+(valeur1*valeur2)+"\n");
                }
            }else if(rep==valeur1*valeur2){
                multicat();
                delayMot("Bonne réponse !\n");
                score++;
            }
        }

        j.score=j.score+score;
        j.nombreParties++;

        println("--------------------------------------------");
        multicat();
        delayMot("Ton score est de "+score+"/"+NBPARTIES+".");
        println();
        resultat(score);

        multicat();
        delayMot("Voici ton profil mis à jour (Prénom, Nom, Score, Nombre de parties) : "+j.prenom+", "+j.nom+", "+j.score+", "+j.nombreParties+"\n");
    }

    

    
    void delayMot (String chaine){ 
        char c;
        for ( int i =0 ; i<length(chaine); i++){
            c = charAt(chaine,i); 
            delay(50); 
            print(c);
        }
        println();
    }
    //Procédure pour afficher au fur et à mesure le texte (seulement esthetique)

    void multicat(){ 
        print(ANSI_PURPLE+"Multicat : "+ANSI_RESET);
    }
    void pseudo(String prenom){
        print(ANSI_GREEN+prenom+" : "+ANSI_RESET);
    }
    //Procédures affichant en couleur le joueur et le personnage du jeu (seulement esthétique)

    void choixNiveau (Joueur j){
        multicat(); 
        delayMot("Choisis le niveau de ton choix : \n 1. Niveau 1 (Facile)  \n 2. Niveau 2 (Moyen) \n 3. Niveau 3 (Difficile) \n 4. Niveau 4 (Expert)"); 
        int rep =propositionChoixNiveau(); 
        clearScreen();
        if ( rep==1){
            niveau1(j);
        }
        if (rep==2){
            niveau2(j);
        }
        if (rep==3){
            niveau3(j);
        }
        if(rep==4){
            niveau4(j);
        }
    }
    //Procédure permettant à l'utilisateur de choisir le niveau de son choix ==> à associer avec les fonctions validationChoixNiveau et propositionChoixNiveau

        void testValidationChoixNiveau(){
        assertEquals(true, validationChoixNiveau("1"));
        assertEquals(true, validationChoixNiveau("2"));
        assertEquals(true, validationChoixNiveau("3"));
        assertEquals(true, validationChoixNiveau("4"));
        assertEquals(false, validationChoixNiveau("4g45"));
        assertEquals(false, validationChoixNiveau(""));
        assertEquals(false, validationChoixNiveau("15"));
    }
    boolean validationChoixNiveau(String rep){
        if (length(rep)==0 || length(rep)>1){
            return false;
        }

        boolean choixValide = false;
        char c = charAt(rep, 0);
        if(length(rep)==1){
            if(c>='1' && c<='4'){
                choixValide=true;
            }
        }
        return choixValide;
    }
    //Vérifie que la saisie est constitué d'entier compris entre 1 et 4 inclus

    int propositionChoixNiveau(){
        String rep = readString();
        while(!validationChoixNiveau(rep)){
            println("Seuls les chiffres \"1\", \"2\", \"3\" et \"4\" sans espace sont valides : ");
            rep = readString();
        }
        return stringToInt(rep);
    }
    //Permet de saisir le chiffre correspondant au choix fait, de vérifier l'entrée, et de demander une correction de saisie si nécessaire

    


    void resultat (int score ){ 
        multicat();
        afficherChat(score);
    }
    //Permet au personnage du jeu d'afficher le "chat récompense" correspondant au score obtenu 


    void afficherChat(int score){
            extensions.File file = newFile("ressources/AsciiArt/chat"+score+".txt");
            println();
            while (ready(file)) {
            String line = readLine(file);
            println(line);
            }
            println();
    }
    //Affiche les chats en fonction du score obtenu

    void afficherTitre(){
        extensions.File file = newFile(TITRE);
        while (ready(file)) {
            String line = readLine(file);
            println(ANSI_PURPLE_BG+line+ANSI_RESET);
        }
        println();
    }
    //Affiche le titre du jeu (au début et à la fin)

    void quizz(Joueur j){
        multicat();
        delayMot("Bonjour, c'est toi "+j.prenom+" ?");
        multicat();
        delayMot("Es tu prêt.e à relever mon défi ?");
        multicat();
        delayMot("\n 1. Oui, je suis paré.e ! \n 2. Non, pas vraiment...");
        pseudo(j.prenom);
        int pret = propositionChoix();

        if(pret==1){
            multicat();
            delayMot("Alors c'est parti ! \n");
            delay(800);
        }else{
            multicat();
            delayMot("Non ? Alors pourquoi es-tu venu.e jouer avec moi ?");
            multicat();
            delayMot("Aucun retour en arrière n'est possible, c'est parti pour le défi ! \n");
            delay(800);
        }
        clearScreen();
        choixNiveau(j);

        boolean poursuite=false;
        multicat();
        delayMot("Veux-tu tester un autre niveau ? \n 1. Oui \n 2. Non "); 
        int rep= propositionChoix();
        if ( rep==1){
            poursuite=true;;
        }else {
            multicat();
            delayMot("Merci d'avoir joué avec moi ! A bientôt !");
        }
        while(poursuite){
            choixNiveau(j);
            multicat();
            delayMot("Veux-tu tester un autre niveau ? \n 1. Oui \n 2. Non "); 
            rep= propositionChoix();
            if ( rep==2){
                poursuite=false;
                multicat();
                delayMot("Merci d'avoir joué avec moi ! A bientôt !");
            }
        }
    }
    //Permet de lancer le jeu pour les élèves 

    int propositionChoix(){
        String rep = readString();
        while(!validationChoix(rep)){
            println("Seuls les chiffres \"1\" ou \"2\" sans espace sont valides : ");
            rep = readString();
        }
        return stringToInt(rep);
    }
    //Permet de saisir le chiffre correspondant au choix fait, de vérifier l'entrée, et de demander une correction de saisie si nécessaire

    void testValidationChoix(){
        assertEquals(true, validationChoix("1"));
        assertEquals(true, validationChoix("2"));
        assertEquals(false, validationChoix("4g5"));
        assertEquals(false, validationChoix(""));
        assertEquals(false, validationChoix("15"));
    }
    boolean validationChoix(String rep){
        if (length(rep)==0 || length(rep)>1){
            return false;
        }

        boolean choixValide = false;
        char c = charAt(rep, 0);
        if(length(rep)==1){
            if(c=='1' || c=='2'){
                choixValide=true;
            }
        }
        return choixValide;
    }
    //Vérifie que la saisie est soit 1, soit 2



    String[][] CSVtoTab(String nomFichier){
        CSVFile fichier = loadCSV(nomFichier);
        String[][] tab = new String [rowCount(fichier)+1][columnCount(fichier)];
        for(int i=0;i<length(tab,1)-1;i++){
			for(int j=0;j<length(tab,2);j++){
				tab [i][j]=getCell(fichier, i, j);
			}
		}
        return tab;
    }
    //Permet de convertir le ficher CSV en tableau de String à 2 dimensions

    void afficherScoreboard(String[][] tab){
        for(int i=0;i<length(tab,1)-1;i++){
			for(int j=0;j<length(tab,2);j++){
				print(tab [i][j]+" ");
			}
            println();
		}        
    }
    //Permet l'affichage du fichier CSV dans le terminal

    void enregistrementScoreboard(Joueur j, String [][] scoreboard){
        int cpt=1;
        boolean eleveTrouve = false;

        while(cpt<length(scoreboard,1) && !eleveTrouve){
            if(equals(j.prenom, scoreboard[cpt][0])){
                if(equals(j.nom, scoreboard[cpt][1])){
                    eleveTrouve=true;
                    scoreboard[cpt][2]=""+j.score; 
                    scoreboard[cpt][3]=""+j.nombreParties;
                }
            }else{
                cpt++;
            }
        }
        
        if(!eleveTrouve){
            scoreboard[length(scoreboard)-1][0]=j.prenom;
            scoreboard[length(scoreboard)-1][1]=j.nom;
            scoreboard[length(scoreboard)-1][2]=""+j.score;
            scoreboard[length(scoreboard)-1][3]=""+j.nombreParties;
        }
        saveCSV(scoreboard, FICHIER);
    }
    //Enregistre les données du joueur sur le CSV 

    void afficherRegles(){
        multicat();
            delayMot("Veux tu connaître les règles du jeu ? \n1. Oui \n2. Non");
            pseudo("?");
            int regles = propositionChoix();
            if(regles==1){
                multicat();
                delayMot("Le but du jeu est de répondre à mes questions !");
                multicat();
                delayMot("Plus tu me donneras de bonnes réponses, plus tu auras la chance de rencontrer le \"SuperChat\" ! (score de 5/5)");
                multicat();
                delayMot("Tu as le droit d'utiliser une feuille de brouillon pour t'aider.");
                multicat();
                delayMot("Les questions que je vais te poser sont sur les tables de multiplication ! Révise bien avant de commencer...");
            }else if(regles!=1){
                multicat();
                println("Si tu connais les règles, alors commençons...");
            }
    }
    //Affiche les règles pour l'élève

    Joueur rechercheJoueur(String prenom, String nom, String[][] scoreboard){
            Joueur j =newJoueur(prenom,nom);

            boolean eleveTrouve = false;
            int cpt = 1;
            
            while(cpt<length(scoreboard,1) && !eleveTrouve){
                if(equals(prenom, scoreboard[cpt][0])){
                    if(equals(nom, scoreboard[cpt][1])){
                        eleveTrouve=true; 
                    }else{
                        cpt++;
                    }
                }else{
                    cpt++;
                }
            }
            
            if(eleveTrouve){
                j.score=stringToInt(scoreboard[cpt][2]);
                j.nombreParties=stringToInt(scoreboard[cpt][3]); 
            }else{
                j = newJoueur(prenom, nom); 
            }
            return j;
    }
    //Permet de récupérer les données d'un joueur déjà inscrit, ou de créer un nouveau joueur

    void moyenneEleve(String prenom, String nom, String[][] scoreboard){
            Joueur j =newJoueur(prenom,nom);

            boolean eleveTrouve = false;
            int cpt = 1;
            
            while(cpt<length(scoreboard,1) && !eleveTrouve){
                if(equals(prenom, scoreboard[cpt][0])){
                    if(equals(nom, scoreboard[cpt][1])){
                        eleveTrouve=true; 
                    }else{
                        cpt++;
                    }
                }else{
                    cpt++;
                }
            }
            
            if(eleveTrouve){
                j.score=stringToInt(scoreboard[cpt][2]);
                j.nombreParties=stringToInt(scoreboard[cpt][3]); 
                delayMot(ANSI_CYAN+"Nom : "+j.nom+"\nPrénom : "+j.prenom+"\nScore : "+j.score+"\nNombre de parties : "+j.nombreParties+ANSI_RESET);
                println();
                delayMot(ANSI_CYAN+"La moyenne de l'élève est de "+j.score/j.nombreParties+"/5 (Score/Nombre de parties).\nMerci, à bientôt.\n"+ANSI_RESET);
            }else{
                delayMot(ANSI_CYAN+"\nL'élève n'est pas enregistré.e\nMerci, à bientôt.\n"+ANSI_RESET); 
            }  
    }
    //Recherche l'élève dans le tableau, si l'élève est trouvé : réalise la moyenne en prenant en compte Score et NbParties, sinon renvoie un message d'erreur

    void algorithm(){
        afficherTitre();
        String [][] scoreboard = CSVtoTab(FICHIER);

        multicat();
        delayMot("Es-tu ? \n 1. ELEVE \n 2. PROFESSEUR");
        pseudo("?");
        int eOUp = propositionChoix();
        
        
        //Affichage pour prof du scoreboard des élèves et de la moyenne d'un élève choisi ==>> 
        if(eOUp==2){
            println();
            delayMot(ANSI_RED+"Tableau des scores des élèves :\n"+ANSI_RESET);
            afficherScoreboard(scoreboard);
            delayMot(ANSI_CYAN+"\nSouhaitez-vous connaître la moyenne d'un.e élève ? \n 1. Oui \n 2. Non"+ANSI_RESET);
            int repProf = propositionChoix();
            if(repProf==1){
                delayMot(ANSI_CYAN+"Prénom de l'élève (sans espace) : "+ANSI_RESET);
                String preEleve = readString();
                delayMot(ANSI_CYAN+"Nom de l'élève (sans espace) : "+ANSI_RESET);
                String nomEleve = readString();
                println();
                moyenneEleve(preEleve,nomEleve,scoreboard);
            }else if(repProf==2){
                delayMot(ANSI_CYAN+"Merci, à bientôt.\n"+ANSI_RESET);
            }
        //Détermination du profil de l'élève + lancement quizz ==>>
        }else if(eOUp==1){
            afficherRegles();
            multicat();
            delayMot("Entre ton prénom (sans espace): ");
            String prenom = readString();
            multicat();
            delayMot("Entre ton nom (sans espace): ");
            String nom = readString();
            Joueur j=rechercheJoueur(prenom,nom, scoreboard);
            
            multicat();
            delayMot("Voici ton profil (Prénom, Nom, Score, Nombre de parties) : "+j.prenom+", "+j.nom+", "+j.score+", "+j.nombreParties+"\n");
            quizz(j);

            //enregistrement scoreboard ==>
            enregistrementScoreboard(j, scoreboard);

            println();
        }
        afficherTitre();
    } 
      
}