/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import Entidades.Fabricante;
import Persistencia.FabricanteDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RS
 */
public class FabricanteService {
    public void guardarFabricante() throws Exception{
    Fabricante fabricante = new Fabricante();
    FabricanteDAO dao = new FabricanteDAO();
    String codigoString = JOptionPane.showInputDialog("Ingrese el código por favor:");
    fabricante.setCodigo(Integer.parseInt(codigoString));
    String nombre = JOptionPane.showInputDialog("Ingrese el nombre del fabricante:");
    fabricante.setNombre(nombre);
    dao.guardarFabricante(fabricante);
    }
    
    public void modificarFabricante() throws Exception{
        Fabricante fabricante = new Fabricante();
        FabricanteDAO dao = new FabricanteDAO();
        String codigoString = JOptionPane.showInputDialog("Ingrese el código por favor:");
        fabricante.setCodigo(Integer.parseInt(codigoString));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del fabricante:");
        fabricante.setNombre(nombre);
        dao.modificarFabricante(fabricante);
    }
    
    public void eliminarProducto() throws Exception{
        Fabricante fabricante = new Fabricante();
        FabricanteDAO dao = new FabricanteDAO();
        String codigoString = JOptionPane.showInputDialog("Ingrese el código por favor:");
        fabricante.setCodigo(Integer.parseInt(codigoString));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del fabricante:");
        fabricante.setNombre(nombre);
        dao.eliminarFabricante(fabricante);
    }
    
    public void listarFabricantes() throws Exception{
        FabricanteDAO dao = new FabricanteDAO();
        ArrayList <Fabricante> listaFabricante = dao.listarFabricantes();
        for(Fabricante aux: listaFabricante){
            JOptionPane.showMessageDialog(null, "1 - Código:  "+aux.getCodigo()+"\n 2 - Nombre: "+aux.getNombre());
        }
    }
}
