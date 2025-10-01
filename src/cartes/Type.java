package cartes;

public enum Type {
	
	FEU ("FEU ROUGE" , "FEU VERT","PRIORITAIRE"),
	ESSENCE("PANNE D'ESSENCE","ESSENCE","CITERNE D'ESSNCE"),
	CREVAISON("CREVAISON","ROUE DE SECOURS","INCREVABLE"),
	ACCIDENT("ACCIDENT","REPARATIONS","AS DU VOLANT");
	


    private final String attaque;
    private final String parade;
    private final String botte;
    
    Type(String attaque, String parade, String botte) {
        this.attaque = attaque;
        this.parade = parade;
        this.botte = botte;
    }
    
    public String getAttaque() {
    	return attaque ;
    }

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}
}


