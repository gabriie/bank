package dataAccesLayer;

import java.sql.*;
import modelLayer.DBConnect;
import modelLayer.Report;

public class ReportGateway extends Gateway<Report> {

	private DBConnect connection;
	
	public ReportGateway(){
		connection=new DBConnect();
	}

	public void insert(Report r) {
		String query = "INSERT INTO report (action, date, idUser)"
				+ "VALUE(?, ?, ?)";
		
		try{
		PreparedStatement state = connection.getConnection().prepareStatement(query);
		
		state.setString(1, r.getAction());
		state.setString(2, r.getDate());
		state.setInt(3, r.getIdUser());

		state.executeUpdate();
		
		connection.getStatement().executeUpdate(query);
	
		} catch(SQLException e){
			System.out.println("ERROR "+e);
		}
	}

	public void update(Report r) {
		String query = "UPDATE report"+
				"set action=?, date=?, idUser=?"+
				"where idReport=?";

		try{
			PreparedStatement state = connection.getConnection().prepareStatement(query);

			state.setString(1, r.getAction());
			state.setString(2, r.getDate());
			state.setInt(3, r.getIdUser());
			state.setInt(4, r.getIdReport());

			state.executeUpdate();

			connection.getStatement().executeUpdate(query);

		} catch(SQLException e){
			System.out.println("ERROR "+e);
		}
	}

	public void delete(Report r) {
		String query = "DELETE FROM report WHERE idReport = ?";

		try{
			PreparedStatement state = connection.getConnection().prepareStatement(query);

			state.setInt(1, r.getIdReport());

			state.executeUpdate();

			connection.getStatement().executeUpdate(query);

		} catch(SQLException e){
			System.out.println("ERROR "+e);
		}
	}

	@Override
	public ResultSet findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultSet findAll() {
		String query = "SELECT * FROM report";					
		
		try{
			return connection.getStatement().executeQuery(query);
	
		} catch(SQLException e){
			System.out.println("ERROR "+e);
			return null;
		}
	
}
	
	public ResultSet findByName(String name) {
		String query = "SELECT * FROM report WHERE action LIKE ?";
		
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
