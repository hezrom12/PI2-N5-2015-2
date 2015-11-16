package dao;


import entidade.Usuario;
import java.util.List;
import javax.persistence.EntityManager;
import util.JpaUtil;

public class UsuarioDaoJpa implements UsuarioDao {
    

    @Override
    public void salvar(Usuario u) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        if (u.getId() == null) {
            em.persist(u);
        } else {
            em.merge(u);
        }
        em.getTransaction().commit();
        em.close();

    }

    @Override
    public void remover(Usuario u) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();        
        em.remove(em.merge(u));
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        EntityManager em = JpaUtil.getEntityManager();
        Usuario usuario = em.find(Usuario.class, id);
        em.close();
        return (usuario);
    }

    @Override
    public List<Usuario> listar() {
        EntityManager em = JpaUtil.getEntityManager();
        List<Usuario> listaUsuarios = em.createQuery("SELECT u FROM Usuario u").getResultList();
        em.close();
        return (listaUsuarios);
    }

}
