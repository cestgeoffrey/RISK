import edu.princeton.cs.introcs.StdDraw;

public class Board {
	
	
	
	
	
	public void initialize() {
		int x = 1361;
		int y = 675;
		StdDraw.setCanvasSize(x, y);
		StdDraw.setXscale(0, x);
		StdDraw.setYscale(0, y);
		StdDraw.picture(x/2,y/2,"Map/Map.png");
		StdDraw.pause(1000);
		
		//
		
		while (!StdDraw.isKeyPressed(32)) {
			
			if (StdDraw.isMousePressed()) {	
				
				StdDraw.pause(100);//Pause car isMousePressed reste true pendant qq ms (de trop !)
			}
			//Récupérateur de hitbox V2
		}

	}
	
	public void actualize(){

		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.picture(550, 500, "Risk_Map.png");
		
	}
}
