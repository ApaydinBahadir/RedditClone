package postservice.postservice.core.utilities;

import postservice.postservice.entitites.Post;

import java.util.Comparator;

public class PostSortingComparator implements Comparator<Post> {
    public int compare(Post o1, Post o2) {
        return o1.getCreated_at().compareTo(o2.getCreated_at());
    }
}
