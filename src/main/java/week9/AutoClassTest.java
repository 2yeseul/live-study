package week9;

public class AutoClassTest {
    public static void main(String[] args) {
        AutoCloseObj obj = new AutoCloseObj();
        try (obj){
            throw new Exception();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
