import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



public class TesTAffichBowling {
	private int[] score;
	private int[] score_test;
	private AffichBowlingGame game = null;
	private AffichBowlingGame game_test = null;
	//private AffichBowlingGame game2= null;
		
	@Before
	public void setUp(){
		this.score = new int[25];
		this.score[0] = 1;//1stFrame
		this.score[1] = 3;//1stFrame
		this.score[2] = 2;//2ndFrame
		this.score[3] = 8;//2ndFrame
		this.score[4] = 3;//2ndFrame
		this.score[5] = 1;//3rdFrame
		this.score[6] = 9;//3rdFrame
		this.score[7] = 10;//3rdFrame
		this.score[8] = 10;//4thFrame
		this.score[9] = 10;//4thFrame
		this.score[10] =10;//4thFrame
		this.score[11] = 1;//5tfFrame
		this.score[12] = 0;//5tfFrame
		this.score[13] = 0;//6thFrame
		this.score[14] = 0;//6thFrame
		this.score[15] = 2;//7thFrame
		this.score[16] = 7;//7thFrame
		this.score[17] = 0;//8thFrame
		this.score[18] = 10;//8thFrame
		this.score[19] = 10;//8thFrame
		this.score[20] = 1;//9thFrame
		this.score[21] = 2;//9thFrame
		this.score[22] = 7;//10thFrame
		this.score[23] = 3;//10thFrame
		this.score[24] = 0;//10thFrame
		this.game = new AffichBowlingGame(this.score);
		this.score_test = new int[11];
		this.score_test[0] = 1;
		this.score_test[1] = 3;
		this.score_test[2] = 2;
		this.score_test[3] = 8;
		this.score_test[4] = 3;
		this.score_test[5] = 1;
		this.score_test[6] = 9;
		this.score_test[7] = 10;
		this.score_test[8] = 10;
		this.score_test[9] = 10;
		this.score_test[10] = 10;
		this.game_test= new AffichBowlingGame(this.score_test);
	}

	@After
	public void tearDown() throws Exception {
		this.game = null;
		this.score=null;
	}
	
	@Test
	public void testAffichBowlingGameValeurGame() {
		assertEquals(110, this.game.ValeurGame());			
	}
	@Test
	public void testAffichFrames(){
		for(int i=0;i<10;i++){
			System.out.print(game.getFrames(i,0));
			System.out.print(","+game.getFrames(i,1)+"\n");
		}
		}
	@Test
	public void testAjouterScore() {
		int[] i= new int[2];
		i[0]=1;
		i[1]=8;
		this.game_test.ajouterScore(i);
	}
	
	@Test
	public void testValeurGame() {
		assertEquals(110, this.game.ValeurGame());
	}


	@Test
	public void testAfficherScoreJoueur() {
		this.game.afficherScoreJoueur();
	}
	
	@Test
	public void testValeurFame() {
		assertEquals(4, this.game.ValeurFrame(1));
		assertEquals(13, this.game.ValeurFrame(2));
		assertEquals(20, this.game.ValeurFrame(3));
		assertEquals(30, this.game.ValeurFrame(4));
		assertEquals(1, this.game.ValeurFrame(5));
		assertEquals(0, this.game.ValeurFrame(6));
		assertEquals(9, this.game.ValeurFrame(7));
		assertEquals(20, this.game.ValeurFrame(8));
		assertEquals(3, this.game.ValeurFrame(9));
		assertEquals(10, this.game.ValeurFrame(10));
	}
	@Test
	public void testAjouterScoreTropsDeFrames() {
		int[] i= new int[2];
		i[0]=1;
		i[1]=8;
		this.game.ajouterScore(i);
	}
	
	@Test
	public void testTourDunJoueur(){
		try {
			this.game_test.tourDunJoueur();
		} catch (ScorePasPossibleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
