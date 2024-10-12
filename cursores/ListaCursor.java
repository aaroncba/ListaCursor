//package dsa.cursores;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ListaCursor<T> {
	T Datos[]; 
	int[] Indice; 
	int Inicio, MemoriaUsada = 0;
	
	
    @SuppressWarnings("unchecked")
	public ListaCursor(Class<T> clazz) {
    	this.Datos = (T[]) Array.newInstance(clazz, 1000);
		this.Indice = new int[1000]; 
		Arrays.fill(this.Indice, -1);
		this.Inicio = -1; 
	}	

    
    public static void main(String[] args) {
    	/*
    	 * Par probar el codigo, se tiene que inializar una ListaCursor de la siguiente manera
    	 * ListaCursor<Tipo_de_Dato> NombreDeVariable = new ListaCursor(Tipo_de_Dato.class);
    	 * Por ejemplo, para una lista cursor de tipo entero: 
    	 * ListaCursor<Integer> Cursero_Entero = new ListaCursor(Integer.class); 
    	 * */

    	
	}
    
    //Funcion Inserta
    
    public static <T> void INSERTA(T x, int pos, ListaCursor<T> L) {
        // Verifica si la posición es válida (entre 1 y 999) o es -1 (insertar al final)
        if(!((pos >= 1 && pos < 1000) || pos == -1)) {
            throw new ArrayIndexOutOfBoundsException("El valor ingresado es menor que 1 o mayor que 1000"); 
        } 
        
        // Verifica si ya no hay espacio en la lista
        if(L.MemoriaUsada == 1000) {
            System.out.println("YA NO HAY ESPACIO EN LA LISTA");
            return;
        }
        
        // Encuentra una posición libre en el arreglo
        int pos_libre = ListaCursor.ESPACIOS_LIBRES(L);
        System.out.println("Pos libre es " + pos_libre);
        
        // Si es la primera inserción (lista vacía)
        if(L.Inicio == -1) {
            System.out.println("Primera inserción en posición " + pos);
            L.Inicio = pos; 
            L.Datos[pos-1] = x;  // Insertar el dato en la posición libre
            
        } 
        // Si la lista tiene un solo elemento
        else if(L.MemoriaUsada == 1) {
            System.out.println("Inserción cuando hay un solo elemento, en posición " + pos);
            L.Indice[L.Inicio - 1] = pos_libre + 1;  // Enlaza el primer elemento al nuevo
            L.Datos[pos_libre] = x;  // Inserta el dato
            L.Indice[pos_libre] = -1;  // El nuevo final de la lista
        } 
        // Si inserta al final de la lista
        else if(pos == -1) {
            int ult_pos = ListaCursor.ANTERIOR(ListaCursor.FIN(L), L);
            System.out.println("ULT POS ES " + ult_pos);
            L.Indice[ult_pos - 1] = pos_libre + 1;  // Enlaza el último elemento al nuevo
            L.Datos[pos_libre] = x;  // Inserta el dato en la posición libre
            L.Indice[pos_libre] = -1;  // El nuevo final de la lista
        } 
        // Inserta en una posición específica dentro de la lista
        else {
            int pos_sig = L.Indice[pos - 1];  // Obtiene el siguiente elemento en la lista
            L.Indice[pos - 1] = pos_libre + 1;  // Actualiza el índice del anterior
            L.Datos[pos_libre] = L.Datos[pos - 1];  // Mueve el dato actual a la nueva posición
            L.Indice[pos_libre] = pos_sig;  // Enlaza la nueva posición con la siguiente
            L.Datos[pos - 1] = x;  // Inserta el nuevo dato en la posición deseada
        }

        // Incrementa el uso de memoria después de la inserción
        L.MemoriaUsada++; 
    }

    
    public static <T> int ESPACIOS_LIBRES(ListaCursor<T> L) {
    	for(int i = 0; i < 1000; i++) {
    		
    		if(L.Indice[i] == -1 && L.Datos[i] == (null)) return i; 
    	}
    	return -1; 
    }
    
    
    public static <T> int SIGUIENTE(int pos, ListaCursor<T> L) {
    	//Si L.Indice[pos] es igual a menos -1 (FIN(L)) y L.Datos[pos] == null
    	//Eso significa que es algo que no se puede hacer porque no esta definido
    	if(L.Indice[pos-1] == -1 && L.Datos[pos-1] == null) 
    		throw new ArrayIndexOutOfBoundsException(pos + " en el Cursor L no esta definido");
    	//Se va a trabajar con L.Indice[pos-1] porque el arreglo va de 0-999
    	//La lista va de 1-1000 :)
    	else {
    		return L.Indice[pos-1]; 
    	} 
   
    }
    
    
    public static <T> int ANTERIOR(int pos, ListaCursor<T> L) {
    	//Tenemos que determinar que pos sea distinto de L.Inicio
    	if(pos != -1) {
    		if(L.Indice[pos-1] == -1 && (L.Datos[pos-1] == null) || pos == L.Inicio) 
    			throw new ArrayIndexOutOfBoundsException(pos + " en el Cursor L no esta definido");
    	}
    	for(int i = 0; i < 1000; i++) {
    	
    		//System.out.println("pos es " + pos + ( L.Indice[i] == pos && !(L.Datos[i] == null)));
    		//System.out.println("L.indice " + (L.Indice[i] == pos));
    		if(L.Indice[i] == pos && !(L.Datos[i] == null)) return i+1; 
    	}
    	System.out.println("Llego ahasta");
    	return -1; 
    }
    
    
    public static <T> int FIN(ListaCursor<T> L) {
    	return -1; 
    }
    
    
    
    
    public static <T> void IMPRIME_LISTA(ListaCursor<T> L) {
        System.out.printf("| %-20s | %-20s | %-25s | %n", "Indice de Arreglo", "Info Guardada", "Pos Lista");
        for (int i = 0; i < 1000; i++) {
            System.out.printf("| %-20d | %-20s | %-25d | %n", (i + 1), L.Datos[i], L.Indice[i]);
        }

        // Print Inicio and MemoriaUsada after the table
        System.out.printf("Inicio: %-10d Memoria Usada: %-10d %n", L.Inicio, L.MemoriaUsada);
    }


    
    
    //LOCALIZA(x, L)
    public static <T> int LOCALIZA(T x, ListaCursor L) {
    	int pos = L.Inicio; //comienza desde la primer posicion del cursor  
    	for(int i = 0; i<1000; i++) { // itera por todo el cursor
    		if(L.Datos[pos-1].equals(x)) return pos;  // si el dato en esa posicion es igual a x, retorna la posicion 
    		pos = L.Indice[pos-1]; // de lo contrario, avanza a la siguiente
    		if(pos == -1) break; // si llega a -1, entonces llego al fin
    		System.out.println("Entro aqui y cambio a " + pos);
    	}
    	return -1; 
    }
    
    
    //RECUPERA(p, L)
    //Si el elemento no existe o es FIN(L), entonces se devuleve null
    public static <T> T RECUPERA(int p, ListaCursor L) {
    	if(p == -1 || (L.Indice[p-1] == -1 && (L.Datos[p-1] == null))) return null; 
    	
    	return (T) L.Datos[p-1]; 
    }
    
    //SUPRIME(p, L)
    public static <T> void SUPRIME(int p, ListaCursor L){
    	if((p == -1) || ((L.Datos[p-1] == null) && L.Indice[p-1] == -1)) {
    		throw new ArrayIndexOutOfBoundsException(p + " en el Cursor L no esta definido o es el fin de la lista");
    	}
    	else {
    		if(p == L.Inicio) {
    			L.Inicio = ListaCursor.SIGUIENTE(p, L); 
    		}else {
    			int newP = ListaCursor.ANTERIOR(p, L); 
        		L.Indice[newP -1] = ListaCursor.SIGUIENTE(p, L); 	
    		}
    		L.Indice[p-1] = -1; 
    		L.Datos[p-1] = null; 
    		L.MemoriaUsada--; 
    		
    	}
    	
    }
    
    //ANULA(L) 
    public static <T> int ANULA(ListaCursor L) { 
    	Arrays.fill(L.Datos, null);
    	L.Inicio = -1; 
    	L.MemoriaUsada = 0;
    	Arrays.fill(L.Indice, -1);
    	return -1; 
    }
    
    //PRIMERO(L)
    //Si L.Inicio es -1, eso significa que no hay una posicion definida
    public static <T> int PRIMERO(ListaCursor L) {
    	return L.Inicio; 
    }
    
	
 
}
