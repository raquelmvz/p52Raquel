/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilercoches;

/**
 *
 * @author raquel
 */
public class MisVehiculos {

    public static void main(String[] args) {

        EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive", "www.easydrive.com");

        //registro de los clientes
        easydrive.registrarCliente(new Cliente("X5618927C", "Juan", "González López"));
        easydrive.registrarCliente(new Cliente("Z7568991Y", "Luis", "Fernández Gómez"));

        //registrar vehiculos
        easydrive.registrarVehiculo(new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4070 DEP", "Ford", "Mustang", "Rojo", 150.0, true));
        easydrive.registrarVehiculo(new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, false));
        easydrive.registrarVehiculo(new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true));

        //Catalogo de vehiculos
        System.out.println("----CATALOGO DE VEHICULOS----");
        easydrive.imprimirVehiculos();

        //Registro de alquileres
        easydrive.registrarAlquiler("X5618927C", "4070 DEP", 15);
        easydrive.registrarAlquiler("Z7568991Y", "4100 FUR", 6);

        //Lista de alquileres
        System.out.println("----LISTA DE ALQUILERES----");
        easydrive.listaAlquilados();

        //Matriculas y fechas de entrega
        System.out.println("---FECHAS DE ENTREGA---");
        easydrive.listaFechasEntrega();

        //Modificar disponibilidad del vehiculo 4
        System.out.println("---DISPONIBILIDAD DE VEHICULOS---");
        easydrive.disponibilidadVehiculo("4090 TUR");

        System.out.println("El vehiculo 4 ahora está disponible");
        easydrive.imprimirVehiculos();
    }

}
