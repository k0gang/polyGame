package polyGame;

import java.util.Vector;

public class Healer extends Unit implements skillUsable {

	Healer() {
		name = "성직자";
		maxhp = 500;
		curhp = 500;
		power = 30;
	}

	public void skill(Vector<Unit> unitList, int index) {
		System.out.println("성직자의 치유의 물결!");
		System.out.println("전체 아군 체력을 [" + power +"X3]만큼 회복");
		
		for(int i=0; i<unitList.size(); i++) {
			unitList.get(i).curhp += power*3;
			if(unitList.get(i).curhp > maxhp)
				unitList.get(i).curhp = maxhp;
		}
	}

}
