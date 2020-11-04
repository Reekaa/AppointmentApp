package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import model.Appointment;
//import java.io.*;

public class SQLDAO extends DAO {
    static private String userName = "root";
    static private String password = "";		
    static private String url = "jdbc:mysql://localhost:3306/appointments";
    static private Connection connection = null;
    static private Statement stmt = null;
    static private ResultSet rs = null;  
    
    public SQLDAO(String appointmentDate) {
        super(appointmentDate);
        try {
            connection = DriverManager.getConnection(url, userName, password);
            stmt = connection.createStatement();
            System.out.println("Connected to database");            
        } catch (SQLException ex) { System.out.println(ex);} 
    }    
    
    @Override
    public List<Appointment> getAppointments() {
        List<Appointment> appointmentsList = new ArrayList<>();
        try {
            String queryString = "CALL GETAPPOINTMENTS(" + appointmentDate + ")";            
            rs = stmt.executeQuery(queryString);
            
            while (rs.next()) {
                String customerName = rs.getString("CUSTOMERNAME");
                LocalTime appointmentTime = rs.getTime("APPOINTMENTTIME").toLocalTime();   
                int appointmentLength = rs.getInt("APPOINTMENTLENGTH");
                Appointment appointment = new Appointment(customerName, appointmentTime, appointmentLength);              
                appointmentsList.add(appointment);
            }
        } catch (SQLException ex) {}            
        return appointmentsList; 
    }
    
    @Override
    public void addAppointment(Appointment appointment) {
        String queryString = "CALL ADDAPPOINTMENT('";
        queryString += appointment.getCustomerName() + "', '"; 
        queryString += this.appointmentDate + "', '";
        queryString += appointment.getAppointmentTime() + "', ";          
        queryString += appointment.getAppointmentLength() + ")";
        System.out.println(queryString);
        try {
            stmt.executeUpdate(queryString);
        } catch (SQLException ex) {}           
    }
    
    @Override
    public void deleteAppointment(Appointment appointment) {
        String queryString = "DELETE FROM Appointment WHERE AppointmentDate = " + this.appointmentDate + " AND CustomerName = " + appointment.getCustomerName() + ";";
        System.out.println(queryString);
        try {
            stmt.executeUpdate(queryString);
        } catch (SQLException ex) {}   
    }
}
