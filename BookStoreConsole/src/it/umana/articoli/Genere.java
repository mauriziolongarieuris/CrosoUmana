package it.umana.articoli;

public enum Genere {
	STORICO("Genere letterario storico", "Libro"), 
	FANTASY("Genere letterario fantasy", "Libro"), 
	GIALLO("Genere letterario giallo", "Libro"), 
	ROSA("Genere letterario rosa", "Libro"),
	ROCK("Genere musicale Rock", "Disco"),
	POP("Genere musicale Pop", "Disco"),
	CLASSICA("Genere musicale Classica", "Disco"),
	JAZZ("Genere musicale Jazz", "Disco");
	
	private String descrizione;
	private String tipologia;
	
	Genere(String descrizione, String tiopologia) {
		this.descrizione = descrizione;
		this.tipologia = tiopologia;
	}
	
	public String getDescrizione() {
		return descrizione;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
}
