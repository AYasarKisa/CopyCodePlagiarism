/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

public class Bulbasaur extends Pokemon{

    public Bulbasaur() {
        
    }
    

    public Bulbasaur(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }       

    @Override
    public int hasarPuaniGoster() {
        return 50;
    }
     @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/balbasaur.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Butterfree extends Pokemon {

    public Butterfree() {
    }

    public Butterfree(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }

    @Override
    public int hasarPuaniGoster() {
        return 10;
    }
    
    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/butterfree.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Charmander extends Pokemon{

  

    public Charmander() {
    }

    public Charmander(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }
      @Override
    public int hasarPuaniGoster() {
        return 60;
    }
   
    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/charmander.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
package prolab.pkg2;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static prolab.pkg2.Prolab2.yenile;
import static prolab.pkg2.Prolab2.flag;

public class ComputerVsComputerGUI {
    private boolean tekrarOynansinMi = false;
    private boolean anaMenuyeDonulsunMu = false;
    private boolean dongudenCikilsinMi=false;
    private boolean programSonlansinMi=false;
    private String kazananOyuncu = "";

    JFrame mainFrame = new JFrame();   
    
    OyuncuBilgisayar computer1 = new OyuncuBilgisayar("Bilgisayar 1",0,0);
    OyuncuBilgisayar computer2 = new OyuncuBilgisayar("Bilgisayar 2",0,0);
    ArrayList<Pokemon> listOfPokemon = new ArrayList<>();
    JTextField tbxComputer1Skor = new JTextField("  0");
    JTextField tbxComputer2Skor = new JTextField("  0");
    public boolean TekrarOynansinMi() {
        return tekrarOynansinMi;
    }

    public boolean AnaMenuyeDonulsunMu() {
        return anaMenuyeDonulsunMu;
    }

    public boolean DongudenCikilsinMi() {
        return dongudenCikilsinMi;
    }

    public void setDongudenCikilsinMi(boolean dongudenCikilsinMi) {
        this.dongudenCikilsinMi = dongudenCikilsinMi;
    }

    public boolean ProgramSonlansinMi() {
        return programSonlansinMi;
    }
    

    public ComputerVsComputerGUI() {

        ImageIcon icon = new ImageIcon(this.getClass().getResource("frameIcon.png"));
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);
        mainFrame.setLayout(null);
        
        
        JLabel lblComputer1 = new JLabel(new ImageIcon(this.getClass().getResource("computer.jpg")));
        JLabel lblComputer1Text = new JLabel("Bilgisayar1");

        lblComputer1Text.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblComputer1Text.setOpaque(true);
        lblComputer1Text.setBackground(Color.WHITE);
        lblComputer1Text.setForeground(Color.lightGray);

        JLabel lblComputer2 = new JLabel(new ImageIcon(this.getClass().getResource("computer.jpg")));
        JLabel lblComputer2Text = new JLabel("Bilgisayar2");

        lblComputer2Text.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblComputer2Text.setOpaque(true);
        lblComputer2Text.setBackground(Color.WHITE);
        lblComputer2Text.setForeground(Color.lightGray);

        lblComputer1.setBounds(0, 0, 300, 300);
        lblComputer2.setBounds(1550, 0, 300, 300);
        lblComputer1Text.setBounds(85, 320, 135, 100);
        lblComputer2Text.setBounds(1600, 300, 135, 100);

        JLabel lblComputer1Skor = new JLabel("Skor : ");
        lblComputer1Skor.setBounds(85, 500, 75, 100);
        lblComputer1Skor.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblComputer1Skor.setOpaque(true);
        lblComputer1Skor.setBackground(Color.WHITE);
        lblComputer1Skor.setForeground(Color.red);

        JLabel lblComputer2Skor = new JLabel("Skor : ");
        lblComputer2Skor.setBounds(1600, 500, 75, 100);
        lblComputer2Skor.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        lblComputer2Skor.setOpaque(true);
        lblComputer2Skor.setBackground(Color.WHITE);
        lblComputer2Skor.setForeground(Color.red);

        tbxComputer1Skor.setBounds(180, 500, 50, 100);
        tbxComputer1Skor.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        tbxComputer1Skor.setOpaque(true);
        tbxComputer1Skor.setBackground(Color.WHITE);
        tbxComputer1Skor.setForeground(Color.red);
        tbxComputer1Skor.setEditable(false);

        tbxComputer2Skor.setBounds(1700, 500, 50, 100);
        tbxComputer2Skor.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        tbxComputer2Skor.setOpaque(true);
        tbxComputer2Skor.setBackground(Color.WHITE);
        tbxComputer2Skor.setForeground(Color.red);
        tbxComputer2Skor.setEditable(false);

        mainFrame.add(lblComputer1);
        mainFrame.add(lblComputer2);
        mainFrame.add(lblComputer2Text);
        mainFrame.add(lblComputer1Text);
        mainFrame.add(lblComputer1Skor);
        mainFrame.add(lblComputer2Skor);
        mainFrame.add(tbxComputer1Skor);
        mainFrame.add(tbxComputer2Skor);
        mainFrame.repaint();

    }

    public void Savas() throws InterruptedException {
        Pikachu pikachu = new Pikachu("Pikachu", "Elektirik");
        Bulbasaur bulbasaur = new Bulbasaur("Bulbasaur", "Çim");
        Charmander charmander = new Charmander("Charmander", "Ateş");
        Squirtle squirtle = new Squirtle("Squirtle", "Su");
        Zubat zubat = new Zubat("Zubat", "Hava");
        Psyduck psyduck = new Psyduck("Psyduck", "Su");
        Snorlax snorlax = new Snorlax("Snorlax", "Normal");
        Butterfree butterfree = new Butterfree("Butterfree", "Hava");
        Jigglypuff jigglypuff = new Jigglypuff("Jigglypuff", "Ses");
        Meowth meowth = new Meowth("Meowth", "Normal");

        listOfPokemon.add(0, pikachu);
        listOfPokemon.add(1, bulbasaur);
        listOfPokemon.add(2, charmander);
        listOfPokemon.add(3, squirtle);
        listOfPokemon.add(4, zubat);
        listOfPokemon.add(5, psyduck);
        listOfPokemon.add(6, snorlax);
        listOfPokemon.add(7, butterfree);
        listOfPokemon.add(8, jigglypuff);
        listOfPokemon.add(9, meowth);

        int[][] kartKonumu1 = {{600, 40, 202, 252}, {820, 40, 202, 252}, {1040, 40, 202, 252}};
        int[][] kartKonumu2 = {{600, 600, 202, 252}, {820, 600, 202, 252}, {1040, 600, 202, 252}};
        int[] arenaBot1 = {720, 310, 202, 252};
        int[] arenaBot2 = {940, 310, 202, 252};

        Random random = new Random();
        int randomNumber;
        int aralik = 10;
        int i;
        for (i = 0; i < 3; i++) {

            randomNumber = random.nextInt(aralik);
            computer1.kart.add(listOfPokemon.get(randomNumber));
            listOfPokemon.get(randomNumber).butonAyarla("", kartKonumu1[i][0], kartKonumu1[i][1], kartKonumu1[i][2], kartKonumu1[i][3]);
            listOfPokemon.get(randomNumber).GUI_ekle(mainFrame);
            listOfPokemon.remove(randomNumber);
            aralik--;
        }

        for (i = 0; i < 3; i++) {
            randomNumber = random.nextInt(aralik);
            computer2.kart.add(listOfPokemon.get(randomNumber));
            listOfPokemon.get(randomNumber).butonAyarla("", kartKonumu2[i][0], kartKonumu2[i][1], kartKonumu2[i][2], kartKonumu2[i][3]);
            listOfPokemon.get(randomNumber).GUI_ekle(mainFrame);
            listOfPokemon.remove(randomNumber);
            aralik--;
        }

        for (i = 0; i < 5; i++) {
            Thread.sleep(1000);
            int randomNumber1 = computer1.kartSec();
            computer1.kart.get(randomNumber1).kartKullanildiMi = true;
            computer1.kart.get(randomNumber1).GUI_cikar(mainFrame);
            computer1.kart.get(randomNumber1).butonAyarla("", arenaBot1[0], arenaBot1[1], arenaBot1[2], arenaBot1[3]);
            computer1.kart.get(randomNumber1).GUI_ekle(mainFrame);

            int randomNumber2 = computer2.kartSec();
            computer2.kart.get(randomNumber2).kartKullanildiMi = true;
            computer2.kart.get(randomNumber2).GUI_cikar(mainFrame);
            computer2.kart.get(randomNumber2).butonAyarla("", arenaBot2[0], arenaBot2[1], arenaBot2[2], arenaBot2[3]);
            computer2.kart.get(randomNumber2).GUI_ekle(mainFrame);
            Thread.sleep(2000);
            yenile(mainFrame);
            int hasarPuani1 = computer1.kart.get(randomNumber1).hasarPuaniGoster();
            int hasarPuani2 = computer2.kart.get(randomNumber2).hasarPuaniGoster();

            if (hasarPuani1 > hasarPuani2) {
                computer1.SkoruArtir();
                tbxComputer1Skor.setText(Integer.toString(computer1.SkorGoster()));
            } else if (hasarPuani1 < hasarPuani2) {
                computer2.SkoruArtir();
                tbxComputer2Skor.setText(Integer.toString(computer2.SkorGoster()));
            }
            computer1.kart.get(randomNumber1).GUI_cikar(mainFrame);
            computer2.kart.get(randomNumber2).GUI_cikar(mainFrame);
            Thread.sleep(1000);
            computer1.kart.remove(randomNumber1);
            computer2.kart.remove(randomNumber2);

            if (listOfPokemon.size() > 0) {
                int newRandomNumber1 = random.nextInt(listOfPokemon.size());
                computer1.kart.add(randomNumber1, listOfPokemon.get(newRandomNumber1));
                listOfPokemon.remove(newRandomNumber1);
                computer1.kart.get(randomNumber1).butonAyarla("", kartKonumu1[randomNumber1][0], kartKonumu1[randomNumber1][1], kartKonumu1[randomNumber1][2], kartKonumu1[randomNumber1][3]);
                computer1.kart.get(randomNumber1).GUI_ekle(mainFrame);

                int newRandomNumber2 = random.nextInt(listOfPokemon.size());
                computer2.kart.add(randomNumber2, listOfPokemon.get(newRandomNumber2));
                listOfPokemon.remove(newRandomNumber2);
                computer2.kart.get(randomNumber2).butonAyarla("", kartKonumu2[randomNumber2][0], kartKonumu2[randomNumber2][1], kartKonumu2[randomNumber2][2], kartKonumu1[randomNumber2][3]);
                computer2.kart.get(randomNumber2).GUI_ekle(mainFrame);
            }

            mainFrame.repaint();

        }

        if (computer1.SkorGoster() > computer2.SkorGoster()) {
            kazananOyuncu = computer1.getOyuncuAdi();
        } else if (computer2.SkorGoster() > computer1.SkorGoster()) {
            kazananOyuncu = computer2.getOyuncuAdi();
        } else {
            kazananOyuncu = "Oyuncular Berabere Kaldı.";
        }
        
        JFrame exitFrame = new JFrame("Çıkış yapmak üzeresiniz.");
        JButton cikis = new JButton("Oyundan çıkış");
        JButton anaMenu = new JButton("Ana Menü");
        JButton tekrarOyna = new JButton("Tekrar Oyna");
        JLabel kazanan = new JLabel("Kazanan oyuncu :" + kazananOyuncu);
        kazanan.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        kazanan.setForeground(Color.red);

        exitFrame.add(kazanan);
        exitFrame.add(cikis);
        exitFrame.add(anaMenu);
        exitFrame.add(tekrarOyna);
        
        if (kazananOyuncu.equals("Bilgisayar")) { // Bilgisayar kazanira pencere boyutu 
            exitFrame.setSize(370, 120);
        } else {
            exitFrame.setSize(370, 120);
        }

        exitFrame.setLocationRelativeTo(null);// mesaj kutusunu merkeze almayi sagliyor.
        exitFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        exitFrame.setVisible(true);

        cikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                exitFrame.dispose();                
                mainFrame.dispose();
                programSonlansinMi=true;
                dongudenCikilsinMi=true;

            }
        });
        anaMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anaMenuyeDonulsunMu = true;
                dongudenCikilsinMi=true;
                exitFrame.dispose();                
                mainFrame.dispose();
                flag=4;

            }
        });
        tekrarOyna.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // savas fonksiyonu yazilacak.
                tekrarOynansinMi = true;
                dongudenCikilsinMi=true;
                exitFrame.dispose();                
                mainFrame.dispose();

            }
        });

        

    }

}    
package prolab.pkg2;

