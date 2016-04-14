package application.model;

import java.util.*;

public class Scacchiera {
	
	private Map<Posizione, Lettera> griglia;
	private List<Posizione> posizioniValide;
	
	public Scacchiera(){
		griglia = new HashMap<Posizione, Lettera>();
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
	
	public List<Posizione> getPosizioniValide(){
		return posizioniValide;
	}
	
	public Map<Posizione, Lettera> getGriglia(){
		return griglia;
	}

}
