/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Beans.EmployeesBeans;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eduar
 */
interface EmployeeInterface {
     public boolean successfullyRegistered = false;
     public void RegisterEmployees(EmployeesBeans Register) throws Exception;
    public void Saveemployee(EmployeesBeans Addemployee) throws Exception;
    public void Employeelist() throws Exception;
}
