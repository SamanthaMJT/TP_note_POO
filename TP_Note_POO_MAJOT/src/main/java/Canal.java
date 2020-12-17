import java.util.*;

public class Canal implements Comparable<Canal>, Destinataire {

    private Map<Role, List<Utilisateur>> mapping_role_utilisateurs;
    private int ordre;
    private List<Webhook> webhooks;
    private String nom;
    private Map<Role, List<Habilitation>> mapping_role_habilitations;
    private List<Message> historiques;

    public Canal(){
        ServeurDiscussion serv = new ServeurDiscussion();
        mapping_role_utilisateurs = serv.getMapping_role_utilisateurs();
        ordre = 1;
        webhooks = new ArrayList<>();
        webhooks.add(new Webhook());
        nom = "Les copains";
        mapping_role_habilitations = serv.getMapping_role_habilitations();
        historiques = new ArrayList<>();
    }

    public void ecrireMessage(Utilisateur user, Message message) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Tappez votre message :");
        String str = sc.nextLine();
        System.out.println("" + user.getLogin() + " : " + str);
        message.setTexte(str);
        message.setAuteur(user);
        message.setDestinataire(user);
        historiques.add(message);
    }

    @Override
    public int compareTo(Canal canal) {
        if(ordre==canal.ordre) return 1;
        else return 0;
    }

    public Map<Role, List<Utilisateur>> getMapping_role_utilisateurs() {
        return mapping_role_utilisateurs;
    }

    public void setMapping_role_utilisateurs(Map<Role, List<Utilisateur>> mapping_role_utilisateur) {
        this.mapping_role_utilisateurs = mapping_role_utilisateur;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public List<Webhook> getWebhooks() {
        return webhooks;
    }

    public void setWebhooks(List<Webhook> webhooks) {
        this.webhooks = webhooks;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Map<Role, List<Habilitation>> getMapping_role_habilitations() {
        return mapping_role_habilitations;
    }

    public void setMapping_role_habilitations(Map<Role, List<Habilitation>> mapping_role_habilitations) {
        this.mapping_role_habilitations = mapping_role_habilitations;
    }

    public List<Message> getHistoriques() {
        return historiques;
    }

    public void setHistoriques(List<Message> historiques) {
        this.historiques = historiques;
    }
}
