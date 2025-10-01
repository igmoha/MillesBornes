package cartes;

public class Attaque extends Bataille {
	public Type t ;
	public Attaque( Type type) {
		super( type);
		this.t=type;
	}
	public String toString() {
        return t.getAttaque();
    }
	
}
