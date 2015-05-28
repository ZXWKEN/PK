import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class DishesControl 
{
	
	
	public void addDishes(int id,String name,double price)
	{
		String sql="INSERT INTO dishes(id, name, price) VALUES ("+id+","+"'"+name+"'"+","+price+")";
		DishesDB dishesDB=new DishesDB();
		dishesDB.executeDB(sql,false);
		dishesDB.closeDB();
	}
	public void changeDishes(int id,double price)
	{
		String sql="UPDATE dishes SET price="+price+" WHERE (id="+id+")";
		DishesDB dishesDB=new DishesDB();
		dishesDB.executeDB(sql,false);
		dishesDB.closeDB();		
				
	}
	public void delectDishes(int id)
	{
		String sql="DELETE FROM dishes WHERE (id="+id+")";
		DishesDB dishesDB=new DishesDB();
		dishesDB.executeDB(sql,false);
		dishesDB.closeDB();	
	}
	public Dishes selectDishes(int id)
	{
		
		Dishes dishes=null;
		String sql="SELECT * FROM dishes WHERE (id="+id+")";
		DishesDB dishesDB=new DishesDB();
		ResultSet ret=dishesDB.executeDB(sql,true);
		try {
			if(ret.next())
			{
				dishes=new Dishes();
				dishes.setId(id);
				dishes.setName(ret.getString(2));
				dishes.setPrice(ret.getDouble(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dishesDB.closeDB();	
		return dishes;
	}
	public ArrayList<Dishes> readFromDB()
	{
		
		ArrayList<Dishes> dishes=new ArrayList<Dishes>();
		
		
		String sql="SELECT * FROM dishes ";
		DishesDB dishesDB=new DishesDB();
		ResultSet ret=dishesDB.executeDB(sql,true);
		try {
			while(ret.next())
			{
				Dishes tempdishes=new Dishes();
				tempdishes.setId(ret.getInt(1));
				tempdishes.setName(ret.getString(2));
				tempdishes.setPrice(ret.getDouble(3));
				dishes.add(tempdishes);
				//System.out.println(tempdishes.getName());
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dishesDB.closeDB();	
		return dishes;
	}

}
