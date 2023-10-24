DROP TABLE IF EXISTS reservation;

CREATE TABLE `reservation` (
  `reservation_id` int NOT NULL AUTO_INCREMENT,
  `room_id` int NOT NULL,
  `start_dt` date NOT NULL,
  `finish_dt` date NOT NULL,
  PRIMARY KEY (`reservation_id`)
);

INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 1, '2023-04-21', '2023-04-25');
 
INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 1, '2023-05-01', '2023-05-04');
 
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 2, '2023-05-01', '2023-05-04');
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 2, '2023-05-01', '2023-05-04');
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 2, '2023-05-01', '2023-05-04');
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 2, '2023-05-01', '2023-05-04');
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 2, '2023-05-01', '2023-05-04');
 
  INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 3, '2023-05-01', '2023-05-04');
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 3, '2023-05-01', '2023-05-04');
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 4, '2023-05-01', '2023-05-04');
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 4, '2023-05-01', '2023-05-04');
 INSERT INTO `reservation` (`room_id`, `start_dt`, `finish_dt`)
 VALUES ( 4, '2023-05-01', '2023-05-04');
 