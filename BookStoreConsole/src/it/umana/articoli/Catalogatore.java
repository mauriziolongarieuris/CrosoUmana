package it.umana.articoli;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import it.umana.Biblioteca;

public class Catalogatore implements Runnable {
	
	private String fileName;
	private List<Articolo> giacenze;
	
	private static String ARCHIVE_PATH = "elaborati" + File.separator;
	
	private List<List<String>> distinta_articoli_matrix;

	private boolean finished = false;
	
	public Catalogatore(String fileName, List<Articolo> giacenze) {
		this.fileName = fileName;
		this.giacenze = giacenze;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Articolo> getGiacenze() {
		return giacenze;
	}

	public void setGiacenze(List<Articolo> giacenze) {
		this.giacenze = giacenze;
	}
	
	public boolean isFinished() {
		return this.finished;
	}

	@Override
	public void run() {
		//System.out.println("Inizio Caricamento file: " + fileName);
		while(true) {
			if(this.leggiFile()) {
				synchronized(giacenze) {
					this.cataloga();
				}
				try {
					archiviaFile();
				} catch (IOException e) {
					System.out.println("Non sono riuscito a spostare il file");
				}			
			}

			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		//System.out.println("Fine Caricamento file: " + fileName + "Gicenze caricate: " + (giacenze.size() - giacenzeBeforeCataloga));
	}
	
	public void start() {
		Thread th = new Thread(this);
        th.start();
	}
	
	private boolean leggiFile() {
		distinta_articoli_matrix = new ArrayList<List<String>>();
		FileReader fileReader;
		try {
			fileReader = new FileReader(Biblioteca.FILES_PATH + fileName);
		} catch (FileNotFoundException e) {
			return false;
		}
		
        try(BufferedReader r = new BufferedReader(fileReader)){
        	String line;
			while ( (line= r.readLine()) !=null ) {
				distinta_articoli_matrix.add(Arrays.asList(line.split(";")));
			}
        }catch (Exception e) {
		    e.printStackTrace();
		}
        return true;
	}
	
	private void archiviaFile() throws IOException {
		Path sourcePath = Paths.get(Biblioteca.FILES_PATH + fileName);
		String destFileName = fileName + 
				LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss"));
		Path destPath = Paths.get(Biblioteca.FILES_PATH + ARCHIVE_PATH +destFileName);
		Files.move(sourcePath, destPath);
	}
        
    private void cataloga() {		
		int indiceGiacenze = giacenze.size();
        for(int i=0; i < distinta_articoli_matrix.size(); i++) {
        	if("LIBRO".equals(distinta_articoli_matrix.get(i).get(0))) {
	        	giacenze.add(new Libro(
	        			distinta_articoli_matrix.get(i).get(1),
	        			distinta_articoli_matrix.get(i).get(2), 
	        			distinta_articoli_matrix.get(i).get(3), 
	        			distinta_articoli_matrix.get(i).get(4), 
	        			Genere.valueOf(distinta_articoli_matrix.get(i).get(5))
	        		)
	        	);
        	} else if("DISCO".equals(distinta_articoli_matrix.get(i).get(0))) {
        		giacenze.add(new Disco(
	        			distinta_articoli_matrix.get(i).get(1),
	        			distinta_articoli_matrix.get(i).get(2), 
	        			distinta_articoli_matrix.get(i).get(3), 
	        			distinta_articoli_matrix.get(i).get(4), 
	        			Genere.valueOf(distinta_articoli_matrix.get(i).get(5))
	        		)
	        	);
        	} else if("GADGET".equals(distinta_articoli_matrix.get(i).get(0))) {
        		giacenze.add(new Gadget(
	        			distinta_articoli_matrix.get(i).get(1),
	        			distinta_articoli_matrix.get(i).get(2), 
	        			Float.parseFloat(distinta_articoli_matrix.get(i).get(3))
        			)
        		);
        	}
        	// Genero i cloni
	        try {
	        	//System.out.println("Thread del file: "+ fileName +" indiceGiacenze: "+ indiceGiacenze);
	        	if("GADGET".equals(distinta_articoli_matrix.get(i).get(0))) {
					for(int j = 1; j<Integer.parseInt(distinta_articoli_matrix.get(i).get(4)); j++) {
		    	    	indiceGiacenze++;
		    	    	giacenze.add((Articolo) ((Gadget)giacenze.get(indiceGiacenze-1)).clone());
		    	    }
	        	}else {
					for(int j = 1; j<Integer.parseInt(distinta_articoli_matrix.get(i).get(6)); j++) {
		    	    	indiceGiacenze++;
		    	    	giacenze.add((Articolo) ((ArticoloEditoriale)giacenze.get(indiceGiacenze-1)).clone());
		    	    }
	        	}
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			} catch (ClassCastException e) {
				e.printStackTrace();
			}
	        indiceGiacenze++;
        }
	}
}
