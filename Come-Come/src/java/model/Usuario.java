package model;

public class Usuario {
    private String nome;
    private String email;
    private String login;
    private String senha;
    private boolean admin;

    public Usuario() {
    }

    public Usuario(String login, String senha) {
        this.nome = login;        
        this.login = login;
        this.senha = senha;
        this.admin = true;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

  
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isAdmin() {
        return admin;
    }
    
    public String getAdminString(){
        if(admin) return "SIM";
        else return "NAO";
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    public boolean verificaLogin(String login, String senha){
        return(this.login.equals(login) && this.senha.equals(senha));
    }
}   