package bittencourt.jader.dottchallenge.entity;

import java.math.BigDecimal;

public class Item {

    private BigDecimal cost;
    private BigDecimal shippingFee;
    private BigDecimal taxAmount;
    private Product product;

    public Item(BigDecimal shippingFee, BigDecimal taxAmount, Product product) {
        this.shippingFee = shippingFee;
        this.taxAmount = taxAmount;
        this.product = product;
        this.cost = BigDecimal.ZERO.add(product.getPrice()).add(shippingFee).add(taxAmount);
    }

    public BigDecimal getCost() {
        return cost;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Item{" +
                "cost=" + cost +
                ", shippingFee=" + shippingFee +
                ", taxAmount=" + taxAmount +
                ", product=" + product +
                '}';
    }
}
