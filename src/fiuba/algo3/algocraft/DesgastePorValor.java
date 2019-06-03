package fiuba.algo3.algocraft;

public class DesgastePorValor extends Desgaste{

    public DesgastePorValor(int durabilidadInicial) {
        this.durabilidad = durabilidadInicial;
    }


    public void desgastar(int valor, double factor) {
        if (durabilidad == 0) throw new DurabilidadCeroException();
        durabilidad -= valor * factor;
        if (durabilidad <= 0) durabilidad = 0;
    }

}

