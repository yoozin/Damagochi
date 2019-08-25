package damagochi;

public class Damagochi {
	String name; // 이름
	int level; // 레벨
	int experience; // 경험치
	int intimacy; // 친밀도
	int hunger; // 배고픔
	int fatigue; // 피로도
	int dDay; // 날짜

	public Damagochi(String name, int level, int experience, int intimacy, int hunger, int fatigue, int dDay) {

		this.name = name;
		this.level = level;
		this.experience = experience;
		this.intimacy = intimacy;
		this.hunger = hunger;
		this.fatigue = fatigue;
		this.dDay = dDay;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getIntimacy() {
		return intimacy;
	}

	public void setIntimacy(int intimacy) {
		this.intimacy = intimacy;
	}

	public int getHunger() {
		return hunger;
	}

	public void setHunger(int hunger) {
		this.hunger = hunger;
	}

	public int getFatigue() {
		return fatigue;
	}

	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}

	public int getdDay() {
		return dDay;
	}

	public void setdDay(int dDay) {
		this.dDay = dDay;
	}

	@Override
	public String toString() {
		return "たまごっち " + name + "\tLv." + level + "\tExp." + experience + "\t親密度" + intimacy + "%\t空腹" + hunger
				+ "%\t疲労度" + fatigue + "%\t産まれてから " + dDay + "日";

	}

}