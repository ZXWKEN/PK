import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class OrderControl 
{
	public void writeToDB(Customer customer)
	{
		String sql="INSERT INTO `booking`.`customer` (`id`, `name`, `phoneNum`, `dishesid`, `dishesname`, `dishesprice`) VALUES ("+customer.getId()+","+ customer.getName()+","+ customer.getPhoneNum()+","+ customer.getDishes().getId()+","+ customer.getDishes().getName()+","+ customer.getDishes().getPrice()+")";
		OrderDB order=new OrderDB();
		order.executeDB(sql,false);
		order.closeDB();
	}
	public ArrayList<Customer> readFromDB(int id)
	{
		ArrayList<Customer> customer=new ArrayList<Customer>();
		Customer tempCustomer=new Customer();
		Dishes tempDishes=new Dishes();
		String sql="SELECT * FROM `customer` WHERE (`id`="+id+")";
		OrderDB order=new OrderDB();
		ResultSet ret=order.executeDB(sql,true);
		try {
			while(ret.next())
			{
				tempCustomer.setId(ret.getInt(1));
				tempCustomer.setName(ret.getString(2));
				tempCustomer.setPhoneNum(ret.getInt(3));
				tempDishes.setId(ret.getInt(4));
				tempDishes.setName(ret.getString(5));
				tempDishes.setPrice(ret.getDouble(6));
				tempCustomer.setDishes(tempDishes);
				customer.add(tempCustomer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		order.closeDB();
		return customer;
	}
 
}
