INSERT INTO address (id, address_line_1, address_line_2, city, postal_code) VALUES
                                                                                (1, 'Main St', 'Apt 1', 'Warsaw', '00-001'),
                                                                                (2, 'Market Sq', 'Suite 200', 'Krakow', '31-002');

INSERT INTO doctor (id, first_name, last_name, telephone_number, email, doctor_number, specialization, address_id) VALUES
                                                                                                                       (1, 'John', 'Doe', '123456789', 'john.doe@example.com', 'DOC001', 'CARDIOLOGY', 1),
                                                                                                                       (2, 'Jane', 'Smith', '987654321', 'jane.smith@example.com', 'DOC002', 'NEUROLOGY', 2);

INSERT INTO patient (id, first_name, last_name, telephone_number, email, patient_number, date_of_birth, address_id) VALUES
                                                                                                                        (1, 'Alice', 'Brown', '555666777', 'alice.brown@example.com', 'PAT001', '1980-01-15', 1),
                                                                                                                        (2, 'Bob', 'White', '444555666', 'bob.white@example.com', 'PAT002', '1975-06-20', 2);

INSERT INTO medical_treatment (id, description, type) VALUES
                                                          (1, 'Chemotherapy', 'USG'),
                                                          (2, 'Physical Therapy', 'EKG');

INSERT INTO visit (id, description, time, doctor_id, patient_id) VALUES
                                                                     (1, 'Routine Checkup', '2023-05-15 10:00:00', 1, 1),
                                                                     (2, 'Specialist Consultation', '2023-05-16 14:30:00', 2, 2);

INSERT INTO visit_treatment (visit_id, treatment_id) VALUES
                                                         (1, 1),
                                                         (2, 2);
