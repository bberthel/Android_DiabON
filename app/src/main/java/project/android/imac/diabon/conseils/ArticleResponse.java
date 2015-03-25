package project.android.imac.diabon.conseils;

import project.android.imac.diabon.alimentation.Alimentation;

/**
 * Created by Brice on 25/03/2015.
 */
public class ArticleResponse {
    private String balance;
    private Article article;


    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
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
