package br.com.alunoonline.api.dtos;

public class CredenciaisConta {
    private static final long serialVersionUID = 1L;

    private String usuario;
    private String senha;

    public CredenciaisConta() {
    }

    public CredenciaisConta(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
