/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import bean.Produto;
import com.google.gson.Gson;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:ProdutoResource [produto]<br>
 * USAGE:
 * <pre>
 *        ProdutoWs client = new ProdutoWs();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Thiago
 */
public class ProdutoWs {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Come-Come/webresources";

    public ProdutoWs() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("produto");
    }

    /**
      public String adicionarContato(Contato contato) throws ClientErrorException {
        WebTarget resource = webTarget;
        Gson gson = new Gson();
        String json = gson.toJson(contato);
        System.out.println(json);

        Response response =  resource.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        
        final String responseEntity = response.readEntity(String.class);
        System.out.println(responseEntity);
        return(responseEntity);
     */
    public String adicionarProduto(Produto produto) throws ClientErrorException {
        WebTarget resource = webTarget;
        Gson gson = new Gson();
        String json = gson.toJson(produto);
        System.out.println(json);

        Response response =  resource.request().post(Entity.entity(json, MediaType.APPLICATION_JSON));
        System.out.println(response.getStatus());
        final String responseEntity = response.readEntity(String.class);
        System.out.println(responseEntity);
        return(responseEntity);
        
        
    
    }

    public <T> T getListaProduto(GenericType<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
