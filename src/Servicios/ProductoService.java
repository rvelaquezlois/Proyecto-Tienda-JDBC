/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;



import Entidades.Producto;
import Persistencia.ProductoDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RS
 */
public class ProductoService {
    public void insertarProducto() throws Exception{
        Producto producto = new Producto();
        ProductoDAO dao = new ProductoDAO();
        String comodin = null;
        comodin = JOptionPane.showInputDialog(null, "Ingrese el nuevo código:");
        producto.setCodigo(Integer.parseInt(comodin));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        producto.setNombre(nombre);
        comodin = JOptionPane.showInputDialog("Ingrese el precio del producto:");
        producto.setPrecio(Double.parseDouble(comodin));
        comodin = JOptionPane.showInputDialog("Ingrese el código del fabricante:");
        producto.setCodigo_fabricante(Integer.parseInt(comodin));
        dao.guardarProducto(producto);
    }
    
    public void modificarProducto() throws Exception{
        Producto producto = new Producto();
        ProductoDAO dao = new ProductoDAO();
        String comodin = null;
        comodin = JOptionPane.showInputDialog(null, "Ingrese el nuevo código:");
        producto.setCodigo(Integer.parseInt(comodin));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        producto.setNombre(nombre);
        comodin = JOptionPane.showInputDialog("Ingrese el precio del producto:");
        producto.setPrecio(Double.parseDouble(comodin));
        comodin = JOptionPane.showInputDialog("Ingrese el código del fabricante:");
        producto.setCodigo_fabricante(Integer.parseInt(comodin));
        dao.modificarProducto(producto);
    }
    
    public void eliminarProducto() throws Exception{
        Producto producto = new Producto();
        ProductoDAO dao = new ProductoDAO();
        String comodin = null;
        comodin = JOptionPane.showInputDialog(null, "Ingrese el nuevo código:");
        producto.setCodigo(Integer.parseInt(comodin));
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto:");
        producto.setNombre(nombre);
        comodin = JOptionPane.showInputDialog("Ingrese el precio del producto:");
        producto.setPrecio(Double.parseDouble(comodin));
        comodin = JOptionPane.showInputDialog("Ingrese el código del fabricante:");
        producto.setCodigo_fabricante(Integer.parseInt(comodin));
        dao.eliminarProducto(producto);
    }
    
    public void listaTodos() throws Exception{
        ProductoDAO dao = new ProductoDAO();
        ArrayList <Producto> listaProductos = dao.listaProductos();
        for(Producto aux: listaProductos){
            JOptionPane.showMessageDialog(null, "1 - Código: "+aux.getCodigo()+"\n 2 - Nombre: "+aux.getNombre()+"\n 3 - Precio: "+aux.getPrecio()+"\n 4 - Código fabricante: "+aux.getCodigo_fabricante());
        }
    }
    
    public void listaNombrePrecio() throws Exception{
        ProductoDAO dao = new ProductoDAO();
        ArrayList <Producto> listaProductos = dao.listarNombrePrecioProd();
        for(Producto aux: listaProductos){
            JOptionPane.showMessageDialog(null, "1 - Nombre: "+aux.getNombre()+"\n 2 - Precio: "+aux.getPrecio());
        }
    }
    
    public void lista120_202() throws Exception {
        ProductoDAO dao = new ProductoDAO();
        ArrayList <Producto> listaProductos = dao.listar120_202();
        for(Producto aux: listaProductos){
            JOptionPane.showMessageDialog(null, "1 - Código: "+aux.getCodigo()+"\n 2 - Nombre: "+aux.getNombre()+"\n 3 - Precio: "+aux.getPrecio()+"\n 4 - Código fabricante: "+aux.getCodigo_fabricante());
        }
    }
    
    public void listaPortatil() throws Exception{
        ProductoDAO dao = new ProductoDAO();
        ArrayList <Producto> listaProductos = dao.listarPortatil();
        for(Producto aux: listaProductos){
            JOptionPane.showMessageDialog(null, "1 - Código: "+aux.getCodigo()+"\n 2 - Nombre: "+aux.getNombre()+"\n 3 - Precio: "+aux.getPrecio()+"\n 4 - Código fabricante: "+aux.getCodigo_fabricante());
        }
    }
    
    public void barato() throws Exception{
        ProductoDAO dao = new ProductoDAO();
        Producto producto = dao.barato();
       JOptionPane.showMessageDialog(null, "1 - Código: "+producto.getCodigo()+"\n 2 - Nombre: "+producto.getNombre()+"\n 3 - Precio: "+producto.getPrecio()+"\n 4 - Código fabricante: "+producto.getCodigo_fabricante()); 
    }
}

