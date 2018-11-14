package it.umana.articoli;

public class Gadget extends Articolo implements Cloneable {
	
	private String descrizione;
	private float peso;
	
	public Gadget () {
		
	}
	public Gadget (String codice, String descrizione, float peso) {
		super(codice);
		this.descrizione = descrizione;
		this.peso = peso;
	}
	

	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float peso) {
		this.peso = peso;
	}
	
    @Override
    public Object clone () throws CloneNotSupportedException {
    	Gadget gadget = (Gadget)super.clone();
    	gadget.setCodice( new String(getCodice()) );
    	gadget.descrizione = new String(descrizione);
    	gadget.peso = new Float(peso);
    	return gadget;
    }
    @Override
    public String toString(){
        return getCodice()+" "+this.descrizione+" grammi:"+this.peso;
    }

}