import java.awt.*;
import java.awt.event.*;

import java.util.Random;
import java.util.ArrayList;
import javax.swing.*;
import static prolab.pkg2.Prolab2.flag;

public class ComputerVsPlayerGUI {

    GercekOyuncu gercekOyuncu = new GercekOyuncu("Gercek Oyuncu", 0, 0);
    OyuncuBilgisayar bot = new OyuncuBilgisayar("Bilgisayar", 1, 0);
    
    Pikachu pikachu = new Pikachu("Pikachu", "Elektirik");
    Bulbasaur bulbasaur = new Bulbasaur("Bulbasaur", "Çim");
    Charmander charmander = new Charmander("Charmander", "Ateş");
    Squirtle squirtle = new Squirtle("Squirtle", "Su");
    Zubat zubat = new Zubat("Zubat", "Hava");
    Psyduck psyduck = new Psyduck("Psyduck", "Su");
    Snorlax snorlax = new Snorlax("Snorlax", "Normal");
    Butterfree butterfree = new Butterfree("Butterfree", "Hava");
    Jigglypuff jigglypuff = new Jigglypuff("Jigglypuff", "Ses");
    Meowth meowth = new Meowth("Meowth", "Normal");

    JLabel skorGercekOyuncu = new JLabel("Skor: 0");
    JLabel skorBilgisayar = new JLabel("Skor :0");
    JFrame mainFrame = new JFrame("Pokemon Oyunu"); // yeni bir gui olusturduk.
    JLabel botDurum = new JLabel("BOT DURUM");
    JLabel playerDurum = new JLabel("Oyuncu DURUM");

