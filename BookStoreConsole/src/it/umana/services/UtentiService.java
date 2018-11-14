package it.umana.services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import it.umana.Biblioteca;
import it.umana.noleggi.Utente;

public class UtentiService {
	private static final String UTENTI_FILENAME = "Utenti.txt";
	
	public List<Utente> caricaUtenti() {
       //lettura Utenti
		List<Utente> utenti = new ArrayList<Utente>();
		try(BufferedReader r = new BufferedReader(new FileReader(Biblioteca.FILES_PATH + UTENTI_FILENAME))){
			String line;
			while ( (line= r.readLine()) !=null ) {
				String[] userStrings = line.split(";");
				utenti.add(new Utente(
						 Integer.parseInt(userStrings[0]),
						 userStrings[1],
						 userStrings[2],
						 userStrings[3],
						 Integer.parseInt(userStrings[4]),
						 userStrings[5],
						 userStrings[6]
					)
				);
			}
		}catch (Exception e) {
		    e.printStackTrace();
		}
		
        return utenti;
	}

	public void visualizzaUtenti(List<Utente> utenti) {
        for(Utente u: utenti) {
        	System.out.println(u);
        }
	}

}
