package algocraft.matriz;

import algocraft.jugador.Jugador;
import algocraft.material.Madera;
import algocraft.material.Piedra;
import algocraft.utilidades.VectorPosicion2I;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CeldaTests {

    @Test
    public void test01CeldaSeIniciaVacia(){
        Celda celda  = new Celda();
        assert(celda.estaVacia());
    }


    @Test
    public void test02CeldaSeLeAgregaUnMaterialYnoEstaVacia(){
        Celda celda = new Celda();
        celda.colocarMaterial(new Madera());
        assert(!celda.estaVacia());
    }

    @Test
    public void test03CeldaSeLeAgregaUnMaterialCorrectamenteACelda(){

        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        assertEquals(madera, celda.obtenerMaterial());
    }

    @Test
    public void test04CeldaSeLeAgregaUnJugadorCorrectamenteACelda(){

        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);

        assertEquals(jugador, celda.obtenerJugador());
    }

    @Test
    public void test05CeldaSeIntentaAgregarUnMaterialEnUnaCeldaOcupadaPorMaterialYnoSeModifica(){
        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);
        Madera madera2 = new Madera();
        celda.colocarMaterial(madera2);

        assertEquals(madera, celda.obtenerMaterial());
    }

    @Test
    public void test06CeldaSeIntentaAgregarUnMaterialEnUnaCeldaOcupadaPorJugadorYnoSeModifica(){
        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        assertEquals( jugador, celda.obtenerJugador());
    }

    @Test
    public void test07CeldaSeRemueveMaterialCorrectamente(){
        Celda celda = new Celda();
        Madera madera = new Madera();
        celda.colocarMaterial(madera);

        celda.removerMaterial();

        assert(celda.estaVacia());
    }

    @Test
    public void test08CeldaSeRemueveJugadorCorrectamente(){

        Celda celda = new Celda();
        Jugador jugador = new Jugador();
        celda.colocarJugador(jugador);

        celda.removerJugador();

        assert(celda.estaVacia());
    }

    @Test
    public void test09ComparoDosMatrices(){

        Matriz matriz1 = new Matriz(new VectorPosicion2I(3,3));
        Matriz matriz2 = new Matriz(new VectorPosicion2I(3,3));

        // Pico de piedra
        matriz1.colocar(new Piedra(), new VectorPosicion2I(0,0));
        matriz1.colocar(new Piedra(), new VectorPosicion2I(1,0));
        matriz1.colocar(new Piedra(), new VectorPosicion2I(2,0));
        matriz1.colocar(new Madera(), new VectorPosicion2I(1,1));
        matriz1.colocar(new Madera(), new VectorPosicion2I(1,2));

        // Pico de piedra
        matriz2.colocar(new Piedra(), new VectorPosicion2I(0,0));
        matriz2.colocar(new Piedra(), new VectorPosicion2I(1,0));
        matriz2.colocar(new Piedra(), new VectorPosicion2I(2,0));
        matriz2.colocar(new Madera(), new VectorPosicion2I(1,1));
        matriz2.colocar(new Madera(), new VectorPosicion2I(1,2));

        assert(matriz1.esIgualA(matriz2));

        matriz2.colocar(new Madera(), new VectorPosicion2I(2,2));

        assert(!matriz1.esIgualA(matriz2));

        matriz2.remover(new VectorPosicion2I(2,2));

        assert(matriz1.esIgualA(matriz2));

    }
}
