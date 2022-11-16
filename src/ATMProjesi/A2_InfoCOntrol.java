package ATMProjesi;

import java.util.Scanner;

import static ATMProjesi.A3_Transactions.ibanVeSifreKontrolEt;
import static ATMProjesi.A3_Transactions.sifreKontrol;
import static ATMProjesi.A4_MenuSecimi.menuSecimi;


public class A2_InfoCOntrol {

        public static void atmStart() {
            Scanner scan = new Scanner(System.in);
            System.out.println("ATM kartı olmadan işlem yapmak için 0'a basın\n" +
                    "ATM kartı ile işlem yapmak için 1'e basın");
            int kartSecimi = scan.nextInt();
            if (kartSecimi == 0) {
                kartsizIslem();
            } else if (kartSecimi == 1) {
                kartliIslem();
            } else {
                System.out.println("Lütfen 1 veya 0 girin...");
                atmStart();
            }
        }
        public static void kartsizIslem() {
            System.out.println("---- Kartsız İşlem Bölümü ----");
            if (sifreKontrol()) {
                menuSecimi();
            }else{
                System.out.println("Yanlış denemeler nedeniyle hesabınız bloke edildi!");
            }
        }

        public static void kartliIslem() {
            if (ibanVeSifreKontrolEt()) {
                menuSecimi();
            }else{
                System.out.println("Yanlış denemeler nedeniyle hesabınız bloke edildi!");
            }
        }
}
