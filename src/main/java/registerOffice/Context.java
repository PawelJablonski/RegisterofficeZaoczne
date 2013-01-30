package registerOffice;

public final class Context {

	private int quantityOfOrders;
	private int quantityOfPeople;
	
	private Context() {
	}

	private static Context instance;

	public static Context getInstance() {
		
		if (instance == null)
			synchronized (Context.class) {
				if (instance == null)
					instance = new Context();
			}
		return instance;
	}
	
	public void reduceOrders()
	{
		this.quantityOfOrders--;
	}
	
	public void reducePeople()
	{
		this.quantityOfPeople--;
	}
	public void raiseNumberOfOrders()
	{
		this.quantityOfOrders++;
	}

	public void raisenumberOfPeople()
	{
		this.quantityOfPeople++;
	}
	
	public int getQuantityOfPeople()
	{
		return this.quantityOfPeople;
	}
	public int getQuantity()
	{
		return this.quantityOfOrders;
	}
}
