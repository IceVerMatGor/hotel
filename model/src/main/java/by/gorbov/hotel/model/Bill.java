package by.gorbov.hotel.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Bill extends AbstractEntity {
    @ManyToOne
    private Client client;

    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
