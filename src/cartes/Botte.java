package cartes;

public class Botte extends Probleme {
	public Type type ;
	public Botte( Type type) {
		super(type);
		this.type = type;
	
	}
	public String toString() {
        return type.getBotte();
    }
	
	
}
