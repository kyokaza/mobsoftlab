package hu.bm.mobsoft.lab.costlog.model;

import com.orm.dsl.Table;

import java.util.Date;

@Table
public class Item {
    private Long id;

    private String serverId;
    private Date date;
    private int cost;

    public Item() {
    }

    public Item(Long id, String serverId, Date date, int cost) {
        this.id = id;
        this.serverId = serverId;
        this.date = date;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
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
