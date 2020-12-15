package week4.homework.hw2.Github;

import org.kohsuke.github.*;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;

public class LiveStudy {
    private final GitHub gitHub;
    private final GHRepository repository;

    public LiveStudy(String path, String repositoryName) throws IOException {
        this.gitHub = GitHubBuilder.fromPropertyFile(path).build();
        this.repository = gitHub.getRepository(repositoryName);
    }
    public GitHub getGitHub() {
        return gitHub;
    }

    public GHRepository getRepository() {
        return repository;
    }

    public List<GHIssue> getAllIssueLists() throws IOException {
        return this.getRepository().getIssues(GHIssueState.ALL);
    }

    public String getUserLoginID(GHIssueComment comment) throws IOException {
        return comment.getUser().getLogin();
    }

    public void saveAllSubmit(HashMap<String, Integer> users) throws IOException {
        List<GHIssue> issueList = this.getAllIssueLists();
        int index = issueList.size()-1;
        for(int i=0;i<issueList.size();i++) {
            GHIssue nowIssue= issueList.get(index-i);
            List<GHIssueComment> commentList = nowIssue.getComments();
            // 1주차
            if(i == 0) {
                for(int j=0;j<nowIssue.getCommentsCount();j++) {
                    String userLoginId = getUserLoginID(commentList.get(j));
                    if(!users.containsKey(userLoginId)) users.put(userLoginId, 1);
                }
            }
            // 2주차
            else {
                for(int j=0;j<nowIssue.getCommentsCount();j++) {
                    String userLoginId = getUserLoginID(commentList.get(j));
                    int previous = 0;
                    if(users.get(userLoginId)!=null) previous = users.get(userLoginId);
                    if((previous!=0) && (previous <= i+1)) users.replace(userLoginId, previous+1);
                    else if(previous == 0) users.put(userLoginId, 1);
                }
            }
        }
    }

    public void showRateResult(HashMap<String, Integer> users) throws IOException {
        saveAllSubmit(users);
        int totalSize = getAllIssueLists().size();
        DecimalFormat format = new DecimalFormat("#.##");
        for(String userID : users.keySet()) {
            double r = ((double)users.get(userID) / (double)totalSize)*100;
            String rates = format.format(r) + "%";
            System.out.println(userID + " : " + rates);
        }
    }
}

