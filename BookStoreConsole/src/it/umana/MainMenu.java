package it.umana;

import java.util.List;
import java.util.Scanner;

import it.umana.articoli.Articolo;
import it.umana.noleggi.Noleggio;
import it.umana.noleggi.Utente;
import it.umana.services.ArticoliService;
import it.umana.services.NoleggiService;
import it.umana.services.UtentiService;

public class MainMenu {
	
	private List<Articolo> giacenze;
	private List<Utente> utenti;
	private List<Noleggio<?>> noleggi;
	
	
	public MainMenu(List<Articolo> giacenze, List<Utente> utenti, List<Noleggio<?>> noleggi) {
		this.giacenze = giacenze;
		this.utenti = utenti;
		this.noleggi = noleggi;
	}

	public void showMainMenu() {
		int choice = -1;
		ArticoliService articoliService = new ArticoliService();
		NoleggiService noleggiService = new NoleggiService();
		UtentiService utentiService = new UtentiService();
		do {
			System.out.println("Scegli una opzione: ");
			System.out.println("1) Visualizza Giacenze;\n2) Visualizza Utenti\n3) Visualizza Noleggi\n"
					+ "4) Noleggia Articolo\n5) Chiudi Noleggio Articolo\n6) Inserisci Nuovo Utente\n0) Esci\n");
			Scanner sc = new Scanner(System.in);
			try{
				choice = sc.nextInt();
				switch (choice) {
					case 0:
						System.out.println("Arrivederci!");
						break;
			        case 1:
			        	articoliService.visualizzaGiacenze(giacenze);
			            break;
			        case 2:
			        	utentiService.visualizzaUtenti(utenti);
			            break;
			        case 3:
			            noleggiService.visualizzaNoleggi(noleggi);
			            break;
			        case 4:
			            // Perform "quit" case.
			            break;
			        case 5:
			            // Perform "quit" case.
			            break;
			        case 6:
			            // Perform "quit" case.
			            break;
			        default:
			        	System.out.println("Opzione non valida!");
			        	
			    }
			} catch (Exception e){
				e.printStackTrace();
			}
			
		} while(choice>0);
		return;
	}

}
