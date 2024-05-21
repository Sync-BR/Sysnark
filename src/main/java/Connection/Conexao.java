package Connection;

import settings.Settings;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author SYNC
 * @Conexao Está classe está armazenado todas codigo da conexão
 */
public class Conexao {

    /**
     * @author SYNC
     * @Connection Efetuar conexão com banco de dados
     * @getConnection Retornar conexão
     * @connection Variavel global para armazenar a conexão
     */
    private static Connection connection = null;

    public static Connection getConnection() throws Exception {
        //Carregar os drivers jdbc
        Class.forName("com.mysql.jdbc.Driver");
        try {
            return DriverManager.getConnection(Settings.host + "/" + Settings.db, Settings.user, Settings.password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    /**
     * @author SYNC
     * @close Receber os parametros do fechamento da conexão e encerra de acordo com a nescessidade.
     */
    private static void close(Connection conn, Statement stm, ResultSet rs) throws Exception {
        try {
            if (conn != null) {
                conn.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author SYNC
     * @closeConnection Encerrar um conjuto de conexões, Statement e ResultSet.
     */
    public static void closeConnection(Connection conn, ResultSet rs, Statement stm) throws Exception {
        close(conn, stm, rs);
    }

    /**
     * @author SYNC
     * @closeConnection Encerrar um conjuto de conexões e Statement.
     */
    public static void closeConnection(Connection conn, Statement stm) throws Exception {
        close(conn, stm, null);
    }

    /**
     * @author SYNC
     * @closeConnection Encerrar apenas a conexão.
     */
    public static void closeConnection(Connection conn) throws Exception {
        close(conn, null, null);
    }

}
