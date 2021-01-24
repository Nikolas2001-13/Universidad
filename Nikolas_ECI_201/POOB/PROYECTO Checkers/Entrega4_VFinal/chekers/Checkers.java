package chekers;
import shapes.*;
import javax.swing.JOptionPane;
import java.util.*;

/**
 * Clase para la creacion de todo
 * 
 * @author (Nikolas Bernal - Juan Pablo Contreras) 
 * @version (16/02/2020)
 */
public class Checkers
{
    private int contador;
    public Tablero configuracion;
    public Tablero juego;
    private boolean juegoActivo;
    private boolean wasCorrect;
    private Circle conf;
    private Circle game;
    private HashMap<String,String> guardar;  
    private int xsel;
    private int ysel;
    private String colorSel;
    /**
     * Constructor for objects of class Checkers
     */
    public Checkers()
    {
        // initialise instance variables
        contador = 0;
        configuracion = new Tablero();
        juego = new Tablero();
        juego.moveTablero();
        juegoActivo = false;        
        int moveFichas=0;
        conf = new Circle("green");
        conf.moveHorizontal(-10);
        conf.moveVertical(260);
        conf.makeVisible();
        game = new Circle("green");
        game.moveHorizontal(400);
        game.moveVertical(260);
        guardar=new HashMap();
    }    
    /**
     * Selecciona un ficha del juego
     * @param row,column
     */
    public void select(int row, int column){
        xsel =column ;
        ysel =row ;
        if(juegoActivo){
            if (juego.fichas[row-1][column-1] != null ){      
                String color = juego.fichas[row-1][column-1].getColor();
                if(color.equals("white")){
                    juego.fichas[row-1][column-1].changeColor("green"); 
                    colorSel = "white";
                }else{
                    juego.fichas[row-1][column-1].changeColor("green");
                    colorSel = "black";
                } 
              wasCorrect=true;
            }else if(juego.rey[row-1][column-1] != null ){
                String color = juego.rey[row-1][column-1].getColor();
                if(color.equals("white")){
                    juego.rey[row-1][column-1].changeColor("green");
                    colorSel = "white";
                }else{
                    juego.rey[row-1][column-1].changeColor("green");
                    colorSel = "black";
                } 
             wasCorrect=true;
            }else{wasCorrect=false;JOptionPane.showMessageDialog(null, "no hay una ficha es esta casilla","ERROR!",JOptionPane.ERROR_MESSAGE);}
        }else{
            JOptionPane.showMessageDialog(null, "solo podra usar el metodo shift y jump");
            if (configuracion.fichas[row-1][column-1] != null ){      
                String color = configuracion.fichas[row-1][column-1].getColor();
                if(color.equals("white")){
                    configuracion.fichas[row-1][column-1].changeColor("green"); 
                    colorSel = "white";
                }else{
                    configuracion.fichas[row-1][column-1].changeColor("green");
                    colorSel = "black";
                } 
                wasCorrect=true;
            }else if(configuracion.rey[row-1][column-1] != null ){
                String color = configuracion.rey[row-1][column-1].getColor();
                if(color.equals("white")){
                    configuracion.rey[row-1][column-1].changeColor("green");
                    colorSel = "white";
                }else{
                    configuracion.rey[row-1][column-1].changeColor("green");
                    colorSel = "black";
                }
                wasCorrect=true;
            }else{wasCorrect=false;JOptionPane.showMessageDialog(null, "no hay una ficha es esta casilla","ERROR!",JOptionPane.ERROR_MESSAGE);}
        }
    }
    /**
     * mueve las fichas en la zona de configuracion.
     * @param top , right
     */
    public void shift(boolean top, boolean right){
        if(!juegoActivo){
            if(top && right){
                if(configuracion.fichas[ysel-1][xsel-1] != null){
                    if(ysel-2<0||xsel==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.add(ysel-2,xsel,colorSel);     
                    }
                }else{
                    if(ysel-2<0||xsel==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.addK(ysel-2,xsel,colorSel);    
                    }
                }                
            }if(top && !right){
                if(configuracion.fichas[ysel-1][xsel-1] != null){
                    if(xsel-2<0||ysel-2<0){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1); 
                        configuracion.add(ysel-2,xsel-2,colorSel);
                    }
                }else{
                    if(xsel-2<0||ysel-2<0){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1); 
                        configuracion.addK(ysel-2,xsel-2,colorSel);
                    }
                }
            }if(!top && right){
                if(configuracion.fichas[ysel-1][xsel-1] != null){
                    if(xsel==8||ysel==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1); 
                        configuracion.add(ysel,xsel,colorSel);
                    }
                }else{
                    if(xsel==8||ysel==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1); 
                        configuracion.addK(ysel,xsel,colorSel);
                    }
                }
            }if(!top && !right){
                 if(configuracion.fichas[ysel-1][xsel-1] != null){
                    if(xsel-2<0||ysel==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1); 
                        configuracion.add(ysel,xsel-2,colorSel); 
                    }
                } else{
                    if(xsel==8||ysel<0){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1); 
                        configuracion.addK(ysel,xsel-2,colorSel);
                    }
                }
            }
            wasCorrect=true;
        }else{
            JOptionPane.showMessageDialog(null, "Esta en zona de juego","ERROR!",JOptionPane.ERROR_MESSAGE);
            wasCorrect = false;
        }
    }
    /**
     * mueve las fichas del tablero de configuracion  en forma de salto
     * @param top,right
     */
    public void jump(boolean top, boolean right){
        if(!juegoActivo){
            if(top && right){
                if(configuracion.fichas[ysel-1][xsel-1] != null){
                    if(ysel-3<0||xsel+1==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.add(ysel-3,xsel+1,colorSel);  
                    }
                }else{
                    if(ysel-3<0||xsel+1==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.addK(ysel-3,xsel+1,colorSel);
                    }
                }                
            }if(top && !right){
                if(configuracion.fichas[ysel-1][xsel-1] != null){
                    if(xsel-3<0||ysel-3<0){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.add(ysel-3,xsel-3,colorSel);
                    }
                }else{
                    if(xsel-3<0||ysel-3<0){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.addK(ysel-3,xsel-3,colorSel);
                    }
                }
            }if(!top && right){
                if(configuracion.fichas[ysel-1][xsel-1] != null){
                    if(xsel+1==8||ysel+1==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.add(ysel+1,xsel+1,colorSel);
                    }
                }else{
                    if(xsel+1==8||ysel+1==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.addK(ysel+1,xsel+1,colorSel);
                    }
                }
            }if(!top && !right){
                 if(configuracion.fichas[ysel-1][xsel-1] != null){
                    if(xsel-3<0||ysel+1==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.add(ysel+1,xsel-3,colorSel);
                    }
                }if(configuracion.rey[ysel-1][xsel-1] != null){
                    if(xsel-3<0||ysel+1==8){JOptionPane.showMessageDialog(null, "movimiento no valido","ERROR!",JOptionPane.ERROR_MESSAGE);}else{
                        configuracion.remove(ysel-1,xsel-1);
                        configuracion.addK(ysel+1,xsel-3,colorSel);
                    }
                }
            }
            wasCorrect=true;
        }else{
            JOptionPane.showMessageDialog(null, "Esta en zona de juego","ERROR!",JOptionPane.ERROR_MESSAGE);
            wasCorrect = false;
        }
    }
    /**
     * mueve un ficha del juego
     * @param notation,row,column
     */
    public void move(String notation){
        if(juegoActivo){
            int x = 0; int i1 =0;int j1 =0;int i2 =0; int j2 =0; String num1=""; String num2="";int contx=0;
            for (int n = 0; n<notation.length();n++) {if(notation.charAt(n)=='x' ||notation.charAt (n)=='-'){x =n;}if(notation.charAt(n)=='x'){contx+=1;}}
            for(int n = 0;n<x;n++) {if(notation.charAt(n)!='x'){num1+=Character.toString(notation.charAt(n));}else{break;}}
            for(int n = x+1;n<notation.length();n++) {if(notation.charAt(n)!='x'){num2+=Character.toString(notation.charAt(n));}}
             i1= filaequi(num1);j1= columequi(num1);i2=filaequi(num2);j2= columequi(num2);
             if((juego.fichas[i1-1][j1-1]!=null && juego.fichas[i1-1][j1-1].getType()!=("Libertarian"))||(juego.rey[i1-1][j1-1]!=null && (juego.rey[i1-1][j1-1].getColor()!=("cyan")||juego.rey[i1-1][j1-1].getColor()!=("blue")))){
                if((juego.fichas[i1-1][j1-1]!=null && juego.fichas[i1-1][j1-1].getType().equals("Lazy"))||(juego.rey[i1-1][j1-1]!=null && (juego.rey[i1-1][j1-1].getColor().equals("orange")||juego.rey[i1-1][j1-1].getColor().equals("yellow")))){
                    if(contx>1){JOptionPane.showMessageDialog(null, "Esta haciendo un movimiento invalido para una ficha Lazy","ERROR!",JOptionPane.ERROR_MESSAGE); return;}
                }
                if(contx>0){matar(num1,num2);}
            }
                if(juego.fichas[i1-1][j1-1]!= null){
                    String type = juego.fichas[i1-1][j1-1].getType();
                    String newCol =juego.fichas[i1-1][j1-1].getColor();
                    juego.remove(i1-1,j1-1);
                    juego.seeType(type,i2,j2,newCol);
                    juego.fichas[i2-1][j2-1].moveHorizontal(350);
                    juego.makeVisible();
                    if (type!=("Superman")){
                        juego.toKing();
                    }
                }if(juego.rey[i1-1][j1-1]!= null){
                    String newCol =juego.rey[i1-1][j1-1].getColor();
                    juego.remove(i1-1,j1-1);
                    juego.addK(i2-1,j2-1,newCol);
                    juego.rey[i2-1][j2-1].moveHorizontal(350);
                    juego.makeVisible();
                }
              hurried(i1-1,j1-1,i2-1,j2-1);
              wasCorrect = true;
        }else{
            JOptionPane.showMessageDialog(null, "Esta en zona de configuracion","ERROR!",JOptionPane.ERROR_MESSAGE);
            wasCorrect = false;
        }
    }
    int cont1=0;
    int cont2=0;
    /**
     * adiciona una ficha al tablero de configuracion
     * @param king,row,column
     */
    public void add(boolean king, int row, int column){
        if(!juegoActivo){
            if(king){
                if ((row%2!=0 && column%2!=0)||(row%2==0 && column%2==0)||(configuracion.rey[row-1][column-1]!=null)||(configuracion.fichas[row-1][column-1]!=null)){
                    JOptionPane.showMessageDialog(null, "Casilla no valida","ERROR!",JOptionPane.ERROR_MESSAGE);
                    wasCorrect = false;
                }
                else{
                    String y = JOptionPane.showInputDialog("Color Black(b) or White(w)");
                    if( y.equals("w")){ 
                        if(cont1<12){
                            configuracion.addK(row-1,column-1,"white");
                            cont1 +=1;
                        }else{
                            JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                            wasCorrect = false;
                            return;
                        }
                    }
                    else if( y.equals("b")){
                        if (cont2<12){
                            configuracion.addK(row-1,column-1,"black");
                            cont2 +=1;
                        }else{
                            JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                            wasCorrect = false;
                            return;
                        }
                    }
                    configuracion.rey[row-1][column-1].makeVisible();
                    wasCorrect = true;
                }
            }else{
                if ((row%2!=0 && column%2!=0)||(row%2==0 && column%2==0)||(configuracion.fichas[row-1][column-1]!=null)||(configuracion.rey[row-1][column-1]!=null)){
                    JOptionPane.showMessageDialog(null, "Casilla no valida","ERROR!",JOptionPane.ERROR_MESSAGE);
                    wasCorrect = false;
                }
                else{
                    String y = JOptionPane.showInputDialog("Color Black(b) or White(w)");
                    if( y.equals("w")){
                        if (cont2<12){
                            configuracion.add(row-1,column-1,"white");
                            cont1 +=1;
                        }else{
                            JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                            wasCorrect = false;
                            return;
                        }
                    }
                    else if( y.equals("b")){
                        if (cont2<12){
                            configuracion.add(row-1,column-1,"black");
                            cont2 +=1;
                        }else{
                            JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                            wasCorrect = false;
                            return;
                        }
                    }
                    configuracion.fichas[row-1][column-1].makeVisible();
                    wasCorrect = true;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Esta en zona de juego","ERROR!",JOptionPane.ERROR_MESSAGE);
            wasCorrect = false;
        }
    }
    /**
     * adiciona una ficha segun el tipo al tablero de configuracion
     * @param type,king,row,column
     */
    public void add(String type, boolean king, int row, int column){
        if (!juegoActivo){
            if ((row%2!=0 && column%2!=0)||(row%2==0 && column%2==0)||(configuracion.fichas[row-1][column-1]!=null)||(configuracion.rey[row-1][column-1]!=null)){
                    JOptionPane.showMessageDialog(null, "Casilla no valida","ERROR!",JOptionPane.ERROR_MESSAGE);
                    wasCorrect = false;}
            else{
                if(configuracion.fichas[row][column]==null){
                    String y = JOptionPane.showInputDialog("Color Black(b) or White(w)");
                    String color = "";
                    if( y.equals("w")){color="white";cont1 +=1;}else{color="black";cont2 +=1;}
                    if ((y.equals("w") && cont1<=12) || (y.equals("b") && cont2<=12)){
                        if(king){
                            if (type!=("Superman")){
                                configuracion.addK2(type,row,column,color);
                            }
                            else{
                                JOptionPane.showMessageDialog(null, "Superman no puede ser rey","ERROR!",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else{
                            configuracion.seeType(type,row,column,color);
                        } 
                    }else{
                        JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                        wasCorrect = false;
                        return;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "Casilla no valida","ERROR!",JOptionPane.ERROR_MESSAGE);
                    wasCorrect = false;
                }
            }
            }
        else{
            JOptionPane.showMessageDialog(null, "Esta en zona de juego","ERROR!",JOptionPane.ERROR_MESSAGE);
            wasCorrect = false;
        }
    }
    
    /**
     * Adiciona una lista de fichas del mismo tipo
     * @param type el tipo de la ficha
     * @para men lista de las fichas
     */
    
    public void add(String type, int[][] men){
        for(int i=0;i<men.length;i++){
            add(type,false,men[i][0],men[i][1]);
            
        }
    }   
    /**
     * adiciona una ficha tipo men al juego
     * @param 
     */
    public void add(int[][] men){
        if(!juegoActivo){
            for (int i=0;i<men.length;i++){
                int row=men[i][0];
                int column=men[i][1];                
                if ((row%2!=0 && column%2!=0)||(row%2==0 && column%2==0)||(configuracion.fichas[row-1][column-1]!=null)||(configuracion.rey[row-1][column-1]!=null)){
                    JOptionPane.showMessageDialog(null, "Casilla no valida","ERROR!",JOptionPane.ERROR_MESSAGE);
                    wasCorrect = false;
                }
                else{
                    String y = JOptionPane.showInputDialog("Color Black(b) or White(w)");
                    if( y.equals("w")){
                        if (cont1<12){
                            configuracion.add(row-1,column-1,"white");
                            cont1 +=1;
                       }else{
                            JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                            wasCorrect = false;
                            return;
                        }
                    }
                    else if( y.equals("b")){
                        if (cont2<12){
                            configuracion.add(row-1,column-1,"black");
                            cont2 +=1;
                        }else{
                            JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                            wasCorrect = false;
                            return;
                        }
                    }                    
                    configuracion.fichas[row-1][column-1].makeVisible();
                    wasCorrect = true;
                }
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Esta en zona de juego","ERROR!",JOptionPane.ERROR_MESSAGE);
            wasCorrect = false;
        }
    }
    /**
     * cosulta si la ultima accion realizada fue valida o no
     * @return boolean
     */
    public boolean ok(){
        if(wasCorrect){
            JOptionPane.showMessageDialog(null, "La ultima operacion fue correcta");
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "La ultima operacion fue incorrecta");
            return false;
        }       
    }
    /**
     * cierra todo
     */
    public void finish(){
        System.exit(0);
    }
    int cont2w = 0;
    int cont2b = 0;
    /**
     * consulta el numero de fichas en cada tablero
     * @return String
     */
    public String consult(){
        cont2w = 0;
        cont2b = 0;
        for(int j =0; j<=7;j++){
            for(int i =0; i<=7;i++){                    
                if(juego.fichas[j][i] != null&&juego.fichas[j][i].isVisible){
                    if(juego.fichas[j][i].getColor() == "black"){cont2b+=1;
                    }else if (juego.fichas[j][i].getColor() == "white"){cont2w+=1;
                    } 
                }
                if(juego.rey[j][i] != null&&juego.rey[j][i].isVisible){
                    if(juego.rey[j][i].getColor() == "black"){cont2b+=1;
                    }else{cont2w+=1;}
                }                                                                        
            }
        } 
        String confgW=String.valueOf(cont1);
        String confgB=String.valueOf(cont2);
        String gameW=String.valueOf(cont2w);
        String gameB=String.valueOf(cont2b);
        return ("En la zona de configuracicon jWhite tiene: "+confgW+" y jBlack tiene: "+confgB+". Y en la zona de juego jWhite tiene: "+gameW+" y el jugador jBlack tiene: "+gameB+" .");
    }

    /**
     * hace invisible todo
     */
    public void makeInvisible(){
        configuracion.makeInvisible();
        juego.makeInvisible();
    }

    /**
     * hace visible todo
     */
    public void makeVisible(){
        configuracion.makeVisible();
        juego.makeVisible();
    }
    /**
     * cambia el tablero activo
     */
    public void swap(){
        contador +=1;
        if(juegoActivo){
            juegoActivo = false;
            conf.makeVisible();
            game.makeInvisible();
        }else{
            juegoActivo =true;
            conf.makeInvisible();
            game.makeVisible();
            if(contador <=1){copy();} 
        }
    }
    /**
     * copia las fichas del tablero de configuracion al tablero de juego.
     */
    private void copy(){
            for(int j =0; j<=7;j++){
                for(int i =0; i<=7;i++){                    
                    if(juego.fichas[j][i] != null){juego.remove(j,i);
                    }
                    if(juego.rey[j][i] != null){juego.remove(j,i);}
                }
            }
            for(int j =0; j<=7;j++){
                for(int i =0; i<=7;i++){                    
                    if(configuracion.fichas[j][i]!=null){
                        String c =configuracion.fichas[j][i].getColor();
                        String type = configuracion.fichas[j][i].getType();
                        juego.seeType(type,j+1,i+1,c);
                        juego.fichas[j][i].moveHorizontal(350);}
                    if(configuracion.rey[j][i]!=null){String c =configuracion.rey[j][i].getColor();
                        juego.addK(j,i,c);juego.rey[j][i].moveHorizontal(350);
                    }
                }
            }
    }
    /**
     * Remueve todas las fichas del tablero de configuracion.
     * @param matriz de enteros los cuales son las coordenadas de cada ficha en el tablero.
     */
    public void remove(int[][] pieces){
        if(!juegoActivo){
            for (int i=0; i<pieces.length;i++){
                int row=pieces[i][0];
                int column=pieces[i][1];
                if ((row%2!=0 && column%2!=0)||(row%2==0 && column%2==0)){
                    JOptionPane.showMessageDialog(null, "Casilla no valida","ERROR!",JOptionPane.ERROR_MESSAGE);
                    wasCorrect = false;
                }else{
                    if (cont1<=0 && cont2<=0){
                    JOptionPane.showMessageDialog(null, "No hay fichas para eliminar","ERROR!",JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                    if (configuracion.fichas[row-1][column-1]==null &&configuracion.rey[row-1][column-1]==null){
                    wasCorrect = false;
                    JOptionPane.showMessageDialog(null, "No hay ficha para remover en esa posicion","ERROR!",JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                    if(configuracion.fichas[row-1][column-1] != null&&configuracion.fichas[row-1][column-1].getColor() == "white"){
                    cont1 -=1;
                    configuracion.remove(row-1,column-1);
                    }
                     if(configuracion.fichas[row-1][column-1] != null&& configuracion.fichas[row-1][column-1].getColor() == "black"){
                    cont2 -=1;
                    configuracion.remove(row-1,column-1);
                    }
                    wasCorrect = true;
                }
           }
        }else{
        JOptionPane.showMessageDialog(null, "Esta en zona de juego","ERROR!",JOptionPane.ERROR_MESSAGE);
        wasCorrect = false;
        }
    }
    /**
     * remueve una ficha determinada.
     * @param row,colum
     */
    public void remove(int row, int column){
        if(!juegoActivo){
            if ((row%2!=0 && column%2!=0)||(row%2==0 && column%2==0)){
                JOptionPane.showMessageDialog(null, "Casilla no valida","ERROR!",JOptionPane.ERROR_MESSAGE);
                wasCorrect = false;
            }
            else{
                if (cont1<=0 && cont2<=0){
                    JOptionPane.showMessageDialog(null, "No hay fichas para eliminar","ERROR!",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (configuracion.fichas[row-1][column-1]==null &&configuracion.rey[row-1][column-1]==null){
                    wasCorrect = false;
                    JOptionPane.showMessageDialog(null, "No hay ficha para remover en esa posicion","ERROR!",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if(configuracion.fichas[row-1][column-1] != null&&configuracion.fichas[row-1][column-1].getColor() == "white"){
                    cont1 -=1;
                    configuracion.remove(row-1,column-1);
                }
                if( configuracion.fichas[row-1][column-1] != null&& configuracion.fichas[row-1][column-1].getColor() == "black"){
                    cont2 -=1;
                    configuracion.remove(row-1,column-1);
                }
                if(configuracion.rey[row-1][column-1] != null&&configuracion.rey[row-1][column-1].getColor() == "white"){
                    cont1 -=1;
                    configuracion.remove(row-1,column-1);
                }
                if( configuracion.rey[row-1][column-1] != null&&configuracion.rey[row-1][column-1].getColor() == "black"){
                    cont2 -=1;
                    configuracion.remove(row-1,column-1);
                }
                wasCorrect = true;
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Esta en zona de juego","ERROR!",JOptionPane.ERROR_MESSAGE);
            wasCorrect = false;
        }
    }
    /**
     * guarda el tablero de  configuracion
     * @param name de tipo string
     */
    public void save(String name){
        String save = write();
        guardar.put(name,save);
    }
    /**
     * recupera el tablero guardado
     * @param name tipo String con el que se buscara el tablero guardado
     * @raturn Tablero en forma de String
     */
    public String recover(String name){
        String x = guardar.get(name);
        return x;
    }
    
    /**
     * Lee la representación en cadena del tablero que queremos que esté en el área de configuración.
     * @param entra un string con la representacion del tablero
     */
    public void read(String checherboard){
        configuracion.removeAll();juego.removeAll();
        for (int n = 0; n <Math.sqrt(checherboard.length ()); n++) { 
            for (int j= 0; j <Math.sqrt(checherboard.length ()); j++) { 
                char c = checherboard.charAt (j+(n*(int)Math.sqrt(checherboard.length ()))); 
                if(c=='B'){
                    configuracion.addK(n,j,"black");
                    juego.addK(n,j,"black");
                    juego.rey[n][j].moveHorizontal(350);
                }if(c=='W'){
                    configuracion.addK(n,j,"white");
                    juego.addK(n,j,"white");
                    juego.rey[n][j].moveHorizontal(350);
                }if(c=='b'){
                    configuracion.add(n,j,"black");
                    juego.add(n,j,"black");
                    juego.fichas[n][j].moveHorizontal(350);
                }if(c=='w'){
                    configuracion.add(n,j,"white");
                    juego.add(n,j,"white");
                    juego.fichas[n][j].moveHorizontal(350);                    
                }
            }
        }
        if (configuracion.isVisible){juego.makeVisible();}
    }
    /**
     * hace visible las fichas leidas en el metodo read
     * @return String que indica ...
     */
    public String write(){
        String a = "{";
        for(int i =0;i<configuracion.fichas.length;i++){
         a+="{"  ;
            for(int j=0;j<configuracion.fichas.length;j++){
                if (configuracion.fichas[i][j]==null && configuracion.rey[i][j]==null){
                    if (i%2==0 && j%2!=0){
                        a+=".";
                    }
                    if(i%2!=0 && j%2==0){
                        a+=".";
                    }
                    if (i%2==0 && j%2==0){
                        a+="-";
                    }
                    if(i%2!=0 && j%2!=0){
                        a+="-";
                    }
                }
                if(configuracion.fichas[i][j]!=null){
                    a +=configuracion.fichas[i][j].toString();
                }
                if(configuracion.rey[i][j]!=null){
                    a +=configuracion.rey[i][j].toString();
                }
            }
          a+="}" ;
        }
        a+="}";
        return a;
    }
    /**
     * convuierte en cadena el tablero de juego
     * @return String que indica el tablero en forma de string
     */
    public String writeGame(){
        String a = "{";
        for(int i =0;i<juego.fichas.length;i++){
         a+="{"  ;
            for(int j=0;j<juego.fichas.length;j++){
                if (juego.fichas[i][j]==null && juego.rey[i][j]==null){
                    if (i%2==0 && j%2!=0){
                        a+=".";
                    }
                    if(i%2!=0 && j%2==0){
                        a+=".";
                    }
                    if (i%2==0 && j%2==0){
                        a+="-";
                    }
                    if(i%2!=0 && j%2!=0){
                        a+="-";
                    }
                }
                if(juego.fichas[i][j]!=null){
                    a +=juego.fichas[i][j].toString();
                }
                if(juego.rey[i][j]!=null){
                    a +=juego.rey[i][j].toString();
                }
            }
          a+="}" ;
        }
        a+="}";
        return a;
    }
    /**
     * busca el equivalente del string en matriz
     * @param numero
     * @return fil tipo int 
     */
    public int filaequi(String numero){
       int num = Integer.parseInt(numero);
       int fil =0;
       if(num == 1 ||num == 2||num ==3||num == 4){fil=1;}
       if(num == 5||num == 6||num ==7||num == 8){fil= 2;}
       if(num == 9 ||num == 10||num ==11||num == 12){fil=3;}
       if(num == 13||num == 14||num ==15||num == 16){fil= 4;}
       if(num == 17 ||num == 18||num ==19||num == 20){fil=5;}
       if(num == 21||num == 22||num ==23||num == 24){fil= 6;}
       if(num == 25 ||num == 26||num ==27||num == 28){fil=7;}
       if(num == 29||num == 30||num ==31||num == 32){fil= 8;}
       return fil;  
    }
    /**
     * busca el equivalente del string en matriz
     * @param numero
     * @return col tipo int 
     */
    public int columequi(String numero){
       int num = Integer.parseInt(numero);
       int col = 0;
       if(num == 5 ||num == 13||num ==21||num == 19){col=1;}
       if(num == 1||num == 9||num ==17||num == 25){col= 2;}
       if(num == 6 ||num == 14||num ==22||num == 30){col=3;}
       if(num == 2||num == 10||num ==18||num == 26){col= 4;}
       if(num == 7 ||num == 15||num ==23||num == 31){col=5;}
       if(num == 3||num == 11||num ==17||num == 27){col= 6;}
       if(num == 8 ||num == 16||num ==24||num == 32){col=7;}
       if(num == 4||num == 12||num ==20||num == 28){col= 8;}
       return col;
    }
    
    /**
     * adiciona una ficha al tablero de configuracion
     * @param king,row,column
     */
    public void addSolve(boolean king, int row, int column, String color){
        if(!juegoActivo){
            if(king){
                if ((row%2!=0 && column%2!=0)||(row%2==0 && column%2==0)||(configuracion.rey[row-1][column-1]!=null)||(configuracion.fichas[row-1][column-1]!=null)){
                    JOptionPane.showMessageDialog(null, "Casilla no valida","ERROR!",JOptionPane.ERROR_MESSAGE);
                    wasCorrect = false;
                }
                else{
                    String y = color;
                    if( y.equals("white")){ 
                        if(cont1<12){
                            configuracion.addK(row-1,column-1,"white");
                            cont1 +=1;
                        }else{
                            JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                            wasCorrect = false;
                            return;
                        }
                    }
                    else if( y.equals("black")){
                        if (cont2<12){
                            configuracion.addK(row-1,column-1,"black");
                            cont2 +=1;
                        }else{
                            JOptionPane.showMessageDialog(null, "maximo de fichas","ERROR!",JOptionPane.ERROR_MESSAGE);
                            wasCorrect = false;
                            return;
                        }
                    }
                    configuracion.rey[row-1][column-1].makeVisible();
                    wasCorrect = true;
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Esta en zona de juego","ERROR!",JOptionPane.ERROR_MESSAGE);
            wasCorrect = false;
        }
    } 
    
    /**
     * Mata a una ficha que fue saltada
     * @param Num1 posicion inicial
     * @param Num2 posicion final
     */
    public void matar(String Num1, String Num2){
        int num = Integer.parseInt(Num1);
        int num2 = Integer.parseInt(Num2);
        int mayor=0;
        int menor =0;
        int fil=0;
        int col =0;
        
        if(num>num2){mayor=num;menor=num2;}else{mayor=num2;menor=num;}
        int eliminar=menor+(((mayor-menor)-((mayor-menor)%2))/2);
        if (menor==1||menor==2||menor==3||menor==4){
            eliminar +=1;
        }
        
        fil = filaequi(Integer.toString(eliminar))-1;
        col= columequi(Integer.toString(eliminar))-1;
        if((juego.fichas[fil][col]!=null && juego.fichas[fil][col].getType().equals("Powerful") || juego.fichas[fil][col].getType().equals("Superman"))||(juego.rey[fil][col]!=null && (juego.rey[fil][col].getColor().equals("pink")||juego.rey[fil][col].getColor().equals("magenta")))){
            return;
        }else{
            if ((juego.fichas[fil][col]!=null && juego.fichas[fil][col].getColor().equals("white"))||(juego.rey[fil][col]!=null && (juego.rey[fil][col].getColor().equals("pink")||juego.rey[fil][col].getColor().equals("gray")||juego.rey[fil][col].getColor().equals("yellow")||juego.rey[fil][col].getColor().equals("cyan")))){
                cont1=-1;
            }
            else{
                cont2=-1;
            }
            juego.remove(fil,col);
        }
    }
    
    /**
     * Duplica el movimiento anterior de la ficha Hurried
     * @param fil1 fila inicial
     * @param col1 columna inicial
     * @param fil2 fila final
     * @param col2 columna final
     */
    public void hurried(int fil1,int col1,int fil2,int col2){
        int newFil =0;int newCol =0;int cont=0;
        if(juego.fichas[fil2][col2].getType().equals("Hurried")){
            if(fil2-fil1==1){
                newFil = fil2+1;
            }if(fil2-fil1==-1){
                newFil = fil2-1;
            }if(col2-col1==1){
                newCol = col2+1;
            }if(col2-col1==-1){
                newCol = col2-1;
            }if(fil2-fil1==2){
                newFil = fil2+2;cont++;
            }if(fil2-fil1==-2){
                newFil = fil2-2;cont++;
            }if(col2-col1==2){
                newCol = col2+2;cont++;
            }if(col2-col1==-2){
                newCol = col2-2;cont++;
            }if(cont==2){matar(fil2,col2,newFil,newCol);}
        }else{
            return;
        }
        if(newFil>7||newCol>7||newFil<0||newCol<0||juego.fichas[newFil][newCol]!=null||juego.rey[newFil][newCol]!=null){return;}else{
            if(juego.fichas[fil2][col2]!= null){
                String color = juego.fichas[fil2][col2].getColor();
                juego.remove(fil2,col2);
                juego.addH(newFil,newCol,color);
                juego.fichas[newFil][newCol].moveHorizontal(350);
            }else{
                String color = juego.rey[fil2][col2].getColor();
                juego.remove(fil2,col2);
                juego.addK2("Hurried",newFil,newCol,color);
                juego.rey[newFil][newCol].moveHorizontal(350);
            }
        }
    }
     /**
     * Mata a una ficha que fue saltada
     * @param fil1 fila inicial
     * @param col1 columna inicial
     * @param fil2 fila final
     * @param col2 columna final
     */
    public void matar(int fil1,int col1,int fil2,int col2){
        int fil=0;
        int col =0;
        if(fil2-fil1==2){
          fil = fil2-1;
        }if(fil2-fil1==-2){
          fil = fil2+1;
        }if(col2-col1==2){
          col = col2-1;
        }if(col2-col1==-2){
          col = col2+1;
        }
        if((juego.fichas[fil][col]!=null && juego.fichas[fil][col].getType().equals("Powerful"))||(juego.rey[fil][col]!=null && (juego.rey[fil][col].getColor().equals("pink")||juego.rey[fil][col].getColor().equals("magenta")))){
            return;
        }else{
            if ((juego.fichas[fil][col]!=null && juego.fichas[fil][col].getColor().equals("white"))||(juego.rey[fil][col]!=null && (juego.rey[fil][col].getColor().equals("pink")||juego.rey[fil][col].getColor().equals("gray")||juego.rey[fil][col].getColor().equals("yellow")||juego.rey[fil][col].getColor().equals("cyan")))){
                cont1=-1;
            }
            else{
                cont2=-1;
            }
            juego.remove(fil,col);
        }
    }
}
