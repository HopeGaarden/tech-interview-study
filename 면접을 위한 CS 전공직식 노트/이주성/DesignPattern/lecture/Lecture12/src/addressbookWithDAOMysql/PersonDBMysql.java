package addressbookWithDAOMysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.Person;

public class PersonDBMysql implements PersonDAO {
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
	
    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;

	public PersonDBMysql() {
		try {
			Class.forName(MYSQL_JDBC_DRIVER); // loading a JDBC driver    
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);  // MySQL
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            final String table = " (id int(64) NOT NULL AUTO_INCREMENT, name varchar(255) NOT NULL, address varchar(255) NOT NULL, UNIQUE(id))";
            // create table
            statement.executeUpdate("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
            statement.executeUpdate("CREATE TABLE " + DB_TABLE_NAME + table);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// add
	@Override
	public void insert(Person person) {
        try {
            statement.execute("INSERT INTO " + DB_TABLE_NAME + " VALUES(" + person.getId() + ", '"
                    + person.getName() + "', '" + person.getAddress() + "')");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	// findAll
	@Override
	public List<Person> findAll() {
        ArrayList<Person> persons = new ArrayList<Person>();
        try {
            rs = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME);
            while (rs.next()) {
                persons.add(new Person(rs.getInt("id"), rs.getString("name"),
                                       rs.getString("address")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
	}
	
	// find by id
	@Override
	public Person find(int id) {
        Person person = null;
        try {
            rs = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE id = " + id);
            if (rs.next()) {
                person = new Person(rs.getInt("id"), rs.getString("name"),
                                   rs.getString("address"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
	}

	// find by name
	public Person find(String name) {
        Person person = null;
        try {
            rs = statement.executeQuery("SELECT * FROM " + DB_TABLE_NAME + " WHERE name = " + name);
            if (rs.next()) {
                person = new Person(rs.getInt("id"), rs.getString("name"),
                                   rs.getString("address"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
	}

	// update by id
	@Override
	public void update(Person person, int id) {
		Person p = find(id);
		if (p != null) {
			try {
				statement.execute("UPDATE " + DB_TABLE_NAME + " SET " + "name = '" + person.getName() + "', address = '"
							+ person.getAddress() + "' WHERE id = " + id);
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// update by name
	public void update(Person person, String name) {
		Person p = find(name);
		if (p != null) {
			try {
				statement.execute("UPDATE " + DB_TABLE_NAME + " SET " + "name = '" + person.getName() + "', address = '"
							+ person.getAddress() + "' WHERE id = " + person.getId());
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// delete by Person 
	@Override
	public void delete(Person person) {
        delete(person.getId());
	}
	
	// delete by id 
	@Override
	public void delete(int id) {
        try {
            statement.execute("DELETE FROM " + DB_TABLE_NAME + " WHERE id = " + id);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
	}

	// delete by name
	@Override
	public void delete(String name) {
        try {
            statement.execute("DELETE FROM " + DB_TABLE_NAME + " WHERE name = " + name);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
	}

}
