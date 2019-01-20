package io.zipcoder.persistenceapp.model;

public class Home {
    private Integer id;
    private String address, homeNumber;

    public Home(Integer id, String address, String homeNumber) {
        this.id = id;
        this.address = address;
        this.homeNumber = homeNumber;
    }

    public Home() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }
}
