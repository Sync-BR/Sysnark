package Beans;

import java.sql.Date;

/**
 *
 * @author SYNC
 */
public class EmployeesBeans {

    public EmployeesBeans() {
    }
    private int id;
    private String name;
    private Date date;
    private String cpf;
    private String cep;
    private String road;
    private String neighborhood;
    private String city;
    private String state;
    private int housenumber;
    private String complement;
    private String telephone;
    private String bank;
    private String bankaccount;
    private String login;
    private String password;
    private int access;
    public EmployeesBeans(String Login, String Password){
        this.login = Login;
        this.password = Password;
    }
    public EmployeesBeans(String Name, Date Date, String Cpf, String Cep,String Road,String Neighborhood, String City, String State, int Housenumber, String Complement, String Telephone, String Bank, String Bankaccount, String Login, String Password, int Access){
        this.name = Name;
        this.date = Date;
        this.cpf = Cpf;
        this.cep = Cep;
        this.road = Road;
        this.neighborhood = Neighborhood;
        this.city = City;
        this.state = State;
        this.housenumber = Housenumber;
        this.complement = Complement;
        this.telephone = Telephone;
        this.bank = Bank;
        this.bankaccount = Bankaccount;
        this.login = Login;
        this.password = Password;
        this.access = Access;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Date getDate() {
        return date;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRoad() {
        return road;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public String getComplement() {
        return complement;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getBank() {
        return bank;
    }

    public String getBankaccount() {
        return bankaccount;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRoad(String road) {
        this.road = road;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setBankaccount(String bankaccount) {
        this.bankaccount = bankaccount;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccess() {
        return access;
    }

    public void setAccess(int access) {
        this.access = access;
    }
    public String getCep(){
        return cep;
    }
    public void setCep(String cep){
        this.cep = cep;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
  
}
