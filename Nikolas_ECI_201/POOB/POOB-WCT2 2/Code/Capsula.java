
/**
 * Write a description of class Capsula here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capsula extends Nodriza
{
    private boolean isViva;

    /**
     * Constructor for objects of class Capsula
     */
    public Capsula()
    {
        isViva=true;
    }
    
    private String autodestruccion(){
        if(!getIsViva()){
            this.isViva = false;
            return "Nodriza Muerta";
        }
        return "";
    }
}
