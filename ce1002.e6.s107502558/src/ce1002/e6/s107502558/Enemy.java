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
		// TODO �۰ʲ��ͪ���k Stub
		return Name;
	}

	public int getHp() {
		// TODO �۰ʲ��ͪ���k Stub
		return Hp;
	}

	public int getAtk() {
		// TODO �۰ʲ��ͪ���k Stub
		return Atk;
	}

	public String getDropItem() {
		// TODO �۰ʲ��ͪ���k Stub
		return DropItem;
	}

	public void setHp(int i) {
		// TODO �۰ʲ��ͪ���k Stub
		Hp=i;
	}

}
