package hu.bm.mobsoft.lab.costlog.model;

import java.util.Date;

public class Item {

    private String id;
    private Date date;
    private int cost;

    public Item() {
    }

    public Item(String id, Date date, int cost) {
        this.id = id;
        this.date = date;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
