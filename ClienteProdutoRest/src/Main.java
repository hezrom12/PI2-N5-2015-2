
import bean.Cliente;
import bean.Produto;
import java.util.List;
import javax.swing.JOptionPane;
import javax.ws.rs.core.GenericType;

import ws.ProdutoWs;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiago & Hezrom
 */
public class Main {
        public static void main(String[]args){

            ProdutoWs produtoc = new ProdutoWs();
            Produto produto = new Produto(
                    JOptionPane.showInputDialog("Nome: "), JOptionPane.showInputDialog("Fornecedor: "));
            //produtoc.adicionarProduto(new Produto("Salgado",4.50));
            System.out.println(produto);
            produtoc.adicionarProduto(produto);
            List<Produto> produtos = produtoc.getListaProduto(  
                new GenericType<List<Produto>>(){});     
                                   
            for(Produto p: produtos){
                System.out.println(p.getNome());
            }
        }
    
}
