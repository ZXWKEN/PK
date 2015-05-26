import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Connection; 
import java.sql.Statement;

public class DishesDB implements DB {
	public static final String url = "jdbc:mysql://localhost:3306/booking";   
	public static final String name = "com.mysql.jdbc.Driver";   
	public static final String user = "root";   
	public static final String password = "123"; 
	
	public Connection conn = null;   
	public PreparedStatement pst = null;
	
	public DishesDB() 
	{
		
		try 
		{
			Class.forName(name);//指定连接类型   
	        conn = DriverManager.getConnection(url, user, password);//获取连接   
               
	    } catch (Exception e) 
	    {
	    	e.printStackTrace();   
	    }   
	}
	
	
	public ResultSet executeDB(String sql,Boolean isreturn)
	{
		ResultSet ret=null;
		
		try 
		{
			pst = conn.prepareStatement(sql);//准备执行语句 
			if(isreturn)
			{
				ret=pst.executeQuery();
			}
			else
			{
				pst.execute();
			}
			
			
			
			  
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ret;
		
	}
	
	public void closeDB() 
	{
		try 
		{
			this.conn.close();   
			this.pst.close();   
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();   
		}   
	}

	
	

	

}
