package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;
import ru.job4j.dream.model.User;

public class PsqlMain {
    public static void main(String[] args) throws InterruptedException {
        Store store = PsqlStore.instOf();
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        for (Candidate can : store.findAllCandidates()) {
            System.out.println(can.getId() + " " + can.getName());
        }

        store.removeCandidate(2);
        for (Candidate can : store.findAllCandidates()) {
            System.out.println(can.getId() + " " + can.getName());
        }
        System.out.println(store.findPostById(2).toString());
        User user = new User();
        user.setName("TestName");
        user.setEmail("TestEmail");
        user.setPassword("TestPassword");
        store.addUser(user);
    }
}
