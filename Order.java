import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>{
	final int MIN = 10000;
	final int MAX = 90000;
	private int orderNo;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> bevList;
	
	public Order(int orderTime,Day orderDay,Customer cust) {
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.orderNo = generateOrder();
		this.bevList = new ArrayList<>();

	}
	public int generateOrder() {
		int num = 0;		
		Random rand = new Random(MIN);
		num = rand.nextInt(MAX - MIN) + 1;
		return num;
	}
	public int getOrderNo() {
		return this.orderNo;
	}
	public int getOrderTime() {
		return this.orderTime;
	}
	public Day getOrderDay() {
		return this.orderDay;
	}
	public Customer getCustomer() {
		return new Customer(cust);
	}
	
	public int getTotalItems() {
		return bevList.size();
	}
	public ArrayList<Beverage> getBeverages()
	{
		return bevList;
	}
	public void setDay(Day orderDay) {
		this.orderDay=orderDay;
	}
	public void setOrderDay(Day orderDay) {
		this.orderDay=orderDay;
	}
	public void setCustomer(Customer cust)
	{
		this.cust = cust;
		
	}
	public void setOrderNo(int orderNo)
	{
		this.orderNo = orderNo;
		
	}
	
	@Override
	public boolean isWeekend() {
		if(this.orderDay == Day.SATURDAY || this.orderDay == Day.SUNDAY)
		{
			return true;
			
		}
		else
		{
			return false;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return bevList.get(itemNo);
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot,extraSyrup);
		bevList.add(coffee);
				
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		boolean isWeekend = false;
		if(this.orderDay == Day.SATURDAY || this.orderDay == Day.SUNDAY)
		{
			isWeekend = true;
		}
		Alcohol alcohol = new Alcohol(bevName,size, isWeekend);
		bevList.add(alcohol);		
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie smoothie = new Smoothie(bevName,size,numOfFruits,addProtein); 
		bevList.add(smoothie);
		
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		for(Beverage bevs : bevList)
		{
			total += bevs.calcPrice();
		}
		return total;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int totalofType = 0;
		for(Beverage b : bevList)
		{
			if(b.getType() == type)
			{
				totalofType++;
			}
		}
		
		return totalofType;
	}
	public String toString() {
		return "The Order Info is as follows; Order Number: " + orderTime + " Order Time: " + orderTime + 
				"Order Day: " + orderDay + " Customer Information: " + cust.getAge() + " " + cust.getName();
		
	}
	@Override
	public int compareTo(Order anotherOrder) {
		if(this.getOrderNo() == anotherOrder.getOrderNo())
		{
			return 0;
		}
		else if(this.getOrderNo() > anotherOrder.getOrderNo())
		{
			return 1;
		}
		else {
			return -1;
		}
	}
	

}
