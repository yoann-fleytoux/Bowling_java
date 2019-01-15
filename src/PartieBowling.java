import java.util.*;


public class PartieBowling {

	private Hashtable<Integer,AffichBowlingGame> parti;
	
	public PartieBowling(int i){
		this.parti=new Hashtable<Integer,AffichBowlingGame>(i);
		for(int x=1;x<=i;x++){
			this.creerJoueur(x);
		}
	}
	public void creerJoueur(int i){
		if (this.parti.containsKey(i)==false)
		{
			AffichBowlingGame c= new AffichBowlingGame();
			this.parti.put(i, c);
		}
	}
	/*public void setScore(int i,int[] j){
			if (this.parti.containsKey(i))
			{
				this.parti.get(i).ajouterScore(j);
			}
	}*/
	public AffichBowlingGame getJoueur(int i) throws JoueurNonExistantException{
		if (this.parti.containsKey(i)==false)
		{
			throw new JoueurNonExistantException();
		}
		return(this.parti.get(i));
	}
	
	public void afficherScores(){
		Enumeration<AffichBowlingGame> e;
		e =this.parti.elements();
		int i=1;
		while (e.hasMoreElements()) {
			System.out.println("Score du Joueur "+i+"\n");
		e.nextElement().afficherScoreJoueur();
		System.out.println("\n");
		i++;
		}
	}
	/*public void afficherClassement(){
		int[][] classement=new int[this.parti.size()][1];
		Enumeration<AffichBowlingGame> e;
		e =this.parti.elements();
		int i=0;
		while (e.hasMoreElements()) {
			classement[i][0]=e.nextElement().ValeurGame();
			i++;
		}
		Arrays.sort(classement);
		for(int x=0;x<=this.parti.size();x++){
			System.out.println(classement[x]);
		}
	}*/
}