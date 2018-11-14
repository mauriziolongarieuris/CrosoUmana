package it.umana.articoli;

public class Libro extends ArticoloEditoriale implements Cloneable {

    public Libro(String isbn, String anno, String titolo, String autore, Genere genere) {
        super(isbn, anno, titolo, autore, genere);
    }
}