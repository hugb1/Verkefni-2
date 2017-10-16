--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.2
-- Dumped by pg_dump version 9.6.2

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: banquetbookings; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE banquetbookings (
    id integer NOT NULL,
    name text NOT NULL,
    kennitala bigint NOT NULL,
    email text NOT NULL,
    phonenr integer NOT NULL,
    banquetnumber integer NOT NULL
);


ALTER TABLE banquetbookings OWNER TO gunnarmarhardarson;

--
-- Name: banquetbookings_id_seq; Type: SEQUENCE; Schema: public; Owner: gunnarmarhardarson
--

CREATE SEQUENCE banquetbookings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE banquetbookings_id_seq OWNER TO gunnarmarhardarson;

--
-- Name: banquetbookings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gunnarmarhardarson
--

ALTER SEQUENCE banquetbookings_id_seq OWNED BY banquetbookings.id;


--
-- Name: banquets; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE banquets (
    banquetnumber integer NOT NULL,
    name text NOT NULL,
    location text NOT NULL,
    street text NOT NULL,
    price integer NOT NULL,
    maxppl integer NOT NULL,
    phonenr integer NOT NULL,
    email text NOT NULL,
    key text DEFAULT '12345'::text NOT NULL
);


ALTER TABLE banquets OWNER TO gunnarmarhardarson;

--
-- Name: banquets_banquetnumber_seq; Type: SEQUENCE; Schema: public; Owner: gunnarmarhardarson
--

CREATE SEQUENCE banquets_banquetnumber_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE banquets_banquetnumber_seq OWNER TO gunnarmarhardarson;

--
-- Name: banquets_banquetnumber_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gunnarmarhardarson
--

ALTER SEQUENCE banquets_banquetnumber_seq OWNED BY banquets.banquetnumber;


--
-- Name: sportvenuebookings; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE sportvenuebookings (
    id integer NOT NULL,
    name text NOT NULL,
    kennitala bigint NOT NULL,
    email text NOT NULL,
    phonenr integer NOT NULL,
    sportvenuenumber integer NOT NULL
);


ALTER TABLE sportvenuebookings OWNER TO gunnarmarhardarson;

--
-- Name: sportvenuebookings_id_seq; Type: SEQUENCE; Schema: public; Owner: gunnarmarhardarson
--

CREATE SEQUENCE sportvenuebookings_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sportvenuebookings_id_seq OWNER TO gunnarmarhardarson;

--
-- Name: sportvenuebookings_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gunnarmarhardarson
--

ALTER SEQUENCE sportvenuebookings_id_seq OWNED BY sportvenuebookings.id;


--
-- Name: sportvenues; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE sportvenues (
    sportvenuenumber integer NOT NULL,
    name text NOT NULL,
    location text NOT NULL,
    street text NOT NULL,
    price integer NOT NULL,
    phonenr integer NOT NULL,
    email text NOT NULL,
    key text DEFAULT '12345'::text NOT NULL
);


ALTER TABLE sportvenues OWNER TO gunnarmarhardarson;

--
-- Name: sportvenues_sportvenuenumber_seq; Type: SEQUENCE; Schema: public; Owner: gunnarmarhardarson
--

CREATE SEQUENCE sportvenues_sportvenuenumber_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sportvenues_sportvenuenumber_seq OWNER TO gunnarmarhardarson;

--
-- Name: sportvenues_sportvenuenumber_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gunnarmarhardarson
--

ALTER SEQUENCE sportvenues_sportvenuenumber_seq OWNED BY sportvenues.sportvenuenumber;


--
-- Name: banquetbookings id; Type: DEFAULT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquetbookings ALTER COLUMN id SET DEFAULT nextval('banquetbookings_id_seq'::regclass);


--
-- Name: banquets banquetnumber; Type: DEFAULT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquets ALTER COLUMN banquetnumber SET DEFAULT nextval('banquets_banquetnumber_seq'::regclass);


--
-- Name: sportvenuebookings id; Type: DEFAULT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenuebookings ALTER COLUMN id SET DEFAULT nextval('sportvenuebookings_id_seq'::regclass);


--
-- Name: sportvenues sportvenuenumber; Type: DEFAULT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenues ALTER COLUMN sportvenuenumber SET DEFAULT nextval('sportvenues_sportvenuenumber_seq'::regclass);


