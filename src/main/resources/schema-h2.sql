--
--  create a table to hold customers
create table public.customer
(
    id         integer primary key,
    first_name character varying,
    last_name  character varying
);

drop sequence public.customer_id_seq;

create sequence public.customer_id_seq
    increment by 100
    minvalue 1
    maxvalue 2147483637
    start 1
    cache 100;