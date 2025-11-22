package br.com.fiap.flow.infraestructure.api.rest;

import br.com.fiap.flow.domain.model.Usuario;
import br.com.fiap.flow.interfaces.UsuarioController;
import br.com.fiap.flow.interfaces.dto.output.UsuarioDto;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioRestController {

    private final UsuarioController usuarioController;

    public UsuarioRestController(UsuarioController usuarioController) {
        this.usuarioController = usuarioController;
    }

    @POST
    public Response criarUsuario(Usuario usuario){
        try {
            UsuarioDto usuarioDto = usuarioController.salvarUsuario(usuario);
            return Response.status(Response.Status.CREATED).entity(usuarioDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", " It is not possible creat user. ")).build();
        }
    }

    @PUT
    public Response atualizarUsuario(Usuario usuario){
        try {
            UsuarioDto usuarioDto = usuarioController.atualizarUsuario(usuario);
            return Response.status(Response.Status.ACCEPTED).entity(usuarioDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.NOT_FOUND).entity(Map.of("Error: ", "It is not possible to update user.")).build();
        }
    }


    @GET
    public Response buscarUsuarioPorId(Long id){
        try {
            UsuarioDto usuarioDto = usuarioController.obterUsuarioPorId(id);
            return Response.status(Response.Status.ACCEPTED).entity(usuarioDto).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.NOT_FOUND).entity(Map.of("Error: ", "It is not possible to search for the user.")).build();
        }
    }

    @DELETE
    @Path("/delete/{id}")
    public Response deletarUsuario(@PathParam("id") Long id){
        try {
            usuarioController.deletarUsuario(id);
            return Response.status(Response.Status.NO_CONTENT).entity(Map.of("Response: ", "Operation successfully completed!")).build();
        }catch (RuntimeException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(Map.of("Error: ", "It is not possible to delete the user.")).build();
        }
    }

}
