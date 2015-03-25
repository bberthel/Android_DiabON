package project.android.imac.diabon.alimentation;

import java.io.Serializable;

/**
 * Created by Brice on 12/03/2015.
 */
public class Alimentation implements Serializable {
    protected String id;
    protected String name;

    public Alimentation(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Alimentation(int id, String name) {
        this(Integer.toString(id), name);
    }

    public Alimentation(){

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
