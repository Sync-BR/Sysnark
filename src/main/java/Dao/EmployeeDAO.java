package Dao;

import Beans.EmployeesBeans;
import Connection.Conexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável pelas operações de banco de dados relacionadas aos
 * funcionários. Fornece funcionalidades para recuperar os nomes dos
 * funcionários a partir do banco de dados. Utiliza a conexão provida pela
 * classe {@link Conexao}.
 *
 * @author SYNC
 */
public class EmployeeDAO implements EmployeeInterface {

    /**
     * Variável booleana que indica se o registro de um funcionário foi
     * realizado com sucesso.
     */
    public boolean successfullyRegisteredEmployees = false;

    /**
     * Registra um novo funcionário no banco de dados. Este método configura e
     * executa uma instrução SQL para inserir os dados do funcionário no banco.
     *
     * @param Register Objeto contendo as informações do funcionário a ser
     * registrado.
     * @throws Exception Pode lançar uma exceção SQL se a conexão ou a execução
     * da query falhar.
     */
    @Override
    public void RegisterEmployees(EmployeesBeans Register) throws Exception {
        Connection connection = null; // Inicializa a conexão com o banco de dados como nula.
        PreparedStatement stm = null; // Inicializa o objeto para preparação da instrução SQL como nulo.
        successfullyRegisteredEmployees = false; // Reseta a variável de sucesso para falso a cada chamada do método.

        // String SQL contendo a instrução de inserção com placeholders para os valores.
        String sql = "INSERT INTO market.employees (Employeename, Dateofbirth, Cpf, Cep, Road, Neighborhood, City, Housenumber, Complement, Cellphone, Bank, Bankaccount, Login, Password, Access, State) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            connection = Conexao.getConnection(); // Estabelece uma nova conexão com o banco de dados.
            stm = connection.prepareStatement(sql); // Prepara a instrução SQL para execução.

            // Configura os valores para cada placeholder na instrução SQL, baseando-se nos dados do objeto Register.
            stm.setString(1, Register.getName());
            stm.setDate(2, Register.getDate());
            stm.setString(3, Register.getCpf());
            stm.setString(4, Register.getCep());
            stm.setString(5, Register.getRoad());
            stm.setString(6, Register.getNeighborhood());
            stm.setString(7, Register.getCity());
            stm.setInt(8, Register.getHousenumber());
            stm.setString(9, Register.getComplement());
            stm.setString(10, Register.getTelephone());
            stm.setString(11, Register.getBank());
            stm.setString(12, Register.getBankaccount());
            stm.setString(13, Register.getLogin());
            stm.setString(14, Register.getPassword());
            stm.setInt(15, Register.getAccess());
            stm.setString(16, Register.getState());

            // Executa a instrução SQL e verifica o retorno para determinar o sucesso da operação.
            int sucesso = stm.executeUpdate();
            if (sucesso > 0) {
                successfullyRegisteredEmployees = true; // Atualiza o estado de sucesso para verdadeiro se o registro foi bem-sucedido.
            } 
        } catch (SQLException e) {
            // Imprime o stack trace para qualquer exceção SQL que ocorra durante o processo.
            e.printStackTrace();
        } finally {
            // Fecha a conexão e o PreparedStatement para liberar recursos.
            Conexao.closeConnection(connection, stm);
        }
    }

    /*
    *
    *@Saveemployee Funcionalidade para editar um funcionario no banco de dados
     */
    //UPDATE `market`.`employees` SET `Employeename` = 'John Does' WHERE (`idEmployees` = '1');
    public boolean savedSuccessfully = false;

    @Override
    public void Saveemployee(EmployeesBeans Addemployee) throws Exception {
        savedSuccessfully = false; //Iniciar variavel logica como falso.
        Connection connection = null;
        PreparedStatement ps = null;
        String sql = "UPDATE market.employees set  Dateofbirth = ?, Cpf = ?, Cep = ?,State = ?, Road = ?, Neighborhood = ?, City = ?,  Complement = ?, Cellphone = ?, Bank = ?, Bankaccount = ?, Login = ?, Password = ?, Access = ? where Employeename = ?";

        try {
            connection = Conexao.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setDate(1, Addemployee.getDate());
            ps.setString(2, Addemployee.getCpf());
            ps.setString(3, Addemployee.getCep());
            ps.setString(4, Addemployee.getState());
            ps.setString(5, Addemployee.getRoad());
            ps.setString(6, Addemployee.getNeighborhood());
            ps.setString(7, Addemployee.getCity());
            ps.setString(8, Addemployee.getComplement());
            ps.setString(9, Addemployee.getTelephone());
            ps.setString(10, Addemployee.getBank());
            ps.setString(11, Addemployee.getBankaccount());
            ps.setString(12, Addemployee.getLogin());
            ps.setString(13, Addemployee.getPassword());
            ps.setInt(14, Addemployee.getAccess());
            ps.setString(15, Addemployee.getName());
            int Successfully = ps.executeUpdate();
            if (Successfully > 0) {
                savedSuccessfully = true;
            } else {
                savedSuccessfully = false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * Lista para armazenar os nomes dos funcionários. Os nomes são carregados
     * do banco de dados através do método {@link #Employeelist()}.
     */
    public List<String> name = new ArrayList<>();

    /**
     * Consulta todos os funcionários na base de dados e armazena seus nomes na
     * lista {@code name}. Este método limpa a lista de nomes antes de realizar
     * a consulta para garantir que apenas dados atuais sejam mantidos.
     *
     * @throws Exception Caso ocorra algum erro durante a conexão ao banco de
     * dados ou na execução da consulta SQL.
     */
    @Override
    public void Employeelist() throws Exception {
        Connection connection = null; // Iniciar a conexão como nula.
        PreparedStatement ps = null; // Iniciar o PreparedStatement como nulo.
        ResultSet rs = null; // Iniciar o ResultSet como nulo.
        String sql = "SELECT * FROM market.employees"; // Instrução SQL para consultar todos os funcionários.
        name.clear(); // Limpa a lista de nomes para garantir que não haja dados antigos.
        try {
            connection = Conexao.getConnection(); // Obter a conexão com o banco de dados.
            ps = connection.prepareStatement(sql); // Preparar a consulta SQL.
            rs = ps.executeQuery(); // Executar a consulta e obter o ResultSet.
            // Iterar sobre o ResultSet e adicionar cada nome encontrado à lista de nomes.
            while (rs.next()) {
                name.add(rs.getString("Employeename"));
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir a pilha de exceções em caso de erro SQL.
            throw new Exception("Erro ao acessar o banco de dados", e); // Lançar uma exceção indicando o erro.
        } finally {
            Conexao.closeConnection(connection, rs, ps);
        }
    }

    /**
     * @Searchemployees Funcionalidade para efetuar uma pesquisar especificar de
     * um funcionario.
     * @employeeFound Variavel responsavel pelo sucesso de uma pesquisar.
     */
    public boolean employeeFound;

    public void Searchemployees(EmployeesBeans Search) throws Exception {
        Connection connection = null; //Iniciar a conexão nula.
        PreparedStatement ps = null; //Iniciar as intruções nulo
        ResultSet rs = null; //Iniciar o conjunto de resultado nulo.
        employeeFound = false; // iniciar variavel que indicar que não foi encontrado ianda um funcionario
        String sql = "SELECT * FROM market.employees where Employeename = ?"; //instrução sql
        try {
            connection = Conexao.getConnection(); //Pegar a conexão.
            ps = connection.prepareStatement(sql); //Passar as intruções SQL.
            ps.setString(1, Search.getName()); // Pegar o parametro para pesquisar.
            rs = ps.executeQuery(); //Executar conjuto do resulteset para efetuar uma pesquisar de usuario.
            //Retornar os dados
            while (rs.next()) {
                Search.setName(rs.getString("Employeename"));
                Search.setDate(rs.getDate("Dateofbirth"));
                Search.setCpf(rs.getString("Cpf"));
                Search.setCep(rs.getString("Cep"));
                Search.setState(rs.getString("State"));
                Search.setRoad(rs.getString("Road"));
                Search.setNeighborhood(rs.getString("Neighborhood"));
                Search.setCity(rs.getString("City"));
                Search.setHousenumber(rs.getInt("Housenumber"));
                Search.setComplement(rs.getString("Complement"));
                Search.setTelephone(rs.getString("Cellphone"));
                Search.setBank(rs.getString("Bank"));
                Search.setBankaccount(rs.getString("Bankaccount"));
                Search.setLogin(rs.getString("Login"));
                Search.setPassword(rs.getString("Password"));
                Search.setAccess(rs.getInt("Access"));
                employeeFound = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.closeConnection(connection, rs, ps);
        }

    }

    public static void main(String[] args) throws Exception {
        EmployeesBeans add = new EmployeesBeans();
        EmployeeDAO p1 = new EmployeeDAO();
        Date data = new Date(1998 - 04 - 24);
        add.setName("SYNC");
        add.setDate(data);
        add.setCpf("061.260.395-48");
        add.setCep("40484-550");
        add.setRoad("Adilson Leite");
        add.setCity("Salvador");
        add.setNeighborhood("BRAZUK");
        add.setState("Alto do cabrito");
        add.setTelephone("71981590149");
        add.setBank("Banco do Brasil");
        add.setBankaccount("8554-5");
        add.setLogin("admin");
        add.setPassword("81555");
        add.setAccess(3);
        try {
            p1.RegisterEmployees(add);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
