package Controller;

import Model.EmpresaModel;
import entity.Empresa;

public class EmpresaController {
    public static String getAll(){
        EmpresaModel objModel = new EmpresaModel();
        String listEmpresas = "Lista de todas las Empresas: \n";
        for (Object i : objModel.findAll()){
            Empresa objEmpresa = (Empresa) i;
            listEmpresas += objEmpresa.toString()+"\n";
        }
        return listEmpresas;
    }

}
