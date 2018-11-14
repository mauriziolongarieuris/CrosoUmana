package it.umana.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import it.umana.Biblioteca;
import it.umana.articoli.Articolo;
import it.umana.articoli.ArticoloEditoriale;
import it.umana.articoli.Disco;
import it.umana.articoli.Gadget;
import it.umana.articoli.Libro;
import it.umana.noleggi.Noleggio;
import it.umana.noleggi.Utente;

public class NoleggiService {

	private static final int NOLEGGI_DA_FARE_PER_OGNI_ARTICOLO = 5;
	private static final String NOLEGGI_FILENAME_PREFIX = "NoleggiAl";
	
	public List<Noleggio<?>> noleggiaArticoli(List<Utente> utenti, List<Articolo> giacenze) {
		int indiceGiacenze;
		System.out.println("\nNoleggi");
        List<Noleggio<?>> noleggi = new ArrayList<Noleggio<?>>(); 
        indiceGiacenze =0;
        Random random = new Random();
        for(Utente u: utenti) {
            for(int j = 0; j< NOLEGGI_DA_FARE_PER_OGNI_ARTICOLO; j++) {
            	indiceGiacenze = random.nextInt(giacenze.size());
            	Articolo g = giacenze.get(indiceGiacenze);
        		if(g instanceof Libro) {
        			noleggi.add(new Noleggio<Libro>(u, (Libro) g));
        		} else if(giacenze.get(indiceGiacenze) instanceof Disco) {
        			noleggi.add(new Noleggio<Disco>(u, (Disco) g));
        		} else if(giacenze.get(indiceGiacenze) instanceof Gadget) {
        			noleggi.add(new Noleggio<Gadget>(u, (Gadget) g));
        		}
        		giacenze.remove(g);
            }
        }
		return noleggi;
	}

	public void stampaNoleggi(List<Noleggio<?>> noleggi) {
		String noleggiFileName = NOLEGGI_FILENAME_PREFIX + 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) 
				+".txt";
        try(BufferedWriter w = new BufferedWriter(new FileWriter(Biblioteca.FILES_PATH + noleggiFileName))){
	        for(Noleggio<?> n: noleggi) {
	        	String text = "L'utente " + n.getUtente().getNome() + " " + n.getUtente().getCognome();
	        	if(n.getArticolo() instanceof ArticoloEditoriale) {
	        		ArticoloEditoriale a = (ArticoloEditoriale)n.getArticolo();
	        		text  += " ha noleggiato il "+ a.getGenere().getTipologia() + ":\t" + a.getTitolo();
	        	} else if(n.getArticolo() instanceof Gadget) {
	        		Gadget g = (Gadget)n.getArticolo();
	        		text += " ha noleggiato il Gadget: "+g.getDescrizione();
	        	}
        		System.out.println(text);
        		w.append(text);
        		w.newLine();
	        }
        }catch (Exception e) {
		    e.printStackTrace();
		}
	}

	public void visualizzaNoleggi(List<Noleggio<?>> noleggi) {
		for(Noleggio<?> n: noleggi) {
        	String text = "L'utente nr."+ n.getUtente().getId()+" "+ n.getUtente().getNome() + " " + n.getUtente().getCognome();
        	if(n.getArticolo() instanceof ArticoloEditoriale) {
        		ArticoloEditoriale a = (ArticoloEditoriale)n.getArticolo();
        		text  += " ha noleggiato il "+ a.getGenere().getTipologia() + ":\t con ID:" +a.getCodice()+" "+ a.getTitolo();
        	} else if(n.getArticolo() instanceof Gadget) {
        		Gadget g = (Gadget)n.getArticolo();
        		text += " ha noleggiato il Gadget con ID: "+g.getCodice()+" "+g.getDescrizione();
        	}
    		System.out.println(text);
        }
		
	}
	
}
