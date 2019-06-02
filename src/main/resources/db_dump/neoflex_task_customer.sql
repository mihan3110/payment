CREATE TABLE `customer` (
   `customerId` int(10) NOT NULL AUTO_INCREMENT,
   `customerNumber` varchar(10) NOT NULL,
   `Name` varchar(50) NOT NULL,
   `Surname` varchar(50) DEFAULT NULL,
   `Male` varchar(10) DEFAULT NULL,
   `Passport` int(10) NOT NULL,
   PRIMARY KEY (`customerId`),
   UNIQUE KEY `customerNumber_UNIQUE` (`customerNumber`),
   UNIQUE KEY `Passport_UNIQUE` (`Passport`)
 ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci


 INSERT INTO `customer` VALUES   (1,'h9tuakkwy5','Mike','Black','m',67475187),
                                 (2,'vykuc99d8v','Frank','White','m',50178783),
                                 (3,'4qeiztmgpw','Mike','Bloom','m',16060916),
                                 (4,'dq9avzgisk','Denis','Purple','m',59423731),
                                 (5,'9gipdjh407','Olga','Gray','f',93080377),
                                 (6,'ufe8o76gg5','Alex','Grey','m',26044360),
                                 (7,'2kdwncven1','Oleg','Rock','m',57560153),
                                 (8,'j3yzrmpzgp','Mike','Strong','m',93974304);
