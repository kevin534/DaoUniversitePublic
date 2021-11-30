package Model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


public class Enseignant {

  private String id;
  private String nomEnseignant;
  private String prenomEnseignant;
  private String emailEnseignant;
  private String addEnseignant;
  private Integer numTelephoneEnseignant;
  private String statusEnseignant;
  private String codeCategorieEnseignant;
  private List<Matiere> listMatiere = new ArrayList<>();

    public List<Matiere> getListMatiere() {
        return listMatiere;
    }

    public void setListMatiere(List<Matiere> listMatiere) {
        this.listMatiere = listMatiere;
    }

    public String getAddEnseignant() {
    return addEnseignant;
  }

  public void setAddEnseignant(String addEnseignant) {
    this.addEnseignant = addEnseignant;
  }

  public String getStatusEnseignant() {
    return statusEnseignant;
  }
  //Ajoute une matière à un professeur
  public void addMatiere(Matiere matiere){
    this.listMatiere.add(matiere);
  }
  public Enseignant(){

  }

  public void setId(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }


  public String getNomEnseignant() {
    return nomEnseignant;
  }

  public void setNomEnseignant(String nomEnseignant) {
    this.nomEnseignant = nomEnseignant;
  }

  public String getPrenomEnseignant() {
    return prenomEnseignant;
  }

  public void setPrenomEnseignant(String prenomEnseignant) {
    this.prenomEnseignant = prenomEnseignant;
  }

  public String getEmailEnseignant() {
    return emailEnseignant;
  }

  public void setEmailEnseignant(String emailEnseignant) {
    this.emailEnseignant = emailEnseignant;
  }

  public Integer getNumTelephoneEnseignant() {
    return numTelephoneEnseignant;
  }

  public void setNumTelephoneEnseignant(Integer numTelephoneEnseignant) {
    this.numTelephoneEnseignant = numTelephoneEnseignant;
  }

  public String getStatusEnseignant(String statut_enseignant) {
    return statusEnseignant;
  }

  public void setStatusEnseignant(String statusEnseignant) {
    this.statusEnseignant = statusEnseignant;
  }

  public String getCodeCategorieEnseignant() {
    return codeCategorieEnseignant;
  }

  public void setCodeCategorieEnseignant(String codeCategorieEnseignant) {
    this.codeCategorieEnseignant = codeCategorieEnseignant;
  }

  @Override
  public String toString() {
    return "Enseignant{" +
            "id=" + id +
            ", nomEnseignant='" + nomEnseignant + '\'' +
            ", prenomEnseignant='" + prenomEnseignant + '\'' +
            ", emailEnseignant='" + emailEnseignant + '\'' +
            ", numTelephoneEnseignant='" + numTelephoneEnseignant + '\'' +
            ", statusEnseignant='" + statusEnseignant + '\'' +
            ", codeCategorieEnseignant='" + codeCategorieEnseignant + '\'' +
            '}';
  }




}
