package com.mycompany.funcionarios.iud.app.test;

import com.mycompany.funcionarios.iud.app.controller.FuncionarioController;
import com.mycompany.funcionarios.iud.app.domain.Funcionario;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void obtenerFun(FuncionarioController funcionarioController) {

        try {
            List<Funcionario> funcionarios = funcionarioController.obtenerFun();
            if (funcionarios.isEmpty()) {
                System.out.println("No hay datos");
            } else {
                funcionarios.forEach(funcionario -> {
                    System.out.println("id: " + funcionario.getId());
                    System.out.println("tipo_doccumento: " + funcionario.getTipo_doccumento());
                    System.out.println("numero_documento: " + funcionario.getNumero_documento());
                    System.out.println("nombre: " + funcionario.getNombre());
                    System.out.println("apellido: " + funcionario.getApellido());
                    System.out.println("estado_civil: " + funcionario.getEstado_civil());
                    System.out.println("sexo: " + funcionario.getSexo());
                    System.out.println("direccion: " + funcionario.getDireccion());
                    System.out.println("telefono: " + funcionario.getTelefono());
                    System.out.println("fecha_nacimiento: " + funcionario.getFecha_nacimiento());
                    System.out.println("---------------");
                    System.out.println("---------------");

                });

            }

        } catch (SQLException ex) {
            ex.printStackTrace();

        }

    }

    public static void crear(FuncionarioController funcionarioController) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Ingretese el tipo de documento:  ");
            String tipodoccumento = sc.nextLine();
            System.out.println("El tipo doccumento es: " + tipodoccumento);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            System.out.println("Ingretese el numero de documento:  ");
            String numerodoccumento = sc.nextLine();
            System.out.println("El numero de doccumento es: " + numerodoccumento);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            System.out.println("Ingretese el nombre:  ");
            String nombre = sc.nextLine();
            System.out.println("El nombre es: " + nombre);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            System.out.println("Ingretese el apellido:  ");
            String apellido = sc.nextLine();
            System.out.println("El apellido es: " + apellido);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            System.out.println("Ingretese el estado civil:  ");
            String estadoCivil = sc.nextLine();
            System.out.println("El estado civil es: " + estadoCivil);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            System.out.println("Ingretese el sexo:  ");
            String sexo = sc.nextLine();
            System.out.println("El sexo es: " + sexo);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            System.out.println("Ingretese la dirección:  ");
            String direccion = sc.nextLine();
            System.out.println("La dirección  es: " + direccion);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            System.out.println("Ingertese el telefono:  ");
            String telefono = sc.nextLine();
            System.out.println("El telefono es: " + telefono);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            System.out.println("Ingretese la fecha de nacimiento:  ");
            String nacimiento = sc.nextLine();
            System.out.println("La fecha de nacimiento es: " + nacimiento);
            System.out.println("---------------");
            System.out.println("---------------");
            System.out.println("---------------");

            Funcionario funcionario = new Funcionario();
            funcionario.setTipo_doccumento(tipodoccumento);
            funcionario.setNumero_documento(numerodoccumento);
            funcionario.setNombre(nombre);
            funcionario.setApellido(apellido);
            funcionario.setEstado_civil(estadoCivil);
            funcionario.setSexo(sexo);
            funcionario.setDireccion(direccion);
            funcionario.setTelefono(telefono);
            funcionario.setFecha_nacimiento(nacimiento);
            funcionarioController.crear(funcionario);
            System.out.println("Funcionario creado con exito");
            obtenerFun(funcionarioController);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public static void eliminarFuncionario(FuncionarioController funcionarioController) {

        try {
            Scanner sc = new Scanner(System.in);

            System.out.println("Digite el ID del funcionario: =  ");
            int id = sc.nextInt();
            System.out.println("El id del funcionario es: " + id);

            Funcionario funcionarioExist = funcionarioController.obtentenerFuncionario(id);
            if (funcionarioExist == null) {
                System.out.println("No existe funcionario");
                return;
            }

            funcionarioController.eliminarFun(id);
            System.out.println("Funcionario eliminado con exito");
            obtenerFun(funcionarioController);
            System.out.println("--------------");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {

        var opcion = -1;
        var scanner = new Scanner(System.in);
        FuncionarioController funcionarioController = new FuncionarioController();
        while (opcion != 0) {
            System.out.println("Elige una opcion ");
            System.out.println("--------------");

            System.out.println("1. listar funcionarios");
            System.out.println("2. crear funcionarios");
            System.out.println("3. eliminar funcionario");
//        System.out.println("listar funcionario popr ID");
//        System.out.println("Actualizar funcionario");

            System.out.println("--------------");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 0:
                    System.out.println("Ha salido de la aplicacion  ");
                    break;

                case 1:
                    obtenerFun(funcionarioController);
                    break;
                case 2:
                    crear(funcionarioController);

                case 3:
                    eliminarFuncionario(funcionarioController);
                    break;

                default:
                    System.out.println("Opcion invalida  ");
            }

        }

    }
}
