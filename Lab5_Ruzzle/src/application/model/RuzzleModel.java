package application.model;

import java.util.*;

import application.db.LetteraDAO;

public class RuzzleModel {
	

	private Scacchiera griglia;
	private LetteraDAO dao;
	private List<Lettera> usate;
	private List<String> trovate;
	
	public RuzzleModel(){
		griglia = new Scacchiera();
		dao = new LetteraDAO();
		usate = new ArrayList<Lettera>();
		trovate = new ArrayList<String>();
	}
	
	public String randomChar(){
		Random r = new Random();
		int j = 97;
		int n = 122-j;
		int k = r.nextInt(n)+j;
		return String.valueOf(Character.toChars(k));
	}
	
	public void prepare(List<Lettera> list){
		griglia.getGriglia().clear();
		int i = 0;
		for(Posizione p : griglia.getPosizioniValide()){
			//Inserisco nella griglia la lettera e aggiorno la sua posizione
			griglia.getGriglia().put(p, list.get(i));
			list.get(i).setP(p);
			i++;
		}
	}
	
	public List<String> cercaParole(){
		trovate.clear();
		for(int r=1; r<=4; r++){
			for(int c=1; c<=4; c++){
				usate.add(griglia.getGriglia().get(new Posizione(r, c)));
				ricerca(griglia.getGriglia().get(new Posizione(r, c)));
				usate.clear();
			}
		}
		Collections.sort(trovate, new Comparator<String>(){

			@Override
			public int compare(String s1, String s2) {
				if(s1.length()>s2.length()){
					return 1;
				}
				else if(s1.length()<s2.length()){
					return -1;
				}
				return 0;
			}
			
		});
		return trovate;
	}
	
	public void ricerca(Lettera l){
		int posRiga = l.getP().getRiga();
		int posCol = l.getP().getColonna();
		for(int r=posRiga-1; r<=posRiga+1; r++){
			for(int c=posCol-1; c<=posCol+1; c++){
				//Controllo validità posizione
				if(r>=1 && r<=4){
					if(c<=4 && c>=1){
						//Prendo la lettera(che sarà adiacente ad l); se non è usata la aggiungo alla parola e controllo se è valida
						Lettera lett = griglia.getGriglia().get(new Posizione(r, c));
						if(!usate.contains(lett)){
							usate.add(lett);
							String check = "";
							for(Lettera s : usate){
								check += s.getLettera();
							}
							if(dao.checkParola(check)){
								trovate.add(check);
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
