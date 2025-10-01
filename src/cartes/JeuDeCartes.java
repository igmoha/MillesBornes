package cartes;

public class JeuDeCartes {
	
	private Configuration[] configurations;
	
	 public JeuDeCartes() {
	        configurations = new Configuration[]{
	        		 new Configuration(new Borne(25), 10),  
	        		 new Configuration(new Borne(50), 10),
	        		 new Configuration(new Borne(75), 10),
	        		 new Configuration(new Borne(200), 4),
	        		 new Configuration(new Parade(Type.FEU), 14),
	        		 new Configuration(new FinLimite(), 6),
	        		 new Configuration(new Parade(Type.ESSENCE), 6),        
	                 new Configuration(new Parade(Type.CREVAISON), 6),     
	                 new Configuration(new Parade(Type.ACCIDENT), 6),       
	                 new Configuration(new Attaque(Type.FEU), 5),           
	                 new Configuration(new DebutLimite(), 4),               
	                 new Configuration(new Attaque(Type.ESSENCE), 3),      
	                 new Configuration(new Attaque(Type.CREVAISON), 3),     
	                 new Configuration(new Attaque(Type.ACCIDENT), 3),      
	                 new Configuration(new Botte(Type.FEU), 1),             
	                 new Configuration(new Botte(Type.ESSENCE), 1),         
	                 new Configuration(new Botte(Type.CREVAISON), 1),       
	                 new Configuration(new Botte(Type.ACCIDENT), 1)   };
	        }
	 
	 public Carte[] donnerCartes() {
	        int totalCartes = 0;
	        for (Configuration config : configurations) {
	            totalCartes += config.getNbExemplaire();
	        }
	        Carte[] cartes = new Carte[totalCartes];
	        int index = 0;
	        for (Configuration config : configurations) {
	            for (int i = 0; i < config.getNbExemplaire(); i++) {
	                cartes[index++] = config.getCarte();
	            }
	        }
	        return cartes;
	 }
	 
	 
	
	 public String affichageJeuCartes() {
	        StringBuilder sb = new StringBuilder("");
	        for (Configuration config : configurations) {
	            sb.append(config.getNbExemplaire()).append(" ").append(config.getCarte().toString()).append("\n");
	        }
	        return sb.toString();
	    }
	
	
	
	private static class Configuration  {
		private int nbExamplaires;
		private Carte carte ;
		
		public Configuration(Carte carte ,int nombre) {
			this.nbExamplaires = nombre ;
			this.carte = carte ;
		}
		 public Carte getCarte() {
	            return carte;
	        }

	        public int getNbExemplaire() {
	            return nbExamplaires;
	        }
	}
	
}