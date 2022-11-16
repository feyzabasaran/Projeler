package OkulProjesi;

import java.util.Scanner;

public class Depo {
    static Scanner scan = new Scanner(System.in);

    public static void anaMenu() throws InterruptedException {

        String tercih="";
        do {
            System.out.println("========= YILDIZ KOLEJİ =========\n " +
                    "========= ANA MENU =========\n" +
                    "\n" +
                    "\t 1- Okul Bilgileri Goruntule\n" +
                    "\t 2- Ogretmen Menu\n" +
                    "\t 3- Ogrenci Menu\t\t \n" +
                    "\t Q- CIKIS\n");
            System.out.println("Lutfen Menuden Tercihinizi Yapiniz");
            tercih = scan.nextLine();

            switch (tercih){
                case "1":  // Okul Bilgileri
                    Depo.okulBilgileriniYazdir();
                    break;
                case "2": // Ogretmen Menu
                    Ogretmen.ogretmenMenu();
                    break;
                case "3": // Ogrenci Menu
                    Ogrenci.ogrenciMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Gecerli bir tercih giriniz");
            }


        }while(!tercih.equalsIgnoreCase("q"));

        Depo.projeDurdur();
    }

    public static void okulBilgileriniYazdir() throws InterruptedException {
        System.out.println("=========== YILDIZ KOLEJİ ===========\n " +
                "\t Adres : " + Okul.adres +
                "\n\t Telefon: " + Okul.telefon);
        Thread.sleep(5000);

    }

    public static void projeDurdur() {
        System.out.println("Okul projesinden ciktiniz");
        System.exit(0); // sistemi durdurmak icin
    }
}
