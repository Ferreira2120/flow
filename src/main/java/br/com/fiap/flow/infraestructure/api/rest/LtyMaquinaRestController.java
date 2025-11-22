package br.com.fiap.flow.infraestructure.api.rest;

import br.com.fiap.flow.domain.model.LtyMaquina;
import br.com.fiap.flow.interfaces.LtyMaquinaController;
import br.com.fiap.flow.interfaces.dto.output.LtyMaquinaDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/layout-maquina")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LtyMaquinaRestController {

    private final LtyMaquinaController ltyMaquinaController;


    public LtyMaquinaRestController(LtyMaquinaController ltyMaquinaController) {
        this.ltyMaquinaController = ltyMaquinaController;
    }

    @POST
    public Response criarLayoutMaquina(LtyMaquina ltyMaquina){
        try{
            LtyMaquinaDto ltyMaquinaDto = ltyMaquinaController.salvarLtyMaquina(ltyMaquina);
            return Response.status(Response.Status.CREATED).entity(ltyMaquinaDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible to create a layout.")).build();
        }
    }

    @PUT
    public Response editarUser(LtyMaquina ltyMaquina){
        try {
            LtyMaquinaDto ltyMaquinaDto = ltyMaquinaController.atualizarLtyMaquina(ltyMaquina);
            return Response.status(Response.Status.ACCEPTED).entity(ltyMaquinaDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible to update layout")).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarUserById(@PathParam("id")Long id){
        try {
            LtyMaquinaDto ltyMaquinaDto = ltyMaquinaController.buscarLtyMaquinaPorId(id);
            return Response.status(Response.Status.ACCEPTED).entity(ltyMaquinaDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.NOT_FOUND).entity(Map.of("Error: ", " It is not possible to search for the layout.")).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deleteUser(@PathParam("id") Long id){
        try {
            ltyMaquinaController.deletarLtyMaquina(id);
            return Response.status(Response.Status.NO_CONTENT).entity(Map.of("Error: ", "Operation successfully completed!")).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible to delete the layout.")).build();
        }
    }

}
