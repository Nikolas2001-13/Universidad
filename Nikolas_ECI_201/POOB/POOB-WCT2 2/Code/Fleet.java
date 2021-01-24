
import java.util.List;
public class Fleet {
    private String name;
    private Board board;
    private List<Machine> machines;
    private List<Marine> marines;
    public void alNorte() throws BatallaNavalExcepcion{
        int newLat=1;
        for (Machine m: machines){
            m.moveMachine(newLat,0);
        }
    }

}
