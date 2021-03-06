import edu.princeton.cs.introcs.StdDraw;

public class Board {
	
	Territory[] territories = new Territory[42];
	Player[] players = new Player[6];
	int x = 1361;
	int y = 675;
	
	
	public void initialize(int PlayerCount, int ActivateAI) {
		int x = 1361;
		int y = 675;
		StdDraw.setCanvasSize(x, y);
		StdDraw.setXscale(0, x);
		StdDraw.setYscale(0, y);
		StdDraw.picture(x/2,y/2,"Map/Map.png");
		StdDraw.pause(200);
		
		this.instanceTerritories();
		this.attributeTerritories(PlayerCount, ActivateAI);
		this.instancePlayers(PlayerCount, ActivateAI);

	}
	
	
	public void instanceTerritories() {
		
		territories[0]= new Territory(1,2,11,10,0,0,0);
		territories[1]= new Territory(2,1,11,12,3,0,0);
		territories[2]= new Territory(3,2,12,13,4,0,0);
		territories[3]= new Territory(4,3,14,5,0,0,0);
		territories[4]= new Territory(5,4,14,15,6,0,0);
		territories[5]= new Territory(6,5,15,21,22,16,7);
		territories[6]= new Territory(7,6,16,24,8,0,0);
		territories[7]= new Territory(8,7,24,25,17,9,0);
		territories[8]= new Territory(9,8,17,10,0,0,0);
		territories[9]= new Territory(10,1,9,17,25,26,0);
		territories[10]= new Territory(11,1,2,12,18,0,0);
		territories[11]= new Territory(12,2,11,18,19,13,3);
		territories[12]= new Territory(13,12,19,3,0,0,0);
		territories[13]= new Territory(14,4,20,15,5,0,0);
		territories[14]= new Territory(15,5,14,20,21,6,0);
		territories[15]= new Territory(16,6,22,23,24,7,0);
		territories[16]= new Territory(17,10,9,8,25,0,0);
		territories[17]= new Territory(18,11,12,19,0,0,0);
		territories[18]= new Territory(19,13,12,18,27,0,0);
		territories[19]= new Territory(20,14,15,21,30,0,0);
		territories[20]= new Territory(21,15,20,30,31,22,6);
		territories[21]= new Territory(22,21,31,32,23,16,6);
		territories[22]= new Territory(23,24,16,22,33,0,0);
		territories[23]= new Territory(24,25,8,7,16,23,33);
		territories[24]= new Territory(25,26,10,17,8,24,0);
		territories[25]= new Territory(26,10,25,0,0,0,0);
		territories[26]= new Territory(27,18,19,28,0,0,0);
		territories[27]= new Territory(28,27,34,29,0,0,0);
		territories[28]= new Territory(29,28,34,35,30,0,0);
		territories[29]= new Territory(30,21,20,29,36,32,31);
		territories[30]= new Territory(31,21,30,32,22,0,0);
		territories[31]= new Territory(32,22,31,30,36,37,38);
		territories[32]= new Territory(33,24,23,39,0,0,0);
		territories[33]= new Territory(34,28,29,35,0,0,0);
		territories[34]= new Territory(35,34,29,0,0,0,0);
		territories[35]= new Territory(36,30,31,32,37,0,0);
		territories[36]= new Territory(37,36,32,38,0,0,0);
		territories[37]= new Territory(38,32,37,0,0,0,0);
		territories[38]= new Territory(39,33,40,41,0,0,0);
		territories[39]= new Territory(40,42,41,39,0,0,0);
		territories[40]= new Territory(41,39,40,42,0,0,0);
		territories[41]= new Territory(42,41,40,0,0,0,0);
		
		territories[0].setGeoInfo(55.0,577.0,1);
		territories[1].setGeoInfo(157.0,576.0,1);
		territories[2].setGeoInfo(340.0,615.0,1);
		territories[3].setGeoInfo(424.0,546.0,2);
		territories[4].setGeoInfo(507.0,562.0,2);
		territories[5].setGeoInfo(598.0,508.0,2);
		territories[6].setGeoInfo(691.0,529.0,3);
		territories[7].setGeoInfo(744.0,579.0,3);
		territories[8].setGeoInfo(830.0,596.0,3);
		territories[9].setGeoInfo(899.0,558.0,3);
		territories[10].setGeoInfo(142.0,521.0,1);
		territories[11].setGeoInfo(206.0,508.0,1);
		territories[12].setGeoInfo(277.0,502.0,1);
		territories[13].setGeoInfo(401.0,459.0,2);
		territories[14].setGeoInfo(499.0,449.0,2);
		territories[15].setGeoInfo(678.0,424.0,3);
		territories[16].setGeoInfo(818.0,511.0,3);
		territories[17].setGeoInfo(148.0,439.0,1);
		territories[18].setGeoInfo(221.0,421.0,1);
		territories[19].setGeoInfo(431.0,376.0,2);
		territories[20].setGeoInfo(509.0,381.0,2);
		territories[21].setGeoInfo(621.0,319.0,3);
		territories[22].setGeoInfo(738.0,314.0,3);
		territories[23].setGeoInfo(804.0,373.0,3);
		territories[24].setGeoInfo(839.0,438.0,3);
		territories[25].setGeoInfo(951.0,430.0,3);
		territories[26].setGeoInfo(165.0,338.0,1);
		territories[27].setGeoInfo(233.0,291.0,4);
		territories[28].setGeoInfo(304.0,220.0,4);
		territories[29].setGeoInfo(461.0,248.0,5);
		territories[30].setGeoInfo(547.0,273.0,5);
		territories[31].setGeoInfo(596.0,201.0,5);
		territories[32].setGeoInfo(831.0,282.0,3);
		territories[33].setGeoInfo(196.0,210.0,4);
		territories[34].setGeoInfo(253.0,111.0,5);
		territories[35].setGeoInfo(543.0,157.0,5);
		territories[36].setGeoInfo(545.0,70.0,5);
		territories[37].setGeoInfo(652.0,61.0,5);
		territories[38].setGeoInfo(832.0,169.0,6);
		territories[39].setGeoInfo(937.0,199.0,6);
		territories[40].setGeoInfo(879.0,63.0,6);
		territories[41].setGeoInfo(972.0,78.0,6);			
	}
	
