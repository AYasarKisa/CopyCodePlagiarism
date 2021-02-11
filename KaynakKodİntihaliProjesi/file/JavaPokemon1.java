package ermantos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ismail
 */
public class arayuz {

    private JFrame giriş;
    private JButton bilgisayar; // bilgisayar v bilgisayar
    private JButton kullanici; // kullanıcı v bilgisayar
    private JLabel oyuncuID;
    private JLabel oyuncuAdı;
    private JTextField yazdır;
    private JTextField yazdır1;
    private JButton tamamButon;
    private String isim1, isim2;

    public arayuz() {
        giriş = new JFrame("girişarayüzü");
        int x = 1366, y = 768;

        giriş.setLayout(null);

        bilgisayar = new JButton("kullanıcı v bilgisayar ");
        giriş.add(bilgisayar);

        bilgisayar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                Scanner a = new Scanner(System.in);
                giriş.dispose();
                JFrame giriş2 = new JFrame("girişarayüzü2");
                oyuncuID = new JLabel("oyuncuID");
                giriş2.getContentPane().add(oyuncuID);
                yazdır = new JTextField(20);
                giriş2.getContentPane().add(yazdır);

                oyuncuAdı = new JLabel("oyuncu adı ");
                giriş2.getContentPane().add(oyuncuAdı);
                yazdır1 = new JTextField(20);
                giriş2.getContentPane().add(yazdır1);

                tamamButon = new JButton("Tamam");
                tamamButon.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        isim1 = yazdır.getText();
                        isim2 =yazdır1.getText();
                       // System.out.println(isim1+"  "+isim2);
                    }
                });

                giriş2.add(tamamButon);
                tamamButon.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        String oyuncuID = yazdır.getText();
                        String oyuncuAdı = yazdır1.getText();
                        Oyuncu.setoyuncuID(oyuncuID);
                    }
                }
                );

                giriş2.setTitle("");
                giriş2.setLayout(new FlowLayout());

                giriş2.setSize(x, y);
                giriş2.setVisible(true);

                giriş2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }

        });

        kullanici = new JButton("bilgisayar v bilgisayar ");
        giriş.add(kullanici);
        kullanici.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JFrame giriş2 = new JFrame("girişarayüzü2");

                oyuncuAdı = new JLabel("oyuncu adı ");
                giriş2.getContentPane().add(oyuncuAdı);
                yazdır = new JTextField(20);
                giriş2.getContentPane().add(yazdır);

                tamamButon = new JButton("Tamam");
                tamamButon.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {
                        isim1 = yazdır.getText();

                        System.out.println(isim1);
                    }
                });

                giriş2.add(tamamButon);

                giriş2.setTitle("");
                giriş2.setLayout(new FlowLayout());

                giriş2.setSize(x, y);

                giriş2.setVisible(true);

                giriş2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        });

        giriş.setTitle("Pokemon");

        giriş.setLayout(new FlowLayout());

        giriş.setSize(x, y);

        giriş.setVisible(true);

        giriş.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import java.util.ArrayList;
import java.util.Random;

public class bilgisayar extends Oyuncu{
    
