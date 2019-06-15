package algocraft.herramienta;

import algocraft.desgaste.DurabilidadCeroException;
import algocraft.material.*;
import algocraft.matriz.Matriz;
import algocraft.utilidades.VectorPosicion2I;

public class Hacha extends Herramienta{

    protected MaterialHerramienta material;

    public Hacha(MaterialHerramienta material){
        this.material = material;
        material.inicializarHacha(this);
        crearMatrizCrafteo(material.getMaterial());
    }

    @Override
    public void desgastar(Material material){

        try {
            desgaste.desgastarHerramienta(this);
        } catch (DurabilidadCeroException e) {
            throw new HerramientaEstaRotaException();
        }
        material.desgastarCon(this);
    }

    public MaterialHerramienta getMaterial(){ return this.material; }

    protected void crearMatrizCrafteo(Material material) {
        matrizCrafteo = new Matriz(new VectorPosicion2I(3, 3));

        matrizCrafteo.colocar(material, new VectorPosicion2I(0,0));
        matrizCrafteo.colocar(material, new VectorPosicion2I(1,0));
        matrizCrafteo.colocar(material, new VectorPosicion2I(0,1));
        matrizCrafteo.colocar(new Madera(), new VectorPosicion2I(1,1));
        matrizCrafteo.colocar(new Madera(), new VectorPosicion2I(1,2));
    }
}
