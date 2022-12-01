package OkulYonetim;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OgretmenMenu implements IIslemler{

    /*
   ============= İŞLEMLER =============
        1-EKLEME
        2-ARAMA
        3-LİSTELEME
        4-SİLME
        Q-ÇIKIŞ
    */

    ArrayList<Ogretmen> ogretmenList = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    void ogretmenMenu(){
        System.out.println("============= İŞLEMLER =============\n" +
                "1-EKLEME\n" +
                "2-ARAMA\n" +
                "3-LİSTELEME\n" +
                "4-SİLME\n" +
                "Q-ÇIKIŞ\n" +
                "SECİMİNİZ: ");


        while (true) {
            char secim = scan.next().toUpperCase().charAt(0);

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
                case 'Q':{
                    cikis();
                }
            }
        }
    }
    @Override
    public void ekleme() {
        System.out.print("Ogretmen adini giriniz: ");
        scan.nextLine();
        String isim = scan.nextLine();
        System.out.print("Ogretmen soyadini giriniz: ");
        String soyIsim = scan.nextLine();
        System.out.print("Ogretmen TC no giriniz: ");
        String tcNo = scan.next();
        System.out.print("Ogretmen yasini giriniz: ");
        int yas = scan.nextInt();
        System.out.print("Ogretmen bolumu giriniz: ");
        scan.nextLine();
        String bolum = scan.nextLine();
        System.out.print("Ogretmen sicil no giriniz: ");
        int sicilNo = scan.nextInt();

        Ogretmen ogretmen = new Ogretmen(isim,soyIsim,tcNo,yas,bolum,sicilNo);
        ogretmenList.add(ogretmen);
        ogretmenMenu();
    }

    @Override
    public void arama() {
        if (!ogretmenList.isEmpty()){
            System.out.println("Arama yapilacak Tc no giriniz: ");
            String tcNo= scan.next();

            for (int i = 0 ; i< ogretmenList.size(); i++) {
                if (ogretmenList.get(i).equals(tcNo)){
                    System.out.println(ogretmenList.toString());
                    ogretmenMenu();
                }else {
                    System.out.println("Tc no'ya ait ogretmen bulunamamistir");
                    ogretmenMenu();
                }
            }
        }else {
            System.out.println("Ogretmen listeniz bos");
            ogretmenMenu();
        }

    }

    @Override
    public void listeleme() {
        if (!ogretmenList.isEmpty()){
            for (Ogretmen each: ogretmenList) {
                System.out.println(each.toString());
            }
            ogretmenMenu();
        }else {
            System.out.println("Ogretmen Listesi Bos");
            ogretmenMenu();
        }

    }

    @Override
    public void silme() {
        if (!ogretmenList.isEmpty()){
            System.out.println("Silme yapilacak Tc no giriniz: ");
            String tcNo= scan.next();
            for (int i = 0; i < ogretmenList.size() ; i++) {
                if (tcNo.equals(ogretmenList.get(i).getTcNo())){
                    ogretmenList.remove(i);
                    ogretmenMenu();
                }
            }
        }else {
            System.out.println("Ogretmen Listesi Bos");
            ogretmenMenu();
        }

    }

    @Override
    public void cikis() {
        AnaMenu anaMenu = new AnaMenu();
        anaMenu.anaMenu();
    }
}
