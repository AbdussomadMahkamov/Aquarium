import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int vaqt=0;
    public static void main(String[] args) {
        System.out.println("Akvarium: ");
        boolean holat =  true;
        Random random = new Random();
        int N = random.nextInt(10);
        int M = random.nextInt(10);
        ArrayList<Baliqlar> baliqlars = new ArrayList<>();
        for (int i=0; i<N; i++){
            Baliqlar baliq=new Baliqlar();
            baliq.jinsi = true;
            baliq.yashashVaqti = random.nextInt(1000);
            baliq.tugulishVaqti = vaqt;
            System.out.println(baliq.yashashVaqti);
            baliqlars.add(baliq);
        }
        for (int i=0; i<M; i++){
            Baliqlar baliq=new Baliqlar();
            baliq.jinsi = false;
            baliq.yashashVaqti = random.nextInt(1000);
            System.out.println(baliq.yashashVaqti);
            baliqlars.add(baliq);
        }
        Scanner cin = new Scanner(System.in);
        int son = 0;
        while(holat){
            System.out.println("n: "+N);
            System.out.println("m: "+M);
            BaliqHarakati(baliqlars);
            if(son == 1000){
                holat=!holat;
            }
            son++;
            vaqt++;
        }
    }
    public static void BaliqHarakati(ArrayList<Baliqlar> baliqlars){
        try {
            Random random = new Random();
            for (int i = 0; i < baliqlars.size(); i++) {
                Baliqlar baliqlar = baliqlars.get(i);
                baliqlar.xOqi = random.nextInt(100);
                baliqlar.yOqi = random.nextInt(100);
                baliqlars.set(i, baliqlar);
            }
            System.out.println("***************");
            for (Baliqlar baliqlar : baliqlars) {
                if(baliqlar.jinsi){
                    System.out.println("Erkak");
                    System.out.println("Yashash vaqti: "+baliqlar.yashashVaqti);
                    System.out.println("X oqi: "+baliqlar.xOqi);
                    System.out.println("Y oqi: "+baliqlar.yOqi);
                }else {
                    System.out.println("Urg'ochi");
                    System.out.println("Yashash vaqti: "+baliqlar.yashashVaqti);
                    System.out.println("X oqi: "+baliqlar.xOqi);
                    System.out.println("Y oqi: "+baliqlar.yOqi);
                }
                System.out.println();
            }
            System.out.println("***************");
            for (Baliqlar baliqlar : baliqlars) {
                if (baliqlar.yashashVaqti+baliqlar.tugulishVaqti == vaqt){
                    baliqlars.remove(baliqlar);
                }
            }
            for (Baliqlar baliqlar : baliqlars) {
                for (Baliqlar baliqlar1 : baliqlars) {
                    if (baliqlar.xOqi == baliqlar1.xOqi &&
                            baliqlar.yOqi == baliqlar1.yOqi &&
                            baliqlar.jinsi != baliqlar1.jinsi){
                        System.out.println("Juftlashdi");
                        System.out.println("Juftlashdi");
                        System.out.println("Juftlashdi");
                        System.out.println("Juftlashdi");
                        System.out.println("Juftlashdi");
                        System.out.println("Juftlashdi");
                        System.out.println("Juftlashdi");
                        System.out.println("Juftlashdi");
                        int soni = random.nextInt(100);
                        for (int i = 0; i < soni; i++) {
                            Baliqlar baliqlar2 = new Baliqlar();
                            baliqlar2.xOqi = random.nextInt(30);
                            baliqlar2.yOqi = random.nextInt(30);
                            baliqlar2.jinsi = random.nextBoolean();
                            baliqlar2.yashashVaqti = random.nextInt(1000);
                            baliqlars.add(i,baliqlar2);
                        }
                    }
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}