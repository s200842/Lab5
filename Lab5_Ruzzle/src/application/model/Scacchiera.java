package application.model;

import java.util.*;

public class Scacchiera {
	
	private Map<Posizione, Character> griglia;
	private List<Posizione> posizioniValide;
	
	public Scacchiera(){
		griglia = new HashMap<Posizione, Character>();
		posizioniValide = new ArrayList<Posizione>();
		for(int r=1; r<=4; r++){
			for(int c=1; c<=4; c++){
				posizioniValide.add(new Posizione(r, c));
			}
		}
	}
	
	public int size(){
		return posizioniValide.size();
	}

}
