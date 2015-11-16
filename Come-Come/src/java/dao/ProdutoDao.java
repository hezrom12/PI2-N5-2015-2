package dao;

import entidade.Produto;
import java.util.List;

public interface ProdutoDao {
    public void remover(Produto p);
    public void salvar(Produto p);
    public Produto buscarPorId(Long id);
    public List<Produto> listar();                
}
