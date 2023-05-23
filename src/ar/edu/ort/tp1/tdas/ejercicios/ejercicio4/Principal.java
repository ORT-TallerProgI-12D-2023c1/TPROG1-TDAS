package ar.edu.ort.tp1.tdas.ejercicios.ejercicio4;

import java.util.ArrayList;
import java.util.Arrays;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class Principal {

    
    public static void main(String[] args) {
        DeptoDeDeportes depto = new DeptoDeDeportes();
        
        for (int i = 0; i < 3; i++) {
        	depto.agregarPelota( new Pelota("F" + (i+1), TipoPelota.FUTBOL));
		}
        
        for (int i = 0; i < 6; i++) {
        	depto.agregarPelota( new Pelota("V" + (i+1), TipoPelota.VOLEY));
		}
        
        for (int i = 0; i < 4; i++) {
        	depto.agregarPelota( new Pelota("B" + (i+1), TipoPelota.BASQUET));
		}
        
        
        depto.mostrarTodasLasPelotas();
        depto.verPelotasEnTopes();
        System.out.println("-------");
        System.out.println( depto.buscarPelota("F3") );
        System.out.println( depto.buscarPelota("V1") );
        System.out.println( depto.buscarPelota("B2") );
        System.out.println( depto.buscarPelota("ZZ") );
        
        System.out.println(Arrays.toString(depto.pelotasPorTipo()));
        
        
    }

}