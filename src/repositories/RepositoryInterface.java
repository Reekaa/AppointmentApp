package repositories;

import java.util.List;
import model.Appointment;

public interface RepositoryInterface {
    List<Appointment> getItems();
    void addItem(Appointment appointment);
    void deleteItem(Appointment appointment);
}
