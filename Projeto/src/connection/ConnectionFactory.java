package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;


public class ConnectionFactory {
	
	
	private static Connection con=null;	
	private static String user="root";
	private static String pass="";
	private static String server="localhost";
	private static String dataBase="projeto";
	private static int porta=3306;
	public static Connection getConnection() throws SQLException, ClassNotFoundException
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto?useTimezone=true&serverTimezone=UTC", "root","");
			
			//metodo de conexão 2
			
			/*MysqlDataSource ds=new MysqlDataSource();
			ds.setUser(user);
	        ds.setPassword(pass);
	        ds.setServerName(server);
	       // ds.setPortNumber(porta);
	        ds.setDatabaseName(dataBase);	
	        con=ds.getConnection();;
	        */
		} catch (SQLException e) {
			e.getMessage();
			throw new SQLException();
		}
		return con;
	}
}
