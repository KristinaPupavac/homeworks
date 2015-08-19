Part 1 
Zadatak 1 
Napraviti klasu Computer, koja je abstract. Klasa sadrzi ime i MAC adresu racunara. Pored toga,
napraviti i dva konstruktora, kao i dvije get metode. MAC adresa je objekat koju opisuje 
unutrasnja nestaticna klasa MCAddress. Objekat tog tipa treba sadrzavati niz karaktera adrese, 
ali bez ':'. Klasa treba imati toString metodu i konstruktor. Napraviti i equals i toString 
metode za Computer klasu. 

Zadatak 2
Napisati klasu Network, koja je abstract. Network klasa 
sadrzi atribut imena mreze, kao i spisak racunara koji su u toj mrezi (niz racunara). Klasa 
sadrzi konstruktor koji inicijalizira broj racunara niza na 0, kao i metodu addComputer
(Computer c) i removeComputer(Computer c), koje su abstract. 

Zadatak 3 
Napisati Server klasu koja sadrzi broj koji oznacava koliko maksimalno drugih racunara moze podnijeti a da ne dozivi 
krah. Napraviti i jednu get metodu za taj limit. Napisati dodatni konstruktor koji 
inicijalizira ime, MAC adresu i spomenuti limit servera. Napraviti i equals i toString metode.

Zadatak 4 
Napraviti interface Connectable koji sadrzi metode connect(Computer), connect(Network) i 
disconnect(). Client klasa sadrzi atribut tipa Computer koji oznacava sa kojim je racunarom 
dati klijent spojen. Pored toga, ima jos jedan slican atribut koji je tipa Network koji 
oznacava sa kojom je mrezom klijent spojen. Konstruktor klijenta treba imati samo ime i MAC a
dresu. Klasa implementira Connectable interface. Metoda connect treba da postavi link na dati 
racunar, odnosno na datu mrezu. Ukoliko link vec postoji onda baciti exception. Metoda 
disconnect postavlja oba linka na null. Napisati i get metodu za te link metode. Napraviti i 
equals i toString metode. Napomena: Client se nikada ne moze spojiti na drugu mrezu/racunar 
ako mu oba atributa nisu null! 

Zadatak 5 
Napraviti demonstraciju svih klasa i metoda iz prijasnja cetiri zadatka. Napisati javadoc za 
sve metode (nije potrebno za equals i toString metode). 

Part 2 
Zadatak 1
Napraviti interface Functionable koji ima metodu boolean isFunctioning().
 
Zadatak 2 
Napraviti klasu ArrayManipulation koja sadrzi static metodu extendArray(Computer[]) koja 
prosiri dati niz za jedan index/element. Novi element treba biti null. Pored toga, tu se nalazi i metoda 
shrinkArray(Computer[], int) koja smanji dati niz za jedan tako sto "obrise" dati index.
 
Zadatak 3 
Napraviti klasu BusNetwork koja nasljedjuje Network klasu i implementira Functionable interface.
Metoda addComputer radi na principu tako sto prosiri prvo niz racunara za jedan, zatim stavi 
dati racunar na to mjesto i povezuje racunar preko njegove connect metode sa ovom mrezom. 
Metoda removeComputer radi na principu tako sto prvo pronadje dati racunar (ako ga nema baciti 
exception) i obrise ga (smanji niz). Pored toga, racunar prekida svoju vezu sa mrezom preko 
svoje disconnect metode. Metoda isFunctioning treba vratiti true ukoliko ima barem dva racunara 
spojena na mrezi (da nisu null). toString metoda treba imati broj racunara u sebi, kao i dio 
koji govori da li mreza funkcionise ili ne. 

Zadatak 4 
Napraviti klasu StarNetwork koja nasljedjuje Network klasu i implementira Functionable 
interface. Klasa sadrzi jedan Server. Metoda addComputer radi na principu tako sto prosiri 
prvo niz racunara za jedan, zatim stavi racunar na to mjesto. Pored toga, dati racunar se 
povezuje preko connect metode sa serverom preko svoje connect metode. Metoda removeComputer 
radi na principu tako sto prvo pronadje dati racunar (ako ga nema baciti exception) i obrise 
ga (smanji niz). Pored toga, dati racunar prekida link sa serverom preko svoje disconnect 
metode. Metoda isFunctioning treba vratiti true ukoliko server radi. Server pada ukoliko ima 
vise povezanih racunara nego sto moze podnijeti. toString metoda treba imati broj spojenih 
racunara na server u sebi, kao i dio koji govori da li mreza funkcionise ili ne.
 
Zadatak 5 
Napisati javadoc za sve metode osim toString i equals metode. Napisati demonstraciju svih 
metoda!