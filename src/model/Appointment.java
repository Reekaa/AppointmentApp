package model;

import java.io.Serializable;
import java.time.LocalTime;

public class Appointment implements Serializable {
    private String customerName;
    private LocalTime appointmentTime;
    private int appointmentLength;  
    
    public Appointment() {
        this.customerName = null;
        this.appointmentTime = null;
        this.appointmentLength = 0;        
    }
    
    public Appointment(String customerName, LocalTime appointmentTime, int appointmentLength) {
        this.customerName = customerName;
        this.appointmentTime = appointmentTime;
        this.appointmentLength = appointmentLength;       
    }  
    
    public Appointment(String customerName) {
        this.customerName = customerName;
        this.appointmentTime = null;
        this.appointmentLength = 0;  
    }  
    
    public String getCustomerName() {
        return this.customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalTime getAppointmentTime() {
        return this.appointmentTime;
    }
    
    public void setAppointmentTime(LocalTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }   
   
    public int getAppointmentLength() {
        return this.appointmentLength;
    }
    
    public void setAppointmentLength(int appointmentLength) {
        this.appointmentLength = appointmentLength;
    }
    
    @Override
    public String toString() {
        return "\nCustomer: " + this.customerName +
                " Time: " + this.appointmentTime +                
                " Length: " + Integer.toString(this.appointmentLength) + "\n";
    }
      
}
