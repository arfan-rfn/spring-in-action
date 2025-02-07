DROP TABLE IF EXISTS licenses;

CREATE TABLE IF NOT EXISTS licenses (
    license_id      VARCHAR(100) PRIMARY KEY,
    organization_id VARCHAR(100) NOT NULL,
    description     VARCHAR(200),
    product_name    VARCHAR(100) NOT NULL,
    license_type    VARCHAR(100) NOT NULL
);