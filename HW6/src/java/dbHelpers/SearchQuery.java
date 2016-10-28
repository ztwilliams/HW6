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


public class SearchQuery {
    
    private Connection conn; 
    private ResultSet results;
            
    public SearchQuery() {
        
        
        Properties props = new Properties();
        InputStream instr = getClass().getResourceAsStream("dbConn.properties");
        try {
            props.load(instr);
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            instr.close();
        } catch (IOException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String driver = props.getProperty("driver.name");
        String url = props.getProperty("server.name");
        String username = props.getProperty("user.name");
        String passwd = props.getProperty("user.password");
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            conn = DriverManager.getConnection(url, username, passwd);
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void doSearch(String stateName){
        
        try {
            String query = "SELECT * FROM states WHERE UPPER(stateName) LIKE ? ORDER BY stateID DESC";
            
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, "%" + stateName.toUpperCase() + "%"); 
            this.results = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String getHTMLTable(){
        
        String table = "";
        
        table += "<table>";
        
        table += "<th>State ID</th>";
        table += "<th>State Name</th>";
        table += "<th>Year Founded</th>";
        table += "<th>Population</th>";
        table += "<th>Age</th>";
        table += "<th>Tools</th>";
        
        try {
            while(this.results.next()){
                
                States state = new States();
                
                state.setStateID(this.results.getInt("stateID"));
                state.setStateName(this.results.getString("stateName"));
                state.setYearFounded(this.results.getInt("yearFounded"));
                state.setPopulation(this.results.getInt("population"));
                state.setAge(this.results.getInt("age"));
              
                
                table += "<tr>";
                
                
                table += "<td>";
                table += state.getStateID();
                table += "</td>";
                
                table += "<td>";
                table += state.getStateName();
                table += "</td>";
                
                table += "<td>";
                table += state.getYearFounded();
                table += "</td>";
                
                table += "<td>";
                table += state.getPopulation();
                table += "</td>";
                
                table += "<td>";
                table += state.getAge();
                table += "</td>";
                
                table += "<td>";
                table += "<a href=update?stateID=" + state.getStateID() + "> Update </a>" + "<a href=delete?stateID=" + state.getStateID() + "> Delete </a>"; 
                table += "</td>";
                
                
                table += "</tr>";
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SearchQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        table += "</table>";
        
        return table; 
    }
    
    
    
}
