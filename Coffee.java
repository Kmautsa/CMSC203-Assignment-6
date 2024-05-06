
public class Coffee extends Beverage {
	boolean extraShot;
	boolean extraSyrup;
	private final double EXTRASHOT = .50;
	private final double EXTRASYRUP = .50;
	public Coffee(String bevName,Size size, boolean extraShot, boolean extraSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	public void setExtraShot(boolean extraShot)
	{
		this.extraShot = extraShot;
	}
	public void setExtraSyrup(boolean extraSyrup)
	{
		this.extraSyrup = extraSyrup;
		
	}
	public boolean getExtraShot() {
		return extraShot;
	}
	public boolean getExtraSyrup() {
		return extraSyrup;
	}
	public double calcPrice() {
		double totalPrice = super.getBASE_PRICE();
				
				if(super.getSize() == Size.MEDIUM)
				{
					totalPrice += super.getSIZE_PRICE();
				}
				else if(super.getSize() == Size.LARGE)
				{
					totalPrice += 2 * super.getSIZE_PRICE();
					
				}
				
				if(extraShot)
				{
					totalPrice += EXTRASHOT;
				}
				if(extraSyrup)
				{
					totalPrice += EXTRASYRUP;
				}
				
				return totalPrice;
	}
	public String toString() {
		return getBevName() + "size : " + getSize() + "\n" +
				"Extra Shot :" + extraShot + "\n" + 
				"Extra Syrup: " + extraSyrup;
	}
	public boolean equals(Coffee anotherBev) {
		boolean flag = false;
		if(super.equals(anotherBev) && this.extraShot == anotherBev.getExtraShot() 
				&& this.extraSyrup == anotherBev.getExtraSyrup())
						flag = true;
		
		return flag;
	}
	
	
}
