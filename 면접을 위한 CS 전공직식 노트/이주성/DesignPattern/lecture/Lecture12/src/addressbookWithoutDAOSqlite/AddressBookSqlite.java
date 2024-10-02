package addressbookWithoutDAOSqlite;

import java.sql.*;

public class AddressBookSqlite {
    final static String DB_FILE_NAME = "addressbook.db";
    final static String DB_TABLE_NAME = "persons";

    public AddressBookSqlite() {
        Connection connection = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            final String table = " (ID INTEGER PRIMARY KEY AUTOINCREMENT, name text, address text)";

            // create table
            statement.executeUpdate("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
            statement.executeUpdate("CREATE TABLE " + DB_TABLE_NAME + table);

            System.out.println("--- inserting...");
            statement.execute("INSERT INTO persons(name, address) VALUES('Dooly','SS')");
            statement.execute("INSERT INTO persons(name, address) VALUES('HeeDong','YY')");

            System.out.println("--- finding all...");
            rs = statement.executeQuery("SELECT * FROM persons WHERE id < 4 ORDER BY id");
            while (rs.next()) {
                System.out.println("" + rs.getInt("ID") + ", " + rs.getString("name") + ", " + rs.getString("address"));
            }

            System.out.println("--- updating...");
            statement.execute("UPDATE persons SET name = 'Michol' WHERE id = 1");

            System.out.println("--- see if updated...");
            rs = statement.executeQuery("SELECT * FROM persons WHERE id = 1");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("address"));
            }

            System.out.println("--- deleting...");
            statement.execute("DELETE FROM persons WHERE id = 1");

            System.out.println("--- finding all after deleting...");
            rs = statement.executeQuery("SELECT * FROM persons WHERE id < 4 ORDER BY id");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + ", " + rs.getString("name") + ", " + rs.getString("address"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                if(rs != null) {
                    rs.close();
                }
                if(statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}