    // pokemonlar tanımlandı.
    public ArrayList<Pokemon> deste = new ArrayList<>();

    Random random = new Random();
    // kartların konumu tanımlandi.
    int[][] kartKonumu1 = {{600, 70, 202, 252}, {820, 70, 202, 252}, {1040, 70, 202, 252}};
    int[][] kartKonumu2 = {{600, 680, 202, 252}, {820, 680, 202, 252}, {1040, 680, 202, 252}};
    int[] arenaBot = {720, 370, 202, 252};
    int[] arenaGercek = {940, 370, 202, 252};

    private boolean tekrarOynansinMi = false;
    private boolean anaMenuyeDonulsunMu = false;
    private boolean dongudenCikilsinMi = false;
    private boolean programSonlansinMi = false;

    private String kazananOyuncu = "";

    public ComputerVsPlayerGUI(String oyuncuİsim, int oyuncuid) {
        gercekOyuncu.setOyuncuAdi(oyuncuİsim);
        gercekOyuncu.setOyuncuID(oyuncuid);
        
    }

    public boolean TekrarOynansinMi() {
        return tekrarOynansinMi;
    }

    public boolean AnaMenuyeDonulsunMu() {
        return anaMenuyeDonulsunMu;
    }

    public boolean DongudenCikilsinMi() {
        return dongudenCikilsinMi;
    }

