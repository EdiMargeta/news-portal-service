securityCREATE TABLE public.role (
    id          BIGSERIAL,
    name        VARCHAR (50),
    PRIMARY KEY (id)
);

CREATE TABLE public.users (
    id              BIGSERIAL,
    first_name      VARCHAR (50),
    last_name       VARCHAR (50),
    email           VARCHAR (50),
    password        text,
    active          BOOLEAN,
    role_id         BIGINT,
    PRIMARY KEY (id),
    foreign key (role_id) references public.role (id)
);


CREATE TABLE public.news (
    id                    BIGSERIAL,
    headline              text,
    description           text,
    body                  text,
    cover_image           text,
    date                  DATE,
    category              VARCHAR (50),
    author                VARCHAR (50),
    PRIMARY KEY (id)
);
