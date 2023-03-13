package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if(!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.print("Je suis desolé "+ nomVendeur +", mais il fait être un\n"
					+ " habitant de notre village pour commercer ici.\n");
		}else {
			System.out.print("Bonjour "+ nomVendeur +", je vais \n"
					+ "regarder si je peux vous trouver une etal.\n");
			if(!controlPrendreEtal.resteEtals()) {
				System.out.println("Désoléé " + nomVendeur + "je n'ai plus d'etal qui ne soit pas deja occipé");
				
			}else {
				installerVendeur(nomVendeur);
			}
			
		}
		
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait, il me reste un etal pour vous\n\n"
				+ "Il me faudrait quelques renseignements :\n ");
		String produit=Clavier.entrerChaine("Quel produit souhaites vous vendre ?\n");
		int nbProduit=Clavier.entrerEntier("Combien souhaitez-vous en vendre ?\n");
		int indetal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		System.out.println("Le vedeur "+ nomVendeur +" s'est installé à l'étal n°"+ indetal+1 +" .");
	}
}
