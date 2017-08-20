/*
Navicat PGSQL Data Transfer

Source Server         : localpost
Source Server Version : 90604
Source Host           : localhost:5432
Source Database       : spring
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90604
File Encoding         : 65001

Date: 2017-08-19 01:54:08
*/


-- ----------------------------
-- Table structure for "group_module"
-- ----------------------------
DROP TABLE "group_module";
CREATE TABLE "group_module" (
"group_id" int8 NOT NULL,
"module_id" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of group_module
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "m_group"
-- ----------------------------
DROP TABLE "m_group";
CREATE TABLE "m_group" (
"id" int8 NOT NULL,
"description" varchar(64),
"name" varchar(32)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of m_group
-- ----------------------------
BEGIN;
INSERT INTO "m_group" VALUES ('1', 'Administrator', 'ADMIN');
COMMIT;

-- ----------------------------
-- Table structure for "m_module"
-- ----------------------------
DROP TABLE "m_module";
CREATE TABLE "m_module" (
"id" int8 NOT NULL,
"name" varchar(50) NOT NULL,
"url" varchar(100) NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of m_module
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "m_pendamping"
-- ----------------------------
DROP TABLE "m_pendamping";
CREATE TABLE "m_pendamping" (
"kdpendamping" varchar(9) NOT NULL,
"alamat" varchar(150),
"nmpendamping" varchar(50) NOT NULL,
"status" varchar(1),
"kdkabu" int4,
"kdkeca" int4,
"kdkelr" int4,
"kdprop" int4,
"userid" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of m_pendamping
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "m_user"
-- ----------------------------
DROP TABLE "m_user";
CREATE TABLE "m_user" (
"id" int8 NOT NULL,
"account_expired" bool NOT NULL,
"account_locked" bool NOT NULL,
"credentials_expired" bool NOT NULL,
"account_enabled" bool,
"namauser" varchar(50) NOT NULL,
"kdkabu" varchar(4),
"kdkeca" varchar(6),
"kdkelr" varchar(8),
"kdprop" varchar(2),
"password" varchar(255) NOT NULL,
"userid" varchar(50) NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of m_user
-- ----------------------------
BEGIN;
INSERT INTO "m_user" VALUES ('1', 't', 't', 't', 't', 'Fajar Septian', '02', '02', '02', '02', '123456', 'admin@gmail.com');
INSERT INTO "m_user" VALUES ('4', 'f', 'f', 't', 't', 'fajar septian dwi saputro', '02', '02', '01', '1', '$2a$10$Fvu1cQHze/6mitVZ8tHMJedzeOA.65a0gv4mh4/BVFyglS26kKv8W', 'fajarseptian08@gmail.com');
COMMIT;

-- ----------------------------
-- Table structure for "mst_jawaban"
-- ----------------------------
DROP TABLE "mst_jawaban";
CREATE TABLE "mst_jawaban" (
"kode_jawaban" varchar(10) NOT NULL,
"name" varchar(100),
"kode_soal" varchar(10)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_jawaban
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "mst_kabupaten"
-- ----------------------------
DROP TABLE "mst_kabupaten";
CREATE TABLE "mst_kabupaten" (
"kd_kab" int4 NOT NULL,
"kab_name" varchar(100),
"kd_prop" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_kabupaten
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "mst_kecamatan"
-- ----------------------------
DROP TABLE "mst_kecamatan";
CREATE TABLE "mst_kecamatan" (
"kd_kec" int4 NOT NULL,
"kec_name" varchar(100),
"kd_kab" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_kecamatan
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "mst_kelurahan"
-- ----------------------------
DROP TABLE "mst_kelurahan";
CREATE TABLE "mst_kelurahan" (
"kd_kelr" int4 NOT NULL,
"kelr_name" varchar(100),
"kd_kac" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_kelurahan
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "mst_propinsi"
-- ----------------------------
DROP TABLE "mst_propinsi";
CREATE TABLE "mst_propinsi" (
"kd_prop" int4 NOT NULL,
"prop_name" varchar(100)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_propinsi
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "mst_religion"
-- ----------------------------
DROP TABLE "mst_religion";
CREATE TABLE "mst_religion" (
"id" int8 NOT NULL,
"religion_name" varchar(20) NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_religion
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "mst_soal"
-- ----------------------------
DROP TABLE "mst_soal";
CREATE TABLE "mst_soal" (
"kode_soal" varchar(10) NOT NULL,
"max_digit" int4,
"ordered" int4,
"question" varchar(100),
"type" varchar(255),
"parent_kode_soal" varchar(10)
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of mst_soal
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "sequence_table"
-- ----------------------------
DROP TABLE "sequence_table";
CREATE TABLE "sequence_table" (
"sequence_name" varchar(255) NOT NULL,
"sequence_next_hi_value" int8
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of sequence_table
-- ----------------------------
BEGIN;
INSERT INTO "sequence_table" VALUES ('TBL_USER_ID', '5');
COMMIT;

-- ----------------------------
-- Table structure for "t_kpm_resertifikasi"
-- ----------------------------
DROP TABLE "t_kpm_resertifikasi";
CREATE TABLE "t_kpm_resertifikasi" (
"noart" varchar(20) NOT NULL,
"nopeserta" varchar(15) NOT NULL,
"alamat" varchar(255),
"hub_krt" varchar(2),
"jnskel_kd" varchar(1),
"namaart" varchar(50),
"nmpengurus" varchar(50),
"nik" varchar(16),
"nokk" varchar(30),
"tahunkepesertaan" int4,
"tgl_lhr" date,
"kdkabu" int4,
"kdkeca" int4,
"kdkelr" int4,
"kdpendamping" varchar(9),
"kdprop" int4
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_kpm_resertifikasi
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "t_survey_resertifikasi"
-- ----------------------------
DROP TABLE "t_survey_resertifikasi";
CREATE TABLE "t_survey_resertifikasi" (
"noart" varchar(20) NOT NULL,
"nopeserta" varchar(15) NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_survey_resertifikasi
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for "user_group"
-- ----------------------------
DROP TABLE "user_group";
CREATE TABLE "user_group" (
"user_id" int8 NOT NULL,
"group_id" int8 NOT NULL
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of user_group
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table "group_module"
-- ----------------------------
ALTER TABLE "group_module" ADD PRIMARY KEY ("group_id", "module_id");

-- ----------------------------
-- Uniques structure for table "m_group"
-- ----------------------------
ALTER TABLE "m_group" ADD UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table "m_group"
-- ----------------------------
ALTER TABLE "m_group" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table "m_module"
-- ----------------------------
ALTER TABLE "m_module" ADD UNIQUE ("name");

-- ----------------------------
-- Primary Key structure for table "m_module"
-- ----------------------------
ALTER TABLE "m_module" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Uniques structure for table "m_pendamping"
-- ----------------------------
ALTER TABLE "m_pendamping" ADD UNIQUE ("userid");

-- ----------------------------
-- Primary Key structure for table "m_pendamping"
-- ----------------------------
ALTER TABLE "m_pendamping" ADD PRIMARY KEY ("kdpendamping");

-- ----------------------------
-- Uniques structure for table "m_user"
-- ----------------------------
ALTER TABLE "m_user" ADD UNIQUE ("userid");

-- ----------------------------
-- Primary Key structure for table "m_user"
-- ----------------------------
ALTER TABLE "m_user" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table "mst_jawaban"
-- ----------------------------
ALTER TABLE "mst_jawaban" ADD PRIMARY KEY ("kode_jawaban");

-- ----------------------------
-- Primary Key structure for table "mst_kabupaten"
-- ----------------------------
ALTER TABLE "mst_kabupaten" ADD PRIMARY KEY ("kd_kab");

-- ----------------------------
-- Primary Key structure for table "mst_kecamatan"
-- ----------------------------
ALTER TABLE "mst_kecamatan" ADD PRIMARY KEY ("kd_kec");

-- ----------------------------
-- Primary Key structure for table "mst_kelurahan"
-- ----------------------------
ALTER TABLE "mst_kelurahan" ADD PRIMARY KEY ("kd_kelr");

-- ----------------------------
-- Primary Key structure for table "mst_propinsi"
-- ----------------------------
ALTER TABLE "mst_propinsi" ADD PRIMARY KEY ("kd_prop");

-- ----------------------------
-- Primary Key structure for table "mst_religion"
-- ----------------------------
ALTER TABLE "mst_religion" ADD PRIMARY KEY ("id");

-- ----------------------------
-- Primary Key structure for table "mst_soal"
-- ----------------------------
ALTER TABLE "mst_soal" ADD PRIMARY KEY ("kode_soal");

-- ----------------------------
-- Primary Key structure for table "sequence_table"
-- ----------------------------
ALTER TABLE "sequence_table" ADD PRIMARY KEY ("sequence_name");

-- ----------------------------
-- Primary Key structure for table "t_kpm_resertifikasi"
-- ----------------------------
ALTER TABLE "t_kpm_resertifikasi" ADD PRIMARY KEY ("noart", "nopeserta");

-- ----------------------------
-- Primary Key structure for table "t_survey_resertifikasi"
-- ----------------------------
ALTER TABLE "t_survey_resertifikasi" ADD PRIMARY KEY ("noart", "nopeserta");

-- ----------------------------
-- Primary Key structure for table "user_group"
-- ----------------------------
ALTER TABLE "user_group" ADD PRIMARY KEY ("user_id", "group_id");

-- ----------------------------
-- Foreign Key structure for table "group_module"
-- ----------------------------
ALTER TABLE "group_module" ADD FOREIGN KEY ("group_id") REFERENCES "m_group" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "group_module" ADD FOREIGN KEY ("module_id") REFERENCES "m_module" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "m_pendamping"
-- ----------------------------
ALTER TABLE "m_pendamping" ADD FOREIGN KEY ("kdkabu") REFERENCES "mst_kabupaten" ("kd_kab") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "m_pendamping" ADD FOREIGN KEY ("kdprop") REFERENCES "mst_propinsi" ("kd_prop") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "m_pendamping" ADD FOREIGN KEY ("kdkelr") REFERENCES "mst_kelurahan" ("kd_kelr") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "m_pendamping" ADD FOREIGN KEY ("userid") REFERENCES "m_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "m_pendamping" ADD FOREIGN KEY ("kdkeca") REFERENCES "mst_kecamatan" ("kd_kec") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "mst_jawaban"
-- ----------------------------
ALTER TABLE "mst_jawaban" ADD FOREIGN KEY ("kode_soal") REFERENCES "mst_soal" ("kode_soal") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "mst_kabupaten"
-- ----------------------------
ALTER TABLE "mst_kabupaten" ADD FOREIGN KEY ("kd_prop") REFERENCES "mst_propinsi" ("kd_prop") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "mst_kecamatan"
-- ----------------------------
ALTER TABLE "mst_kecamatan" ADD FOREIGN KEY ("kd_kab") REFERENCES "mst_kabupaten" ("kd_kab") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "mst_kelurahan"
-- ----------------------------
ALTER TABLE "mst_kelurahan" ADD FOREIGN KEY ("kd_kac") REFERENCES "mst_kecamatan" ("kd_kec") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "mst_soal"
-- ----------------------------
ALTER TABLE "mst_soal" ADD FOREIGN KEY ("parent_kode_soal") REFERENCES "mst_soal" ("kode_soal") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "t_kpm_resertifikasi"
-- ----------------------------
ALTER TABLE "t_kpm_resertifikasi" ADD FOREIGN KEY ("kdpendamping") REFERENCES "m_pendamping" ("kdpendamping") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "t_kpm_resertifikasi" ADD FOREIGN KEY ("kdprop") REFERENCES "mst_propinsi" ("kd_prop") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "t_kpm_resertifikasi" ADD FOREIGN KEY ("kdkabu") REFERENCES "mst_kabupaten" ("kd_kab") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "t_kpm_resertifikasi" ADD FOREIGN KEY ("kdkeca") REFERENCES "mst_kecamatan" ("kd_kec") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "t_kpm_resertifikasi" ADD FOREIGN KEY ("kdkelr") REFERENCES "mst_kelurahan" ("kd_kelr") ON DELETE NO ACTION ON UPDATE NO ACTION;

-- ----------------------------
-- Foreign Key structure for table "user_group"
-- ----------------------------
ALTER TABLE "user_group" ADD FOREIGN KEY ("group_id") REFERENCES "m_group" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
ALTER TABLE "user_group" ADD FOREIGN KEY ("user_id") REFERENCES "m_user" ("id") ON DELETE NO ACTION ON UPDATE NO ACTION;
