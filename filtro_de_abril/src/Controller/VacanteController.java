package Controller;

import Model.VacanteModel;
import entity.Vacante;

import javax.swing.*;

public class VacanteController {
    public static void create(){
        VacanteModel objModel = new VacanteModel();

        int id_empresa = Integer.parseInt(JOptionPane.showInputDialog(EmpresaController.getAll()+"\nPor favor ingrese el id de la empresa: "));
        String titulo = JOptionPane.showInputDialog("Por favor ingrese el titulo de la vacante: ");
        String descripcion = JOptionPane.showInputDialog("Por favor ingrese la descripcion: ");
        String duracion = JOptionPane.showInputDialog("Por favor ingrese la duracion: ");
        String tecnologia = JOptionPane.showInputDialog("Por favor ingrese la tecnologia: ");


        Vacante objVacante = new Vacante();
        objVacante.setId_empresa(id_empresa);
        objVacante.setTitulo(titulo);
        objVacante.setDescripcion(descripcion);
        objVacante.setDuracion(duracion);
        objVacante.setEstado("ACTIVO");
        objVacante.setTecnologia(tecnologia);

        objVacante = (Vacante) objModel.insert(objVacante);
        JOptionPane.showMessageDialog(null,objVacante.toString());

    }


    public static String getAll(){
        VacanteModel objModel = new VacanteModel();
        String listVacantes = "Lista de todas las Vacantes: \n";
        for (Object i : objModel.findAll()){
            Vacante objVacante = (Vacante) i;
            listVacantes += objVacante.toString()+"\n";
        }
        return listVacantes;
    }
    public static void delete(){
        VacanteModel objModel = new VacanteModel();
        int id_eliminar = Integer.parseInt(JOptionPane.showInputDialog(getAll()+"\nPor favor ingrese el id de la vacante a borrar: "));
        Vacante objVacante = (Vacante) objModel.findById(id_eliminar);


        int confirm = 1;
        if (objVacante == null){
            JOptionPane.showMessageDialog(null,"Vacante no encontrada");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,objVacante.toString()+"\nEstas seguro que deseas borrar esta vacante?");
            if (confirm == 0){
                objModel.delete(objVacante);
            }
        }
    }


    public static void update() {
        VacanteModel objModel = new VacanteModel();
        int idFind = Integer.parseInt(JOptionPane.showInputDialog(getAll() + "\n Por favor ingrese el id de la vacante que desea actualizar: "));
        Vacante objVacante = (Vacante) objModel.findById(idFind);
        if (objVacante == null) {
            JOptionPane.showMessageDialog(null, "Vacante no encontrado");
        } else {

            int id_empresa = Integer.parseInt(JOptionPane.showInputDialog(EmpresaController.getAll()+"\nPor favor ingrese el id de la empresa nueva: ",objVacante.getId_empresa()));
            String titulo = JOptionPane.showInputDialog("Por favor ingrese el titulo de la vacante nueva: ",objVacante.getTitulo());
            String descripcion = JOptionPane.showInputDialog("Por favor ingrese la descripcion nueva: ",objVacante.getDescripcion());
            String duracion = JOptionPane.showInputDialog("Por favor ingrese la duracion nueva: ",objVacante.getDuracion());
            String tecnologia = JOptionPane.showInputDialog("Por favor ingrese la tecnologia nueva: ",objVacante.getTecnologia());


            objVacante.setId_empresa(id_empresa);
            objVacante.setTitulo(titulo);
            objVacante.setDescripcion(descripcion);
            objVacante.setDuracion(duracion);
            objVacante.setEstado("ACTIVO");
            objVacante.setTecnologia(tecnologia);

            objModel.update(objVacante);
        }
    }
    public static String getByTitle(){
        VacanteModel objModel = new VacanteModel();
        String titulo = JOptionPane.showInputDialog("Por favor ingrese el titulo a buscar: ");
        String listVacantes = "Lista de todas las Vacantes con el titulo ("+titulo+"): \n";
        for (Object i : objModel.findByTitle(titulo)){
            Vacante objVacante = (Vacante) i;
            listVacantes += objVacante.toString()+"\n";
        }
        return listVacantes;
    }
    public static String getByTechnology(){
        VacanteModel objModel = new VacanteModel();
        String tecnologia = JOptionPane.showInputDialog("Por favor ingrese la tecnologia a buscar: ");
        String listVacantes = "Lista de todas las Vacantes con la tecnologia ("+tecnologia+"): \n";
        for (Object i : objModel.findByTechnology(tecnologia)){
            Vacante objVacante = (Vacante) i;
            listVacantes += objVacante.toString()+"\n";
        }
        return listVacantes;
    }
    public static void updateStatus() {
        VacanteModel objModel = new VacanteModel();
        int idFind = Integer.parseInt(JOptionPane.showInputDialog(getAll() + "\n Por favor ingrese el id de la vacante a la cual le desea cambiar el estado: "));
        Vacante objVacante = (Vacante) objModel.findById(idFind);
        if (objVacante == null) {
            JOptionPane.showMessageDialog(null, "Vacante no encontrado");
        } else {
            if (objVacante.getEstado().equals("ACTIVO")){
                String estado = JOptionPane.showInputDialog("El estado de la vacante es 'ACTIVO' desea desactivarlo? (si)/(no): ");
                if (estado.toLowerCase().equals("si")){
                    objVacante.setEstado("INACTIVO");
                    objModel.update(objVacante);
                }
            }else {
                String estado = JOptionPane.showInputDialog("El estado de la vacante es 'INACTIVO' desea Activarlo? (si)/(no): ");
                if (estado.toLowerCase().equals("si")){
                    objVacante.setEstado("ACTIVO");
                    objModel.update(objVacante);
                }
            }
        }
    }
    public static String getActivas(){
        VacanteModel objModel = new VacanteModel();
        String listVacantes = "Lista de todas las Vacantes activas: \n";
        for (Object i : objModel.findActivas()){
            Vacante objVacante = (Vacante) i;
            listVacantes += objVacante.toString()+"\n";
        }
        return listVacantes;
    }
    public static void updateStatusAuto(int idFind){
        VacanteModel objModel = new VacanteModel();
        Vacante objVacante = (Vacante) objModel.findById(idFind);
        if (objVacante == null) {
            JOptionPane.showMessageDialog(null, "Vacante no encontrada");
        } else {
            objVacante.setEstado("INACTIVO");
            objModel.update(objVacante);
        }
    }

}
