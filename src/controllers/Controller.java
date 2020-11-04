package controllers;

import model.Appointment;
import helpers.InputHelper;
import java.time.LocalTime;
import java.util.List;
import repositories.Repository;

public class Controller {
    
    public Controller() {
    }    
    
    public void run() {
        boolean finished = false;
        InputHelper inputHelper = new InputHelper();
        do {        
            System.out.print("\nA. List Appointments");
            System.out.print("\tB. Add Appointment");     
            System.out.print("\tC. Delete Appointment");   
            System.out.print("\tQ. Quit\n");              
            char choice = inputHelper.readCharacter("Enter choice", "ABCQ");    
            switch (choice) {
                case 'A': 
                    listAppointments();
                    break;
                case 'B':  
                    addAppointment();
                    break;            
                case 'C':  
                    deleteAppointment();
                    break;       
                case 'Q': 
                    finished = true;
            }
        } while (!finished);
    } 
    
    private void listAppointments() {
        System.out.println("List Appointments");
        System.out.println("=================");   
        InputHelper inputHelper = new InputHelper();
        String appointmentDate = inputHelper.readDateString("Enter Appointment Date", "YYYYMMDD");       
        Repository repository = new Repository(appointmentDate);        
        List<Appointment> appointmentsList = repository.getItems();
        if (appointmentsList != null)
            System.out.println(appointmentsList);
        else
            System.out.println("File Not Found");
    }     
   
    private void addAppointment() {
        System.out.println("Add Appointment");
        System.out.println("===============");          
        InputHelper inputHelper = new InputHelper();
        String appointmentDate = inputHelper.readDateString("Enter Appointment Date", "YYYYMMDD");       
        Repository repository = new Repository(appointmentDate);         
        String customerName = inputHelper.readString("Enter Customer Name");
        LocalTime appointmentTime = LocalTime.parse(inputHelper.readString("Enter Appointment Time (HH:mm)"));
        int appointmentLength = inputHelper.readInt("Enter Appointment Length", 120, 15);   
        Appointment newAppointment = new Appointment(customerName, appointmentTime, appointmentLength);               
        repository.addItem(newAppointment);
    }   
    
    private void deleteAppointment() {
        System.out.println("Delete Appointment");
        System.out.println("===============");          
        InputHelper inputHelper = new InputHelper();
        String appointmentDate = inputHelper.readDateString("Enter Appointment Date", "YYYYMMDD");       
        Repository repository = new Repository(appointmentDate);         
        String customerName = inputHelper.readString("Enter Customer Name");
//        LocalTime appointmentTime = LocalTime.parse(inputHelper.readString("Enter Appointment Time (HH:mm)"));
//        int appointmentLength = inputHelper.readInt("Enter Appointment Length", 120, 15);   
        Appointment appointmentToDelete = new Appointment(customerName);               
        repository.deleteItem(appointmentToDelete);
    }   
}
