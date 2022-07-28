package com.example.demo12.model;

public class Book {
    private int id;
    private String nameBook;
    private String describeBook;
    private  String image;
    private String statusBook;
    private Category category;
    private PublishingCompany publishingCompany;
    private Location location;

    public Book(String nameBook, String describeBook, String image, String statusBook, Category category, PublishingCompany publishingCompany, Location location) {
        this.nameBook = nameBook;
        this.describeBook = describeBook;
        this.image = image;
        this.statusBook = statusBook;
        this.category = category;
        this.publishingCompany = publishingCompany;
        this.location = location;
    }

    public Book() {
    }

    public Book(int id, String nameBook, String describeBook, String image, String statusBook, Category category, PublishingCompany publishingCompany, Location location) {
        this.id = id;
        this.nameBook = nameBook;
        this.describeBook = describeBook;
        this.image = image;
        this.statusBook = statusBook;
        this.category = category;
        this.publishingCompany = publishingCompany;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getDescribeBook() {
        return describeBook;
    }

    public void setDescribeBook(String describeBook) {
        this.describeBook = describeBook;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatusBook() {
        return statusBook;
    }

    public void setStatusBook(String statusBook) {
        this.statusBook = statusBook;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PublishingCompany getPublishingCompany() {
        return publishingCompany;
    }

    public void setPublishingCompany(PublishingCompany publishingCompany) {
        this.publishingCompany = publishingCompany;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", nameBook='" + nameBook + '\'' +
                ", describeBook='" + describeBook + '\'' +
                ", image='" + image + '\'' +
                ", statusBook='" + statusBook + '\'' +
                ", category=" + category +
                ", publishingCompany=" + publishingCompany +
                ", location=" + location +
                '}';
    }
}
