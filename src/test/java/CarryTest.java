import classes.CarryImpl;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;

public class CarryTest {

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

}