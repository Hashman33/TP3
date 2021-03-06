package algocraft.juego.mapa;

import algocraft.juego.material.*;
import algocraft.juego.jugador.*;
import algocraft.utilidades.matriz.*;
import algocraft.utilidades.matriz.Celda;
import algocraft.utilidades.VectorPosicion2I;
import java.util.Random;

// Utilizamos patron Singleton
public class Mapa {

    private static Mapa instancia = new Mapa();

    // Medidas en casilleros
    private static final int LARGO = 20;
    private static final int ANCHO = 20;
    private static Matriz tablero;

    public static Mapa obtenerInstancia() {

        if (instancia == null) instancia = new Mapa();
        return instancia;
    }

    public int getAncho() { return ANCHO; }

    public int getLargo() { return  LARGO; }


    private Mapa() {
        this.iniciarNormalizado();
    }

    public void iniciarRandom(){
        tablero = new Matriz(LARGO,ANCHO);
        RandomMap generador = new RandomMap(this, ANCHO, LARGO);
        generador.disponerMaterialMadera(50,30);
        generador.disponerMaterialPiedra(40,25);
        generador.disponerMaterialMetal(20,10);
        generador.disponerMaterialDiamante(10,5);

    }

    public void iniciarNormalizado(){

        tablero =  new Matriz(LARGO, ANCHO);

        for( int i = 0; i < LARGO; i++ ){

            for( int j = 0; j< ANCHO; j++){

                if (i > 0 && i < 3 && j > 6 && j < 14) {
                    this.insertarMaterial(new Metal(), new VectorPosicion2I(j, i));
                }

                else if (i > 2 && i < 6 && j > 16 && j < 19) {
                    this.insertarMaterial(new Diamante(), new VectorPosicion2I(j, i));
                }

                else if (i > 8 && i < 12 && j > 0 && j < 7) {
                    this.insertarMaterial(new Piedra(), new VectorPosicion2I(j, i));
                }

                else if (i > 13 && i < 19 && j > 2 && j < 11) {
                    this.insertarMaterial(new Madera(), new VectorPosicion2I(j, i));
                }
            }
        }

    }

    // Hecho con el VectorPosicion2I //

    // Propuesta de movimiento: Cuando funcione el juego vos apretas una tecla y se mueve. Depende la tecla
    // le pasas un vector distinto y se mueve a donde corresponde
    public boolean moverJugador(Jugador jugador, VectorPosicion2I posicionActual, VectorPosicion2I movimiento) {

        // Tecla arriba: + (0 -1)
        // Tecla abajo: + (0 1)
        // Tecla izquierda: + (-1 0)
        // Tecla derecha: + (1 0)
        // Tambien en diagonal se podria con (1 1), (-1 1), etc.

        VectorPosicion2I nuevaPosicion = posicionActual.sumar(movimiento);

        boolean seColoco = tablero.colocar(jugador, nuevaPosicion);

        if (seColoco) { tablero.limpiarCelda(posicionActual); }

        return seColoco;
    }

    public boolean insertarJugador(Jugador jugador, VectorPosicion2I posicion) {

        if (tablero.colocar(jugador, posicion)) {
            jugador.setCoordenadas(posicion);
            return true;
        }
        return false;
    }

    public void insertarJugador(Jugador jugador) {

        VectorPosicion2I posicion;
        do {
            int posX = new Random().nextInt(ANCHO - 1);
            int posY = new Random().nextInt(LARGO - 1);
            posicion = new VectorPosicion2I(posX, posY);

        }
        while (!tablero.colocar(jugador, posicion));
        jugador.setCoordenadas(posicion);
    }


    public void removerJugador(VectorPosicion2I posicion) {
        tablero.limpiarCelda(posicion);
    }

    public boolean insertarMaterial(Material material, VectorPosicion2I posicion) {
        return tablero.colocar(material, posicion);
    }

    public void removerMaterial(VectorPosicion2I posicion) {
        tablero.limpiarCelda(posicion);
    }

    public Material obtenerMaterial(VectorPosicion2I posicion) {
        return tablero.obtenerMaterial(posicion);
    }

    public Jugador obtenerJugador(VectorPosicion2I posicion) {
        return tablero.obtenerJugador(posicion);
    }

    public void resetear() { instancia = null; }
}

