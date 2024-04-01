package polyGame;

public abstract class Unit {
	int curhp;
	int maxhp;
	int power;
	String name;
	
	Unit(){
	}
	
	Unit(String name, int maxhp, int power){
		this.name = name;
		this.maxhp = maxhp;
		this.curhp = maxhp;
		this.power = power;
	}
	
	public void attack(Unit target) {
		target.curhp -= power;
		String message = String.format("[%s] 이 [%s] 에게 [%d]의 피해를 입힙니다.",name,target.name,power);
		System.out.println(message);
		if(target.curhp <= 0) {
			message = String.format("[%s]가 쓰러졌다!",target.name);
			System.out.println(message);
			target.curhp = 0;
		}
	}
	
	public void printData() {
		String message = String.format("[%s] [%d/%d] [%d]", name, curhp, maxhp, power);
		System.out.println(message);
	}
}
