package dataAccesLayer;

import java.sql.*;

import modelLayer.Client;
import modelLayer.DBConnect;
import modelLayer.Factura;


public class FacturaGateway extends Gateway<Factura>{

	
	private DBConnect connection;
	
	public FacturaGateway(){
		connection=new DBConnect();
	}
	
	public void insert(Factura f) {
		String query = "INSERT INTO factura ( idClient, comments, paid, amountFactura)"
				+ "VALUE(?, ?, ?, ?)";
		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);
		
		state.setInt(1, f.getIdClient());
		state.setString(2, f.getComments());
		state.setString(3, f.getPaid());
		state.setInt(4, f.getAmountFactura());
		state.executeUpdate();
		
		connection.getStatement().executeUpdate(query);
	
		} catch(SQLException e){
			System.out.println("ERROR "+e);
		}	
	}
		
	


	public void update(Factura f) {
		
		String query = "UPDATE factura"+
				"set idClient=?, comments=?, paid=?, amountFactura=?"+
				"where idFactura=?";

		try{
			PreparedStatement state = connection.getConnection().prepareStatement(query);

			state.setInt(1, f.getIdClient());
			state.setString(2, f.getComments());
			state.setString(3, f.getPaid());
			state.setInt(4, f.getAmountFactura());
			state.setInt(5, f.getIdFactura());
			state.executeUpdate();

			connection.getStatement().executeUpdate(query);

		} catch(SQLException e){
			System.out.println("ERROR "+e);
		}
		
	}


	public void delete(Factura f) {
		
		String query = "DELETE from factura"+
				"where idFactura=?";

		try{
			PreparedStatement state = connection.getConnection().prepareStatement(query);

			state.setInt(1, f.getIdFactura());
			state.executeUpdate();

			connection.getStatement().executeUpdate(query);

		} catch(SQLException e){
				System.out.println("ERROR "+e);
			}	
		
	}


	public ResultSet findById(int id) {
		String query = "SELECT * from factura where idFactura=?";
		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);

		state.setInt(1, id);
		state.executeUpdate();
		
		return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			System.out.println("ERROR "+e);
			return null;
		}	
	}


	public ResultSet findAll() {
		
		String query = "SELECT * from factura";					
		
		try{
			return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			System.out.println("ERROR "+e);
			return null;
		}

	}
	
	public ResultSet findByName(String name) {
		String query = "SELECT * FROM factura WHERE comments LIKE ?";
		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);

		state.setString(1, name);
		state.executeUpdate();
		
		return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			System.out.println("ERROR "+e);
			return null;
		}	
	}

}
