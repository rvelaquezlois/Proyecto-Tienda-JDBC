/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Fabricante;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RS
 */
public class FabricanteDAO extends DAO {
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        try {
            if(fabricante==null){
                JOptionPane.showMessageDialog(null, "No ha ingresado ningún fabricante");
            }else {
                String sql = "Insert into fabricante (codigo, nombre) values ("+fabricante.getCodigo()+", '"+fabricante.getNombre()+"');";
                insertarModificarEliminar(sql);
            }
        } catch (Exception e) {
            throw new Exception("Error: "+e.toString());
        }
    }
    
    public void modificarFabricante(Fabricante fabricante) throws Exception{
        try {
            if(fabricante==null){
                JOptionPane.showMessageDialog(null, "Debe indicar un fabricante para modificar");
            }else {
                String opcionString = JOptionPane.showInputDialog("MENÚ: \n 1) Cambiar código \n 2) Cambiar nombre \n Ingrese una opción:");
                int opcion = Integer.parseInt(opcionString);
                boolean volver = true;
                String sql = null;
                while(volver){
                    switch(opcion){
                        case 1:
                            String nuevoCodigoString = JOptionPane.showInputDialog("Ingrese el nuevo código:");
                            int nuevoCodigo = Integer.parseInt(nuevoCodigoString);
                            sql = "Update fabricante set codigo = "+nuevoCodigo+" where nombre = '"+fabricante.getNombre()+"';";
                            insertarModificarEliminar(sql);
                            volver = false;
                            break;
                        case 2:
                            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre para el fabricante: ");
                            sql = "Update fabricante set nombre = '"+nuevoNombre+"' where codigo = "+fabricante.getCodigo()+";";
                            insertarModificarEliminar(sql);
                            volver = false;
                            break;
                        default:
                            String opcionSalir = JOptionPane.showInputDialog("Ha ingresado una opción erronea, ingrese S si desea salir o N por no:");
                            if (opcionSalir.equalsIgnoreCase("S")) {
                                volver = false;
                            }
                            break;
                    }
                }
            }
        } catch (Exception e) {
            throw new Exception("Error: "+e.toString());
        }
    }
    
    public void eliminarFabricante(Fabricante fabricante) throws Exception{
        try {
            if(fabricante==null){
                JOptionPane.showMessageDialog(null, "Debe ingresar un fabricante para eliminar");
            }else {
                String sql = "Delete from fabricante where nombre = '"+fabricante.getNombre()+"';";
                insertarModificarEliminar(sql);
            }
        } catch (Exception e) {
            throw new Exception("Error: "+e.toString());
        }
    }
    
    public ArrayList <Fabricante> listarFabricantes() throws Exception{
        try {
            String sql = "Select * from fabricante";
            consultarBase(sql);
            Fabricante fabricante = null;
            ArrayList <Fabricante> listaFabricantes = new ArrayList<>();
            while(resultado.next()){
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt("codigo"));
                fabricante.setNombre(resultado.getString("nombre"));
                listaFabricantes.add(fabricante);
            }
            desconectarBase();
            return listaFabricantes;
        } catch (Exception e) {
            throw new Exception("Error: "+e.toString());
        }
    }
}
