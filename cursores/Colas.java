package dsa.cursores;

public class Colas<T> extends ListaCursor{
	
	public static void main(String[] args) {
        // Inicializa una cola de cadenas
        Colas<String> a = new Colas<>(String.class);

        // Agrega elementos a la cola
        System.out.println("Agregando elementos a la cola:");
        a.PONE_EN_COLA("Primero", a);
        a.PONE_EN_COLA("Segundo", a);
        a.PONE_EN_COLA("Tercero", a);

        // Muestra el frente de la cola
        System.out.println("Frente de la cola: " + a.FRENTE(a)); // Debe mostrar "Primero"

        // Quita un elemento de la cola
        System.out.println("Quitando el frente de la cola:");
        a.QUITA_DE_COLA(a); // Debe quitar "Primero"

        // Muestra el nuevo frente de la cola
        System.out.println("Nuevo frente de la cola: " + a.FRENTE(a)); // Debe mostrar "Segundo"

        // Vacía la cola
        System.out.println("Anulando la cola (vaciando todos los elementos):");
        a.ANULA(a); 

        // Intenta obtener el frente de una cola vacía
        System.out.println("Frente después de anular la cola: " + a.FRENTE(a)); // Puede devolver null o manejar el vacío

        // Verifica que la cola está vacía
        System.out.println("Quitando de una cola vacía:");
        a.IMPRIME_LISTA(a);
        a.QUITA_DE_COLA(a); // Debería manejar el caso de cola vacía
    }
	
	public Colas(Class clazz) {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	//ANULA(C) -> Se puede usar la de ListaCursor 
	
	//FRENTE(C) 
	public static <T> T FRENTE(Colas C) {
		return Colas.RECUPERA(Colas.PRIMERO(C), C);
	} 
	
	//PONE_EN_COLA(x, C)
	public static <T> void PONE_EN_COLA(T x, Colas C) {
		Colas.INSERTA(x, Colas.FIN(C), C);
	}
	
	//QUITA_DE_COLA(C) 
	public static <T> void QUITA_DE_COLA(Colas C) {
		Colas.SUPRIME(Colas.PRIMERO(C), C);
	}
	//VACIA(C)
	public static <T> boolean VACIA(Colas P) {
		return (P.MemoriaUsada == 0); 
	}
}
