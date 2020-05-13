package database;

import java.sql.*;

public class ConnectClassNew {

//    public static final String TABLE1 = "CUSTOMER";
//    public static final String TABLE2 = "SHOPS";

    public static final String TABLE_ID = "ID";
    public static final String COLUMN_ACCOUNT = "ACCOUNT";
    public static final String COLUMN_NAMEWORK = "NAMEWORK";
    public static final String COLUMN_ADDRESS = "ADDRESS";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_PHONE = "PHONE";
    public static final String COLUMN_EMAIL = "EMAIL";

    public static Connection connect;
    public static Statement statement;

    public static void insertCustomer(Statement statement, String table, int id, String name, String phone, String email) throws SQLException {
        statement.execute("INSERT INTO " + table +
            " (" + TABLE_ID + ", " +
            COLUMN_NAME + ", " +
            COLUMN_PHONE + ", " + COLUMN_EMAIL +
            ") " +
            "VALUES(" + id + ", '" + name + "', '" + phone + "', '" + email + "')");
    }

    public static void insertShop(Statement statement, String table, int id, String account, String tel, String namework, String address) throws
        SQLException {
        statement.execute("INSERT INTO " + table +
            " (" + TABLE_ID + ", " +
            COLUMN_ACCOUNT + ", " + COLUMN_PHONE + ", " +
            COLUMN_NAMEWORK + ", " + COLUMN_ADDRESS +
            ") " +
            "VALUES(" + id + ", '" + account + "', '" + tel + "', '" + namework + "' , '" + address + "')");
    }


    public boolean connections2(String server, String port, String base, String username, String password) {

        boolean status = false;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            connect = DriverManager.getConnection("jdbc:oracle:thin:" + server + ":" + port + ":" + base, username, password);
            if (!connect.isClosed()) {
                status = true;
                System.out.println("Connection is successful!");
            } else {
                System.out.println("Connection unsuccessful!");
            }

            statement = connect.createStatement();

//            statement.execute("CREATE TABLE customer22" +
//                    "(id INTEGER, name varchar(20), phone varchar(20), email varchar(20))");

//            statement.execute("INSERT INTO customer(id, name, phone, email)" +
            //                   "VALUES(6, 'Dusan','5786','dusan@')");

            //           statement.execute("insert into shops(ID, ACCOUNT, TEL, NAMEWORK, ADDRESS)" +
            //                   "VALUES(4,'1234','062840','FastFood','Miljakovac')");
            //           statement.execute("DROP table customer20");

//            statement.execute("select t.*, t.rowid from SHOPS t");
//            ResultSet resultSet = statement.getResultSet();

//            while (resultSet.next()) {
//                System.out.println(resultSet.getInt("ID") + " " +
//                        resultSet.getString("ACCOUNT") + " " +
//                        resultSet.getString("TEL") + " " +
//                        resultSet.getString("NAMEWORK") + " " +
//                        resultSet.getString("ADDRESS"));
//            }


//            statement.execute("DROP TABLE " + TABLE);

//            insertCustomer(statement, 11, "Nikola", "1231235", "@nikola");
//           insertShop(statement, 7, "234567", "45632", "Pizzaa", "StariGrad");
//            insertShop(statement,  "345678", "4829484", "Pizzzaaa", "Zvezdara");

//            statement.execute("UPDATE " + TABLE + " SET " +
//                    COLUMN_TEL + "=5566789" +
//                    " WHERE " + COLUMN_ACCOUNT + "=123456");

//            statement.execute("DELETE FROM " + TABLE +
//                    " WHERE " + TABLE_ID + "=1");

//            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + TABLE);
//            while (resultSet.next()) {
            //               System.out.println(resultSet.getString(TABLEID) + " " +
            //                       resultSet.getString(COLUMN_ACCOUNT) + " " +
            //                       resultSet.getString(COLUMN_TEL) + " " +
            //                       resultSet.getString(COLUMN_NAMEWORK) + " " +
            //                       resultSet.getString(COLUMN_ADDRESS));
            //           }

            //           resultSet.close();
//            statement.close();
//            connect.close();

        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
        return status;
    }
}