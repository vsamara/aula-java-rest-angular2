package view;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.Categoria;
import model.Produto;

@XmlRootElement
public class ProdutoView extends View<Produto> {

	public ProdutoView() {
		super(Produto.class);
	}
	
	public ProdutoView(Produto produto) {
		super(produto);
	}
	
	@XmlElement
	public Long getId() {
		return entity.getId();
	}
	
	@XmlElement
	public String getDescricao() {
		return entity.getDescricao();
	}
	
	@XmlElement
	public BigDecimal getValor() {
		return entity.getValor();
	}
	
	@XmlElement
	public String getValidade() {
		Date d = entity.getValidade();
		return d == null ? null : new SimpleDateFormat("dd/MM/yyyy").format(d);
	}
	
	@XmlElement
	public Long getCategoria() {
		Categoria c = entity.getCategoria();
		return c == null ? 0L : c.getId();
	}
	
}
