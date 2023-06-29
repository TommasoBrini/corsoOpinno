## **GESTIONE PRENOTAZIONE - WEB SERVICE**

Modificare il progetto realizzato nella precedente esercitazione per implementare un web  service Spring Boot applicando la suddivisione nei diversi strati architetturali.

Realizzare le classi service per disaccoppiare l’accesso ai dati attraverso i repository prevedendo, ove ritenuto opportuno, l’utilizzo di funzionalità avanzate come paginazione e ordinamento.

Introdurre un meccanismo di gestione  globale  delle  eccezioni con particolare riferimento a quelle relative alle prenotazioni.

Realizzare i vari controller a supporto delle operazioni CRUD per le entità del modello dati.

Dopo aver analizzato il testo:

- Aggiungi le dipendenze necessarie al progetto
- Organizza l’applicazione secondo il pattern MVC creando i vari package richiesti
- Crea i vari service che espongono le operazioni CRUD interagendo con i repository associati alle entità del modello dati
- Implementa un sistema di gestione delle eccezioni basato sul ControllerAdvice
- Realizza i controller che costituiscono le API dell’applicazione