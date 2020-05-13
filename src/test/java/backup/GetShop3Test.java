package backup;

import classes.CarryImpl;
import dto.Dish;
import dto.Shop3;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetShop3Test {

    Carry carry = new CarryImpl();

    //before open connection
    @Before
    public void open() {
        System.out.println("open " + carry.open());
    }

    //after close connection
    @After
    public void close() {
        carry.close();
    }

    @Test
    public void getShop3() {

        //getShop2(id), uzeti shop iz tabele
        Shop3 shop = carry.getShop3(2);

        System.out.println("Shop: ID = " + shop.getId() + ", " +
                "ACCOUNT = " + shop.getAccount() + ", " +
                "PHONE = " + shop.getPhone() + ", " +
                "NAMEWORK = " + shop.getNamework() + ", " +
                "ADDRESS = " + shop.getAddress() + "  " + shop.getDishId());

        for (Dish dish : shop.getMenu())
            System.out.println("Dish: ID = " + dish.getId() + ", " +
                    "NAME = " + dish.getDishname() + ", " +
                    "PRICE = " + dish.getPrice() + ", " +
                    "QUANTITY = " + dish.getQuantity());
    }
}
