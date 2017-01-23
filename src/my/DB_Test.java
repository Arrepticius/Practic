package my;

import java.sql.*;


/**
 * Created by Arrepticius on 21.01.2017.
 */
public class DB_Test {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    private static final String USER_NAME = "root";
    private static final String PASS = "java";



    public static void main(String[] args) {
        addMySQLToClasspath();


        getData();

    }

    private static void addMySQLToClasspath(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Connection getDBConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL,USER_NAME,PASS);
    }

    /*private static void createDbUserTable() {
        Connection dbConnection = null;
        Statement statement = null;

        String createTableSQL = "CREATE TABLE if not EXISTS DBUSER"
                +"("
                + "USER_ID INT(5) NOT NULL, "
                + "USERNAME VARCHAR(20) NOT NULL, "
                + "USERLASTNAME VARCHAR (20) NOT NULL,"
                + " PRIMARY KEY (USER_ID)"
                + ")";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }*/
   /* private static String insertDB = "insert into DBUSER"
            +"(USER_ID, USERNAME, USERLASTNAME)"
            +" VALUES"
            +"(1,'Jet','Melnyk')";
    private static void insertData(){
        Connection dbConnection = null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            statement.execute(insertDB);
            System.out.println("well done!");
        }catch (SQLException e){
            e.printStackTrace();
        }

    }*/
    private static final String getRow = "select USER_ID, USERNAME from DBUSER";

    private static void getData(){
        Connection dbConnection =null;
        Statement statement = null;
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();

            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(getRow);

            // И если что то было получено то цикл while сработает
            while (rs.next()) {
                String userid = rs.getString("USER_ID");
                String username = rs.getString("USERNAME");

                if((userid.equals("1"))&&(username.equalsIgnoreCase("jet"))){
                    System.out.println("!!!True!!!");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
