package Model;

import Database.CRUD;
import Database.ConfigDB;
import entity.Contratacion;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratacionModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection =  ConfigDB.openConnection();


        Contratacion objContratacion = (Contratacion) obj;
        try {
            String sql = "INSERT INTO contratación (id_vacante,id_coder,estado,salario) VALUES(?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objContratacion.getId_vacante());
            objPrepare.setInt(2, objContratacion.getId_coder());
            objPrepare.setString(3, objContratacion.getEstado());
            objPrepare.setDouble(4, objContratacion.getSalario());


            objPrepare.execute();


            ResultSet objResult = objPrepare.getGeneratedKeys();


            while (objResult.next()){
                objContratacion.setId_contratacion(objResult.getInt(1));
                Contratacion objContratacion2 = (Contratacion) this.findById(objResult.getInt(1));
                objContratacion.setFecha_aplicacion(objContratacion2.getFecha_aplicacion());
            }
            JOptionPane.showMessageDialog(null,"Contratacion añadida correctamente");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }


        ConfigDB.closeConnection();
        return objContratacion;
    }


    @Override
    public List<Object> findAll() {
        Connection objConnection  = ConfigDB.openConnection();
        List<Object> listContrataciones = new ArrayList<>();
        try {
            String sql = "SELECT * FROM contratación ;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();


            while (objResult.next()){
                Contratacion objContratacion = new Contratacion();

                objContratacion.setId_contratacion(objResult.getInt("id_contratacion"));
                objContratacion.setId_vacante(objResult.getInt("id_vacante"));
                objContratacion.setId_coder(objResult.getInt("id_coder"));
                objContratacion.setFecha_aplicacion(objResult.getString("fecha_aplicacion"));
                objContratacion.setEstado(objResult.getString("estado"));
                objContratacion.setSalario(objResult.getDouble("salario"));


                listContrataciones.add(objContratacion);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listContrataciones;
    }


    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Contratacion objContratacion = (Contratacion) obj;


        boolean isUpdate = false;
        try {
            String sql = "UPDATE contratación SET id_vacante=?,id_coder=?,estado=?,fecha_aplicacion=?,salario= ?  WHERE id_contratacion =?; ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);



            objPrepare.setInt(1,objContratacion.getId_vacante());
            objPrepare.setInt(2,objContratacion.getId_coder());
            objPrepare.setString(3,objContratacion.getEstado());
            objPrepare.setString(4,objContratacion.getFecha_aplicacion());
            objPrepare.setDouble(5,objContratacion.getSalario());
            objPrepare.setInt(6,objContratacion.getId_contratacion());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected >0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Actualizado correctamente ");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }


    @Override
    public boolean delete(Object obj) {
        Contratacion objContratacion = (Contratacion) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean isDelete = false;
        try {
            String sql = "DELETE FROM contratación WHERE id_contratacion =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objContratacion.getId_contratacion());


            int totalAffected = objPrepare.executeUpdate();
            if (totalAffected>0){
                isDelete=true;
                JOptionPane.showMessageDialog(null,"Eliminado correctamente");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return isDelete;
    }


    public Contratacion findById(int id){
        Connection objConnection = ConfigDB.openConnection();


        Contratacion objContratacion = null;
        try {
            String sql  = "SELECT * FROM contratación WHERE id_contratacion =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,id);
            ResultSet objResult = objPrepare.executeQuery();


            while (objResult.next()){
                objContratacion = new Contratacion();
                objContratacion.setId_contratacion(objResult.getInt("id_contratacion"));
                objContratacion.setId_vacante(objResult.getInt("id_vacante"));
                objContratacion.setId_coder(objResult.getInt("id_coder"));
                objContratacion.setFecha_aplicacion(objResult.getString("fecha_aplicacion"));
                objContratacion.setEstado(objResult.getString("estado"));
                objContratacion.setSalario(objResult.getDouble("salario"));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return objContratacion;
    }
    public boolean updateStatus(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Contratacion objContratacion = (Contratacion) obj;


        boolean isUpdate = false;
        try {
            String sql = "UPDATE contratación SET estado=? WHERE id_contratacion =?; ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objContratacion.getEstado());
            objPrepare.setInt(2,objContratacion.getId_contratacion());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected >0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Actualizado correctamente ");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }
    public Contratacion printAllContratacion(int id){
        Connection objConnection = ConfigDB.openConnection();

        Contratacion objContratacion = null;
        try {
            String sql  = "SELECT vacante.titulo, vacante.descripcion, vacante.tecnologia, contratación.salario,   FROM vacante INNER JOIN contratación ON contratación.id_vacante = vacante.id_vacante WHERE vacante.id_vacante =?;SELECT empresa.nombre, empresa.ubicacion FROM empresa INNER JOIN vacante ON vacante.id_empresa = empresa.id_empresa WHERE empresa.id_empresa =?;SELECT coder.nombre, coder.apellidos, coder.documento  FROM coder INNER JOIN contratación ON coder.id_coder = contratación.id_coder WHERE coder.id_coder =?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,id);
            ResultSet objResult = objPrepare.executeQuery();


            while (objResult.next()){
                objContratacion = new Contratacion();
                objContratacion.setId_contratacion(objResult.getInt("id_contratacion"));
                objContratacion.setId_vacante(objResult.getInt("id_vacante"));
                objContratacion.setId_coder(objResult.getInt("id_coder"));
                objContratacion.setFecha_aplicacion(objResult.getString("fecha_aplicacion"));
                objContratacion.setEstado(objResult.getString("estado"));
                objContratacion.setSalario(objResult.getDouble("salario"));
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return objContratacion;
    }

}
