package classes;

import interfaces.Carry;
import dto.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import static java.lang.Class.forName;

public class CarryImpl implements Carry {

    public static final String CONN_STRING = "jdbc:mysql://localhost:3308/mydatabase?user=root";

//    public static final String DB_NAME = "etorcl11g";
//    public static final String SERVER = "@10.0.3.22";
//    public static final String PORT = "1521";
//    public static final String USERNAME = "PREDRAG";
//    public static final String PASSWORD = "PREDRAG";


    //get all Shops
    String getAllShops = "select t.id, t.account, t.phone, t.workname, t.address from SHOPS t";

    //get Shops WHERE id=?
    String getShopId = "select t.account, t.phone, t.workname, t.address from shops t where t.id = ?";

    //insert into shops
    //String insert = "insert into shops(id, account, phone, workname, address) values (SHOPS_S.NEXTVAL,?,?,?,?)";
    String insert = "insert into shops(account, phone, workname, address) values (?,?,?,?)";

//    insert into shops2
//    String insert2 = "insert into shops2(id, account, phone, workname, address) values (SHOPS2_S.NEXTVAL,?,?,?,?)";
//    String insert2 = "insert into shops2(account, phone, workname, address) values (?,?,?,?)";

    //public static final String insert
    //String insertD = "insert into dishes(id, dishname, price, quantity) values (DISHES_S.NEXTVAL,?,?,?)";
    String insertD = "insert into dishes(dishname, price, quantity) values (?,?,?)";

    //SELECT account, phone, workname, address FROM Shops WHERE account = ?
    String getShopAccount = "select t.id, t.phone, t.workname, t.address from shops t where t.account=?";

    //UPDATE shop from Shops
    String updateShop = "update shops t set t.account=?, t.phone=?, t.workname=?, t.address=? where t.id=?";

    //UPDATE shops SET account WHERE id = ?
    String updateShop2 = "update shops2 t set t.account=? where t.id=?";

    //DELETE Shops
    String deleteShop = "delete from shops t where t.id=?";

    //Search Shops WHERE account=? OR phone=? OR workname=? OR address=?
    String search = "select t.id, t.account, t.phone, t.workname, t.address from shops t " +
        "where t.account=? or t.phone=? or t.workname=? or t.address=?";

    //GET Shop2 WHERE id=?
    String getShop3Id = "select t.account, t.phone, t.workname, t.address, t.dishid from shops3 t where t.id=?";

    //Get dish WHERE id=?
    //String getDish = "select t.id, t.dishname, t.price, t.quantity from dishes t where t.id=?";
    String getDish = "select t.id, t.dishname, t.price, t.quantity from dishes t where t.id=?";

    //Search id shops
    String queryShop = "select t.id from shops t where t.account=?";

    //Search id Shops2
    //String queryShop2 = "select t.id from shops2 t where t.account=?";
    String queryShop2 = "select t.id from shops t where t.account=?";

    //Search id
    String queryDish = "select t.id from dishes t where t.dishname=?";

    //Select shop2_id i dish_id from shops2_dishes_xref where shop2_id=?
    String queryShop2Dish = "select t.shop2_id, t.dish_id from shops2_dishes_xref t where t.shop2_id=?";

    //Insert into x_ref table shop2_id, dish_id
    String insertShop2Dish = "insert into shops2_dishes_xref(shop2id, dishid ) values (?,?)";

    //returns the object Shop2
    String queryMenu = "select s.account, s.workname, d.id, d.dishname, d.price, d.quantity\n" +
        "from shops s join shops2_dishes_xref sd on sd.shop2id = s.id join dishes d on d.id = sd.dishid where s.id = ?";


    private Connection connect;
    //private PreparedStatement insertShop;
    private PreparedStatement getAllShopsLink,
        getShopIdLink,
        getShopAccountLink,
        insertShopLink,
        insertShop2,
        insertDishLink,
        insertShop2DishLink,
        updateShopLink,
        updateShop2Link,
        deleteShopLink,
        searchLink,
        getShop3Link,
        queryDishLink,
        queryShopLink,
        queryShop2Link,
        queryShop2DishLink,
        queryMenuLink,
        getDishLink;

