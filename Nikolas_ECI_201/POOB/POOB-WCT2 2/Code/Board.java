import java.util.List;
public class Board {
    private List<Fleet> fleets;
    public int alNorte()throws BatallaNavalExcepcion{
        int cont=0;
        for(Fleet f: fleets){
            f.alNorte();
            cont++;
        }
        return cont;
    }
}
