
SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `lake` CASCADE
;

/* Create Tables */

CREATE TABLE `lake`
(
	`lid` INT NOT NULL,
	`lname` VARCHAR(50) NULL,
	`lprovince` VARCHAR(50) NULL,
	CONSTRAINT `PK_Lid` PRIMARY KEY (`lid` ASC)
)

;

SET FOREIGN_KEY_CHECKS=1
; 