    @Override
    public boolean open() {

        try {

//            connect = DriverManager.getConnection("jdbc:oracle:thin:" + SERVER + ":" + PORT + ":" + DB_NAME, USERNAME, PASSWORD);

            connect = DriverManager.getConnection(CONN_STRING);
            getAllShopsLink = connect.prepareStatement(getAllShops);
            getShopIdLink = connect.prepareStatement(getShopId);
            getShopAccountLink = connect.prepareStatement(getShopAccount);
//            insertShop = connect.prepareStatement(insert);
            insertShopLink = connect.prepareStatement(insert, PreparedStatement.RETURN_GENERATED_KEYS);
            insertDishLink = connect.prepareStatement(insertD, PreparedStatement.RETURN_GENERATED_KEYS);
//            insertShop2 = connect.prepareStatement(insert2);
            insertShop2DishLink = connect.prepareStatement(insertShop2Dish);
            //new String[] { TABLE_ID }
            updateShopLink = connect.prepareStatement(updateShop);
            updateShop2Link = connect.prepareStatement(updateShop2);
            deleteShopLink = connect.prepareStatement(deleteShop);
            searchLink = connect.prepareStatement(search);
            getShop3Link = connect.prepareStatement(getShop3Id);
            queryShopLink = connect.prepareStatement(queryShop);
            queryShop2Link = connect.prepareStatement(queryShop2);
            queryDishLink = connect.prepareStatement(queryDish);
            getDishLink = connect.prepareStatement(getDish);
            queryShop2DishLink = connect.prepareStatement(queryShop2Dish);
            queryMenuLink = connect.prepareStatement(queryMenu);
            return true;

        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database: " + e.getMessage());
            return false;
        }
    }

    @Override
    public void close() {

        try {
            if (getAllShopsLink != null ||
                insertShopLink != null ||
                insertShop2 != null ||
                getShopIdLink != null ||
                getShopAccountLink != null ||
                insertShop2DishLink != null ||
                updateShopLink != null ||
                updateShop2Link != null ||
                deleteShopLink != null ||
                getShop3Link != null ||
                queryShopLink != null ||
                queryShop2Link != null ||
                queryDishLink != null ||
                getDishLink != null ||
                queryShop2DishLink != null ||
                queryMenuLink != null ||
                searchLink != null ||
                connect != null) {

                getAllShopsLink.close();
                insertShopLink.close();
//                insertShop2.close();
                getShopIdLink.close();
                getShopAccountLink.close();
                insertShop2DishLink.close();
                updateShopLink.close();
                updateShop2Link.close();
                deleteShopLink.close();
                getShop3Link.close();
                queryShopLink.close();
                queryShop2Link.close();
                queryDishLink.close();
                getDishLink.close();
                queryShop2DishLink.close();
                queryMenuLink.close();
                searchLink.close();
                connect.close();
                System.out.println("Connect close!");
            }

//            if (searchLink != null) {
//                searchLink.close();
//            }

        } catch (SQLException e) {
            System.out.println("Couldn't connect to the database and close connection: " + e.getMessage());
            e.printStackTrace();
        }
    }


