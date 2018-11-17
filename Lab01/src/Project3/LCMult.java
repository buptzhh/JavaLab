package Project3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LCMult{
	public static void main(String[] args) {
		try {
		@SuppressWarnings("resource")
		Scanner input =new Scanner(System.in);
		Num n1 = new Num(input.nextLong());
		Num n2 = new Num(input.nextLong());
		System.out.println(n1.lcm(n2));
		}
		catch (InputMismatchException e) {
			System.out.println("input wrong");
		}
	}
}

class Num {
	private long[][] table;
	private long num;
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}
	public long[][] getTable() {
		return table;
	}
	public void setTable(long[][] table) {
		this.table = table;
	}
	public Num() {
		super();
		this.num=0;
	}
	public Num(long num) {
		super();
		this.num=num;
		//Initialize the two-dimensional array
		//table[i][0] store the numerical value of prime factor
		//table[i][1] store the number of prime factor
		table = new long[20][2];
		if(num==1) {
			table[0][0]=1;
			table[0][1]=1;
		}else if(num<=0) {
			System.out.println("number cannot less than 0");
		}else {
			long factor = 2;
			int i=0;		//i is the counter of the prime factor 
			int flag=0;		//flag record weather the factor had been added.
			while(factor<=num) {
				//num%factor == 0 iff factor is one of the prime factor 
				if(num%factor==0) {
					if(flag==1) i++;
					num = num/factor;
					table[i][0]=factor;
					table[i][1]++;	
					flag=0;
				}else {
					factor++;
					flag=1;
				}		
			}
		}
	}
	public long lcm(Num num) {
		if(num.getNum()<=0||this.num<=0) {
			return 0;
		}
		//construct a new table that store the numerical value and number of prime factor.
		long[][] table = new long[this.table.length+num.getTable().length][2];
		//merge two array 
		int i=0;
		int j=0;
		int k=0;
		while(i < this.table.length && j < num.getTable().length) {
			if(this.table[i][0] < num.getTable()[j][0]) {
				table[k][0] = this.table[i][0];
				table[k][1] = this.table[i][1];
				k++;i++;
			}else if(this.table[i][0] > num.getTable()[j][0]) {
				table[k][0] = num.getTable()[j][0];
				table[k][1] = num.getTable()[j][1];
				k++;j++;
			}else if(this.table[i][0] == num.getTable()[j][0]) {
				table[k][0] = this.table[i][0];
				table[k][1] = this.table[i][1]>num.getTable()[j][1]?this.table[i][1]:num.getTable()[j][1];
				k++;i++;j++;
			}
		}
		while(i<this.table.length) {
			table[k][0] = this.table[i][0];
			table[k][1] = this.table[i][1];
			k++;i++;
		}
		while(j<num.getTable().length) {
			table[k][0] = num.getTable()[j][0];
			table[k][1] = num.getTable()[j][1];
			k++;j++;
		}
		//According to the new table 't',we can calculate the lcm.
		long lcm=1;
		while(k-->0) {
			for(int q=1;q<=table[k][1];q++) {
				//System.out.print(table[k][0]);
				//System.out.println(" "+table[k][1]);
				lcm*=table[k][0];
			}
		}
		if(lcm<=0) {
			System.out.println("the number is too large");
			return 0;
		}
		return lcm;
	}
}
