package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entities.Departement;

public interface IDepartmentService {

	List<Departement> retrieveAlldepartment(); 
	Departement addDepartement(Departement d);
	void deleteDepartement(String id);
	Departement updateDepartement(Departement d);
	Departement retreieveDepartement(String id);
}
