package daos;

import java.util.List;

import model.Appointment;

public abstract class DAO {	
    protected String appointmentDate;
    
    DAO() {
        this.appointmentDate="Unknown";
    }
    
    DAO(String date) {
        this.appointmentDate = date;
    }
    
    public abstract List<Appointment> getAppointments();
    public abstract void addAppointment(Appointment appointment);
//    public abstract void updateAppointment(Appointment appointment);
    public abstract void deleteAppointment(Appointment appointment);
}