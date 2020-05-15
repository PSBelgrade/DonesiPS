package backup;

import classes.CarryImpl;
import dto.Shop;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GetShopIdtest {

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
    public void getShopId() {


        //getShops(id), uzeti shop iz tabele
        //getShops(account), uzeti shop iz tabele
        Shop shop = carry.getShop(3);
        if (shop.getId() == null) {
            System.out.println("No shop!");

        } else {

            System.out.println("Shop: ID = " + shop.getId() + ", " +
                "ACCOUNT = " + shop.getAccount() + ", " +
                "PHONE = " + shop.getPhone() + ", " +
                "NAMEWORK = " + shop.getNameWork() + ", " +
                "ADDRESS = " + shop.getAddress());
        }
    }
}
