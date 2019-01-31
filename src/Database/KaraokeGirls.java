package Database;

public class KaraokeGirls extends ServiceGirls {
	
	private int hoursWork;
	private int rankQuality;
	@Override
	public double getMoney() {
		this.money = this.hoursWork*this.rankQuality*100000;
		return this.money;
	}
	public int getHoursWork() {
		return hoursWork;
	}
	public void setHoursWork(int hoursWork) {
		this.hoursWork = hoursWork;
	}
	public int getRankQuality() {
		return rankQuality;
	}
	public void setRankQuality(int rankQuality) {
		this.rankQuality = rankQuality;
	}
	public KaraokeGirls(int jobCode, String name, int age, String body, int hoursWork, int rankQuality) {
		super(jobCode, name, age, body);
		this.hoursWork = hoursWork;
		this.rankQuality = rankQuality;
	}
	public KaraokeGirls() {
		super();
	}
	@Override
	public String toString() {
		return super.toString() +"-"+this.getMoney();
	}
}
