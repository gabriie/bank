package dataAccesLayer;

import java.sql.ResultSet;

import modelLayer.Entity;

public abstract class Gateway<TEntity extends Entity> { 
	
	public abstract void insert(TEntity e);
	public abstract void update(TEntity e);
	public abstract void delete(TEntity e);
	public abstract ResultSet findById(int id);
	public abstract ResultSet findAll();
	

}
