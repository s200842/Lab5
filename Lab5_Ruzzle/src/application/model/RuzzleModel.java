package application.model;

import java.util.*;

import application.db.LetteraDAO;

public class RuzzleModel {
	
	private List<Lettera> parole;
	private Scacchiera griglia;
	private LetteraDAO dao;
	private List<Lettera> usate;
	
	public RuzzleModel(){
		parole = new ArrayList<Lettera>();
		griglia = new Scacchiera();
		dao = new LetteraDAO();
		usate = new ArrayList<Lettera>();
	}
	
	public String randomChar(){
		Random r = new Random();
		int j = 97;
		int n = 122-j;
		int k = r.nextInt(n)+j;
		return String.valueOf(Character.toChars(k));
	}
	
	public void prepare(List<Lettera> list){
		int i = 0;
		for(Posizione p : griglia.getPosizioniValide()){
			//Inserisco nella griglia la lettera e aggiorno la sua posizione
			griglia.getGriglia().put(p, list.get(i));
			list.get(i).setP(p);
			i++;
		}
	}
	
	public void cercaParole(){
		for(int r=1; r<=4; r++){
			for(int c=1; c<=4; c++){
				usate.add(griglia.getGriglia().get(new Posizione(r, c)));
				ricerca(griglia.getGriglia().get(new Posizione(r, c)));
				usate.clear();
			}
		}
	}
	
	public void ricerca(Lettera l){
		int posRiga = l.getP().getRiga();
		int posCol = l.getP().getColonna();
		for(int c=posCol-1; c<=posCol+1; c++){
			for(int r=posRiga-1; r<=posRiga+1; r++){
				//Controllo validit� posizione
				if(r>=1 && r<=4){
					if(c<=4 && c>=1){
						//Prendo la lettera(che sar� adiacente ad l); se non � usata la aggiungo alla parola e controllo se � valida
						Lettera lett = griglia.getGriglia().get(new Posizione(c,r));
						if(!usate.contains(lett)){
							usate.add(lett);
							String check = "";
							for(Lettera s : usate){
								check += s.getLettera();
							}
							if(dao.checkParola(check)){
								System.out.println(check);
								ricerca(lett);
							}
							usate.remove(lett);
						}
					}
				}
			}
		}
	}
	
	

}
