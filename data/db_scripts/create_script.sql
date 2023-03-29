CREATE TABLE public.valid_customers
(
  id serial PRIMARY KEY NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  city varchar(30) NOT NULL,
  state varchar(30) NOT NULL,
  postal_code varchar(10),
  phone_no varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  ip_address varchar(20)
);
CREATE UNIQUE INDEX valid_customers_id_uindex ON public.valid_customers (id);
CREATE UNIQUE INDEX valid_customers_phone_no_uindex ON public.valid_customers (phone_no);
CREATE UNIQUE INDEX valid_customers_email_uindex ON public.valid_customers (email);


CREATE TABLE public.invalid_customers
(
  id serial PRIMARY KEY NOT NULL,
  first_name varchar(50) NOT NULL,
  last_name varchar(50) NOT NULL,
  city varchar(30) NOT NULL,
  state varchar(30) NOT NULL,
  postal_code varchar(10),
  phone_no varchar(20) NOT NULL,
  email varchar(50) NOT NULL,
  ip_address varchar(20)
);
CREATE UNIQUE INDEX invalid_customers_id_uindex ON public.invalid_customers (id);
CREATE UNIQUE INDEX invalid_customers_phone_no_uindex ON public.invalid_customers (phone_no);
CREATE UNIQUE INDEX invalid_customers_email_uindex ON public.invalid_customers (email);