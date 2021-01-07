package week8;

public class KoreanPitcher implements Pitcher {
    @Override
    public void pitchingHand(String hand) {
        System.out.println(hand + "투수 입니다.");
    }

    public static void main(String[] args) {
        Pitcher kwangHyun = new KoreanPitcher();
        kwangHyun.pitchingHand("좌");
    }
}
