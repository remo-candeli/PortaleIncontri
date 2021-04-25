  
**Portale Incontri**

Realizzare una applicazione che consenta la registrazione di più persone ad un portale per incontri.
Ipoteticamente questi dati saranno registrati sul DB, ma per ora non ci interessa. Dovranno dunque essere usate le collections.
Determinare quindi le caratteristiche principali di ciascun iscritto al sito (nome, cognome, etá, genere, colore degli occhi, ....stabilite voi quali altri valori).
A queste caratterisite proprie dell´individuo andranno associate quelle relative alle sue preferenze rispetto a chi spera di incontrare.


In linea di massima si potrebbe immaginare di stabilire una percentuale generale (o fattore, o una soglia) oltre la quale il matching é positvo.
In tal caso il sistema dovrebbe esprimere questa affinitá legando uno o piú soggetti all´individuo sul quale, di volta in volta, il sistema sta
effettuando la ricerca dell´anima gemella.


Nota 1: la preferenza relativa ad una certa caratteristica, in questi contesti, é spesso espresso tramite dei range. Esempio:
"vorrei conoscere una persona tra i 30 e i 40 anni"
In java nativamente non esistono oggenti di tipo range. Forse si potrebbero utilizzare gli ArrayList per emularli.

* Implementare anche i test unitari.



**Implementazione**

Il portale incontri prevede che un Utente del sistema sia anche una Persona.  
La persona deve possedere delle Caratteristiche proprie (Colore degli occhi, Altezza, Etá, ecc..).  

La registrazione di un Utente prevede la necessitá di indicare anche le sue Preferenze.  
Le Preferenze sono un elenco di attributi che l'Utente desidera riscontrare nella sua ideale
anima gemella.  

Le Preferenze sono esprimibili in varie forme (intervalli o elenchi).  
Gli intervalli (Es.: etá dai 45 ai 50 anni) si esprimono indicando tipicamente un valore minimo
ed un massimo.  
Gli elenchi (Es.: Hobbies TENNIS, CALCIO, CINEMA, PASSEGGIATE, ecc..) si esprimono con 
elenchi che sono stati gestiti attraverso Enumeratori di Java.  

Il sistema esegue la ricerca dell'anima gemella in base ad un soggetto richiedente (Utente registrato).  
La ricerca viene effettuata mettendo a confronto le Preferenze del richiedente con le Caratteristiche di ogni
iscritto al portale.  
Ogni Preferenza incapsula la competenza relativa alle modalitá in cui confrontare se stessa con la caratterisitca
associata direttamente ad essa. Esempio:  
La Preferenza PreferenzaEta valuta la CaratteristicaEta per verificare se questa rientra nei parametri definiti dal 
richiedente. In tal caso asssegna un punteggio predefinito nella Preferenza.


