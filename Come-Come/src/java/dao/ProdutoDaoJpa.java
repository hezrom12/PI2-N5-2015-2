package dao;


import entidade.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import util.JpaUtil;

public class ProdutoDaoJpa implements ProdutoDao {
    

    @Override
    public void salvar(Produto p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (p.getId() == null) {
            em.persist(p);
        } else {
            em.merge(p);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remover(Produto p) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(p));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Produto buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Produto produto = em.find(Produto.class, id);
        em.close();
        return (produto);
    }

    @Override
    public List<Produto> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Produto> listaProdutos = em.createQuery("SELECT p FROM Produto p").getResultList();
        em.close();
        return (listaProdutos);
    }

}
