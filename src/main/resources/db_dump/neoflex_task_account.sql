CREATE TABLE `account` (
   `account_id` int(10) NOT NULL AUTO_INCREMENT,
   `accountNumber` varchar(15) NOT NULL,
   `customerNumber` varchar(10) NOT NULL,
   `currency` varchar(10) NOT NULL,
   `balance` double unsigned DEFAULT '0',
   PRIMARY KEY (`account_id`),
   UNIQUE KEY `accountNumber_UNIQUE` (`accountNumber`)
 ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


 INSERT INTO `account` VALUES    (1,'vtihfhth3d27qho','h9tuakkwy5','eu',5000),
                                 (2,'jruw1h1ks15htpg','vykuc99d8v','eu',500000),
                                 (3,'0h0hqsmkg6e1kqd','4qeiztmgpw','eu',7000),
                                 (4,'ys6a40y3y858349','dq9avzgisk','eu',39000),
                                 (5,'hvfxdel4wfvm51r','9gipdjh407','eu',125000),
                                 (6,'vey4vz0hi7mtdaz','ufe8o76gg5','eu',8000),
                                 (7,'9k5hhvnsu75cn9i','2kdwncven1','eu',4000),
                                 (8,'ei012q7g25wglwv','j3yzrmpzgp','eu',750000);