public class Produit {
    private int code;
    private String nom;
    private double prix;
    private int quantite;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }



    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }



    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Produit() {}
    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + code +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                ", nombreEnStock=" + quantite +
                '}';
    }

    public double calculerValeur()
    {
        return quantite * prix;
    }
}
