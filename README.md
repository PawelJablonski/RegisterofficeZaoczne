RegisterofficeZaoczne
=====================
Moja aplikacja obsluguje prosta sprzedaz w sklepie ze sprzetem komputerowym. Kazdy typ asortymentu dziedziczy
po nadrzednej dla niego abstrakcyjnej klasie Assortment, nadpisujac czesc jej metod. Encja klientow jest w powiazaniu
z encja asortymentow w relacji jeden do wielu. Kwestie zwiazane z obsluga hsql zostawilem Hibernate'owi, ktory
obsluguje dziedziczenie w strategii ONE TABLE STRATEGY. Baza jest wypelniana testowymi wartosciami w celu
demonstracji dzialania. 
Diagram klas znajduje sie pod linkiem: https://www.dropbox.com/s/rfypc51bwkzt23n/klasy.png
Wersja edytowalna: https://www.dropbox.com/s/gc9xddgd6gjiukv/diagram%20klas%20mpr.dia
