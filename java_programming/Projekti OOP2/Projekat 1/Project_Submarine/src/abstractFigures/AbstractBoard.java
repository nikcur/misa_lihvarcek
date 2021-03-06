package abstractFigures;

import java.util.List;
import java.util.ArrayList;

import static java.lang.System.out;

/**
 * Klasa koja daje op�te informacije o tabli na kojoj se igra.
 * Ostale klase koje predstavljaju tablu za igru nasledjuju ovu klasu.
 * 
 * Inicijalni izgled table:
 * 
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * [0,0,0,0,0,0,0,0,0,0]
 * 
 * @author <a href="mailto:lihvarcekmisa@yahoo.com"> Lihvarcek Misa </a> 
 *
 */

public abstract class AbstractBoard {
   
   //tabla
   protected static List<List<Integer>> board;
   
   //konstantan broj vrsta i kolona na tabli
   protected final int NUM_ROWS = 10;
   protected final int NUM_COLUMNS = 10;
   
   //konstatan broj podmornica na tabli
   protected final int NUM_2LENGTH_SUBS = 3;
   protected final int NUM_3LENGTH_SUBS = 2;
   protected final int NUM_4LENGTH_SUBS = 1;
   
   //ukupan broj podmornica koji moze stajati na tabli
   protected final int MAX_SUB_NUM = NUM_2LENGTH_SUBS + NUM_3LENGTH_SUBS + NUM_4LENGTH_SUBS;
	
   AbstractBoard(){
	  //prazna tabla 
	  board = new ArrayList<>(NUM_ROWS);
	  
	  //dodajemo polja table
	  for(int row=0; row < 10; row++)
		 board.add(new ArrayList<Integer>(NUM_COLUMNS));
	  
	  //inicijalno tablu popunjavamo nulama
	  for(List<Integer> row: board)
	     for(int column=0; column < 10; column ++)
	    	row.add(0);
   }
   
   /**
    * Metod vraca broj vrsta na tabli.
    * 
    * @return broj vrsta
    */
   public int getRowCount(){
	  return board.size(); 
   }
   
   /**
    * Metod vraca broj kolona na tabli.
    * 
    * @return broj kolona
    */
   public int getColumnCount(){
	  return NUM_COLUMNS;
   }
   
   
   /**
    * Metod vraca dozvoljeni broj podmornica duzine 2.
    * 
    * @return broj podmornica duzine 2
    */
   public int getNum2SubsCount(){
	  return NUM_2LENGTH_SUBS; 
   }
   
   /**
    * Metod vraca dozvoljeni broj podmornica duzine 3.
    * 
    * @return  broj podmornica duzine 3
    */
   public int getNum3SubsCount(){
	  return NUM_3LENGTH_SUBS; 
   }
   
   /**
    * Metod vraca dozvoljeni broj podmornica duzine 4.
    * 
    * @return  broj podmornica duzine 4
    */
   public int getNum4SubsCount(){
	  return NUM_4LENGTH_SUBS; 
   }
   
   /**
    * Metod stampa trenutni izgled table u konzoli.
    */
   public void printTable(){
	  for(int row=0; row < board.size(); row++){
		 out.print("[");
		 for(int column=0; column < board.get(row).size(); column++){
			out.printf("%6d",board.get(row).get(column));
			if(column != board.get(row).size()-1)
			   out.print(",");
		 }
		 out.println("]");
	  }
	  out.printf("%s\n\n\n", "");
   }
   
   /**
    * Metod sluzi za postavljanje podmornice na tablu,
    * s tim da ce jedan kraj podmornice na tabli imati
    * koordinate x1,y1 a drugi kraj podmornice zavisi od njene
    * duzine i orijentacije.
    */
   public abstract void putSubmarine(Submarine submarine,int x1,int y1);
   
   /**
    *Metod sluzi za otkrivanje skrivenih polja na tabli.
    */
   public abstract boolean shootSubmarine(int x1,int y1);
   
   /**
    * Metod sluzi za vracanje table u stanje pre igre.
    */
   public abstract void resetTable();
   
   /**
    * Metod postavlja podmornice nasumicno po tabli.
    */
   public abstract void setSubmarinesRandomOnBoard();
   
   /**
    * Metod sluzi za promenu trenutne pozicije podmornice na tabli.
    */
   public abstract boolean changeSubmarinePosition(int id,int newX1,int newY1);
   
   
   
   public static void main(String [] args){
	  //AbstractBoard ab = new AbstractBoard();
	  //System.out.print(ab.getColumnCount()); 
	  //System.out.print(board.size());
   }
}
