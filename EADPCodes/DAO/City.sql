
SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `city` CASCADE
;

/* Create Tables */

CREATE TABLE `city`
(
	`cid` INT NOT NULL,
	`cname` VARCHAR(50) NULL,
	`cprovince` VARCHAR(50) NULL,
	CONSTRAINT `PK_Cid` PRIMARY KEY (`cid` ASC)
)

;

SET FOREIGN_KEY_CHECKS=1
; 
