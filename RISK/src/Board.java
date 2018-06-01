import edu.princeton.cs.introcs.StdDraw;

public class Board {
	
	
	
	public void initialize() {
		int x = 1100;
		int y = 1000;
		StdDraw.setCanvasSize(x, y);
		StdDraw.setXscale(0, x);
		StdDraw.setYscale(0, y);

	}
	
	public void actualize(){

		StdDraw.setPenColor(StdDraw.MAGENTA);
		StdDraw.picture(550, 500, "Risk_Map.png");
		
	}
}
