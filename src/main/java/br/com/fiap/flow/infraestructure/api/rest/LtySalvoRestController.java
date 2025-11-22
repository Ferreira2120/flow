package br.com.fiap.flow.infraestructure.api.rest;

import br.com.fiap.flow.domain.model.LtySalvo;
import br.com.fiap.flow.interfaces.LtySalvoController;
import br.com.fiap.flow.interfaces.dto.output.LtySalvoDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/layouts-salvos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LtySalvoRestController {

    private final LtySalvoController ltySalvoController;

    public LtySalvoRestController(LtySalvoController ltySalvoController) {
        this.ltySalvoController = ltySalvoController;
    }

    @POST
    public Response criarLtySalvo(LtySalvo ltySalvo){
        try {
            LtySalvoDto ltySalvoDto = ltySalvoController.salvarController(ltySalvo);
            return Response.status(Response.Status.CREATED).entity(ltySalvoDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible creat save layout.")).build();
        }
    }

    @PUT
    public Response editarLtySalvo(LtySalvo ltySalvo){
        try {
            LtySalvoDto ltySalvoDto = ltySalvoController.atualizarController(ltySalvo);
            return Response.status(Response.Status.ACCEPTED).entity(ltySalvoDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible to update user.")).build();
        }
    }

    @GET
    public Response buscarLtySalvoPorId(Long id){
        try {
            LtySalvoDto ltySalvoDto = ltySalvoController.buscarPorIdController(id);
            return Response.status(Response.Status.ACCEPTED).entity(ltySalvoDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.NOT_FOUND).entity(Map.of("Error: ", "It is not possible to search for the save layout.")).build();

        }
    }

}