	public void attributeTerritories(int PlayerCount, int ActivateAI) {
		int x;
		int y;
		int memory;
		territories[40].player = 0;//dans le cas ou on joue � 3 ou 4, les deux derniers territoires ne sont attribu�s � personne
		territories[41].player = 0;
		
		//attribution �quitable et ordonn�e de territoires
		for (int i = 0; i<PlayerCount;i++) {
			for (int j= 0; j<42/PlayerCount;j++){
				territories[(i*(42/PlayerCount))+j].player = i+1;
			}
		}
		
		//melange des attributions
		for (int i=0; i<200;i++) {
			x= (int )(Math.random() * 42);
			y= (int )(Math.random() * 42);
			memory = territories[x].player;
			territories[x].player = territories[y].player;
			territories[y].player = memory;
		}
		
		if (PlayerCount == 3 || PlayerCount == 4) {
			for (int j= 0; j<42;j++){
				if(territories[j].player==0) {
					territories[j].setMusketman(0,0,0);
				}
			}
		}		
	}
	
	public void instancePlayers(int PlayerCount, int ActivateAI) {
		
		int i = 1;
		players[0] = new Player(1,75,209,227);
		players[1] = new Player(2,0,0,0);
		players[2] = new Player(3,255,255,255);
		players[3] = new Player(4,130,130,130);
		players[4] = new Player(5,169,224,40);
		players[5] = new Player(6,255,183,135);
		
		players[0].alive = true;
		players[0].AI = false;
		while(i < PlayerCount) {
			players[i].alive = true;
			if(ActivateAI == 1) {
				players[i].AI = true;
			}
			else {
				players[i].AI = false;
			}
			i++;	
		}
		
		//melange
		int x, y;
		boolean memoryAlive, memoryAI;
		for (i=0; i<PlayerCount*4;i++) {
			x= (int )(Math.random() * PlayerCount);
			y= (int )(Math.random() * PlayerCount);
			memoryAlive = players[x].alive;
			memoryAI = players[x].AI;
			players[x].alive = players[y].alive;
			players[x].AI = players[y].AI;
			players[y].alive = memoryAlive;
			players[y].AI = memoryAI;
		}		
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public void actualize( int panel, int player,int territory){
		StdDraw.clear();
		StdDraw.picture(this.x/2, this.y/2, "Map/Map.png");
		this.writeTerritories();
		this.writePanel(panel,player,territory);
		this.writeColoredCube(player);
		this.writeInRangeTerritories(panel,player,territory);
		StdDraw.show();
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	public void writeTerritories() {
		StdDraw.enableDoubleBuffering();
		for (int i=0; i<42;i++) {
			if (territories[i].player != 0) {
				StdDraw.setPenColor(255, 255, 255);
				StdDraw.filledCircle(territories[i].X, territories[i].Y, 20);
				StdDraw.setPenColor(players[territories[i].player-1].color[0], players[territories[i].player-1].color[1], players[territories[i].player-1].color[2]);// couleur du player controlant le territoire
				StdDraw.setPenRadius(0.015);
				StdDraw.circle(territories[i].X, territories[i].Y, 22.5);
				StdDraw.setPenColor(0, 0, 0);
				StdDraw.text(territories[i].X, territories[i].Y-2, Integer.toString(this.powerEstimation(territories[i])));				
			}
			else {
				StdDraw.setPenColor(255, 255, 255);
				StdDraw.filledCircle(territories[i].X, territories[i].Y, 20);
				StdDraw.setPenColor(0, 0, 0);
				StdDraw.text(territories[i].X, territories[i].Y-2, "0");								
			}
		}
		StdDraw.disableDoubleBuffering();
	}
	
	public void writePanel(int panel, int player, int territory) {
		//panel : voir classe joueur
		//player : nombre du joueur (pas index)
		//territory : ID du territoire (pas index aussi)
		StdDraw.enableDoubleBuffering();
		switch(panel) {
		case 0: 
			StdDraw.picture(this.x/2, this.y/2, "Map/Clear.png");
			break;
		case 1:
			StdDraw.picture(this.x/2, this.y/2, "Map/OPFOR1.png");
			StdDraw.setPenColor(255,255,255);
			StdDraw.text(1090.0,435.0,Integer.toString(this.territories[territory-1].getHorseman()));
			StdDraw.text(1287.0,436.0,Integer.toString(this.territories[territory-1].getCanonnier()));
			StdDraw.text(1190.0,435.0,Integer.toString(this.territories[territory-1].getMusketman()));
			break;
		case 2: 
			StdDraw.picture(this.x/2, this.y/2, "Map/Reinforcements.png");
			StdDraw.setPenColor(255,255,255);
			StdDraw.text(1090.0,435.0,Integer.toString(this.territories[territory-1].getHorseman()));
			StdDraw.text(1287.0,436.0,Integer.toString(this.territories[territory-1].getCanonnier()));
			StdDraw.text(1190.0,435.0,Integer.toString(this.territories[territory-1].getMusketman()));
			StdDraw.text(1089.0,348.0,Integer.toString(this.players[player-1].horseman[0]));
			StdDraw.text(1190.0,349.0,Integer.toString(this.players[player-1].musketman[0]));
			StdDraw.text(1287.0,348.0,Integer.toString(this.players[player-1].canonnier));
			StdDraw.text(1188.0,244.0,Integer.toString(this.players[player-1].reinforcements));
			break;
		case 3:
			StdDraw.picture(this.x/2, this.y/2, "Map/OPFOR2.png");
			StdDraw.setPenColor(255,255,255);
			StdDraw.text(1090.0,435.0,Integer.toString(this.territories[territory-1].getHorseman()));
			StdDraw.text(1287.0,436.0,Integer.toString(this.territories[territory-1].getCanonnier()));
			StdDraw.text(1190.0,435.0,Integer.toString(this.territories[territory-1].getMusketman()));
			break;
		case 4:
			StdDraw.picture(this.x/2, this.y/2, "Map/Orders.png");
			StdDraw.setPenColor(255,255,255);
			StdDraw.text(1088.0,481.0,Integer.toString(this.territories[territory-1].getHorseman()));
			StdDraw.text(1187.0,481.0,Integer.toString(this.territories[territory-1].getMusketman()));
			StdDraw.text(1290.0,482.0,Integer.toString(this.territories[territory-1].getCanonnier()));
			StdDraw.text(1090.0,404.0,Integer.toString(this.territories[territory-1].horseman[3]));
			StdDraw.text(1190.0,403.0,Integer.toString(this.territories[territory-1].musketman[2]));
			StdDraw.text(1290.0,403.0,Integer.toString(this.territories[territory-1].canonnier[1]));
			StdDraw.text(1073.0,324.0,Integer.toString(this.territories[territory-1].horseman[2]));
			StdDraw.text(1076.0,247.0,Integer.toString(this.territories[territory-1].horseman[1]));
			StdDraw.text(1077.0,178.0,Integer.toString(this.territories[territory-1].horseman[0]));
			StdDraw.text(1175.0,321.0,Integer.toString(this.territories[territory-1].musketman[1]));
			StdDraw.text(1172.0,252.0,Integer.toString(this.territories[territory-1].musketman[0]));
			StdDraw.text(1273.0,324.0,Integer.toString(this.territories[territory-1].canonnier[0]));
			if(this.players[player-1].troopsInHand()<=3 && this.players[player-1].troopsInHand()>0) {
				StdDraw.setPenColor(StdDraw.RED);
			}
			if(this.players[player-1].troopsInHand()>3) {
				StdDraw.setPenColor(StdDraw.GREEN);
			}
			StdDraw.text(1109.0,290.0,Integer.toString(this.players[player-1].horseman[2]));
			StdDraw.text(1109.0,219.0,Integer.toString(this.players[player-1].horseman[1]));
			StdDraw.text(1109.0,147.0,Integer.toString(this.players[player-1].horseman[0]));
			StdDraw.text(1208.0,292.0,Integer.toString(this.players[player-1].musketman[1]));
			StdDraw.text(1208.0,220.0,Integer.toString(this.players[player-1].musketman[0]));
			StdDraw.text(1304.0,292.0,Integer.toString(this.players[player-1].canonnier));
			break;			
		}		
	}
	
	public void writeColoredCube(int player) {
		StdDraw.enableDoubleBuffering();
		StdDraw.setPenColor(this.players[player-1].color[0],this.players[player-1].color[1],this.players[player-1].color[2]);
		StdDraw.filledSquare(55.0, 55.0, 40.0);
	}
	
	public void writeInRangeTerritories(int panel, int player, int territory) {
		if (panel == 4) {
			StdDraw.enableDoubleBuffering();
			StdDraw.setPenColor(255,255,255);
			StdDraw.setPenRadius(0.010);
			if(this.territories[territory-1].player == player) {
				for (int i = 0; i<6 ; i++) {
					if (this.territories[territory-1].adjacency[i]!=0) {
						if(this.players[player-1].troopsInHand()>3) {
							if(this.territories[this.territories[territory-1].adjacency[i]-1].player == player) {
								StdDraw.circle(this.territories[this.territories[territory-1].adjacency[i]-1].X, this.territories[this.territories[territory-1].adjacency[i]-1].Y, 35);
							}
						}else {
							StdDraw.circle(this.territories[this.territories[territory-1].adjacency[i]-1].X, this.territories[this.territories[territory-1].adjacency[i]-1].Y, 35);
						}						
						//On cherche dans le tab d'adjacence les id des territoires adjacents au territoire courant,
						//puis on cherche les pos X et Y de ces territoires pour dessiner les cercles
						//si il est possible d'effectuer une attaque vers un territoire ennemi, (unit�s en main <= 3)
						//soit il est possible d'effectuer un d�placement (unit�s en main > 3)
						//les territoires sont entour�s en fonction des possibilit�s du joueur
					}
				}
			}	
		}
	}
	
	public int powerEstimation(Territory territory) {
		int x = territory.musketman[0]+territory.musketman[1]+territory.musketman[2];
		x+= (territory.horseman[0]+territory.horseman[1]+territory.horseman[2]+territory.horseman[3])*3;
		x+= (territory.canonnier[0]+territory.canonnier[1])*7;
		return x;
	}
}
