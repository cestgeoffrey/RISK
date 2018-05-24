package risk;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class map extends BasicGame
{
	public map(String title) {
		super(title);
	}
	public void init(GameContainer arg0) throws SlickException  {
		
	}
	public void update(GameContainer arg0, int delta) {
		
	}
	public void render(GameContainer arg0, Graphics g) throws SlickException {
		Image img = new Image("carte.png");
		g.drawImage(img, 0, 0, 0 ,0, 1253, 795);
		g.drawString("Hello World", 50,50);
	}
	public static void main(String[] args) throws SlickException{
		AppGameContainer app = new AppGameContainer(new map("map"));
		
		app.setDisplayMode (1253,795,false);
		app.start();
	}
}

