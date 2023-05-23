
package ar.edu.ort.tp1.tdas.ejercicios.ejercicio4;
/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class Pelota {

    private String codigo;
    private TipoPelota tipo;
    
	public Pelota(String codigo, TipoPelota tipo) {
		super();
		this.codigo = codigo;
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "P" + tipo.name().charAt(0);
	}
	
	protected TipoPelota getTipo() {
		return tipo;
	}

	public boolean mismoCodigo(String codigo) {
		return this.codigo.equals(codigo);
	}
    
    
    
}