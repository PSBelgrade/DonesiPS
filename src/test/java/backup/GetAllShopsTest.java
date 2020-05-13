package backup;

import classes.CarryImpl;
import dto.Shop;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class GetAllShopsTest {

    //getAllShops
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
    public void testMethod() {

        List<Shop> shopList = carry.getAllShops();
        System.out.println("Found " + shopList.size() + " shops!");
    }

    @Test
    public void getAllShops() {


        //getAllShops(), uzeti sve podatke iz postojeće tabele
        List<Shop> ListAllShops = carry.getAllShops();
        if (ListAllShops.isEmpty()) {
            System.out.println("No shops!");
            return;
        }
        for (Shop shop : ListAllShops)
            System.out.println("Shop: ID = " + shop.getId() + ", " +
                "ACCOUNT = " + shop.getAccount() + ", " +
                "PHONE = " + shop.getPhone() + ", " +
                "NAMEWORK = " + shop.getNameWork() + ", " +
                "ADDRESS = " + shop.getAddress());
    }
}