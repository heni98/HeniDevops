package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employeRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);

	
	@Override
	public List<Employe> retrieveAllEmploye() { 
		List<Employe> employes = null; 
		try {
	
			l.info("In retrieveAllUsers() : ");
			employes = (List<Employe>) employeRepository.findAll();  
			for (Employe e : employes) {
				l.debug("employe +++ : " + e);
			} 
			l.info("Out of retrieveAllEmploye() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEmploye() : " + e);
		}

		return employes;
	}


	@Override
	public Employe addEmploye(Employe e) {
		return employeRepository.save(e); 
	}

	@Override 
	public Employe updateEmploye(Employe e) { 
		return employeRepository.save(e);
	}

	@Override
	public void deleteEmploye(String id) {
		employeRepository.deleteById(Integer.parseInt(id));
	}

	@Override
	public Employe retrieveEmploye(String id) {
		l.info("in  retrieveUser id = " + id);

		Employe e =  employeRepository.findById(Integer.parseInt(id)).orElse(null); 

		l.info("employe returned : " + e);
		return e; 
	}


	

}
