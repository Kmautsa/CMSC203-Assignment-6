/*
 * Class: CMSC203 
 * Instructor:Khandan Monshi
 * Due: 5/5/2024
 * Platform/compiler:Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Kudzanai Mautsa
*/

public abstract class Beverage {
	private String bevName;
	private Type type;
	private Size size;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_PRICE = 1;
	
	public Beverage(String bevName, Type type, Size size) {
		this.bevName=bevName;
		this.type =type;
		this.size=size;
		
	}
 
	public double getBASE_PRICE() {
		return BASE_PRICE;
	}
	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}
	
	public Type getType() {
		return type;
	}
	
	public String getBevName() {
		return bevName;
	}
	
	public Size getSize() {
		return size;
	}
	

	@Override
	public String toString() {
		return "The beverage name is " + bevName + " and the size is " + size;
	}
	
	public boolean equals(Beverage anotherBev) {
		boolean flag = false; 
		if(bevName.equals(anotherBev.getBevName()) && this.type == anotherBev.getType()&& this.size == anotherBev.getSize())
		{
			flag = true;
		}
		return flag;
	
	}
	
	public abstract double calcPrice();
	
	public void setSize(Size size) {
		this.size=size;
	}
	public void setType(Type type) {
		this.type=type;
	}
	public void setBevName(String bevName) {
		this.bevName=bevName;
	}
	
	}
