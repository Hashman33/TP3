package algocraft.juego.jugador;

import algocraft.juego.jugador.herramienta.*;
import algocraft.juego.mapa.*;

import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JugadorTests {


    @Test
    public void test01JugadorIniciaConHachaDeMadera() {

        Jugador jugador = new Jugador();

        assert (jugador.herramientaEquipada() instanceof Hacha);
        assert (((Hacha) jugador.herramientaEquipada()).getMaterial() instanceof HerramientaMadera);
    }

    @Test
    public void test02JugadorSeInsertaEnElOrigenDelMapaCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(0, 0)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(0, 0)));

        mapa.resetear();
    }

    @Test
    public void test03JugadorSeInsertaEnElMapaEnPosicionDefinidaCorrectamente() {
        Jugador jugador = new Jugador(new VectorPosicion2I(14, 14));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(14, 14)));
        assertEquals(jugador, mapa.obtenerJugador(new VectorPosicion2I(14, 14)));

        mapa.resetear();
    }

    @Test
    public void test04JugadorSeInsertaEnElMapaEnPosicionRandomCorrectamente() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador);

        assertEquals(jugador, mapa.obtenerJugador(jugador.getPosicion()));

        mapa.resetear();
    }


}