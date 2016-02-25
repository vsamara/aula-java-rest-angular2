package service;

import validator.Validator;

import dao.DAO;
import model.Model;

public class Service<T extends Model<?>> {
	
	protected DAO<T> dao;
	protected Validator<T> validator;
	
	public Service(DAO<T> dao, Validator<T> validator) {
		this.dao = dao;
		this.validator = validator;
	}
	
	public void create(T entity) {
		if(validator.validate(entity)) {
			dao.create(entity);
		}
	}
	
}
