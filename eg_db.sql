# Copy this file, load up mysql in terminal, then paste and hit enter. 
# This will give you the database schema that the library api relies on and also three dummy entries.
# Then you can download a mysql gui like Sequel Pro and load up the database 'bookshelf' on localhost port 3006


# Sets character sets and encoding

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


# Dump of table Books if it already exists
DROP TABLE IF EXISTS `Books`;

# (Re)creates 'Books' table with correct columns
CREATE TABLE `Books` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(150) DEFAULT '',
  `authorFirst` varchar(150) DEFAULT '',
  `isbn` varchar(30) DEFAULT '',
  `authorLast` varchar(150) DEFAULT '',
  `subject` varchar(50) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

LOCK TABLES `Books` WRITE;
/*!40000 ALTER TABLE `Books` DISABLE KEYS */;

# Inserts three dummy rows into the database
INSERT INTO `Books` (`id`, `title`, `authorFirst`, `isbn`, `authorLast`, `subject`)
VALUES
  (1,'New book','Jacob','1234132432','White','Javascript'),
  (2,'Head First Java','Alan','3453455345','Davies','Node'),
  (12,'adfgad','Test first name','9780385472579','Smith','Java');

/*!40000 ALTER TABLE `Books` ENABLE KEYS */;
UNLOCK TABLES;



/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;