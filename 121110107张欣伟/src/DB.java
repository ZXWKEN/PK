import java.sql.ResultSet;


public interface DB {
	
	ResultSet executeDB(String sql,Boolean isreturn);
	void closeDB();

}
