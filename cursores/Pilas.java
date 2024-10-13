package dsa.cursores;

public class Pilas<T> extends ListaCursor{

	

	
	
	public Pilas(Class clazz) {
		super(clazz);
	}
	
	
	//ANULA(P) -> va a usar la funcion de ListaCursor, no se necesitan cambios
	
	//TOPE(P)
	@SuppressWarnings("unchecked")
	public static <T> T TOPE(Pilas P) {
		return P.RECUPERA(Pilas.PRIMERO(P), P);
	}
	
	//SACA(P)
	
	public static <T> void SACA(Pilas P) {
		Pilas.SUPRIME(Pilas.PRIMERO(P), P);
	}
	
	//METE(x, P) 
	
	public static <T> void METE(T x, Pilas P) {
		Pilas.INSERTA(x, Pilas.PRIMERO(P), P);
	}
	
	//VACIA(P)
	public static <T> boolean VACIA(Pilas P) {
		return (P.MemoriaUsada == 0); 
	}
	
}
