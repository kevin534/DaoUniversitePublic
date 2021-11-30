package DAO;

import Model.Enseignant;
import exceptions.DataAccessException;
import lombok.extern.java.Log;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log
public class EnseignantDAO extends AbstractDAO<Enseignant>{
    private String url;
    private String username;
    private String password;

    public EnseignantDAO()throws SQLException {
        super("INSERT INTO ENSEIGNANT (ID_ENSEIGNANT,NOM_ENSEIGNANT,PRENOM_ENSEIGNANT,ADD_ENSEIGNANT,EMAIL_ENSEIGNANT,TELEPHONE_ENSEIGNANT,STATUT_ENSEIGNANT,CODE_CATEGORIE) VALUES (?,?,?,?,?,?,?,?)",
                "UPDATE ENSEIGNANT SET NOM_ENSEIGNANT= ? WHERE ID_ENSEIGNANT= ?");
    }

    @Override
    public String getTableName() {
        return "ENSEIGNANT";
    }

    protected Enseignant fromResultSet(ResultSet rs) throws SQLException {
        Enseignant enseignant = new Enseignant();
        enseignant.setId(rs.getString("ID_ENSEIGNANT"));
        enseignant.setNomEnseignant(rs.getString("NOM_ENSEIGNANT"));
        enseignant.setPrenomEnseignant(rs.getString("PRENOM_ENSEIGNANT"));
        enseignant.setEmailEnseignant(rs.getString("EMAIL_ENSEIGNANT"));
        enseignant.setNumTelephoneEnseignant(rs.getInt("TELEPHONE_ENSEIGNANT"));
        enseignant.setStatusEnseignant(rs.getString("STATUT_ENSEIGNANT"));
        enseignant.setCodeCategorieEnseignant(rs.getString("CODE_CATEGORIE"));
        return enseignant;
    }
public Enseignant persist(Enseignant enseignant) throws DataAccessException {
    try {
        persistPS.setString(1,enseignant.getId());
        persistPS.setString(2,enseignant.getNomEnseignant());
        persistPS.setString(3,enseignant.getPrenomEnseignant());
        persistPS.setString(4,enseignant.getAddEnseignant());
        persistPS.setString(5,enseignant.getEmailEnseignant());
        persistPS.setInt(6,enseignant.getNumTelephoneEnseignant());
        persistPS.setString(7,enseignant.getStatusEnseignant());
        persistPS.setString(8,enseignant.getCodeCategorieEnseignant());

    } catch (SQLException e) {
        throw new DataAccessException(e.getLocalizedMessage());
    }
   return super.persist();

}
    @Override
    public void update(Enseignant enseignant) throws DataAccessException {

        try {
            updatePS.setString(1,enseignant.getNomEnseignant());
            updatePS.setString(2,enseignant.getId());
            System.out.println(enseignant.getNomEnseignant()+"  save into the data base!");
        } catch (SQLException e) {
            throw new DataAccessException(e.getLocalizedMessage());
        }
        super.update();

    }

    @Override
    public List<Enseignant> findAllS() throws DataAccessException {
        List<Enseignant> entityList = new ArrayList<>();
        try {
            ResultSet rs = findAllPS.executeQuery();
           Enseignant enseignant = new Enseignant();
            while (rs.next()){
                enseignant.setId(rs.getString("ID_ENSEIGNANT"));
                enseignant.setNomEnseignant(rs.getString("NOM_ENSEIGNANT"));
                enseignant.setPrenomEnseignant(rs.getString("PRENOM_ENSEIGNANT"));
                enseignant.setEmailEnseignant(rs.getString("EMAIL_ENSEIGNANT"));
                enseignant.setNumTelephoneEnseignant(rs.getInt("TELEPHONE_ENSEIGNANT"));
                enseignant.setStatusEnseignant(rs.getString("STATUT_ENSEIGNANT"));
                enseignant.setCodeCategorieEnseignant(rs.getString("CODE_CATEGORIE"));

            }
            entityList.add(enseignant);
            System.out.println(entityList);
            return  entityList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    /*public EnseignantDAO(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
    public Enseignant SaveEnseignant(Enseignant enseignant){
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            if(enseignant.getId() != null){
                PreparedStatement statement =
                        connection.prepareStatement("UPDATE ENSEIGNANT SET NOM_ENSEIGNANT= ? WHERE ID_ENSEIGNANT= ? ");
                statement.setString(1,enseignant.getNomEnseignant());
                statement.setString(2,enseignant.getId());
                statement.execute();

            }else{
                PreparedStatement statement =
                        connection.prepareStatement("INSERT INTO ENSEIGNANT (ID_ENSEIGNANT,NOM_ENSEIGNANT,PRENOM_ENSEIGNANT) VALUES (?,?,?)");
                statement.setString(1, String.valueOf(enseignant.getId()));
                statement.setString(2,enseignant.getNomEnseignant());
                statement.setString(3,enseignant.getPrenomEnseignant());
                //statement.setString(4,enseignant.getEmailEnseignant());
                statement.execute();
            }
            System.out.println(enseignant.getNomEnseignant()+"  save into the data base!");

        } catch (SQLException e) {
            e.printStackTrace();
            e.getMessage();
            System.out.println("unable to save the enseignant");

        }
        return enseignant;
    }

    public Enseignant getEnseignant(String id){
        try {
            Connection connection = DriverManager.getConnection(url,username,password);
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM ENSEIGNANT WHERE ID_ENSEIGNANT = ?");
            statement.setString(1,id);

            ResultSet resultSet = statement.executeQuery();

            Enseignant enseignant = new Enseignant();
            while (resultSet.next()){
                enseignant.setIdresultSet.getString(("ID_ENSEIGNANT"));
                enseignant.setNomEnseignant(resultSet.getString("NOM_ENSEIGNANT"));
                enseignant.setPrenomEnseignant(resultSet.getString("PRENOM_ENSEIGNANT"));
                enseignant.setEmailEnseignant(resultSet.getString("EMAIL_ENSEIGNANT"));
                enseignant.setNumTelephoneEnseignant(resultSet.getInt("TELEPHONE_ENSEIGNANT"));
                enseignant.setStatusEnseignant(resultSet.getString("STATUT_ENSEIGNANT"));
                enseignant.setCodeCategorieEnseignant(resultSet.getString("CODE_CATEGORIE"));


            }
            return  enseignant;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

     */
}
