-- MySQL dump 10.13  Distrib 8.0.36, for macos14 (arm64)
--
-- Host: 127.0.0.1    Database: projectwork
-- ------------------------------------------------------
-- Server version	8.0.36


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cibo`
--

DROP TABLE IF EXISTS `cibo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cibo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `immagine` varchar(255) NOT NULL,
  `prezzo` decimal(6,2) NOT NULL,
  `allergeni` varchar(45) NOT NULL,
  `descrizione` varchar(1000) NOT NULL,
  `portata` varchar(45) NOT NULL,
  `alimentazione` varchar(45) NOT NULL,
  `furgoni_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cibo`
--

LOCK TABLES `cibo` WRITE;
/*!40000 ALTER TABLE `cibo` DISABLE KEYS */;
INSERT INTO `cibo` VALUES (3,'Pizza Margherita','https://i.ibb.co/DrcdFSM/pizza-png-from-pngfre-10.png',6.00,'glutine','Un\'icona della cucina italiana, la Pizza Margherita è una base di pizza sottile e croccante, arricchita con salsa di pomodoro, mozzarella fior di latte fresca e foglie di basilico profumate. Semplice, ma incredibilmente gustosa, è un\'esplosione di sapori mediterranei.','primo','onnivoro',5),(4,'Pasta alla Carbonara','https://i.ibb.co/mBVNPyS/carbonara.png',8.00,'uova','Un piatto classico romano, la Pasta alla Carbonara è un\'armoniosa combinazione di spaghetti al dente conditi con una cremosa salsa a base di uova, pancetta croccante, pecorino romano e pepe nero macinato fresco. Un tripudio di sapori semplici e avvolgenti.','primo','onnivoro',5),(5,'Risotto alla Milanese','https://i.ibb.co/cyS6Fbs/risotto-alla-milanese.png',10.00,'pesce','Originario di Milano, il Risotto alla Milanese è un piatto ricco e cremoso preparato con riso Carnaroli o Arborio, arricchito con zafferano, brodo di carne, vino bianco e Parmigiano Reggiano. Il suo colore dorato e il sapore delicato lo rendono un piatto elegante e irresistibile.','primo','onnivoro',5),(7,'Lasagne al Forno','https://i.ibb.co/vkG4XkW/lasagne.png',10.00,'glutine','Le Lasagne al Forno sono un classico della cucina italiana, con strati di pasta all\'uovo intercalati con ragù di carne, besciamella e formaggio Parmigiano Reggiano, il tutto cotto lentamente in forno fino a ottenere una crosta dorata e croccante. Un comfort food che scalda il cuore.','primo','onnivoro',5),(8,'Tiramisù','https://i.ibb.co/XYBT9t6/tiramisu.png',5.00,'latte','Il Tiramisù è un dolce al cucchiaio amato in tutto il mondo, con strati di savoiardi inzuppati nel caffè, alternati a una crema di mascarpone dolce e vellutata, spolverati con cacao amaro in polvere. Una combinazione perfetta di dolcezza, cremosità e un tocco di amarezza.','dessert','onnivoro',5),(9,'Hamburger','https://i.ibb.co/02F15bK/png-clipart-hamburger-veggie-burger-chicken-sandwich-fast-food-hamburger-burger-burger-sandwich-food.png',7.00,'sesamo','Un classico intramontabile dell\'America, l\'hamburger è un\'esplosione di gusto tra due morbidi panini, un succoso hamburger di manzo, croccante lattuga, pomodoro fresco, saporito formaggio cheddar e una generosa porzione di salse, servito con le iconiche patatine fritte.','secondo','onnivoro',6),(10,'Mac and Cheese','https://i.ibb.co/zx170cJ/mac-and-cheese.png',6.00,'glutine','Una comfort food amata da grandi e piccini, il Mac and Cheese è una prelibatezza cremosa e avvolgente di pasta cotta al dente arricchita con una densa salsa di formaggio, che si scioglie in bocca regalando un tripudio di sapori irresistibili.','primo','onnivoro',6),(11,'BBQ Ribs','https://i.ibb.co/p23jkQh/bbq-ribs.png',8.00,'latte','Le BBQ Ribs sono una vera e propria festa per il palato, con costine di maiale lentamente cotte al barbecue fino a raggiungere una tenera e succulenta consistenza. Rivestite con una salsa BBQ dolce e affumicata, ogni morso è una delizia appagante.','secondo','onnivoro',6),(12,'Apple Pie','https://i.ibb.co/yRVTTx7/apple-pie.png',4.00,'latte','La Apple Pie è un\'icona della pasticceria americana, con una croccante crosta di pasta brisée che racchiude uno strato di mele dolci e speziate, cotte lentamente fino a diventare morbide e succose. Servita calda con una pallina di gelato alla vaniglia, è il dolce perfetto per concludere un pasto.','dessert','onnivoro',6),(13,'Fried Chicken','https://i.ibb.co/b5kcGxy/chicken-fried.png',6.00,'glutine','Il Fried Chicken è un piatto comfort irresistibile, con pezzi di pollo marinati, impanati e fritti fino a raggiungere una croccantezza perfetta all\'esterno e una morbidezza succosa all\'interno. Servito con patatine fritte o biscotti al burro, è un piacere indulgente da gustare con le mani.','secondo','onnivoro',6),(14,'Sushi','https://i.ibb.co/Rj7QpkR/Sushi-PNG-Image.png',15.00,'pesce','Il sushi è un piatto giapponese iconico, composto da piccoli bocconi di riso conditi con aceto di riso e accompagnati da una varietà di ingredienti freschi come pesce crudo, gamberetti, avocado e cetriolo. Un equilibrio perfetto di sapori e consistenze.','primo','onnivoro',7),(15,'Ramen','https://i.ibb.co/rmszJcX/ramen.png',13.00,'uova','Il ramen è una zuppa giapponese composta da noodles di frumento serviti in un brodo ricco e aromatico, arricchito con carne di maiale, uova sode, cipolla verde e altri condimenti come alga nori e germogli di bambù. Un comfort food che scalda l\'anima.','primo','onnivoro',7),(16,'Tempura','https://i.ibb.co/r7q0C7H/tempura.png',9.00,'pesce','La tempura è una tecnica di frittura giapponese leggera e croccante, che prevede l\'immersione di verdure e frutti di mare in pastella e la loro cottura in olio caldo. Il risultato sono bocconcini croccanti e deliziosi, perfetti da gustare con salsa di immersione e daikon grattugiato.','secondo','onnivoro',7),(17,'Okonomiyaki','https://i.ibb.co/JrjGfLz/okonomiyaki.png',5.00,'pesce','L\'okonomiyaki è una specie di pancake giapponese a base di cavolo grattugiato e altri ingredienti a scelta, come carne di maiale, gamberetti o formaggio, cotti su una piastra e conditi con salsa okonomiyaki, maionese, alghe nori e fiocchi di bonito essiccati. Un piatto gustoso e versatile.','secondo','onnivoro',7),(18,'Gyoza','https://i.ibb.co/bQptg6Q/gyoza.png',4.00,'salsa di soia','I gyoza sono ravioli giapponesi ripieni di carne macinata di maiale o di pollo, verdure tritate e condimenti, chiusi a mezzaluna e poi cotti al vapore, fritti o in padella fino a raggiungere una consistenza croccante e dorata. Spesso serviti con salsa di soia, sono un antipasto popolare in Giappone.','secondo','onnivoro',7),(19,'Couscous alle Verdure Grigliate','https://i.ibb.co/bKDLP8b/couscous-alle-verdure-grigliate.png',9.00,'nessuno','Un piatto leggero e saporito composto da couscous cotto al vapore e arricchito con una varietà di verdure grigliate, come zucchine, melanzane, peperoni e pomodori, condite con olio d\'oliva, succo di limone e erbe aromatiche. Un\'opzione veggie colorata e gustosa.','primo','vegano',8),(20,'Pad Thai Vegetariano','https://i.ibb.co/tJ2T4BX/pad-thai-vegetariano.png',7.00,'uova','Una versione vegetariana del classico piatto thailandese, preparata con noodles di riso saltati in padella con tofu cubetti, uova strapazzate, germogli di soia, cipollotti e arachidi tritate, conditi con una salsa agrodolce a base di tamarindo e salsa di soia. Un\'esplosione di sapori orientali senza carne.','secondo','vegano',8),(21,'Hummus e Veggie Wrap','https://i.ibb.co/B6KMhPV/hummus-e-veggie-wrap.png',12.00,'nessuno','Un wrap leggero e nutriente farcito con hummus cremoso, fette di avocado maturo, falafel croccanti, cetrioli a fette sottili, pomodori a dadini e foglie di lattuga fresca, avvolto in una morbida tortilla integrale. Un\'opzione vegana ricca di proteine e fibre.','primo','vegano',8),(22,'Melanzane alla Parmigiana','https://i.ibb.co/SvbJZFq/melanzane-alla-parmigiana.png',12.00,'glutine','Un piatto italiano tradizionale composto da fette di melanzane grigliate, alternate con strati di salsa di pomodoro, mozzarella e parmigiano grattugiato, il tutto cotto al forno fino a ottenere una crosta dorata e croccante. Un\'esplosione di sapori mediterranei senza carne.','primo','vegano',8),(23,'Tacos Vegani con Salsa di Avocado','https://i.ibb.co/tbkKgz8/tacos-vegani-con-salsa-di-avocado.png',7.00,'fagioli','Tacos gustosi e colorati preparati con gusci di mais croccanti farciti con una miscela di fagioli neri speziati, peperoni arrostiti, mais dolce, salsa di pomodoro fresca e una cremosa salsa di avocado a base di avocado maturo, lime e coriandolo fresco. Un\'opzione tex-mex senza carne piena di sapore.','secondo','vegano',8),(24,'Insalata di Quinoa e Verdure','https://i.ibb.co/T1yXmJj/insalata-di-quinos-e-verdure.png',13.00,'nessuno','Un\'insalata leggera e nutriente preparata con quinoa cotta al dente, mix di verdure fresche come pomodori, cetrioli e peperoni, arricchita con foglie di spinaci freschi e condita con una vinaigrette leggera al limone. Un piatto ricco di fibre e proteine.','secondo','onnivoro',9),(25,'Wrap di Pollo e Avocado','https://i.ibb.co/V2YHTzc/wrap-pollo-e-avocado-Copia-Copia.png',15.00,'nessuno','Un wrap leggero e gustoso preparato con tortilla integrale farcita con fettine di pollo grigliato, avocado a fette, lattuga croccante e pomodori freschi, conditi con una salsa allo yogurt greco e erbe aromatiche. Un\'opzione equilibrata e ricca di proteine.','secondo','onnivoro',9),(26,'Zoodles alla Bolognese','https://i.ibb.co/1n0cZNf/zoodies-alla-bolognese-Copia-Copia.png',12.00,'glutine','Una versione \"fit\" del classico piatto italiano, con zucchine tagliate a spirale al posto della pasta tradizionale, condite con un sugo alla bolognese preparato con carne macinata magra, pomodori freschi e spezie aromatiche. Un\'alternativa leggera e saporita.','primo','onnivoro',9),(27,'Salmone al Vapore con Verdure','https://i.ibb.co/7QN0LRF/salmone-al-vapore-Copia.png',15.00,'pesce','Un piatto leggero e salutare preparato con filetti di salmone al vapore, serviti con una selezione di verdure croccanti come broccoli, carote e zucchine, condite con un filo di olio d\'oliva e succo di limone fresco. Una fonte eccellente di proteine e grassi sani.','primo','onnivoro',9),(28,'Smoothie Verde Detox','https://i.ibb.co/zQmnRHJ/smoothie-verde-detox.png',7.00,'frutta a guscio','Un smoothie verde rinfrescante e disintossicante preparato con una miscela di spinaci freschi, avocado maturo, kiwi, cetriolo e succo di lime, arricchito con un pizzico di zenzero fresco e semi di chia. Una bevanda ricca di antiossidanti e nutrienti essenziali.','dessert','onnivoro',9);
/*!40000 ALTER TABLE `cibo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `furgoni`
--

DROP TABLE IF EXISTS `furgoni`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `furgoni` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  `immagine` varchar(255) NOT NULL,
  `n_telefono` int NOT NULL,
  `descrizione` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `furgoni`
--

LOCK TABLES `furgoni` WRITE;
/*!40000 ALTER TABLE `furgoni` DISABLE KEYS */;
INSERT INTO `furgoni` VALUES (5,'Sapori D\'Italia','https://i.ibb.co/3YnyYBW/115958519-b9b96f29-13e4-4705-816c-9a97e2828473-removebg-preview.png%22%20alt=%22115958519-b9b96f29-13e4-4705-816c-9a97e2828473-removebg-preview',331988824,'Specializzato in piatti tradizionali come pasta fatta in casa, pizza napoletana e arancini siciliani, utilizza ingredienti freschi e di alta qualità. Includendo specialità regionali e opzioni vegetariane. La presenza del truck food in vari eventi e festival garantisce una deliziosa immersione nella cucina italiana ovunque si trovi. Con un\'atmosfera accogliente e un servizio amichevole,  porta i sapori della tradizione italiana direttamente ai suoi clienti.'),(6,'Grill Masters','https://i.ibb.co/ZM9bFC6/092212250-ae74af60-d599-481f-9d23-bde9f43c309c-removebg-preview.png%22%20alt=%22092212250-ae74af60-d599-481f-9d23-bde9f43c309c-removebg-preview',331898989,'Grill Masters è un truck food specializzato in deliziose grigliate. Offriamo una selezione di carni succulente, hamburger gourmet e salsicce artigianali. Utilizziamo solo ingredienti freschi e di alta qualità per garantire il miglior sapore. Perfetto per gli amanti del barbecue, ci trovi in vari eventi e festival. Vieni a trovarci'),(7,'Sushi On Wheels ','https://i.ibb.co/4RSc6N2/Rolling-Yatai-Driver-Side-1-removebg-preview.png%22%20alt=%22Rolling-Yatai-Driver-Side-1-removebg-preview',331787878,'Sushi On Wheels porta l\'autentica cucina giapponese direttamente a te. Specializzati in sushi fresco, sashimi e roll creativi, usiamo solo pesce di alta qualità e ingredienti freschi. Perfetto per eventi, festival e pranzi veloci, offriamo anche opzioni vegetariane e vegane. Con un servizio rapido e cordiale, trasformiamo ogni pasto in un\'esperienza unica. Vieni a scoprire la nostra vasta gamma di deliziosi piatti giapponesi.'),(8,'Veggie Van','https://i.ibb.co/3zf60v2/48202bcd744a4d309014413bcbd0370a-removebg-preview.png%22%20alt=%2248202bcd744a4d309014413bcbd0370a-removebg-preview',331999999,'Veggie Van è un paradiso per gli amanti del cibo vegetariano e vegano. Offriamo una vasta selezione di piatti senza carne, realizzati con ingredienti freschi e di stagione. Dal gustoso burger di verdure al wrap mediterraneo, ogni opzione è pensata per soddisfare i palati più esigenti. Con un\'attenzione particolare alla sostenibilità e al benessere, Veggie Van è la scelta perfetta per coloro che cercano un\'alternativa gustosa e salutare.'),(9,'Olimpya Food','https://i.ibb.co/kGxyfpT/vegan-food-truck-1024x623-removebg-preview.png%22%20alt=%22vegan-food-truck-1024x623-removebg-preview',331909090,'Olympia Food offre un\'ampia selezione di piatti pensati per gli amanti del fitness e dei palestrati. Dal gustoso pollo alla griglia alle insalate ricche di proteine, ogni opzione è progettata per fornire nutrienti essenziali per il recupero muscolare e la salute generale. Utilizziamo solo ingredienti freschi e di alta qualità, senza compromessi sul gusto. Con un menu adatto alle esigenze nutrizionali degli sportivi e un servizio rapido e cordiale, Olympia Food è la scelta perfetta per coloro che cercano cibo sano e delizioso on-the-go.');
/*!40000 ALTER TABLE `furgoni` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordine_dettaglio`
--

DROP TABLE IF EXISTS `ordine_dettaglio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordine_dettaglio` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ordine_id` int NOT NULL,
  `cibo_id` int NOT NULL,
  `quantita` int NOT NULL,
  `prezzo` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordine_dettaglio`
--

LOCK TABLES `ordine_dettaglio` WRITE;
/*!40000 ALTER TABLE `ordine_dettaglio` DISABLE KEYS */;
INSERT INTO `ordine_dettaglio` VALUES (21,16,8,2,5),(22,16,4,2,8),(23,16,7,1,10);
/*!40000 ALTER TABLE `ordine_dettaglio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordini`
--

DROP TABLE IF EXISTS `ordini`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordini` (
  `id` int NOT NULL AUTO_INCREMENT,
  `utenti_id` int NOT NULL,
  `data` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordini`
--

LOCK TABLES `ordini` WRITE;
/*!40000 ALTER TABLE `ordini` DISABLE KEYS */;
INSERT INTO `ordini` VALUES (16,11,'2024-05-28T12:08:11.179Z');
/*!40000 ALTER TABLE `ordini` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utenti`
--

DROP TABLE IF EXISTS `utenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utenti` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nome` varchar(55) NOT NULL,
  `cognome` varchar(55) NOT NULL,
  `ruolo` varchar(45) NOT NULL,
  `username` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utenti`
--

LOCK TABLES `utenti` WRITE;
/*!40000 ALTER TABLE `utenti` DISABLE KEYS */;
INSERT INTO `utenti` VALUES (6,'andreadifioree@gmail.com','andrea1sd23','andrea','adf','user',NULL),(11,'andrea@andrea.it','AAaa22%%223aa','andrea','di fiore','admin','andrea12');
/*!40000 ALTER TABLE `utenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-28 15:40:43
