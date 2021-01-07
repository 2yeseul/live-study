package week4.homework.hw2.Github;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TIL {
    private final GitHub gitHub;
    private final GHRepository repository;
    final String path = "src/main/resources/.github";
    final String repositoryName = "2yeseul/TIL";
    public TIL() throws IOException {
        this.gitHub = GitHubBuilder.fromPropertyFile(path).build();
        this.repository = gitHub.getRepository(repositoryName);
    }

    public static void main(String[] args) throws IOException {
        TIL til = new TIL();
        List<GHCommitComment> fileName = new ArrayList<>();
        fileName = til.repository.listCommitComments().toList();
        System.out.println(fileName.size());
        for (int i=0;i<fileName.size();i++) System.out.println(fileName.get(i));
    }
}
