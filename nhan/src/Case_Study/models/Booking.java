package Case_Study.models;

import java.io.Serializable;
import java.util.Objects;

public class Booking implements Serializable,Comparable<Booking> {
    private String idBooking;//String??
    private String dateStart;// String??
    private String dateEnd;// String??
    private Customer customer;
    private String serviceName;
    private String serviceType;
    private Facility facility;

    public Booking() {
    }

    public Booking(String idBooking, String dateStart, String dateEnd, Customer customer, String serviceName, String serviceType, Facility facility) {
        this.idBooking = idBooking;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.customer = customer;
        this.serviceName = serviceName;
        this.serviceType = serviceType;
        this.facility = facility;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public int compareTo(Booking o) {
        return this.dateStart.compareTo(o.dateStart);//String so sánh với String (vd: 23/5/2022 compareTo với 19/5/2021)
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(dateStart, booking.dateStart) && Objects.equals(dateEnd, booking.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateStart, dateEnd);
    }
}

