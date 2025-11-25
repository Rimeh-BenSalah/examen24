package examen2024;

public class Test {

    public static void main(String[] args) {
        StreamingPlatform platform = new StreamingPlatform(20, 10);
        platform.addContent(new Movie("Inception", "Sci-Fi", false, 148));
        platform.addContent(new Serie("Stranger Things", "Thriller", false, 25, 50));
        platform.addContent(new Movie("Charlie Chaplin", "Comedy", true, 75));
        platform.addContent(new Serie("Friends", "Comedy", true, 236, 22));

        User imene = new User("Imene", false);
        User jihene = new User("Jihene", true);

        platform.addUser(imene);
        platform.addUser(jihene);

        try {
            System.out.println("=== Imene tente de regarder Inception ===");
            platform.playContent(imene, platform.findContent("Inception"));
        } catch (ContentNotFoundException | AccessDeniedException ex) {
            System.out.println("Erreur: " + ex.getMessage());
        }

        try {
            System.out.println("=== Imene regarde Charlie Chaplin ===");
            platform.playContent(imene, platform.findContent("Charlie Chaplin"));
        } catch (ContentNotFoundException | AccessDeniedException ex) {
            System.out.println("Erreur: " + ex.getMessage());
        }

        try {
            System.out.println("=== Jihene regarde Stranger Things ===");
            platform.playContent(jihene, platform.findContent("Stranger Things"));
            System.out.println("=== Jihene regarde Friends ===");
            platform.playContent(jihene, platform.findContent("Friends"));
        } catch (ContentNotFoundException | AccessDeniedException ex) {
            System.out.println("Erreur: " + ex.getMessage());
        }

        System.out.println("\nRecommandations pour Jihene:");
        Content[] recs = platform.getRecommendations(jihene);
        boolean hasRecs = false;
        for (Content c : recs) {
            if (c != null) {
                c.afficheDetails();
                hasRecs = true;
            }
        }
        if (!hasRecs) {
            System.out.println("Aucune recommandation trouvée.");
        }
    }
}
