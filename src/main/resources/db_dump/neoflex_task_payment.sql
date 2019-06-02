CREATE TABLE `payment` (
   `requestId` varchar(10) NOT NULL,
   `amount` double unsigned NOT NULL,
   `currency` varchar(30) NOT NULL,
   `operatingType` varchar(2) NOT NULL,
   `remark` text,
   `accountNumberFrom` varchar(45) NOT NULL,
   `accountNumberTo` varchar(45) NOT NULL,
   `referenceNumber` varchar(32) NOT NULL,
   `status` varchar(45) DEFAULT NULL,
   `dateStamp` timestamp NOT NULL,
   PRIMARY KEY (`requestId`),
   UNIQUE KEY `referenceNumber_UNIQUE` (`referenceNumber`),
   UNIQUE KEY `requestId_UNIQUE` (`requestId`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci

 INSERT INTO `payment` VALUES   ('q1w2e',100,'eu','AA','Good test pay','vtihfhth3d27qho','ys6a40y3y858349','1b6bdw1j9f2hzwwmd4yggmnplh2k4298','successful','2019-06-02 12:27:39'),
                                ('qel12',12,'EU','CA','none','vtihfhth3d27qho','ei012q7g25wglwv','1y8jo97r1vpxq6n9j0fqwb7h3g5j3ke5','successful','2019-06-02 14:41:06');
