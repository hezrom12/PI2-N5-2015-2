package bean;

import entidade.Cliente;
import dao.ClienteDaoJpa;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped 
public class ClienteMB {

    private List<Cliente> listaClientes;
    private Cliente clienteSelecionado;

    public ClienteMB() {
        clienteSelecionado = new Cliente();        
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    

    public String novoCliente(){
        clienteSelecionado=new Cliente();
        return("/admin/formClienteAdd?faces-redirect=true");
    }

    public String adicionarCliente()
    {
        new ClienteDaoJpa().salvar(clienteSelecionado);
        return (this.novoCliente());
    }

    public String editarCliente(Cliente c){
        clienteSelecionado = c;
        return("/admin/formClienteEdit?faces-redirect=true");
    }
    public String atualizarCliente()
    {
        new ClienteDaoJpa().salvar(clienteSelecionado);
        return("/admin/index?faces-redirect=true");
    }

    public void removerCliente(Cliente cliente){
        new ClienteDaoJpa().remover(cliente);
        
    }

}
