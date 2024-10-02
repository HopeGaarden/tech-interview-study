package addressbookWithDAOSqlite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.Person;

public class PersonDBSqlite implements PersonDAO {
    final static String DB_FILE_NAME = "addressbook.db";
    final static String DB_TABLE_NAME = "persons";

    Connection connection = null;
    ResultSet rs = null;
    Statement statement = null;

	public PersonDBSqlite() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_FILE_NAME);
            statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            final String table = " (ID INTEGER PRIMARY KEY AUTOINCREMENT, name text, address text)";

            // create table
            statement.executeUpdate("DROP TABLE IF EXISTS " + DB_TABLE_NAME);
            statement.executeUpdate("CREATE TABLE " + DB_TABLE_NAME + table);
        }
        catch (SQLException e) {
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
