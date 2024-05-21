/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Thread;

import Screens.ManageProducts;
import static Screens.ManageProducts.Confirmuserpassword;
import static Screens.ManageProducts.Userpassword;
import Checker.Employees;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 *
 * @author SYNC
 */
public class Threads extends Thread {

    String user;

    public void Verifyuser() {
        Employees check = new Employees();
        Thread thread = new Thread(() -> {
            user = ManageProducts.UserLogin.getText();
            try {
                check.Checkname(user);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (check.Employeefound) {
                ManageProducts.Verifyaccount.setText("Já existe esse login");
            } else {
                ManageProducts.Verifyaccount.setText("Login valido");
            }
        });
        thread.start();
    }

    public boolean Samepasswords; // Variavel lógico responsavel pelas senhas iguais 
    //Funcionalidade responsavel por verifica se as senhas são identicas

    public void Checkpassword() throws Exception {
        Samepasswords = false;
        Thread thread = new Thread(() -> {
            if (Userpassword.getText() != null && Confirmuserpassword.getText() != null) {
                if (Userpassword.getText().equals(Confirmuserpassword.getText())) {
                    ManageProducts.Verifyaccount.setText("Senha confirmada!");
                    Samepasswords = true;
                    stop();
                } else {
                    //Caso a senha não seja iguais
                    ManageProducts.Verifyaccount.setText("Senha diferentes");
                    stop();
                }
            }
        });
        thread.start();
    }

    public static void main(String[] args) {

            // Se o objeto for uma data válida, faça a formatação
            Date data = new java.sql.Date(24/04/1998);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String dataFormatada = dateFormat.format(data);
            System.out.println("Data formatada: " + dataFormatada);
      

    }
}
