-- *********************************************
-- * Standard SQL generation                   
-- *--------------------------------------------
-- * DB-MAIN version: 11.0.1              
-- * Generator date: Dec  4 2018              
-- * Generation date: Wed Jun 21 15:48:59 2023 
-- * LUN file: C:\Users\tbrin\Desktop\corso Opinno\Laboratorio\corsoOpinno\SharedMobility\SharedMobility.lun 
-- * Schema: DIAGRAMMA_1/SQL 
-- ********************************************* 


-- Database Section
-- ________________ 

create database DIAGRAMMA_1;


-- DBSpace Section
-- _______________


-- Tables Section
-- _____________ 

create table CASCO (
     ID -- Compound attribute -- not null,
     Tipo char(1) not null,
     Pos_ID char(1) not null,
     constraint ID_CASCO_ID primary key (ID -- Compound attribute --));

create table PATENTE (
     ID numeric(1) not null,
     Abilitazioni varchar(10) not null,
     constraint ID_PATENTE_ID primary key (ID));

create table UTENTE (
     Nome varchar(20) not null,
     Cognome varchar(20) not null,
     Date date not null,
     CF varchar(11) not null,
     ID char(1) not null,
     Pos_ID numeric(1) not null,
     Credito float(1) not null,
     constraint ID_UTENTE_ID primary key (ID),
     constraint FKpossiede__ID unique (Pos_ID));

create table VEICOLO (
     Tipo -- Compound attribute -- not null,
     ID char(1) not null,
     Targa char(1),
     Casco char(1),
     Posizione char(1) not null,
     Aff_ID char(1) not null,
     constraint ID_VEICOLO_ID primary key (ID));


-- Constraints Section
-- ___________________ 

alter table CASCO add constraint FKpossiede_FK
     foreign key (Pos_ID)
     references UTENTE;

alter table PATENTE add constraint ID_PATENTE_CHK
     check(exists(select * from UTENTE
                  where UTENTE.Pos_ID = ID)); 

alter table UTENTE add constraint FKpossiede__FK
     foreign key (Pos_ID)
     references PATENTE;

alter table VEICOLO add constraint FKaffitta_FK
     foreign key (Aff_ID)
     references UTENTE;


-- Index Section
-- _____________ 

create unique index ID_CASCO_IND
     on CASCO (ID -- Compound attribute --);

create index FKpossiede_IND
     on CASCO (Pos_ID);

create unique index ID_PATENTE_IND
     on PATENTE (ID);

create unique index ID_UTENTE_IND
     on UTENTE (ID);

create unique index FKpossiede__IND
     on UTENTE (Pos_ID);

create unique index ID_VEICOLO_IND
     on VEICOLO (ID);

create index FKaffitta_IND
     on VEICOLO (Aff_ID);

