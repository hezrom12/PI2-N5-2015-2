package bean;

import dao.ProdutoDaoJpa;
import model.Produto;
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

    public List<entidade.Produto> getListaProdutos() {
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
        listaProdutos.add(produtoSelecionado);
        return(this.novoProduto());
    }

    public String editarProduto(Produto p){
        produtoSelecionado = p;
        return("/admin/formProdutoEdit?faces-redirect=true");
    }
    public String atualizarProduto()
    {
        return("/admin/index?faces-redirect=true");
    }

    public void removerProduto(Produto produto){
        listaProdutos.remove(produto);
    }

}
