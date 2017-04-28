package hu.bm.mobsoft.lab.costlog.interactor.login.events;

import hu.bm.mobsoft.lab.costlog.model.User;

public class StartLoginEvent {
    private int code;
    private User user;
    private Throwable throwable;

    public StartLoginEvent() {
        this.code = 200;
        this.user = new User("Alma", "Alma");
    }

    public StartLoginEvent(int code, User user, Throwable throwable) {
        this.code = 200;
        this.user = new User("Alma", "Alma");
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
