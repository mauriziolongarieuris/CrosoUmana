package it.umana.noleggi;

public class Utente{
    private int id;
    private String nome;
    private String cognome;
    private String sesso;
    private int eta;
    private String indirizzo;
    private String telefono;
    
    public Utente(int id, String nome, String cognome, String sesso, int eta, String indirizzo, String telefono){
        this.id=id;
        this.nome=nome;
        this.cognome=cognome;
        this.sesso=sesso;
        this.eta=eta;
        this.indirizzo=indirizzo;
        this.telefono=telefono;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    
    public String getCognome(){
        return cognome;
    }
    public void setCognome(String cognome){
        this.cognome=cognome;
    }
    
    public String getSesso(){
        return sesso;
    }
    public void setSesso(String sesso){
        this.sesso=sesso;
    }
    
    public int getEta(){
        return eta;
    }
    public void set(int eta){
        this.eta=eta;
    }
    
    public String getIndirizzo(){
        return indirizzo;
    }
    public void setIndirizzo(String indirizzo){
        this.indirizzo=indirizzo;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public void set(String telefono){
        this.telefono=telefono;
    }
    
    @Override
    public String toString(){
        return "ID Utente: "+this.id+" Nome: "+this.nome+" "+this.cognome+" Sesso: "+this.sesso+" Età: "+this.eta+
        		" Indirizzo: "+this.indirizzo+" Telefono:"+this.telefono;
    }
}