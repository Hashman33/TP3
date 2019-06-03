package fiuba.algo3.algocraft;

public class PicoPiedra extends Herramienta {

    public PicoPiedra(){
        this.desgaste = new DesgastePorValor(200);
        this.factor = 1.5;
        this.valordesgaste = 4;

    }
    @Override
    public void desgastar(Material material){
        material.desgastarcon(this);
        desgaste.desgastar(this.GetValorDesgaste(),this.factor);

    }


}
