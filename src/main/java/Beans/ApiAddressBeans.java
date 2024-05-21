package Beans;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author SYNC
 * @ ApiAddressBeans Está classe tem relação com api para o retorno do endereço
 */
@JsonIgnoreProperties(ignoreUnknown = true)

public class ApiAddressBeans {
    private String cep;
    public static String logradouro;
    public static String complemento;
    public  static String bairro;
    public static String localidade;
    public static String uf;

    
   

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
