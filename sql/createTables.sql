DROP TABLE vehicles CASCADE CONSTRAINTS PURGE;
DROP TABLE bicycle CASCADE CONSTRAINTS PURGE;
DROP TABLE escooter CASCADE CONSTRAINTS PURGE;
DROP TABLE parks CASCADE CONSTRAINTS PURGE;
DROP TABLE parks_info CASCADE CONSTRAINTS PURGE;
DROP TABLE clients CASCADE CONSTRAINTS PURGE;
DROP TABLE administrador CASCADE CONSTRAINTS PURGE;
DROP TABLE trips CASCADE CONSTRAINTS PURGE;
DROP TABLE invoices CASCADE CONSTRAINTS PURGE;
DROP TABLE paths CASCADE CONSTRAINTS PURGE;
DROP TABLE pois CASCADE CONSTRAINTS PURGE;
DROP TABLE vehicle_parks CASCADE CONSTRAINTS PURGE;
DROP TABLE trip_paths CASCADE CONSTRAINTS PURGE;

CREATE TABLE vehicles (
    vehicle_desc    VARCHAR(20),
    cod_vehicle      INTEGER GENERATED AS IDENTITY,
    estado          CHAR(1),

    CONSTRAINT pk_vehicle_vehicle_desc PRIMARY KEY (vehicle_desc)
);

CREATE TABLE bicycle (
    vehicle_desc    VARCHAR(20),
    weight          INTEGER
        CONSTRAINT nn_vehicle_type_weight NOT NULL,
    aerodynamic_cf  NUMBER(10,2)
        CONSTRAINT nn_vehicle_type_aerodynamic_cf NOT NULL,
    frontal_area    NUMBER(10,1)
        CONSTRAINT nn_vehicle_type_frontal_area NOT NULL,
    wheel_size      VARCHAR(8)
        CONSTRAINT nn_bycicle_vehicles_wheek_size NOT NULL,

    CONSTRAINT pk_bicycle_types_vehicle_desc PRIMARY KEY (vehicle_desc)
);

CREATE TABLE escooter (
    vehicle_desc    VARCHAR(20),
    weight          INTEGER
        CONSTRAINT nn_escooter_types_type_weight NOT NULL,
    aerodynamic_cf  NUMBER(10,2)
        CONSTRAINT nn_escooter_types_aerodynamic_cf NOT NULL,
    frontal_area    NUMBER(10,1)
        CONSTRAINT nn_escooter_types_frontal_area NOT NULL,
    battery_max     INTEGER
        CONSTRAINT nn_escooter_types_battery_max NOT NULL,
    battery_actual  INTEGER
        CONSTRAINT nn_escooter_vehicles_battery_actual NOT NULL,
    scooter_type     VARCHAR(8)
        CONSTRAINT nn_escooter_types_scooter_type NOT NULL,
    motor            NUMBER(10),


    CONSTRAINT ck_vehicle_type_type CHECK (REGEXP_LIKE ( scooter_type, 'city|off-road')),
    CONSTRAINT pk_escooter_types_vehicle_desc PRIMARY KEY (vehicle_desc)
);


CREATE TABLE parks (
    park_id         VARCHAR(20),
    latitude        NUMBER(10,6)
        CONSTRAINT nn_parks_latitude NOT NULL,
    longitude       NUMBER(10,6)
        CONSTRAINT nn_parks_longitude NOT NULL,


    CONSTRAINT pk_parks_park_id PRIMARY KEY (park_id)
);

CREATE TABLE parks_info (
    latitude        NUMBER(10,6),
    longitude       NUMBER(10,6),
    elevation       INTEGER
        CONSTRAINT nn_parks_info_elevation NOT NULL,
    park_desc		VARCHAR(30),
    max_bicycles    INTEGER
        CONSTRAINT nn_parks_info_max_bicycles NOT NULL,
    max_scooters    INTEGER
        CONSTRAINT nn_parks_info_max_scooters NOT NULL,
    input_voltage   INTEGER
        CONSTRAINT nn_parks_info_input_voltage NOT NULL,
    input_current   INTEGER
        CONSTRAINT nn_parks_info_input_current NOT NULL,


    CONSTRAINT pk_parks_info_latitude_longitude PRIMARY KEY (latitude, longitude)
);

CREATE TABLE clients (
    email           VARCHAR(20)
        CONSTRAINT nn_clients_email NOT NULL,
    pass            VARCHAR(20)
        CONSTRAINT nn_clients_password NOT NULL,
    visa            INTEGER,
    points          NUMBER(10)     DEFAULT 0,
    username		VARCHAR(20)
        CONSTRAINT nn_clients_username NOT NULL,
    height          INTEGER
        CONSTRAINT nn_clients_height NOT NULL,
    weight          INTEGER
        CONSTRAINT nn_clients_weight NOT NULL,
    gender          VARCHAR(6),
    avg_cycling_spd NUMBER(10,2)
        CONSTRAINT nn_clients_avg_cycling_spd NOT NULL,


    CONSTRAINT ck_clients_gender CHECK (REGEXP_LIKE ( lower(gender), 'm|f')),
    CONSTRAINT pk_clients_email PRIMARY KEY (email)
);

