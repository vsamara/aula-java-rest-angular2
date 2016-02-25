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

import model.Categoria;
import view.CategoriaView;

@Path("categoria")
public class CategoriaWS extends GenericWS<Categoria, CategoriaView> {

	public CategoriaWS() {
		super(CategoriaView.class, Categoria.class);
	}
	
	@POST
	@Path("create")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void create(Categoria categoria) {
		dao.create(categoria);
	}
	
	@GET
	@Path("find-{id}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public CategoriaView find(@PathParam("id") Long categoria) {
		return new CategoriaView(dao.find(categoria));
	}
	
	@GET
	@Path("find-all")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public List<CategoriaView> findAll() {
		return getViews(dao.findAll());
	}
	
	@PUT
	@Path("update")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void update(Categoria categoria) {
		dao.update(categoria);
	}
	
	@DELETE
	@Path("delete")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public void delete(Categoria categoria) {
		dao.delete(categoria);
	}
	
}
