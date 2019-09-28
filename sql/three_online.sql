DROP DATABASE IF EXISTS three_online;
CREATE DATABASE three_online DEFAULT CHARACTER SET utf8;
USE three_online;

CREATE TABLE three_online.item (
  item_id VARCHAR(10) PRIMARY KEY,
  item_name VARCHAR(128) NOT NULL,
  item_genre VARCHAR(128) NOT NULL,
  item_publisher VARCHAR(128) NOT NULL,
  item_arrival_date DATE NOT NULL,
  item_img_path VARCHAR(128) NOT NULL,
  item_comment VARCHAR(512),
  delete_flg CHARACTER(1) NOT NULL,
  insert_date DATE NOT NULL,
  update_date DATE NOT NULL
);
INSERT INTO three_online.item VALUES
('0000000001','Fate/stay night [Heaven\'s Feel]','ファンタジー','TYPE-MOON','2017/10/14','/FateStayNightHeavensFeel','『Fate/stay night [Heaven\'s Feel]』（フェイト ステイナイト ヘブンズフィール）は、2017年10月14日より順次劇場公開予定の全三章で構成される連作劇場アニメ。配給はアニプレックス。アニメーション制作はufotable。「Project Fate/stay night」における最後の企画となる。','0',SYSDATE(),SYSDATE())
,('0000000002','機動戦士ガンダムUC episode 1','SF','サンライズ','2010/03/12','/GundamUC1', 'ここからでていけー','0',SYSDATE(),SYSDATE())
;
commit;

CREATE TABLE three_online.stock (
  item_id VARCHAR(10) PRIMARY KEY,
  item_stock int NOT NULL,
  delete_flg CHARACTER(1) NOT NULL,
  insert_date DATE NOT NULL,
  update_date DATE NOT NULL
);
INSERT INTO three_online.stock VALUES
('0000000001',10,'0',SYSDATE(),SYSDATE())
,('0000000002',10,'0',SYSDATE(),SYSDATE())
;
commit;

CREATE TABLE three_online.user (
  user_id VARCHAR(10) PRIMARY KEY,
  password VARCHAR(16) NOT NULL,
  user_name VARCHAR(128) NOT NULL,
  user_name_kana VARCHAR(128) NOT NULL,
  user_gender VARCHAR(1) NOT NULL,
  user_birth_day DATE NOT NULL,
  user_zip VARCHAR(8) NOT NULL,
  user_address VARCHAR(256) NOT NULL,
  user_phone_number VARCHAR(16),
  user_mail_address VARCHAR(256),
  delete_flg CHARACTER(1) NOT NULL,
  insert_date DATE NOT NULL,
  update_date DATE NOT NULL
);
INSERT INTO three_online.user VALUES
('0000000001','password', 'やずや','ヤズヤ','男','1977-01-17','815-8686','福岡県福岡市南区大楠1-34-16','0120-828-828','yazuya@yazuya.com','0',SYSDATE(),SYSDATE())
,('0000000002','password','植木 宏基','ウエキ ヒトシ','男','1991-08-06','123-4567','ユートピア','0120-783-640','h-ueki@three-in.com','0',SYSDATE(),SYSDATE())
;