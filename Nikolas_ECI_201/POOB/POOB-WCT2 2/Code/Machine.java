
public abstract class Machine{
    private Location location;
    public void moveMachine(int newLat ,int newLong)throws BatallaNavalExcepcion{
        location.changeLocation(newLat,newLong);
    }
}
