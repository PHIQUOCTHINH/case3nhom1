package com.example.demo12.model;

public class PublishingCompany {
    private int id;
    private String namePublishing;

    public PublishingCompany() {
    }

    public PublishingCompany(String namePublishing) {
        this.namePublishing = namePublishing;
    }

    public PublishingCompany(int id, String namePublishing) {
        this.id = id;
        this.namePublishing = namePublishing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamePublishing() {
        return namePublishing;
    }

    public void setNamePublishing(String namePublishing) {
        this.namePublishing = namePublishing;
    }

    @Override
    public String toString() {
        return "PublishingCompany{" +
                "id=" + id +
                ", namePublishing='" + namePublishing + '\'' +
                '}';
    }
}
