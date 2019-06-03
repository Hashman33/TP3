package fiuba.algo3.algocraft;

public class Diamante extends Material {


    public Diamante(){
        this.desgaste = new DesgastePorValor(100);

    }
    @Override
    public boolean desgastarCon(Hacha hacha){
        return false;
    }


    @Override
    public boolean desgastarCon(Pico pico){
        return false;
    }


    @Override
    public boolean desgastarCon(PicoFino picoFino){
        this.desgaste.desgastar(picoFino.getFuerza(), 1);
        return true;
    }
}
