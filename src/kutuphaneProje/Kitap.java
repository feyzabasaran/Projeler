package kutuphaneProje;

public class Kitap {

    /*
    1. kullanicinin Kitap ekleme, silme ve listeleme gibi
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

    private int no;
    private String kitapAdi;
    private String yazarAdi;
    private int yayinYili;
    private double fiyat;


    public Kitap() {
    }

    public Kitap(int no, String kitapAdi, String yazarAdi, int yayinYili, double fiyat) {
        this.no = no;
        this.kitapAdi = kitapAdi;
        this.yazarAdi = yazarAdi;
        this.yayinYili = yayinYili;
        this.fiyat = fiyat;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getYazarAdi() {
        return yazarAdi;
    }

    public void setYazarAdi(String yazarAdi) {
        this.yazarAdi = yazarAdi;
    }

    public int getYayinYili() {
        return yayinYili;
    }

    public void setYayinYili(int yayinYili) {
        this.yayinYili = yayinYili;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "\nKitap{" +
                "no=" + no +
                ", kitapAdi='" + kitapAdi + '\'' +
                ", yazarAdi='" + yazarAdi + '\'' +
                ", yayinYili=" + yayinYili +
                ", fiyat=" + fiyat +
                '}';
    }
}
