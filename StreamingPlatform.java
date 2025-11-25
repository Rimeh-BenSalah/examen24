package examen2024;

public class StreamingPlatform {

    private Content[] contents;
    private User[] users;
    private int nbContents = 0;
    private int nbUsers = 0;
    private int capContents;
    private int capUsers;

    public StreamingPlatform(int capContents, int capUsers) {
        this.capContents = capContents;
        this.capUsers = capUsers;
        contents = new Content[capContents];
        users = new User[capUsers];
    }

    public void addContent(Content content) {
        if (nbContents < capContents) {
            contents[nbContents] = content;
            nbContents++;
        } else {
            System.out.println("Tableau des contenus est plein");
        }
    }

    public void addUser(User user) {
        if (nbUsers < capUsers) {
            users[nbUsers] = user;
            nbUsers++;
        } else {
            System.out.println("Tableau des utilisateurs est plein");
        }
    }

    public Content findContent(String title) throws ContentNotFoundException {
        for (int i = 0; i < nbContents; i++) {
            if (contents[i].title.trim().equalsIgnoreCase(title.trim())) {
                System.out.println("Contenu trouvé");
                return contents[i];
            }
        }
        throw new ContentNotFoundException("Ce contenu n'a pas été trouvé");
    }

    public void playContent(User user, Content cnt) throws AccessDeniedException {
        if (user.canPlay(cnt)) {
            System.out.println("Accès accepté");
            user.addWatchedContent(cnt);
        } else {
            throw new AccessDeniedException("Accès refusé");
        }
    }

    public Content[] getRecommendations(User user) {
        Content[] recm = new Content[10];
        int k = 0;

        for (int i = 0; i < user.getWatchedGenres().length; i++) {
            for (int j = 0; j < nbContents; j++) {
                if (contents[j] != null && contents[j].genre.equals(user.getWatchedGenres()[i])) {

                    boolean existsInWatched = false;
                    for (int c = 0; c < user.nbWatched; c++) {
                        if (contents[j].equals(user.watchedContent[c])) {
                            existsInWatched = true;
                            break;
                        }
                    }

                    boolean existsInRec = false;
                    for (int x = 0; x < k; x++) {
                        if (recm[x] != null && recm[x].equals(contents[j])) {
                            existsInRec = true;
                            break;
                        }
                    }

                    if (!existsInWatched && !existsInRec && k < recm.length) {
                        recm[k] = contents[j];
                        k++;
                    }
                }
            }
        }
        return recm;
    }
}
