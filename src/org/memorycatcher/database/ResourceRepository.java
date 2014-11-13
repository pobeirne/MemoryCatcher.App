/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.memorycatcher.database;


import java.io.FileInputStream;
import MemoryCatcherApp.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import org.memorycatcher.interfaces.IResourceRepository;

/**
 *
 * @author pobeirne
 */
public class ResourceRepository implements IResourceRepository{

    private final String CONFIG_PATH = "C:\\MemoryCatcherApp\\"
            + "src\\dbconfig.properties";
    private final Connection myConn;
    private Statement myStmt;
    private PreparedStatement myPrepStmt;
    private ResultSet myRs;

    private Resource resource;
    private List<Resource> resourceList;

    public ResourceRepository() throws SQLException, Exception {
        Properties props = new Properties();

        props.load(new FileInputStream(CONFIG_PATH));
        String theUser = props.getProperty("user");
        String thePassword = props.getProperty("password");
        String theDBurl = props.getProperty("dburl");

        myConn = DriverManager.getConnection(
                theDBurl,
                theUser,
                thePassword);

    }

    
    
    
    
    @Override
    public List<Resource> getAllResourcesById(int memoryId) throws SQLException {
          myStmt = null;
        myRs = null;
        try {
            myStmt = myConn.createStatement();
            myRs = myStmt.executeQuery("select * from resources where memory_id ="+memoryId+"");
            resourceList = new ArrayList<>();
            while (myRs.next()) {
                resource = convertRowToResource(myRs);
                resourceList.add(resource);
            }
            return resourceList;

        } finally {
            close(myConn, myStmt, myRs);
        }
    }

    @Override
    public boolean addResource(int memoryId, int ownerId, String type, String location) throws SQLException {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateResource(Resource resource) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeResource(int resourceId) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close(Connection connection, Statement statement, ResultSet rs) {
           if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                System.out.printf(e.getMessage());
            }
        }
    }

    private Resource convertRowToResource(ResultSet myRs) throws SQLException {
        resource = new Resource();
        resource.id = myRs.getInt("resource_id");
        resource.memoryId = myRs.getInt("memory_id");
        resource.ownerId = myRs.getInt("owner_id");
        resource.type = myRs.getString("type");
        resource.location= myRs.getString("location");
        resource.createDate= myRs.getString("`create_date");      
        return resource;               
    }
    
    private static java.sql.Date getCurrentDate() {

        Calendar calendar = Calendar.getInstance();
        java.sql.Date createDate = new java.sql.Date(calendar.getTime().getTime());
        return createDate;

    }
   
}
