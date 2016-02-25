package view;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Categoria;

@XmlRootElement
public class CategoriaView extends View<Categoria> {

	public CategoriaView() {
		super(Categoria.class);
	}
	
	public CategoriaView(Categoria categoria) {
		super(categoria);
	}
	
	@XmlElement
	public Long getId() {
		return entity.getId();
	}

	@XmlElement
	public String getDescricao() {
		return entity.getDescricao();
	}
	
}
