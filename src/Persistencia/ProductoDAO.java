/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Entidades.Producto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author RS
 */
public class ProductoDAO extends DAO{
    public void guardarProducto(Producto producto) throws Exception{
        try {
            if(producto==null){
                JOptionPane.showMessageDialog(null, "Debe indicar un producto");
            }else {
                String sql = "Insert into producto (codigo, nombre, precio, codigo_fabricante) values ("+producto.getCodigo()+", '"+producto.getNombre()+"', "+producto.getPrecio()+", "+producto.getCodigo_fabricante()+");";
                insertarModificarEliminar(sql);
            }
        } catch (Exception e) {
            throw new Exception("Error: "+e.toString());
        }
    }
    
    public void modificarProducto(Producto producto) throws ClassNotFoundException, Exception{
        try {
            if(producto==null){
                JOptionPane.showMessageDialog(null, "Debe indicar un producto para modificar");
            }else{
                 String opcionString = JOptionPane.showInputDialog("MENÚ: \n 1)Cambiar código \n 2)Cambiar nombre \n 3)Cambiar precio \n 4)Cambiar codigo fabricante \n Ingrese una opción:");
       int opcion = Integer.parseInt(opcionString);
       boolean volver = true;
       String sql = null;
       while(volver){
           switch(opcion){
               case 1:
                  String nuevoCodigoString = JOptionPane.showInputDialog("Ingrese el nuevo código que desea:");
                  int nuevoCodigo = Integer.parseInt(nuevoCodigoString);
                  sql = "Update producto set codigo = "+nuevoCodigo+" where nombre = '"+producto.getNombre()+"';";
                  insertarModificarEliminar(sql);
                  volver = false;
                  break;
               case 2:
                   String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                   sql = "Update producto set nombre = '"+nuevoNombre+"' where codigo ="+producto.getCodigo();
                   insertarModificarEliminar(sql);
                   volver = false;
                   break;
               case 3:
                   String nuevoPrecioString = JOptionPane.showInputDialog("Ingrese el nuevo precio del producto:");
                   double nuevoPrecio = Double.parseDouble(nuevoPrecioString);
                   sql = "Update producto set precio= "+nuevoPrecio+" where nombre = '"+producto.getNombre()+"';";
                   insertarModificarEliminar(sql);
                   volver = false;
                   break;
               case 4:
                   String nuevoCodigoFabricanteString  = JOptionPane.showInputDialog("Ingrese el nuevo código de fabricante:");
                   int nuevoCodigoFabricante = Integer.parseInt(nuevoCodigoFabricanteString);
                   sql = "Update producto set codigo_fabricante = "+nuevoCodigoFabricante+" where nombre = '"+producto.getNombre()+"';";
                   insertarModificarEliminar(sql);
                   volver = false;
                   break;
               default:
                   String opcionSalir = JOptionPane.showInputDialog("Ha ingresado una opción erronea, ingrese S si desea salir o N por no:");
                   if(opcionSalir.equalsIgnoreCase("S")){
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
    
    public void eliminarProducto(Producto producto) throws Exception{
        try {
            if(producto == null){
                JOptionPane.showMessageDialog(null, "Debe ingresar un producto para eliminar");
            }else {
                String sql = "Delete from producto where nombre = '"+producto.getNombre()+"';";
                insertarModificarEliminar(sql);
            }
        } catch (Exception e) {
            throw new Exception("Error: "+e.toString());
        }
    }
    
    public ArrayList <Producto> listaProductos() throws Exception{
        try {
            String sql = "select * from producto;";
            consultarBase(sql);
            Producto producto = null;
            ArrayList <Producto> listaProductos = new ArrayList<>();
            while(resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                listaProductos.add(producto);
            }
            desconectarBase();
            return listaProductos;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error: "+e.toString());
        }
    }
    
    public ArrayList <Producto> listarNombrePrecioProd() throws Exception{
        try {
            String sql = "select nombre, precio from producto;";
            consultarBase(sql);
            Producto producto = null;
            ArrayList <Producto> listaNombrePrecios = new ArrayList<>();
            while(resultado.next()){
                producto = new Producto();
                //producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
               // producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                listaNombrePrecios.add(producto);
            }
            desconectarBase();
            return listaNombrePrecios;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error: "+e.toString());
        }
    }
    
    public ArrayList <Producto> listar120_202() throws Exception{
        try {
            String sql = "select * from producto where precio between 120 and 202;";
            consultarBase(sql);
            Producto producto = null;
            ArrayList <Producto> lista120_202 = new ArrayList<>();
            while(resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                lista120_202.add(producto);
            }
            desconectarBase();
            return lista120_202;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error: "+e.toString());
        }
    }
    
    public ArrayList <Producto> listarPortatil() throws Exception{
        try {
            String sql = "select * from producto where nombre like '%Portatil%';";
            consultarBase(sql);
            Producto producto = null;
            ArrayList <Producto> listaPortatil = new ArrayList<>();
            while(resultado.next()){
                producto = new Producto();
                producto.setCodigo(resultado.getInt("codigo"));
                producto.setNombre(resultado.getString("nombre"));
                producto.setPrecio(resultado.getDouble("precio"));
                producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
                listaPortatil.add(producto);
            }
            desconectarBase();
            return listaPortatil;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error: "+e.toString());
        }
    }
    
    //TENGO DUDAS CON ESTE
    public Producto barato () throws Exception{
        try {
            String sql = "select * from producto order by precio asc limit 1;";
            consultarBase(sql);
            Producto producto = new Producto();
            producto.setCodigo(resultado.getInt("codigo"));
            producto.setNombre(resultado.getString("nombre"));
            producto.setPrecio(resultado.getDouble("precio"));
            producto.setCodigo_fabricante(resultado.getInt("codigo_fabricante"));
            desconectarBase();
            return producto;
        } catch (Exception e) {
            desconectarBase();
            throw new Exception("Error: "+e.toString());
        }
    }
}
    

