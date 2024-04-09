package Controller;

import Model.ContratacionModel;
import Model.VacanteModel;
import entity.Contratacion;
import entity.Vacante;

import javax.swing.*;

public class ContratacionController {
    public static void create(){
        ContratacionModel objModel = new ContratacionModel();

        int id_vacante = Integer.parseInt(JOptionPane.showInputDialog(VacanteController.getActivas()+"\nPor favor el id de la vacante: "));
        int id_coder = Integer.parseInt(JOptionPane.showInputDialog(CoderController.getAll()+"\nPor favor el id del coder: "));
        Double salario = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el salario: "));

        Contratacion objContratacion = new Contratacion();
        objContratacion.setId_vacante(id_vacante);
        objContratacion.setId_coder(id_coder);
        objContratacion.setEstado("ACTIVO");
        objContratacion.setSalario(salario);


        objContratacion = (Contratacion) objModel.insert(objContratacion);
        VacanteController.updateStatusAuto(id_vacante);
        JOptionPane.showMessageDialog(null,objContratacion.toString());

    }


    public static String getAll(){
        ContratacionModel objModel = new ContratacionModel();
        String listContrataciones = "Lista de todas las Contrataciones: \n";
        for (Object i : objModel.findAll()){
            Contratacion objContratacion = (Contratacion) i;
            listContrataciones += objContratacion.toString()+"\n";
        }
        return listContrataciones;
    }
    public static void delete(){
        ContratacionModel objModel = new ContratacionModel();
        int id_eliminar = Integer.parseInt(JOptionPane.showInputDialog(getAll()+"\nPor favor ingrese el id de la contratacion a borrar: "));
        Contratacion objContratacion = (Contratacion) objModel.findById(id_eliminar);


        int confirm = 1;
        if (objContratacion == null){
            JOptionPane.showMessageDialog(null,"Contratacion no encontrada");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,objContratacion.toString()+"\nEstas seguro que deseas borrar esta contratacion?");
            if (confirm == 0){
                objModel.delete(objContratacion);
            }
        }
    }


    public static void update() {
        ContratacionModel objModel = new ContratacionModel();
        int idFind = Integer.parseInt(JOptionPane.showInputDialog(getAll() + "\n Por favor ingrese el id de la contratacion que desea actualizar: "));
        Contratacion objContratacion = (Contratacion) objModel.findById(idFind);
        if (objContratacion == null) {
            JOptionPane.showMessageDialog(null, "Contratacion no encontrada");
        } else {

            int id_vacante = Integer.parseInt(JOptionPane.showInputDialog(VacanteController.getAll()+"\nPor favor el id de la vacante nueva: ",objContratacion.getId_vacante()));
            int id_coder = Integer.parseInt(JOptionPane.showInputDialog(CoderController.getAll()+"\nPor favor el id del coder nuevo: ",objContratacion.getId_coder()));
            Double salario = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el salario nuevo: ",objContratacion.getSalario()));


            objContratacion.setId_vacante(id_vacante);
            objContratacion.setId_coder(id_coder);
            objContratacion.setEstado("ACTIVO");
            objContratacion.setSalario(salario);


            objModel.update(objContratacion);
        }
    }
    public static void updateStatus() {
        ContratacionModel objModel = new ContratacionModel();
        int idFind = Integer.parseInt(JOptionPane.showInputDialog(getAll() + "\n Por favor ingrese el id de la contratacion a la cual le desea cambiar el estado: "));
        Contratacion objContratacion = (Contratacion) objModel.findById(idFind);
        if (objContratacion == null) {
            JOptionPane.showMessageDialog(null, "contratacion no encontrado");
        } else {
            if (objContratacion.getEstado().equals("ACTIVO")){
                String estado = JOptionPane.showInputDialog("El estado de la contratacion es 'ACTIVO' desea desactivarlo? (si)/(no): ");
                if (estado.toLowerCase().equals("si")){
                    objContratacion.setEstado("INACTIVO");
                    objModel.update(objContratacion);
                }
            }else {
                String estado = JOptionPane.showInputDialog("El estado de la contratacion es 'INACTIVO' desea Activarlo? (si)/(no): ");
                if (estado.toLowerCase().equals("si")){
                    objContratacion.setEstado("ACTIVO");
                    objModel.update(objContratacion);
                }
            }

        }
    }


}
