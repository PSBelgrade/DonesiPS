package backup;

import classes.CarryImpl;
import dto.Shop;
import dto.ShopFilter;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class SearchShopTest {

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
    public void name() {

        //serachShop(filter), pretraga objekta po određenom kriterijumu
        ShopFilter filter = new ShopFilter();

        filter.setAddress("Miljakovac2");
        //filter.setNameWork("Restoran");

        List<Shop> shopList = carry.searchShops(filter);
        if (shopList.isEmpty()) {
            System.out.println("No shops!");
            return;
        }
        for (Shop shop : shopList) {
            System.out.println("Shop: ID = " + shop.getId() + ", " +
                "ACCOUNT = " + shop.getAccount() + ", " +
                "PHONE = " + shop.getPhone() + ", " +
                "WORKNAME = " + shop.getNameWork() + ", " +
                "ADDRESS = " + shop.getAddress());
        }
    }
}
