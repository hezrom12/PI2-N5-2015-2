package dao;

import entidade.Usuario;
import java.util.List;

public interface UsuarioDao {
    public void remover(Usuario u);
    public void salvar(Usuario u);
    public Usuario buscarPorId(Long id);
    public List<Usuario> listar();                
}
