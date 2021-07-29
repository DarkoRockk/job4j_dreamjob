package ru.job4j.dream.store;

import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.model.Post;

public class PsqlMain {
    public static void main(String[] args) throws InterruptedException {
        Store store = PsqlStore.instOf();
        store.save(new Post(0, "Java Job", "Any Description"));
        store.save(new Post(2, "Ja", "Anyyyyyyyy"));
        for (Post post : store.findAllPosts()) {
            System.out.println(post.getId() + " " + post.getName());
        }
        Thread.sleep(1000);
        store.addCandidate(new Candidate(0, "Java Junior"));
        for (Candidate can : store.findAllCandidates()) {
            System.out.println(can.getId() + " " + can.getName());
        }

        store.removeCandidate(2);
        for (Candidate can : store.findAllCandidates()) {
            System.out.println(can.getId() + " " + can.getName());
        }
        System.out.println(store.findPostById(2).toString());
    }
}
