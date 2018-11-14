package it.umana.noleggi;

public class Noleggio<T>{
    private Utente utente;
    private T articolo;
    
    public Noleggio(Utente utente,T articolo){
        this.utente=utente;
        this.articolo=articolo;
    }
    
    public void setUtente(Utente utente){
        this.utente=utente;
    }
    
    public Utente getUtente(){
        return utente;
    }
    
    public void setArticolo(T articolo){
        this.articolo=articolo;
    }
    
    public Object getArticolo(){
        return articolo;
    }
     
    
}