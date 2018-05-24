package risk;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;

import org.newdawn.slick.state.*;

public class risk extends BasicGameState
{
	public risk(String string) {
		
	}
	public risk(int risk) {
		// TODO Auto-generated constructor stub
	}
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException  {
		
	}
	public void update(GameContainer gc ,StateBasedGame sbg, int delta) {
		
	}
	public void render(GameContainer gc,StateBasedGame sbg, Graphics g) throws SlickException {
		
	}
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer((Game) new risk("risk"));
		
		app.setDisplayMode (1253,795,false);
		app.start();
	}
	public int getID() {
		return 1;
	}
}

