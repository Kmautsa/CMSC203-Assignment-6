
public class Smoothie extends Beverage{
	private int numOfFruits;
	private boolean addProtein;
	private final double PROTEIN_COST = 1.50;
	private final double EXTRA_FRUIT = 0.50;
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein){
		super(bevName,Type.SMOOTHIE,size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	public int getNumOfFruits() {
		return numOfFruits;
	}
	public boolean getAddProtein(){
		return addProtein;
	}
	
	public void setNumofFruits(int numOfFruits)
	{
		this.numOfFruits = numOfFruits;
	}
	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}

	public String toString() {
		String str = getBevName() + ", " + getSize() + ", " + numOfFruits + "fruits";
				
				if(addProtein)
				{
					str += ", protein powder";
				}
				
				str += ", $" + calcPrice();
				return str;
	}
	public double calcPrice() {
	    double price = getBASE_PRICE();
	    int sizeMultiplier = 0;

	    switch (getSize()) {
	        case SMALL:
	            sizeMultiplier = 0;
	            break;
	        case MEDIUM:
	            sizeMultiplier = 2;
	            break;
	        case LARGE:
	            sizeMultiplier = 3;
	            break;
	    }

	    if (getAddProtein()) {
	        price += PROTEIN_COST;
	    }

	    int numOfExtraFruits = Math.max(0, getNumOfFruits() - 1);
	    price += numOfExtraFruits * EXTRA_FRUIT;

	    price += getSIZE_PRICE() * sizeMultiplier;

	    return price;
	}
	public boolean equals(Smoothie anotherBev) {
		boolean flag = false;
		if(super.equals(anotherBev) && this.numOfFruits == anotherBev.getNumOfFruits() && this.addProtein == anotherBev.getAddProtein())
		{
			flag = true;
		}
		return flag;
	}
	
}
