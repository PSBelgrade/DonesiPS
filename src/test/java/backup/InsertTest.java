package backup;

import classes.CarryImpl;
import dto.Shop;
import interfaces.Carry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

public class InsertTest {

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

//    @Test
//    //ubacivanje jela u tabelu Dish
//    public void insertDish() throws SQLException {
//
//        Dish dish = new Dish();
//        dish.setDishname("pizza1");
//        dish.setPrice(80);
//        dish.setQuantity(50);
////        dish.setId(2);
//
//        System.out.println(carry.insertDish(dish).getId());
//    }


    @Test
    public void name() throws SQLException {

        Shop shop = new Shop();

        shop.setAccount("99999");
        shop.setPhone("12345");
        shop.setNameWork("Kafana");
        shop.setAddress("Miljakovac2");
        //newShop.setId(13);

        //insertShop(Shops), ubacivanje novog objekta u tabelu
        carry.insertShop(shop);
        System.out.println("Shop: ID = " + shop.getId() + ", " +
            "ACCOUNT = " + shop.getAccount() + ", " +
            "PHONE = " + shop.getPhone() + ", " +
            "NAMEWORK = " + shop.getNameWork() + ", " +
            "ADDRESS = " + shop.getAddress());
    }}

//    @Test
//    public void insert2Test() throws SQLException{
//
//        Shop2 newShop2 = new Shop2();
//
//        newShop2.setAccount("789789");
//        newShop2.setPhone("12345");
//        newShop2.setNameWork("Kafana5");
//        newShop2.setAddress("Miljakovac2");
//        newShop2.setId(1);
//
//        //insertShop(shop), ubacivanje novog objekta u tabelu
//        carry.insertShop2(newShop2);
//        System.out.println("Shop: ID = " + newShop2.getId() + ", " +
//                "ACCOUNT = " + newShop2.getAccount() + ", " +
//                "PHONE = " + newShop2.getPhone() + ", " +
//                "NAMEWORK = " + newShop2.getNameWork() + ", " +
//                "ADDRESS = " + newShop2.getAddress());
//    }