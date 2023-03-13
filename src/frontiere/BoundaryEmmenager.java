package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					StringBuilder dialogue = new StringBuilder();
					dialogue.append("Bienvenu villageois "+ nomVisiteur + "\n");
					dialogue.append("Quelle est votre force ?\n");
					int force= Clavier.entrerEntier(dialogue.toString());
					controlEmmenager.ajouterGaulois(nomVisiteur, force);
					
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder dialogue = new StringBuilder();
		dialogue.append("Bienvenu druide "+ nomVisiteur + "\n");
		dialogue.append("Quelle est votre force ?\n");
		int force= Clavier.entrerEntier(dialogue.toString());
		int effetPotionMin;
		int effetPotionMax;
		do{
			StringBuilder dialogue1 = new StringBuilder();
			dialogue1.append("Quelle est la force de potion la plus faible que vous produisez ?\n");
			effetPotionMin= Clavier.entrerEntier(dialogue1.toString());
			StringBuilder dialogue2 = new StringBuilder();
			dialogue2.append("Quelle est la force de potion la plus forte que vous produisez ?\n");
			effetPotionMax= Clavier.entrerEntier(dialogue2.toString());
			if(effetPotionMin>effetPotionMax) {
				System.out.println("Attrntion Druide, vous vous êtes trompé entre le minimum et le maximum");
			}
		
		}while(effetPotionMin>effetPotionMax);
		controlEmmenager.ajouterDuide(nomVisiteur, force, effetPotionMin, effetPotionMax);
	}
}
