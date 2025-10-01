package cartes;

public class Parade extends Bataille {
	public Type type ;
	public Parade(Type type) {
		super(type);
		this.type = type;
	}
	
	public String toString() {
        return type.getParade();
    }
}
