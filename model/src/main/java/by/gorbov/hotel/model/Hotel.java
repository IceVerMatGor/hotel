package by.gorbov.hotel.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel extends AbstractEntity {

    @OneToMany(mappedBy = "hotel")
    private List<Employee> employees;

    @ManyToMany(mappedBy = "hotels")
    private List<Client> clients;

    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms;

    @OneToOne
    private Admin admin;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
}
