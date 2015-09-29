package bean;

import model.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager = true)
@ApplicationScoped 
public class ClienteMB {

    private List<Cliente> listaClientes;
    private Cliente clienteSelecionado;

    public ClienteMB() {
        clienteSelecionado = new Cliente();
        listaClientes = new ArrayList<Cliente>();
       
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
        listaClientes.add(clienteSelecionado);
        return(this.novoCliente());
    }

    public String editarCliente(Cliente c){
        clienteSelecionado = c;
        return("/admin/formClienteEdit?faces-redirect=true");
    }
    public String atualizarCliente()
    {
        return("/admin/index?faces-redirect=true");
    }

    public void removerCliente(Cliente cliente){
        listaClientes.remove(cliente);
    }

}
