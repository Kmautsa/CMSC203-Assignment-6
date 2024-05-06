import java.util.ArrayList;

public class BevShop implements BevShopInterface {
	private int numOfAlcoholInOrder;
	private int currentOrder;
	private ArrayList<Order> orders;
	
//	public ArrayList<Order> orders(){
//		
//	}
	
	public BevShop() {
		this.orders = new ArrayList<>();
	}
	
	@Override
	public boolean isValidTime(int time) {
		if(time >= MIN_TIME || time <= MAX_TIME)
		{
			return true;
		}
		return false;
	}

	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if(numOfFruits > MAX_FRUIT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getMaxOrderForAlcohol() {

		return  MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if(numOfAlcoholInOrder< 3){
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public int getNumOfAlcoholDrink() {
		return this.numOfAlcoholInOrder;
	}

	@Override
	public boolean isValidAge(int age) {
		if(age > MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		orders.add(order);
		currentOrder = orders.indexOf(order);
		numOfAlcoholInOrder = 0;
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		orders.get(currentOrder).addNewBeverage(bevName, size, extraShot, extraSyrup);	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		orders.get(currentOrder).addNewBeverage(bevName, size);
		numOfAlcoholInOrder++;
		
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		orders.get(currentOrder).addNewBeverage(bevName, size, numOfFruits, addProtein);
		
	}

	@Override
	public int findOrder(int orderNo) {
		int index = -1;
		for(int i = 0; i < orders.size(); i++){
			if(orders.get(i).getOrderNo() == orderNo){
				index = i;
			}
		}
		return index;
	}

	@Override
	public double totalOrderPrice(int orderNo) {
		double orderTotal = 0.0;
		orderTotal = orders.get(findOrder(orderNo)).calcOrderTotal();
		return orderTotal;

	}

	@Override
	public double totalMonthlySale() {
		double monthTotal = 0.0;
		for(int i = 0; i < orders.size(); i++)
		{
			monthTotal += orders.get(i).calcOrderTotal();
		}
		return monthTotal;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		int monthOrderNum = orders.size();
		return monthOrderNum;
	}

	@Override
	public Order getCurrentOrder() {
		return orders.get(currentOrder);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		Order orderIndex = orders.get(index);
		return orderIndex;
	}

	@Override
	public void sortOrders() {
		for (int i = 0; i < orders.size()-1; i++) 
		{
			int minOrderNumIdx = i;
			for (int j = i+1; j < orders.size(); j++) 
			{
				if (orders.get(j).getOrderNo() < orders.get(minOrderNumIdx).getOrderNo())
				{
					minOrderNumIdx = j;
				}
			}

			Order temp = orders.get(minOrderNumIdx);
			orders.set(minOrderNumIdx, orders.get(i));
			orders.set(i, temp);
		}
		
	}
	
	public String toString() {
		  StringBuilder builder = new StringBuilder();
	        builder.append("Orders:\n");
	        for (Order order : orders) {
	            builder.append(order.toString()).append("\n");
	        }
	        builder.append("Total Monthly Sale: $").append(totalMonthlySale());
	        return builder.toString();
		}
}
