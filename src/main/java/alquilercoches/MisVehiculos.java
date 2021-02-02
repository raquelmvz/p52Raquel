/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilercoches;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author raquel
 */
public class MisVehiculos {

    public static void main(String[] args) {

        EmpresaAlquilerVehiculos easydrive = new EmpresaAlquilerVehiculos("A-28-187189", "easy drive", "www.easydrive.com");

        //clientes
        Cliente cliente1 = new Cliente("X5618927C", "Juan", "González López");
        Cliente cliente2 = new Cliente("Z7568991Y", "Luis", "Fernández Gómez");

        //Registrar clientes empresa
        easydrive.registrarCliente(cliente1);
        easydrive.registrarCliente(cliente2);

        //vehiculos
        Vehiculo vehiculo1 = new Vehiculo("4060 TUR", "Skoda", "Fabia", "Blanco", 90.0, false);
        Vehiculo vehiculo2 = new Vehiculo("4070 DEP", "Ford", "Mustang", "Rojo", 150.0, true);
        Vehiculo vehiculo3 = new Vehiculo("4080 TUR", "VW", "GTI", "Azul", 110.0, false);
        Vehiculo vehiculo4 = new Vehiculo("4090 TUR", "SEAT", "Ibiza", "Blanco", 90.0, false);
        Vehiculo vehiculo5 = new Vehiculo("4100 FUR", "Fiat", "Ducato", "Azul", 80.0, true);

        //Registrar vehiculos de la empresa
        easydrive.registrarVehiculo(vehiculo1);
        easydrive.registrarVehiculo(vehiculo2);
        easydrive.registrarVehiculo(vehiculo3);
        easydrive.registrarVehiculo(vehiculo4);
        easydrive.registrarVehiculo(vehiculo5);

        //Catalogo de vehiculos
        System.out.println("----CATALOGO DE VEHICULOS----");
        easydrive.imprimirVehiculos();

        //Alquiler de vehiculos
        VehiculoAlquilado alquiler1 = new VehiculoAlquilado(cliente1, vehiculo2, LocalDate.of(2020, Month.DECEMBER, 27), 20);
        VehiculoAlquilado alquiler2 = new VehiculoAlquilado(cliente2, vehiculo5, LocalDate.of(2021, Month.JANUARY, 5), 15);

        //Añadir los alquileres
        easydrive.registrarAlquiler(alquiler1);
        easydrive.registrarAlquiler(alquiler2);
        
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
