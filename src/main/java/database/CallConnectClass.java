package database;

public class CallConnectClass {

    public static final String DB_NAME = "etorcl11g";
    public static final String SERVER = "@10.0.3.22";
    public static final String PORT = "1521";
    public static final String USERNAME = "PREDRAG";
    public static final String PASSWORD = "PREDRAG";


    public static void main(String args[]) {

        ConnectClassNew call = new ConnectClassNew();

        try {

            System.out.println(call.connections2(SERVER, PORT, DB_NAME, USERNAME, PASSWORD));
            call.insertShop(call.statement, "SHOPS", 11, "45678", "12345", "Kafana5", "Miljakovac2");
            call.insertCustomer(call.statement, "CUSTOMER", 15, "Marija", "12536454", "@marija");

            call.statement.close();
            call.connect.close();

        } catch (Exception e) {
            e.getMessage();
        }
    }
}