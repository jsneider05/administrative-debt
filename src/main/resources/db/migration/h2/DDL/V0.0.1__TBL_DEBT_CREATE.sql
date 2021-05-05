create table if not exists public.tbl_debt
(
    id_client   varchar(15) not null,
    amount      bigint      not null,
    client_name varchar(60) not null,
    due_date    DATE        not null,
    email       varchar(60) not null,
    id_debt     varchar(60) not null,
    primary key (id_client),
    unique (email),
    unique (id_debt)
)