package ar.edu.ort.tp1.tdas.ejercicios.ejercicio4;

/**
* Código generado por la app UXFtoJava by Charly Cimino
* @see https://github.com/CharlyCimino/uxf-to-java
*/
public class DeptoDeDeportes {

    private static final int CANT_PILAS = 3;
    private PilaDePelotas[] pilasDePelotas;
    
    public DeptoDeDeportes() {
    	this.pilasDePelotas = new PilaDePelotas[CANT_PILAS];
    	crearPilas();
    }
    
    private void crearPilas() {
    	for (int i = 0; i < pilasDePelotas.length; i++) {
			pilasDePelotas[i] = new PilaDePelotas(5);
		}
    }
    
    public void verPelotasEnTopes() {
        for (int i = 0; i < pilasDePelotas.length; i++) {
        	System.out.println(pilasDePelotas[i].peek());			
		}
    }

    public boolean agregarPelota(Pelota pelota) {
    	PilaDePelotas pilaConLugar = buscarPilaLibre();
    	if (pilaConLugar != null) {
    		pilaConLugar.push(pelota);
    	}
    	return pilaConLugar != null; 	        
    }

    private PilaDePelotas buscarPilaLibre() {
    	PilaDePelotas encontrada = null;
        int i = 0;
        while(i < CANT_PILAS && pilasDePelotas[i].isFull()) {
        	i++;
        }
        if (i < CANT_PILAS) {
        	encontrada = pilasDePelotas[i];
        }        	
        return encontrada;
	}
    
    public void mostrarTodasLasPelotas() {
    	for (int i = 0; i < pilasDePelotas.length; i++) {
    		System.out.println("----------------------------");
			mostrarPila(pilasDePelotas[i]);
			System.out.println("\n----------------------------");
		}
    }
    
    private void mostrarPila(PilaDePelotas pp) {
    	PilaDePelotas pilaAux = new PilaDePelotas();
    	while(!pp.isEmpty()) {
    		Pelota pActual = pp.pop();
    		pilaAux.push(pActual);    		
    	}
    	System.out.print("| ");
    	while(!pilaAux.isEmpty()) {
    		Pelota pActual = pilaAux.pop();
    		System.out.print(pActual + " | ");
    		pp.push(pActual);
    	}
    }

	public Pelota buscarPelota(String codigo) {
        Pelota buscada = null;
        int i = 0;
        while (i < CANT_PILAS && buscada == null) {
        	buscada = buscarPelotaEnPila(pilasDePelotas[i], codigo);
        	i++;
        }
        return buscada;
    }
	
	private Pelota buscarPelotaEnPila(PilaDePelotas pp, String codigo) {
		Pelota encontrada = null;
		PilaDePelotas pilaAux = new PilaDePelotas();
    	while(!pp.isEmpty() && encontrada == null) {
    		Pelota pActual = pp.pop();
    		pilaAux.push(pActual); 
    		if(pActual.mismoCodigo(codigo)) {
    			encontrada = pActual;
    		} /*else { Si se desea quitarla
    			pilaAux.push(pActual);    			
    		}*/
    	}
    	while(!pilaAux.isEmpty()) {
    		pp.push(pilaAux.pop());
    	}
    	return encontrada;
	}

    public int[] pelotasPorTipo() {
        int[] cantPelotasPorTipo = new int[TipoPelota.values().length];
        for (int i = 0; i < pilasDePelotas.length; i++) {
        	contarPelotasEnPila(pilasDePelotas[i], cantPelotasPorTipo);
		}
        return cantPelotasPorTipo;
    }

	private void contarPelotasEnPila(PilaDePelotas pp, int[] cantPelotasPorTipo) {
		PilaDePelotas pilaAux = new PilaDePelotas();
    	while(!pp.isEmpty()) {
    		Pelota pActual = pp.pop();
    		pilaAux.push(pActual);  
    		cantPelotasPorTipo[pActual.getTipo().ordinal()]++;
    	}
    	while(!pilaAux.isEmpty()) {
    		pp.push(pilaAux.pop());
    	}
	}

}