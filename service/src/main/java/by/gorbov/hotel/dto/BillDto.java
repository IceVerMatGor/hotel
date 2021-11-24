package by.gorbov.hotel.dto;

public class BillDto extends AbstractDto{
    private Long clientId;
    private Integer price;

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
