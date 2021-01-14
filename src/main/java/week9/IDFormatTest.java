package week9;

public class IDFormatTest {
    private String userID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) throws IDFormatException {
        if (userID == null) throw new IDFormatException("아이디는 null일 수 없다");
        else if (userID.length() < 8 || userID.length() > 20) throw new IDFormatException("8자 이상 20자 이하");
        this.userID = userID;
    }

    public static void main(String[] args) {
        IDFormatTest idFormatTest = new IDFormatTest();
        String userID = null;
        try {
            idFormatTest.setUserID(userID);
        } catch (IDFormatException e) {
            System.out.println(e.getMessage());
        }
        userID = "1234567";
        try {
            idFormatTest.setUserID(userID);
        } catch (IDFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}

