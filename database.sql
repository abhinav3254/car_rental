CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    gender VARCHAR(10),
    email VARCHAR(100) UNIQUE NOT NULL,
    phone VARCHAR(20) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    occupation VARCHAR(100),
    address TEXT,
    status BOOLEAN,
    profile_photo BYTEA,
    role VARCHAR(50) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

CREATE TABLE vehicle_type (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    people_capacity INT,
    luggage_capacity INT,
    description TEXT,
    fuel_type VARCHAR(50),
    transmission_type VARCHAR(50),
    average_mileage FLOAT,
    year_of_manufacture INT,
    registration_date DATE,
    last_service_date DATE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

CREATE TABLE vehicle_company (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address TEXT,
    contact_phone VARCHAR(20),
    website VARCHAR(100),
    logo BYTEA,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

CREATE TABLE vehicle (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    type_id INT REFERENCES vehicle_type(id),
    company_id INT REFERENCES vehicle_company(id),
    price DECIMAL(10, 2) NOT NULL,
    vehicle_img BYTEA,
    available BOOLEAN,
    color VARCHAR(50),
    registration_number VARCHAR(20) UNIQUE,
    year_of_manufacture INT,
    mileage INT,
    last_service_date DATE,
    insurance_expiry_date DATE,
	late_fine DECIMAL(10, 2) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

CREATE TABLE booking (
    id SERIAL PRIMARY KEY,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    user_license BYTEA NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    user_id INT REFERENCES users(id),
    vehicle_id INT REFERENCES vehicle(id),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

CREATE TABLE billing (
    id SERIAL PRIMARY KEY,
    start_date TIMESTAMP NOT NULL,
    end_date TIMESTAMP NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
	late_days INT,
	late_fine DECIMAL(10, 2),
	final_price DECIMAL(10, 2) not null,
    user_id INT REFERENCES users(id),
    vehicle_id INT REFERENCES vehicle(id),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    created_by VARCHAR(100),
    updated_by VARCHAR(100)
);

select * from users;
