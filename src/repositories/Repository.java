package repositories;

import daos.DAO;
import daos.TestDAO;
import daos.SQLDAO;

import java.util.List;
import model.Appointment;


public class Repository implements RepositoryInterface {
    private DAO dao;
	
    public Repository(String appointmentDate) { 
//        dao = new TestDAO(appointmentDate);
    	dao = new SQLDAO(appointmentDate);
        //dao = new CSVDAO(appointmentDate);     
    	//dao = new XMLDAO(appointmentDate);          
    	//dao = new JSONDAO(appointmentDate);      
    	//dao = new ObjectDAO(appointmentDate);  
    }
    
    @Override
    public List<Appointment> getItems() {       	
        return dao.getAppointments();
    }   
    
    @Override
    public void addItem(Appointment appointment) {
        dao.addAppointment(appointment);
    } 
    
    @Override
    public void deleteItem(Appointment appointment) {
        dao.deleteAppointment(appointment);
    } 
    
}
