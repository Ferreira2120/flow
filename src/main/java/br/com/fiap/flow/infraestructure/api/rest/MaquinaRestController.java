package br.com.fiap.flow.infraestructure.api.rest;

import br.com.fiap.flow.domain.model.Maquina;
import br.com.fiap.flow.interfaces.MaquinaController;
import br.com.fiap.flow.interfaces.dto.output.MaquinaDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/maquinas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MaquinaRestController {

    private final MaquinaController maquinaController;

    public MaquinaRestController(MaquinaController maquinaController) {
        this.maquinaController = maquinaController;
    }

    @POST
    public Response criarMaquina(Maquina maquina){
        try{
            MaquinaDto maquinaDto = maquinaController.criarMaquina(maquina);
            return Response.status(Response.Status.CREATED).entity(maquinaDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible to create a maquina.")).build();
        }
    }

    @PUT
    public Response editarMaquina(Maquina maquina){
        try{
            MaquinaDto maquinaDto = maquinaController.atualizarMaquina(maquina);
            return Response.status(Response.Status.ACCEPTED).entity(maquinaDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible to update maquina")).build();
        }
    }

    @GET
    @Path("/{id}")
    public Response buscarMaquina(@PathParam("id") Long id){
        try{
            MaquinaDto maquinaDto = maquinaController.obterMaquinaPorId(id);
            return Response.status(Response.Status.ACCEPTED).entity(maquinaDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "Error searching for machine.")).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response excluirMaquina(@PathParam("id") Long id){
        try{
            maquinaController.deletarMaquina(id);
            return Response.status(Response.Status.NO_CONTENT).entity(Map.of("Response: ", "Operation successfully completed!")).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible to delete the machine.")).build();
        }
    }

}
