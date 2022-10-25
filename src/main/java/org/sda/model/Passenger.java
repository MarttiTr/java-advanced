package org.sda.model;

public class Passenger extends Person {
    private String paymentType;
    private String destinationAddress;

    public Passenger () {

    }

    public Passenger(String paymentType, String destinationAddress) {
        this.paymentType = paymentType;
        this.destinationAddress = destinationAddress;
    }

    public Passenger(Long id, String address, String paymentType, String destinationAddress) {
        super(id, address);
        this.paymentType = paymentType;
        this.destinationAddress = destinationAddress;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    @Override
    public String getEmail() {
        return "sda@gmail.com";
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "paymentType='" + paymentType + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                '}';
    }

    public String getAddresses() {
        return "Source address: " + super.getAddress() + ", Destination address: " + getDestinationAddress();

    }
}