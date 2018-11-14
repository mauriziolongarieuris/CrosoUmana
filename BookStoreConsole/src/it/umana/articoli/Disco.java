package it.umana.articoli;

public class Disco extends ArticoloEditoriale implements Cloneable {

    public Disco(String isbn, String anno, String titolo, String autore, Genere genere) {
        super(isbn, anno, titolo, autore, genere);
    }
}