package aplicacion;


public class Turtle extends Poder {
    /**
     * constructor del poder
     * @param p
     */
    public Turtle(Poong p){
        super(p);
    }
    /**
     * define el jugador afectado 
     */
    @Override
    public void power(){
        if(pongsito.getBall().getBounds().intersects(getBounds())){
            int  p =pongsito.getBall().getNX();
            if(p<0){
                slow(true);
            }else{
                slow(false);
            }
            super.bloque(pongsito.getBall().getNX());
            super.killMePlis();
        }
    }
    /**
     * manda al jugador al metodo que le pone el poder
     * @param p1
     */
    public void slow(boolean p1){
        if(p1){pongsito.getp1().slow();
        }else{pongsito.getp2().slow();}   
    }
}