package jeu;
import cartes.Carte;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Sabot implements Iterable<Carte> {
	
	 private Carte[] cartes;
	    private int nbCartes;
	    private int nombreOperations;
	    
	    public Sabot(Carte[] cartes) {
	    }
	
	    public boolean estVide() {
	        return this.nbCartes == 0;
	    }
	    public void ajouterCarte(Carte carte) {
	        if (this.nbCartes == 106) {
	            throw new IllegalArgumentException("Le nombre de cartes maximum est atteint.");
	        }
	        this.cartes[this.nbCartes] = carte;
	        this.nbCartes++;
	        this.nombreOperations++;
	    }
	    public Carte piocher() {
	        if (estVide()) {
	            throw new NoSuchElementException("Il n'y a plus de cartes a piocher.");
	        }
	        Iterator<Carte> iterator =  this.iterator();
	        Carte carte = iterator.next();
	        iterator.remove();
	        return carte;
	        }

		@Override
		 public Iterator<Carte> iterator() {
	        return new SabotIterator();
	    }
		private class SabotIterator implements Iterator<Carte>{
			private int positionCourante = 0;
	        private final int nbOperationsReference = nombreOperations;
	        private boolean estSupprimable = false;
			
	        private void verifierModification() {
	            if (nbOperationsReference != nombreOperations) {
	                throw new ConcurrentModificationException("Le sabotest modifie pendant l'iteration.");
	            }}
	            
	        public boolean hasNext() {
	        	verifierModification();
	            return positionCourante < nbCartes;
	        }
	        public Carte next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException("Aucune carte suivante.");
	            }
	            estSupprimable = true;
	            return cartes[positionCourante++];
	        }
	        @Override
	        public void remove() {
	            if (!estSupprimable) {
	                throw new IllegalStateException("Il faut appeler next() avant de pouvoir supprimer un element.");
	            }
	            System.arraycopy(cartes, positionCourante, cartes, positionCourante - 1, nbCartes - positionCourante);
	            cartes[--nbCartes] = null;
	            positionCourante--;
	            estSupprimable = false;
	        }
		} 
}
