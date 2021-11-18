package tn.esprit.spring.services;

import java.util.List;
import tn.esprit.spring.entities.Contrat;

public interface IContratService {

	List<Contrat> retrieveAllcontrat(); 
	Contrat addcontrat(Contrat c);
	void deletecontrat(String id);
	Contrat updatecontrat(Contrat c);
	Contrat retreivecontrat(String id);
}
