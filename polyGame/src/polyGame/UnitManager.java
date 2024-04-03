package polyGame;

import java.util.Random;
import java.util.Vector;

public class UnitManager {

	private final int PLAYER = 3;
	Vector<Unit> player_list = new Vector<>();
	Vector<Unit> mon_list = new Vector<>();
	String path = "polyGame.";
	String mons[] = {"UnitWolf", "UnitBat", "UnitOrc"};
	String heroes[] = {"Knight", "Magician", "Healer"};
	Random ran = new Random();
	
	UnitManager(){
		for(int i=0; i<PLAYER; i++) {
			try {
				Class<?> clazz = Class.forName(path + heroes[i]);
				Object obj = clazz.getDeclaredConstructor().newInstance();
				Unit temp = (Unit) obj;
				player_list.add(temp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
