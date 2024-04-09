package Model;

import Database.ConfigDB;
import entity.Empresa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpresaModel {
    public List<Object> findAll() {
        Connection objConnection  = ConfigDB.openConnection();
        List<Object> listEmpresas = new ArrayList<>();
        try {
            String sql = "SELECT * FROM empresa ;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();


            while (objResult.next()){
                Empresa objEmpresa = new Empresa();


                objEmpresa.setId_empresa(objResult.getInt("id_empresa"));
                objEmpresa.setNombre(objResult.getString("nombre"));
                objEmpresa.setSector(objResult.getString("sector"));
                objEmpresa.setUbicacion(objResult.getString("ubicacion"));
                objEmpresa.setContacto(objResult.getString("contacto"));

                listEmpresas.add(objEmpresa);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listEmpresas;
    }

}
