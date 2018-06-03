
public class Player {
	int number = 0;
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
	
}
