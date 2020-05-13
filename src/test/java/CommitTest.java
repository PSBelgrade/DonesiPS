import classes.CarryImpl;
import dto.Dish;
import dto.Shop2;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommitTest {

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
    //insert into Shop2
    public void insertShop2() throws SQLException {

        List<Dish> dishList = new ArrayList<>();
        Dish dish1 = new Dish();
        dish1.setDishname("jelo2");
        dish1.setPrice(55);
        dish1.setQuantity(68);
        dishList.add(dish1);

//        Dish dish2 = new Dish();
//        dish2.setName("jelo2");
//        dish2.setPrice(555);
//        dish2.setQuantity(666);
//        dishList.add(dish2);


        Shop2 shop2 = new Shop2();
        shop2.setAccount("123");
        shop2.setPhone("11");
        shop2.setNameWork("12");
        shop2.setAddress("13");
        shop2.setMenu(dishList);
        carry.insertShop2(shop2);
    }
}