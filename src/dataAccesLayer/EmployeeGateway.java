package dataAccesLayer;
import java.sql.*;
import java.util.ArrayList;
import modelLayer.DBConnect;
import modelLayer.Employee;

public class EmployeeGateway extends Gateway<Employee> {
	
	private DBConnect connection;
	
	public EmployeeGateway(){
		connection=new DBConnect();
	}

	public void insert(Employee em){
		PreparedStatement state=null;
		
		try{
			state=(PreparedStatement) connection.getConnection().prepareStatement("INSERT into employee "
					+ "(nameEmployee,function,username,passwordEmployee) "
					+ "values(?, ?, ?, ?)");
			
			state.setString(1, em.getNameEmployee());
			state.setBoolean(2, em.isFunction());
			state.setString(3, em.getUsername());
			state.setString(4, em.getPasswordEmployee());
			state.executeUpdate();
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public void update(Employee em){
		PreparedStatement state=null;
		
		try{
			state=(PreparedStatement) connection.getConnection().prepareStatement("UPDATE `employee` SET `nameEmployee` = ?, `function` = ?, `username` = ?,"
					+ " `passwordEmployee` = ? WHERE `employee`.`idEmployee` = ?;");
			
			state.setString(1, em.getNameEmployee());
			state.setBoolean(2, em.isFunction());
			state.setString(3, em.getUsername());
			state.setString(4, em.getPasswordEmployee());
			state.setInt(5,  em.getIdEmployee());
			state.executeUpdate();
			
		}catch(Exception exc){
			exc.printStackTrace();
		}
	}
	
	public void delete(Employee em) {
		String query = "DELETE from employee where idEmployee=?";

		try{
			PreparedStatement state = connection.getConnection().prepareStatement(query);

			state.setInt(1, em.getIdEmployee());
			state.executeUpdate();

		} catch(SQLException e){
				e.printStackTrace();
			}
		
	}

	public ResultSet findById(int id) {

		PreparedStatement state=null;
		ResultSet myRs=null;
		Employee em;
		String query = "SELECT * from employee where idEmployee=?";
		
		try{
		state = connection.getConnection().prepareStatement(query);
		state.setInt(1, id);
		myRs= state.executeQuery();

		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return myRs;
	}

	public ResultSet findAll() {
		String query = "SELECT * from employee";					
		
		try{
			return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public ResultSet findByName(String name) {
		String query = "SELECT * FROM employee WHERE nameEmployee LIKE ?";
		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);

		state.setString(1, name);
		state.executeUpdate();
		
		return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}	
	}

}
