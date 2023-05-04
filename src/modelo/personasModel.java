package modelo;
import java.util.ArrayList;        
        
public class personasModel {
    public ArrayList<Personas> listaPersonas = new ArrayList <Personas>();
     
    public void agregarPersona(String ape, String nom, String tel){
        Personas persona = new Personas (ape, nom, tel);
        this.listaPersonas.add(persona);
    }
    
    public ArrayList ListarClientes (){
        return listaPersonas;
    }     
        
}
