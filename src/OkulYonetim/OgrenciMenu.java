package OkulYonetim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
   ============= İŞLEMLER =============
        1-EKLEME
        2-ARAMA
        3-LİSTELEME
        4-SİLME
        Q-ÇIKIŞ
    */
public class OgrenciMenu implements IIslemler{

    ArrayList<Ogrenci> ogrenciList= new ArrayList<>();
    Scanner scan = new Scanner(System.in);

    void ogrMenu(){
        System.out.print(" ============= İŞLEMLER =============\n" +
                "1-EKLEME\n" +
                "2-ARAMA\n" +
                "3-LİSTELEME\n" +
                "4-SİLME\n" +
                "Q-ÇIKIŞ\n" +
                "SECİMİNİZ");


        while (true) {
            char secim =scan.next().toUpperCase().charAt(0);
            switch (secim){
                case '1':{
                    ekleme();
                }
                case '2':{
                    arama();
                }
                case '3':{
                    listeleme();
                }
                case '4':{
                    silme();
                }
                case 'Q':{}
                    cikis();
            }
        }
    }


    @Override
    public void ekleme() {
        System.out.println("İsim giriniz: ");
        String isim = scan.nextLine();
        System.out.println("Soyisim giriniz: ");
        String soyIsim = scan.nextLine();
        System.out.println("TC no giriniz: ");
        String tcNo= scan.next();
        System.out.println("Yas giriniz: ");
        int yas = scan.nextInt();
        System.out.println("Sinif giriniz: ");
        String sinif = scan.nextLine();
        System.out.println("Ogrenci No giriniz: ");
        int ogrNo = scan.nextInt();

        Ogrenci ogrenci = new Ogrenci(isim,soyIsim,tcNo,yas,sinif,ogrNo);
        ogrenciList.add(ogrenci);
        ogrMenu();
    }

    @Override
    public void arama() {
        if (!ogrenciList.isEmpty()){
            System.out.println("Arama yapilacak Tc no giriniz: ");
            String aranacakTc= scan.next();
            for (Ogrenci each: ogrenciList) {
                if (each.getTcNo().equals(aranacakTc)){
                    System.out.println(each.toString());
                }else {
                    System.out.println(aranacakTc + " Tc no'ya ait bilgi bulunamadi");
                    ogrMenu();
                }
            }
            ogrMenu();
        }else {
            System.out.println("Ogrenci Listesi Bos");
            ogrMenu();
        }

    }

    @Override
    public void listeleme() {
        if (!ogrenciList.isEmpty()){
            for (Ogrenci each: ogrenciList) {
                System.out.println(each.toString());
            }
            ogrMenu();
        }else {
            System.out.println("Ogrenci Listesi Bos");
            ogrMenu();
        }
    }

    @Override
    public void silme() {
        if (!ogrenciList.isEmpty()){
            System.out.println("Silme yapilacak Tc no giriniz: ");
            String aranacakTc= scan.next();
            for (int i = 0; i <ogrenciList.size() ; i++) {
                if (aranacakTc.equals(ogrenciList.get(i).getTcNo())){
                    ogrenciList.remove(i);
                    ogrMenu();
                }

            }
            ogrMenu();
        }else {
            System.out.println("Ogrenci Listesi Bos");
            ogrMenu();
        }
    }

    @Override
    public void cikis() {
        AnaMenu anaMenu = new AnaMenu();
        anaMenu.anaMenu();

    }
}
