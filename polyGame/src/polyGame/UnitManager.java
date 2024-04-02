package polyGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {

	Vector<Player> player_list = new Vector<>();
	Vector<Unit> mon_list = new Vector<>();
	String path = "polyGame.";
	String mons[] = {"UnitWolf", "UnitBat", "UnitOrc"};
	Random ran = new Random();
	
	UnitManager(){
		player_list.add(new Player("전사", 1000, 45));
		player_list.add(new Player("법사", 800, 60));
		player_list.add(new Player("힐러", 500, 30));
	}
	
	void monster_rand_set(int size) {
		for(int i=0; i<size; i++) {
			int num = ran.nextInt(mons.length);
			try {
				Class<?> clazz = Class.forName(path+mons[num]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;
				int hp = ran.nextInt(100) + 100;
				int pow = ran.nextInt(10) + 10;
				temp.init(hp, pow);
				mon_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
