package it.umana.noleggi;

public interface Noleggiabile{
    public void setGiacenza(int giacenza);
    public int getGiacenza();
    public Noleggio noleggia(Utente u);
}