package database;
import java.sql.*;
public class JdbcAccess 
{ 
    public static void main(String[] args) 
    {     
        String databaseURL = "jdbc:ucanaccess://e://User//SPOORTI//eclipse-workspace//database//Employee.accdb";   
        try
        {     
          Class.forNAme("net.ucanaccess.jdbc.ucanaccessDrives"); 
	        Connection con=DriverManager.getConnection (dataURL);
          String sql = "INSERT INTO Employee (E_id,E_Name,E_Add) VALUES (?, ?, ?)";
          PreparedStatement preparedStatement = con.prepareStatement(sql);
          preparedStatement.setString(1, "100");
          preparedStatement.setString(2, "PRAGATI");
          preparedStatement.setString(3, "Hubli");
          int row = preparedStatement.executedUpdate();
          if (row > 0)
          {
                System.out.println("Inserted sucessfully");
          }   
          sql = "SELECT * FROM Employee";
          Statement st = con.createStatement();
          ResultSet rs = st.executeQuery(sql);
          while (rs.next()) 
          {
                int no = rs.getInt("Employee_No");
                String eid = rs.getString("E_id");
                String ename = rs.getString("E_Name");
                String eadd = rs.getString("E_Add");
                System.out.println(no+ ", " +eid+ ", " +ename+ ", " +eadd);
          }   
        } 
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}
