package project.android.imac.diabon.conseils;

import java.io.Serializable;

/**
 * Created by Brice on 25/03/2015.
 */
public class Article implements Serializable {
    protected String id;
    protected String name;

    public Article(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Article(int id, String name) {
        this(Integer.toString(id), name);
    }

    public Article(){

    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    @Override
    public String toString() { return name; }

}