    public void setDongudenCikilsinMi(boolean dongudenCikilsinMi) {
        this.dongudenCikilsinMi = dongudenCikilsinMi;
    }

    public boolean ProgramSonlansinMi() {
        return programSonlansinMi;
    }

    public void PrepareGUI() {

        JLabel real_label = new JLabel(new ImageIcon(this.getClass().getResource("real_player.png")));
        JLabel computer_label = new JLabel(new ImageIcon(this.getClass().getResource("computer.jpg")));
        JLabel computer_name = new JLabel(bot.getOyuncuAdi());
        JLabel real_name = new JLabel(gercekOyuncu.getOyuncuAdi());
        JLabel gercekOyuncuId = new JLabel("Oyuncu ID :" + Integer.toString(gercekOyuncu.getOyuncuID()));
        JLabel bilgisayarId = new JLabel("Oyuncu ID :" + Integer.toString(bot.getOyuncuID()));
        ImageIcon icon = new ImageIcon(this.getClass().getResource("frameIcon.png"));
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.setLayout(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false); // framin tekrar boyutlanmaini istemiyoruz.
        // burada sonra freame eklen şeyler gozukmez ama repaint yapiyoruz.

        real_label.setBounds(1500, 50, 214, 250);
        real_name.setFont(new Font("Arial", Font.BOLD, 24));
        real_name.setBounds(1500, 300, 200, 30);
        gercekOyuncuId.setBounds(1500, 330, 250, 30);
        gercekOyuncuId.setFont(new Font("Arial", Font.PLAIN, 24));
        skorGercekOyuncu.setBounds(1500, 360, 150, 30);
        skorGercekOyuncu.setFont(new Font("Skor : 0 ", Font.PLAIN, 30));
        playerDurum.setBounds(1500, 390, 250, 50);
        playerDurum.setFont(new Font("Arial", Font.BOLD, 18));
        //skorGercekOyuncu.setBackground(Color.white);
        skorGercekOyuncu.setForeground(Color.red);

        computer_label.setBounds(130, 50, 214, 250);
        computer_name.setBounds(130, 300, 150, 50);
        bilgisayarId.setBounds(130, 340, 250, 30);
        skorBilgisayar.setBounds(130, 370, 180, 50);
        botDurum.setBounds(130, 400, 250, 50);
        botDurum.setFont(new Font("Arial", Font.BOLD, 18));
        computer_name.setFont(new Font("Arial", Font.BOLD, 24));
        bilgisayarId.setFont(new Font("Arial", Font.PLAIN, 24));

        skorBilgisayar.setFont(new Font("Arial ", Font.PLAIN, 30));
        skorBilgisayar.setForeground(Color.red);

        mainFrame.add(real_name);
        mainFrame.add(computer_label);
        mainFrame.add(real_label);
        mainFrame.add(computer_name);
        mainFrame.add(skorGercekOyuncu);
        mainFrame.add(skorBilgisayar);
        mainFrame.add(gercekOyuncuId);
        mainFrame.add(bilgisayarId);
        mainFrame.add(playerDurum);
        mainFrame.add(botDurum);

    }

