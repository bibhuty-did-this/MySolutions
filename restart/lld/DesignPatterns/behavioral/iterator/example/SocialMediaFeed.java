package restart.lld.DesignPatterns.behavioral.iterator.example;

import java.util.*;

public class SocialMediaFeed {
    public static void main(String[] args) {
        // Create sample posts for AdPost
        Post adPost1 = new Post(1627855600000L, "AdPost 1");
        Post adPost2 = new Post(1627859200000L, "AdPost 2");
        Post adPost3 = new Post(1627862800000L, "AdPost 3");

        // Create a PriorityQueue for AdPost
        PriorityQueue<Post> adPostsQueue = new PriorityQueue<>(Comparator.comparingLong(Post::getTimestamp));
        adPostsQueue.add(adPost1);
        adPostsQueue.add(adPost2);
        adPostsQueue.add(adPost3);
        AdPost adPosts = new AdPost(adPostsQueue);

        // Create sample posts for FriendPost
        Post friendPost1 = new Post(1627852000000L, "FriendPost 1");
        Post friendPost2 = new Post(1627865600000L, "FriendPost 2");
        Post friendPost3 = new Post(1627879200000L, "FriendPost 3");

        // Create FriendPost collection
        FriendPost friendPosts = new FriendPost();
        friendPosts.posts.add(friendPost1);
        friendPosts.posts.add(friendPost2);
        friendPosts.posts.add(friendPost3);

        // Create sample posts for PagePost
        Post pagePost1 = new Post(1627882800000L, "PagePost 1");
        Post pagePost2 = new Post(1627886400000L, "PagePost 2");
        Post pagePost3 = new Post(1627890000000L, "PagePost 3");

        // Create PagePost collection
        PagePost pagePosts = new PagePost();
        pagePosts.posts.add(pagePost1);
        pagePosts.posts.add(pagePost2);
        pagePosts.posts.add(pagePost3);

        // Create a list of iterators
        List<Iterator<Post>> iterators = new ArrayList<>();
        iterators.add(adPosts.iterator());
        iterators.add(friendPosts.iterator());
        iterators.add(pagePosts.iterator());

        // Create CompositePostIterator
        CompositePostIterator compositeIterator = new CompositePostIterator(iterators);

        // Iterate through all posts in chronological order
        while (compositeIterator.hasNext()) {
            Post post = compositeIterator.next();
            System.out.println("Timestamp: " + post.getTimestamp() + ", Content: " + post.getContent());
        }
    }
}
class Post{
    long timestamp;
    String content;

    public Post(long timestamp, String content) {
        this.timestamp = timestamp;
        this.content = content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }
}
interface Iterator<T>{
    boolean hasNext();
    T next();
    void reset();
    T peek();
}

interface IterableCollection<T>{
    Iterator<T> iterator();
}
class AdPost implements IterableCollection<Post>{
    PriorityQueue<Post> priorityQueue;

    public AdPost(PriorityQueue<Post> priorityQueue) {
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingLong(Post::getTimestamp));
        this.priorityQueue.addAll(priorityQueue);
    }

    @Override
    public Iterator<Post> iterator() {
        return new PriorityQueueIterator<>(priorityQueue);
    }
}
class PriorityQueueIterator<T> implements Iterator<T>{
    PriorityQueue<T> priorityQueue;
    PriorityQueue<T> priorityQueueCopy;

    public PriorityQueueIterator(PriorityQueue<T> priorityQueue) {
        this.priorityQueue = priorityQueue;
        this.priorityQueueCopy=new PriorityQueue<T>(priorityQueue);
    }

    @Override
    public boolean hasNext() {
        return !priorityQueue.isEmpty();
    }

    @Override
    public T next() {
        if(hasNext()){
            return priorityQueue.poll();
        }
        return null;
    }

    @Override
    public T peek() {
        if(hasNext()){
            return priorityQueue.peek();
        }
        return null;
    }

    @Override
    public void reset() {
        this.priorityQueue.clear();
        this.priorityQueue.addAll(priorityQueueCopy);
    }
}

class FriendPost implements IterableCollection<Post>{
    List<Post> posts;
    public FriendPost(){
        this.posts=new ArrayList<>();
    }

    @Override
    public Iterator<Post> iterator() {
        return new ListIterator<>(posts);
    }
}
class ListIterator<T> implements Iterator<T>{
    List<T> list;
    private int position=0;

    public ListIterator(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return position<list.size();
    }

    @Override
    public T next() {
        if(this.hasNext()) return list.get(position++);
        return null;
    }

    @Override
    public T peek() {
        if(hasNext()){
            return list.get(position);
        }
        return null;
    }

    @Override
    public void reset() {
        this.position=0;
    }
}

class PagePost implements IterableCollection<Post>{
    ArrayDeque<Post> posts;

    public PagePost() {
        this.posts=new ArrayDeque<>();
    }

    @Override
    public Iterator<Post> iterator() {
        return new PagePostIterator<>(posts);
    }
}

class PagePostIterator<T> implements Iterator<T>{
    ArrayDeque<T> queue;
    ArrayDeque<T> queueCopy;
    public PagePostIterator(ArrayDeque<T> queue) {
        this.queue=queue;
        this.queueCopy=new ArrayDeque<>(queue);
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        if(hasNext()){
            return queue.poll();
        }
        return null;
    }

    @Override
    public T peek() {
        if(hasNext()){
            return queue.peek();
        }
        return null;
    }

    @Override
    public void reset() {
        this.queue=new ArrayDeque<>(this.queueCopy);
    }

}

class CompositePostIterator implements Iterator<Post>{
    List<Iterator<Post>> iterators;
    PriorityQueue<Post> minHeap;

    public CompositePostIterator(List<Iterator<Post>> iterators) {
        this.iterators=iterators;
        this.minHeap = new PriorityQueue<>(Comparator.comparingLong(Post::getTimestamp));
        for (Iterator<Post> iterator : iterators) {
            if (Objects.nonNull(iterator.peek())){
                minHeap.offer(iterator.next());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !minHeap.isEmpty();
    }

    @Override
    public Post next() {
        if(!hasNext()){
            return null;
        }

        Post nextPost = minHeap.poll();

        for (Iterator<Post> iterator : iterators) {
            if (Objects.nonNull(iterator.peek())){
                minHeap.offer(iterator.next());
            }
        }

        return nextPost;
    }

    @Override
    public void reset() {
        for (Iterator<Post> iterator : iterators) {
            if (iterator.hasNext()){
                iterator.reset();
            }
        }
        minHeap.clear();
        for (Iterator<Post> iterator : iterators) {
            if (Objects.nonNull(iterator.peek())){
                minHeap.offer(iterator.next());
            }
        }
    }

    @Override
    public Post peek() {
        return minHeap.peek();
    }
}
