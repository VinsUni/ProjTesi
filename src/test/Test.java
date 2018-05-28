package test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import operative.CoreNLPObj;
import operative.Lettore;
import operative.Term;

public class Test {

	public static void main(String[] args) {

		Lettore lettore = new Lettore();
		lettore.getReviewId("I:1034");
		lettore.getTitleId("I:1034");
		lettore.readNotRilevantTerm();
		lettore.readRilevantTerm();
		CoreNLPObj o = new CoreNLPObj(lettore);
		
		o.excractTerm();
		
		HashSet<Term> prova = new HashSet<>();
		
		prova = o.getListForTerm();
		
		for(Term t: prova) {
			System.out.println(t.toString());
		}
		

		System.out.println(lettore.getTitoloItem());
		System.out.println("Term Relevant: ------->" + lettore.getTermRilevant().toString());
		System.out.println("Term Not Relevant: ------->" + lettore.getTermNotRilevant().toString());
		// System.out.println("Review for this Item:------->" +
		// lettore.getReviewFilteredById().toString());
		System.out.println("Num of reviews:-------->" + lettore.getCounterReviewId());

		List<String> reviewACaso = new ArrayList<>();

		int numSpace = 0;

		reviewACaso.add("Carlo e franco-stasera sono nervoso e mammt mor ");

		String stringa = reviewACaso.get(0);

		String[] array = stringa.split(" ");
	

		System.out.println(array.length);

		reviewACaso.get(0).replace(" ", "");

		System.out.println(reviewACaso.get(0).length());

		reviewACaso.add(" Tenaglia");
		reviewACaso.add("Bello Figo Gu");
		String term = "Gu";

		System.out.println(reviewACaso.size());
		int counterTerm = 0;
		int counter = 0;
		for (String parola : reviewACaso) {
			counter = parola.length() + counter;
			if (parola.equals(term)) {
				counterTerm++;
			}

		}
		System.out.println("CT: " + counterTerm + ", CP: " + counter + ", TF: " + counterTerm / counter);

	}

}
