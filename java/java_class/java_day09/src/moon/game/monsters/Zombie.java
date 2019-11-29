package moon.game.monsters;

public class Zombie extends Monster{
	private static final String name = "좀비";
	private static final int monsterNo = 2;

	
	public Zombie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Zombie(int hp, int atk_low, int atk_high, int agi, int def) {
		super(hp, atk_low, atk_high, agi, def);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void attack(Monster m) {
		// TODO Auto-generated method stub
		
	}

}
