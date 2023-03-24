package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if(!controlAcheterProduit.verifierIdentite(nomAcheteur)) {
			System.out.println("Je suis désolé" + nomAcheteur + "mais il\r\n"
					+ "faut être un habitant de notre\r\n"
					+ "village pour commercer ici");
		}
		else {
			String produit = null;
			
			while(produit==null) 
				produit=Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
			Gaulois gaulois[] = controlAcheterProduit.rechercheVendeursEtals(produit);
			if(gaulois==null) {
				System.out.println("Désolé, personne\r\n"
						+ "ne vend ce produit au marché.");
			}
			else {
				int choix= 0;
				int quantiteDemande=-1;
				String question = "";
				question.concat("Chez quel commerçant voulez-vous \n"+
						"acheter des "+produit + " ?");
				for(int i=0;i<gaulois.length;i++) {
					question.concat(i + " - "+ gaulois[i].getNom()+"\n");
				}
				System.out.println(question);
				while(choix==0 || choix>gaulois.length)
						choix=Clavier.entrerEntier(question);
				String nomVendeur = gaulois[choix].getNom();
				System.out.println( nomAcheteur+"se déplace jusqu'à l'étal\r\n"
						+ "du vendeur"+ nomVendeur  +"\n"
						+ "Bonjour"+ nomAcheteur);
				while(quantiteDemande<0) {
					quantiteDemande=Clavier.entrerEntier("Combien de "+ produit+ " voulez-vous\r\n"
							+ "acheter ?");
				}
				int quantiteAchete=controlAcheterProduit.acheterProduit(gaulois[choix], quantiteDemande);
				
				if(quantiteAchete==0) {
					System.out.println( nomAcheteur+" veut acheter "+quantiteDemande +"\r\n"
							+ produit +", malheureusement il n’y\r\n"
							+ "en a plus !");
				}else if(quantiteDemande>quantiteAchete) {
					System.out.println( nomAcheteur+" veut acheter "+quantiteDemande+" "+ produit+ ",\r\n"
							+ "malheureusement"+ nomVendeur +"n’en a\r\n"
							+ "plus que "+ quantiteAchete  +". "+ nomAcheteur +"achète\r\n"
							+ "tout le stock de "+ nomVendeur +".");
				}else {
					System.out.println(nomAcheteur +" achète "+quantiteAchete +" "+produit+"à "+nomAcheteur+" .");
				}
			}
		}
	}
}
