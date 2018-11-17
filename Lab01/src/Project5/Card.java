package Project5;

import java.util.Stack;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Card extends HBox{
	private ImageView[] card = new ImageView[4];
	private int[] numOfCard = new int[4];
	
	Card(){
		for(int i =0;i<4;i++) {
			card[i]=new ImageView("file:bin\\card\\backCard.png");
			card[i].setFitHeight(150);
			card[i].setFitWidth(110);
			getChildren().add(card[i]);
		}
		numOfCard = new int[4];
		for(int i =0;i<4;i++) {
			numOfCard[i] = 0;
		}
	}
	
	public void refresh(){
		//generate four random integer from 1 to 52,and assign them to each card
		for(int i = 0;i<4;i++) {
			numOfCard[i] = 1 +(int)(Math.random() * 52);
			for(int j =0;j<i;j++) {
				if(numOfCard[i] == numOfCard[j]) {
					i--;
					break;
				}
			}
		}
		//change each card's image
		for(int i = 0;i<4;i++) {
			card[i].setImage(new Image("file:bin\\card\\" + numOfCard[i] + ".png"));
		}
	}
	
	public boolean check(String s) {
		Stack<Character> char_stack= new Stack<Character>();
		char c = 0;
		//check whether the brackets are right.
		for (int i = 0; i < s.length(); i++) {
			if ('(' == s.charAt(i) || '[' == s.charAt(i))
				char_stack.push(s.charAt(i));
			else
				if (')' == s.charAt(i) || ']' == s.charAt(i))
					if(char_stack.empty()) {
						return false;
					}else
					c = char_stack.pop(); 
					if ((')' == s.charAt(i) && '(' != c)
						|| (']' == s.charAt(i) && '[' != c)){
						return false;
						}
		}
		if(!char_stack.empty()) return false;
		return true;
	}
	
	public String verify(String s) {
		if(!check(s))
			return "the string is wrong";		
		//turn infix expression into postfix expression,which only support double-digit calculation
		Stack<Character> char_stack= new Stack<Character>();
		int num = 0;
		int count = 0;
		char[] store = new char[20];
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) > '0' && s.charAt(i) <= '9') {
				num = s.charAt(i)-'0';
				if(i<s.length()-1 && s.charAt(i+1)>='0' && s.charAt(i+1)<='9') {
					num=(int)(s.charAt(++i)-'0')+num*10;
				}
				store[count++] = (char)(num+'0');
			}
			else if(s.charAt(i) == '+' || s.charAt(i) == '-') {
					//when the last sign is not number,it is wrong
					if(s.charAt(i - 1)<'0' && s.charAt(i - 1)!=']' && s.charAt(i - 1)!=')') {
						return "the string is wrong";
					}
					while(!char_stack.empty()  
							&& char_stack.peek()!='(' && char_stack.peek()!='[') {
						store[count++] = char_stack.pop();
					}
					char_stack.push(s.charAt(i));
				}
			else if(s.charAt(i) == '(' || s.charAt(i) == '[') {
					
					char_stack.push(s.charAt(i));
				}
			else if(s.charAt(i) == '*' || s.charAt(i) == '/') {
					//when the last sign is not number,it is wrong
					if(s.charAt(i - 1)<'0' && s.charAt(i - 1)!=']' && s.charAt(i - 1)!=')') {
						return "the string is wrong";
					}
					while(!char_stack.empty()
							&& char_stack.peek()!='+' && char_stack.peek()!='-'
							&& char_stack.peek()!='(' && char_stack.peek()!='[') {
						store[count++] = char_stack.pop();
					}
					char_stack.push(s.charAt(i));
				}
			else if(s.charAt(i) == ')' || s.charAt(i) == ']') {
				//when the last sign is not number,it is wrong
					if(s.charAt(i - 1)<'0' && s.charAt(i - 1)!=']' && s.charAt(i - 1)!=')') {
						return "the string is wrong";
					}
					while(char_stack.peek()!='(' || char_stack.peek()!='(') {
						store[count++] = char_stack.pop();
					}
					char_stack.pop();
				}
			else return "the string is wrong";
		}
		while(!char_stack.empty()) {
			store[count++] = char_stack.pop();
		}
		
		//calculate the postfix expression
		Stack<Double> int_stack = new Stack<Double>();
		double a,b;
		for(int i = 0; i<count;i++) {
			 if(store[i]>'0') {
				 int_stack.push((double)(store[i]-'0'));
			 }else
				 if(store[i] == '+') {
					 a=int_stack.pop();
					 b=int_stack.pop();
					 int_stack.push(a+b);
				 }else
					 if(store[i] == '-') {
						 a=int_stack.pop();
						 b=int_stack.pop();
						 int_stack.push(b-a);
					 }else
						 if(store[i] == '*') {
							 a=int_stack.pop();
							 b=int_stack.pop();
							 int_stack.push(a*b);
						 }else
							 if(store[i] == '/') {
								 a=int_stack.pop();
								 b=int_stack.pop();
								 int_stack.push(b/a);
							 }
		}
		if(int_stack.pop()==24) {
			return "yes";
		}else return "no";
	}
	
	public String findSolution() {
		//this is a ugly algorithm,which will execute 24*64 times in worst condition.
		String s;
		//try every means of numOfCard arrangement
		for(int i = 0;i < 4;i++) {
			if((s=find(numOfCard[i],numOfCard[(i+1)%4],numOfCard[(i+2)%4],numOfCard[(i+3)%4])).charAt(0)!=' ')
				return s;
			if((s=find(numOfCard[i],numOfCard[(i+1)%4],numOfCard[(i+3)%4],numOfCard[(i+2)%4])).charAt(0)!=' ')
				return s;
			if((s=find(numOfCard[i],numOfCard[(i+2)%4],numOfCard[(i+1)%4],numOfCard[(i+3)%4])).charAt(0)!=' ')
				return s;
			if((s=find(numOfCard[i],numOfCard[(i+2)%4],numOfCard[(i+3)%4],numOfCard[(i+1)%4])).charAt(0)!=' ')
				return s;
			if((s=find(numOfCard[i],numOfCard[(i+3)%4],numOfCard[(i+1)%4],numOfCard[(i+2)%4])).charAt(0)!=' ')
				return s;
			if((s=find(numOfCard[i],numOfCard[(i+3)%4],numOfCard[(i+2)%4],numOfCard[(i+3)%4])).charAt(0)!=' ')
				return s;
		}
		return "no solution";
	}
	
	public String find(double a,double b,double c,double d) {                                                          
		a=(a-1)%13+1;
		b=(b-1)%13+1;
		c=(c-1)%13+1;
		d=(d-1)%13+1;
		//try every means of sign arrangement
		char sign[] = new char[4];
		sign[0]='+';sign[1]='-';sign[2]='*';sign[3]='/';
		double result = 0;
		for(char firstSign : sign) {
			for(char secondSign : sign) {
				for(char thirdSign : sign) {
					if(firstSign == '+') {
						result = a+b;
					}
					else if(firstSign == '-') {
						result = a-b;
					}
					else if(firstSign == '*') {
						result = a*b;
					}
					else if(firstSign == '/') {
						result = a/b;
					}
					if(secondSign == '+') {
						result += c;
					}
					else if(secondSign == '-') {
						result -= c;
					}
					else if(secondSign == '*') {
						result *= c;
					}
					else if(secondSign == '/') {
						result /= c;
					}
					if(thirdSign == '+') {
						result += d;
					}
					else if(thirdSign == '-') {
						result -= d;
					}
					else if(thirdSign == '*') {
						result *= d;
					}
					else if(thirdSign == '/') {
						result /= d;
					}
					if(result==24) {
						//add brackets to expression and return it as string
						if((firstSign=='+'||firstSign=='-')
								&&(secondSign=='*'||secondSign=='/'))
							return "("+(int)a+" "+firstSign+" "+(int)b+")"+" "+secondSign+" "+(int)c+" "+thirdSign+" "+(int)d;
						if((firstSign=='+'||firstSign=='-')
								&&(secondSign=='+'||secondSign=='-')&&(thirdSign=='*'||thirdSign=='/'))
							return "("+"("+(int)a+" "+firstSign+" "+(int)b+")"+" "+secondSign+" "+(int)c+")"+" "+thirdSign+" "+(int)d;
						if((firstSign=='*'||firstSign=='/')
								&&(secondSign=='+'||secondSign=='-')&&(thirdSign=='*'||thirdSign=='/'))
							return "("+(int)a+" "+firstSign+" "+(int)b+" "+secondSign+" "+(int)c+")"+" "+thirdSign+" "+(int)d;
						return (int)a+" "+firstSign+" "+(int)b+" "+secondSign+" "+(int)c+" "+thirdSign+" "+(int)d;
					}
				}
			}
		}
		return " ";
			
	}
}
