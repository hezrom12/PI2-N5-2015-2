package bean;
import dao.UsuarioDaoJpa;
import entidade.Usuario;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager = true)
@ApplicationScoped 
public class UsuarioMB {

    private List<Usuario> listaUsuarios;
    private Usuario usuarioSelecionado;

    public UsuarioMB() {
        usuarioSelecionado = new Usuario();
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public List<Usuario> getListaUsuarios() {
        return new UsuarioDaoJpa().listar();
    }
    
    public List<Usuario> getListaUsuariosalt() {
        return new UsuarioDaoJpa().listaralt();
    }

    public void setListaUsuarios(List<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    

    public String novoUsuario(){
        usuarioSelecionado=new Usuario();
        return("/admin/formUsuarioAdd?faces-redirect=true");
    }

    public String adicionarUsuario()
    {
        new UsuarioDaoJpa().salvar(usuarioSelecionado);
        return(this.novoUsuario());
    }

    public String editarUsuario(Usuario u){
        usuarioSelecionado = u;
        return("/admin/formUsuarioEdit?faces-redirect=true");
    }
    public String atualizarUsuario()
    {
        new UsuarioDaoJpa().salvar(usuarioSelecionado);
        return("/admin/index?faces-redirect=true");
    }

    public void removerUsuario(Usuario u){
        new UsuarioDaoJpa().remover(u);
    }

}
