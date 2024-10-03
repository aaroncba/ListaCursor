package dsa.cursores;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ListaCursor<T> {
	T Datos[]; 
	int[] Indice, EspaciosLibres; 
	int Inicio, EspacioLibre = 0;
	
	
    @SuppressWarnings("unchecked")
	public ListaCursor(Class<T> clazz) {
    	this.Datos = (T[]) Array.newInstance(clazz, 1000);
		this.Indice = new int[1000]; 
		Arrays.fill(this.Indice, -1);
		this.EspaciosLibres = new int[1000];  
	}	
	
    //Funcion Inserta
    
    public <T> void INSERTA(T x, int pos, ListaCursor<T> L) {
    	if(!((pos >= 0) && (pos < 1000))) {
    		throw new ArrayIndexOutOfBoundsException("El valor ingresado es menor que 0 o mayor que 1000"); 
    	} 
    	
    }
    
    
	public static void main(String[] args) {
		ListaCursor<Integer> a = new ListaCursor<>(Integer.class); 
		a.INSERTA(1, 100000, a);
	}
 
}
