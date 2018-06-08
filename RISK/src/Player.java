
public class Player {
	int number = 0;
	int reinforcements;
	int recentlyCaptured = 0;
	int panel = 0;
	//0 = panel vide
	//1 panel de visualisation des unitees ennemies lors de la phase de renfort
	//2 panel de renfort de son territoire
	//3 panel de visualisation des unitees ennemies lors de la phase de combat
	//4 panel d'ordres
	int[] musketman = {0,0};//musketman[0] contient le nombre de musketman ayant dépensé 0 points de mouvements. similaire à ce que l'on trouve
	//dans la classe Territory
	int[] horseman =  {0,0,0};
	int canonnier = 0;
	int[] color= new int[3];
	boolean alive = false;
	boolean AI;
	
	
	public Player(int number, int R, int G, int B) {
		this.number = number;
		this.color[0]=R;
		this.color[1]=G;
		this.color[2]=B;
	}
	public void setAliveAndAI(boolean alive, boolean AI) {
		this.alive = alive;
		this.AI = AI;
	}
	public int troopsInHand() {
		int x = this.musketman[0]+this.musketman[1];
		x += this.horseman[0]+this.horseman[1]+this.horseman[2];
		x += this.canonnier;
		return x;
	}
	
	
	 
	
}