    @Override
    //select all from Shops
    public List<Shop> getAllShops() {

        try {

            ResultSet results = getAllShopsLink.executeQuery();

            List<Shop> shopList = new ArrayList<>();
            while (results.next()) {
                Shop shop = new Shop();
                shop.setId(results.getInt("ID"));
                shop.setAccount(results.getString("ACCOUNT"));
                shop.setPhone(results.getString("PHONE"));
                shop.setNameWork(results.getString("WORKNAME"));
                shop.setAddress(results.getString("ADDRESS"));
                shopList.add(shop);
            }
            return shopList;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }

    @Override
    //select from Shops where id=?
    public Shop getShop(int id) {

        try {

            getShopIdLink.setInt(1, id);
            ResultSet results = getShopIdLink.executeQuery();

            Shop shop = new Shop();
            while (results.next()) {

                shop.setId(id);
                shop.setAccount(results.getString("ACCOUNT"));
                shop.setPhone(results.getString("PHONE"));
                shop.setNameWork(results.getString("WORKNAME"));
                shop.setAddress(results.getString("ADDRESS"));
            }

            return shop;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    //select from Shops where account=?
    public Shop getShop(String account) {

        try {

            getShopAccountLink.setString(1, account);
            ResultSet results = getShopAccountLink.executeQuery();

            Shop shop = new Shop();
            while (results.next()) {

                shop.setId(results.getInt("ID"));
                shop.setAccount(account);
                shop.setPhone(results.getString("PHONE"));
                shop.setNameWork(results.getString("WORKNAME"));
                shop.setAddress(results.getString("ADDRESS"));
            }

            return shop;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    //insert shop into the table Shops
    public Shop insertShop(Shop shop) throws SQLException {

        queryShopLink.setString(1, shop.getAccount());
        ResultSet results = queryShopLink.executeQuery();
        if (results.next()) {
            shop.setId(results.getInt("ID"));
            return shop;

        } else {

            // insert the shop
            insertShopLink.setString(1, shop.getAccount());
            insertShopLink.setString(2, shop.getPhone());
            insertShopLink.setString(3, shop.getNameWork());
            insertShopLink.setString(4, shop.getAddress());
            //int affectedRows = insertShopLink.executeUpdate();
            insertShopLink.executeUpdate();

            /*
            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert shop!");

            } else {
                queryShopLink.setString(1, shop.getAccount());
                results = queryShopLink.executeQuery();
                if (results.next()) shop.setId(results.getInt("id"));
            */

            results = insertShopLink.getGeneratedKeys();
            results.next();
            int autoGeneratedID = results.getInt(1);
            shop.setId(autoGeneratedID);
            return shop;
        }
    }

    @Override
    //insert shop into the table Shops2
    public Shop2 insertSh(Shop2 s) throws SQLException {

        queryShopLink.setString(1, s.getAccount());
        ResultSet results = queryShopLink.executeQuery();
        if (results.next()) {
            s.setId(results.getInt("ID"));
            return s;

        } else {

            // insert the shop
            insertShopLink.setString(1, s.getAccount());
            insertShopLink.setString(2, s.getPhone());
            insertShopLink.setString(3, s.getNameWork());
            insertShopLink.setString(4, s.getAddress());
            //int affectedRows = insertShopLink.executeUpdate();
            insertShopLink.executeUpdate();

            /*
            if (affectedRows != 1) {
                throw new SQLException("Couldn't insert shop!");

            } else {
                queryShopLink.setString(1, s.getAccount());
                results = queryShopLink.executeQuery();
                if (results.next()) s.setId(results.getInt("id"));
            */

            results = insertShopLink.getGeneratedKeys();
            results.next();
            int autoGeneratedID = results.getInt(1);
            s.setId(autoGeneratedID);
            return s;
        }
    }

    @Override
    //insert shop2 into the table Shops2, Dish and Shop2DishXref
    public Shop2 insertShop2(Shop2 shop2) throws SQLException {

        try {
            connect.setAutoCommit(false);

            //the query return id if its exist in the database
            queryShop2Link.setString(1, shop2.getAccount());
            ResultSet results = queryShop2Link.executeQuery();

            if (results.next()) {
                shop2.setId(results.getInt("ID"));

                List<Dish> dishList = new ArrayList<>();
                for (int i = 0; i < shop2.getMenu().size(); i++) {
                    Dish dish;

                    //the query return id if its exist in the database
                    queryDishLink.setString(1, shop2.getMenu().get(i).getDishname());
                    results = queryDishLink.executeQuery();

                    if (results.next()) {

                        throw new SQLException("The combination already exists!");

                    } else {

                        //insert dish or drink with the implemented method insertDish(dish)
                        dish = insertDish(shop2.getMenu().get(i));
                        insertShop2DishLink.setInt(1, shop2.getId());
                        insertShop2DishLink.setInt(2, dish.getId());
                        insertShop2DishLink.executeUpdate();
                        dishList.add(dish);
                    }
                    dishList.add(shop2.getMenu().get(i));
                }
                shop2.setMenu(dishList);
                connect.commit();
                return shop2;

            } else {

                //insert the shop2
                Shop2 newshop2;
                newshop2 = insertSh(shop2);
                insertShop2DishLink.setInt(1, newshop2.getId());


                List<Dish> dishList = new ArrayList<>();
                for (int i = 0; i < shop2.getMenu().size(); i++) {

                    Dish dish;
                    //insert dish or drink with the implemented method insertDish()
                    dish = insertDish(shop2.getMenu().get(i));

                    insertShop2DishLink.setInt(2, dish.getId());
                    insertShop2DishLink.executeUpdate();
                    dishList.add(dish);
                }

                newshop2.setMenu(dishList);
                connect.commit();
                return newshop2;
            }

        } catch (SQLException e) {
            System.out.println("Insert shop exception: " + e.getMessage());

            try {
                System.out.println("Performing rollback");
                connect.rollback();

            } catch (SQLException e2) {
                e2.getMessage();
            }
            return null;

        } finally {

            try {
                System.out.println("Resetting default commit behavior");
                connect.setAutoCommit(true);

            } catch (SQLException e) {
                System.out.println("Couldn't reset auto-commit! " + e.getMessage());
            }
        }
    }

    @Override
    public Dish insertDish(Dish dish) throws SQLException {

        queryDishLink.setString(1, dish.getDishname());
        ResultSet results = queryDishLink.executeQuery();
        if (results.next()) {
            dish.setId(results.getInt("id"));
            return dish;

        } else {

            // insert the dish
            insertDishLink.setString(1, dish.getDishname());
            insertDishLink.setFloat(2, dish.getPrice());
            insertDishLink.setInt(3, dish.getQuantity());
            insertDishLink.executeUpdate();

            results = insertDishLink.getGeneratedKeys();
            results.next();
            int autoGeneratedID = results.getInt(1);

//            if (autoGeneratedID != 1) {
//                throw new SQLException("Couldn't insert dish!");
//
//            } else {

            dish.setId(autoGeneratedID);
            /*queryDishLink.setString(1, dish.getDishname());
            results = queryDishLink.executeQuery();
            if (results.next()) dish.setId(results.getInt("ID"));*/
            return dish;
        }
    }

    @Override
    public Shop updateShop(Shop shop) {

        try {
            updateShopLink.setString(1, shop.getAccount());
            updateShopLink.setString(2, shop.getPhone());
            updateShopLink.setString(3, shop.getNameWork());
            updateShopLink.setString(4, shop.getAddress());
            updateShopLink.setInt(5, shop.getId());
            updateShopLink.executeUpdate();
            return shop;

        } catch (SQLException e) {
            e.getMessage();
            return null;
        }
    }

    @Override
    public boolean deleteShop(int id) {

        try {
//            deleteShop.setString(1, shop.getAccount());
//            deleteShop.setString(2, shop.getPhone());
//            deleteShop.setString(3, shop.getNameWork());
//            deleteShop.setString(4, shop.getAddress());
            deleteShopLink.setInt(1, id);
            deleteShopLink.executeQuery();
            return true;

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    //search Shops where filter=?
    public List<Shop> searchShops(ShopFilter filter) {

        try {

            searchLink.setString(1, filter.getAccount());
            searchLink.setString(2, filter.getPhone());
            searchLink.setString(3, filter.getNameWork());
            searchLink.setString(4, filter.getAddress());

            ResultSet results = searchLink.executeQuery();

            List<Shop> shopList = new ArrayList<>();
            while (results.next()) {
                Shop shop = new Shop();
                shop.setId(results.getInt("ID"));
                shop.setAccount(results.getString("ACCOUNT"));
                shop.setPhone(results.getString("PHONE"));
                shop.setNameWork(results.getString("NAMEWORK"));
                shop.setAddress(results.getString("ADDRESS"));
                shopList.add(shop);
            }
            return shopList;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    @Override
    //select all from Shop3 where id=?
    public Shop3 getShop3(int id) {

        try {

            getShop3Link.setInt(1, id);
            ResultSet results = getShop3Link.executeQuery();

            Shop3 shop = new Shop3();
            while (results.next()) {

                shop.setId(id);
                shop.setAccount(results.getString("ACCOUNT"));
                shop.setPhone(results.getString("PHONE"));
                shop.setNamework(results.getString("WORKNAME"));
                shop.setAddress(results.getString("ADDRESS"));
                shop.setDishId(results.getInt("DISHID"));

                getDishLink.setInt(1, shop.getDishId());
                results = getDishLink.executeQuery();

                List<Dish> dishList = new ArrayList<>();
                while (results.next()) {
                    Dish dish = new Dish();
                    dish.setId(shop.getDishId());
                    dish.setDishname(results.getString("NAME"));
                    dish.setPrice(results.getFloat("PRICE"));
                    dish.setQuantity(results.getInt("QUANTITY"));
                    dishList.add(dish);
                }
                shop.setMenu(dishList);
            }
            return shop;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }


    @Override
    //select all from Shops2_Dishes_Xref
    public Shop2 getShop2Dish(int id) {

        try {

            queryMenuLink.setInt(1, id);
            ResultSet results = queryMenuLink.executeQuery();

            Shop2 shop2 = new Shop2();
            List<Dish> dishList = new ArrayList<>();
            while (results.next()) {

                shop2.setId(id);
                shop2.setAccount(results.getString("ACCOUNT"));
                //shop2.setPhone(results.getString("PHONE"));
                shop2.setNameWork(results.getString("WORKNAME"));
                //shop2.setAddress(results.getString("ADDRESS"));

//                Shop2Dish shop2dish = new Shop2Dish();
//                shop2dish.setShop2Id(results.getInt("SHOP2_ID"));
//                shop2dish.setDishId(results.getInt("DISH_ID"));


                Dish dish = new Dish();
                dish.setId(results.getInt("ID"));
                dish.setDishname(results.getString("DISHNAME"));
                dish.setPrice(results.getFloat("PRICE"));
                dish.setQuantity(results.getInt("QUANTITY"));
                dishList.add(dish);

            }
            shop2.setMenu(dishList);
            return shop2;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}