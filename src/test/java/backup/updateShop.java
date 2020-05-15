package backup;

import classes.CarryImpl;
import dto.Shop;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class updateShop {

    Carry carry = new CarryImpl();

    //before open connection
    @Before
    public void open() throws SQLException {
        System.out.println("open " + carry.open());
    }

    //after close connection
    @After
    public void close() {
        carry.close();
    }

    @Test
    public void name() {

        Shop shop = new Shop();
        shop.setAccount("987987");
        shop.setPhone("062111111");
        shop.setNameWork("Restoran");
        shop.setAddress("Autokomanda");
        shop.setId(3);
        carry.updateShop(shop);
    }
}