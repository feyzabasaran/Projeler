package UcakBileti;

import java.util.HashMap;
import java.util.Scanner;

public class Musteri {
    /*
    1-) Kullanicinin ucak bileti almasi icin once kullanicinin bir hesabi var mi yok mu kontrol ediniz
    2-) Kullaniciya tek yon mu gidis donus mu bilet almak istediginiz sorun
    3-) Kullanicinin kaydi varsa kalkis yerini, gidicegi yeri kalkis saatini ve tarihini ogrenin. Ve bilet fiyatini kullaniciya gosterin
    4-) Eğer bilet fiyati kisiye uygun gelmediyse vazgecme opsiyonu ekleyin
     */
    HashMap<String,String> kullanicilar = new HashMap<>();
    Scanner scan = new Scanner(System.in);
    void musteriKontrol(){
        System.out.print("Kullanici adi giriniz");
        String userName = scan.nextLine();
        if (!kullanicilar.containsKey(userName)){
            System.out.println("Kullanici kayitli degil");
            musteriKayit();
        }else {
            System.out.println("Sifre giriniz");
            String password = scan.next();
            if (kullanicilar.get(userName).equals(password)){
                System.out.println("Sisteme basariyla giris yaptiniz");
            }else {
                while (!kullanicilar.get(userName).equals(password)){
                    System.out.println("Yanlis sifre girdiniz. Tekrar giriniz");
                    password= scan.next();
                }
            }
        }

    }

    public void musteriKayit() {
        System.out.print("Kullanici adi giriniz");
        String userName = scan.nextLine();
        if (kullanicilar.containsKey(userName)){
            System.out.println("Bu isimde kullanici kayitli tekrar kullanici adi giriniz: ");
            musteriKayit();
        }else {
            System.out.print("Sifre giriniz: ");
            kullanicilar.put(userName,scan.next());
            System.out.println("Kayit yapilmistir");
        }
    }
}
