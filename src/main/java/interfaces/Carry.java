package interfaces;

import dto.*;

import java.sql.SQLException;
import java.util.List;

public interface Carry {

    boolean open();

    void close();

    //Returns shops from table Shops
    List<Shop> getAllShops();

    //Search for Shops by id
    Shop getShop(int id);

    //Search for Shops by other columns
    Shop getShop(String account);

    //Insert Shop into the table Shops
    Shop insertShop(Shop shop) throws SQLException;

    //Insert Shop into the table Shops2
    Shop2 insertShop2(Shop2 shop2) throws SQLException;

    //Insert Shop into the table Shops2
    Shop2 insertSh(Shop2 s) throws SQLException;

    //Insert Dish into the table Dish
    Dish insertDish(Dish dish) throws SQLException;

    //Update shop in table
    Shop updateShop(Shop shop);

    //Delete shop by id
    boolean deleteShop(int id);

    //Search the shop by special criteria
    List<Shop> searchShops(ShopFilter filter);

    //Search Shop3 by id
    Shop3 getShop3(int id);

    //Search Shop2 by id // using Shop2Dish
    Shop2 getShop2Dish(int id);

}