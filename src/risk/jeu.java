package risk;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class jeu  extends StateBasedGame{
	
	
	public static final String gamename = "Risk";
	public static final int menu = 0;
	public static final int risk = 1;
	
	public jeu(String gamename) {
		super (gamename);
		this.addState(new risk(risk));
		this.addState(new menu(menu));
		
		
		}
	
	public void initStatesList (GameContainer gc) throws SlickException {
		this.getState(risk).init(gc, this);
		this.getState(menu).init(gc, this);
		
		this.enterState(risk);
		this.enterState(menu);
	}
	public static void main (String[] args) {
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer (new jeu(gamename));
			appgc.setDisplayMode(640,360,false);
			appgc.start();
			
		}catch(SlickException e) {
			e.printStackTrace();
		}
	}

}
