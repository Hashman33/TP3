package fiuba.algo3.algocraft;

public class  HachaMadera extends Herramienta {


    public HachaMadera(){
        this.desgaste = new DesgastePorValor(100);
        this.factor = 1;
        this.valordesgaste = 2;

    }

    @Override
    public void desgastar(Material material){
        material.desgastarcon(this);
        desgaste.desgastar(this.GetValorDesgaste(),this.factor);

    }

}