--
-- Data for Name: banquetbookings; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY banquetbookings (id, name, kennitala, email, phonenr, banquetnumber) FROM stdin;
1	gh	1234567890	gg	1234567	3
2	mh	1234567890	gh	1234567	8
3	gg	1212121212	rj	1234567	3
4	gg	1234567890	ff	1234567	3
5	gg	1234567890	aa	1234567	4
6	prufa fyrir kt	3112882299	prufa-kt	7889988	1
\.


--
-- Name: banquetbookings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('banquetbookings_id_seq', 6, true);


--
-- Data for Name: banquets; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY banquets (banquetnumber, name, location, street, price, maxppl, phonenr, email, key) FROM stdin;
1	Glersalurinn	Reykjavík	Tjarnargata 5	43636	150	6547654	hans@gmail.com	12345
2	Tjörnin	Kópavogur	Guðrúnartún 2	74995	100	8765654	gretar@gmail.com	12345
3	Harpa	Reykjavík	Austurbakki 2	84830	400	5935464	harpa@harpa.is	12345
7	Sólon	Reykjavík	Bankastræti 7a	45654	150	5623232	solon@solon.is	12345
8	Hótel Cabin	Reykjavík	Borgartún 32	78995	100	5116030	cabin@cabin.is	12345
9	Garðskálinn, Gerðarsafn	Kópavogur	Hamraborg 4	39995	50	4417611	gardur@gardur.is	12345
4	Hótel Vellir	Hafnarfjörður	Tjarnarvöllum 3	50000	200	5264321	hotelvellir@vellir.is	12345
5	Fjörukráin	Hafnarfjörður	Víkingastræti 1-3	34995	100	5651213	fjorukrain@fjara.is	12345
6	Salur Hraunbúa	Hafnarfjörður	Hjallabraut 51	67845	110	5650900	hraun@hraun.is	12345
11	test1	Garðabær	test1	454545	80	5454556	test1@test1.is	abcd
\.


--
-- Name: banquets_banquetnumber_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('banquets_banquetnumber_seq', 11, true);


--
-- Data for Name: sportvenuebookings; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY sportvenuebookings (id, name, kennitala, email, phonenr, sportvenuenumber) FROM stdin;
1	GMH	1234567890	gh	1234567	5
2	ss	3112882299	rr	7876655	4
\.


--
-- Name: sportvenuebookings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('sportvenuebookings_id_seq', 2, true);


--
-- Data for Name: sportvenues; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY sportvenues (sportvenuenumber, name, location, street, price, phonenr, email, key) FROM stdin;
1	Kórinn	Kópavogur	Vallakór 12-14	99324	5647383	korinn@kor.is	12345
2	Fífan	Kópavogur	Dalsmári 5	67894	5642346	fifan@fifan.is	12345
3	Stjarnan	Garðabær	Ásgarður	139995	5651940	stjarnan@stjarnan.is	12345
4	Knattspyrnufélag Reykjavíkur	Reykjavík	Frostaskjól	99995	5105300	kr@kr.is	12345
5	Íþróttafélagið Fylkir	Reykjavík	Fylkisvegi 6	67567	5715600	fylkir@fylkir.com	12345
6	Knattspyrnufélagið Valur	Reykjavík	Hlíðarenda	79995	4148000	valur@valur.is	12345
7	Fimleikafélag Hafnafjarðar	Hafnarfjörður	Kaplakriki	54995	5504050	fh@fh.is	12345
8	Knattspyrnufélagið Haukar	Hafnarfjörður	Ásvöllum 1	45499	5258700	haukar@haukar.is	12345
\.


--
-- Name: sportvenues_sportvenuenumber_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('sportvenues_sportvenuenumber_seq', 8, true);


--
-- Name: banquetbookings banquetbookings_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquetbookings
    ADD CONSTRAINT banquetbookings_pkey PRIMARY KEY (id);


--
-- Name: banquets banquets_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquets
    ADD CONSTRAINT banquets_pkey PRIMARY KEY (banquetnumber);


--
-- Name: sportvenuebookings sportvenuebookings_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenuebookings
    ADD CONSTRAINT sportvenuebookings_pkey PRIMARY KEY (id);


--
-- Name: sportvenues sportvenues_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenues
    ADD CONSTRAINT sportvenues_pkey PRIMARY KEY (sportvenuenumber);


--
-- PostgreSQL database dump complete
--

