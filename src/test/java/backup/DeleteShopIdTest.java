package backup;

import classes.CarryImpl;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DeleteShopIdTest {

    //delete shops where id=?
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

        //deleteShop(id), brisanje postojećeg objekta iz tabele
        System.out.println(carry.deleteShop(1));
    }
}
