CREATE DATABASE Course_Search;
USE Course_Search;

CREATE TABLE Majors (
    ID INT NOT NULL AUTO_INCREMENT,
    Major_Name VARCHAR(255),
    PRIMARY KEY (ID)
);

INSERT INTO Majors (Major_Name)
 VALUES
 ('Accounting')
 ,('Administrative Office Technology')
 ,('Aircraft Maintenance Technology')
,('Baking and Pastry Arts')
,('Business Administration')
,('Civil Engineering Technology')
,('Commercial Graphics')
,('Computer Programming')
,('Information Systems Specialist')
,('General Technology')
,('Management')
,('Mechanical Engineering Technology')
,('Network Systems Management')
,('Occupational Therapy Assistant')
,('Physical Therapist Assistant')
,('Veterinary Technology');
CREATE TABLE Courses (
Course_ID VARCHAR(255),
Course_Section VARCHAR(255),
Course_Name VARCHAR(255),
PRIMARY KEY (Course_ID) 
);

#This will be adjusted after this sprint to have the sections split from the courses table, for now it doesn't *actually* affect the information required for filtering courses to majors.
INSERT INTO Courses (Course_ID, Course_Section, Course_Name)
VALUES
('MAT101', 'W01', 'College Algebra'),
('ENG101', 'W01', 'English 101'),
('ECO101', 'W01', 'Microeconomics'),
('ECO102', 'W01', 'Macroeconomics'),
('CPT101', 'W01', 'Java Programming'),
('ACC101', 'W01', 'Accounting'),
('ADM101', 'W01', 'Administrating'),
('AMT101', 'W01', 'Aircraft Building'),
('BAK101', 'W01', 'Cake Conceptualizing'),
('BIS101', 'W01', 'Acronym Making'),
('CET101', 'W01', 'Back Pat Lecture'),
('CAD101', 'W01', 'Tracing'),
('IST101', 'W01', 'CAT5 Identification'),
('GEN101', 'W01', 'technology in the field'),
('MGT101', 'W01', 'Micromanaging'),
('MET101', 'W01', '3D pen usage'),
('NSM101', 'W01', 'How to Not Get Zapped'),
('OTA101', 'W01', 'Feeling Good About Your Job'),
('PTA101', 'W01', 'Muscles 101'),
('VET101', 'W01', 'All About Monkeys');

CREATE TABLE Major_Courses (
Major_ID int NOT NULL, 
Course_ID VARCHAR(255),
FOREIGN KEY (Major_ID) references Majors (ID),
FOREIGN KEY (Course_ID) references Courses(Course_ID)
);

INSERT INTO Major_Courses 
VALUES 
((SELECT ID FROM Majors WHERE Major_Name = 'Accounting'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Accounting'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Accounting'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Accounting'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Accounting'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ACC101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Administrative Office Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Administrative Office Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Administrative Office Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Administrative Office Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Administrative Office Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ADM101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Aircraft Maintenance Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Aircraft Maintenance Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Aircraft Maintenance Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Aircraft Maintenance Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Aircraft Maintenance Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'AMT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Baking and Pastry Arts'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Baking and Pastry Arts'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Baking and Pastry Arts'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Baking and Pastry Arts'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Baking and Pastry Arts'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'BAK101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Business Administration'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Business Administration'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Business Administration'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Business Administration'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Business Administration'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'BIS101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Civil Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Civil Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Civil Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Civil Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Civil Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'CET101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Commercial Graphics'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Commercial Graphics'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Commercial Graphics'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Commercial Graphics'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Commercial Graphics'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'CAD101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Computer Programming'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Computer Programming'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Computer Programming'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Computer Programming'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Computer Programming'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'CPT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Information Systems Specialist'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Information Systems Specialist'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Information Systems Specialist'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Information Systems Specialist'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Information Systems Specialist'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'IST101')),
((SELECT ID FROM Majors WHERE Major_Name = 'General Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'General Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'General Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'General Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'General Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'GEN101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),#
((SELECT ID FROM Majors WHERE Major_Name = 'Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MGT101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Mechanical Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),#
((SELECT ID FROM Majors WHERE Major_Name = 'Mechanical Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Mechanical Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Mechanical Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Mechanical Engineering Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MET101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Network Systems Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),#
((SELECT ID FROM Majors WHERE Major_Name = 'Network Systems Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Network Systems Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Network Systems Management'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Network Systems Managementy'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'NSM101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Occupational Therapy Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),#
((SELECT ID FROM Majors WHERE Major_Name = 'Occupational Therapy Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Occupational Therapy Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Occupational Therapy Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Occupational Therapy Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'OTA101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Physical Therapist Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),#
((SELECT ID FROM Majors WHERE Major_Name = 'Physical Therapist Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Physical Therapist Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Physical Therapist Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Physical Therapist Assistant'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'PTA101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Veterinary Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'MAT101')),#
((SELECT ID FROM Majors WHERE Major_Name = 'Veterinary Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ENG101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Veterinary Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO101')),
((SELECT ID FROM Majors WHERE Major_Name = 'Veterinary Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'ECO102')),
((SELECT ID FROM Majors WHERE Major_Name = 'Veterinary Technology'), (SELECT Course_ID FROM Courses WHERE Course_ID = 'VET101')),
;

