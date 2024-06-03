package model;

public class Usuario {


    private String senha;
    private String email;

    public Usuario(String senha, String email  ) {
        this.senha = senha;
        this.email = email;
    }

    public Usuario() {

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Usuario.this.email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

