
package tn.esprit.spring.service;

 
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.DEFAULT)
public class ContratServiceImplTest {

		@Autowired
		IContratService cs; 
		int i;


		@Test
		public void testRetrieveAllcontrats() {
			List<Contrat> listcontrat = cs.retrieveAllcontrat(); 
			i=listcontrat.size();
			Assert.assertEquals(i, listcontrat.size());
		} 
		
		@Test
		public void testAddcontrat() throws ParseException {
			Contrat c = new Contrat(1,"31/10/2021","CDI", 6300); 
			Contrat contratAdded = cs.addcontrat(c); 
			Assert.assertEquals(c.getDatex(), contratAdded.getDatex());
		}
	 
		@Test
		public void testModifyContrat() throws ParseException   {
			Contrat c = new Contrat(3,"31/10/2021","CDI", 6300); 
			Contrat contratUpdated  = cs.updatecontrat(c);
			Assert.assertEquals(c.getDatex(), contratUpdated.getDatex());
		}
	
		@Test
		public void testRetrieveContrat() {
			Contrat contratRetrieved = cs.retreivecontrat("19"); 
			Assert.assertEquals(19, contratRetrieved.getId());
		}
		
		@Test
		public void testDeletecontrat() {
		cs.deletecontrat("3");
			Assert.assertNull(cs.retreivecontrat("1"));
		
		}
 
}





