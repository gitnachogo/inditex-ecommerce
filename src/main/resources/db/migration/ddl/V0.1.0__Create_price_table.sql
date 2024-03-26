CREATE TABLE prices
(
    id         INT,
    brand_id   INT            NOT NULL,
    product_id INT            NOT NULL,
    start_date TIMESTAMP      NOT NULL,
    end_date   TIMESTAMP      NOT NULL,
    price      DECIMAL(10, 2) NOT NULL,
    curr       VARCHAR(3)     NOT NULL,
    priority   INT            NOT NULL,
    CONSTRAINT pk_prices PRIMARY KEY (id)
);