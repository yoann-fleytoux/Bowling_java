

public class Main {
	public static void main (String[] argv) {
		System.out.println("Simulation partie à deux joueurs"+"\n");
		int nbjoueurs = 2;
		int nbtours=1;
		boolean partieencour=true;
		int i=1;
		PartieBowling simu= new PartieBowling(nbjoueurs);
		while(partieencour){
			System.out.println("Tour "+nbtours+" du Joueur"+i+"\n");
			try {
				simu.getJoueur(i).tourDunJoueur();
			} catch (JoueurNonExistantException | ScorePasPossibleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i==nbjoueurs){
				i=1;
				nbtours++;
			}else{
				i++;
			}
			if(nbtours>10){
				partieencour=false;
			}
		}
		simu.afficherScores();
	}
}
