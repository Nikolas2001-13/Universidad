package aplicacion;

public class FastBall extends Poder {
    /**
     * constructor de la clase Poong
     * @param p
     */
    public FastBall(Poong p){
        super(p);
    }
    /**
     * manda al metodo correspondiente al poder
     */
    @Override
    public void power(){
        if(pongsito.getBall().getBounds().intersects(getBounds())){
            pongsito.getBall().fast();
            super.bloque(pongsito.getBall().getNX());
            super.killMePlis();
        }
    }
}