 /*
 1] Elenca gli impiegati che seguono uno specifico cliente. **** 
*/

-- SELECT *
-- FROM myFancyCompany.impiegati i
-- INNER JOIN myFancyCompany.ordini o ON i.id = o.x_id_impiegato
-- WHERE o.cliente = 'Cliente 2';


/*
 2] Elenca gli ordini seguiti da uno specifico impiegato.
*/

-- SELECT * 
-- FROM myFancyCompany.ordini 
-- WHERE ordini.x_id_impiegato = '2'


/*
 3] Fai un elenco dei clienti indicando la loro spesa complessiva in ordine decrescente.
*/

-- SELECT cliente, sum(importo) as spesa
-- FROM myFancyCompany.ordini
-- GROUP BY cliente
-- ORDER BY spesa DESC

/*
 4] Fai un elenco dei livelli indicando per ogni livello quanti ordini sono seguiti.
*/

-- SELECT livello, count(ordini.id) as conteggio
-- FROM myFancyCompany.impiegati
-- LEFT OUTER JOIN myFancyCompany.ordini ON impiegati.id = ordini.x_id_impiegato
-- GROUP BY impiegati.livello

/*
-- 5] Fai l'elenco degli ordini di febbraio e degli impiegati che li seguono.
*/
-- SELECT ordini.id, impiegati.nome
-- FROM myFancyCompany.ordini
-- LEFT OUTER JOIN myFancyCompany.impiegati ON ordini.x_id_impiegato = impiegati.id
-- WHERE EXTRACT(MONTH FROM ordini.data_ordine) = 5


/*
-- 6] Elenca gli impiegati e l'importo complessivo degli ordini che hanno gestito.
*/

-- SELECT impiegati.nome, sum(ordini.importo) as somma
-- FROM myFancyCompany.impiegati
-- LEFT OUTER JOIN myFancyCompany.ordini ON ordini.x_id_impiegato = impiegati.id
-- GROUP BY impiegati.id
-- ORDER BY somma


-- 7] Fai un elenco dei livelli indicando per ogni livello la somma degli importi gestiti.

-- SELECT livello, SUM(importo)
-- FROM myFancyCompany.impiegati
-- LEFT JOIN myFancyCompany.ordini ON impiegati.id = ordini.x_id_impiegato
-- GROUP BY livello


-- 8] Elenca gli impiegati e la quantità di ordini che hanno gestito.

-- SELECT impiegati.nome, COUNT(ordini.id) as conteggio
-- FROM myFancyCompany.impiegati
-- LEFT OUTER JOIN myFancyCompany.ordini ON impiegati.id = ordini.x_id_impiegato
-- GROUP BY impiegati.id
-- ORDER BY conteggio DESC

