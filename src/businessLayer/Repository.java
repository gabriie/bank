package businessLayer;

import java.sql.*;

import dataAccesLayer.Gateway;
import modelLayer.Entity;

public class Repository<TGateway extends Gateway, TEntity extends Entity> {

		private TGateway gateway;
		private TEntity entity;

		
		public Repository(){
			this.entity=entity;
			this.gateway=gateway;
		}
		
		
		public void insert(TEntity entity){
			gateway.insert(entity);
		}
		public void update(TEntity entity){
			gateway.update(entity);
		}
		public void delete(TEntity entity){
			gateway.delete(entity);
		}
		public ResultSet findById(int id){
			return gateway.findById(id);
		}
		public ResultSet findAll(){
			return gateway.findAll();
		}
		
}
