package week4.homework.Github;

import org.kohsuke.github.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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

    public List<GHIssueComment> getAllIssueComments(GHIssue issue) throws IOException {
        return issue.getComments();
    }

    public String getUserLoginID(GHIssueComment comment) throws IOException {
        return comment.getUser().getLogin();
    }

    public HashMap<String,Integer> saveSubmit(HashMap<String, Integer> users, GHIssueComment comment) throws IOException {
        String userLoginID = this.getUserLoginID(comment);
        return users;
    }

    // 1. 첫 번째 이슈에서 user들 모으기
    // 2. 이슈 별, 사용자의 참석여부 체크
    // 3. 사용자들의 참여율 return

    public HashMap<String, Integer> getSubmitUsers(GHIssue issue) throws IOException {
        HashMap<String, Integer> submitUsers = new HashMap<>();
        return submitUsers;
    }
    public String getUsersLoginId(GHIssue issue) throws IOException {
        String LoginId;
        LoginId = issue.getUser().getLogin();
        return LoginId;
    }

    public static void main(String[] args) throws IOException {
        String path = "src/main/resources/.github";
        String name = "whiteship/live-study";
        LiveStudy liveStudy = new LiveStudy(path, name); // 객체 생성
        // 1) issue list 가져오기
        List<GHIssue> issueList = liveStudy.getRepository().getIssues(GHIssueState.ALL); // 전체 이슈들 가져와서 List에 저장
        HashMap<String, Integer> users = new HashMap<String, Integer>(); // 사용자와 제출 횟수 저장

        int index = (issueList.size()-1);
        for(int i=0;i<issueList.size();i++) {
            GHIssue issue = issueList.get(index-i);
            // 2) 각 이슈의 코멘트 리스트들 가져오기
            List<GHIssueComment> commentList = issue.getComments();
            // 3) 사용자 아이디와 횟수 가져오기
            // 3-1) 사용자 초기화 - 1주
            if(i == 0) {
                for(int j=0;j<issue.getCommentsCount();j++){
                    String userLoginId = commentList.get(j).getUser().getLogin();
                    int submitCount = 1;
                    // 중복이 아닐 때에만 저장
                    if(!users.containsKey(userLoginId)) users.put(userLoginId, submitCount);
                }
            }
            // 2주 ~
            else {
                for(int j=0;j<issue.getCommentsCount();j++) {
                    String userLoginId = commentList.get(j).getUser().getLogin();
                    int previous = 0;
                    if(users.get(userLoginId)!=null) previous = users.get(userLoginId);
                    // System.out.println(userLoginId + " : " + previous);
                    if((previous!=0) && (previous <= i+1)) users.replace(userLoginId, previous+1);
                    else if(previous == 0) users.put(userLoginId, 1);
                }
            }
        }

        for(String id : users.keySet()) {
            System.out.println(id + " : " +users.get(id));
        }

        System.out.println("END");
    }
}

