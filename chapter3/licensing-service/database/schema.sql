CREATE TABLE IF NOT EXISTS licenses (
    id              SERIAL PRIMARY KEY,
    license_id      VARCHAR(100) NOT NULL,
    organization_id VARCHAR(100) NOT NULL,
    description     VARCHAR(200),
    product_name    VARCHAR(100) NOT NULL,
    license_type    VARCHAR(100) NOT NULL
);