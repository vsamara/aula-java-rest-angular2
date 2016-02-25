package controller;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;
import model.Model;
import view.View;

public class GenericWS<T extends Model<?>, E extends View<T>> {
	
	private Class<E> viewClass;
	protected DAO<T> dao;
	
	public GenericWS(Class<E> viewClass, Class<T> modelClass) {
		this.viewClass = viewClass;
		dao = new DAO<>(modelClass);
	}
	
	public GenericWS(Class<E> viewClass, DAO<T> dao) {
		this.viewClass = viewClass;
		this.dao = dao;
	}
	
	public List<E> getViews(List<T> models) {
		List<E> views = new ArrayList<>();
		for(T model : models) {
			try {
				Constructor<E> constructor = viewClass.getConstructor(model.getClass());
				views.add(constructor.newInstance(model));
			} catch (InstantiationException 
					| IllegalAccessException 
					| NoSuchMethodException
					| SecurityException 
					| IllegalArgumentException 
					| InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		return views;
	}
	
}
