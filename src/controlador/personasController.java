package controlador;

import java.awt.event.*;        
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class personasController implements ActionListener {
    frmPrincipal vistaPrincipal;
    frmPersonas vistaPersonas;
    personasModel modeloPersona;
    public DefaultTableModel TablaUsuarios = new DefaultTableModel();

    public personasController(frmPrincipal vistaPrincipal, frmPersonas vistaPersonas, 
             personasModel modeloPersona) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPersonas = vistaPersonas;
        this.modeloPersona = modeloPersona;
        
        
        this.vistaPrincipal.btnAgregar.addActionListener(this);
        this.vistaPrincipal.btnListar.addActionListener(this);
        this.vistaPrincipal.btnAbrir.addActionListener(this);
        
        this.vistaPrincipal.setVisible(true);
       
        
        this.TablaUsuarios.addColumn("APELLIDO");
        this.TablaUsuarios.addColumn("NOMBRES");
        this.TablaUsuarios.addColumn("TELEFONO");     
        this.vistaPrincipal.jtbPersonas.setModel(TablaUsuarios);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== this.vistaPrincipal.btnAgregar){
            
            this.modeloPersona.agregarPersona(this.vistaPrincipal.txtApellido.getText(),
                    this.vistaPrincipal.txtNombre.getText(), 
                    this.vistaPrincipal.txtTelefono.getText());
            
                ArrayList <Personas> listaLocal = this.modeloPersona.ListarClientes();
            
                String Cadena = " ";
                
            for(Personas MiListaPersonas: listaLocal){
                Cadena = Cadena + MiListaPersonas.getApellido() + " " + MiListaPersonas.getNombre() + " " + MiListaPersonas.getTelefono() +"\n";
                this.vistaPersonas.txtaPersonas.setText(Cadena);
                        
            }
            JOptionPane.showMessageDialog(null, "Agregado Correctamente");
        }       
                
        if(e.getSource () == this.vistaPrincipal.btnListar){
            ArrayList<Personas> listaLocal = this.modeloPersona.ListarClientes();
            
            for(int i = 0; i < listaLocal.size(); i++){
                
                this.TablaUsuarios.addRow(new Object[]{this.modeloPersona.listaPersonas.get(i).getApellido(), 
                this.modeloPersona.listaPersonas.get(i).getNombre(), 
                Integer.parseInt(this.modeloPersona.listaPersonas.get(i).getTelefono())});  
                
            }        
            
        }
        
        if(e.getSource () == this.vistaPrincipal.btnAbrir){
            this.vistaPersonas.setVisible(true);
        }
        
    }
    
    
}
