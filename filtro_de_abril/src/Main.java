import Controller.CoderController;
import Controller.ContratacionController;
import Controller.VacanteController;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String option;
        do {
            option = JOptionPane.showInputDialog("""
           GESTION:
                              
           1. Coders.
           2. Vacantes.
           3. Contrataciones.
                                         
           4. Salir.
           """);


            switch (option) {
                case "1":
                    String optio;
                    optio = JOptionPane.showInputDialog("""
                   1. Ingresar un nuevo Coder.
                   2. Listar Coders.
                   3. Actualizar Coder.
                   4. Eliminar Coder.
                  
                   0. Salir.
                   """);
                    switch (optio) {
                        case "1":
                            CoderController.create();
                            break;

                        case "2":
                            String opti0;
                            opti0 = JOptionPane.showInputDialog("""
                               1. Listar todas.
                               2. Buscar coders por cohorte.
                               3. Buscar coders por clan.
                               4. Buscar coders por tecnologia.
                              
                               0. Salir.
                               """);
                            switch (opti0) {
                                case "1":
                                    JOptionPane.showMessageDialog(null,CoderController.getAll());
                                    break;
                                case "2":
                                    JOptionPane.showMessageDialog(null,CoderController.getByCohorte());
                                    break;
                                case "3":
                                    JOptionPane.showMessageDialog(null,CoderController.getByClan());
                                    break;
                                case "4":
                                    JOptionPane.showMessageDialog(null,CoderController.getByTechnology());
                                    break;
                                case "0":
                                    break;
                            }
                            break;

                        case "3":
                            CoderController.update();
                            break;

                        case "4":
                            CoderController.delete();
                            break;
                        case "0":
                            break;
                    }
                    break;


                case "2":
                    String opti;
                    opti = JOptionPane.showInputDialog("""
               1. Ingresar una nueva Vacante.
               2. Listar Vacantes.
               3. Actualizar Vacante.
               4. Eliminar Vacante.
               5. Cambiar estado de una vacante.
              
               0. Salir.
               """);
                    switch (opti) {
                        case "1":
                            VacanteController.create();
                            break;


                        case "2":
                            String opti1;
                            opti1 = JOptionPane.showInputDialog("""
                   1. Listar todas.
                   2. Buscar Vacantes por titulo.
                   2. Buscar Vacantes por tecnologia.
                  
                   0. Salir.
                   """);
                            switch (opti1) {
                                case "1":
                                    JOptionPane.showMessageDialog(null,VacanteController.getAll());
                                    break;
                                case "2":
                                    JOptionPane.showMessageDialog(null,VacanteController.getByTitle());
                                    break;
                                case "3":
                                    JOptionPane.showMessageDialog(null,VacanteController.getByTechnology());
                                    break;
                                case "0":
                                    break;
                            }

                            break;

                        case "3":
                            VacanteController.update();
                            break;


                        case "4":
                            VacanteController.delete();
                            break;
                        case "5":
                            VacanteController.updateStatus();
                            break;
                        case "0":
                            break;
                    }
                    break;


                case "3":
                    String opt;
                    opt = JOptionPane.showInputDialog("""
               1. Ingresar una nueva contratacion.
               2. Listar contrataciones.
               3. Actualizar contratacion.
               4. Eliminar contratacion.
               5. Cambiar estado de una contratacion.
              
               0. Salir.
               """);
                    switch (opt) {
                        case "1":
                            ContratacionController.create();
                            break;


                        case "2":
                            String opti2;
                            opti2 = JOptionPane.showInputDialog("""
                   1. Listar todos.
                   2. buscar OPCION_EJEMPLO por OPCION_EJEMPLO.
                                       
                   0. Salir.
                   """);
                            switch (opti2) {
                                case "1":
                                    JOptionPane.showMessageDialog(null,ContratacionController.getAll());
                                    break;
                                case "2":


                                    break;
                                case "0":
                                    break;
                            }
                            break;




                        case "3":
                            ContratacionController.update();
                            break;


                        case "4":
                            ContratacionController.delete();
                            break;
                        case "5":
                            ContratacionController.updateStatus();
                            break;
                        case "0":
                            break;
                    }
                    break;


            }}while (!option.equals("4"));


    }
}