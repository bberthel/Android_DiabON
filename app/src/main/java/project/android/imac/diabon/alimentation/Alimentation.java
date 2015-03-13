package project.android.imac.diabon.alimentation;

import java.io.Serializable;

/**
 * Created by Brice on 12/03/2015.
 */
public class Alimentation implements Serializable {
    protected String id;
    protected String name;
    /*protected Integer weight;
    protected Float glucide;*/

    public Alimentation(String id, String name/*,Integer weight, Float glucide*/) {
        this.id = id;
        this.name = name;
        /*this.weight = weight;
        this.glucide = glucide;*/
    }

    public Alimentation(int id, String name/*,Integer weight, Float glucide*/) {
        this(Integer.toString(id), name/*, weight, glucide*/);
    }

    public Alimentation(){

    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    /*public Integer getWeight() { return weight; }

    public void setWeight(Integer weight) { this.weight = weight; }

    public Float getGlucide() { return glucide; }

    public void setGlucide(Float glucide) { this.glucide = glucide; }*/

    @Override
    public String toString() { return name; }

}
