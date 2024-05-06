

public class BevShopDriverApp {

	public static void main(String[] args) {

		BevShop bevShop = new BevShop();
		System.out.println(bevShop.getMaxOrderForAlcohol());
		System.out.println(bevShop.getMinAgeForAlcohol());
		
		bevShop.startNewOrder(10, Day.MONDAY, "Montero", 29);
		
		System.out.println("The total is : " + bevShop.getCurrentOrder().calcOrderTotal());
		
		Customer c = new Customer("Santiago", 24);
		System.out.println(c.getAge());
		System.out.println(c.getName());
		System.out.println(bevShop.getCurrentOrder().getCustomer().getName());
		if(bevShop.isValidAge(c.getAge()))
		{
			System.out.println(c.getName() + " can drink alcohol");
			bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
		}
		System.out.println(bevShop.getCurrentOrder().calcOrderTotal());
		bevShop.processCoffeeOrder("Dark Coffee", Size.LARGE, false, true);
		System.out.println(bevShop.getCurrentOrder().calcOrderTotal());
		System.out.println(bevShop.getOrderAtIndex(0));
		System.out.println(bevShop.getNumOfAlcoholDrink());
		bevShop.processSmoothieOrder("Banana Smoothie", Size.LARGE, 3, true);
		bevShop.sortOrders();
		System.out.println(bevShop.getCurrentOrder().getTotalItems());
		System.out.println(bevShop.getCurrentOrder().calcOrderTotal());


	}
}