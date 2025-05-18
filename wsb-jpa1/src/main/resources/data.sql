DELETE FROM visit_entity;
DELETE FROM patient_entity;
DELETE FROM doctor_entity;
DELETE FROM address_entity;
DELETE FROM medical_treatment_entity;

INSERT INTO address_entity (address_line1, address_line2, city, postal_code)
VALUES
    ('ul. Testowa 1', 'm. 12', 'Warszawa', '00-001'),
    ('ul. Zdrowia 2', 'lok. 4', 'Kraków', '30-002');

INSERT INTO doctor_entity (first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES
    ('Adam', 'Nowak', '111111111', 'adam@klinika.pl', 'D001', 'DERMATOLOGIST');

INSERT INTO medical_treatment_entity (description, type)
VALUES
    ('Badanie kontrolne', 'USG');

INSERT INTO patient_entity (first_name, last_name, telephone_number, email, patient_number, date_of_birth, insured, address_id, pesel)
VALUES
    ('Jan', 'Kowalski', '123456789', 'jan@example.com', 'P001', '1990-01-01', true, 1, '90010112345');

INSERT INTO visit_entity (doctor_id, medical_treatment_id, patient_id, time, visit_date, description)
VALUES (1, 1, 1, '2025-05-01 10:00:00', '2025-05-01 10:00:00', 'Pierwsza wizyta testowa');
