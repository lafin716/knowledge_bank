package com.lafin.knowledge.stream.exam;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Exam01 {

    class User {
        String name;
        String[] hobby;
        String intro;

        public void name(String name) {
            this.name = name;
        }
    }

    List<String> getFileContents() {
        try {
            URI uri = getClass().getResource("user.csv").toURI();
            System.out.println(uri);
            return Files.readAllLines(Paths.get(uri));
        } catch (IOException e) {
            return new ArrayList<>();
        } catch (URISyntaxException e) {
            return new ArrayList<>();
        }
    }

    void print() {
        List<String> list = getFileContents();
        list.forEach(System.out::println);
    }

    int getHobbyCount() {
        var users = getFileContents();

        return 0;
    }

    public static void main(String[] args) {
        Exam01 exam01 = new Exam01();
        exam01.print();
    }
}
