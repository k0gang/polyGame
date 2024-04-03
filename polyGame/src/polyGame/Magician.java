package polyGame;

import java.util.Vector;

public class Magician extends Unit implements skillUsable {
	
	public int maxmp;
	public int curmp;
	
	Magician() {
		name = "법사";
		maxhp = 800;
		curhp = 800;
		power = 60;
	}

	public void skill(Vector<Unit> unitList, int index) {
		System.out.println("법사의 메테오!");
		System.out.println("모든 적에게 ["+power+"X2] 의 데미지");
		
		for(Unit unit : unitList) {
			unit.curhp -= power*2;
			if(unit.curhp <= 0) {
				System.out.println("[" +unit.name+"]가 쓰러졌다!");
				unit.curhp = 0;
			}
		}
	}

}