CREATE TABLE administrador (
    login			VARCHAR(20)
        CONSTRAINT nn_admin_login NOT NULL,
    password 		VARCHAR(20)
        CONSTRAINT nn_admin_password NOT NULL,


    CONSTRAINT pk_admin_login PRIMARY KEY (login)
);

CREATE TABLE trips (
    cod_trip        INTEGER GENERATED AS IDENTITY,
    email           VARCHAR(20)
        CONSTRAINT nn_trips_email NOT NULL,
    vehicle_desc    VARCHAR(20),
    park_id_start   VARCHAR(20),
    start_date      TIMESTAMP,
    end_date        TIMESTAMP,
    latitude_end    NUMBER(10,6),
    longitude_end   NUMBER(10,6),

    CONSTRAINT pk_pedidos_aluguer_cod_pedido PRIMARY KEY (cod_trip)
);

CREATE TABLE trip_paths(
    cod_trip INTEGER,
    id_path  INTEGER,

    CONSTRAINT pk_trip_paths_cod_trip_id_path PRIMARY KEY (cod_trip, id_path)
);

CREATE TABLE invoices (
    cod_invoice     INTEGER GENERATED AS IDENTITY,
    cod_trip        INTEGER,
    value           NUMBER(10,2),


    CONSTRAINT pk_invoices_cod_bill PRIMARY KEY (cod_invoice)
);

CREATE TABLE paths (
    id_path                   INTEGER      GENERATED ALWAYS AS IDENTITY,
    latitude_a                NUMBER(10,6)   DEFAULT 0,
    longitude_a               NUMBER(10,6)   DEFAULT 0,
    latitude_b                NUMBER(10,6)   DEFAULT 0,
    longitude_b               NUMBER(10,6)   DEFAULT 0,
    kinetic_cf                NUMBER(10,3)   DEFAULT 0,
    wind_dir                  INTEGER        DEFAULT 0,
    wind_spd                  NUMBER(10,1)   DEFAULT 0,
    
    CONSTRAINT pk_paths_id_path PRIMARY KEY (id_path)
);

CREATE TABLE pois(
    latitude                NUMBER(10,6)    DEFAULT 0,
    longitude               NUMBER(10,6)    DEFAULT 0,
    elevation               INTEGER     DEFAULT 0,
    poi_description         VARCHAR(20),
    
    CONSTRAINT pk_poi_latitude_longitude PRIMARY KEY (latitude, longitude)
);

CREATE TABLE vehicle_parks(
     vehicle_desc           VARCHAR(20),
     park_id                VARCHAR(20),
     
     CONSTRAINT pk_vehicle_parks_vehicle_desc PRIMARY KEY (vehicle_desc)
);


ALTER TABLE bicycle             ADD CONSTRAINT fk_bicycle_vehicles_cod          FOREIGN KEY ( vehicle_desc )         REFERENCES vehicles ( vehicle_desc );
ALTER TABLE escooter            ADD CONSTRAINT fk_escooter_vehicles_desc         FOREIGN KEY ( vehicle_desc )        REFERENCES vehicles ( vehicle_desc );
ALTER TABLE parks               ADD CONSTRAINT fk_parks_latitude_longitude      FOREIGN KEY ( latitude, longitude ) REFERENCES parks_info ( latitude, longitude );
ALTER TABLE trips               ADD CONSTRAINT fk_trips_email                   FOREIGN KEY ( email )               REFERENCES clients ( email );
ALTER TABLE trips               ADD CONSTRAINT fk_trips_vehicle_desc             FOREIGN KEY ( vehicle_desc )         REFERENCES vehicles ( vehicle_desc );
ALTER TABLE trips               ADD CONSTRAINT fk_trips_park_id_start           FOREIGN KEY ( park_id_start )       REFERENCES parks ( park_id );
ALTER TABLE invoices            ADD CONSTRAINT fk_invoice_cod_trip              FOREIGN KEY ( cod_trip )            REFERENCES trips ( cod_trip );
ALTER TABLE trip_paths          ADD CONSTRAINT fk_trip_paths_cod_trip           FOREIGN KEY ( cod_trip )            REFERENCES trips ( cod_trip );
ALTER TABLE trip_paths          ADD CONSTRAINT fk_trip_paths_id_path            FOREIGN KEY ( id_path )             REFERENCES paths ( id_path );
ALTER TABLE vehicle_parks       ADD CONSTRAINT fk_vehicle_park_vehicle_desc      FOREIGN KEY ( vehicle_desc )         REFERENCES vehicles ( vehicle_desc );
ALTER TABLE vehicle_parks       ADD CONSTRAINT fk_vehicle_park_park_id          FOREIGN KEY ( park_id )             REFERENCES parks ( park_id );