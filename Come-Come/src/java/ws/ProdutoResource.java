/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.ClienteMB;
import bean.ProdutoMB;
import dao.ClienteDaoJpa;
import dao.ProdutoDaoJpa;
import entidade.Cliente;
import entidade.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author Thiago
 */
@Path("produto")
public class ProdutoResource {
    
    @EJB
    ProdutoMB produto;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoResource
     */
    public ProdutoResource() {
    }

    /**
     * Retrieves representation of an instance of ws.ProdutoResource
     * @return an instance of bean.ProdutoMB
     */
    @GET
    
    @Produces("application/json")
           
    public List<Produto> getListaProduto() {
            return new ProdutoDaoJpa().listar();
    }

    /**
     * PUT method for updating or creating an instance of ProdutoResource
     * @param produto representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @POST //Método
    @Consumes("application/json") //Consome json
    @Produces("text/plain") //Produz texto pleno
    public String adicionarProduto(Produto produto) { //Intancia a classe ProdutoMB
        new ProdutoDaoJpa().salvar(produto); //Método da classe JPA e foi intanciado la em cima abaixo do @EJB)
        return "OK"; //Retorno
    
    }
    
}

