package application.model;

import java.util.*;

public class RuzzleModel {
	
	List<String> parole;
	Scacchiera griglia;
	
	public RuzzleModel(){
		parole = new ArrayList<String>();
		griglia = new Scacchiera();
	}
	
	public String randomChar(){
		Random r = new Random();
		int j = 97;
		int n = 122-j;
		int k = r.nextInt(n)+j;
		return String.valueOf(Character.toChars(k));
	}
	
	public void prepare(){
		
	}
	
	

}
