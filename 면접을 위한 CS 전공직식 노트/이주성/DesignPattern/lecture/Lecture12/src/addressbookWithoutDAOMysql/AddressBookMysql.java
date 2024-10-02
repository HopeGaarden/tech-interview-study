package addressbookWithoutDAOMysql;

import java.sql.*;

public class AddressBookMysql {
	// JDBC driver name and database URL
	static final String DB_PROPERTIES = "?serverTimezone=UTC&useSSL=false"; // MySQL Connector J 8.0
    static final String MARIADB_JDBC_DRIVER = "org.mariadb.jdbc.Driver"; // MariaDB driver
	static final String MYSQL_JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"; // MySQL driver
	//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; // deprecated "com.mysql.jdbc.Driver";  // try "com.mysql.cj.jdbc.Driver"
	static final String DB_NAME = "java-23";
	static final String DB_TABLE_NAME = "persons";
	static final String DB_URL = "jdbc:mysql://localhost/" + DB_NAME + DB_PROPERTIES; 

	//  Database credentials
	static final String USERNAME = "jus";
	static final String PASSWORD = "1234";

    public AddressBookMysql() {
        Connection connection = null;
        ResultSet rs = null;
        Statement statement = null;
        try {
        	//Class.forName(MARIADB_JDBC_DRIVER); // loading a JDBC driver
            Class.forName(MYSQL_JDBC_DRIVER); // loading a JDBC driver    //        connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306/" + DB_NAME, USERNAME,  PASSWORD);
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);  // MySQL
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            final String table = " (id int(64) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, address varchar(255) NOT NULL, UNIQUE(id))";

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