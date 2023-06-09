PGDMP         +                {           teatro    15.3    15.3 Q    K           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            L           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            M           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            N           1262    16404    teatro    DATABASE     y   CREATE DATABASE teatro WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Italian_Italy.1252';
    DROP DATABASE teatro;
                postgres    false                        2615    16405    teatro    SCHEMA        CREATE SCHEMA teatro;
    DROP SCHEMA teatro;
                postgres    false            �            1259    16475    posto    TABLE     }   CREATE TABLE teatro.posto (
    id integer NOT NULL,
    fila smallint,
    numero smallint,
    id_sala integer NOT NULL
);
    DROP TABLE teatro.posto;
       teatro         heap    postgres    false    6            �            1259    16483    posto_id_sala_seq    SEQUENCE     �   CREATE SEQUENCE teatro.posto_id_sala_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE teatro.posto_id_sala_seq;
       teatro          postgres    false    6    226            O           0    0    posto_id_sala_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE teatro.posto_id_sala_seq OWNED BY teatro.posto.id_sala;
          teatro          postgres    false    227            �            1259    16474    posto_id_seq    SEQUENCE     �   CREATE SEQUENCE teatro.posto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 #   DROP SEQUENCE teatro.posto_id_seq;
       teatro          postgres    false    6    226            P           0    0    posto_id_seq    SEQUENCE OWNED BY     =   ALTER SEQUENCE teatro.posto_id_seq OWNED BY teatro.posto.id;
          teatro          postgres    false    225            �            1259    16426    sala    TABLE     }   CREATE TABLE teatro.sala (
    id integer NOT NULL,
    nome character varying(30) NOT NULL,
    id_sede integer NOT NULL
);
    DROP TABLE teatro.sala;
       teatro         heap    postgres    false    6            �            1259    16425    sala_id_sede_seq    SEQUENCE     �   CREATE SEQUENCE teatro.sala_id_sede_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE teatro.sala_id_sede_seq;
       teatro          postgres    false    221    6            Q           0    0    sala_id_sede_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE teatro.sala_id_sede_seq OWNED BY teatro.sala.id_sede;
          teatro          postgres    false    220            �            1259    16424    sala_id_seq    SEQUENCE     �   CREATE SEQUENCE teatro.sala_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE teatro.sala_id_seq;
       teatro          postgres    false    6    221            R           0    0    sala_id_seq    SEQUENCE OWNED BY     ;   ALTER SEQUENCE teatro.sala_id_seq OWNED BY teatro.sala.id;
          teatro          postgres    false    219            �            1259    16418    sede    TABLE     �   CREATE TABLE teatro.sede (
    "ID" integer NOT NULL,
    nome character varying(30) NOT NULL,
    indirizzo character varying(30) NOT NULL,
    comune character varying(30) NOT NULL,
    isopen boolean NOT NULL
);
    DROP TABLE teatro.sede;
       teatro         heap    postgres    false    6            �            1259    16417    sede_ID_seq    SEQUENCE     �   CREATE SEQUENCE teatro."sede_ID_seq"
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE teatro."sede_ID_seq";
       teatro          postgres    false    6    218            S           0    0    sede_ID_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE teatro."sede_ID_seq" OWNED BY teatro.sede."ID";
          teatro          postgres    false    217            �            1259    16458 
   spettacolo    TABLE       CREATE TABLE teatro.spettacolo (
    id integer NOT NULL,
    nome character varying(30) NOT NULL,
    orario time without time zone NOT NULL,
    durata integer,
    genere character varying(20),
    prezzo double precision NOT NULL,
    id_sala integer NOT NULL
);
    DROP TABLE teatro.spettacolo;
       teatro         heap    postgres    false    6            �            1259    16457    spettacolo_id_sala_seq    SEQUENCE     �   CREATE SEQUENCE teatro.spettacolo_id_sala_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE teatro.spettacolo_id_sala_seq;
       teatro          postgres    false    6    224            T           0    0    spettacolo_id_sala_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE teatro.spettacolo_id_sala_seq OWNED BY teatro.spettacolo.id_sala;
          teatro          postgres    false    223            �            1259    16456    spettacolo_id_seq    SEQUENCE     �   CREATE SEQUENCE teatro.spettacolo_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE teatro.spettacolo_id_seq;
       teatro          postgres    false    224    6            U           0    0    spettacolo_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE teatro.spettacolo_id_seq OWNED BY teatro.spettacolo.id;
          teatro          postgres    false    222            �            1259    16498    ticket    TABLE     �   CREATE TABLE teatro.ticket (
    id integer NOT NULL,
    "timestamp" timestamp without time zone NOT NULL,
    id_utente integer NOT NULL,
    id_posto integer NOT NULL,
    id_spettacolo integer NOT NULL
);
    DROP TABLE teatro.ticket;
       teatro         heap    postgres    false    6            �            1259    16496    ticket_id_posto_seq    SEQUENCE     �   CREATE SEQUENCE teatro.ticket_id_posto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE teatro.ticket_id_posto_seq;
       teatro          postgres    false    6    232            V           0    0    ticket_id_posto_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE teatro.ticket_id_posto_seq OWNED BY teatro.ticket.id_posto;
          teatro          postgres    false    230            �            1259    16494    ticket_id_seq    SEQUENCE     �   CREATE SEQUENCE teatro.ticket_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE teatro.ticket_id_seq;
       teatro          postgres    false    232    6            W           0    0    ticket_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE teatro.ticket_id_seq OWNED BY teatro.ticket.id;
          teatro          postgres    false    228            �            1259    16497    ticket_id_spettacolo_seq    SEQUENCE     �   CREATE SEQUENCE teatro.ticket_id_spettacolo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE teatro.ticket_id_spettacolo_seq;
       teatro          postgres    false    232    6            X           0    0    ticket_id_spettacolo_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE teatro.ticket_id_spettacolo_seq OWNED BY teatro.ticket.id_spettacolo;
          teatro          postgres    false    231            �            1259    16495    ticket_id_utente_seq    SEQUENCE     �   CREATE SEQUENCE teatro.ticket_id_utente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE teatro.ticket_id_utente_seq;
       teatro          postgres    false    6    232            Y           0    0    ticket_id_utente_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE teatro.ticket_id_utente_seq OWNED BY teatro.ticket.id_utente;
          teatro          postgres    false    229            �            1259    16407    utente    TABLE       CREATE TABLE teatro.utente (
    id integer NOT NULL,
    nome character varying(30) NOT NULL,
    cognome character varying(30) NOT NULL,
    mail character varying(30) NOT NULL,
    telefono character varying(20),
    indirizzo character varying(50) NOT NULL
);
    DROP TABLE teatro.utente;
       teatro         heap    postgres    false    6            �            1259    16406    utente_id_seq    SEQUENCE     �   CREATE SEQUENCE teatro.utente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE teatro.utente_id_seq;
       teatro          postgres    false    6    216            Z           0    0    utente_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE teatro.utente_id_seq OWNED BY teatro.utente.id;
          teatro          postgres    false    215            �           2604    16478    posto id    DEFAULT     d   ALTER TABLE ONLY teatro.posto ALTER COLUMN id SET DEFAULT nextval('teatro.posto_id_seq'::regclass);
 7   ALTER TABLE teatro.posto ALTER COLUMN id DROP DEFAULT;
       teatro          postgres    false    225    226    226            �           2604    16484    posto id_sala    DEFAULT     n   ALTER TABLE ONLY teatro.posto ALTER COLUMN id_sala SET DEFAULT nextval('teatro.posto_id_sala_seq'::regclass);
 <   ALTER TABLE teatro.posto ALTER COLUMN id_sala DROP DEFAULT;
       teatro          postgres    false    227    226            �           2604    16429    sala id    DEFAULT     b   ALTER TABLE ONLY teatro.sala ALTER COLUMN id SET DEFAULT nextval('teatro.sala_id_seq'::regclass);
 6   ALTER TABLE teatro.sala ALTER COLUMN id DROP DEFAULT;
       teatro          postgres    false    219    221    221            �           2604    16430    sala id_sede    DEFAULT     l   ALTER TABLE ONLY teatro.sala ALTER COLUMN id_sede SET DEFAULT nextval('teatro.sala_id_sede_seq'::regclass);
 ;   ALTER TABLE teatro.sala ALTER COLUMN id_sede DROP DEFAULT;
       teatro          postgres    false    220    221    221            �           2604    16421    sede ID    DEFAULT     f   ALTER TABLE ONLY teatro.sede ALTER COLUMN "ID" SET DEFAULT nextval('teatro."sede_ID_seq"'::regclass);
 8   ALTER TABLE teatro.sede ALTER COLUMN "ID" DROP DEFAULT;
       teatro          postgres    false    218    217    218            �           2604    16461    spettacolo id    DEFAULT     n   ALTER TABLE ONLY teatro.spettacolo ALTER COLUMN id SET DEFAULT nextval('teatro.spettacolo_id_seq'::regclass);
 <   ALTER TABLE teatro.spettacolo ALTER COLUMN id DROP DEFAULT;
       teatro          postgres    false    224    222    224            �           2604    16462    spettacolo id_sala    DEFAULT     x   ALTER TABLE ONLY teatro.spettacolo ALTER COLUMN id_sala SET DEFAULT nextval('teatro.spettacolo_id_sala_seq'::regclass);
 A   ALTER TABLE teatro.spettacolo ALTER COLUMN id_sala DROP DEFAULT;
       teatro          postgres    false    223    224    224            �           2604    16501 	   ticket id    DEFAULT     f   ALTER TABLE ONLY teatro.ticket ALTER COLUMN id SET DEFAULT nextval('teatro.ticket_id_seq'::regclass);
 8   ALTER TABLE teatro.ticket ALTER COLUMN id DROP DEFAULT;
       teatro          postgres    false    232    228    232            �           2604    16502    ticket id_utente    DEFAULT     t   ALTER TABLE ONLY teatro.ticket ALTER COLUMN id_utente SET DEFAULT nextval('teatro.ticket_id_utente_seq'::regclass);
 ?   ALTER TABLE teatro.ticket ALTER COLUMN id_utente DROP DEFAULT;
       teatro          postgres    false    232    229    232            �           2604    16503    ticket id_posto    DEFAULT     r   ALTER TABLE ONLY teatro.ticket ALTER COLUMN id_posto SET DEFAULT nextval('teatro.ticket_id_posto_seq'::regclass);
 >   ALTER TABLE teatro.ticket ALTER COLUMN id_posto DROP DEFAULT;
       teatro          postgres    false    232    230    232            �           2604    16504    ticket id_spettacolo    DEFAULT     |   ALTER TABLE ONLY teatro.ticket ALTER COLUMN id_spettacolo SET DEFAULT nextval('teatro.ticket_id_spettacolo_seq'::regclass);
 C   ALTER TABLE teatro.ticket ALTER COLUMN id_spettacolo DROP DEFAULT;
       teatro          postgres    false    232    231    232            �           2604    16410 	   utente id    DEFAULT     f   ALTER TABLE ONLY teatro.utente ALTER COLUMN id SET DEFAULT nextval('teatro.utente_id_seq'::regclass);
 8   ALTER TABLE teatro.utente ALTER COLUMN id DROP DEFAULT;
       teatro          postgres    false    216    215    216            B          0    16475    posto 
   TABLE DATA           :   COPY teatro.posto (id, fila, numero, id_sala) FROM stdin;
    teatro          postgres    false    226   �X       =          0    16426    sala 
   TABLE DATA           1   COPY teatro.sala (id, nome, id_sede) FROM stdin;
    teatro          postgres    false    221   �X       :          0    16418    sede 
   TABLE DATA           E   COPY teatro.sede ("ID", nome, indirizzo, comune, isopen) FROM stdin;
    teatro          postgres    false    218   �X       @          0    16458 
   spettacolo 
   TABLE DATA           W   COPY teatro.spettacolo (id, nome, orario, durata, genere, prezzo, id_sala) FROM stdin;
    teatro          postgres    false    224   �X       H          0    16498    ticket 
   TABLE DATA           U   COPY teatro.ticket (id, "timestamp", id_utente, id_posto, id_spettacolo) FROM stdin;
    teatro          postgres    false    232   Y       8          0    16407    utente 
   TABLE DATA           N   COPY teatro.utente (id, nome, cognome, mail, telefono, indirizzo) FROM stdin;
    teatro          postgres    false    216   /Y       [           0    0    posto_id_sala_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('teatro.posto_id_sala_seq', 1, false);
          teatro          postgres    false    227            \           0    0    posto_id_seq    SEQUENCE SET     ;   SELECT pg_catalog.setval('teatro.posto_id_seq', 1, false);
          teatro          postgres    false    225            ]           0    0    sala_id_sede_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('teatro.sala_id_sede_seq', 1, false);
          teatro          postgres    false    220            ^           0    0    sala_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('teatro.sala_id_seq', 1, false);
          teatro          postgres    false    219            _           0    0    sede_ID_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('teatro."sede_ID_seq"', 1, false);
          teatro          postgres    false    217            `           0    0    spettacolo_id_sala_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('teatro.spettacolo_id_sala_seq', 1, false);
          teatro          postgres    false    223            a           0    0    spettacolo_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('teatro.spettacolo_id_seq', 1, false);
          teatro          postgres    false    222            b           0    0    ticket_id_posto_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('teatro.ticket_id_posto_seq', 1, false);
          teatro          postgres    false    230            c           0    0    ticket_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('teatro.ticket_id_seq', 1, false);
          teatro          postgres    false    228            d           0    0    ticket_id_spettacolo_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('teatro.ticket_id_spettacolo_seq', 1, false);
          teatro          postgres    false    231            e           0    0    ticket_id_utente_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('teatro.ticket_id_utente_seq', 1, false);
          teatro          postgres    false    229            f           0    0    utente_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('teatro.utente_id_seq', 1, false);
          teatro          postgres    false    215            �           2606    16482    spettacolo check_durata    CHECK CONSTRAINT     _   ALTER TABLE teatro.spettacolo
    ADD CONSTRAINT check_durata CHECK ((durata >= 0)) NOT VALID;
 <   ALTER TABLE teatro.spettacolo DROP CONSTRAINT check_durata;
       teatro          postgres    false    224    224            �           2606    16481    spettacolo check_prezzo    CHECK CONSTRAINT     s   ALTER TABLE teatro.spettacolo
    ADD CONSTRAINT check_prezzo CHECK ((prezzo >= (0)::double precision)) NOT VALID;
 <   ALTER TABLE teatro.spettacolo DROP CONSTRAINT check_prezzo;
       teatro          postgres    false    224    224            �           2606    16468    spettacolo pk_spettacolo 
   CONSTRAINT     V   ALTER TABLE ONLY teatro.spettacolo
    ADD CONSTRAINT pk_spettacolo PRIMARY KEY (id);
 B   ALTER TABLE ONLY teatro.spettacolo DROP CONSTRAINT pk_spettacolo;
       teatro            postgres    false    224            �           2606    16506    ticket pk_ticket 
   CONSTRAINT     N   ALTER TABLE ONLY teatro.ticket
    ADD CONSTRAINT pk_ticket PRIMARY KEY (id);
 :   ALTER TABLE ONLY teatro.ticket DROP CONSTRAINT pk_ticket;
       teatro            postgres    false    232            �           2606    16480    posto posto_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY teatro.posto
    ADD CONSTRAINT posto_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY teatro.posto DROP CONSTRAINT posto_pkey;
       teatro            postgres    false    226            �           2606    16466    sala sala_pk 
   CONSTRAINT     J   ALTER TABLE ONLY teatro.sala
    ADD CONSTRAINT sala_pk PRIMARY KEY (id);
 6   ALTER TABLE ONLY teatro.sala DROP CONSTRAINT sala_pk;
       teatro            postgres    false    221            �           2606    16423    sede sede_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY teatro.sede
    ADD CONSTRAINT sede_pkey PRIMARY KEY ("ID");
 8   ALTER TABLE ONLY teatro.sede DROP CONSTRAINT sede_pkey;
       teatro            postgres    false    218            �           2606    16414    utente unique_mail 
   CONSTRAINT     M   ALTER TABLE ONLY teatro.utente
    ADD CONSTRAINT unique_mail UNIQUE (mail);
 <   ALTER TABLE ONLY teatro.utente DROP CONSTRAINT unique_mail;
       teatro            postgres    false    216            �           2606    16416    utente unique_tel 
   CONSTRAINT     P   ALTER TABLE ONLY teatro.utente
    ADD CONSTRAINT unique_tel UNIQUE (telefono);
 ;   ALTER TABLE ONLY teatro.utente DROP CONSTRAINT unique_tel;
       teatro            postgres    false    216            �           2606    16412    utente utente_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY teatro.utente
    ADD CONSTRAINT utente_pkey PRIMARY KEY (id);
 <   ALTER TABLE ONLY teatro.utente DROP CONSTRAINT utente_pkey;
       teatro            postgres    false    216            �           2606    16433    sala fk_id_sede    FK CONSTRAINT     o   ALTER TABLE ONLY teatro.sala
    ADD CONSTRAINT fk_id_sede FOREIGN KEY (id_sede) REFERENCES teatro.sede("ID");
 9   ALTER TABLE ONLY teatro.sala DROP CONSTRAINT fk_id_sede;
       teatro          postgres    false    221    3226    218            �           2606    16489    posto fk_posto_sala    FK CONSTRAINT     {   ALTER TABLE ONLY teatro.posto
    ADD CONSTRAINT fk_posto_sala FOREIGN KEY (id_sala) REFERENCES teatro.sala(id) NOT VALID;
 =   ALTER TABLE ONLY teatro.posto DROP CONSTRAINT fk_posto_sala;
       teatro          postgres    false    221    226    3228            �           2606    16469    spettacolo fk_spettacolo_sala    FK CONSTRAINT     �   ALTER TABLE ONLY teatro.spettacolo
    ADD CONSTRAINT fk_spettacolo_sala FOREIGN KEY (id_sala) REFERENCES teatro.sala(id) NOT VALID;
 G   ALTER TABLE ONLY teatro.spettacolo DROP CONSTRAINT fk_spettacolo_sala;
       teatro          postgres    false    3228    221    224            �           2606    16512    ticket fk_ticket_posto    FK CONSTRAINT     v   ALTER TABLE ONLY teatro.ticket
    ADD CONSTRAINT fk_ticket_posto FOREIGN KEY (id_posto) REFERENCES teatro.posto(id);
 @   ALTER TABLE ONLY teatro.ticket DROP CONSTRAINT fk_ticket_posto;
       teatro          postgres    false    232    3232    226            �           2606    16517    ticket fk_ticket_spettacolo    FK CONSTRAINT     �   ALTER TABLE ONLY teatro.ticket
    ADD CONSTRAINT fk_ticket_spettacolo FOREIGN KEY (id_spettacolo) REFERENCES teatro.spettacolo(id);
 E   ALTER TABLE ONLY teatro.ticket DROP CONSTRAINT fk_ticket_spettacolo;
       teatro          postgres    false    232    3230    224            �           2606    16507    ticket fk_ticket_utente    FK CONSTRAINT     y   ALTER TABLE ONLY teatro.ticket
    ADD CONSTRAINT fk_ticket_utente FOREIGN KEY (id_utente) REFERENCES teatro.utente(id);
 A   ALTER TABLE ONLY teatro.ticket DROP CONSTRAINT fk_ticket_utente;
       teatro          postgres    false    3224    216    232            B      x������ � �      =      x������ � �      :      x������ � �      @      x������ � �      H      x������ � �      8      x������ � �     