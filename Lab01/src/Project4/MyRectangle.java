package Project4;

public class MyRectangle {
	
	public static void main(String[] args) {
		MyRectangle r1 = new MyRectangle(4,40);
		MyRectangle r2 = new MyRectangle(3.5,35.9);
		r1.setColor("RED");
		r2.setColor("RED");
		System.out.println("r1's properties:  " + r1.toString());
		System.out.println("the area: "+r1.getArea()+"  the perimeter: "+r1.getPerimeter());
		System.out.println("r2's properties:  " +r2.toString());
		System.out.println("the area: "+r2.getArea()+"  the perimeter: "+r2.getPerimeter());
	}
	
	private double width;
	private double height;
	private String color;
	public MyRectangle(double width, double height) {
		super();
		this.setWidth(width);
		this.setHeight(height);
		this.setColor("WHITE");
	}
	public MyRectangle() {
		super();
		this.setWidth(100);
		this.setHeight(100);
		this.setColor("WHITE");
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		if(width>0) {
			this.width = width;
		}else {
			this.width = 100;
			System.out.println("input wrong");
		}
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		if(height>0) {
			this.height = height;
		}else {
			this.height = 100;
			System.out.println("input wrong");
		}
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getArea() {
		return width*height;
	}
	public double getPerimeter() {
		return (width+height)*2;
	}
	@Override
	public String toString() {
		return "width: "+width + "  height:" + height + "  color:" + color; 
	}
}
