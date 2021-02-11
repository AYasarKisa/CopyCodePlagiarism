import os
from os import listdir
from os.path import isfile, join
from fuzzywuzzy import fuzz
from fuzzywuzzy import process
import numpy as np
from fuzzy import interp_membership, trimf, centroid,trapmf
import matplotlib.pyplot as plt
import math as m
import time


def dizindenDosyalariOku():
    print("Toplam Dosya Sayisi {}".format(len(onlyfiles)))
    for i in range(0, len(onlyfiles), 1):
        for n in range(i + 1, len(onlyfiles), 1):
            dosya1 = open("./file/" + onlyfiles[i], 'r')  
            dosya2 = open("./file/" + onlyfiles[n], 'r')
            str1 = dosya1.read()
            str2 = dosya2.read()

            print("Islem Yapilan Dosya Numaralari:  {}--{}".format(i,n))

            str1 = "".join(str1.split())  # kaynak koddak' bosluklari sildik
            str2 = "".join(str2.split())
            benzerlikOrani = fuzz.token_sort_ratio(str1, str2)  # iki kaynak dosya arasindaki benzerlik orani bulduk.      
            progDiliBenzerlikOrani = getProglamaDillerininBenzerlikOrani(onlyfiles[i],onlyfiles[n])
            dosyaKarsilastirmaListesi.append((onlyfiles[i], onlyfiles[n], benzerlikOrani,progDiliBenzerlikOrani))

            dosya1.close()  # dosyayı kapatma işlemi
            dosya2.close()  # dosyayı kapatma işlemi



def uyelikFonksiyonulariniCizdir() :
    fig, (ax0, ax1, ax2) = plt.subplots(nrows=3, figsize=(6, 10))
    ax0.plot(crispInputAraligi, kodAzBenzer, 'r', linewidth=2, label='kod az benzer')
    ax0.plot(crispInputAraligi, kodBenzer, 'g', linewidth=2, label='kod benzer')
    ax0.plot(crispInputAraligi, kodCokBenzer, 'b', linewidth=2, label='kod cok benzer')
    ax0.set_title('Kod benzerligi')
    ax0.legend()
    ax1.plot(crispInputAraligi, programlamaDiliBenzerligiDusuk, 'r', linewidth=2, label='benzerlik dusuk')
    ax1.plot(crispInputAraligi, programlamaDiliBenzerligiYuksek, 'g', linewidth=2, label='benzerlik yuksek')
    ax1.set_title('Programlama dili  benzerligi')
    ax1.legend()
    ax2.plot(crispInputAraligi, kopyaYok, 'r', linewidth=2, label='kopya yok')
    ax2.plot(crispInputAraligi, kopyaIhtimali, 'g', linewidth=2, label='kopya ihtimali')
    ax2.plot(crispInputAraligi, kopyaVar, 'b', linewidth=2, label='kopya var')
    ax2.set_title('Kopya')
    ax2.legend()
    plt.tight_layout()
    plt.show()



def bulanikMantikSisteminiCalistir(inputKodlarinBO, inputProgramlamaDillerininBO):
    # kodlarin benzerlik oranlari girisine gore bulanik kumelere uyelik derecesini (UD) belirledik.
    # Gonderilen benzerlik oranina gore uyelik derecesini geri donderip (UD_) degiskenlerine atadik
    UD_kodAzBenzer = interp_membership(crispInputAraligi, kodAzBenzer, inputKodlarinBO)
    UD_kodBenzer = interp_membership(crispInputAraligi, kodBenzer, inputKodlarinBO)
    UD_kodCokBenzer = interp_membership(crispInputAraligi, kodCokBenzer, inputKodlarinBO)
    # kodlarin benzerlik oranlari girisine gore bulanik kumelere uyelik derecesini (UD) belirledik.
    # Gonderilen benzerlik oranina gore uyelik derecesini geri donderip (UD_) degiskenlerine atadik
    UD_pDiliBenzerligiDusuk = interp_membership(crispInputAraligi, programlamaDiliBenzerligiDusuk,
                                                inputProgramlamaDillerininBO)
    UD_pDiliBenzerligiBuyuk = interp_membership(crispInputAraligi, programlamaDiliBenzerligiYuksek,
                                                inputProgramlamaDillerininBO)
    # buraya kadar olan islemlerde uyelik degerlerini bulaniklastirdik.

    # kurallari olusturuyoruz
    kural1 = np.fmin(np.fmin(UD_kodAzBenzer, UD_pDiliBenzerligiBuyuk), kopyaYok)
    kural2 = np.fmin(np.fmin(UD_kodAzBenzer, UD_pDiliBenzerligiDusuk), kopyaYok)
    kural3 = np.fmin(np.fmin(UD_kodBenzer, UD_pDiliBenzerligiBuyuk), kopyaIhtimali)
    kural4 = np.fmin(np.fmin(UD_kodBenzer, UD_pDiliBenzerligiDusuk), kopyaIhtimali)
    kural5 = np.fmin(np.fmin(UD_kodCokBenzer, UD_pDiliBenzerligiBuyuk), kopyaVar)

    # ayni ciktiyi veren bulanik kumelerin birlesimi alinir.

    outKopyaYok = np.fmax(kural1,kural2)
    outKopyaVar = kural5
    outKopyaIhtimali = np.fmax(kural4, kural3)
    # tum alanlaribirlestirme islemi
    # cikis kumemizin son hali
    ciktiKopya = np.fmax(outKopyaVar, np.fmax(outKopyaYok, outKopyaIhtimali))
    # durulastirma yapilir
    defuzzified = centroid(crispInputAraligi, ciktiKopya)
  
    # hesaplanan agirlik merkezinin tam olarak hangi uyelik derecesine denk geldigini tutmaktadir.
    sonuc = interp_membership(crispInputAraligi, ciktiKopya, defuzzified)
    return defuzzified


