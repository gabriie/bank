package modelLayer;
import java.sql.*;

public class DBConnect {
	private Connection connection;
	private Statement statement;
	private ResultSet result;
	
	public DBConnect(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");	
			connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/tema3","root","");
			statement= connection.createStatement();
		}catch (Exception e){
				System.out.println("Error" + e);
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResult() {
		return result;
	}

	public void setResult(ResultSet result) {
		this.result = result;
	}
}
