package algocraft.juego.jugador.herramienta;

import algocraft.juego.jugador.desgaste.DesgastePorValor;
import algocraft.juego.material.Material;

public class Mano extends Herramienta {

    public Mano(){
        this.texturaUrl = "/recursos/texturas/stick.png";
        this.sonidoUrl = "/recursos/sonidos/mano.mp3";
        this.desgaste = new DesgastePorValor(Double.POSITIVE_INFINITY);
        this.factor = 1;
        this.fuerza = 0;
    }
    @Override
    public void desgastar(Material material){
        desgaste.desgastarHerramienta(this);
        material.desgastarCon(this);
    }

}
