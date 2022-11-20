package SansliMusteriBulmaProjesi;

import java.util.Scanner;

public class Menu {
    Registration registration = new Registration();
    Listing listing = new Listing();
    void giris (){
        System.out.println("Yapmak istediginiz islemi seciniz\n" +
                "1. Isim girisi\n" +
                "2. Sansli isimleri listeleme\n" +
                "3. Cikis\n" +
                "Seciminiz: ");
        Scanner scan = new Scanner(System.in);
        while (true){
            if (scan.hasNextInt()){
                int secim = scan.nextInt();
                switch (secim){
                    case 1: {
                        registration.register();
                        giris();
                    }
                    case 2: {
                        listing.listele(registration.userList);
                        giris();
                    }
                    case 3: {
                        System.out.println("Gule Gule");
                        System.exit(0);
                    }
                    default: {
                        System.out.println("Gecerli deger giriniz");
                        giris();
                    }

                }
            }else {
                System.out.println("Gecerli deger giriniz");
                giris();
            }
        }
    }
}
