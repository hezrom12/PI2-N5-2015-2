package dao;

import entidade.Cliente;
import java.util.List;

public interface ClienteDao {
    public void remover(Cliente c);
    public void salvar(Cliente c);
    public Cliente buscarPorId(Long id);
    public List<Cliente> listar();                
}
