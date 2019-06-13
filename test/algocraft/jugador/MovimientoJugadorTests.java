package algocraft.jugador;

import algocraft.mapa.Mapa;
import algocraft.material.Piedra;
import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;


public class MovimientoJugadorTests {

    Mapa mapa = Mapa.obtenerInstancia();
    private int largo = mapa.getLargo();
    private int ancho = mapa.getAncho();

    // Test de movimiento con el VectorPosicion2I //
    @Test
    public void test01JugadorEnElOrigenSeMueveHaciaAbajo() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(0,1));

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(0, 1)));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test02JugadorEnElOrigenSeMueveHaciaLaDerecha() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(1, 0));

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 0)));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test03JugadorEnElOrigenNoSeMueveHaciaLaIzquierda() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(-1, 0));

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(0, 0)));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test04JugadorEnElOrigenNoSeMueveHaciaArriba() {
        Jugador jugador = new Jugador();

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(0, -1));

        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(0, 0)));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test05JugadorNoSeMueveSobreUnCasilleroOcupado() {
        Jugador jugador = new Jugador(new VectorPosicion2I(1, 1));

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        // Rodeo al jugador de piedras
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(0,0));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(1,0));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(2,0));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(0,1));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(0,2));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(1,2));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(2,2));
        mapa.insertarMaterial(new Piedra(), new VectorPosicion2I(2,1));

        jugador.mover(mapa, new VectorPosicion2I(0, -1));
        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 1)));
        jugador.mover(mapa, new VectorPosicion2I(0, 1));
        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 1)));
        jugador.mover(mapa, new VectorPosicion2I(1, 0));
        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 1)));
        jugador.mover(mapa, new VectorPosicion2I(-1, 0));
        assert(jugador.getPosicion().esIgualA( new VectorPosicion2I(1, 1)));

        // Al final los saco porque es un singleton
        mapa.removerJugador(jugador.getPosicion());
        mapa.removerMaterial(new VectorPosicion2I(0,0));
        mapa.removerMaterial(new VectorPosicion2I(1,0));
        mapa.removerMaterial(new VectorPosicion2I(2,0));
        mapa.removerMaterial(new VectorPosicion2I(0,1));
        mapa.removerMaterial(new VectorPosicion2I(0,2));
        mapa.removerMaterial(new VectorPosicion2I(1,2));
        mapa.removerMaterial(new VectorPosicion2I(2,2));
        mapa.removerMaterial(new VectorPosicion2I(2,1));
    }

    @Test
    public void test06JugadorEnBordeSuperiorSeMueveHaciaArribaYNoSeDesplaza() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(3,0);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(0, -1));

        assert(jugador.getPosicion().esIgualA(posicionInicial));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test07JugadorEnBordeInferiorSeMueveHaciaAbajoYNoSeDesplaza() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(3,19);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(0, 1));

        assert(jugador.getPosicion().esIgualA(posicionInicial));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test08JugadorEnBordeIzquierdoSeMueveHaciaIzquierdaYNoSeDesplaza() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(0,3);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(-1, 0));

        assert(jugador.getPosicion().esIgualA(posicionInicial));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test09JugadorEnBordeDerechoSeMueveHaciaDerechaYNoSeDesplaza() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(19,3);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(1, 0));

        assert(jugador.getPosicion().esIgualA(posicionInicial));

        mapa.removerJugador(jugador.getPosicion());
    }


    @Test
    public void test10JugadorEnBordeSuperiorDerechoNoPuedeDesplazarseParaArribaODerecha() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(ancho - 1,0);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(0, -1));
        jugador.mover(mapa, new VectorPosicion2I(1, 0));

        assert(jugador.getPosicion().esIgualA(posicionInicial));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test11JugadorEnBordeInferiorIzquierdoNoPuedeDesplazarseParaAbajoOIzquierda() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(0, largo - 1);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(0, 1));
        jugador.mover(mapa, new VectorPosicion2I(-1, 0));

        assert (jugador.getPosicion().esIgualA(posicionInicial));

        mapa.removerJugador(jugador.getPosicion());
    }

    @Test
    public void test12JugadorEnBordeInferiorDerechoNoPuedeDesplazarseParaAbajoODerecha() {
        VectorPosicion2I posicionInicial = new VectorPosicion2I(ancho - 1, largo - 1);
        Jugador jugador = new Jugador(posicionInicial);

        Mapa mapa = Mapa.obtenerInstancia();
        mapa.insertarJugador(jugador, jugador.getPosicion());

        jugador.mover(mapa, new VectorPosicion2I(0, 1));
        jugador.mover(mapa, new VectorPosicion2I(1, 0));

        assert (jugador.getPosicion().esIgualA(posicionInicial));

        mapa.removerJugador(jugador.getPosicion());
    }
}
