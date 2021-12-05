package Model;

public class Etudiant {
    private String noms;
    private String prenoms;
    private Long id;
    private String email;

    public Etudiant(String noms, String prenoms, Long id, String email) {
        this.noms = noms;
        this.prenoms = prenoms;
        this.id = id;
        this.email = email;
    }

    public void setNoms(String noms) {
        this.noms = noms;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoms() {
        return noms;
    }
    @Override
    public String toString() {
        return "Etudiant{" +
                "noms='" + noms + '\'' +
                ", prenoms='" + prenoms + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