def  kaynakKodlarinKopyaOraniniBul() :
    dosya = open('Sonuclar.txt', 'w')
    for i in range(len(dosyaKarsilastirmaListesi)) : 

        kopyaOrani = m.ceil( bulanikMantikSisteminiCalistir(dosyaKarsilastirmaListesi[i][2],dosyaKarsilastirmaListesi[i][3]))
       
        """
        print("\ndosya1:{} dosya2: {}".format(dosyaKarsilastirmaListesi[i][0],dosyaKarsilastirmaListesi[i][1]))
        print("kaynak kodlarin benzerlik orani: {}".format(dosyaKarsilastirmaListesi[i][2]))
        print("Programlama dillerinin benzerlik orani : {}".format(dosyaKarsilastirmaListesi[i][3]))
        print("Kopya cekme orani :{} \n".format(kopyaOrani) )
        """
        dosya.write("--------------------------------------------------------------------------\n")
        dosya.write("dosya1:{}\n".format(dosyaKarsilastirmaListesi[i][0]))
        dosya.write("dosya2:{}\n".format(dosyaKarsilastirmaListesi[i][1]))
        dosya.write("kaynak kodlarin benzerlik orani: %{}\n".format(dosyaKarsilastirmaListesi[i][2]))
        dosya.write("Programlama dillerinin benzerlik orani : %{}\n".format(dosyaKarsilastirmaListesi[i][3]))
        dosya.write("Kopya cekme orani :%{} \n".format(kopyaOrani) )
    
    dosya.close()



def getProglamaDillerininBenzerlikOrani(dosyaAdi1,dosyaAdi2):
    list1 = dosyaAdi1.split(".")
    uzanti1 = list1[1]
    list2 = dosyaAdi2.split(".")
    uzanti2 = list2[1]
   
    index1 = programlamaDilleriSozluk[str(uzanti1)]
    index2 = programlamaDilleriSozluk[str(uzanti2)]
    return skorListesi[index1][index2]
   


# Burada basliyor

t = time.process_time()



# Programlama dillerinin birbirine olan benzerligini burada tutuyoruz 
dosyaKarsilastirmaListesi = []
"""skorListesi 2 boyutlu bir array olup programlama
 dillerinin birbirleriyle benzerlik orani tutlmustur
 0 --> java 
 1 --> c
 2--> c++
 3---> c#
 4 --> python
      java c c++ c# python
 """
skorListesi = [[100,25,30,35,10],[25,100,30,20,5],[30,30,100,25,5],[35,20,25,100,10],[10,5,5,10,100]]
programlamaDilleriSozluk = { "java":0, "c":1,"cpp":2,"cs":3,"py":4}
klasor = "./file"
onlyfiles = [f for f in listdir(klasor) if isfile(join(klasor, f))]



crispInputAraligi = np.arange(0, 101, 1)  # 0 ile 100 arasinda elemanlara sahip bir matris
# kaynak kodlarin benzerligi icin ucgensel uyelik fonksiyonu elde ediyoruz.
kodAzBenzer = trimf(crispInputAraligi, [0, 0, 50])
kodBenzer = trimf(crispInputAraligi, [25, 50, 75])
kodCokBenzer = trimf(crispInputAraligi, [50, 100, 100])

# programlama dillerinin benzerligi icin ucgensel uyelik fonksiyonu elde ediyoruz.
programlamaDiliBenzerligiDusuk = trimf(crispInputAraligi, [0, 0, 100])
programlamaDiliBenzerligiYuksek = trimf(crispInputAraligi, [0, 100, 100])

# kopya cekme ihtimalleri icin yamuk uyelik fonksiyonlari olusturuyoruz. 
kopyaYok = trapmf(crispInputAraligi, [0, 0, 30,60])
kopyaIhtimali = trapmf(crispInputAraligi, [30, 55, 55,80])
kopyaVar = trapmf(crispInputAraligi, [50, 80,100, 100])


dizindenDosyalariOku()
kaynakKodlarinKopyaOraniniBul()

uyelikFonksiyonulariniCizdir()


elapsed_time = time.process_time() - t

print("Islemin Tamamlanma Suresi:  {}".format(elapsed_time))
