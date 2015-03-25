package project.android.imac.diabon.alimentation;

import java.io.Serializable;

/**
 * Created by Brice on 12/03/2015.
 */
public class Alimentation implements Serializable {

    private String id;
    private String name;
    private Integer weight;
    private Float glucide;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Float getGlucide() {
        return glucide;
    }

    public void setGlucide(Float glucide) {
        this.glucide = glucide;
    }

}