    @Override
    public int kartSec(ArrayList<Pokemon> gercek) {
        Random r = new Random();
        int esik=gercek.size()-1;
        if(esik==0){
            return 0;
        }
        return r.nextInt(esik);
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author PC
 */
public class bilgisayarVsBilgisayar {

    Random r = new Random();
    bilgisayar bilgisayarnesne2 = new bilgisayar();
    bilgisayar bilgisayarnesne = new bilgisayar();
    JFrame anaFrame = new JFrame("Pokemon Oyunu");
    int[][] mevki1 = {{400, 60, 120, 150}, {620, 60, 120, 150}, {840, 60, 120, 150}};
    int[][] mevki2 = {{400, 500, 120, 150}, {620, 500, 120, 150}, {840, 500, 120, 150}};
    int[] ortaMevki1 = {520, 270, 120, 150};
    int[] ortaMevki2 = {740, 270, 120, 150};
    private ArrayList<Pokemon> deste = new ArrayList<>();
    private ArrayList<Pokemon> bilgisayar2 = new ArrayList<>();
    private ArrayList<Pokemon> bilgisayar = new ArrayList<>();

    JLabel pcSkor = new JLabel("Skor:");
    JLabel pcSkor2 = new JLabel("Skor:");
    Pikachu pikachu = new Pikachu();
    Psyduck psyduck = new Psyduck();
    Snorlax snorlax = new Snorlax();
    Squirtle squirtle = new Squirtle();
    Zubat zubat = new Zubat();
    Bulbasaur bulbasaur = new Bulbasaur();
    Butterfree butterfree = new Butterfree();
    Charmander charmander = new Charmander();
    Jigglypuff jigglypuff = new Jigglypuff();
    Meowth meowth = new Meowth();

    public bilgisayarVsBilgisayar() {

        //anaFrame.setSize(1366,768);
        JLabel pcFoto = new JLabel();
        JLabel pcFoto2 = new JLabel();
        JLabel pcAd = new JLabel("Bilgisayar");
        JLabel pcAd2 = new JLabel("Bilgisayar2");

        pcFoto.setBounds(20, 60, 232, 217);
        pcFoto2.setBounds(1100, 400, 232, 217);
        pcAd.setBounds(100, 250, 100, 100);
        pcAd2.setBounds(1200, 520, 232, 217);
        pcSkor.setBounds(100, 220, 232, 217);
        pcSkor2.setBounds(1200, 550, 232, 217);
        pcFoto.setIcon(new ImageIcon(this.getClass().getResource("pc.jpg")));
        pcFoto2.setIcon(new ImageIcon(this.getClass().getResource("pc.jpg")));
        anaFrame.add(pcFoto);
        anaFrame.add(pcFoto2);
        anaFrame.add(pcAd);
        anaFrame.add(pcAd2);
        anaFrame.add(pcSkor);
        anaFrame.add(pcSkor2);

        anaFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        anaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        anaFrame.setLayout(null);
        anaFrame.setVisible(true);

    }

    public void kartDagit() {
        deste.add(0, pikachu);
        deste.add(1, bulbasaur);
        deste.add(2, zubat);
        deste.add(3, meowth);
        deste.add(4, butterfree);
        deste.add(5, snorlax);
        deste.add(6, squirtle);
        deste.add(7, charmander);
        deste.add(8, jigglypuff);
        deste.add(9, psyduck);

        // System.out.println(deste.get(0));
        int esik = 10, index;
        for (int i = 0; i < 3; i++) { // oyuncuya kartları dağıtıyor.
            index = r.nextInt(esik);
            bilgisayar2.add(deste.get(index));

            deste.remove(index);
            esik--;

        }
        for (int i = 0; i < 3; i++) { // oyuncuya kartları dağıtıyor.
            index = r.nextInt(esik);
            bilgisayar.add(deste.get(index));

            deste.remove(index);
            esik--;

        }

    }

    public void savas() throws InterruptedException {

        for (int i = 0; i < 3; i++) {

            bilgisayar2.get(i).butonAta("", mevki2[i][0], mevki2[i][1], mevki2[i][2], mevki2[i][3]);
            bilgisayar.get(i).butonAta("", mevki1[i][0], mevki1[i][1], mevki1[i][2], mevki1[i][3]);
            bilgisayar2.get(i).ekle(anaFrame);
            bilgisayar.get(i).ekle(anaFrame);
        }
        int index=-1;
        for (int i = 0; i < 5; i++) {
            
            if(deste.size()!=0)
            index=bilgisayarnesne2.kartSec(deste);
            
            System.out.println(index);

            bilgisayar2.get(index).cikar(anaFrame);
            bilgisayar2.get(index).butonAta("", ortaMevki1[0], ortaMevki1[1], ortaMevki1[2], ortaMevki1[3]);
            bilgisayar2.get(index).ekle(anaFrame);
            Thread.sleep(1500);

            int a = bilgisayarnesne.kartSec(bilgisayar);
            bilgisayar.get(a).butonAta("", ortaMevki2[0], ortaMevki2[1], ortaMevki2[2], ortaMevki2[3]);
            bilgisayar.get(a).ekle(anaFrame);

            if (bilgisayar2.get(index).getHasarPuanı() < bilgisayar.get(a).getHasarPuanı()) {
                bilgisayarnesne.setskor(bilgisayarnesne.getskor() + 5);

            } else if (bilgisayar2.get(index).getHasarPuanı() > bilgisayar.get(a).getHasarPuanı()) {
                System.out.println(bilgisayar2.get(index).getHasarPuanı());

                bilgisayarnesne2.setskor(bilgisayarnesne2.getskor() + 5);
            } else {
                bilgisayarnesne2.setskor(bilgisayarnesne2.getskor());
                bilgisayarnesne.setskor(bilgisayarnesne.getskor());
            }
            pcSkor.setText("Skor: " + bilgisayarnesne.getskor());
            pcSkor2.setText("Skor: " + bilgisayarnesne2.getskor());
            Thread.sleep(1500);

            bilgisayar.get(a).cikar(anaFrame);
            bilgisayar2.get(index).cikar(anaFrame);
            bilgisayar2.remove(index);
            bilgisayar.remove(a);

            if (deste.size() > 0) {
                int yeni = r.nextInt(deste.size());
                bilgisayar2.add(index, deste.get(yeni));
                deste.remove(yeni);
                bilgisayar2.get(index).butonAta("", mevki2[index][0], mevki2[index][1], mevki2[index][2], mevki2[index][3]);
                bilgisayar2.get(index).ekle(anaFrame);
                yeni = r.nextInt(deste.size());
                bilgisayar.add(a, deste.get(yeni));
                deste.remove(yeni);
                bilgisayar.get(a).butonAta("", mevki1[a][0], mevki1[a][1], mevki1[a][2], mevki1[a][3]);
                bilgisayar.get(a).ekle(anaFrame);

            }

            Thread.sleep(1000);

        }
        String kazananOyuncu=" ";
        if (bilgisayarnesne2.getskor() > bilgisayarnesne.getskor()) {
            kazananOyuncu = "Bilgisayar2";
        } else {
            kazananOyuncu = "Bilgisayar";
        }

        JFrame kazanan = new JFrame();
        JLabel kazananJLabel = new JLabel(kazananOyuncu);
        kazanan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kazananJLabel.setText("Kazanan Oyuncu :"+kazananOyuncu);
        kazananJLabel.setBounds(20, 20, 200, 30);
        kazanan.add(kazananJLabel,BorderLayout.CENTER);
        kazanan.setSize(200, 200);
        kazanan.setLocationRelativeTo(null);
        kazanan.setLayout(null);
        kazanan.setVisible(true);
        
        anaFrame.dispose();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

/**
 *
 * @author PC
 */
public class bilgisayarVsOyuncu {

    Random r = new Random();
    Kullanıcı kullanıcı = new Kullanıcı();
    bilgisayar bilgisayarnesne = new bilgisayar();
    JFrame anaFrame = new JFrame("Pokemon Oyunu");
    int[][] mevki1 = {{400, 60, 120, 150}, {620, 60, 120, 150}, {840, 60, 120, 150}};
    int[][] mevki2 = {{400, 500, 120, 150}, {620, 500, 120, 150}, {840, 500, 120, 150}};
    int[] ortaMevki1 = {520, 270, 120, 150};
    int[] ortaMevki2 = {740, 270, 120, 150};
    private ArrayList<Pokemon> deste = new ArrayList<>();
    private ArrayList<Pokemon> oyuncu = new ArrayList<>();
    private ArrayList<Pokemon> bilgisayar = new ArrayList<>();

    JLabel pcSkor = new JLabel("Skor:");
    JLabel oyuncuSkor = new JLabel("Skor:");
    Pikachu pikachu = new Pikachu();
    Psyduck psyduck = new Psyduck();
    Snorlax snorlax = new Snorlax();
    Squirtle squirtle = new Squirtle();
    Zubat zubat = new Zubat();
    Bulbasaur bulbasaur = new Bulbasaur();
    Butterfree butterfree = new Butterfree();
    Charmander charmander = new Charmander();
    Jigglypuff jigglypuff = new Jigglypuff();
    Meowth meowth = new Meowth();

    public bilgisayarVsOyuncu() {

        //anaFrame.setSize(1366,768);
        JLabel pcFoto = new JLabel();
        JLabel oyuncuFoto = new JLabel();
        JLabel pcAd = new JLabel("Bilgisayar");
        JLabel oyuncuAd = new JLabel("Oyuncu");

        pcFoto.setBounds(20, 60, 232, 217);
        oyuncuFoto.setBounds(1100, 400, 232, 217);
        pcAd.setBounds(100, 250, 100, 100);
        oyuncuAd.setBounds(1200, 520, 232, 217);
        pcSkor.setBounds(100, 220, 232, 217);
        oyuncuSkor.setBounds(1200, 550, 232, 217);
        pcFoto.setIcon(new ImageIcon(this.getClass().getResource("pc.jpg")));
        oyuncuFoto.setIcon(new ImageIcon(this.getClass().getResource("ash.jpg")));
        anaFrame.add(pcFoto);
        anaFrame.add(oyuncuFoto);
        anaFrame.add(pcAd);
        anaFrame.add(oyuncuAd);
        anaFrame.add(pcSkor);
        anaFrame.add(oyuncuSkor);

        anaFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        anaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        anaFrame.setLayout(null);
        anaFrame.setVisible(true);

    }

    public void kartDagit() {
        deste.add(0, pikachu);
        deste.add(1, bulbasaur);
        deste.add(2, zubat);
        deste.add(3, meowth);
        deste.add(4, butterfree);
        deste.add(5, snorlax);
        deste.add(6, squirtle);
        deste.add(7, charmander);
        deste.add(8, jigglypuff);
        deste.add(9, psyduck);

        // System.out.println(deste.get(0));
        int esik = 10, index;
        for (int i = 0; i < 3; i++) { // oyuncuya kartları dağıtıyor.
            index = r.nextInt(esik);
            oyuncu.add(deste.get(index));

            deste.remove(index);
            esik--;

        }
        for (int i = 0; i < 3; i++) { // oyuncuya kartları dağıtıyor.
            index = r.nextInt(esik);
            bilgisayar.add(deste.get(index));

            deste.remove(index);
            esik--;

        }

    }

    public void savas() throws InterruptedException {

        for (int i = 0; i < 3; i++) {

            oyuncu.get(i).butonAta("", mevki2[i][0], mevki2[i][1], mevki2[i][2], mevki2[i][3]);
            bilgisayar.get(i).butonAta("", mevki1[i][0], mevki1[i][1], mevki1[i][2], mevki1[i][3]);
            oyuncu.get(i).ekle(anaFrame);
            bilgisayar.get(i).ekle(anaFrame);
        }
        int döndür = -1;
        for (int i = 0; i < 5; i++) {
            while (döndür == -1) {
                döndür = kullanıcı.kartSec(oyuncu);
            }

            oyuncu.get(döndür).cikar(anaFrame);
            oyuncu.get(döndür).butonAta("", ortaMevki1[0], ortaMevki1[1], ortaMevki1[2], ortaMevki1[3]);
            oyuncu.get(döndür).ekle(anaFrame);

            int a = bilgisayarnesne.kartSec(oyuncu);
            bilgisayar.get(a).butonAta("", ortaMevki2[0], ortaMevki2[1], ortaMevki2[2], ortaMevki2[3]);
            bilgisayar.get(a).ekle(anaFrame);

            if (oyuncu.get(döndür).getHasarPuanı() < bilgisayar.get(a).getHasarPuanı()) {
                bilgisayarnesne.setskor(bilgisayarnesne.getskor() + 5);

            } else if (oyuncu.get(döndür).getHasarPuanı() > bilgisayar.get(a).getHasarPuanı()) {
                System.out.println(oyuncu.get(döndür).getHasarPuanı());

                kullanıcı.setskor(kullanıcı.getskor() + 5);
            } else {
                kullanıcı.setskor(kullanıcı.getskor());
                bilgisayarnesne.setskor(bilgisayarnesne.getskor());
            }
            pcSkor.setText("Skor: " + bilgisayarnesne.getskor());
            oyuncuSkor.setText("Skor: " + kullanıcı.getskor());
            Thread.sleep(2000);

            bilgisayar.get(a).cikar(anaFrame);
            oyuncu.get(döndür).cikar(anaFrame);
            oyuncu.remove(döndür);
            bilgisayar.remove(a);

            if (deste.size() > 0) {
                int yeni = r.nextInt(deste.size());
                oyuncu.add(döndür, deste.get(yeni));
                deste.remove(yeni);
                oyuncu.get(döndür).butonAta("", mevki2[döndür][0], mevki2[döndür][1], mevki2[döndür][2], mevki2[döndür][3]);
                oyuncu.get(döndür).ekle(anaFrame);
                yeni = r.nextInt(deste.size());
                bilgisayar.add(a, deste.get(yeni));
                deste.remove(yeni);
                bilgisayar.get(a).butonAta("", mevki1[a][0], mevki1[a][1], mevki1[a][2], mevki1[a][3]);
                bilgisayar.get(a).ekle(anaFrame);

            }

            döndür = -1;

        }
        String kazananOyuncu=" ";
        if (kullanıcı.getskor() > bilgisayarnesne.getskor()) {
            kazananOyuncu = "Oyuncu";
        } else {
            kazananOyuncu = "Bilgisayar";
        }

        JFrame kazanan = new JFrame();
        JLabel kazananJLabel = new JLabel(kazananOyuncu);
        kazanan.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        kazananJLabel.setText("Kazanan Oyuncu :"+kazananOyuncu);
        kazananJLabel.setBounds(20, 20, 200, 30);
        kazanan.add(kazananJLabel,BorderLayout.CENTER);
        kazanan.setSize(200, 200);
        kazanan.setLayout(null);
        kazanan.setVisible(true);
        
        anaFrame.dispose();

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Bulbasaur extends Pokemon{
    int hasarPuanı=50;
     @Override
    public void butonAta(String foto, int x, int y, int z, int r) {
        super.butonAta("bulbasaur.png", x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }
    

    public Bulbasaur(String pokemonTip, String pokemonAdı) {
        super(pokemonTip, pokemonAdı);
         
    }

    public Bulbasaur() {
    }

    @Override
    public int getHasarPuanı() {
        return 50; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Butterfree extends Pokemon {

    int hasarPuanı = 10;
     @Override
    public void butonAta(String foto, int x, int y, int z, int r) {
        super.butonAta("butterfree.jpg",  x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }

    public Butterfree(String pokemonTip, String pokemonAdı) {
        super(pokemonTip, pokemonAdı);
    }

    public Butterfree() {
    }

    @Override
    public int getHasarPuanı() {
        return 10; //To change body of generated methods, choose Tools | Templates.
    }

    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Charmander extends Pokemon{
    int hasarPuanı = 60;
      @Override
    public void butonAta(String foto,  int x, int y, int z, int r) {
        super.butonAta("charmander.png",  x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }

    public Charmander(String pokemonTip, String pokemonAdı) {
        super(pokemonTip, pokemonAdı);
    }

    public Charmander() {
    }

    @Override
    public int getHasarPuanı() {
        return 60; //To change body of generated methods, choose Tools | Templates.
    }
     
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

/**
 *
 * @author BerkayEfe
 */
public class Ermantos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
      //  bilgisayarVsOyuncu savas1 = new bilgisayarVsOyuncu();
      //  savas1.kartDagit();
       // savas1.savas();
        bilgisayarVsBilgisayar savas2 = new bilgisayarVsBilgisayar();
        savas2.kartDagit();
        savas2.savas();
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Jigglypuff extends Pokemon{
    int hasarPuanı = 70;
      @Override
    public void butonAta(String foto,  int x, int y, int z, int r) {
        super.butonAta("Jigglypuff.png",  x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public int getHasarPuanı() {
        return 70; //To change body of generated methods, choose Tools | Templates.
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import java.util.ArrayList;

public class Kullanıcı extends Oyuncu {

    @Override
    public int kartSec(ArrayList<Pokemon> gercek) {
        for (int i = 0; i < gercek.size(); i++) {
            
            if (gercek.get(i).KartKullanildimi()==true) {
              return i;
            }
            
        }
        return -1;
    }
    
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Meowth extends Pokemon{
    int hasarPuanı = 40;
      @Override
    public void butonAta(String foto, int x, int y, int z, int r) {
        super.butonAta("meowth.png", x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public int getHasarPuanı() {
        return 40; //To change body of generated methods, choose Tools | Templates.
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import java.util.ArrayList;

public abstract class Oyuncu {
    public static String oyuncuID;
    public static String oyuncuAdı;
    public  int skor=0;// STATİC OLMAMALI
    public static String getoyuncuID()
    {
                return oyuncuID;
    }
    public static void setoyuncuID(String a)
    {
        oyuncuID=a;
    }
     public static String getoyuncuAdı()
    {
                return oyuncuAdı;
    }
    public static void setoyuncuAdı(String b)
    {
        oyuncuAdı = b;
    } 
     public int getskor()
    {
                return skor;
    }
    public void setskor(int c)
    {
        skor=c;
    }
    public abstract int kartSec(ArrayList<Pokemon> gercek); // abstract olarak tanimlardik.
    
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Pikachu extends Pokemon{
    int hasarPuanı = 40;
        @Override
    public void butonAta(String foto,  int x, int y, int z, int r) {
        super.butonAta("Pikachu.png", x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getHasarPuanı() {
        return 40; //To change body of generated methods, choose Tools | Templates.
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Pokemon {

    private int pokemonID;
    private int hasarPuanı ;
    private String pokemonTip;
    private String pokemonAdı;
    private boolean kartKullanildimi=false;
    private JButton button = new JButton();

    public Pokemon(String pokemonTip, String pokemonAdı) {
        this.pokemonTip = pokemonTip;
        this.pokemonAdı = pokemonAdı;
        
    }
   
    public Pokemon() {
       
        
    }

    public int getHasarPuanı() {
        return hasarPuanı;
    }

    public void setHasarPuanı(int hasarPuanı) {
        this.hasarPuanı = hasarPuanı;
    }
    

    public int getpokemonID() {
        return pokemonID;
    }

    public void setpokemonID(int a) {
        pokemonID = a;
    }

    public String getpokemonTip() {
        return pokemonTip;
    }

    public void setpokemonID(String b) {
        pokemonTip = b;
    }

    public String getpokemonAdı() {
        return pokemonAdı;
    }

    public void setpokemonAdı(String c) {
        pokemonAdı = c;
    }

   

    public boolean KartKullanildimi() {
        return kartKullanildimi;
    }
    

    public ImageIcon getResimYolu(ImageIcon resim) {
        return resim;
    }

    public void butonAta(String foto, int x, int y, int z, int r) {

        button.setIcon(new ImageIcon(this.getClass().getResource(foto)));
        button.setBounds(x, y, z, r);

    }

    public void ekle(JFrame Ata) {
        Ata.add(button);
        Ata.repaint();
        butonTık();
    }

    public void cikar(JFrame Ata) {

        Ata.remove(button);
        Ata.repaint();

    }

    public void butonTık() {
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                kartKullanildimi=true;
                
            }
        });
    }

}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Psyduck extends Pokemon{
    int hasarPuanı = 20;

    @Override
    public void butonAta(String foto, int x, int y, int z, int r) {
        super.butonAta("psyduck.png", x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }
    
     @Override
    public int getHasarPuanı() {
        return 20; //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;


import javax.swing.JFrame;

public class Snorlax extends Pokemon{
    int hasarPuanı=30;
       @Override
    public void butonAta(String foto, int x, int y, int z, int r) {
        super.butonAta("snorlax.png",  x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public int getHasarPuanı() {
        return 30; //To change body of generated methods, choose Tools | Templates.
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Squirtle extends Pokemon {
    int hasarPuanı = 30;
        @Override
    public void butonAta(String foto, int x, int y, int z, int r) {
        super.butonAta("Squirtle.png", x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public int getHasarPuanı() {
        return 30; //To change body of generated methods, choose Tools | Templates.
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ermantos;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Zubat extends Pokemon{
    int hasarPuanı = 50;
       @Override
    public void butonAta(String foto,  int x, int y, int z, int r) {
        super.butonAta("zubat.png",  x, y, z, r); //To change body of generated methods, choose Tools | Templates.
    }
     @Override
    public int getHasarPuanı() {
        return 50; //To change body of generated methods, choose Tools | Templates.
    }
}



