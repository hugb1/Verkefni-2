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
-- Name: banquets; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE banquets (
    id integer NOT NULL,
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
-- Name: banquets_id_seq; Type: SEQUENCE; Schema: public; Owner: gunnarmarhardarson
--

CREATE SEQUENCE banquets_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE banquets_id_seq OWNER TO gunnarmarhardarson;

--
-- Name: banquets_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gunnarmarhardarson
--

ALTER SEQUENCE banquets_id_seq OWNED BY banquets.id;


--
-- Name: sportvenues; Type: TABLE; Schema: public; Owner: gunnarmarhardarson
--

CREATE TABLE sportvenues (
    id integer NOT NULL,
    name text NOT NULL,
    location text NOT NULL,
    street text NOT NULL,
    price integer,
    phonenr integer NOT NULL,
    email text NOT NULL
);


ALTER TABLE sportvenues OWNER TO gunnarmarhardarson;

--
-- Name: sportvenues_id_seq; Type: SEQUENCE; Schema: public; Owner: gunnarmarhardarson
--

CREATE SEQUENCE sportvenues_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE sportvenues_id_seq OWNER TO gunnarmarhardarson;

--
-- Name: sportvenues_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: gunnarmarhardarson
--

ALTER SEQUENCE sportvenues_id_seq OWNED BY sportvenues.id;


--
-- Name: banquets id; Type: DEFAULT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquets ALTER COLUMN id SET DEFAULT nextval('banquets_id_seq'::regclass);


--
-- Name: sportvenues id; Type: DEFAULT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenues ALTER COLUMN id SET DEFAULT nextval('sportvenues_id_seq'::regclass);


--
-- Data for Name: banquets; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY banquets (id, name, location, street, price, maxppl, phonenr, email) FROM stdin;
1	Glersalurinn	Reykjavík	Tjarnargata 5	43636	150	6547654	hans@gmail.com
2	Tjörnin	Kópavogur	Guðrúnargata 2	74995	100	8765654	gretarh@gmail.com
\.


--
-- Name: banquets_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('banquets_id_seq', 2, true);


--
-- Data for Name: sportvenues; Type: TABLE DATA; Schema: public; Owner: gunnarmarhardarson
--

COPY sportvenues (id, name, location, street, price, phonenr, email) FROM stdin;
1	Kórinn	Kópavogur	Vallakór 12-14	\N	5647383	korinn@kor.is
2	Fífan	Kópavogur	Dalsmári 5	\N	5642346	fifan@fifan.is
\.


--
-- Name: sportvenues_id_seq; Type: SEQUENCE SET; Schema: public; Owner: gunnarmarhardarson
--

SELECT pg_catalog.setval('sportvenues_id_seq', 2, true);


--
-- Name: banquets banquets_email_key; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquets
    ADD CONSTRAINT banquets_email_key UNIQUE (email);


--
-- Name: banquets banquets_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY banquets
    ADD CONSTRAINT banquets_pkey PRIMARY KEY (id);


--
-- Name: sportvenues sportvenues_email_key; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenues
    ADD CONSTRAINT sportvenues_email_key UNIQUE (email);


--
-- Name: sportvenues sportvenues_pkey; Type: CONSTRAINT; Schema: public; Owner: gunnarmarhardarson
--

ALTER TABLE ONLY sportvenues
    ADD CONSTRAINT sportvenues_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

