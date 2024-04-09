package Model;

import Database.CRUD;
import Database.ConfigDB;
import com.sun.jdi.VoidValue;
import entity.Empresa;
import entity.Vacante;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacanteModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection =  ConfigDB.openConnection();

        Vacante objVacante = (Vacante) obj;
        try {
            String sql = "INSERT INTO vacante (id_empresa,titulo,descripcion,duracion,estado,tecnologia) VALUES(?,?,?,?,?,?);";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            objPrepare.setInt(1, objVacante.getId_empresa());
            objPrepare.setString(2, objVacante.getTitulo());
            objPrepare.setString(3, objVacante.getDescripcion());
            objPrepare.setString(4, objVacante.getDuracion());
            objPrepare.setString(5, objVacante.getEstado());
            objPrepare.setString(6, objVacante.getTecnologia());


            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();


            while (objResult.next()){
                objVacante.setId_vacante(objResult.getInt(1));
            }
            JOptionPane.showMessageDialog(null,"Vacante añadida correctamente");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        ConfigDB.closeConnection();
        return objVacante;
    }


    @Override
    public List<Object> findAll() {
        Connection objConnection  = ConfigDB.openConnection();
        List<Object> listVacantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vacante ;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Vacante objVacante = new Vacante();

                objVacante.setId_vacante(objResult.getInt("id_vacante"));
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));
                objVacante.setTecnologia(objResult.getString("tecnologia"));

                listVacantes.add(objVacante);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacantes;
    }


    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;

        boolean isUpdate = false;
        try {
            String sql = "UPDATE vacante SET id_empresa=?,titulo=?,descripcion=?,duracion=?,estado=?,tecnologia=? WHERE id_vacante =?; ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);


            objPrepare.setInt(1,objVacante.getId_empresa());
            objPrepare.setString(2,objVacante.getTitulo());
            objPrepare.setString(3,objVacante.getDescripcion());
            objPrepare.setString(4,objVacante.getDuracion());
            objPrepare.setString(5,objVacante.getEstado());
            objPrepare.setString(6,objVacante.getTecnologia());
            objPrepare.setInt(7,objVacante.getId_vacante());


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
        Vacante objVacante = (Vacante) obj;
        Connection objConnection = ConfigDB.openConnection();
        boolean isDelete = false;
        try {
            String sql = "DELETE FROM vacante WHERE id_vacante =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,objVacante.getId_vacante());


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


    public Vacante findById(int id){
        Connection objConnection = ConfigDB.openConnection();

        Vacante objVacante = null;
        try {
            String sql  = "SELECT * FROM vacante WHERE id_vacante =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1,id);
            ResultSet objResult = objPrepare.executeQuery();


            while (objResult.next()){
                objVacante = new Vacante();
                objVacante.setId_vacante(objResult.getInt("id_vacante"));
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));
                objVacante.setTecnologia(objResult.getString("tecnologia"));

            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return objVacante;
    }
    public List<Object> findByTitle(String titulo) {
        Connection objConnection  = ConfigDB.openConnection();
        List<Object> listVacantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vacante WHERE titulo LIKE ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+titulo+"%");
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Vacante objVacante = new Vacante();

                objVacante.setId_vacante(objResult.getInt("id_vacante"));
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));
                objVacante.setTecnologia(objResult.getString("tecnologia"));

                listVacantes.add(objVacante);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacantes;
    }
    public List<Object> findByTechnology(String tecnologia) {
        Connection objConnection  = ConfigDB.openConnection();
        List<Object> listVacantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vacante WHERE tecnologia LIKE ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"%"+tecnologia+"%");
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Vacante objVacante = new Vacante();

                objVacante.setId_vacante(objResult.getInt("id_vacante"));
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));
                objVacante.setTecnologia(objResult.getString("tecnologia"));

                listVacantes.add(objVacante);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacantes;
    }
    public boolean updateStatus(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Vacante objVacante = (Vacante) obj;

        boolean isUpdate = false;
        try {
            String sql = "UPDATE vacante SET estado=? WHERE id_vacante =?; ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objVacante.getEstado());
            objPrepare.setInt(2,objVacante.getId_vacante());


            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected >0){
                isUpdate = true;
                JOptionPane.showMessageDialog(null, "Operacion realizada correctamente ");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return isUpdate;
    }
    public List<Object> findActivas() {
        Connection objConnection  = ConfigDB.openConnection();
        List<Object> listVacantes = new ArrayList<>();
        try {
            String sql = "SELECT * FROM vacante WHERE estado LIKE ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1,"ACTIVO");
            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()){
                Vacante objVacante = new Vacante();

                objVacante.setId_vacante(objResult.getInt("id_vacante"));
                objVacante.setId_empresa(objResult.getInt("id_empresa"));
                objVacante.setTitulo(objResult.getString("titulo"));
                objVacante.setDescripcion(objResult.getString("descripcion"));
                objVacante.setDuracion(objResult.getString("duracion"));
                objVacante.setEstado(objResult.getString("estado"));
                objVacante.setTecnologia(objResult.getString("tecnologia"));

                listVacantes.add(objVacante);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listVacantes;
    }

}
