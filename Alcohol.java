
public class Alcohol extends Beverage{
	private boolean isWeekend;
	private final double WeekendFee = 0.60;
	
	public Alcohol (String bevName, Size size, boolean isWeekend) {
		super(bevName, Type.ALCOHOL,size);
		this.isWeekend = isWeekend;
	}
	public double calcPrice() {
		double total = super.getBASE_PRICE();
				
				if(super.getSize() == Size.MEDIUM)
				{
					total += super.getSIZE_PRICE();
				}
				
				if(super.getSize() == Size.LARGE)
				{
					total += super.getSIZE_PRICE() * 2;
					
				}
				
				if(isWeekend)
				{
					total += WeekendFee;
				}
				
				return total;
	}
	public String toString() {
		return "The beverage name is " + getBevName() + " size " + getSize() + "\n" +
				"Weekend Price: " + isWeekend;
	}
	public boolean equals(Alcohol anotherBev) {
		boolean flag = false;
		if(super.equals(anotherBev) && this.isWeekend == anotherBev.getIsWeekend())
			flag = true;
		return flag;
	}
	public boolean getIsWeekend() {
		return isWeekend;
	}
	

}
