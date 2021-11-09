package by.gorbov.hotel.model;


import javax.persistence.*;

@Entity
public class Employee extends AbstractEntity{

    @ManyToOne
    private Hotel hotel;
    private String name;
    private String position;
    private Integer salary;
}
