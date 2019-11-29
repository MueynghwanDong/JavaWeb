package moon.game.monsters;

public class Hero {
	private int heroNo;
	private String name;
	
	private int level;
	private int str;
	private int dex;
	private int end;
	private int health;
	
	private int hp;			// 플레이어의 레벨 + health 스탯 합
	private int stamina;	// 플레이어의 레벨 + end 스탯 합
	private int atk_low;	// 플레이어의 str 스탯 + 무기 공격력 합 + 장비 추가 효과, 공격력의 최소치
	private int atk_high;	// 플레이어의 str 스탯 + 무기 공격력 합 + 장비 추가 효과, 공격력의 최대치
	private int agi;		// 플레이어의 dex 스탯 + 장비 추가효과
	private int cri;		// 플레이어의 기본 치명타율 + 장비 추가효과
	private int def;		// 플레이어의 end 스탯 + 장비 추가 방어력
	
	
	public Hero() {}


	public Hero(int heroNo, String name, int level, int str, int dex, int end, int health) {
		super();
		this.heroNo = heroNo;
		this.name = name;
		this.level = level;
		this.str = str;
		this.dex = dex;
		this.end = end;
		this.health = health;
		
		hp = this.level * 10 + health * 3;
		stamina = this.level * 10 + end * 3;
		
		atk_low = 1 + this.level/3;
		atk_high = 1 + this.level/2;
		
		
	}
	
	
}
