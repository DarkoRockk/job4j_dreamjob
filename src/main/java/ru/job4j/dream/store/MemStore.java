package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Calendar;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MemStore implements Store{

    private static final Store INST = new MemStore();

    private final Map<Integer, Post> posts = new ConcurrentHashMap<>();

    private final Map<Integer, Candidate> candidates = new ConcurrentHashMap<>();

    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    private static AtomicInteger POST_ID = new AtomicInteger(4);
    private static AtomicInteger CANDIDATE_ID = new AtomicInteger(4);
    private static AtomicInteger USER_ID = new AtomicInteger(4);

    private MemStore() {
//        posts.put(1, new Post(1, "Junior Java Job", "Any description"));
//        posts.put(2, new Post(2, "Middle Java Job", "Any description"));
//        posts.put(3, new Post(3, "Senior Java Job", "Any description"));
//        candidates.put(1, new Candidate(1, "Junior Java"));
//        candidates.put(2, new Candidate(2, "Middle Java"));
//        candidates.put(3, new Candidate(3, "Senior Java"));
//        users.put(1, new User());
//        users.put(2, new User());
//        users.put(3, new User());
    }

    public static Store instOf() {
        return INST;
    }

    public Collection<Post> findAllPosts() {
        return posts.values();
    }

    public Collection<Candidate> findAllCandidates() {
        return candidates.values();
    }

    public void save(Post post) {
        if (post.getId() == 0) {
            post.setId(POST_ID.incrementAndGet());
        }
        post.setCreated(Calendar.getInstance());
        posts.put(post.getId(), post);
    }

    public void addCandidate(Candidate candidate) {
        if (candidate.getId() == 0) {
            candidate.setId(CANDIDATE_ID.incrementAndGet());
        }
        candidates.put(candidate.getId(), candidate);
    }

    public void removeCandidate(int id) {
        candidates.remove(id);
    }

    public Post findPostById(int id) {
        return posts.get(id);
    }
    public Candidate findCanById(int id) {
        return candidates.get(id);
    }

    @Override
    public void addUser(User user) {
        if (user.getId() == 0) {
            user.setId(CANDIDATE_ID.incrementAndGet());
        }
        users.put(user.getId(), user);
    }

    @Override
    public User findUserByEmail(String email) {
        return null;
    }


}
