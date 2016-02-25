package view;

import model.Model;

public abstract class View<T extends Model<?>> {
	
	protected T entity;
	
	public View(Class<T> clazz) {
		try {
			entity = clazz.newInstance();
		} catch(IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
	}
	
	public View(T entity) {
		this.entity = entity;
	}

	//TODO verificar se o rest usa isso
	public View() {
	}
	
}
