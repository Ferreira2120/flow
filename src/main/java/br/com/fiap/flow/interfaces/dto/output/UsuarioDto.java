package br.com.fiap.flow.interfaces.dto.output;

import java.time.LocalDate;

public class UsuarioDto {

    private Long idUsuario;

    private String nome;

    private String email;

    private String senha;

    private LocalDate dtCadastro;

    public UsuarioDto() {
    }

    public UsuarioDto(Long idUsuario, String nome, String email, String senha, LocalDate dtCadastro) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtCadastro = dtCadastro;
    }

    public UsuarioDto(String nome, String email, String senha, LocalDate dtCadastro) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.dtCadastro = dtCadastro;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

}