    public void Savas() throws InterruptedException {

        int i = 0;
        int sinir = 10;// index sinirini belirledim.
        int indis;
        deste.add(0, pikachu);
        deste.add(1, bulbasaur);
        deste.add(2, charmander);
        deste.add(3, squirtle);
        deste.add(4, zubat);
        deste.add(5, psyduck);
        deste.add(6, snorlax);
        deste.add(7, butterfree);
        deste.add(8, jigglypuff);
        deste.add(9, meowth);

        for (i = 0; i < 3; i++) {
            indis = random.nextInt(sinir); // rastgale bir indis
            Pokemon temp = deste.get(indis);
            gercekOyuncu.kart.add(temp);// gercek oyuncuya rastgele uc kart dagitildi.
            deste.remove(temp);
            sinir--;

        }
        for (i = 0; i < 3; i++) {
            indis = random.nextInt(sinir); // rastgale bir indis
            Pokemon temp = deste.get(indis);
            bot.kart.add(temp);// bot a rastgele uc kart dagitildi.
            deste.remove(temp);
            sinir--;
        }
        for (i = 0; i < 3; i++) { // gercek oyuncuya kartlar dagıtılıyor.

            gercekOyuncu.kart.get(i).butonAyarla("",
                    kartKonumu2[i][0], kartKonumu2[i][1], kartKonumu2[i][2],
                    kartKonumu2[i][3]);
            gercekOyuncu.kart.get(i).GUI_ekle(mainFrame);

            bot.kart.get(i).butonAyarla("",
                    kartKonumu1[i][0], kartKonumu1[i][1], kartKonumu1[i][2],
                    kartKonumu1[i][3]);
            bot.kart.get(i).GUI_ekle(mainFrame);
        }

        int botunSectigiKart = 0;
        int gercekOyuncuKart = -1;
        int randomIndex;
        int gOHasar;
        int botHasar;

        for (i = 0; i < 5; i++) {
            botDurum.setText("Bot Kart Seçiyor...");
            Thread.sleep(1000);
            botunSectigiKart = bot.kartSec();// bot kart secip index dondurecek.
            bot.kart.get(botunSectigiKart).GUI_cikar(mainFrame);
            bot.kart.get(botunSectigiKart).butonAyarla("", arenaBot[0],
                    arenaBot[1], arenaBot[2], arenaBot[3]);
            bot.kart.get(botunSectigiKart).GUI_ekle(mainFrame);
            botDurum.setText("");//botun durumu temizleniyor...
            playerDurum.setText("Lütfen bir kart seçin !");
            while (gercekOyuncuKart == -1) {
                gercekOyuncuKart = gercekOyuncu.kartSec();
                Thread.sleep(100);// cpu ya yuk indirmemek icin 100 ms bekletildi.
            }
            playerDurum.setText("");
            gercekOyuncu.kart.get(gercekOyuncuKart).GUI_cikar(mainFrame);
            gercekOyuncu.kart.get(gercekOyuncuKart).butonAyarla("",
                    arenaGercek[0], arenaGercek[1], arenaGercek[2], arenaGercek[3]);
            gercekOyuncu.kart.get(gercekOyuncuKart).GUI_ekle(mainFrame);

            gOHasar = gercekOyuncu.kart.get(gercekOyuncuKart).hasarPuaniGoster();
            botHasar = bot.kart.get(botunSectigiKart).hasarPuaniGoster();
            //Skor islemleri
            if (gOHasar > botHasar) {
                playerDurum.setText(gercekOyuncu.kart.get(gercekOyuncuKart).getPokemonAdi()
                        + " Kazandi. ");
                Thread.sleep(500);
                gercekOyuncu.SkoruArtir();
                skorGercekOyuncu.setText("Skor: " + Integer.toString(gercekOyuncu.SkorGoster()));
                Thread.sleep(1000);
                playerDurum.setText("");

            } else if (gOHasar == botHasar) {
                playerDurum.setText("Berabere Kalındı.");
                botDurum.setText("Berabere Kalındı.");

            } else {
                botDurum.setText(bot.kart.get(botunSectigiKart).getPokemonAdi()
                        + " Kazandı.");
                bot.SkoruArtir();
                Thread.sleep(500);
                skorBilgisayar.setText("Skor: " + Integer.toString(bot.SkorGoster()));
                Thread.sleep(1000);
                botDurum.setText("");

            }

            Thread.sleep(1000);// 1sn bekleme yapacak.

            bot.kart.get(botunSectigiKart).GUI_cikar(mainFrame);
            gercekOyuncu.kart.get(gercekOyuncuKart).GUI_cikar(mainFrame);
            bot.kart.remove(bot.kart.get(botunSectigiKart));
            gercekOyuncu.kart.remove(gercekOyuncu.kart.get(gercekOyuncuKart));

            // desteden yeni kartlar dağıtılıyor.
            if (deste.size() > 0) {
                randomIndex = random.nextInt(deste.size());// desteden rastgale bir kart sececek.
                gercekOyuncu.kart.add(gercekOyuncuKart, deste.get(randomIndex));
                deste.remove(randomIndex);
                randomIndex = random.nextInt(deste.size());// desteden rastgale bir kart sececek.
                bot.kart.add(botunSectigiKart, deste.get(randomIndex)); // botun sectigi kartaki index .
                deste.remove(randomIndex);

                gercekOyuncu.kart.get(gercekOyuncuKart).butonAyarla("",
                        kartKonumu2[gercekOyuncuKart][0], kartKonumu2[gercekOyuncuKart][1],
                        kartKonumu2[gercekOyuncuKart][2], kartKonumu2[gercekOyuncuKart][3]);
                gercekOyuncu.kart.get(gercekOyuncuKart).GUI_ekle(mainFrame);

                bot.kart.get(botunSectigiKart).butonAyarla("",
                        kartKonumu1[botunSectigiKart][0], kartKonumu1[botunSectigiKart][1],
                        kartKonumu1[botunSectigiKart][2], kartKonumu1[botunSectigiKart][3]);
                bot.kart.get(botunSectigiKart).GUI_ekle(mainFrame);
            }

            gercekOyuncuKart = -1;//gercek oyuncunun tekerar kart seçmesi sağlanacak.

        }
        // Kazanan Oyuncu belirleniyor.
        if (gercekOyuncu.SkorGoster() > bot.SkorGoster()) {
            kazananOyuncu = gercekOyuncu.getOyuncuAdi();
        } else if (gercekOyuncu.SkorGoster() < bot.SkorGoster()) {
            kazananOyuncu = bot.getOyuncuAdi();
        } else {
            kazananOyuncu = "Oyuncular Berabere Kaldı.";
        }

        JFrame exitFrame = new JFrame("Çıkış yapmak üzeresiniz.");
        JButton cikis = new JButton("Oyundan çıkış");
        JButton anaMenu = new JButton("Ana Menü");
        JButton tekrarOyna = new JButton("Tekrar Oyna");
        JLabel kazanan = new JLabel("Kazanan oyuncu :" + kazananOyuncu);
        kazanan.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        kazanan.setForeground(Color.red);

        exitFrame.add(kazanan);
        exitFrame.add(cikis);
        exitFrame.add(anaMenu);
        exitFrame.add(tekrarOyna);

        if (kazananOyuncu.equals("Bilgisayar")) { // Bilgisayar kazanira pencere boyutu 
            exitFrame.setSize(350, 120);
        } else {
            exitFrame.setSize(495, 120);
        }

        exitFrame.setLocationRelativeTo(null);// mesaj kutusunu merkeze almayi sagliyor.
        exitFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
        exitFrame.setVisible(true);

        cikis.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                exitFrame.dispose();
                mainFrame.dispose();
                programSonlansinMi = true;
                dongudenCikilsinMi = true;

            }
        });
        anaMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                anaMenuyeDonulsunMu = true;
                dongudenCikilsinMi = true;
                exitFrame.dispose();
                mainFrame.dispose();
                flag = 4;// tekrar ana menüde islem yapilmasini sagladik.

            }
        });
        tekrarOyna.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // savas fonksiyonu yazilacak.
                tekrarOynansinMi = true;
                dongudenCikilsinMi = true;
                exitFrame.dispose();
                mainFrame.dispose();

            }
        });

    }
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;


