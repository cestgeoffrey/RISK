import edu.princeton.cs.introcs.StdDraw;
import java.util.*;


public class Game {
	
	Board Plateau = new Board();
	
	public void initialize(int x , int y) {
		StdDraw.setCanvasSize(x, y);
		StdDraw.setXscale(0, x);
		StdDraw.setYscale(0, y);

	}
	
	
	
	public void menu(int x, int y) {
		
		int tictac = 2000 ;  // en ms. tictac/2 = temps d'affichage de chaque image
		boolean Menu1 = true; //bouleen pour savoir quel image est affichee en ce moment
		StdDraw.picture(x/2, y/2, "Menu/Menu1.png");

		while (!StdDraw.isMousePressed()) {
			if (System.currentTimeMillis() % tictac < tictac/2 && !Menu1) {
				StdDraw.picture(x/2, y/2, "Menu/Menu1.png");
				Menu1 = true;
			}
			if(System.currentTimeMillis() % tictac > tictac/2 && Menu1){
				StdDraw.picture(x/2, y/2, "Menu/Menu2.png");
				Menu1 = false;
			}				
		}
		
		StdDraw.picture(x/2, y/2, "Menu/Menu3.png"); //Menu de selection
		int PlayerCount = 0;
		int ActivateAI = 0;
		
		
		while (!StdDraw.isKeyPressed(32)) {
			if (StdDraw.isMousePressed()) {	
				if (this.isBetween(228.0, 407.0, 366.0, 506.0)) {
					PlayerCount = 2;
				}
				if (this.isBetween(387.0, 394.0, 524.0, 535.0)) {
					PlayerCount = 3;
				}
				if (this.isBetween(536.0, 379.0, 678.0, 539.0)) {
					PlayerCount = 4;
				}
				if (this.isBetween(699.0, 359.0, 839.0, 539.0)) {
					PlayerCount = 5;
				}
				if (this.isBetween(868.0, 365.0, 1055.0, 537.0)) {
					PlayerCount = 6;
				}
				if (this.isBetween(265.0, 158.0, 543.0, 280.0)) {
					ActivateAI = 1;
				}
				if (this.isBetween(759.0, 158.0, 1038.0, 281.0)) {
					ActivateAI = 2;
				}
				
				
				//Affichage Dynamique
				if (PlayerCount ==0 || ActivateAI == 0) {					
					StdDraw.picture(x/2, y/2, "Menu/Menu3.png");
				}
				
				if (PlayerCount !=0 && ActivateAI != 0) {
					StdDraw.picture(x/2, y/2, "Menu/Menu4.png");
				}
				switch(PlayerCount) {
				case 2: this.drawRectangle(228.0, 407.0, 366.0, 506.0);
				break;
				case 3: this.drawRectangle(387.0, 394.0, 524.0, 535.0);
				break;
				case 4: this.drawRectangle(536.0, 379.0, 678.0, 539.0);
				break;
				case 5: this.drawRectangle(699.0, 359.0, 839.0, 539.0);
				break;
				case 6: this.drawRectangle(868.0, 365.0, 1055.0, 537.0);
				break;					
				}
				switch(ActivateAI) {
					case 1: this.drawRectangle(265.0, 158.0, 543.0, 280.0);
					break;
					case 2: this.drawRectangle(759.0, 158.0, 1038.0, 281.0);
					break;
					
				}
				if (this.isBetween(487.0, 15.0, 805.0, 135.0 )) {
					if (PlayerCount !=0 && ActivateAI != 0) {
						StdDraw.pause(100);	// isMousePressed n'aime pas quand on lance une methode alors qu'il ne s'est pas encore reset
						this.launch(PlayerCount, ActivateAI);
					}
				}
				StdDraw.pause(100);
			}
		}
		
		
		
		
		
		
	}
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	public void launch(int PlayerCount, int ActivateAI){
		
		this.Plateau.initialize(PlayerCount, ActivateAI);
		while (this.moreThan1Alive()){
			
			for (int playingPlayer=1; playingPlayer <= 6; playingPlayer++) {
				if (this.Plateau.players[playingPlayer-1].alive) {
					this.Plateau.players[playingPlayer-1].reinforcements = this.calculateReinforcements(playingPlayer);
					this.listenPhase1(playingPlayer);
				}
				
					
				
			}
		}
		// TODO Dire qui a gagne
	}
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	public boolean isBetween(double x1, double y1, double x2, double y2) {
		if (StdDraw.mouseX()>x1 && StdDraw.mouseX()<x2 && StdDraw.mouseY()>y1 && StdDraw.mouseY()<y2) {
			return true;
			
		}
		return false;
		//Dans cette fonction, rentrez les coordonnées de votre hitbox.
		//Pour récupérer les coordonnées d'une hitbox facilement, utilisez le code qui convertit vos clicks en coord x et y dans la console
		//cliquez en bas à gauche puis en haut à droite de votre hitbox, puis utilisez dans l'ordre d'affichage dans la console les nombres en
		//argument de la fonction (4 nombres par hitbox si tout est bon)
	}
	
