package ATMProjesi;

import java.util.Locale;
import java.util.Scanner;

import static ATMProjesi.A3_Transactions.*;


public class A4_MenuSecimi {

    static String dogruSifre = "0000";
    static String dogruKartNumarasi = "TR1122334455667788";
    static double hesapBakiyesi = 10000;
    static double tutar;
    static int kartSecimi;

    public static void menuSecimi() {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Lütfen yapmak istediklerinizi listeden seçiniz.");
        System.out.println("1-Para Gönder\n2-Para Çek\n3-Para Yatır " +
                " \n4-Hesap bakiyenizi kontrol edin\n5-Çıkış");
        int kartSecimi = scan1.nextInt();


        if (kartSecimi == 1) {
            System.out.println("Mevcut bakiyeniz = " + hesapBakiyesi + " TL");
            System.out.println("Lütfen transfer etmek istediğiniz tutarı giriniz");
            Scanner scan = new Scanner(System.in);
            double gondermeTutari = scan.nextDouble();
            if (gondermeTutari <= hesapBakiyesi) {
                paraGonderme(gondermeTutari);
            } else {
                System.out.println("Mevcut miktarınızdan daha büyük bir miktar gönderemezsiniz.");
                menuSecimi();
            }

        }else if (kartSecimi == 2) {
            System.out.println("Mevcut bakiyeniz = " + hesapBakiyesi + " $");
            System.out.println("Lütfen çekmek istediğiniz tutarı giriniz");
            Scanner scan = new Scanner(System.in);
            double paraCekmeMiktari = scan.nextDouble();
            paraCekme(paraCekmeMiktari);

        }else if (kartSecimi == 3) {
            System.out.println("Mevcut bakiyeniz = " + hesapBakiyesi + " $");
            System.out.println("Lütfen yatırmak istediğiniz tutarı giriniz");
            Scanner scan = new Scanner(System.in);
            double depositAmount = scan.nextDouble();
            depozito(depositAmount);

        }else if (kartSecimi == 4) {
            hesapBakiyesiniKontrolEt();

        }else if (kartSecimi == 5) {
            System.out.println("Iyi gunler dileriz...");

        }else {
            System.out.println("Yanlış seçim..");
            System.out.println("Tekrar denemek ister misiniz?\n" +
                    "E/H?");
            Scanner scan3 = new Scanner(System.in);
            String yanlisSecim = scan3.next().toUpperCase(Locale.ROOT);
            if (yanlisSecim.equals("Y")){
                menuSecimi();
            }else if (yanlisSecim.equals("N")){
                System.out.println("Iyi gunler dileriz...");
            }else {
                System.out.println("Yanlis secim...");
                System.out.println("Iyi gunler dileriz...");
            }
        }

    }

}
