package Api;
import Beans.ApiAddressBeans;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;




/**
 * Classe responsável por realizar consultas de CEP usando a API ViaCEP. Esta
 * classe permite a recuperação de dados de endereço a partir de um código
 * postal (CEP) fornecido.
 *
 * @author SYNC
 */

public class CEPQuery {
    public String bairro;

    /**
     * URL base da API ViaCEP para consulta de CEPs.
     */
    public static  boolean Zipfound;
    public static final String url = "https://viacep.com.br/ws/";

    /**
     * Realiza uma busca de dados de endereço a partir de um CEP especificado. A
     * função conecta-se à API ViaCEP, realiza uma requisição GET e retorna os
     * dados de endereço mapeados para um objeto {@link ApiAddressBeans}.
     *
     * @param cep O CEP para o qual os dados de endereço serão buscados.
     * @return Um objeto {@link ApiAddressBeans} contendo os dados do endereço
     * associado ao CEP, ou {@code null} se ocorrer um erro.
     * Zipcodefound Responsavel por dizer se o cep foi encontrado.
     */
    public static ApiAddressBeans ZIPcodesearch(String cep) {
                Zipfound =  false;    

        String urlfinal = url + cep + "/json/"; // Constrói a URL final para a consulta de CEP.
        // Cria uma instância padrão do HttpClient e garante que os recursos serão fechados automaticamente.
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(urlfinal); // Cria uma requisição GET para a URL específica.
            // Executa a requisição e processa a resposta HTTP.
            return httpClient.execute(request, httpResponse -> {
                Zipfound = true; 
                String json = EntityUtils.toString(httpResponse.getEntity()); // Converte o corpo da resposta em uma string JSON.
                ObjectMapper mapper = new ObjectMapper(); // Instancia um ObjectMapper para deserialização.
                mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false); // Configura o ObjectMapper para ignorar propriedades desconhecidas no JSON.
                return mapper.readValue(json, ApiAddressBeans.class);// Deserializa o JSON para um objeto ApiAddressBeans.
                
            });
            
        } catch (IOException e) {
            e.printStackTrace(); // Imprime o rastreamento de pilha para erros.
            return null; // Retorna null em caso de falhas na requisição ou processamento.
        }

    }

    /**
     * Método principal para testar a consulta de CEP.
     *
     * @param args Argumentos da linha de comando.
     * @throws Exception Pode lançar exceções relacionadas a falhas de conexão
     * ou processamento.
     */
    public static void main(String[] args) throws Exception {
        String cep = "40484-550"; // Define um CEP para teste.
        ApiAddressBeans address = ZIPcodesearch(cep); // Realiza a consulta do CEP.

        // Verifica se a consulta retornou resultados e imprime os detalhes do endereço.
        if (address != null) {
            System.out.println("Rua: " + address.getLogradouro());
            System.out.println("Bairro: " + address.getBairro());
            System.out.println("Cidade: " + address.getLocalidade());
            System.out.println("Estado: " + address.getUf());

        } else {
            System.out.println("Falha ao buscar dados para o CEP fornecido.");
        }
    }
}
