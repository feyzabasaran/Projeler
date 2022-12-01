package UcakBileti;

import java.util.Random;
import java.util.Scanner;

public class UcusBilgileri {
    Scanner scan = new Scanner(System.in);
    int seferSayisi = 1000;
    public void ucusKontrol(){
        System.out.println("Yapmak istediginiz yolculuk seklini seciniz. Tek yon icin 1, Cift yon icin 2'ye basiniz");
        int secim = scan.nextInt();
        switch (secim){
            case 1: {
                tekYon();
                break;
            }
            case 2: {
            }
            default:{
                System.out.println("Yanlis deger girdiniz tekrar deneyin");
                ucusKontrol();
            }
        }
    }

    int fiyatHesapla(){
        return (int) (Math.random()*100);
    }
    private void tekYon() {

        System.out.println("Kalkis noktasini giriniz");
        String kalkisNoktasi = scan.nextLine();
        System.out.println("Inis noktasini giriniz");
        String inisNoktasi = scan. nextLine();
        Random dolar = new Random();
        System.out.println("Gidis tarihi giriniz:(yyyy/mm/dd)");
        String tarih= scan.nextLine();
        char kalkisIlkHarf = kalkisNoktasi.charAt(0);
        char inisIlkHarf = inisNoktasi.charAt(0);
        seferSayisi++;
        String ucusBilgileri = kalkisNoktasi+"===>" + inisNoktasi+ " " + tarih+ " "+
                kalkisIlkHarf+ inisIlkHarf + seferSayisi+ " No'lu ucusun fiyati $ " + fiyatHesapla()+
                "Bilet fiyatiniz";
        System.out.println(ucusBilgileri + " onaylıyor musunuz? E/H");
        char secim = scan.next().toUpperCase().charAt(0);
        if (secim=='E'){
            System.out.println("Biletiniz onaylanmistir " + ucusBilgileri);
        }else {
            System.out.println("Tesekkurler. Iyi gunler dileriz.");
        }
    }
}
