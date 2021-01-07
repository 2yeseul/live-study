package week8;

public class KBOPlayer implements BaseballPlayer {
    String name;

    KBOPlayer(String name) {
        this.name = name;
    }

    @Override
    public void position(String position) {
        System.out.println(this.name + "'s position is " + position);
    }

    @Override
    public void hittingHand(String hand) {
        System.out.println(this.name + "'s hitting hand is " + hand);
    }

    @Override
    public void pitchingHand(String hand) {
        System.out.println(this.name + "'s pitching hand is " + hand);
    }

    public static void main(String[] args) {
        KBOPlayer kboPlayer = new KBOPlayer("Daeho");
        KBOPlayer kboPlayer1 = new KBOPlayer("Hyun-jong");
        kboPlayer.hittingHand("right");
        kboPlayer1.pitchingHand("left");
    }
}