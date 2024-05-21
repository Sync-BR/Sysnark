package Dao;

import Beans.EmployeesBeans;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Connection.Conexao;
import java.sql.ResultSet;

/**
 * Classe responsável pela autenticação de usuários no sistema. Utiliza uma
 * verificação de credenciais (login e senha) no banco de dados para permitir
 * acesso.
 *
 * @author SYNC
 */
public class AuthenticateDao {

    /**
     * @authenticatedSuccessfully flag que indica se a autenticação foi
     * bem-sucedida. Se verdadeiro, o usuário foi autenticado com sucesso. Se
     * falso, as credenciais são inválidas ou ocorreu um erro durante a
     * autenticação.
     * administrator indica que o tipo de usuario é um administrador. Tipo 3
     * @stockManager indica que o tipo da conta é um gestor de estoque. tipo 2
     * @Employee indica que o tipo da conta é um Funcionário. Tipo 1
     */
    public boolean authenticatedSuccessfully;
    public boolean administrator;
    public boolean stockManager;
    public boolean employee;

    /**
     * Tenta autenticar um usuário com base nas credenciais fornecidas. Este
     * método configura uma conexão com o banco de dados, executa uma consulta
     * SQL e verifica se há correspondência para o par login/senha fornecidos.
     *
     * @param Login Objeto contendo os detalhes de login do usuário
     * (login e senha).
     * @throws Exception Se ocorrer um erro durante a conexão com o banco de
     * dados ou durante a execução da consulta.
     */
    public int access = 0;
    public void login(EmployeesBeans Login) throws Exception {
        Connection connection = null; // Inicializa a conexão como nula.
        PreparedStatement ps = null; // Inicializa o statement como nulo.
        ResultSet rs = null; // Inicializa o ResultSet como nulo.
        authenticatedSuccessfully = false; // Inicia como false até que se prove o contrário.
        administrator = false; //Inicializa variavel da conta administrador falso.
        stockManager = false; // Inicializa variavel da conta Gestor de Estoque. 
        employee = false; //Inicializa variavel da conta de funcionario.

        String sql = "SELECT * FROM market.employees WHERE Login = ? AND Password = ?"; // Consulta SQL para verificar login.

        try {
            connection = Conexao.getConnection(); // Estabelece conexão com o banco de dados.
            ps = connection.prepareStatement(sql); // Prepara a consulta SQL.
            ps.setString(1, Login.getLogin()); // Define o primeiro parâmetro da consulta (login).
            ps.setString(2, Login.getPassword()); // Define o segundo parâmetro da consulta (senha).
            rs = ps.executeQuery(); // Executa a consulta e retorna um ResultSet.
            // Verifica se há pelo menos um resultado na consulta.
            while (rs.next()) {
                authenticatedSuccessfully = true; // Autenticação bem-sucedida.
                access = rs.getInt("Access");
            }
            //Verificar o tipo de acesso 
            if(access == 3){
                administrator = true; //A conta é de um administrador
            } else if(access == 2){
                stockManager = true; //A conta é de um gestor de estoque. 
            } else if(access == 1){
                employee = true; //A conta é de um funcionário
            } else{
                administrator = false;
                stockManager = false;
                employee = false;
                authenticatedSuccessfully = false;    
            }
            
        } catch (SQLException e) {
            e.printStackTrace(); // Imprime o erro de SQL no console.
        } finally {
            Conexao.closeConnection(connection, rs, ps); // Fecha a conexão com o banco e outros recursos.
        }
    }

  

}
