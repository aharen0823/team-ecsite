SET foreign_key_checks=1;

USE teamdb;

INSERT INTO mst_user
(user_name, password, family_name, first_name, family_name_kana, first_name_kana, gender)
VALUES ('taro@gmail.com', '111111', '山田', '太郎', 'やまだ', 'たろう', 0);

INSERT INTO mst_category (category_name,category_description) VALUES
('sports', 'sportsカテゴリーはboxingとsoccerです'),
('bitsAndPieces', 'bitsAndPiecesカテゴリーはhumanとfriendです'),
('music', 'musicカテゴリーはkaraokeとbgmです');


INSERT INTO mst_product(product_name,product_name_kana,product_description,category_id,price,image_full_path,release_date,release_company) VALUES 
('soccer','さっかー','サッカーを一緒にしてくれる',1,550,'/img/soccernohito.JPG','2024/06/13','ひと、かします'),
('boxing','ぼくしんぐ','ボクシングを一緒にしてくれる',1,350,'/img/boxingnohito.jpg','2024/06/13','ひと、かします'),
('human','ひゅーまん','雑用や話を聞いたりしてくれる',2,450,'/img/gutinohito.jpg','2024/06/13','ひと、かします'),
('friend','ふれんど','1日友達になってくれます',2,1100,'/img/tomodatinohito.jpg','2024/06/13','ひと、かします'),
('karaoke','からおけ','カラオケを一緒にしてくれる',3,700,'/img/karaokenohito.jpg','2024/06/13','ひと、かします'),
('bgm','びーじーえむ','結婚式等で楽器の演奏をしてくれます',3,900,'/img/Musicnohito.jpg','2024/06/13','ひと、かします');
