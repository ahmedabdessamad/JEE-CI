package tn.esprit.spring;
import static org.junit.Assert.*;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.controller.ControllerEmployeImpl;
import tn.esprit.spring.controller.ControllerEntrepriseImpl;
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;





@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployerTest {
	
	
	
private static final Logger l = LogManager.getLogger(EmployerTest.class);
	
	@Autowired
	ControllerEmployeImpl EmployeController;	
	
	@Autowired
	ControllerEntrepriseImpl EntrepriseController ;
	
	
	
	@Test
	public void test() throws ParseException {
	
		try {	
	
	Employe Aymen = new Employe ("Aymen"	,"Ouali","Aymen.Ouali@siiconsulting.tn",true,Role.INGENIEUR);
	Employe Bochra = new Employe ("Bochra","Bouzid","Bochra.Bouzid@siiconsulting.tn",true,Role.CHEF_DEPARTEMENT);
	
	EmployeController.ajouterEmploye(Aymen);
	EmployeController.ajouterEmploye(Bochra);
	
	int AymenId = EmployeController.ajouterEmploye(Aymen);
	int BochraId = EmployeController.ajouterEmploye(Bochra);

	
	EntrepriseController.affecterDepartementAEntreprise(1,1);
	
		
	l.info(EmployeController.getEmployePrenomById(AymenId));
	l.info(EmployeController.getEmployePrenomById(BochraId));
	l.info(EmployeController.getAllEmployes());
	l.debug("Le code s'exécute correctement");
		}
	catch (Exception e) { l.error("Erreur dans l'ajout ou dans le recupération du données : " + e); }
		
}
}
