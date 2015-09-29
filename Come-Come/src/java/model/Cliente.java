
package model;


public class Cliente {
    
    public final static int MASCULINO = 1;
    public final static int FEMININO = 2;
    private String nome;
    private String telefone;
    private String email;
    private String cpf;
    private String rg;
    private int sexo;
    private String cidade;
    

    public Cliente() {
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public int getSexo() {
        return sexo;
    }

     public String getSexoString() {
        if(sexo==1) return "Masculino";
        else return "Feminino";
    }
    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
  

       
    
    
}
