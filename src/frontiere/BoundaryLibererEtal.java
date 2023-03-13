package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu=controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.print("Mais vous n'êtes pas inscrit sur notre march aujourd'hui !");
			
		}else {
			String[] donneesEtal=controlLibererEtal.libererEtal(nomVendeur);
			if(donneesEtal[0]=="1") {
				System.out.print("Vous avez vendu"+ donneesEtal[2] + "sur"
						+ "\n" + donneesEtal[3] + " " + donneesEtal[4] + ".");
				System.out.print("En revoir" + nomVendeur +", passez une bonne journée");
			}
		}
	}

}
