package Controller;

import Model.CoderModel;
import Model.VacanteModel;
import entity.Coder;
import entity.Vacante;

import javax.swing.*;

public class CoderController {
    public static void create(){
        CoderModel objModel = new CoderModel();

        String nombre = JOptionPane.showInputDialog("Por favor ingrese el nombre: ");
        String apellidos = JOptionPane.showInputDialog("Por favor ingrese los apellidos: ");
        String documento = JOptionPane.showInputDialog("Por favor ingrese el numero de documento: ");
        if (objModel.verificarDocumento(documento) == true){
            int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el numero de cohorte: "));
            String cv = JOptionPane.showInputDialog("Por favor ingrese su CV: ");
            String clan = JOptionPane.showInputDialog("Por favor ingrese el clan: ");


            Coder objCoder = new Coder();
            objCoder.setNombre(nombre);
            objCoder.setApellidos(apellidos);
            objCoder.setDocumento(documento);
            objCoder.setCohorte(cohorte);
            objCoder.setCv(cv);
            objCoder.setClan(clan);


            objCoder = (Coder) objModel.insert(objCoder);
            JOptionPane.showMessageDialog(null,objCoder.toString());
        }else {
            JOptionPane.showMessageDialog(null,"Numero de documento ya existente");
        }

    }


    public static String getAll(){
        CoderModel objModel = new CoderModel();
        String listCoders = "Lista de todos los Coders: \n";
        for (Object i : objModel.findAll()){
            Coder objCoder = (Coder) i;
            listCoders += objCoder.toString()+"\n";
        }
        return listCoders;
    }
    public static void delete(){
        CoderModel objModel = new CoderModel();
        int id_eliminar = Integer.parseInt(JOptionPane.showInputDialog(getAll()+"\nPor favor ingrese el id del Coder a borrar: "));
        Coder objCoder = (Coder) objModel.findById(id_eliminar);


        int confirm = 1;
        if (objCoder == null){
            JOptionPane.showMessageDialog(null,"Coder no encontrado");
        }else{
            confirm = JOptionPane.showConfirmDialog(null,objCoder.toString()+"\nEstas seguro que deseas borrar este Coder?");
            if (confirm == 0){
                objModel.delete(objCoder);
            }
        }
    }


    public static void update() {
        CoderModel objModel = new CoderModel();
        int idFind = Integer.parseInt(JOptionPane.showInputDialog(getAll() + "\n Por favor ingrese el id del Coder que desea actualizar: "));
        Coder objCoder = (Coder) objModel.findById(idFind);
        if (objCoder == null) {
            JOptionPane.showMessageDialog(null, "Coder no encontrado");
        } else {
            String nombre = JOptionPane.showInputDialog("Por favor ingrese el nombre nuevo: ",objCoder.getNombre());
            String apellidos = JOptionPane.showInputDialog("Por favor ingrese los apellidos nuevos: ",objCoder.getApellidos());
            String documento = JOptionPane.showInputDialog("Por favor ingrese el numero de documento nuevo: ",objCoder.getDocumento());
            int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el numero de cohorte nuevo: ",objCoder.getCohorte()));
            String cv = JOptionPane.showInputDialog("Por favor ingrese su CV nuevo: ",objCoder.getCv());
            String clan = JOptionPane.showInputDialog("Por favor ingrese el clan nuevo: ",objCoder.getClan());


            objCoder.setNombre(nombre);
            objCoder.setApellidos(apellidos);
            objCoder.setDocumento(documento);
            objCoder.setCohorte(cohorte);
            objCoder.setCv(cv);
            objCoder.setClan(clan);

            objModel.update(objCoder);
        }
    }
    public static String getByCohorte(){
        CoderModel objModel = new CoderModel();
        int cohorte = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el numero de la corte a buscar: "));
        String listCoders = "Lista de todas los coders de la cohorte ("+cohorte+"): \n";
        for (Object i : objModel.findByCohorte(cohorte)){
            Coder objCoder = (Coder) i;
            listCoders += objCoder.toString()+"\n";
        }
        return listCoders;
    }
    public static String getByClan(){
        CoderModel objModel = new CoderModel();
        String clan = JOptionPane.showInputDialog("Por favor ingrese el nombre del clan a buscar: ");
        String listCoders = "Lista de todas los coders del clan ("+clan+"): \n";
        for (Object i : objModel.findByClan(clan)){
            Coder objCoder = (Coder) i;
            listCoders += objCoder.toString()+"\n";
        }
        return listCoders;
    }
    public static String getByTechnology(){
        CoderModel objModel = new CoderModel();
        String technology = JOptionPane.showInputDialog("Por favor ingrese la tecnologia a buscar: ");
        String listCoders = "Lista de todas los coders con la tecnologia ("+technology+"): \n";
        for (Object i : objModel.findByTechnology(technology)){
            Coder objCoder = (Coder) i;
            listCoders += objCoder.toString()+"\n";
        }
        return listCoders;
    }

}
