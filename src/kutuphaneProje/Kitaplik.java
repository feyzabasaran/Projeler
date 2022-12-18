package kutuphaneProje;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kitaplik {
      /*
    1. Kullanicinin Kitap ekleme, silme ve listeleme gibi
    işlemleri yapmasına imkan taniyan bir uygulama yaziniz.
    2. Program, kitaplara 1000'den baslayarak sirali ve otomatik numara vermeli.
    Bunun yanindai her bir kitap icin Kitap Adi,Yazar Adi,Yayin Yili, Fiyat gibi bilgiler girilebilmelidir.
    3. Programin başlangicinda kullaniciya asagidaki gibi bir menu sunulmalıdır.
       kullanici programi bitirene kadar işlemlere devam edebilmelidir.

       =========== Kitap Programi ============
            1: Kitap ekle
            2: Numara ile kitap sil
            3: Tüm kitaplari listele
            4: Bitir
     */

    static List<Kitap> kitapListesi = new ArrayList<>();

    static int kitapNo = 1000;
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Kutuphanede bulunan kitaplar: \n" +mevcutKitap(kitapListesi));
        System.out.println("");
        anaMenu();


    }

    private static void anaMenu() {
        System.out.println("=========== Kitap Programi ============\n" +
                "            1: Kitap ekle\n" +
                "            2: Numara ile kitap sil\n" +
                "            3: Tüm kitaplari listele\n" +
                "            4: Bitir");
        System.out.print("Lutfen tercihinizi giriniz");
        int tercih = scan.nextInt();

        switch (tercih){
            case 1:
                kitapEkle();
            case 2:
                noIleKitapSil();
            case 3:
                tumKitaplariListele();
            case 4:
                System.out.println("====== IYI GUNLER :) ======");
                System.exit(0);
            default:
                System.out.println("Hatali giris yaptiniz");
        }

    }

    private static void tumKitaplariListele() {
        for (Kitap eachKitap: kitapListesi
             ) {
            System.out.println(eachKitap.toString());
        }
        anaMenu();
    }

    private static void noIleKitapSil() {
        System.out.print("Silmek istediginiz kitabin no'sunu giriniz: ");
        int silinecekNo = scan.nextInt();

        for (int i = 0; i < kitapListesi.size(); i++) {
            if (silinecekNo==kitapListesi.get(i).getNo()){
                kitapListesi.remove(i);
                System.out.println(silinecekNo + " numarali kitap basari ile silindi");
                anaMenu();
            }
        }
        System.out.println(silinecekNo + " numarali kitap bulunamadi");
        anaMenu();

    }


    private static void kitapEkle() {
        System.out.print("Eklemek istediginiz kitabin adini giriniz: ");
        scan.nextLine();
        String kitapAdi = scan.nextLine();
        System.out.print("Eklemek istediginiz kitabin yazar adini giriniz: ");
        String yazarAdi = scan.nextLine();
        System.out.print("Eklemek istediginiz kitabin yayin yilini giriniz: ");
        int yayinYili = scan.nextInt();
        System.out.print("Eklemek istediginiz kitabin fiyatini giriniz: ");
        int fiyat = scan.nextInt();

        Kitap eklenecekKitap = new Kitap(kitapNo++,kitapAdi,yazarAdi,yayinYili,fiyat);
        kitapListesi.add(eklenecekKitap);
        System.out.println(eklenecekKitap.toString() + "bilgilerine sahip kitap sisteme basari ile eklendi");
        anaMenu();
    }

    private static List<Kitap> mevcutKitap(List<Kitap> kitapListesi) {

        Kitap kitap1 = new Kitap(kitapNo++,"Semerkant","Amin Maalouf",2020,35);
        kitapListesi.add(kitap1);
        Kitap kitap2 = new Kitap(kitapNo++,"Milena'ya Mektuplar", "Franz Kafka",2016,49);
        kitapListesi.add(kitap2);
        Kitap kitap3 = new Kitap(kitapNo++,"Fareler ve Insanlar","John Steinbeck",2020,48);
        kitapListesi.add(kitap3);
        return kitapListesi;
    }
}
