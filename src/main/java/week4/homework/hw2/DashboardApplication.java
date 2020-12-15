package week4.homework.hw2;

import week4.homework.hw2.Github.LiveStudy;

import java.io.IOException;
import java.util.HashMap;

public class DashboardApplication {
    public static void main(String[] args) throws IOException {
        final String path = "src/main/resources/.github";
        final String repoName = "whiteship/live-study";
        LiveStudy liveStudy = new LiveStudy(path, repoName);
        HashMap<String, Integer> userList = new HashMap<String, Integer>();
        liveStudy.showRateResult(userList);
    }

}
