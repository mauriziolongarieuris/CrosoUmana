package it.umana.articoli;

public abstract class Articolo implements Cloneable{
	
	private String codice;
	
	public Articolo () {
		
	}
	
	public Articolo (String codice) {
		this.codice = codice;
	}
	
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	
	@Override
    public Object clone () throws CloneNotSupportedException {
		Articolo articolo = (Articolo)super.clone();
		articolo.setCodice( new String(getCodice()) );
    	return articolo;
    }
	
}
