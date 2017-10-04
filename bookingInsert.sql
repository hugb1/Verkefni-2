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
    kennitala character(10) NOT NULL,
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
    email text NOT NULL
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
    kennitala character(10) NOT NULL,
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
    email text NOT NULL
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
\.


--
-- Name: banquetbookings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('banquetbookings_id_seq', 1, false);


--
-- Data for Name: banquets; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY banquets (banquetnumber, name, location, street, price, maxppl, phonenr, email) FROM stdin;
1	Glersalurinn	Reykjavík	Tjarnargata 5	43636	150	6547654	hans@gmail.com
2	Tjörnin	Kópavogur	Guðrúnartún 2	74995	100	8765654	gretar@gmail.com
\.


--
-- Name: banquets_banquetnumber_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('banquets_banquetnumber_seq', 2, true);


--
-- Data for Name: sportvenuebookings; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY sportvenuebookings (id, name, kennitala, email, phonenr, sportvenuenumber) FROM stdin;
\.


--
-- Name: sportvenuebookings_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('sportvenuebookings_id_seq', 1, false);


--
-- Data for Name: sportvenues; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY sportvenues (sportvenuenumber, name, location, street, price, phonenr, email) FROM stdin;
1	Kórinn	Kópavogur	Vallakór 12-14	99324	5647383	korinn@kor.is
2	Fífan	Kópavogur	Dalsmári 5	67894	5642346	fifan@fifan.is
\.


--
-- Name: sportvenues_sportvenuenumber_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('sportvenues_sportvenuenumber_seq', 2, true);


--
-- Name: banquetbookings banquetbookings_email_key; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquetbookings
    ADD CONSTRAINT banquetbookings_email_key UNIQUE (email);


--
-- Name: banquetbookings banquetbookings_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquetbookings
    ADD CONSTRAINT banquetbookings_pkey PRIMARY KEY (id);


--
-- Name: banquets banquets_email_key; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquets
    ADD CONSTRAINT banquets_email_key UNIQUE (email);


--
-- Name: banquets banquets_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquets
    ADD CONSTRAINT banquets_pkey PRIMARY KEY (banquetnumber);


--
-- Name: sportvenuebookings sportvenuebookings_email_key; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenuebookings
    ADD CONSTRAINT sportvenuebookings_email_key UNIQUE (email);


--
-- Name: sportvenuebookings sportvenuebookings_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenuebookings
    ADD CONSTRAINT sportvenuebookings_pkey PRIMARY KEY (id);


--
-- Name: sportvenues sportvenues_email_key; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenues
    ADD CONSTRAINT sportvenues_email_key UNIQUE (email);


--
-- Name: sportvenues sportvenues_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenues
    ADD CONSTRAINT sportvenues_pkey PRIMARY KEY (sportvenuenumber);


--
-- PostgreSQL database dump complete
--

