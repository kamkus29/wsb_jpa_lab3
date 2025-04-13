-- Adresy
INSERT INTO address (id, address_line1, address_line2, city, postal_code)
VALUES
    (1, 'ul. Testowa 1', 'm. 12', 'Warszawa', '00-001'),
    (2, 'ul. Zdrowia 2', 'lok. 4', 'Kraków', '30-002');

-- Lekarze
INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization)
VALUES
    (1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@clinic.pl', 'DOC001', 'GP'),
    (2, 'Anna', 'Nowicka', '111222333', 'anna.nowicka@clinic.pl', 'DOC002', 'OCULIST');

-- Pacjenci
INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id, is_insured)
VALUES
    (1, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', 'PAT001', '1990-05-20', 1, true),
    (2, 'Piotr', 'Zieliński', '555666777', 'piotr.zielinski@example.com', 'PAT002', '1985-07-15', 2, false);

-- Zabiegi
INSERT INTO medical_treatment (id, description, type)
VALUES
    (1, 'Badanie EKG', 'EKG'),
    (2, 'USG jamy brzusznej', 'USG');

-- Wizyty
INSERT INTO visit (description, time, doctor_id, patient_id, medical_treatment_id)
VALUES
    ('Pierwsza wizyta', '2025-04-08T10:00:00', 1, 1, 1);
