package daos;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;

public class TestDAO extends DAO {
    private List<Appointment> appointmentsList20201001;
    private List<Appointment> appointmentsList20201002;
    private List<Appointment> appointmentsList20201003;    

    public TestDAO(String appointmentDate) {
        super(appointmentDate);
        
        this.appointmentsList20201001 = new ArrayList<>();
        Appointment appointment;
        appointment = new Appointment("Lynn Kelly",LocalTime.parse("10:00"),30);
        this.appointmentsList20201001.add(appointment);
        appointment = new Appointment("Ciara O'Donnell",LocalTime.parse("11:15"),45);
        this.appointmentsList20201001.add(appointment);
        appointment = new Appointment("Louise Kelly",LocalTime.parse("13:15"),60);
        this.appointmentsList20201001.add(appointment);
        
        this.appointmentsList20201002 = new ArrayList<>();
        appointment = new Appointment("Martin Gallacher",LocalTime.parse("09:20"),15);
        this.appointmentsList20201002.add(appointment);
        appointment = new Appointment("Stephen Pickering",LocalTime.parse("10:15"),45);
        this.appointmentsList20201002.add(appointment);
        appointment = new Appointment("Stephen Gaddis",LocalTime.parse("11:30"),60);
        this.appointmentsList20201002.add(appointment);        
        
        this.appointmentsList20201003 = new ArrayList<>();
        appointment = new Appointment("Joe Kelly",LocalTime.parse("09:00"),30);
        this.appointmentsList20201003.add(appointment);
        appointment = new Appointment("Gene Kelly",LocalTime.parse("10:15"),15);
        this.appointmentsList20201003.add(appointment);         
    }
    
    @Override
    public List<Appointment> getAppointments() {
        List<Appointment> appointmentsDateList = new ArrayList<>();
        switch(appointmentDate) {
            case "20201001":
                return appointmentsList20201001;
            case "20201002":
                return appointmentsList20201002;
            case "20201003":
                return appointmentsList20201003;
            default:
                return appointmentsDateList;  
        }        
    }
    
    @Override
    public void addAppointment(Appointment appointment) {
        switch(appointmentDate) {
            case "20201001":
                appointmentsList20201001.add(appointment);
                System.out.println(appointmentsList20201001);
                break;
            case "20201002":
                appointmentsList20201002.add(appointment);
                System.out.println(appointmentsList20201002);                
                break;
            case "20201003":
                appointmentsList20201003.add(appointment);
                System.out.println(appointmentsList20201003);                
                break;                
        }
    }
    
    @Override
    public void deleteAppointment(Appointment appointment) {
        switch(appointmentDate) {
            case "20201001":
                appointmentsList20201001.remove(appointment);
                System.out.println(appointmentsList20201001);
                break;
            case "20201002":
                appointmentsList20201002.remove(appointment);
                System.out.println(appointmentsList20201002);                
                break;
            case "20201003":
                appointmentsList20201003.remove(appointment);
                System.out.println(appointmentsList20201003);                
                break;                
        }
    }
}
