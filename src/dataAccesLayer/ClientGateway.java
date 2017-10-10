package dataAccesLayer;
import java.sql.*;
import modelLayer.DBConnect;
import modelLayer.Employee;
import modelLayer.Client;

public class ClientGateway extends Gateway<Client> {

	private DBConnect connection;
	
	public ClientGateway(){
		connection=new DBConnect();
	}
	
	public void insert(Client c) {
		PreparedStatement state=null;
		String query = "INSERT INTO client (nameClient, cardNr, cnp, adress)"
				+ "values(?, ?, ?, ?)";
		
		try{
		state = connection.getConnection().prepareStatement(query);

		state.setString(1, c.getNameClient());
		state.setString(2, c.getCardNr());
		state.setInt(3, c.getCnp());
		state.setString(4, c.getAdress());
		state.executeUpdate();
			
		} catch(SQLException e){
			e.printStackTrace();
		}	
	}
		
	


	public void update(Client c) {
		PreparedStatement state=null;
		String query = "UPDATE `client` SET `nameClient` = ?, `cardNr` = ?, `cnp` = ?,"
				+ " `adress` = ? WHERE `client`.`idClient` = ?; ";

		try{
			state = connection.getConnection().prepareStatement(query);

			state.setString(1, c.getNameClient());
			state.setString(2, c.getCardNr());
			state.setInt(3, c.getCnp());
			state.setString(4, c.getAdress());
			state.setInt(5, c.getIdClient());
			state.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
		}
		
	}

	public void delete(Client c) {
		String query = "DELETE from client where idClient=?";

		try{
			PreparedStatement state = connection.getConnection().prepareStatement(query);

			state.setInt(1, c.getIdClient());
			state.executeUpdate();

		} catch(SQLException e){
			e.printStackTrace();
			}	
		}


	public ResultSet findById(int id) {
		String query = "SELECT * from client where idClient=?";
		PreparedStatement state=null;
		ResultSet myRs=null;
		
		try{
		state = connection.getConnection().prepareStatement(query);
		state.setInt(1, id);
		myRs=state.executeQuery();

	
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}	
		return myRs;
	}

	public ResultSet findAll() {
		
		String query = "SELECT * from client";					
		
		try{
			return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		}

	}
	
	public ResultSet findByName(String nameClient) {
		String query = "SELECT * FROM client WHERE nameClient LIKE ?";
		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);

		state.setString(1, nameClient);
		state.executeUpdate();
		
		return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			System.out.println("ERROR "+e);
			return null;
		}	
	}

}
