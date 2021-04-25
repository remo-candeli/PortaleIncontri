=============================================  
PLAY01 - Portale Incontri  
=============================================

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
