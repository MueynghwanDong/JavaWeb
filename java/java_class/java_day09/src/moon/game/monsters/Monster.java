package moon.game.monsters;

public abstract class Monster {
	private int hp;
	private int atk_low;
	private int atk_high;
	private int agi;
	private int def;
	
	public Monster() {}
	public Monster(int hp, int atk_low, int atk_high, int agi, int def) {
		super();
		this.hp = hp;
		this.atk_low = atk_low;
		this.atk_high = atk_high;
		this.agi = agi;
		this.def = def;
	}

	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk_low() {
		return atk_low;
	}
	public void setAtk_low(int atk_low) {
		this.atk_low = atk_low;
	}
	public int getAtk_high() {
		return atk_high;
	}
	public void setAtk_high(int atk_high) {
		this.atk_high = atk_high;
	}
	public int getAgi() {
		return agi;
	}
	public void setAgi(int agi) {
		this.agi = agi;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	
	
	public abstract void attack(Monster m);
	
}