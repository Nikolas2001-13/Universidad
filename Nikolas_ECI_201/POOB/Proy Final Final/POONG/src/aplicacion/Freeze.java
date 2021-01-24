package aplicacion;

public class Freeze extends Poder {
    /**
     * constructor de la  sorpresa  
     * @param p
     */
    public Freeze(Poong p){
        super(p);
    }
    /**
     * metodo qye verfica el jugador afectado por el poder
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
     * redirecciona la metodo slow
     * @param p1
     */
    public void slow(boolean p1){
        if(p1){pongsito.getp1().freeze();
        }else{pongsito.getp2().freeze();}   
    }
    
}