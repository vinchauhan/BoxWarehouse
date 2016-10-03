-- CREATE TABLE public.boxuser
-- (
--   user_id bigint NOT NULL DEFAULT nextval('boxuser_user_id_seq'::regclass),
--   role character varying(255) NOT NULL,
--   email character varying(255) NOT NULL,
--   firstname character varying(255),
--   lastname character varying(255),
--   password character varying(255) NOT NULL,
--   username character varying(255) NOT NULL,
--   CONSTRAINT boxuser_pkey PRIMARY KEY (user_id),
--   CONSTRAINT uk_1qp2go8g40i52wx9lh6ml0nwn UNIQUE (username),
--   CONSTRAINT uk_r5tlu48nq6l98f695eko84321 UNIQUE (email)
-- )
-- WITH (
-- OIDS=FALSE
-- );
-- ALTER TABLE public.boxuser
--   OWNER TO postgres;


--
-- CREATE TABLE public.box
-- (
--   box_id bigint NOT NULL DEFAULT nextval('box_box_id_seq'::regclass),
--   box_code character varying(255) NOT NULL,
--                                   box_details character varying(255),
--   box_size character varying(255),
--   scanned_format character varying(255),
--   scanned_on timestamp without time zone NOT NULL,
--   user_id bigint,
--           CONSTRAINT box_pkey PRIMARY KEY (box_id),
--   CONSTRAINT fkr74ny7a1b5tgf1a3isx1gxc0o FOREIGN KEY (user_id)
--   REFERENCES public.boxuser (user_id) MATCH SIMPLE
--                                       ON UPDATE NO ACTION ON DELETE NO ACTION
-- )
-- WITH (
--   OIDS=FALSE
-- );
-- ALTER TABLE public.box
--   OWNER TO postgres;