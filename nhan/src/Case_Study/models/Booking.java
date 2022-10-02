package Case_Study.models;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Booking implements Serializable,Comparable<Booking> {
    private String idBooking;//String??
    private Date dateStart;// String??
    private Date dateEnd;// String??
    private Customer customer;
    private String serviceName;
    private String serviceType;
    private Facility facility;

    public Booking() {
    }

    public Booking(String idBooking, Date dateStart, Date dateEnd, Customer customer, String serviceName, String serviceType, Facility facility) {
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(Date dateEnd) {
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
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", customer=" + customer +
                ", serviceName='" + serviceName + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", facility=" + facility +
                '}';
    }
}

