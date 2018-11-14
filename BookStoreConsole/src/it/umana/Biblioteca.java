package it.umana;

import java.util.ArrayList;
import java.util.List;

import it.umana.articoli.Articolo;
import it.umana.noleggi.Noleggio;
import it.umana.noleggi.Utente;
import it.umana.services.ArticoliService;
import it.umana.services.NoleggiService;
import it.umana.services.UtentiService;

public class Biblioteca{
	
	/**	
	* Lezione NR-8. Esercitazione-2, Utilizzo dei Thread e Lambda Expression
	*/
	
	public static final String FILES_PATH = "C:\\Users\\longari\\Projects\\workspaces\\Local\\JAVA_CORE\\files\\";
	
	public static List<Articolo> giacenze = new ArrayList<Articolo>();
	public static List<Utente> utenti;
	public static List<Noleggio<?>> noleggi;
	
	public static void main(String args[]){
		
		UtentiService utentiService = new UtentiService();
		utenti = utentiService.caricaUtenti();
        
        //Leggo la distinta degli articoli e creo l'array delle giacenze
        ArticoliService articoliService = new ArticoliService();		
		articoliService.caricaArticoli(giacenze);

		//Avvio il menu principale
		MainMenu menu = new MainMenu(giacenze, utenti, noleggi);
		menu.showMainMenu();

	}

}