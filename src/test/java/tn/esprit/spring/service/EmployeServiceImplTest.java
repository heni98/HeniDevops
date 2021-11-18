
package tn.esprit.spring.service;

 
import java.text.ParseException;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {

		@Autowired
		IEmployeService es; 
		int i;
		@Test
		public void testRetrieveAllEmploye() {
			List<Employe> listEmployes = es.retrieveAllEmploye(); 
			// if there are 7 employes in DB : 
			i=listEmployes.size();
			Assert.assertEquals(i, listEmployes.size());
		}
		
		
		@Test
		public void testAddEmploye() throws ParseException {
			Employe e = new Employe("tt", "balti", "baltihamza6@gmail.com", "12345", true, Role.ADMINISTRATEUR); 
			Employe employeAdded = es.addEmploye(e); 
			Assert.assertEquals(e.getNom(), employeAdded.getNom());
		}
	 
		/*@Test
		public void testModifyEmploye() throws ParseException   {
			Employe e = new Employe(18,"uu", "jamil", "baltihamza6@gmail.com", "12345", true, Role.ADMINISTRATEUR); 
			Employe employeUpdated  = es.updateEmploye(e);
			Assert.assertEquals(e.getNom(), employeUpdated.getNom());
		}
	
		@Test
		public void testRetrieveUser() {
			Employe employeRetrieved = es.retrieveEmploye("9"); 
			Assert.assertEquals(9, employeRetrieved.getId());
		}
		
		@Test
		public void testDeleteUser() {
			es.deleteEmploye("17");
			Assert.assertNull(es.retrieveEmploye("17"));
		
		}
		// 5 tests unitaires  
*/
}





