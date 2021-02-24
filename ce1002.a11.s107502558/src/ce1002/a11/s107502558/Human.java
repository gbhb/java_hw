/* Assignment 11
 * course : ce1002
 * student id  :107502558
 * name :/�f�ɿ�
 */
package ce1002.a11.s107502558;

import java.awt.event.ContainerListener;
import java.awt.event.ContainerAdapter;;

//�i�H���ʧ@������
abstract class Entity {
	int hp;
	int id;
}
class Magic{
	String Magic;
	int damage;
	int costmp;
}
class Material{
	String Material;
}
class Weapon{
	String Weapon;
	int damage;
	int costsp;
}
//�H��
abstract class Human extends Entity {
	String name;
	Human(String name,int hp,int id){
	this.name=name;
	super.hp=hp;
	super.id=id;
	}
}

//�Ԥh
class Warrior extends Human implements ICanHoldWeapon {
	

	Warrior(String name, int hp, int id) {
		super(name, hp, id);
		// TODO �۰ʲ��ͪ��غc�l Stub
	}

	int StaminaPoint;
	final int MaxStaminaPoint=10;

	void AdvanceSwordAttack(Monster monster){}

	@Override
	public void PickUpWeapon(Weapon weapon){}

	@Override
	public void ThrowWeapon(Weapon weapon){}
}

//�Ův
class Wizard extends Human implements ICanUseMagic {
	

	Wizard(String name, int hp, int id) {
		super(name, hp, id);
		// TODO �۰ʲ��ͪ��غc�l Stub
	}

	int MagicPoint;
	final int MaxMagicPoint=10;

	void ManaImpact(Monster monster){}

	@Override
	public void LaunchMagic(Magic Magic){}

	@Override
	public void LearnMagic(Magic Magic){}

	@Override
	public void CraftMagicWeapon(Magic Magic){}
}

//���Q
class Monk extends Human implements ICanHoldWeapon, ICanUseMagic {
	

	Monk(String name, int hp, int id) {
		super(name, hp, id);
		// TODO �۰ʲ��ͪ��غc�l Stub
	}

	int MagicPoint;
	final int MaxMagicPoint=10;
	int StaminaPoint;
	final int MaxStaminaPoint=10;
	void HolyHealing(Human Human) {
		Human.hp++;
	}
	@Override
	public void PickUpWeapon(Weapon weapon) {}

	@Override
	public void ThrowWeapon(Weapon weapon) {}
	@Override
	public void LaunchMagic(Magic Magic) {}

	@Override
	public void LearnMagic(Magic Magic) {}

	@Override
	public void CraftMagicWeapon(Magic Magic) {}
}

//�Ǫ�
abstract class Monster extends Entity {
	Monster(int hp,int id){
		super.hp=hp;
		super.id=id;
		}
}

//�����L
class Goblin extends Monster implements ICanHoldMaterial{
	Goblin(int hp, int id) {
		super(hp, id);
		// TODO �۰ʲ��ͪ��غc�l Stub
	}

	@Override
	public void ThrowMaterial(Material Material) {}
}

//�����L�Ův
class GoblinWizard extends Monster implements ICanUseMagic,ICanHoldMaterial{
	GoblinWizard(int hp, int id) {
		super(hp, id);
		// TODO �۰ʲ��ͪ��غc�l Stub
	}

	int MagicPoint;
	final int MaxMagicPoint=10;

	void ManaImpact(Monster monster) {}
	@Override
	public void ThrowMaterial(Material Material) {}
	@Override
	public void LaunchMagic(Magic Magic) {}

	@Override
	public void LearnMagic(Magic Magic) {}

	@Override
	public void CraftMagicWeapon(Magic Magic) {
	}
}

//�����L�Ԥh
class GoblinWarrior extends Monster implements ICanHoldWeapon,ICanHoldMaterial{
	GoblinWarrior(int hp, int id) {
		super(hp, id);
		// TODO �۰ʲ��ͪ��غc�l Stub
	}

	int StaminaPoint;
	final int MaxStaminaPoint=10;
	@Override
	public
	void ThrowMaterial(Material Material) {
	}
	@Override
	public
	void PickUpWeapon(Weapon weapon) {
	}

	@Override
	public
	void ThrowWeapon(Weapon weapon) {
	}
}

//���H��
class Ogre extends Monster implements ICanHoldMaterial{
	Ogre(int hp, int id) {
		super(hp, id);
		// TODO �۰ʲ��ͪ��غc�l Stub
	}

	@Override
	public
	void ThrowMaterial(Material Material) {
	}
}

//�v�ܩi
class Smile extends Monster implements ICanHoldMaterial{
	Smile(int hp, int id) {
		super(hp, id);
		// TODO �۰ʲ��ͪ��غc�l Stub
	}

	@Override
	public
	void ThrowMaterial(Material Material) {
	}
}


//�i�H������
interface ICanHoldMaterial {
	abstract void ThrowMaterial(Material Material);
}
//�i�H�˳ƪZ��
interface ICanHoldWeapon {
	abstract void PickUpWeapon(Weapon weapon);

	abstract void ThrowWeapon(Weapon weapon);

}

//�i�H�ϥ��]�N
interface ICanUseMagic{
	abstract void LaunchMagic(Magic Magic);
	abstract void CraftMagicWeapon(Magic Magic);
	abstract void LearnMagic(Magic Magic);
}
