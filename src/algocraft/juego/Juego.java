package algocraft.juego;

import algocraft.juego.jugador.Jugador;
import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.VectorPosicion2I;

public class Juego {

    private Mapa mapa = Mapa.obtenerInstancia();
    private Jugador jugador = new Jugador();

    public Juego() {

        mapa.iniciarRandom();
        mapa.insertarJugador(jugador);
    }

    public void moverJugador(VectorPosicion2I movimiento) { mapa.moverJugador(jugador, movimiento); }

    public void usarHerramienta() { jugador.usarHerramienta(mapa); }


    public Mapa getMapa() { return this.mapa; }
    public Jugador getJugador() { return this.jugador; }
}
