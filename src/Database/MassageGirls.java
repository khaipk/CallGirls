package Database;

public class MassageGirls extends ServiceGirls {
	
	private int times;
	private int rankCute;
	@Override
	public double getMoney() {
		this.money = this.times*this.rankCute*200000;
		return this.money;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	public int getRankCute() {
		return rankCute;
	}
	public void setRankCute(int rankCute) {
		this.rankCute = rankCute;
	}
	public MassageGirls() {
		super();
	}
	public MassageGirls(int jobCode, String name, int age, String body, int times, int rankCute) {
		super(jobCode, name, age, body);
		this.times = times;
		this.rankCute = rankCute;
	}
	@Override
	public String toString() {
		return super.toString()+"-"+this.getMoney();
	}

}
