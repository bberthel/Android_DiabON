package project.android.imac.diabon.alimentation;

import java.util.List;

/**
 * Created by Brice on 24/03/2015.
 */
public class AlimentationResponse {
    private String balance;
    private Alimentation food;


    public Alimentation getAlimentation() {
        return food;
    }

    public void setAlimentation(Alimentation event) {
        this.food = food;
    }

    public String getBalance() {
        if(balance == null) {
            balance ="0";
        }
        if(balance != null && balance.equals("Empty") )
            balance = "0";

        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
