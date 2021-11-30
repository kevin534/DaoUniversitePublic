package DAO;

import DataSource.DBCPDataSource;
import exceptions.DataAccessException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDAO<E>  implements dao<E>{
    private static final String JUU = "JUU";
    protected Connection connection;
 protected PreparedStatement updatePS;
 protected PreparedStatement persistPS;
 protected  PreparedStatement findAllPS;
    protected  PreparedStatement findListMatiere;

 public AbstractDAO(String persistPS,String updatePS){
     Connection _connection = null;
     PreparedStatement  _updatePS = null;
     PreparedStatement _persistPS = null;
     PreparedStatement _findAllPS= null;
     PreparedStatement _findListMatiere = null;

     try {
         _connection = DBCPDataSource.getConnection();
         System.out.println("connection is not null: "+ _connection);
         _persistPS = _connection.prepareStatement(persistPS);
         _updatePS = _connection.prepareStatement(updatePS);
         _findAllPS = _connection.prepareStatement("SELECT * FROM " + getTableName());
         _findListMatiere = _connection.prepareStatement("\nSELECT * FROM ENSEIGNANT LEFT JOIN MATIERE ON PROF_ID = ID_ENSEIGNANT AND PROF_ID =  'JUU' ");
     } catch (SQLException e) {
         e.printStackTrace();
     }
     this.connection= _connection;
     this.updatePS = _updatePS;
     this.persistPS = _persistPS;
     this.findAllPS = _findAllPS;
     this.findListMatiere = _findListMatiere;

 }

    public abstract String getTableName();
    protected abstract E fromResultSet(ResultSet resultSet) throws SQLException;
    @Override
    public List<E> findAll() throws DataAccessException {
        List<E> entityList = new ArrayList<>();
        try {
            ResultSet rs = findAllPS.executeQuery();
            while (rs.next()) entityList.add(fromResultSet(rs));
        } catch (SQLException e) {
            throw new DataAccessException(e.getLocalizedMessage());
        }
        return entityList;
    }

 public void update() throws DataAccessException{
     try {
         updatePS.executeUpdate();
        System.out.println("connect matiere:     "+findListMatiere);
     } catch (SQLException e) {
         throw new DataAccessException(e.getLocalizedMessage());
     }

 }


    public E persist() throws DataAccessException{

        try {
         persistPS.executeUpdate();
           //ResultSet rs = persistPS.executeQuery();

        } catch (SQLException e) {
            throw  new DataAccessException(e.getLocalizedMessage());
        }
        return null;
    }


    public abstract List<E> findAllS() throws DataAccessException;
}
