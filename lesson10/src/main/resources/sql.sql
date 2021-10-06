CREATE TABLE users
(
    username varchar(50)  NOT NULL,
    password varchar(100) NOT NULL,
    enabled  tinyint(1)   NOT NULL,

    PRIMARY KEY (username)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

INSERT INTO users
VALUES ('admin', 'adm_pass', 1),
       ('manager', 'manager_pass', 1),
       ('all', 'all_pass', 1);

CREATE TABLE authorities
(
    username  varchar(50) NOT NULL,
    authority varchar(50) NOT NULL,

    UNIQUE KEY authorities_idx_1 (username, authority),

    CONSTRAINT authorities_ibfk_1
        FOREIGN KEY (username)
            REFERENCES users (username)
) ENGINE = InnoDB
  DEFAULT CHARSET = latin1;

INSERT INTO authorities
VALUES ('admin', 'ROLE_ADMIN'),
       ('manager', 'ROLE_MANAGER'),
       ('all', 'ROLE_ADMIN'),
       ('all', 'ROLE_MANAGER');