package com.advancia;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/Lista")
public class Lista {

	public static List<ExteseUsers> list = new ArrayList<>();
	public static int contatore = 0;

	@Path("/Inserimento")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserisciUtente(Users u) {
		ExteseUsers uTemp = new ExteseUsers();
		contatore++;
		uTemp.setId(contatore);
		uTemp.setName(u.getName());
		uTemp.setlName(u.getlName());
		uTemp.setCodFis(u.getCodFis());
		uTemp.setIndirizzo(u.getIndirizzo());
		list.add(uTemp);
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Visualizza/{id}")
	public Response visualizzaUtente(@PathParam("id") int id) {

		ExteseUsers user = new ExteseUsers();
		user = list.get(id);
		return Response.status(200).entity(user).build();
		/*int i;
	
		
		for (i = 0; list.get(i).getId() != id && list.size() != i; i++)
			if (i != list.size()) {
				user = list.get(i);
				return Response.status(200).entity(user).build();
				}
				return Response.status(400).entity("Elemento non presente nella lista").build(); */
	}

	@DELETE
	@Path("/Eliminazione/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response elimina(@PathParam("id") int id) {

		ExteseUsers user = new ExteseUsers();
		int i;

		if (id < 0) {
			return Response.status(400).entity("id non valido").build();
		}
		else {
			list.remove(id);
			return Response.status(200).entity("Elemento eliminato").build();
		}
		/*for (i = 0; list.get(i).getId() != id && list.size() != i; i++)
			if (i != list.size()) {
				list.remove(i);
				return Response.status(200).entity("Elemento eliminato").build();
			} else
				return Response.status(400).entity("Elemento non trovato").build();
		return null;*/
	}


	@PUT
	@Path("/Aggiornamento/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response aggiorna(@PathParam("id") int id, Users u) {

		ExteseUsers user = new ExteseUsers();
		int i;
		if ( id >= 0) {
			user = list.get(id);
			user.setName(u.getName());
			user.setlName(u.getlName());
			user.setCodFis(u.getCodFis());
			user.setIndirizzo(u.getIndirizzo());
			list.remove(id);
			list.add(user);
			
			return Response.status(200).entity("Elemento aggiornato").build();
		}
		else
			return Response.status(400).entity("Elemento non trovato").build();
	/*	for (i = 0; list.get(i).getId() != id && list.size() != i; i++)
			if (i != list.size()) {
				user.setId(i);
				user.setName(u.getName());
				user.setlName(u.getlName());
				user.setCodFis(u.getCodFis());
				user.setIndirizzo(u.getIndirizzo());
				list.add(i, user);
				list.remove(++i);
				return Response.status(200).entity("Elemento aggiornato").build();
			} else
				return Response.status(400).entity("Elemento non trovato").build();
		return null;
	} */
	}
}