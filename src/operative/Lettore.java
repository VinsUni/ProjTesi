package operative;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Lettore {
	
	private String idItem;
	private String titoloItem;
	private ArrayList<String> reviewFilteredById;
	private ArrayList<String> termNotRilevant;
	private ArrayList<String> termRilevant;
	private int counterReviewId;
	
	public Lettore() {
		this.reviewFilteredById=new ArrayList<String>();
		this.termNotRilevant = new ArrayList<String>();
		this.termRilevant = new ArrayList<String>();
		this.idItem = null;
		this.titoloItem=null;
		this.counterReviewId=0;
	}

	public int getCounterReviewId() {
		return this.counterReviewId;
	}
	
	public String getIdItem() {
		return idItem;
	}

	public void setIdItem(String idItem) {
		this.idItem = idItem;
	}

	public String getTitoloItem() {
		return titoloItem;
	}

	public void setTitoloItem(String titoloItem) {
		this.titoloItem = titoloItem;
	}

	public ArrayList<String> getReviewFilteredById() {
		return reviewFilteredById;
	}

	public void setReviewFilteredById(ArrayList<String> reviewFilteredById) {
		this.reviewFilteredById = reviewFilteredById;
	}

	public ArrayList<String> getTermNotRilevant() {
		return termNotRilevant;
	}

	public void setTermNotRilevant(ArrayList<String> termNotRilevant) {
		this.termNotRilevant = termNotRilevant;
	}

	public ArrayList<String> getTermRilevant() {
		return termRilevant;
	}

	public void setTermRilevant(ArrayList<String> termRilevant) {
		this.termRilevant = termRilevant;
	}
	
	//Take idItem and set the list of reviews for item
	
	public void getReviewId(String idItem) {
		Scanner s= null;
		String review=null;
		String line = null;
		int counter=0;
		
		try {
			s = new Scanner(new File("recensioni.txt"));
			while(s.hasNextLine()) {
				line = s.nextLine();
				String [] parts = line.split("\t");
				if(parts[0].equals(idItem)) {
					review= parts[3];
					this.reviewFilteredById.add(review);
					counter++;
					this.counterReviewId=counter;
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	//Take idItem and set the title
	// restituisce quello dopo 
	public void getTitleId(String idItem) {
		Scanner s= null;
		String title = null;
		String line = null;
		
		try {
			   s = new Scanner(new File("list_items_book(reduced).txt"));
			     while (s.hasNextLine()) {
				  line = s.nextLine();
				  String [] parts = line.split("\t");
				  if(parts[0].equals(idItem)) {
					  title=parts[1];
					  this.setTitoloItem(title);
				  }
				  }
		}catch (IOException e) {
			  System.out.println("Error accessing input file!");
			}finally {
				s.close();
			}
		
		
	}
	
	
	//Read Relevant and Not Relevant terms from file and add them in termNotRelevant and termRelevant (ArrayList<String>)
	
	public void readNotRilevantTerm() {
		Scanner s= null;
		try {
			   s = new Scanner(new File("termNotRilevant.txt"));

			  while (s.hasNext()) {
			    this.termNotRilevant.add(s.next());
			  }
			} catch (IOException e) {
			  System.out.println("Error accessing input file!");
			}finally {
				s.close();
			}
		
		
	}
	
	public void readRilevantTerm() {
		Scanner s= null;
		try {
			  s = new Scanner(new File("termRilevant.txt"));

			  while (s.hasNext()) {
			    this.termRilevant.add(s.next());
			  }
			} catch (IOException e) {
			  System.out.println("Error accessing input file!");
			}finally {
				s.close();
			}
	
		
	}
	
	
}
