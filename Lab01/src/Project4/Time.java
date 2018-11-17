package Project4;

public class Time {
	public static void main(String[] args) {
		Time time1=new Time();
		Time time2 = new Time(555550000);
		System.out.println(time1.toString());
		System.out.println(time2.toString());
	}
	private long hour;
	private long minute;
	private long second;
	public Time() {
		super();
		hour=System.currentTimeMillis()/1000/60/60%24;
		minute=System.currentTimeMillis()/1000/60%60;
		second=System.currentTimeMillis()/1000%60;
	}
	public Time(long time) {
		super();
		if(time>0) {
			hour=time/1000/60/60%24;
			minute=time/1000/60%60;
			second=time/1000%60;
		}
		else {
			hour=System.currentTimeMillis()/1000/60/60%24;
			minute=System.currentTimeMillis()/1000/60%60;
			second=System.currentTimeMillis()/1000%60;
			System.out.println("time input wrong");
		}
	}
	public long getHour() {
		return hour;
	}
	public long getMinute() {
		return minute;
	}
	public long getSecond() {
		return second;
	}
	public String toString() {
		return hour+":"+minute+":"+second;
	}
}
