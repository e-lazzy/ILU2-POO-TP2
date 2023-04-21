package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.*;

class ControlAcheterProduitTest {
	Village village;
	ControlVerifierIdentite controlIdentite;
	ControlTrouverEtalVendeur controlEtalVendeur;
	ControlAcheterProduit control;
	Gaulois gauloA;
	Gaulois gauloB;
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village= new Village("village", 10, 5);
		village.setChef(new Chef("Tyranix", 5, village));
		gauloA = new Gaulois("Abrarourix",3);
		gauloB = new Gaulois("Bonmix",4);
		village.ajouterHabitant(gauloA);
		village.ajouterHabitant(gauloB);
		controlIdentite = new ControlVerifierIdentite(village);
		controlEtalVendeur= new ControlTrouverEtalVendeur(village);
		control =new ControlAcheterProduit(controlIdentite, controlEtalVendeur, village);
	}
	
	
	@Test
	void testAcheterProduit() {
		ControlPrendreEtal controlPEtal =new ControlPrendreEtal(controlIdentite, village);
		controlPEtal.prendreEtal("Abrarourix", "Diginité", 3);
		control.acheterProduit(gauloA, 2);
		assertEquals(village.donnerEtatMarche(),"[Abrarourix, 1, Diginité]");
	}
	@AfterEach
	public void finSituation() {
		System.out.println("...FIN");
	}
}
