
public class Location {
    private int latitude;
    private int longitude;
    public void changeLocation(int newLat,int newLong) throws BatallaNavalExcepcion{
        if ((newLat<-100 && newLat>100)||(newLong<-100 && newLong>100)){
            throw new BatallaNavalExcepcion(BatallaNavalExcepcion.AL_NORTE_INVALIDO);
        }
        else{    
            latitude=newLat;
            longitude=newLong;
        }
    }

}
