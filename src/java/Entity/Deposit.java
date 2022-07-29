/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import javax.persistence.*;

/**
 *
 * @author divine
 */
@Entity
public class Deposit {
    @Id
    private String accountNu;
    private double amount;

    public String getAccountNu() {
        return accountNu;
    }

    public void setAccountNu(String accountNu) {
        this.accountNu = accountNu;
    }

    

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
   
    
}