public class GercekOyuncu extends Oyuncu{

    public GercekOyuncu() {
    }

    public GercekOyuncu(String oyuncuAdi, int oyuncuID, int Skor) {
        super(oyuncuAdi, oyuncuID, Skor);
    }
    
    
    
    @Override
    public int kartSec() {
        int i;
        int index=-1;
        for(i=0;i<kart.size();i++){
            if(kart.get(i).kartKullanildiMi){
                index=i;
                        
            }
        }
       return index;
    }
    
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Jigglypuff extends Pokemon{

    public Jigglypuff() {
    }

    public Jigglypuff(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }

    @Override
    public int hasarPuaniGoster() {
    return 70;
    }

    
    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/jigglypuff.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
  
    
}  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Meowth extends Pokemon{

    public Meowth() {
    }

    public Meowth(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }

    @Override
    public int hasarPuaniGoster() {
        return 40;
    }

    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/meowth.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

import java.util.ArrayList;

/**
 *
 * @author BerkayEfeOzcan
 */
public abstract class Oyuncu {
    
    private  String oyuncuAdi;
    private  int oyuncuID;
    private  int  Skor;

    public ArrayList <Pokemon> kart = new ArrayList<>(); // pokemon objeleri tutulacak.
    
    public Oyuncu() {
        oyuncuAdi = "Gecersiz kullanici";
        oyuncuID =-1;
        Skor=0;
    }

    public Oyuncu(String oyuncuAdi, int oyuncuID, int Skor) {
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.Skor = Skor;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

   

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public void setSkor(int Skor) {
        this.Skor = Skor;
    }
    
    public int SkorGoster(){
        return Skor;
    }
    public void SkoruArtir(){
        Skor+=5;
    }
    public void kartEkle(Pokemon poke){
    
        kart.add(poke);
    }
    public void kartCikar(Pokemon poke){
        kart.remove(poke);
    }
    
   abstract int kartSec();
   
   
    
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;


import java.util.ArrayList;
import java.util.Random;

public class OyuncuBilgisayar extends Oyuncu {

    private int sinir;
    Random random = new Random();
    private int rastgele;

    public OyuncuBilgisayar() {
    }

    public OyuncuBilgisayar(String oyuncuAdi, int oyuncuID, int Skor) {
        super(oyuncuAdi, oyuncuID, Skor);
    } 
    
   
    @Override
    public int kartSec() {
        sinir=kart.size();
        rastgele = random.nextInt(sinir);
      

        return rastgele;
    }

}  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Pikachu extends Pokemon {

    public Pikachu() {
    }

    public Pikachu(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }
    
    
    @Override
    public int  hasarPuaniGoster() {
        return 40;
    }

    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/pikachu.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

import java.awt.event.*;
import javax.swing.*;
import static prolab.pkg2.Prolab2.yenile;
public  class Pokemon {
    private String pokemonAdi;
    private String pokemonTipi;
    public boolean kartKullanildiMi = false;
    private JButton button = new JButton();
    
    public Pokemon() {
        this.pokemonAdi="Bilgi Yok.";
        this.pokemonTipi="Bilgi Yok.";
        
    }

    public Pokemon(String pokemonAdi, String pokemonTipi) {
        this.pokemonAdi = pokemonAdi;
        this.pokemonTipi = pokemonTipi;
        
    }

    public String getPokemonAdi() {
        return pokemonAdi;
    }

    public String getPokemonTipi() {
        return pokemonTipi;
    }

    public boolean isKartKullanildiMi() {
        return kartKullanildiMi;
    } 

    public void setPokemonAdi(String pokemonAdi) {
        this.pokemonAdi = pokemonAdi;
    }

    public void setPokemonTipi(String pokemonTipi) {
        this.pokemonTipi = pokemonTipi;
    }

    public void setKartKullanildiMi(boolean kartKullanildiMi) {
        this.kartKullanildiMi = kartKullanildiMi;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
    
    
    
    public int hasarPuaniGoster()
    {
        return -1;
    }
    public void butonAyarla(String imagePath,int x,int y ,int width,int heigth){    
        button.setIcon(new ImageIcon(this.getClass().getResource(imagePath)));
        button.setBounds(x,y,width,heigth);// butonun konumlarini ayarladik.
        
    }
    public void tikDinle(){
        button.addActionListener(new ActionListener(){  
        public void actionPerformed(ActionEvent e){  
              // savas fonksiyonu yazilacak.
              kartKullanildiMi=true;
              
        }  
    });
    }
    public void GUI_ekle(JFrame zemin){ // buton guimize ekleniyot.
        zemin.add(button);
        tikDinle();
        yenile(zemin);
    }
    public void GUI_cikar(JFrame zemin){
        yenile(zemin);
        zemin.remove(button);
    }
    
    
}package prolab.pkg2;

import java.awt.Font;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prolab2 {

    public static int flag = -5;    //eger static fonksiyon taniimlasaydik ImageIcon fonksiyonu calismayacakti.
    public static String gercekOyuncuAdi = "";
    public static int gercekOyuncuId;
    static boolean cikayimMi = false;

    public void PrepareHomePage() { // classin methodu olmsasi icin static yaptik.

        JFrame homePage = new JFrame("Pokemon Oyunu");
        ImageIcon icon = new ImageIcon(this.getClass().getResource("frameIcon.png"));
        homePage.setIconImage(icon.getImage());
        JLabel resim = new JLabel(new ImageIcon(this.getClass().getResource("pokemon-logo.png")));  //not düş
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JButton bilgisayarVSBilgisayar = new JButton("Bilgisayar VS Bilgisayar");
        JButton bilgisayarVSOyuncu = new JButton("Bilgisayar VS Oyuncu  ");
        JButton cikis = new JButton("Oyundan Çıkış");
        resim.setBounds(0, 10, 401, 401);
        panel.setBounds(200, 200, 200, 200);
        panel1.setBounds(200, 200, 200, 200);
        panel2.setBounds(200, 200, 200, 200);
        bilgisayarVSBilgisayar.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        bilgisayarVSOyuncu.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        cikis.setFont(new java.awt.Font("Arial", Font.BOLD, 24));
        panel.add(bilgisayarVSBilgisayar);
        panel1.add(bilgisayarVSOyuncu);
        panel2.add(cikis);

        homePage.setSize(700, 600);
        homePage.setLocationRelativeTo(null);// mesaj kutusunu merkeze almayi sagliyor.
        homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homePage.add(resim);
        homePage.add(panel);
        homePage.add(panel1);
        homePage.add(panel2);
        homePage.setLayout(new FlowLayout(FlowLayout.CENTER));
        homePage.setVisible(true);
        homePage.setResizable(false); // framin tekrar boyutlanmaini istemiyoruz

        /**
         * *************************************
         * giris sayfasi olustutuldu. butonlara eylem atamasi yapilacak.
         */
        bilgisayarVSBilgisayar.addActionListener(new ActionListener() {
            // buton tiklanirsa.
            public void actionPerformed(ActionEvent e) {

                flag = 0;
                homePage.dispose();

            }
        });
        bilgisayarVSOyuncu.addActionListener(new ActionListener() {
            // buton tiklanirsa.
            public void actionPerformed(ActionEvent e) {

                flag = 1;
                homePage.dispose();

            }
        });
        cikis.addActionListener(new ActionListener() {
            // buton tiklanirsa.
            public void actionPerformed(ActionEvent e) {

                flag = 3;
                homePage.dispose();

            }
        });

    }

    public static void yenile(JFrame f) {
        f.repaint();

    }

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        Prolab2 main = new Prolab2();

        main.PrepareHomePage();

        while (true) {

            if (flag == 1) {

                JFrame oyuncuBilgileri = new JFrame();
                JTextField isim = new JTextField();
                JTextField id = new JTextField();
                JLabel isimLabel = new JLabel("İsminiz :");
                JLabel idLabel = new JLabel("ID :");
                JButton tamam = new JButton("Tamam");
                isimLabel.setBounds(50, 50, 100, 20);
                idLabel.setBounds(50, 80, 100, 20);
                isim.setBounds(110, 50, 150, 20);
                id.setBounds(110, 80, 150, 20);
                tamam.setBounds(50, 110, 100, 20);
                oyuncuBilgileri.add(isimLabel);
                oyuncuBilgileri.add(idLabel);
                oyuncuBilgileri.add(tamam);
                oyuncuBilgileri.add(id);
                oyuncuBilgileri.add(isim);
                oyuncuBilgileri.setSize(300, 220);
                oyuncuBilgileri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                oyuncuBilgileri.setLocationRelativeTo(null);
                oyuncuBilgileri.setLayout(null);
                oyuncuBilgileri.setVisible(true);
                //oyuncuBilgileri.setDefaultCloseOperation();

                tamam.addActionListener(new ActionListener() {
                    // buton tiklanirsa.
                    public void actionPerformed(ActionEvent e) {

                        gercekOyuncuAdi = isim.getText();
                        String temp = id.getText();
                        try { // eger kullanici int yerine string girerse hata verir.
                            gercekOyuncuId = Integer.parseInt(temp);
                        } catch ( java.lang.NumberFormatException tamamNumberFormatException) {
                           String mesaj = tamamNumberFormatException.getMessage();  
                           JOptionPane.showMessageDialog(oyuncuBilgileri,mesaj +
                                   " Oyuncu id tam sayi olmak zorundadır.","Alert",JOptionPane.WARNING_MESSAGE);                            
                           gercekOyuncuId = 0;
                           
                        }
                        
                        cikayimMi = true;
                        oyuncuBilgileri.dispose();

                    }
                });
                while (cikayimMi == false) {

                    Thread.sleep(100);
                }
                cikayimMi =false; // tekrar oynama başladığımızda beklemek için
                ComputerVsPlayerGUI computerVsPlayer = new ComputerVsPlayerGUI(gercekOyuncuAdi, gercekOyuncuId);
                computerVsPlayer.PrepareGUI();
                computerVsPlayer.Savas();
                while (computerVsPlayer.DongudenCikilsinMi() == false) {
                    Thread.sleep(100);
                }
                if (computerVsPlayer.AnaMenuyeDonulsunMu()) {
                    main.PrepareHomePage();
                }
                computerVsPlayer.setDongudenCikilsinMi(false);

                if (computerVsPlayer.ProgramSonlansinMi()) {
                    return;//eger program sonlandirilmisa basilmissa oyundan cikilacak.
                }

            } else if (flag == 0) {

                ComputerVsComputerGUI computerVsComputer = new ComputerVsComputerGUI();
                computerVsComputer.Savas();
                while (computerVsComputer.DongudenCikilsinMi() == false) {
                    Thread.sleep(200);
                }
                if (computerVsComputer.AnaMenuyeDonulsunMu()) {
                    main.PrepareHomePage();
                }
                computerVsComputer.setDongudenCikilsinMi(false);

                if (computerVsComputer.ProgramSonlansinMi()) {
                    return;//eger program sonlandirilmisa basilmissa oyundan cikilacak.
                }
            } else if (flag == 3) {
                return;
            }

            Thread.sleep(200);
        }

    }

}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Psyduck extends Pokemon {

    public Psyduck() {
    }

    public Psyduck(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
        
    }
   
    
    
    @Override
    public int hasarPuaniGoster() {
        return 20;
    }
      
    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/psyduck.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Snorlax extends Pokemon{

    public Snorlax() {
    }

    public Snorlax(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }  
    
    @Override
    public int hasarPuaniGoster() {
        return 30;
    }

    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/snorlax.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Squirtle extends Pokemon{

    public Squirtle() {
    }

    public Squirtle(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }       
    
    @Override
    public int hasarPuaniGoster() {
        return 30;
    }

    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/squirtle.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prolab.pkg2;

/**
 *
 * @author BerkayEfeOzcan
 */
public class Zubat extends Pokemon  {

    public Zubat() {
    }

    public Zubat(String pokemonAdi, String pokemonTipi) {
        super(pokemonAdi, pokemonTipi);
    }   
    
    @Override
    public int hasarPuaniGoster() {
        return 50;
    }

    @Override
    public void butonAyarla(String imagePath, int x, int y, int width, int weigth) {
        super.butonAyarla("/pokemons/zubat.png", x, y, width, weigth); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}