package com.example.cz.lianxiyuekao.eventbus;

/**
 * Created by CZ on 2018/1/12.
 */

public class UserEvent {
    private int pid;

    public UserEvent(int pid) {
        this.pid = pid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "UserEvent{" +
                "pid=" + pid +
                '}';
    }
}
