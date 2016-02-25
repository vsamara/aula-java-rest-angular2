package model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Produto implements Model<Long>, Comparable<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	private BigDecimal valor;
	private Date validade;
	@ManyToOne
	private Categoria categoria;
	
	public Produto() {
	}
	
	private Produto(Builder b) {
		id = b.id;
		descricao = b.descricao;
		valor = b.valor; 
		validade = b.validade;
		categoria = b.categoria;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	public Date getValidade() {
		return validade;
	}
	
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			if(obj instanceof Produto) {
				return id.equals(((Produto)obj).id);
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 + ((id == null) ? 0 : id.hashCode());
	}
	
	public int compareTo(Long o) {
		return (int) (this.id - o);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		
		private Long id;
		private String descricao;
		private BigDecimal valor;
		private Date validade;
		private Categoria categoria;
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		
		public Builder valor(BigDecimal valor) {
			this.valor = valor;
			return this;
		}
		
		public Builder validade(Date validade) {
			this.validade = validade;
			return this;
		}
		
		public Builder categoria(Categoria categoria) {
			this.categoria = categoria;
			return this;
		}
		
		public Produto build() {
			return new Produto(this);
		}
		
	}

}
