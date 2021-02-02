/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilercoches;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author raquel
 */
public class EmpresaAlquilerVehiculos {

    private ArrayList<Vehiculo> vehiculos;
    private ArrayList<Cliente> clientes;
    private ArrayList<VehiculoAlquilado> alquilados;
    private String cif;
    private String nombre;
    private String paginaWeb;

    EmpresaAlquilerVehiculos() {

    }

    //Devuelve el numero de clientes
    public int totalClientes() {
        return clientes.size();
    }

    //Devuelve el numero de vehiculos
    public int totalvehiculos() {
        return vehiculos.size();
    }

    //Devuelve el numero de alquileres
    public int totalalquilados() {
        return alquilados.size();
    }

    //Const param
    EmpresaAlquilerVehiculos(String cif, String nombre, String paginaWeb) {
        this.cif = cif;
        this.nombre = nombre;
        this.paginaWeb = paginaWeb;
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
        this.alquilados = new ArrayList<>();
    }

    //Para registrar a un cliente
    public void registrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    //Para registrar un vehiculo
    public void registrarVehiculo(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    //para añadir los alquileres
    public void registrarAlquiler(VehiculoAlquilado vehiculo) {
        alquilados.add(vehiculo);
    }

    //Lista de los alquileres
    //Comprobar primero si existen alquileres
    public void listaAlquilados() {

        if (alquilados.isEmpty()) {
            System.out.println("No existen alquileres");
        } else {
            for (int i = 0; i < alquilados.size(); i++) {
                System.out.println(alquilados.get(i));
            }
        }
    }

    //ordenar por nif
    public void ordenarPorNif() {
        Comparator<Cliente> criterio = (c1, c2) -> c1.getNif().compareTo(c2.getNif());
        Collections.sort(clientes, criterio);
    }

    //buscar por nif
    public int buscarPorNif(Cliente cliente) {
        Comparator<Cliente> criterio = (c1, c2) -> c1.getNif().compareTo(c2.getNif());
        int pos = Collections.binarySearch(clientes, cliente, criterio);

        return pos;
    }

    //imprimir los datos de clientes
    public void imprimirClientes() {

        clientes.forEach(System.out::println);
    }

    //para buscar un vehiculo dada la matricula
    public int buscarVehiculo(String matricula) {

        int pos = 0;

        for (Vehiculo vehiculo : vehiculos) {
            //== 0 -- equals
            if (vehiculo.getMatricula().compareToIgnoreCase(matricula) == 0) {
                return pos;
            }

            pos++;
        }
        //si no existe
        return -1;
    }

    //para imprimir los vehiculos
    public void imprimirVehiculos() {
        vehiculos.forEach(System.out::println);
    }

    //para modificar la disponibilidad del vehiculo
    //para que se pueda alquilar de nuevo
    //primero se busca el veh con la matricula
    public void disponibilidadVehiculo(String matricula) {

        //buscarvehiculo -- pos
        //vehiculos.get(pos) -- se guarda en vehiculo
        Vehiculo vehiculo = vehiculos.get(buscarVehiculo(matricula));

        if (vehiculo != null) {
            vehiculo.setDisponible(true);
        }

    }

    //matriculas y fechas de entrega
    public void listaFechasEntrega() {
        LocalDate fechaEntrega;

        for (VehiculoAlquilado vehiculo : alquilados) {
            fechaEntrega = vehiculo.getFechaAlquiler().plusDays(vehiculo.getTotalDiasAlquiler());
            System.out.println("MATRICULA: " + vehiculo.getVehiculo().getMatricula() + " FECHA ENTREGA: "
                    + fechaEntrega);
        }
    }

}
