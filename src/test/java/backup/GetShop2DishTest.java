package backup;

import classes.CarryImpl;
import dto.Dish;
import dto.Shop2;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetShop2DishTest
{

	//select all from shop2_dish
	Carry carry = new CarryImpl();

	//before open connection
	@Before public void open()
	{
		System.out.println("open " + carry.open());
	}

	//after close connection
	@After public void close()
	{
		carry.close();
	}

	@Test public void name()
	{

		Shop2 shop2 = carry.getShop2Dish(11);

		System.out.println(
				"Shop: ID = " + shop2.getId() + ", " + "ACCOUNT = " + shop2.getAccount() + ", " + "PHONE = " + shop2
						.getPhone() + ", " + "NAMEWORK = " + shop2.getNameWork() + ", " + "ADDRESS = " + shop2
						.getAddress());

		for (Dish dish : shop2.getMenu())
			System.out.println(
					"Dish: ID = " + dish.getId() + ", " + "NAME = " + dish.getDishname() + ", " + "PRICE = " + dish
							.getPrice() + ", " + "QUANTITY = " + dish.getQuantity());
	}
}