package com.mycompany.mercadinho;

import Dao.ProductsDao;
import Dao.EmployeeDAO;
import Screens.ManageProducts;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe principal do sistema Mercadinho, responsável pela inicialização da
 * interface gráfica e pelo carregamento inicial das funcionalidades
 * relacionadas à gestão de produtos.
 *
 * @author SYNC
 */
public class Mercadinho {

    /**
     * Carrega os nomes dos produtos do banco de dados e os adiciona ao
     * componente de interface gráfica. Utiliza a classe ProductsDao para
     * acessar os dados.
     *
     * @throws Exception Caso ocorra algum erro durante a recuperação dos dados
     * do banco.
     */
    public void searchProducts() throws Exception {
        ProductsDao Searchproducts = new ProductsDao(); // Instanciação da classe DAO para acesso aos produtos
        Searchproducts.returnProductnames(); // Buscar todos os nomes de produtos na base de dados.
        // Adiciona os nomes dos produtos recuperados à lista desdobrável na tela de gerenciamento.
        for (int index = 0; index < Searchproducts.Productnames.size(); index++) {
            ManageProducts.productReturn.addItem(Searchproducts.Productnames.get(index));

        }
    }

    /**
     * Carrega os nomes dos funcionários do banco de dados e os adiciona a um
     * componente JComboBox na interface gráfica. Este método utiliza a classe
     * {@code EmployeeDAO} para acessar e recuperar uma lista de nomes de
     * funcionários. Os nomes são então adicionados ao componente JComboBox
     * {@code Employeelist} na interface gráfica {@code ManageProducts}.
     *
     * A execução deste método implica em operações de acesso ao banco de dados,
     * que podem resultar em exceções caso haja problemas na conexão com o banco
     * ou na execução da consulta SQL.
     *
     * @throws Exception Se ocorrer algum erro durante a recuperação dos dados
     * do banco, uma exceção será lançada. Isso pode incluir erros de conexão,
     * falhas de SQL ou problemas ao acessar o componente da interface gráfica.
     */
    public void searchEmployees() throws Exception {
        EmployeeDAO returnEmployees = new EmployeeDAO(); // Cria uma instância da classe EmployeeDAO.
        returnEmployees.Employeelist(); // Chama o método para retornar a lista de nomes dos empregados.

        // Adiciona os nomes dos empregados ao componente JComboBox na interface gráfica.
        for (int index = 0; index < returnEmployees.name.size(); index++) {
            ManageProducts.Employeelist.addItem(returnEmployees.name.get(index));
        }
    }

    /**
     * Ponto de entrada do programa. Este método inicia a interface gráfica e
     * carrega os produtos disponíveis.
     *
     * @param args Argumentos de linha de comando.
     * @throws Exception Caso ocorra algum erro durante a inicialização do
     * programa.
     */
    public static void main(String[] args) throws Exception {
        Mercadinho init = new Mercadinho(); //Adicionar suporte para utilizar as funcioinalidades

        // Inicialização e exibição da janela de gerenciamento de produtos.
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new ManageProducts().setVisible(true);
                try {
                    // Carrega os produtos para a interface gráfica logo após a inicialização da tela.
                    init.searchProducts();
                } catch (Exception ex) {
                    Logger.getLogger(Mercadinho.class.getName()).log(Level.SEVERE, null, ex);
                }
                init.searchEmployees();
            } catch (Exception ex) {
                Logger.getLogger(Mercadinho.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
}
