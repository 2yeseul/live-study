package week10;

class C1 extends Thread{
    public void run() {
        int result = 1;
        for(int i=2;i<=1000;i++) result+=i;
        System.out.println("calculation1 is " + result);
    }
}

class C2 extends Thread{
    public void run() {
        int result = 1;
        for(int i=2;i<=10;i++) result*=i;
        System.out.println("calculation2 is " + result);
    }
}

class ex2 {
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();

        c1.start();
        c2.start();
    }
}
