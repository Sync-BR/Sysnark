package Dao;

import Beans.ProductsBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author SYNC
 */
public class ProductsDao {

    // Lista para armazenar os nomes dos produtos recuperados do banco de dados.
    public  List<Integer> Productid = new ArrayList<>();
    public  List<String> Productnames = new ArrayList<>();

    /**
     * Recupera os nomes dos produtos do banco de dados e os armazena na lista
     * 'productNames'.
     *
     * @throws SQLException Se ocorrer um erro de SQL durante o processo de
     * consulta ou conexão.
     */
    public void returnProductnames() throws Exception {
        Connection connection = null; //Iniciando a conexão null
        PreparedStatement ps = null; // Iniciando as intruções nulla
        ResultSet rs = null; // Iniciando os resultados nullos
        Productid.clear(); // Limpa a lista antes de adicionar novos id.
        Productnames.clear(); // Limpa a lista antes de adicionar novos nomes.
        try {
            String sql = "SELECT * FROM market.products;"; // Código SQL para obter os nomes dos produtos.
            connection = Conexao.getConnection();  // Obter conexão com o banco de dados.
            ps = connection.prepareStatement(sql); // Preparar a instrução SQL.
            rs = ps.executeQuery(); // Executar a consulta e obter o conjunto de resultados.        
            while (rs.next()) {
                Productid.add(rs.getInt("idproducts"));
                Productnames.add(rs.getString("nameProduct")); // Adiciona cada nome do produto na lista.
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean savedSuccessfully;
    /**
     * Classe responsável pela atualização dos produtos na base de dados. Inclui uma
     * variável savedSuccessfully que indica se  foi salvo dcom sucesso
     *
     * @author SYNC
     */
    public void UpdateProducts(ProductsBeans update) throws Exception{
        Connection connection = null; //Inicializando a conexão null
        PreparedStatement ps = null; //Inicializando a instrução sql null
        String sql ="UPDATE market.products set  descriptionProduct = ? , priceProduct = ?, barcodeProduct = ?, brandProduct = ?, amountproduct =? where nameProduct = ?" ;
        try{
            connection = Conexao.getConnection(); //Iniciando a conexão
            ps = connection.prepareStatement(sql); //Preparando as intruções sql
            // Configura os parâmetros da instrução SQL.
            ps.setString(1, update.getDescription());
            ps.setString(2, update.getPrice());
            ps.setString(3, update.getBarcode());
            ps.setString(4, update.getBrand());
            ps.setInt(5, update.getAmount());
            ps.setString(6,update.getName());
            int Updatedsuccessfully  = ps.executeUpdate(); //Executar instrução SQL.
            if(Updatedsuccessfully > 0){
                savedSuccessfully = true; //Se atualizar retornar verdadeiro
            } else {
                savedSuccessfully = false; //Se falhar retornar falso
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    
    }
   
    
    
    /**
     * Classe responsável pela inserção de produtos na base de dados. Inclui uma
     * variável Successfulregistration que indica se o registro foi
     * bem-sucedido.
     *
     * @author SYNC
     */
    public static boolean Successfulregistration;

    /**
     * Insere um novo produto no banco de dados com base nas informações
     * fornecidas. Atualiza a variável {@code Successfulregistration} para
     * indicar o sucesso ou falha do registro.
     *
     * @param addProducts O objeto contendo as informações do produto a ser
     * inserido.
     * @throws Exception Se ocorrer um erro durante a conexão com o banco de
     * dados ou a execução da query.
     */
    public void addProducts(ProductsBeans addProducts) throws Exception {
        Successfulregistration = false;
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            // Define a query SQL para inserção de um novo produto.
            String sql = "INSERT INTO market.products (nameProduct, priceProduct, barcodeProduct, brandProduct,amountproduct, descriptionProduct) "
                    + "values (?,?,?,?,?,?)";
            connection = Conexao.getConnection(); // Obtém uma conexão com o banco de dados.
            ps = connection.prepareStatement(sql);// Prepara a instrução SQL.
            // Configura os parâmetros da instrução SQL.
            ps.setString(1, addProducts.getName());
            ps.setString(2, addProducts.getPrice());
            ps.setString(3, addProducts.getBarcode());
            ps.setString(4, addProducts.getBrand());
            ps.setInt(5, addProducts.getAmount());
            ps.setString(6, addProducts.getDescription());
            int Addedsuccessfully = ps.executeUpdate();
            // Verifica se a inserção foi bem-sucedida.
            if (Addedsuccessfully > 0) {
                System.out.println("Sucesso");
                Successfulregistration = true;
            } else {
                System.out.println("Falhou");
                Successfulregistration = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, e); // Exibe uma mensagem de erro ao usuário.
        }
    }
    //Variavel responsavel por dizer se a operação foi bem sucedido
    public boolean successfullyRemoved;

    /**
     *
     * @author SYNC
     * @removeProduct Classe responsável pela remoção do produto através do
     * código de barras
     */
    public void removeProduct(ProductsBeans deleteProduct) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            String sql = "DELETE FROM market.products where barcodeProduct = ?;";
            connection = Conexao.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, deleteProduct.getBarcode());
            int Success = ps.executeUpdate();
            if (Success > 0) {
                successfullyRemoved = true;
            } else {
                successfullyRemoved = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    //Variavel logica para verificar se o produto foi adicionado com sucesso.
    public boolean Productfound;

    /**
     * Busca um produto no banco de dados utilizando o nome fornecido.
     *
     * @param Search Parametro que contém o nome do produto a ser buscado.
     * @throws java.lang.Exception Lança uma exceção se ocorrer um problema ao
     * acessar o banco de dados. Este método ajusta a flag {@code Productfound}
     * para true se o produto for encontrado.
     */
    public void searchProducts(ProductsBeans Search) throws Exception {
        Connection connection = null; // Inicializa a conexão como nula.
        PreparedStatement ps = null; // Inicializa o PreparedStatement como nulo.
        ResultSet rs = null; // Inicializa o ResultSet como nulo.
        Productfound = false; // Inicia a variável lógica indicando que o produto não foi encontrado.
        String sql = "SELECT * FROM market.products where nameProduct = ?;"; // Query SQL para buscar produto por nome.
        try {
            connection = Conexao.getConnection(); // Estabelece a conexão com o banco de dados.
            ps = connection.prepareStatement(sql); // Prepara a query SQL para execução.
            
            ps.setString(1, Search.getName()); // Define o nome do produto a ser buscado na query.
            rs = ps.executeQuery(); // Executa a query e recebe os resultados.

            if (rs.next()) {
                // Configura os atributos do objeto ProductsBeans com os dados obtidos.
                Search.setId(rs.getInt("idproducts")); //Atualizar o id do produto
                Search.setName(rs.getString("nameProduct")); // Atualiza o nome do produto.
                Search.setDescription(rs.getString("descriptionProduct")); // Atualiza a descrição do produto.
                Search.setPrice(rs.getString("priceProduct")); // Atualiza o preço do produto.
                Search.setBarcode(rs.getString("barcodeProduct")); // Atualiza o código de barras do produto.
                Search.setBrand(rs.getString("brandProduct")); // Atualiza a marca do produto.
                Search.setAmount(rs.getInt("amountProduct")); // Atualiza a quantidade de produtos em estoque.
                Productfound = true; // Define a flag como verdadeira indicando que o produto foi encontrado.
            }
        } catch (SQLException e) {
            // Mostra uma caixa de diálogo com o erro se algo falhar na execução da query.
            JOptionPane.showMessageDialog(null, e);
        } finally {
            // Fechamento seguro de recursos (ResultSet, PreparedStatement e Connection)
            Conexao.closeConnection(connection, rs, ps);
        }
    }
}
