package bean;

import dao.ProdutoDaoJpa;
import entidade.Produto;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(eager = true)
@ApplicationScoped 
public class ProdutoMB {

    private List<Produto> listaProdutos;
    private Produto produtoSelecionado;

    public ProdutoMB() {
        produtoSelecionado = new Produto();
       
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public List<Produto> getListaProdutos() {
        return new ProdutoDaoJpa().listar();
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }
    

    public String novoProduto(){
        produtoSelecionado=new Produto();
        return("/admin/formProdutoAdd?faces-redirect=true");
    }

    public String adicionarProduto()
    {
        new ProdutoDaoJpa().salvar(produtoSelecionado);
        return(this.novoProduto());
    }

    public String editarProduto(Produto p){
        produtoSelecionado = p;
        return("/admin/formProdutoEdit?faces-redirect=true");
    }
    public String atualizarProduto()
    {
        new ProdutoDaoJpa().salvar(produtoSelecionado);
        return("/admin/index?faces-redirect=true");
    }

    public void removerProduto(Produto p){
       new ProdutoDaoJpa().remover(p);
    }

}
