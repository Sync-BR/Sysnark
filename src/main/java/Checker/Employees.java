package Checker;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Connection.Conexao;

/**
 * Classe responsável por operações relacionadas aos funcionários no banco de
 * dados. Esta classe fornece métodos para verificar a existência de um
 * funcionário com base em seu nome de usuário.
 *
 * @author SYNC
 */
public class Employees implements InterfaceEmployees {

    public static int EmployeeAccess = 0; //Tipo de acesso
    public boolean Employeefound = false; // Indica se um funcionário foi encontrado

    /**
     * Verifica a existência de um nome de usuário no banco de dados. Este
     * método consulta o banco de dados para determinar se um nome de usuário já
     * está em uso.
     *
     * @param employees Objeto contendo os dados do funcionário a ser
     * verificado.
     * @throws Exception Pode lançar uma exceção se ocorrer um erro de SQL ou de
     * conexão.
     */
    public void Checkname(String name) throws Exception {
        Connection connection = null; // Inicia uma conexão nula.
        PreparedStatement ps = null; // Prepara o ambiente para instruções SQL.
        ResultSet rs = null; // Guarda o resultado da consulta.
        Employeefound = false; // Assume inicialmente que o funcionário não foi encontrado.

        String sql = "SELECT * FROM market.employees WHERE Employeename = ?"; // Instrução SQL para verificar existência do nome de usuário.

        try {
            connection = Conexao.getConnection(); // Estabelece a conexão com o banco de dados.
            ps = connection.prepareStatement(sql); // Prepara a instrução SQL para execução.
            ps.setString(1, name); // Define o nome de usuário para a consulta.
            rs = ps.executeQuery(); // Executa a consulta e armazena o resultado.

            if (rs.next()) {
                Employeefound = true; // Se encontrou um registro, o funcionário existe.
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime a pilha de exceção em caso de erro SQL.
        } finally {
            Conexao.closeConnection(connection, rs, ps); // Fecha a conexão e os recursos usados.
        }
    }
    @Override
    /**
     *
     * @Formatedate Responsavel pelo retorno da data do usuario.
     * @Sobre retornar o valor da data e enviar para uma classe para efetuar a formatação data.
     */
    public void Formatedate(String name) throws Exception{
        String Date = null; //Variavel responsvel por armazenar a data do funcionariio
        Connection connection = null; //Iniciar a conexão nula.
        PreparedStatement ps = null; //Iniciar variavel de instruçõe do SQL
        ResultSet rs = null; //Iniciar conjuynto de resultados para as intriuções SQL
        String sql = "SELECT * FROM market.employees WHERE Employeename = ?"; // Instrução SQL para verificar existência do nome de usuário.
        try{
            connection = Conexao.getConnection(); //Pegar a conexão na classe Conexao.
            ps = connection.prepareStatement(sql); //Prepara as intruções junto com a conexão para enviar pro banco de dados.
            ps.setString(1, name);
            rs = ps.executeQuery(); // Buscar o resultado.
            if(rs.next()){
                Date = rs.getString("Dateofbirth");
            }
            DateChecker checkdate = new DateChecker();
            checkdate.FormateDate(Date);
            
        } catch(SQLException e){
            e.printStackTrace();
        } finally{
            Conexao.closeConnection(connection, rs, ps);
        }
    }
    public static void main(String[] args)  throws Exception{
        Employees check = new Employees();
        check.Formatedate("SYNC");
    }
}
