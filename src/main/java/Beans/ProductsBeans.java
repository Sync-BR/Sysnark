package Beans;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author SYNC
 */
public class ProductsBeans {

 public ProductsBeans() {
    }

    private int Id;
    private String Name;
    private String Description;
    private String Price;
    private String Barcode;
    private String Brand;
    private int Amount;

    public ProductsBeans(int id, String nome, String Descricao, String preco, String Codigodebarras, String brand, int amount) {
        this.Id = id;
        this.Name = nome;
        this.Description = Descricao;
        this.Price = preco;
        this.Barcode = Codigodebarras;
        this.Brand = brand;
        this.Amount = amount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String Price) {
        this.Price = Price;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }
        public int getAmount() {
        return Amount;
    }

    public void setAmount(int Amount) {
        this.Amount = Amount;
    }

    public static void main(String[] args) {
        Locale localBR = new Locale("pt", "BR"); //Criar uma objeto representando a região do brasil
        double real = 2.25; // Valor do dinheiro
        NumberFormat dinheiro = NumberFormat.getCurrencyInstance(localBR); //Criar um objeto para formatar a moeda 
        System.out.println("Dinheiro " + dinheiro.format(real)); //Aplicar a formatação em valor em dinheiro
    }

}
