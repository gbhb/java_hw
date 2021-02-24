package ce1002.e6.s107502558;

public class Enemy extends Role{

	public static String DropItem = "";

	public Enemy(String name, int hp, int atk, String dropItem2) {
		Name=name;
		Hp=hp;
		Atk=atk;
		this.DropItem=dropItem2;
	}

	public String getName() {
		// TODO 自動產生的方法 Stub
		return Name;
	}

	public int getHp() {
		// TODO 自動產生的方法 Stub
		return Hp;
	}

	public int getAtk() {
		// TODO 自動產生的方法 Stub
		return Atk;
	}

	public String getDropItem() {
		// TODO 自動產生的方法 Stub
		return DropItem;
	}

	public void setHp(int i) {
		// TODO 自動產生的方法 Stub
		Hp=i;
	}

}
