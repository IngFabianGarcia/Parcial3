
import controlador.personasController;
import modelo.*;
import vista.*;

public class main {

    public static void main(String[] args) {
        
        frmPrincipal VistaPrincipal = new frmPrincipal();
        frmPersonas VistaPersonas = new frmPersonas(VistaPrincipal, true);
        personasModel ModeloPersonas = new personasModel();
        
        personasController controladorPersonas = new personasController(VistaPrincipal, VistaPersonas, ModeloPersonas);

    }   
    
}
