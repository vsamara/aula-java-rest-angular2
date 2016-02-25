package controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Produto;
import view.ProdutoView;

@Path("produto")
public class ProdutoWS extends GenericWS<Produto, ProdutoView> {
	
	public ProdutoWS() {
		super(ProdutoView.class, Produto.class);
	}

	@POST
	@Path("create")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void create(Produto produto) {
		dao.create(produto);
	}
	
	@GET
	@Path("find-{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public ProdutoView find(@PathParam("id") Long produto) {
		return new ProdutoView(dao.find(produto));
	}
	
	@GET
	@Path("find-all")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<ProdutoView> findAll() {
		return getViews(dao.findAll());
	}
	
	@PUT
	@Path("update")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void update(Produto produto) {
		dao.update(produto);
	}
	
	@DELETE
	@Path("delete")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(Produto produto) {
		dao.delete(produto);
	}

}
