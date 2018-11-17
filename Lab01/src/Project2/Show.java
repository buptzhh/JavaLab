package Project2;

public class Show {
	public static void main(String[] args) {
		Tax single = new Single();
		Tax joint = new MarriedJointly();
		Tax separate = new MarriedSeparately();
		Tax head =new Head();
		System.out.printf("Income\tSingle\t\tJoint\t\tSeparate\tHead\n");
		for(int i = 50000;i<=60000;i+=50) {
			System.out.print(i+"\t");
			single.setIncome(i);
			joint.setIncome(i);
			separate.setIncome(i);
			head.setIncome(i);
			System.out.println(single.calculate()+ "\t\t" +joint.calculate()+
					"\t\t" +separate.calculate()+ "          " +head.calculate());
		}
	}
}