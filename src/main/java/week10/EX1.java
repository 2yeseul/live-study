package week10;

public class EX1 {
    public static void main(String[] args) {
        int calculation1 = 1;
        int calculation2 = 1;

        for(int i=2;i<=50;i++) calculation1+=i;
        for(int i=2;i<=10;i++) calculation2*=i;

        System.out.println("calculation1 is " + calculation1);
        System.out.println("calculation2 is " + calculation2);
    }
}

