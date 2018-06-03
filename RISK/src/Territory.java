
public class Territory {
	int ID;
	int[] adjacency = {0,0,0,0,0,0};
	int[] musketman = {1,0,0};
	int[] horseman =  {0,0,0,0};
	int[] canonnier = {0,0};
	int player;
	double X;
	double Y;
	int region;
	
	public Territory(int ID, /*int[] adjacency*/int a,int b,int c,int d,int e,int f) {
		this.ID = ID;
        this.adjacency[0]=a;
        this.adjacency[1]=b;
        this.adjacency[2]=c;
        this.adjacency[3]=d;
        this.adjacency[4]=e;
        this.adjacency[5]=f;
		
	}
	public void setGeoInfo(double X, double Y, int region) {
		this.X = X;
		this.Y = Y;
		this.region = region;
	}
	public void setMusketman(int x, int y, int z) {
		this.musketman[0]=x;
		this.musketman[1]=y;
		this.musketman[2]=z;
	}
	
	
}
