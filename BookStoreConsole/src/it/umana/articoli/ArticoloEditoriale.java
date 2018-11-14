package it.umana.articoli;

public abstract class ArticoloEditoriale extends Articolo implements Cloneable {
    private String titolo;
    private String autore;
    private String anno;
    private Genere genere;
    
    public ArticoloEditoriale(String codice, String anno, String titolo, String autore, Genere genere) {
        super(codice);
        this.anno=anno;
        this.titolo=titolo;
        this.autore=autore;
        this.setGenere(genere);
    }
    
    public void setTitolo(String titolo){
        this.titolo=titolo;
    }
    
    public String getTitolo(){
        return titolo;
    }
    
    public void setAnno(String anno){
        this.anno=anno;
    }
    
    public String getAnno(){
        return anno;
    }
    
    public String getAnno(String x){
        return anno;
    }
    
    public String getAnno(String a, int b){
        return anno;
    }
    
    public void setAutore(String autore){
        this.autore=autore;
    }
    
    public String getAutore(){
        return autore;
    }
    
	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

    @Override
	public Object clone () throws CloneNotSupportedException {
		ArticoloEditoriale articoloEditoriale = (ArticoloEditoriale) super.clone();
		articoloEditoriale.setCodice(new String(getCodice()) );
		articoloEditoriale.setTitolo(new String(this.getTitolo()));
		articoloEditoriale.setAutore(new String(this.getAutore()));
		articoloEditoriale.setAnno(new String(this.getAnno()));

		return articoloEditoriale;
   }
    
    @Override
    public String toString(){
        return super.getCodice()+" "+this.anno+" \""+this.titolo.toUpperCase()+"\" "+this.autore+" "+this.genere.getDescrizione();
    }
}