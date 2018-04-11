package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.dao.AnagrammiDAO;

public class Model {
	
	AnagrammiDAO adao;
	
	List<String> soluzione;

	public Model() {
		this.adao = new AnagrammiDAO();
	}
		
	public List<String> getAnagrammi(String s) {
		
		soluzione = new ArrayList<String>();
		String daCercare = s;
		String daTogliere = daCercare;
		int livello = 0;
		String anagramma = "";
		
		recursive(daCercare, daTogliere, livello, anagramma);
		
		return soluzione;
	}
	
	public void recursive(String daCercare, String daTogliere, int livello, String anagramma) {
		
		if(livello>=daCercare.length()) {
			if(!soluzione.contains(anagramma)) {
				soluzione.add(anagramma);
			}
			return;
		}
		
		for(int i=0; i<daTogliere.length(); i++) {
			StringBuilder sb = new StringBuilder(daTogliere);
			sb.deleteCharAt(i);
			recursive(daCercare, sb.toString(), livello+1, anagramma+daTogliere.charAt(i));
		}
		
	}
		
	public boolean isCorrect(String anagramma) {
		return adao.isCorrect(anagramma);
	}

}
