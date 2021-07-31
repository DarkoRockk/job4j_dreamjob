package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

import java.util.Collection;

public interface Store {
    Collection<Post> findAllPosts();

    Collection<Candidate> findAllCandidates();

    void save(Post post);

    void addCandidate(Candidate candidate);

    void removeCandidate(int id);

    Post findPostById(int id);

    Candidate findCanById(int id);

    Collection<User> findAllUsers();

    void addUser(User user);

    User findUserByEmail (String email);
}
