package hu.bm.mobsoft.lab.costlog.interactor.item.events;

import java.util.List;

import hu.bm.mobsoft.lab.costlog.model.Item;

public class GetItemsEvent {
    private int code;
    private List<Item> items;
    private Throwable throwable;

    public GetItemsEvent() {
    }

    public GetItemsEvent(int code, List<Item> items, Throwable throwable) {
        this.code = code;
        this.items = items;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
