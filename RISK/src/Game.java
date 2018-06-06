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
					//this.listenPhase1(playingPlayer);
					//this.listenPhase2(playingPlayer);
					double X1=0, X2=0, Y1=0, Y2=0;
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
					}
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
	
	public void listenPhase2(int playingPlayer) {
		int orderFeedback = 100;// code 100 = continuer d'ecouter le panel de commande des ordres, code 1 - 42 = declencher un mouvement de troups vers 
		//ce numero de territoire, code 0 = cesser d'ecouter le panel d'ordres, code 101 passer le tour du joueur
		boolean clickedInSea = true;
		boolean continu = true;//reste vrai tant que le joueur n'a pas passé son tour
		while(continu) {
			if(StdDraw.isMousePressed()) {
				clickedInSea = true;
				for (int i = 0; i<42 ; i++) {
					if(this.isBetween(Plateau.territories[i].X-28, Plateau.territories[i].Y-28,Plateau.territories[i].X+28 , Plateau.territories[i].Y+28)) {
						if(Plateau.territories[i].player == playingPlayer) {
							this.Plateau.actualize(4, playingPlayer, i+1);
							while(orderFeedback == 100) {
								orderFeedback = this.listenOrders(playingPlayer, i+1) ;
								this.Plateau.actualize(4, playingPlayer, i+1);
								//////////////!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
								
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
	}
	
	public int listenOrders( int player , int territory) {
		StdDraw.pause(150);
		while(true) {
			if (StdDraw.isMousePressed()) {
				if(this.isBetween(1062.0, 451.0, 1117.0, 507.0)) {
					//this.addInRHand(player, 3);
				}
				if(this.isBetween(1161.0, 450.0, 1217.0, 506.0)) {
					//this.addInRHand(player, 2);
				}			
				if(this.isBetween(1260.0, 452.0, 1316.0, 506.0)) {
					//this.addInRHand(player, 1);
				}
				if(this.isBetween(1065.0, 378.0, 1120.0, 432.0)) {
					//this.addInRHand(player, 3);
				}
				if(this.isBetween(1164.0, 378.0, 1216.0, 434.0)) {
					//this.addInRHand(player, 2);
				}
				if(this.isBetween(1262.0, 378.0, 1317.0, 432.0)) {
					//this.addInRHand(player, 1);
				}
				
				//PREMIERE PARTIE ^
				
				if(this.isBetween(1063.0, 311.0, 1083.0, 335.0)) {
					this.substractHand(player, 3, 2, territory);
				}
				if(this.isBetween(1090.0, 278.0, 1118.0, 311.0)) {
					this.addHand(player, 3, 2, territory);
				}
				if(this.isBetween(1161.0, 314.0, 1189.0, 334.0)) {
					this.substractHand(player, 2, 1, territory);
				}
				if(this.isBetween(1191.0, 280.0, 1217.0, 308.0)) {
					this.addHand(player, 2, 1, territory);
				}
				if(this.isBetween(1260.0, 308.0, 1286.0, 333.0)) {
					this.substractHand(player, 1, 0, territory);
				}
				if(this.isBetween(1292.0, 278.0, 1317.0, 311.0)) {
					this.addHand(player, 1, 0, territory);
				}
				
				//1 PT MVT ^
				
				if(this.isBetween(1063.0, 237.0, 1091.0, 263.0)) {
					this.substractHand(player, 3, 1, territory);
				}
				if(this.isBetween(1090.0, 209.0, 1117.0, 238.0)) {
					this.addHand(player, 3, 1, territory);
				}
				if(this.isBetween(1161.0, 238.0, 1185.0, 262.0)) {
					this.substractHand(player, 2, 0, territory);
				}
				if(this.isBetween(1188.0, 208.0, 1218.0, 237.0)) {
					this.addHand(player, 2, 0, territory);
				}
				
				//2 PT MVT ^
				
				if(this.isBetween(1062.0, 166.0, 1089.0, 192.0)) {
					this.substractHand(player, 3, 0, territory);
				}
				if(this.isBetween(1089.0, 135.0, 1118.0, 167.0)) {
					this.addHand(player, 3, 0, territory);
				}
				
				//3 PT MVT ^
				
				if(this.isBetween(1225.0, 22.0, 1329.0, 78.0)) {
					return 101; //Le joueur choisit de terminer son tour, indique à la supermethode de stopper l'ecoute de la phase 2
				}
				
				//PASSE ^
				
				for (int i = 0; i<42 ; i++) {
					if(this.isBetween(Plateau.territories[i].X-28, Plateau.territories[i].Y-28,Plateau.territories[i].X+28 , Plateau.territories[i].Y+28)) {
						if(i+1 == territory) {
							return 100; //le joueur a juste reclicke sur son territoire, on garde le panel intact
						}else {
							
						}
						return i+1; // retourne l'id du territoire recepteur d'une attaque ou d'un mouvement de troupes
					}
				}
				
				
				if(this.isBetween(1025.0, 0.0, 1364.0, 669.0)) {
					return 100; //est toujours sur panel ou a clique sur mm territoire, indique à la supermethode de l'appeler a nouveau
				}
				else {
					//System.out.println((Plateau.territories[territory].X-28) + ",  " +(Plateau.territories[territory].Y-28) +", " + (Plateau.territories[territory].X+28) + ", " +  (Plateau.territories[territory].Y+28));
					//System.out.println(StdDraw.mouseX() + " , " + StdDraw.mouseY());
					return 0;//indique a la supermethode de cesser le while
				}
			}
			
				
			
			
			
		}
	}
	
	public void addHand(int player, int unit, int mvt, int territory) {
		//mvt = points de mouvements deja consommes par l'unite
		//territory = territoire de départ de l'unite
		//unit = type d'unite, 1 = canonnier 2 = musketman 3 = horseman
		if (unit == 1) {
			if(this.Plateau.territories[territory-1].canonnier[mvt]>0) {
				this.Plateau.territories[territory-1].canonnier[mvt]--;
				this.Plateau.players[player-1].canonnier++;
			}
		}
		if (unit == 2) {
			if(this.Plateau.territories[territory-1].musketman[mvt]>0) {
				this.Plateau.territories[territory-1].musketman[mvt]--;
				this.Plateau.players[player-1].musketman[mvt]++;
			}
		}
		if (unit == 3) {
			if(this.Plateau.territories[territory-1].horseman[mvt]>0) {
				this.Plateau.territories[territory-1].horseman[mvt]--;
				this.Plateau.players[player-1].horseman[mvt]++;
			}
		}
		
	}
	public void substractHand(int player, int unit, int mvt, int territory) {
		//mvt = points de mouvements deja consommes par l'unite
		//territory = territoire de départ de l'unite
		//unit = type d'unite, 1 = canonnier 2 = musketman 3 = horseman
		if (unit == 1) {
			if(this.Plateau.players[player-1].canonnier>0) {
				this.Plateau.players[player-1].canonnier--;
				this.Plateau.territories[territory-1].canonnier[mvt]++;
			}
		}
		if (unit == 2) {
			if(this.Plateau.players[player-1].musketman[mvt]>0) {
				this.Plateau.players[player-1].musketman[mvt]--;
				this.Plateau.territories[territory-1].musketman[mvt]++;
			}
		}
		if (unit == 3) {
			if(this.Plateau.players[player-1].horseman[mvt]>0) {
				this.Plateau.players[player-1].horseman[mvt]--;
				this.Plateau.territories[territory-1].horseman[mvt]++;
			}
		}
		
	}
	public void clearHand(int player) {
		this.Plateau.players[player-1].canonnier = 0;
		this.Plateau.players[player-1].musketman[0] = 0;
		this.Plateau.players[player-1].musketman[1] = 0;
		this.Plateau.players[player-1].horseman[0] = 0;
		this.Plateau.players[player-1].horseman[1] = 0;
		this.Plateau.players[player-1].horseman[2] = 0;
	}
	
	public void abortHand(int player, int territory) {
		this.Plateau.territories[territory-1].canonnier[0] = this.Plateau.players[player-1].canonnier;
		this.Plateau.territories[territory-1].musketman[0] = this.Plateau.players[player-1].musketman[0];
		this.Plateau.territories[territory-1].musketman[1] = this.Plateau.players[player-1].musketman[1];
		this.Plateau.territories[territory-1].horseman[0] = this.Plateau.players[player-1].horseman[0];
		this.Plateau.territories[territory-1].horseman[1] = this.Plateau.players[player-1].horseman[1];
		this.Plateau.territories[territory-1].horseman[2] = this.Plateau.players[player-1].horseman[2];
		this.clearHand(player);
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
		public int move(int player, int territory, int target ) {
			
			
			
			
			
			int DEFmusketman = this.Plateau.territories[target-1].getMusketman();
			int ATKhorseman = this.Plateau.players[player-1].horseman[0]+this.Plateau.players[player-1].horseman[1]+this.Plateau.players[player-1].horseman[2];
			int DEFhorseman = this.Plateau.territories[target-1].getHorseman();
			int[] ATK = new int[3];
			int[] DEF = new int[3];
			ATK[0]= ATKhorseman;
			ATK[1]= ATKmusketman;
			ATK[2]= ATKcanonnier;
			DEF[0]= DEFmusketman;
			DEF[1]= DEFcanonnier;
			DEF[2]= DEFhorseman;
			int attackerCode = 0;
			int defenserCode = 0;
			boolean dududuel = false;
			 
			 
				  //deplacement vers allie
			if(this.Plateau.territories[territory-1].player==this.Plateau.territories[target-1].player){
				    this.Plateau.territories[target-1].horseman[1]+=this.Plateau.players[player-1].horseman[0];
				    this.Plateau.territories[target-1].horseman[2]+=this.Plateau.territories[player-1].horseman[1];
				    this.Plateau.territories[target-1].horseman[3]+=this.Plateau.territories[player-1].horseman[2];
				    this.Plateau.territories[target-1].horseman[1]+=this.Plateau.territories[player-1].musketman[0];
				    this.Plateau.territories[target-1].horseman[2]+=this.Plateau.territories[player-1].musketman[1];
				    this.Plateau.territories[target-1].canonnier[1]+=this.Plateau.territories[player-1].canonnier[0];
				    this.clearHand(player-1);
				    return 0;
			}
			else if(this.Plateau.players[player-1].troopsInHand() <= 3) {
				int[][]ATKmatrix = {{0,0,0},{0,0,0},{0,0,0}}; //premiere colonne: pts d'ATK, 2nd : priorité defensive, 3e : pts de mvt deja utilises
				int[][]DEFmatrix = {{0,0},{0,0}}; //ATK et priorite
				int ATKcanonnier = this.Plateau.players[player-1].canonnier;
				int DEFcanonnier = this.Plateau.territories[target-1].getCanonnier();
				int ATKmusketman = this.Plateau.players[player-1].musketman[0]+this.Plateau.players[player-1].musketman[1];
				
				
				
				//parcourt la main du joueur et remplit une matrice facilement lisible par le programme (ATKmatrix)
				for (int i = 0; i < 3; i++) {
					for (int mus = 0; mus <1; mus++) {
						if(ATKmatrix[i][0]==0) {
							if(this.Plateau.players[player-1].musketman[mus]!=0) {
								this.Plateau.players[player].musketman[mus]--;
								ATKmatrix[i][0] = (int )(Math.random() * 7 + 1);
								ATKmatrix[i][1] = 2;
								ATKmatrix[i][2] = mus;
							}
						}
					}
					for (int hor = 0; hor <2; hor++) {
						if(ATKmatrix[i][0]==0) {
							if(this.Plateau.players[player-1].horseman[hor]!=0) {
								this.Plateau.players[player].musketman[hor]--;
								ATKmatrix[i][0] = (int )(Math.random() * 8 + 2);
								ATKmatrix[i][1] = 3;
								ATKmatrix[i][2] = hor;
							}
						}
					}
					if(ATKmatrix[i][0]==0) {
						if(this.Plateau.players[player-1].canonnier!=0) {
							this.Plateau.players[player].canonnier--;
							ATKmatrix[i][0] = (int)(Math.random() * 10 + 4);
							ATKmatrix[i][1] = 1;
							ATKmatrix[i][2] = 0;
						}
					}
					
					
				}
				
				//defense matrix
				for (int i = 0; i < 2 ; i++) {
					if(this.Plateau.territories[target-1].musketman[0] > 0) {
						if(DEFmatrix[i][0] != 0) {
							this.Plateau.territories[target-1].musketman[0]--;
							DEFmatrix[i][0]= (int )(Math.random() * 7 + 1);
							DEFmatrix[i][1]= 2;
						}
					}
					if(this.Plateau.territories[target-1].canonnier[0] > 0) {
						if(DEFmatrix[i][0] != 0) {
							this.Plateau.territories[target-1].canonnier[0]--;
							DEFmatrix[i][0]= (int )(Math.random() * 10 + 4);
							DEFmatrix[i][1]= 1;
						}
					}
					if(this.Plateau.territories[target-1].horseman[0] > 0) {
						if(DEFmatrix[i][0] != 0) {
							this.Plateau.territories[target-1].horseman[0]--;
							DEFmatrix[i][0]= (int )(Math.random() * 8 + 2);
							DEFmatrix[i][1]= 3;
						}
					}
				}
				
				//tri de la matrice d'ATK selon les atk plus puissantes ou priorités
				int memory1;
				int memory2;
				int memory3;
				for (int i = 0; i<2; i++) {
					for (int j =0; j<2; j++) {
						if(ATKmatrix[j][0]<ATKmatrix[j+1][0] || (ATKmatrix[j][0]==ATKmatrix[j+1][0] && ATKmatrix[j][1]<ATKmatrix[j+1][1])) { //swap
							memory1 = ATKmatrix[j][0];
							memory2 = ATKmatrix[j][1];
							memory3 = ATKmatrix[j][2];
							ATKmatrix[j][0] = ATKmatrix[j+1][0];
							ATKmatrix[j][1] = ATKmatrix[j+1][1];
							ATKmatrix[j][2] = ATKmatrix[j+1][2];
							ATKmatrix[j+1][0] = memory1;
							ATKmatrix[j+1][1] = memory2;
							ATKmatrix[j+1][2] = memory3;
						}
					
					}
					
				}
				
				//tri matrice defense
				if(DEFmatrix[0][0]<DEFmatrix[1][0] || (DEFmatrix[0][0]==DEFmatrix[1][0] && DEFmatrix[0][1]<DEFmatrix[1][1] || DEFmatrix[1][1]!=3)) {
					//si l'atk de 2 est supérieur à l'attaque de 1, swap
					//si l'atk de 2 et 1 sont egales et que le code d'unite (pt de mvt max) de 2 est plus grand que le code d'unite de 1
					//excepte si ce code est 3 (horseman), alors swap. Ceci donne toujours 2 - 1 - 3 (soldat - canon - cavalier)
					memory1 = DEFmatrix[0][0];
					memory2 = DEFmatrix[0][1];
					DEFmatrix[0][0] = DEFmatrix[1][0];
					DEFmatrix[0][1] = DEFmatrix[1][1];
					DEFmatrix[1][0] = memory1;
					DEFmatrix[1][1] = memory2;
				}
				
				//if(DEFmatrix)	  
				//continuer ici
					  
				 
			}
			
					
				    
				     
				  
			
			
		}
		
	
	
}
