package dbHelpers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.States;

public class ReadRecord {
    
    private Connection conn; 
    private ResultSet results;
    private States state = new States(); 
    private int stateID;
    
    
    public ReadRecord (int stateID) {

     Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        
        this.stateID = stateID;
        
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
        
}
    
    public void doRead() {
        
        try {
            //set up a string to hold our query
            String query = "SELECT * FROM states WHERE stateID = ?";
            //create a preparedstatement using our query string
            PreparedStatement ps = conn.prepareStatement(query);
            //fill in the preparedstatement
            ps.setInt(1, stateID);
            //execute the query
            this.results = ps.executeQuery();
            
            this.results.next();
            
            state.setStateID(this.results.getInt("stateID"));
            state.setStateName(this.results.getString("stateName"));
            state.setYearFounded(this.results.getInt("yearFounded"));
            state.setPopulation(this.results.getInt("population"));
            state.setAge(this.results.getInt("age"));
            
        } catch (SQLException ex) {
            Logger.getLogger(ReadRecord.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public States getState(){
        
        return this.state;
        
    }
}
