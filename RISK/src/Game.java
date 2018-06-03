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
				StdDraw.pause(100);//Pause car isMousePressed reste true pendant qq ms (de trop !)
			}
			//Récupérateur de hitbox V2
		}
		
	}
	
	
	
	
	
	//Board Plateau = new Board();
	//Plateau.initialize();
	//Plateau.actualize();
	
	
	
}
