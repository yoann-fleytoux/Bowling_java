import java.io.*;
import java.util.*;
//netbeans

public class AffichBowlingGame {
	private int[][] frames;
	private ArrayList<Integer>  scores;
	
	public AffichBowlingGame(){
		this.frames= new int [10] [2];
		this.scores = new ArrayList<Integer>();
	}
	
	public AffichBowlingGame(int[] i) {
		// TODO Auto-generated constructor stub
		this.frames= new int [10] [2];
		this.scores = new ArrayList<Integer>();
		this.ajouterScore(i);
		
	}
	public void ajouterScore(int[] i){
		try{
			for(int x=0; x < i.length;x++){
				this.scores.add(i[x]);
			}    
			this.delimiterFrames();
		}catch( NbFrameException err){
			for(int x=0; x < i.length;x++){
				this.scores.remove(this.scores.lastIndexOf(i[x]));
			}
		}
	}
	public int ValeurFrame(int i) {
		// TODO Auto-generated method stub
		int x=i-1;
		int framedebut=this.getFrames(x, 0);
		int framefin=this.getFrames(x, 1);
		int valeurFrame=this.scores.get(framedebut);
			switch (framefin-framedebut)
			{
			  case 1:
				  valeurFrame+=this.scores.get(framefin);
				  break;
			  case 2:
				  valeurFrame+=this.scores.get(framedebut+1)+this.scores.get(framefin);
				  break;
			}
			return(valeurFrame);   
	}


	
	private void delimiterFrames() throws NbFrameException{
		// TODO Auto-generated method stub
		int numFrame=0;
		int nblances=0;
		int x=0;
		for(x=0; x < this.scores.size();x++){
			if(nblances==0){
				if(numFrame>=10){
					throw new NbFrameException();
				}
				this.frames[numFrame][0]=x;
				if(this.scores.get(x)==10||this.scores.get(x)+this.scores.get(x+1)==10){
					nblances = 3;
				}
				else{
					nblances = 2;
				}
			}
			this.frames[numFrame][1]=x;
			nblances--;
			if(nblances==0){
				numFrame++;
			}
		}
	}

	public int ValeurGame() {
		// TODO Auto-generated method stub
		int valeurGame=0;
		for (int i=1;i<=10;i++){
			valeurGame+=this.ValeurFrame(i);
		}
		return(valeurGame);
	}
	public static String lireString(){//lecture d'une chaine
		String ligne_lue=null;
		try{
		InputStreamReader lecteur=new InputStreamReader(System.in);
		BufferedReader entree=new BufferedReader(lecteur);
		ligne_lue=entree.readLine();
		}
		catch(IOException err){
		System.exit(0);
		}
		return ligne_lue;
		} 
	
	public void tourDunJoueur() throws ScorePasPossibleException{
		//rentrer le score du premier tire
		int score1=0;
		int score2=0;
		int score3=0;
		System.out.print("Rentrer le score du premier tir  "+"\n");
		try{
		String ligne_lue=lireString();
		score1=Integer.parseInt(ligne_lue);
		}catch(NumberFormatException err){
			System.out.println("***Erreur de données Entier attendu***");
			System.exit(0);
		}
		
		System.out.print("Rentrer le score du second tir  "+"\n");
		try{
		String ligne_lue=lireString();
		score2=Integer.parseInt(ligne_lue);
		}catch(NumberFormatException err){
			System.out.println("***Erreur de données Entier attendu***");
			System.exit(0);
		} 
		
		if(score1+score2 == 10|| score1==10){
			System.out.print("Rentrer le score du troisième tir  "+"\n");
			try{
			String ligne_lue=lireString();
			score3=Integer.parseInt(ligne_lue);
			}catch(NumberFormatException err){
				System.out.println("***Erreur de données Entier attendu***");
				System.exit(0);
			}
			int[] scoreDuTour = new int [3];
			scoreDuTour[0] = score1;
			scoreDuTour[1] = score2;
			scoreDuTour[2] = score3;
			this.ajouterScore(scoreDuTour);
		}
		if(score1+score2 > 10 && score1 !=10){
			throw new ScorePasPossibleException();
			
		}else{
			int[] scoreDuTour = new int [2];
			scoreDuTour[0] = score1;
			scoreDuTour[1] = score2;
			this.ajouterScore(scoreDuTour);
		}
	}
	
	public int getFrames(int i, int j) {
		// TODO Auto-generated method stub
		return (this.frames[i][j]);
	}
	public void afficherScoreJoueur(){
		for (int i=1;i<=10;i++){
			System.out.print("Points Frames "+i+":  "+this.ValeurFrame(i)+"\n");
		}
		System.out.print("Score total:" +this.ValeurGame()+"\n");
	}

}
