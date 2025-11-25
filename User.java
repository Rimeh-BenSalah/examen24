package examen2024;

public class User {
    private String name;
    private boolean isSubscribed;
    Content[] watchedContent;
    int nbWatched = 0;
    final int MAX_WATCHED = 100;

    public User(String name, boolean isSubscribed) {
        this.name = name;
        this.isSubscribed = isSubscribed;
        watchedContent = new Content[MAX_WATCHED];
    }

    public boolean canPlay(Content content) {
        return isSubscribed || content.isfree;
    }

    public void addWatchedContent(Content content) {
        if (nbWatched < MAX_WATCHED) {
            watchedContent[nbWatched] = content;
            nbWatched++;
        } else {
            System.out.println("Tableau est plein");
        }
    }

    public String[] getWatchedGenres() {
        String[] genres = new String[nbWatched];
        int k = 0;
        for (int i = 0; i < nbWatched; i++) {
            boolean exists = false;
            for (int j = 0; j < k; j++) {
                if (genres[j].equals(watchedContent[i].genre)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                genres[k] = watchedContent[i].genre;
                k++;
            }
        }
        String[] result = new String[k];
        for (int i = 0; i < k; i++) {
            result[i] = genres[i];
        }
        return result;
    }
}
