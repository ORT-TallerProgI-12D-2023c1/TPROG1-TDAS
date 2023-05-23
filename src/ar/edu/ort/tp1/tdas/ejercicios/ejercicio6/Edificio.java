package ar.edu.ort.tp1.tdas.ejercicios.ejercicio6;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class Edificio {

    public static final int CANT_COLAS = 4;
    private ColaDeFacturas[] colasDeFacturas;
    
    public void catalogar(PilaDeFacturas piladefacturas) {
        while (!piladefacturas.isEmpty()) {
        	Factura f = piladefacturas.pop();
        	colasDeFacturas[f.getTipo().ordinal()].add(f);       	
        	// TIENE QUE QUEDAR ORDENADA POR MES ASCENDENTE
        	// EN UDS. CONFÍO ;)
        }
    }

    public double[] montoAAbonarPorTipo() {
    	double[] totales = new double[TipoFactura.values().length];
    	for (int i = 0; i < colasDeFacturas.length; i++) {
			ColaDeFacturas colaActual = colasDeFacturas[i];
			acumularEnCola(colaActual, totales);			
		}
        return totales;
    }

	private void acumularEnCola(ColaDeFacturas cf, double[] totales) {
		Factura fCentinela = new Factura();
		cf.add(fCentinela);
		Factura fActual = cf.remove();
		while (fActual != fCentinela) {
			// Proceso...
			totales[fActual.getTipo().ordinal()] += fActual.getMonto();
			cf.add(fActual);
			fActual = cf.remove();
		}		
	}
    
    

}