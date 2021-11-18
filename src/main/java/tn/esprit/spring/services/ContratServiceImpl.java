package tn.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.repository.ContratRepository;

@Service
public class ContratServiceImpl implements IContratService {


	
	@Autowired
	ContratRepository contratrepository;

	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);

	
	@Override
	public List<Contrat> retrieveAllcontrat() { 
		List<Contrat> contrat = null; 
		try {
	
			l.info("In retrieveAllcontrat() : ");
			contrat = (List<Contrat>) contratrepository.findAll();  
			for (Contrat c : contrat) {
				l.debug("contrat +++ : " + c);
			} 
			l.info("Out of retrieveAllcontrat() : ");
		}catch (Exception c) {
			l.error("Error in retrieveAllcontrat() : " + c);
		}

		return contrat;
	}


	@Override
	public Contrat addcontrat(Contrat c) {
		return contratrepository.save(c); 
	}

	@Override 
	public Contrat updatecontrat(Contrat c) { 
		return contratrepository.save(c);
	}

	@Override
	public void deletecontrat(String id) {
		contratrepository.deleteById(Integer.parseInt(id));
	}

	@Override
	public Contrat retreivecontrat(String id) {
		l.info("in  retreivecontrat id = " + id);

		Contrat c =  contratrepository.findById(Integer.parseInt(id)).orElse(null); 

		l.info("contrat returned : " + c);
		return c; 
	}


	

}
