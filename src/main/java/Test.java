import DAO.AbstractDAO;
import DAO.EnseignantDAO;
import DataSource.DBCPDataSource;
import Model.Enseignant;
import exceptions.DataAccessException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws SQLException, DataAccessException {

        List<Enseignant> list ;
        Enseignant enseignant = new Enseignant();
        enseignant.setId("ABCD");
        enseignant.setNomEnseignant("Francois");

        EnseignantDAO enseignantDAO = new EnseignantDAO();
        enseignantDAO.update(enseignant);
        enseignant.setId("TOTO");
        enseignant.setNomEnseignant("Toukam");
        enseignant.setPrenomEnseignant("Xavier");
        enseignant.setAddEnseignant("Billy");
        enseignant.setEmailEnseignant("xavier@yahoo.fr");
        enseignant.setNumTelephoneEnseignant(695825524);
        enseignant.setStatusEnseignant("Plein Temps");
        enseignant.setCodeCategorieEnseignant("OMEGA");

        enseignantDAO.persist(enseignant);
        System.out.println(".............................................................");
        System.out.println(enseignantDAO.persist());
        System.out.println(".............................................................");
        list = enseignantDAO.findAllS();
        System.out.println(".............................................................");
        for (Enseignant e:list
             ) {
            if(enseignant.getId().equals(e.getId())){
                System.out.println(e.getId());
            }
            System.out.println(e);
        }

        System.out.println(".............................................................");

       // System.out.println(enseignantDAO.findAll());






        //System.out.println(enseignant);


        /*String url = "jdbc:h2:~/test";
                String user = "sa";
                String password = "1234";

                Enseignant enseignant = new Enseignant();
                enseignant.setId("JUU");
                enseignant.setNomEnseignant("Francois");


        EnseignantDAO enseignantDAO = new EnseignantDAO(url,user,password);
       enseignantDAO.SaveEnseignant(enseignant);
       enseignant = enseignantDAO.getEnseignant("JAJ");

       System.out.println(enseignant);
*/

    }
}
