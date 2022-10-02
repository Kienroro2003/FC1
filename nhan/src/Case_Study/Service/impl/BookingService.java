package Case_Study.Service.impl;

import Case_Study.Repository.IBookingRepository;
import Case_Study.Repository.impl.BookingRepository;
import Case_Study.Service.IBookingService;
import Case_Study.Service.ICustomerService;
import Case_Study.Service.IFacilityService;
import Case_Study.models.Booking;
import Case_Study.models.Customer;

import java.util.*;

public class BookingService implements IBookingService {
    IBookingRepository iBookingRepository=new BookingRepository();
    IFacilityService facilityService = new FacilityService();
    ICustomerService customerService = new CustomerService();
    Scanner scanner=new Scanner(System.in);

    @Override
    public void addBooking() {
        Booking booking=this.infoBooking();
        iBookingRepository.addBooking(booking);
    }

    @Override
    public void displayBooking() {
        Set<Booking> bookingTreeSet= iBookingRepository.findAll();
        for (Booking booking:bookingTreeSet){
            System.out.println(booking);
        }
    }

    public Booking infoBooking(){
        System.out.println("Nhap vao ma booking: ");
        String idBooking=scanner.nextLine();
        System.out.println("Nhap vao ngay bat dau: ");
        String dateStart=scanner.nextLine();
        System.out.println("Nhap vao ngay ket thuc: ");
        String dateEnd=scanner.nextLine();
        System.out.println("Danh sach khach hang");
        this.customerService.display();
        System.out.println("Chon ma khach hang: ");
        Customer customer = this.customerService.findById(Integer.parseInt(scanner.nextLine()));
        System.out.println("Nhap vao ten dich vu: ");
        String serviceName=scanner.nextLine();
        System.out.println("Nhap vao loai dich vu: ");
        String serviceType=scanner.nextLine();
        return null;
//        return new Booking(idBooking,dateStart,dateEnd,idCustomer,serviceName,serviceType);
    }



}
