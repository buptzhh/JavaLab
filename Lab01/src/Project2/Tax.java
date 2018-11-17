package Project2;

public class Tax {
	private double tax;
	private double income;
	public Tax() {
		this.income = 0;
	}
	public Tax(double income) {
		this.income = income;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double calculate() {
		setTax(0);
		return 0;
	}
}

class Single extends Tax{
	public Single(double income) {
		super(income);
	}
	public Single() {
		super();
	}
	@Override
	public double calculate() {
		if(getIncome()<=0) {
			setTax(0);
			return 0;
		}
		if(getIncome()>0 && getIncome()<=7300){
			setTax(getIncome()*0.1);
			return (getTax());
		}
		if(getIncome()>7300 && getIncome()<=29700){
			setTax((getIncome()-7300)*0.15+730);
			return (getTax());
		}
		if(getIncome()>29700 && getIncome()<=71950){
			setTax((getIncome()-29700)*0.25+4090);
			return (getTax());
		}
		if(getIncome()>71950 && getIncome()<=150150){
			setTax((getIncome()-71950)*0.28+14652.50);
			return (getTax());
		}
		if(getIncome()>150150 && getIncome()<=326450){
			setTax((getIncome()-150150)*0.33+36548.50);
			return (getTax());
		}
		if(getIncome()>326450){
			setTax((getIncome()-326450)*0.35+94727.50);
			return (getTax());
		}
		return 0;
	}
}

class MarriedJointly extends Tax{
	public MarriedJointly(double income) {
		super(income);
	}
	public MarriedJointly() {
		super();
	}
	@Override
	public double calculate() {
		if(getIncome()<=0) {
			setTax(0);
			return 0;
		}
		if(getIncome()>0 && getIncome()<=14600){
			setTax(getIncome()*0.1);
			return (getTax());
		}
		if(getIncome()>14600 && getIncome()<=59400){
			setTax((getIncome()-14600)*0.15+1460);
			return (getTax());
		}
		if(getIncome()>59400 && getIncome()<=119950){
			setTax((getIncome()-59400)*0.25+8180);
			return (getTax());
		}
		if(getIncome()>119950 && getIncome()<=182800){
			setTax((getIncome()-119950)*0.28+23317.5);
			return (getTax());
		}
		if(getIncome()>182800 && getIncome()<=326450){
			setTax((getIncome()-1182800)*0.33+40915.50);
			return (getTax());
		}
		if(getIncome()>326450){
			setTax((getIncome()-326450)*0.35+88320.50);
			return (getTax());
		}
		return 0;
	}
}

class MarriedSeparately extends Tax{
	public MarriedSeparately() {
		super();
	}
	public MarriedSeparately(double income) {
		super(income);
	}
	@Override
	public double calculate() {
		if(getIncome()<=0) {
			setTax(0);
			return 0;
		}
		if(getIncome()>0 && getIncome()<=7300){
			setTax(getIncome()*0.1);
			return (getTax());
		}
		if(getIncome()>7300 && getIncome()<=29700){
			setTax((getIncome()-7300)*0.15+730);
			return (getTax());
		}
		if(getIncome()>29700 && getIncome()<=59975){
			setTax((getIncome()-29700)*0.25+4090);
			return (getTax());
		}
		if(getIncome()>59975 && getIncome()<=91400){
			setTax((getIncome()-59975)*0.28+11658.75);
			return (getTax());
		}
		if(getIncome()>91400 && getIncome()<=163225){
			setTax((getIncome()-91400)*0.33+20457.75);
			return (getTax());
		}
		if(getIncome()>163225){
			setTax((getIncome()-163225)*0.35+44160);
			return (getTax());
		}
		return 0;
	}
}

class Head extends Tax{
	public Head() {
		super();
	}
	public Head(double income) {
		super(income);
	}
	@Override
	public double calculate() {
		if(getIncome()<=0) {
			setTax(0);
			return 0;
		}
		if(getIncome()>0 && getIncome()<=10450){
			setTax(getIncome()*0.1);
			return (getTax());
		}
		if(getIncome()>10450 && getIncome()<=39800){
			setTax((getIncome()-10450)*0.15+1045);
			return (getTax());
		}
		if(getIncome()>39800 && getIncome()<=102800){
			setTax((getIncome()-39800)*0.25+5447.50);
			return (getTax());
		}
		if(getIncome()>102800 && getIncome()<=166450){
			setTax((getIncome()-102800)*0.28+21197.50);
			return (getTax());
		}
		if(getIncome()>166450 && getIncome()<=326450){
			setTax((getIncome()-166450)*0.33+39019.50);
			return (getTax());
		}
		if(getIncome()>326450){
			setTax((getIncome()-326450)*0.35+91819.50);
			return (getTax());
		}
		return 0;
	}
}