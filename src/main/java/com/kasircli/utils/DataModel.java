package com.kasircli.utils;

public class DataModel {

    private int create;

    private String creater;

    private int update;

    private String updater;

    public DataModel() {
    }

    public DataModel(int create, String creater, int update, String updater) {
        this.create = create;
        this.creater = creater;
        this.update = update;
        this.updater = updater;
    }

    public int getCreate() {
        return create;
    }

    public void setCreate(int create) {
        this.create = create;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public int getUpdate() {
        return update;
    }

    public void setUpdate(int update) {
        this.update = update;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

}
