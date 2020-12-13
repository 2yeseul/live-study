package week4.homework.Github;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LiveStudyDashboard {
    private GitHub gitHub;
    private GHRepository repository;

    public LiveStudyDashboard(String path, String repositoryName) throws IOException {
        this.gitHub = GitHubBuilder.fromPropertyFile(path).build();
        this.repository = gitHub.getRepository(repositoryName);
    }

    public List<GHIssue> getAllIssues() throws IOException {
        List<GHIssue> issueList = new ArrayList<GHIssue>();
        issueList = repository.getIssues(GHIssueState.ALL);
        return issueList;
    }
    // 1. 첫 번째 이슈에서 user들 모으기
    // 2. 이슈 별, 사용자의 참석여부 체크
    // 3. 사용자들의 참여율 return


}

