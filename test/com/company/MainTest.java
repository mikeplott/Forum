package com.company;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by michaelplott on 9/26/16.
 */
public class MainTest {
    @Test
    public void testLoad() throws FileNotFoundException {
        File f = new File("posts.txt");
        ArrayList<Post> posts = Main.loadPosts(f);
        assertFalse(posts.isEmpty());
    }

    @Test
    public void testReadId() {
        int replyId = Main.readId("2");
        assertTrue(replyId == 2);
    }
}