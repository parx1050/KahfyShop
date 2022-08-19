INSERT INTO `members` VALUES 
	(1,'Alex Brown','alexbrown@gmail.com',135,'alexbrown'),
	(2,'Cassidy Dell','cassidydell@gmail.com',0,'cassidydell'),
	(3,'Emily Foss','emilyfoss@gmail.com',34,'emilyfoss'),
	(4,'Gerald Hank','geraldhank@gmail.com',423,'geraldhank'),
	(5,'Ivan Johnson','ivanjohnson@gmail.com',94,'ivanjohnson');
    
INSERT INTO `products` VALUES 
	(1,'Latte','Espresso mixed with steamed milk.',3.90,3),
	(2,'Cappuccino','Espresso mixed with steamed milk and topped with extra foam.',5.30,5),
	(3,'Espresso','A single shot of espresso.',1.40,1),
	(4,'Water','A bottle of water.',0.00,0),
	(5,'Flat White','Ristretto shots of espresso mixed with steamed whole milk.',4.20,4);
    
INSERT INTO `shopping_session` VALUES 
	(1,3,14.80,0),
    (2,5,2.80,0),
    (3,2,72.50,0);
    
INSERT INTO `cart_item` VALUES 
	(1,1,2,2,0,10,10.60),
    (2,1,5,1,0,4,4.20),
	(3,2,3,2,0,2,2.80),
	(4,3,1,5,0,15,19.50),
	(5,3,4,3,0,0,0.00),
    (6,3,2,10,0,50,53.00);