	public void drawRectangle(double x1, double y1, double x2, double y2) {
		StdDraw.rectangle((x1+x2)/2,(y1+y2)/2,(x2-x1)/2,(y2-y1)/2);
	}
	
	public boolean moreThan1Alive() {
		int x = this.Plateau.territories[0].player;
		for (int i=1; i<42; i++) {
			if(this.Plateau.territories[i].player != x) {
				return true;
			}
		}
		return false;
	}
	
	public int calculateReinforcements(int player) {
		int T = 0;//Territoires controles
		int N = 0;//Nombre de territoires par regions controlees
		int M = 0;//Nombre de regiments gagnes en fonction des territoires captures
		int[] territoryPerRegion = {0,0,0,0,0,0};
		for (int i = 0; i<42; i++) {
			if(this.Plateau.territories[i].player == player) {
				T++;
				territoryPerRegion[this.Plateau.territories[i].region-1]++;
			}
		}
		if(territoryPerRegion[0]==9) {
			N = N + 9;
		}
		if(territoryPerRegion[1]==7) {
			N = N + 7;
		}
		if(territoryPerRegion[2]==12) {
			N = N + 12;
		}
		if(territoryPerRegion[3]==4) {
			N = N + 4;
		}
		if(territoryPerRegion[4]==6) {
			N = N + 6;
		}
		if(territoryPerRegion[5]==4) {
			N = N + 4;
		}
		for(int i = 0; i<this.Plateau.players[player-1].recentlyCaptured;i++) {
			M= M + (int )(Math.random()*2); //50% de chance de gagner un regiment
		}
		
		return (T/3)+(N/2)+M; //retourne le nombre de renforts
		
	}
	
	public void listenPhase1(int playingPlayer) {

		//this.Plateau.actualize(2, playingPlayer, 1); //A SUPP
		//CLICKED IN SEA A CHANGER POUR LE CAS OU RENFORT = 0
		
		boolean stillOnPanel = true;
		boolean clickedInSea = true;
		while(Plateau.players[playingPlayer-1].reinforcements != 0) {
			if(StdDraw.isMousePressed()) {
				clickedInSea = true;
				for (int i = 0; i<42 ; i++) {
					if(this.isBetween(Plateau.territories[i].X-28, Plateau.territories[i].Y-28,Plateau.territories[i].X+28 , Plateau.territories[i].Y+28)) {
						if(Plateau.territories[i].player == playingPlayer) {
							this.Plateau.actualize(2, playingPlayer, i+1);
							while(stillOnPanel) {
								stillOnPanel = this.listenReinforcements(playingPlayer, i+1) ;
								this.Plateau.actualize(2, playingPlayer, i+1);
								
								//Si le joueur n'a plus de renforts a attribuer, on lui fait quitter le panel de force
								if(Plateau.players[playingPlayer-1].reinforcements == 0 && this.powerInHand(playingPlayer) == 0 ) {
									stillOnPanel = false;
								}
								//System.out.println(stillOnPanel);
							}
							stillOnPanel = true;
							this.abortRHand(playingPlayer);
							//StdDraw.pause(150);
						}else {
							this.Plateau.actualize(1, playingPlayer, i+1);
							StdDraw.pause(150);
						}
						clickedInSea = false;
						//this.Plateau.actualize(panel, player, territory);
						
					}
				}
				if (this.isBetween(1025.0, 0.0, 1364.0, 669.0)) {
					clickedInSea = false;
				}
				if(clickedInSea) {
					this.Plateau.actualize(0, playingPlayer, 0);
				}
			}
		}
		
		
		
		
		/*double X1=0, X2=0, Y1=0, Y2=0;
		int i = 0;
		
		while (!StdDraw.isKeyPressed(32)) {
			
			if (StdDraw.isMousePressed()) {	
				if(i == 0) {
					i=1;
					X1 = StdDraw.mouseX();
					Y1 = StdDraw.mouseY();
				}else {
					X2 = StdDraw.mouseX();
					Y2 = StdDraw.mouseY();
					System.out.println(X1 +", "+Y1 +", "+X2 +", "+Y2);
					i = 0;
				}
				StdDraw.pause(150);//Pause car isMousePressed reste true pendant qq ms (de trop !)
			}
			//Récupérateur de hitbox V2
		}*/
		
	}
	
