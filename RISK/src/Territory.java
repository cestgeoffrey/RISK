
public class Territory {
	int ID;
	int[] adjacency = {0,0,0,0,0,0};
	int[] musketman = {0,0,0};
	int[] horseman =  {0,0,0,0};
	int[] canonnier = {0,0};
	int player;
	int X;
	int Y;
	int region;
	
	public Territory(int ID, int[] adjacency) {
		this.ID = ID;
		for (int i = 0; i < 6; i++) {
			this.adjacency[i]=adjacency[i];
		}
	}
	public void setGeoInfo(int X, int Y, int region) {
		this.X = X;
		this.Y = Y;
		this.region = region;
	}
	
}

//Territory France = new Territory(1, {4,5,0,0,0,0});
//France.setGeoInfo(X,Y,2);
