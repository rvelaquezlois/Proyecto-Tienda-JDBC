/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import javax.swing.JOptionPane;

/**
 *
 * @author RS
 */
public class MenuService {
    public void Menu() throws Exception{
        FabricanteService fabSev = new FabricanteService();
        ProductoService prodSev = new ProductoService();
        boolean volver = true;
        while(volver){
            String opcionString = JOptionPane.showInputDialog("MENÚ: \n 1 - Listar productos \n 2 - Listar nombre y precio productos \n 3 - Listar los productos con un precio entre 120 y 202 \n 4 - Listar todos los portátiles \n 5 - Producto más barato \n 6 - Listar fabricantes \n 7 - Ingresar un producto \n 8 - Modificar un producto \n 9 - Eliminar un producto \n 10 - Ingresar un fabricante \n 11 - Modificar un fabricante \n 12 - Eliminar un fabricante \n Ingrese una opción");
            int  opcion = Integer.parseInt(opcionString);
            switch(opcion){
                case 1:
                    prodSev.listaTodos();
                    break;
                case 2:
                    prodSev.listaNombrePrecio();
                    break;
                case 3:
                    prodSev.lista120_202();
                    break;
                case 4:
                    prodSev.listaPortatil();
                    break;
                case 5:
                    prodSev.barato();
                    break;
                case 6:
                    fabSev.listarFabricantes();
                    break;
                case 7:
                    prodSev.insertarProducto();
                    break;
                case 8:
                    prodSev.modificarProducto();
                    break;
                case 9:
                    prodSev.eliminarProducto();
                    break;
                case 10:
                    fabSev.guardarFabricante();
                    break;
                case 11:
                     fabSev.modificarFabricante();
                     break;
                case 12:
                     fabSev.eliminarProducto();
                     break;
                default:
                    break;
            }
        }
    }
}
