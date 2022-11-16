package OkulProjesi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Ogretmen {
    static Scanner scan = new Scanner(System.in);
    static Map<String, String> ogretmenlerMap = new HashMap<>();

    public static void feykOgretmenEkle() {
        ogretmenlerMap.put("123456782346", "Ali, Can, 1980, Matematik");
        ogretmenlerMap.put("132345682346", "Veli, Yan, 1981, Fizik");
        ogretmenlerMap.put("223456782346", "Ayse, Can, 1982, Kimya");
        ogretmenlerMap.put("143456782366", "Ali, San, 1983, Kimya");
        ogretmenlerMap.put("225456782346", "Alp, Yan, 1984, Matematik");

    }

    public static void ogretmenMenu() throws InterruptedException {
        String tercih = "";
        do {
            System.out.println("========= YILDIZ KOLEJİ =========\n " +
                    "======== OGRETMEN MENU ========\n" +
                    "\n" +
                    "\t 1- Ogretmenler Listesi Yazdir\t\n" +
                    "\t 2- Soyisimden Ogretmen Bulma\n" +
                    "\t 3- Branstan Ogretmen Bulma\t\t \n" +
                    "\t 4- Bilgilerini Girerek Ogretmen Ekleme\n" +
                    "\t 5- Kimlik No İle Kayit Silme \t\n" +
                    "\t A- ANAMENU\n" +
                    "\t Q- CIKIS\n");
            tercih = scan.nextLine();

            switch (tercih) {
                case "1": // Ogretmenler Listesi Yazdir
                    ogretmenListesiYazdir();
                    break;
                case "2": // Soyisimden Ogretmen Bulma
                    soyisimdenOgretmenBulma();
                    break;
                case "3": // Branstan Ogretmen Bulma
                    branstanOgretmenBulma();
                    break;
                case "4": // Bilgilerini Girerek Ogretmen Ekleme
                    ogretmenEkleme();
                    break;
                case "5": // Kimlik No İle Kayit Silme
                    tcNoIleOgretmenSil();

                    break;
                case "A":
                case "a":
                    Depo.anaMenu();
                    break;
                case "q":
                case "Q":
                    break;
                default:
                    System.out.println("Lutfen gecerli tercih yapiniz");

            }
        } while (!tercih.equalsIgnoreCase("q"));
        Depo.projeDurdur();

    }

    public static void tcNoIleOgretmenSil() {
        System.out.println("Silinecek ogretmen kimlik no giriniz");
        String silinecekOgretmen = scan.nextLine();

        String silinecekValue = ogretmenlerMap.get(silinecekOgretmen);

        String sonucValue = ogretmenlerMap.remove(silinecekOgretmen);
        try {
            boolean sonuc = sonucValue.equalsIgnoreCase(silinecekValue);
        } catch (Exception e) {
            System.out.println("Istediginiz tc no ile ogretmen bulunamadi");
        }
    }

    public static void ogretmenEkleme() {
        System.out.println("Tc No");
        String tcNo = scan.nextLine();
        System.out.println("isim");
        String isim = scan.nextLine();
        System.out.println("soyisim");
        String soyisim = scan.nextLine();
        System.out.println("Dogum yili");
        String dYili = scan.nextLine();
        System.out.println("Brans");
        String brans = scan.nextLine();

        String eklenecekValue = isim + ", " + soyisim + ", " + dYili + ", " + brans;
        ogretmenlerMap.put(tcNo, eklenecekValue);
    }

    public static void branstanOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin bransini giriniz");
        String istenenBrans = scan.nextLine();

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println("========= YILDIZ KOLEJİ =========\n " +
                "===== BRANS İLE OGRETMEN ARAMA ====\n" +
                "TcNo        Isim    Soyisim   D. Yili  Brans\"");
        for (Map.Entry<String, String> each : ogretmenEntrySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");
            if (istenenBrans.equalsIgnoreCase(eachValuearr[3])) {
                System.out.printf("%11s %-6s  %-8s %4s   %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3]);
            }

        }
        Thread.sleep(5000);
    }

    public static void soyisimdenOgretmenBulma() throws InterruptedException {
        System.out.println("Aradiginiz Ogretmenin soyismini giriniz");
        String istenenSoyisim = scan.nextLine();

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println("========= YILDIZ KOLEJİ =========\n " +
                "===== SOYISIMDEN OGRETMEN ARAMA ====\n" +
                "TcNo        Isim      Soyisim   D. Yili  Brans\"");
        for (Map.Entry<String, String> each : ogretmenEntrySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String eachValuearr[] = eachValue.split(", ");
            if (istenenSoyisim.equalsIgnoreCase(eachValuearr[1])) {
                System.out.printf("%11s %-6s  %-8s %4s   %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                        eachValuearr[2], eachValuearr[3]);
            }

        }
        Thread.sleep(5000);
    }

    public static void ogretmenListesiYazdir() throws InterruptedException {

        Set<Map.Entry<String, String>> ogretmenEntrySet = ogretmenlerMap.entrySet();
        System.out.println("========= YILDIZ KOLEJİ =========\n " +
                "========= OGRETMEN LISTESİ ========\n" +
                "TcNo        Isim      Soyisim   D. Yili  Brans");
        for (Map.Entry<String, String> each : ogretmenEntrySet
        ) {
            String eachKey = each.getKey();
            String eachValue = each.getValue();

            String[] eachValuearr = eachValue.split(", ");
            System.out.printf("%11s %-6s  %-8s %4s   %s \n", eachKey, eachValuearr[0], eachValuearr[1],
                    eachValuearr[2], eachValuearr[3]);

        }
        Thread.sleep(5000);
    }
}
