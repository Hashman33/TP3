package algocraft.vista;

import algocraft.juego.mapa.Mapa;
import algocraft.utilidades.VectorPosicion2I;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class VistaMapa implements Dibujable {

    private Mapa mapa;
    private ContenedorJuego contenedorJuego;
    private Image pasto;
    private GridPane gridPane;

    public VistaMapa(Mapa mapa, ContenedorJuego contenedorJuego) {
        this.contenedorJuego = contenedorJuego;
        this.mapa = mapa;
        this.pasto = new Image("/recursos/texturas/pasto.jpg", 32, 32, false, true);
        this.gridPane = new GridPane();
    }

    @Override
    public void dibujar() {

        for (int i = 0; i < this.mapa.getLargo(); i++) {
            for (int j = 0; j < this.mapa.getAncho(); j++) {
                dibujarPosicion(i, j);
            }
        }
        this.contenedorJuego.setCenter(gridPane);

    }

    public void dibujarPosicion(int i, int j) {

        if (i >= mapa.getAncho() || i < 0 || j >= mapa.getLargo() || j < 0) return;

        VectorPosicion2I posicion = new VectorPosicion2I(i, j);
        ImageView imageView = this.mapa.obtenerMaterial(posicion) != null ? this.mapa.obtenerMaterial(posicion).getTextura() : null;

        if (this.mapa.obtenerJugador(posicion) != null) {
            imageView = this.mapa.obtenerJugador(posicion).getTextura();
        }

        if (imageView == null) {
            imageView = new ImageView(this.pasto);
        }
        this.gridPane.add(imageView, i, j);
    }

}
