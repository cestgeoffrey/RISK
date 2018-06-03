import java.util.*;
import java.lang.*;

public class Main {

	public static void main(String[] args) {
		int x = 1280;
		int y = 720;
		// TODO Auto-generated method stub
		Game GAME = new Game();
		//System.out.println(GAME.Plateau.x);
		//GAME.Plateau.x = 1;
		//System.out.println(GAME.Plateau.x);
		GAME.initialize(x,y);
		GAME.menu(x,y);
		
	}

}

//11 asie
//4 oceanie
//6 afrique
//7 europe
//9 amer nord
//4 amer sud