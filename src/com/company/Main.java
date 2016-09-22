package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Post> posts = new ArrayList<>();

        File f = new File("posts.txt");
        Scanner fileScanner = new Scanner(f);
        while(fileScanner.hasNext()) {
            String line = fileScanner.nextLine();
            String[] columns = line.split("\\|");
            String replyId = columns[0];
            String author = columns[1];
            String text = columns[2];
            Post p = new Post(Integer.valueOf(replyId), author, text);
            posts.add(p);
        }

        Scanner consoleScanner = new Scanner(System.in);

        int replyId = -1;
        while (true) {
//            for (Post post : posts) {
//                if (post.replyId == replyId) {
//                    System.out.printf("[%s] %s by %s\n" replyId + 1, post.text, post.author);
//                }
            //}
            System.out.println("Posts replying to " + replyId);
            for (int i = 0; i < posts.size(); i++) {
                Post post = posts.get(i);
                if (post.replyId == replyId) {
                    System.out.printf("[%s] %s by %s\n", i, post.text, post.author);
                }
            }

            System.out.println("Type the id you want to see replies to:");
            replyId = Integer.valueOf(consoleScanner.nextLine());
        }
    }
}
