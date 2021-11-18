package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

	@Autowired
	DepartmentRepository departmentrepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	
	@Override
	public List<Departement> retrieveAlldepartment() { 
		List<Departement> departements = null; 
		try {
	
			l.info("In retrieveAllDepartments() : ");
			departements = (List<Departement>) departmentrepository.findAll();  
			for (Departement d : departements) {
				l.debug("department +++ : " + d);
			} 
			l.info("Out of retrieveAlldepartment() : ");
		}catch (Exception d) {
			l.error("Error in retrieveAlldepartment() : " + d);
		}

		return departements;
	}


	@Override
	public Departement addDepartement(Departement d) {
		return departmentrepository.save(d); 
	}

	@Override 
	public Departement updateDepartement(Departement d) { 
		return departmentrepository.save(d);
	}

	@Override
	public void deleteDepartement(String id) {
		departmentrepository.deleteById(Integer.parseInt(id));
	}

	@Override
	public Departement retreieveDepartement(String id) {
		l.info("in  retrieveDepartement id = " + id);

		Departement d =  departmentrepository.findById(Integer.parseInt(id)).orElse(null); 

		l.info("department returned : " + d);
		return d; 
	}


	

}
