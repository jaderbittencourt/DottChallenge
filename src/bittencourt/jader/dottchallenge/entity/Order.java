package bittencourt.jader.dottchallenge.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String customerName;
    private String contact;
    private String shippingAddress;
    private BigDecimal grandTotal;
    private LocalDateTime placedOrderDate;
    private List<Item> items;

    public Order(String customerName, String contact, String shippingAddress, BigDecimal grandTotal, LocalDateTime placedOrderDate, List<Item> items) {
        this.customerName = customerName;
        this.contact = contact;
        this.shippingAddress = shippingAddress;
        this.grandTotal = grandTotal;
        this.placedOrderDate = placedOrderDate;
        this.items = items;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }

    public LocalDateTime getPlacedOrderDate() {
        return placedOrderDate;
    }

    public void setPlacedOrderDate(LocalDateTime placedOrderDate) {
        this.placedOrderDate = placedOrderDate;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
