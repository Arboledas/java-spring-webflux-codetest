package com.example.demo.model;

import java.time.OffsetDateTime;

public class Customer {

    private Integer id;
    private String name;
    private OffsetDateTime duetime;
    private OffsetDateTime jointime;

    public Customer() {}

    public Customer(Integer id, String name, OffsetDateTime duetime, OffsetDateTime jointime) {
        this.id = id;
        this.name = name;
        this.duetime = duetime;
        this.jointime = jointime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OffsetDateTime getDuetime() {
        return duetime;
    }

    public void setDuetime(OffsetDateTime duetime) {
        this.duetime = duetime;
    }

    public OffsetDateTime getJointime() {
        return jointime;
    }

    public void setJointime(OffsetDateTime jointime) {
        this.jointime = jointime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duetime=" + duetime +
                ", jointime=" + jointime +
                '}';
    }

}
