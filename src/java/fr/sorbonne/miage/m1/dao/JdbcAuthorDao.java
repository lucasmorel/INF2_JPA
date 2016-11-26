package fr.sorbonne.miage.m1.dao;

import fr.sorbonne.miage.m1.beans.Author;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eddebbima
 */
public class JdbcAuthorDao implements DAO<Author> {

    // JDBC driver name and database URL
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/library";

    //  Database credentials
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection connection;

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();
        try {
            Statement stmt = getConnection().createStatement();
            String sql = "SELECT * FROM Author";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) {
                Integer id = rs.getInt("ID");
                String firstname = rs.getString("FIRSTNAME");
                String lastname = rs.getString("LASTNAME");
                
                Author b = new Author(id, firstname, lastname);
                authors.add(b);
            }
            
            return authors;
        } catch (SQLException e) {
            e.printStackTrace();
            return authors;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return authors;
        }
    }

    @Override
    public Author findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Method that creates a java.sql.Connection object to database
     *
     * @return java.sql.Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        if (connection != null) {
            return connection;
        }
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DB_URL, USER, PASS);
        return connection;
    }

    @Override
    public void create(Author obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Author obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Author obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
