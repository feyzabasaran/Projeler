package ATMProjesi;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

import static ATMProjesi.A4_MenuSecimi.*;

public class A3_Transactions <sifre1>{

    static int sifre1;
    static int kullaniciSifre;
    public static Scanner scan = new Scanner(System.in);

    public static void paraGonderme(double gondermeTutari) {
        String iban1 = getIban();
        if (iban1.startsWith("TR") && iban1.length() == 26) {
            double hesapBakiyesi = gondermeTutari;
            System.out.println(gondermeTutari + " TL " + iban1 + " basari ile gonderildi.");
            System.out.println("Hesabınızın yeni bakiyesi : " + hesapBakiyesi);
        } else {
            System.out.println("Yanlis iban numarasi");
            paraGonderme(gondermeTutari);
        }


        System.out.println("Başka bir işleme devam etmek ister misiniz?\n" +
                "\"Y veya N\" yazın");
        Scanner scan1 = new Scanner(System.in);
        char secim = scan1.next().toUpperCase(Locale.ROOT).charAt(0);
        if (secim == 'Y') {
            menuSecimi();
        } else if (secim == 'N') {
            System.out.println("Iyi gunler dileriz...");
        }else{
            menuSecimi();
        }

    }

    public static void paraCekme(double paraCekmeMiktari) {
        if (paraCekmeMiktari <= hesapBakiyesi) {
            hesapBakiyesi -= paraCekmeMiktari;
            System.out.println(paraCekmeMiktari + " TL başarıyla çekildi.");
            System.out.println("Hesabınızın yeni bakiyesi : " + hesapBakiyesi);
        } else if (paraCekmeMiktari > hesapBakiyesi) {
            System.out.println("Cari hesap bakiyenizden daha fazla çekemezsiniz.");
            menuSecimi();
        }

        System.out.println("Başka bir işleme devam etmek ister misiniz?\n" +
                "\"Y veya N\" yazın");
        Scanner scan1 = new Scanner(System.in);
        char secim = scan1.next().toUpperCase(Locale.ROOT).charAt(0);
        if (secim == 'Y') {
            menuSecimi();
        } else if (secim == 'N') {
            System.out.println("Iyi gunler dileriz...");
        }else{
            menuSecimi();
        }

    }

    public static void depozito(double depozitTutari) {
        hesapBakiyesi += depozitTutari;
        System.out.println("Para yatırdıktan sonraki mevcut bakiyeniz = " + hesapBakiyesi + " TL");
        System.out.println("Başka bir işleme devam etmek ister misiniz?\n" +
                "\"Y veya N\" yazın");
        Scanner scan1 = new Scanner(System.in);
        char secim = scan1.next().toUpperCase(Locale.ROOT).charAt(0);
        if (secim == 'Y') {
            menuSecimi();
        } else if (secim == 'N') {
            System.out.println("Iyi gunler dileriz...");
        }else{
            menuSecimi();
        }

    }

    public static void hesapBakiyesiniKontrolEt() {
        System.out.println("Mevcut bakiyeniz = " + hesapBakiyesi + " $");
        System.out.println("Başka bir işleme devam etmek ister misiniz?\n" +
                "\"Y veya N\" yazın");
        Scanner scan1 = new Scanner(System.in);
        char secim = scan1.next().toUpperCase(Locale.ROOT).charAt(0);
        if (secim == 'Y') {
            menuSecimi();
        } else if (secim == 'N') {
            System.out.println("Iyi gunler dileriz...");
        }else{
            menuSecimi();
        }
    }

    public static int sifreOlusturma() {
        Random pin = new Random();
        sifre1 = pin.nextInt(1000);
        System.out.println("Hesabınızı doğrulamak için JavaBank'tan oluşturulan yeni bir pin kodu" + sifre1 + " B0123");
        System.out.println("Lütfen doğrulamak için yukarıdaki pin kodunu yazın");
        kullaniciSifre = scan.nextInt();
        return kullaniciSifre + sifre1;
    }

    public static boolean sifreKontrol() {
        boolean isCorrect = false;
        if (sifreOlusturma() == 2 * sifre1) {

            isCorrect = true;
        } else {
            for (int i = 0; i < 2; i++) {
                if (sifreOlusturma() != 2 * sifre1) {
                    System.out.println("Hesabınızı doğrulayamadık...");
                } else {
                    isCorrect = true;
                    break;
                }
            }
        }
        return isCorrect;
    }

    public static String getIban() {
        System.out.println("Lütfen havale yapacağınız IBAN'ı giriniz.");
        System.out.println("TR ile başlamalı...");
        Scanner scan1 = new Scanner(System.in);
        String iban = scan1.nextLine();
        return iban;
    }

    public static boolean ibanVeSifreKontrolEt() {
        boolean isCorrect = false;
        Scanner scan2 = new Scanner(System.in);
        System.out.println("Lütfen kart numaranızı giriniz");
        String kartNumarasi = scan2.nextLine();

        System.out.println("Lütfen kart şifrenizi giriniz");
        String kartSifresi = scan2.nextLine();
        if ((kartNumarasi+kartSifresi).equals(dogruKartNumarasi + dogruSifre)) {
            isCorrect = true;
        } else {
            for (int i = 0; i < 3; i++) {
                if (!(kartNumarasi+kartSifresi).equals(dogruKartNumarasi + dogruSifre)) {
                    System.out.println("Hesabınızı doğrulayamadık...");
                } else {
                    isCorrect = true;
                    break;
                }
            }
        }
        return isCorrect;
    }
}
