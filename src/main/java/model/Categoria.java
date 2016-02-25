package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Categoria implements Model<Long>, Comparable<Long> {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	
	public Categoria() {
	}
	
	private Categoria(Builder b) {
		id = b.id;
		descricao = b.descricao;
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
	
	public static Builder builder() {
		return new Builder();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			if(obj instanceof Categoria) {
				return id.equals(((Categoria)obj).id);
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return 31 + ((id == null) ? 0 : id.hashCode());
	}
	
	public int compareTo(Long o) {
		return (int) (id - o);
	}
	
	public static class Builder {
		
		private Long id;
		private String descricao;
		
		private Builder() {
		}

		public Builder id(Long id) {
			this.id = id;
			return this;
		} 
		
		public Builder descricao(String descricao) {
			this.descricao = descricao;
			return this;
		}
		
		public Categoria build() {
			return new Categoria(this);
		}
		
	}
	
}
