package risk;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

import org.newdawn.slick.state.*;



public class menu extends BasicGameState{
	
	 Image jouer;
	 Image Quitter;
	public menu (int state) {
		
	}
	public void init(GameContainer gc , StateBasedGame sbg) throws SlickException{
		jouer = new Image("jouer.png");
		Quitter = new Image("Quitter.png");
	}
	public void render (GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("Bienvenu sur notre jeu Risk", 100, 50);
		jouer.draw(100,100);
		Quitter.draw(100,200);
	}
	public void update(GameContainer gc, StateBasedGame sbg , int delta) throws SlickException{
		int posX = Mouse.getX();
		int posY = Mouse.getY();
		if((posX>100 && posX<200 ) && (posY>209 && posY<260)) {
			if(Mouse.isButtonDown(0)) {
				sbg.enterState(1);
			}}
			if((posX>100 && posX<200 ) && (posY>109 && posY<209)) {
				if(Mouse.isButtonDown(0)) {
					System.exit(0);;
				}	
		}
		
	}	public int getID() {
		return 0;
	}
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer((Game) new risk("risk"));
		
		app.setDisplayMode (1253,795,false);
		app.start();
	}
}

