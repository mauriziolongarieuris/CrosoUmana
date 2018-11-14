package it.umana.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import it.umana.Biblioteca;
import it.umana.articoli.Articolo;
import it.umana.articoli.ArticoloEditoriale;
import it.umana.articoli.Catalogatore;
import it.umana.articoli.Gadget;

public class ArticoliService {
	
	private static final String DISTINTA_ARTICOLI_FILENAME_PREFIX = "Distinta";
	private static final String GIACENZE_FILENAME_PREFIX = "GiacenzeAl";
	
	public void caricaArticoli(List<Articolo> giacenze) {
		Catalogatore catalogatore1 = new Catalogatore(DISTINTA_ARTICOLI_FILENAME_PREFIX+".txt", giacenze);
		catalogatore1.start();
	}


	public void stampaGiacenze(List<Articolo> giacenze) {
		String giacenzeFileName = GIACENZE_FILENAME_PREFIX + 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) 
				+".txt";
        try(BufferedWriter w = new BufferedWriter(new FileWriter(Biblioteca.FILES_PATH + giacenzeFileName))){ 	
	        for(Articolo g: giacenze) {
	        	String text = "";
	    		if(g instanceof ArticoloEditoriale) {
	        		ArticoloEditoriale a = (ArticoloEditoriale)g;
	        		text = " " +a.getGenere().getTipologia() + " " + a.getTitolo();
	        	} else if(g instanceof Gadget) {
	        		Gadget gad = (Gadget)g;
	        		text = " Gadget " + (gad.getDescrizione());
	        	}
        		System.out.println(text);
        		w.append(text);
        		w.newLine();
	        }
        }catch (Exception e) {
		    e.printStackTrace();
		}
	}	
	
	public void visualizzaGiacenze(List<Articolo> giacenze) {
		String giacenzeFileName = GIACENZE_FILENAME_PREFIX + 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")) 
				+".txt";
        try(BufferedWriter w = new BufferedWriter(new FileWriter(Biblioteca.FILES_PATH + giacenzeFileName))){ 	
	        for(Articolo g: giacenze) {
	        	String text = "";
	    		if(g instanceof ArticoloEditoriale) {
	        		ArticoloEditoriale a = (ArticoloEditoriale)g;
	        		text = " " +a.getGenere().getTipologia() + " " + a.getTitolo();
	        	} else if(g instanceof Gadget) {
	        		Gadget gad = (Gadget)g;
	        		text = " Gadget " + (gad.getDescrizione());
	        	}
        		System.out.println(text);
        		w.append(text);
        		w.newLine();
	        }
        }catch (Exception e) {
		    e.printStackTrace();
		}
	}	

}
