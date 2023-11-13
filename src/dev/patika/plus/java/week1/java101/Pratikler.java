package dev.patika.plus.java.week1.java101;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Arrays;

public class Pratikler {
    // PRATIK 8 - hesap makinesi
    public static void p08HesapMakinesi() {
        double[] hesaplanacaklar = new double[2];
        int islemTuru;
        double sonuc;
        String hataMesaji = "";

        Scanner girdi = new Scanner(System.in);

        System.out.println("Yapacağınız işlem türünü belirleyin:\n1 => Toplama\n2 => Çıkarma\n3 => Bölme\n4 => Çarpma\n");
        islemTuru = girdi.nextInt();

        for (int i = 0; i < hesaplanacaklar.length; i++) {
            System.out.println((i + 1) + ". (tam) sayıyı giriniz:");
            hesaplanacaklar[i] = girdi.nextDouble();
        }

        System.out.println("İşleminizin sonucu:");
        switch (islemTuru){
            case 1:
                sonuc = hesaplanacaklar[0] + hesaplanacaklar[1];
                break;
            case 2:
                sonuc = hesaplanacaklar[0] - hesaplanacaklar[1];
                break;
            case 3:
                sonuc = hesaplanacaklar[0] / hesaplanacaklar[1];
                break;
            case 4:
                sonuc = hesaplanacaklar[0] * hesaplanacaklar[1];
                break;
            default:
                sonuc = 0;
                hataMesaji = " Bir hata oluştu. İşlem türünü tek bir rakam olarak tekrar girmeyi deneyiniz.";
        }
        System.out.println(sonuc + hataMesaji);
    }

