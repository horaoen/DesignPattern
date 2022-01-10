
SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `river` CASCADE
;

/* Create Tables */

CREATE TABLE `river`
(
	`rid` INT NOT NULL,
	`rname` VARCHAR(50) NULL,
	`rprovince` VARCHAR(50) NULL,
	CONSTRAINT `PK_Rid` PRIMARY KEY (`rid` ASC)
)

;

SET FOREIGN_KEY_CHECKS=1
; 
