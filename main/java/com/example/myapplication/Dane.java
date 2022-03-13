package com.example.myapplication;

public class Dane {
    private String opis;
    private int cena;
    private int zdj;
    public static Dane[] kompy= new Dane[]{new Dane("I5-12600K/16GB DDR4/SSD 512GB/RTX3070 8GB",7000,R.drawable.komp1),
            new Dane("I7-12700KF/16GB DDR5/SSD 1TB/RTX3080TI 12GB",10000, R.drawable.komp2),
            new Dane("I5-12400F/16GB DDR4/SSD 256GB/RTX2060 6GB",4500,R.drawable.komp3)
    };


    public static Dane[] mouse=new Dane[]{new Dane(
            "LOGITECH G203 Czarny",60,R.drawable.myszka1),
            new Dane("LOGITECH G502 Hero",180,R.drawable.myszka2),
            new Dane("RAZER DeathAdder Essential",2,R.drawable.myszka3)
    };
    public static Dane[] klawy = new Dane[]{new Dane(
            "LOGITECH G413 Carbon",260,R.drawable.klawiatura1),
            new Dane("KRUX Atax Pro RGB",150,R.drawable.klawiatura2),
            new Dane("REDRAGON Draconic K53",80,R.drawable.klawiatura3)
    };
    public static Dane[] monitory = new Dane[]{new Dane(
            "LG 27GN800‑B",1000,R.drawable.monitor1),
            new Dane("Samsung Odyssey S24AG320NU",750,R.drawable.monitor2),
            new Dane("LG Ultragear 27GP850 NanoIPS HDR",900,R.drawable.monitor3)
    };

    public Dane(String opis, int cena, int zdj) {
        this.opis=opis;
        this.cena=cena;
        this.zdj=zdj;
    }

    public int getCena() {
        return cena;
    }

    public int getZdj() {
        return zdj;
    }

    public String getOpis() {
        return opis;
    }
}
