import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final int MAX_PRODUITS = 100;
    private static Produit[] produits = new Produit[MAX_PRODUITS];
    private static int nombreProduits = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            printMenu();
            choix = scanner.nextInt();
            scanner.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    ajouterProduit(scanner);
                    break;
                case 2:
                    modifierProduit(scanner);
                    break;
                case 3:
                    supprimerProduit(scanner);
                    break;
                case 4:
                    afficherProduits();
                    break;
                case 5:
                    rechercherProduit(scanner);
                    break;
                case 6:
                    System.out.println("Valeur totale du stock : " + calculerValeurStock());
                    break;
                case 7:
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        } while (choix != 7);

        scanner.close();
    }

    private static void printMenu()
    {
        System.out.println("Gestion de Stock");
        System.out.println("1. Ajouter un produit");
        System.out.println("2. Modifier un produit");
        System.out.println("3. Supprimer un produit");
        System.out.println("4. Afficher la liste des produits");
        System.out.println("5. Rechercher un produit par nom");
        System.out.println("6. Calculer la valeur totale du stock");
        System.out.println("0. Quitter");
        System.out.print("Votre choix : ");
    }

    public static void ajouterProduit(Scanner sc)
    {
        if (nombreProduits >= MAX_PRODUITS) {
            System.out.println("Erreur : Le stock est plein (100 produits maximum).");
            return;
        }
        System.out.print("Entrez le code du produit : ");
        int code = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nombreProduits; i++) {
            if(produits[i].getCode() == code)
            {
                System.out.println("Erreur : Le code du produit existe déjà.");
                return;
            }
        }

        System.out.println("Entrer le nom du produit : ");
        String nom = sc.nextLine();

        System.out.println("Enter la quantite : ");
        int quantite = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter le prix unitaire : ");
        double prix = sc.nextDouble();
        sc.nextLine();

        if (quantite < 0 || prix < 0) {
            System.out.println("Erreur : La quantité et le prix doivent être positifs.");
            return;
        }

        produits[nombreProduits] = new Produit(code, nom, quantite, prix);
        nombreProduits++;
        System.out.println("Produit ajouté avec succès.");
    }

    public static void modifierProduit(Scanner sc)
    {
        System.out.println("Entrez le code du produit : ");
        int code = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < nombreProduits; i++) {
            if(produits[i].getCode() == code)
            {
                System.out.println("Enter le nom du produit : ");
                String nom = sc.nextLine();
                System.out.println("Enter la quantite : ");
                int quantite = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter le prix unitaire : ");
                double prix = sc.nextDouble();
                sc.nextLine();

                if (quantite < 0 || prix < 0) {
                    System.out.println("Erreur : La quantité et le prix doivent être positifs.");
                    return;
                }
                produits[i].setNom(nom);
                produits[i].setQuantite(quantite);
                produits[i].setPrix(prix);
                System.out.println("Produit modifié avec succès.");
                return;
            }
        }
        System.out.println("Erreur : Aucun produit avec ce code n'a été trouvé.");
    }

    public static void supprimerProduit(Scanner sc)
    {
        System.out.println("Entrez le code du produit : ");
        int code = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < nombreProduits; i++) {
            if(produits[i].getCode() == code)
            {
                for(int j = i; j < nombreProduits - 1; j++)
                {
                    produits[j] = produits[j+1];
                }
                produits[nombreProduits - 1] = null;
                nombreProduits--;
                System.out.println("Produit supprimé avec succès.");
                return;
            }
        }
        System.out.println("Erreur : Aucun produit avec ce code n'a été trouvé.");
    }

    public static void afficherProduits() {
        if(nombreProduits == 0){
            System.out.println("Aucun produit en stock.");
            return;
        }
        System.out.println("\n--- Liste des produits ---");
        for (int i = 0; i < nombreProduits; i++) {
            System.out.println(produits[i]);
        }
    }

    public static void rechercherProduit(Scanner scanner) {
        System.out.print("Entrez le nom du produit à rechercher : ");
        String nom = scanner.nextLine();

        for (int i = 0; i < nombreProduits; i++) {
            if (produits[i].getNom().equals(nom)) {
                System.out.println("Produit trouvé : " + produits[i]);
                return;
            }
        }

        System.out.println("Aucun produit avec ce nom n'a été trouvé.");
    }
    public static double calculerValeurStock() {
        double valeurTotale = 0;
        for (int i = 0; i < nombreProduits; i++) {
            valeurTotale += produits[i].calculerValeur();
        }
        return valeurTotale;
    }

}