	public boolean listenReinforcements( int player , int territory) {
		System.out.println("AH");
		StdDraw.pause(150);
		while(true) {
			if (StdDraw.isMousePressed()) {
				if(this.isBetween(1064.0, 406.0, 1119.0, 461.0)) {
					this.addInRHand(player, 3);
				}
				if(this.isBetween(1162.0, 404.0, 1218.0, 460.0)) {
					this.addInRHand(player, 2);
				}			
				if(this.isBetween(1260.0, 406.0, 1317.0, 462.0)) {
					this.addInRHand(player, 1);
				}	
				if(this.isBetween(1062.0, 322.0, 1117.0, 376.0)) {
					this.addInRHand(player, 3);
				}
				if(this.isBetween(1165.0, 324.0, 1216.0, 377.0)) {
					this.addInRHand(player, 2);
				}
				if(this.isBetween(1262.0, 324.0, 1316.0, 377.0)) {
					this.addInRHand(player, 1);
				}
				if(this.isBetween(1134.0, 209.0, 1245.0, 277.0)) {
					this.abortRHand(player);
				}
				if(this.isBetween(1105.0, 54.0, 1272.0, 107.0)) {
					this.confirmR(player, territory);
				}
				if(this.isBetween(1025.0, 0.0, 1364.0, 669.0) || this.isBetween(Plateau.territories[territory-1].X-28, Plateau.territories[territory-1].Y-28,Plateau.territories[territory-1].X+28 , Plateau.territories[territory-1].Y+28)) {
					return true; //est toujours sur panel ou a clique sur mm territoire, indique à la supermethode de l'appeler a nouveau
				}
				else {
					//System.out.println((Plateau.territories[territory].X-28) + ",  " +(Plateau.territories[territory].Y-28) +", " + (Plateau.territories[territory].X+28) + ", " +  (Plateau.territories[territory].Y+28));
					//System.out.println(StdDraw.mouseX() + " , " + StdDraw.mouseY());
					return false;
				}
			}
			
				
			
			
			
		}
	}
	
	
	
	
	
		//ADD IN REINFORCEMENTS HAND
		//methode qui prend en entree un joueur, l'unité desiree en vue de potentiel attribution de renforts (musketman = 2, canonnier = 1 et horseman = 3)
		//et qui change ou non la main de renforts du joueur (sil il possede assez de renforts)
		public void addInRHand(int player, int unit) {
			
			
			if(this.Plateau.players[player-1].reinforcements >= 1 && unit == 2) {
				this.Plateau.players[player-1].reinforcements --;
				this.Plateau.players[player-1].musketman[0]+=1;
			}
			if(this.Plateau.players[player-1].reinforcements >= 3 && unit == 3) {
				this.Plateau.players[player-1].reinforcements = this.Plateau.players[player-1].reinforcements - 3;
				this.Plateau.players[player-1].horseman[0]+=1;
			}
			if(this.Plateau.players[player-1].reinforcements >= 7 && unit == 1) {
				this.Plateau.players[player-1].reinforcements = this.Plateau.players[player-1].reinforcements - 7;
				this.Plateau.players[player-1].canonnier+=1;
			}
		}
		//Utilisee lorque l'user ne confirme pas les renforts ou clique autre part de la map
		//Met a zero la main du joueur et rembourse les renforts
		public void abortRHand(int player) {
			int powerInHand = this.powerInHand(player);
			this.Plateau.players[player-1].reinforcements += powerInHand;
			this.Plateau.players[player-1].musketman[0] = 0;
			this.Plateau.players[player-1].horseman[0] = 0;
			this.Plateau.players[player-1].canonnier = 0;
		}
		
		public int powerInHand(int player) {
			return this.Plateau.players[player-1].musketman[0]+(3*this.Plateau.players[player-1].horseman[0])+(7*this.Plateau.players[player-1].canonnier);
		}
		//CONFIRM REINFORCEMENTS
		//Assigne les troupes à leur territoire et vide la main du joueur
		//Prend en entree le joueur et l'ID territoire
		public void confirmR (int player, int territory) {
			this.Plateau.territories[territory-1].musketman[0]+= this.Plateau.players[player-1].musketman[0];
			this.Plateau.territories[territory-1].horseman[0]+= this.Plateau.players[player-1].horseman[0];
			this.Plateau.territories[territory-1].canonnier[0]+= this.Plateau.players[player-1].canonnier;
			this.Plateau.players[player-1].musketman[0] = 0;
			this.Plateau.players[player-1].horseman[0] = 0;
			this.Plateau.players[player-1].canonnier = 0;
		}
	
	//Board Plateau = new Board();
	//Plateau.initialize();
	//Plateau.actualize();
	
	
	
}