    // HACKERRANK PROBLEMI - Datatypes
    public static void hRp01() {
        Map<Integer, String> datatypes = new HashMap<>();
        datatypes.put(0, "byte");
        datatypes.put(1, "short");
        datatypes.put(2, "int");
        datatypes.put(3, "long");

        long[] sizesNegative = new long[4]; // 0, byte; 1, short; 2, int; 3, long
        sizesNegative[0] = -128;

        // Find the negative minimum values that they can hold for each datatype by multiplying the number at prior index by itself and 2 respectively.
        for (int i = 1; i < sizesNegative.length; i++) {
            sizesNegative[i] = -((long) Math.pow(sizesNegative[i - 1], 2) * 2);
        }

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            try {
                long x = sc.nextLong();
                System.out.println(x + " can be fitted in:");

                for (int j = 0; j < sizesNegative.length; j++) {
                    if (x >= sizesNegative[j] && x <= -(sizesNegative[j] + 1)) {
                        System.out.println("* " + datatypes.get(j));
                    }
                }
            } catch (Exception e) {
                System.out.println(sc.next() + " can't be fitted anywhere.");
            }
        }
    }

    // PRATIK 7
    public static void p07ManavKasaTutarHesapla() {
        float tutar = 0.0f;
        Scanner girdi = new Scanner(System.in);

        Map<String, Float> manav = new HashMap<>();
        manav.put("armut", 2.14f);
        manav.put("elma", 3.67f);
        manav.put("domates", 1.11f);
        manav.put("muz", 0.95f);
        manav.put("patlican", 5.0f);

        for (Map.Entry<String, Float> mal : manav.entrySet()) {
            System.out.println("Kaç kilo " + mal.getKey() + " aldınız?");
            tutar += girdi.nextFloat() * mal.getValue();
        }

        System.out.println("Toplam tutar: " + tutar);
    }

    // PRATIK 6
    public static void p06VucutKitleIndeksiHesapla() {
        float kilo, boy, vKI;
        Scanner girdi = new Scanner(System.in);

        System.out.println("Kilo bilginizi kg cinsinden giriniz:");
        kilo = girdi.nextFloat();
        System.out.println("Boy bilginizi m cinsinden giriniz:");
        boy = girdi.nextFloat();

        vKI = kilo / (boy * boy);
        System.out.println("Vücut kitle indeksiniz: " + vKI);
    }

    // PRATİK 5
    public static void p05DaireAlanVeCevreHesapla() {
        float PI = 3.14f;
        float yariCap, alan, cevre, merkezAci, dilimAlan;
        Scanner girdi = new Scanner(System.in);

        System.out.println("Dairenin yarı çapını giriniz:");
        yariCap = girdi.nextFloat();

        alan = PI * yariCap * yariCap;
        cevre = 2 * PI * yariCap;

        System.out.printf("%.2f yarı çaplı dairenizin\nalanı %.2f\nçevresi %.2f olarak hesaplanmıştır.\n", yariCap, alan, cevre);

        System.out.println("Bir daire diliminin alanını hesaplamak için merkez açı giriniz:");
        merkezAci = girdi.nextFloat();
        dilimAlan = (PI * (yariCap * yariCap) * merkezAci) / 360;

        System.out.printf("Belirlediğiniz %.2f merkez açısı için daire diliminin alanı %.2f olarak hesaplanmıştır.", merkezAci, dilimAlan);
    }

    // PRATİK 4
    public static void p04TaksimetreTutarHesapla() {
        float KM_TUTAR = 2.2f, TM_ACILIS = 10.0f, MIN_TUTAR = 20.0f;
        float mesafe, tutar;
        Scanner girdi = new Scanner(System.in);

        System.out.println("Gidilen mesafeyi KM cinsinden giriniz:");
        mesafe = girdi.nextFloat();
        tutar = TM_ACILIS + (mesafe * KM_TUTAR);

        if (tutar < MIN_TUTAR) {
            tutar = MIN_TUTAR;
        }

        System.out.println("Taksimetre tutarı: " + tutar + "₺");
    }

    // PRATİK 3
    public static void p03HipotenusVeAlanHesapla() {
        System.out.println("Önce hipotenüs hesaplama aracı çalışır.\nSonra üçgen alanı hesaplama aracı çalışır.");
        hipotenusHesapla();
        ucgenAlanHesapla();
    }

    public static int girdiAlInt() {
        Scanner girdi = new Scanner(System.in);
        return girdi.nextInt();
    }

    public static void ucgenAlanHesapla() {
        int[] kenarlar = new int[3];
        double cevre, alanKare, alan;

        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". kenarın uzunluğu:");
            kenarlar[i] = girdiAlInt();
        }

        // Tüm kenarlar toplanarak çevre elde edilir.
        cevre = Arrays.stream(kenarlar).sum();

        // Alan * Alan = 𝑢 * (𝑢 − 𝑎)* (𝑢 − 𝑏) * (𝑢 − 𝑐) hesaplanır
        alanKare = cevre / 2;
        for (int kenar : kenarlar) {
            alanKare *= ((cevre / 2) - kenar);
        }

        // Alan karenin kökü alınır ve alan bulunup ekrana yazdırılır.
        alan = Math.sqrt(alanKare);
        System.out.println("Üçgenin alanı " + alan);
    }

    public static void hipotenusHesapla() {
        float kareToplam = 0.0f;
        int dikKenar;

        for (int i = 0; i < 2; i++) {
            System.out.println((i + 1) + ". dik kenarın uzunluğunu giriniz:");
            dikKenar = girdiAlInt();
            kareToplam += (dikKenar * dikKenar);
        }

        double c = Math.sqrt(kareToplam);
        System.out.println("Dik üçgeninizin hipotenüsü " + c);
    }

    // PRATİK 2
    public static void p02KdvHesapla() {
        float urunFiyati, KDV, kdvTutari, urunFiyatiArtiKdv;
        Scanner girdi = new Scanner(System.in);

        System.out.println("Ürünün fiyatını giriniz:");
        urunFiyati = girdi.nextFloat();

        KDV = urunFiyati < 1000 ? 0.2f : 0.08f; // (neredeyse) sabit

        kdvTutari = urunFiyati * KDV;
        urunFiyatiArtiKdv = urunFiyati + kdvTutari;

        System.out.println("Ürünün KDV dahil fiyatı: " + (urunFiyatiArtiKdv) + "₺\nKDV tutarı: " + kdvTutari + "₺\nKDV oranı: %" + KDV * 100);
    }

    // PRATİK 1
    public static void p01NotOrtalamasiHesapla() {
        float ortalama = 0.0f;
        Scanner girdi  = new Scanner(System.in);

        System.out.println("Kaç ders notu gireceksiniz?");
        int dersSayisi = girdi.nextInt();

        System.out.println("Her dersten alınan notu sırayla giriniz.");
        for (int ders = 0; ders < dersSayisi; ders++) {
            System.out.println((ders + 1) + ". dersin notunu giriniz:");
            ortalama += girdi.nextFloat();
        }
        ortalama /= dersSayisi;

        System.out.println("Geçme notu 60'tır. Sizin not ortalamanız: " + ortalama);
        System.out.println(ortalama >= 60 ? "Başarıyla geçtiniz!": "Kaldınız!");
    }
}
