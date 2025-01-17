/*
 Navicat Premium Dump SQL

 Source Server         : localhost
 Source Server Type    : MariaDB
 Source Server Version : 100432 (10.4.32-MariaDB)
 Source Host           : localhost:3306
 Source Schema         : movie_db

 Target Server Type    : MariaDB
 Target Server Version : 100432 (10.4.32-MariaDB)
 File Encoding         : 65001

 Date: 27/12/2024 17:45:12
*/

SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for actors
-- ----------------------------
DROP TABLE IF EXISTS `actors`;
CREATE TABLE `actors`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for directors
-- ----------------------------
DROP TABLE IF EXISTS `directors`;
CREATE TABLE `directors`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for food_combos
-- ----------------------------
DROP TABLE IF EXISTS `food_combos`;
CREATE TABLE `food_combos`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `price`       decimal(10, 2)                                                NOT NULL,
    `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `status`      enum('active','inactive') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'active',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for food_ticket_items
-- ----------------------------
DROP TABLE IF EXISTS `food_ticket_items`;
CREATE TABLE `food_ticket_items`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `userId` int(11) NOT NULL,
    `comboId`      int(11) NOT NULL,
    `price`   decimal(10, 2) NOT NULL,
    'quantity' int(50)  NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX          `userId`(`userId`) USING BTREE,
    INDEX          `comboId`(`comboId`) USING BTREE,
    CONSTRAINT `food_ticket_items_ibfk_1` FOREIGN KEY (`userID`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `food_ticket_items_ibfk_2` FOREIGN KEY (`comboId`) REFERENCES `food_combos` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for food_tickets
-- ----------------------------
DROP TABLE IF EXISTS `food_tickets`;
CREATE TABLE `food_tickets`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `totalPrice` decimal(10, 2) NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for genres
-- ----------------------------
DROP TABLE IF EXISTS `genres`;
CREATE TABLE `genres`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `genre` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for movie_actors
-- ----------------------------
DROP TABLE IF EXISTS `movie_actors`;
CREATE TABLE `movie_actors`
(
    `movieId` int(11) NOT NULL,
    `actorId` int(11) NOT NULL,
    PRIMARY KEY (`movieId`, `actorId`) USING BTREE,
    INDEX     `actorId`(`actorId`) USING BTREE,
    CONSTRAINT `movie_actors_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `movie_actors_ibfk_2` FOREIGN KEY (`actorId`) REFERENCES `actors` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for movie_directors
-- ----------------------------
DROP TABLE IF EXISTS `movie_directors`;
CREATE TABLE `movie_directors`
(
    `movieId`    int(11) NOT NULL,
    `directorId` int(11) NOT NULL,
    PRIMARY KEY (`movieId`, `directorId`) USING BTREE,
    INDEX        `directorId`(`directorId`) USING BTREE,
    CONSTRAINT `movie_directors_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `movie_directors_ibfk_2` FOREIGN KEY (`directorId`) REFERENCES `directors` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for movie_genres
-- ----------------------------
DROP TABLE IF EXISTS `movie_genres`;
CREATE TABLE `movie_genres`
(
    `movieId` int(11) NOT NULL,
    `genreId` int(11) NOT NULL,
    PRIMARY KEY (`movieId`, `genreId`) USING BTREE,
    INDEX     `genreId`(`genreId`) USING BTREE,
    CONSTRAINT `movie_genres_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `movie_genres_ibfk_2` FOREIGN KEY (`genreId`) REFERENCES `genres` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for movie_tickets
-- ----------------------------
DROP TABLE IF EXISTS `movie_tickets`;
CREATE TABLE `movie_tickets`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `showtimeId`    int(11) NOT NULL,
    `userId` int(11) NOT NULL,
    `seatId`     int(11) NOT NULL,
    `price`      decimal(10, 2) NOT NULL,
    `created_at` timestamp      NOT NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`id`) USING BTREE,
    INDEX        `orderId`(`showtimeId`) USING BTREE,
    INDEX        `userId`(`userId`) USING BTREE,
    INDEX        `seatId`(`seatId`) USING BTREE,
    CONSTRAINT `movie_tickets_ibfk_1` FOREIGN KEY (`showtimeId`) REFERENCES `showtimes` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `movie_tickets_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `movie_tickets_ibfk_3` FOREIGN KEY (`seatId`) REFERENCES `seats` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for movies
-- ----------------------------
DROP TABLE IF EXISTS `movies`;
CREATE TABLE `movies`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `title`       varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `duration`    int(11) NOT NULL,
    `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `country`     varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `language`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `subtitle`    varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `ageRating`   varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `releaseDate` date NULL DEFAULT NULL,
    `endDate`     date NULL DEFAULT NULL,
    `bannerUrl`   varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `posterUrl`   varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `status`      enum('active','inactive') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'active',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT,
    `userId`       int(11) NOT NULL,
    `totalPrice`   decimal(10, 2) NOT NULL,
    `order_date`   timestamp      NOT NULL DEFAULT current_timestamp(),
    `foodTicketId` int(11) NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX          `userId`(`userId`) USING BTREE,
    INDEX          `foodTicketId`(`foodTicketId`) USING BTREE,
    CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `orders_ibfk_2` FOREIGN KEY (`foodTicketId`) REFERENCES `food_tickets` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for rooms
-- ----------------------------
DROP TABLE IF EXISTS `rooms`;
CREATE TABLE `rooms`
(
    `id`        int(11) NOT NULL AUTO_INCREMENT,
    `name`      varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `style`     varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
    `occupancy` int(11) NULL DEFAULT NULL,
    `status`    enum('active','inactive') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'active',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for seats
-- ----------------------------
DROP TABLE IF EXISTS `seats`;
CREATE TABLE `seats`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `roomId`      int(11) NOT NULL,
    `row`         varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `seat_number` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `price`       decimal(10, 2)                                              NOT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX         `roomId`(`roomId`) USING BTREE,
    CONSTRAINT `seats_ibfk_1` FOREIGN KEY (`roomId`) REFERENCES `rooms` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for showtime_seats
-- ----------------------------
DROP TABLE IF EXISTS `showtime_seats`;
CREATE TABLE `showtime_seats`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `showTimeId` int(11) NOT NULL,
    `seatId`     int(11) NOT NULL,
    `status`     enum('available','reserved','booked') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'available',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `showTimeId`(`showTimeId`, `seatId`) USING BTREE,
    INDEX        `seatId`(`seatId`) USING BTREE,
    CONSTRAINT `showtime_seats_ibfk_1` FOREIGN KEY (`showTimeId`) REFERENCES `showtimes` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
    CONSTRAINT `showtime_seats_ibfk_2` FOREIGN KEY (`seatId`) REFERENCES `seats` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for showtimes
-- ----------------------------
DROP TABLE IF EXISTS `showtimes`;
CREATE TABLE `showtimes`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `movieId`  int(11) NOT NULL,
    `roomId`   int(11) NOT NULL,
    `showDate` date NOT NULL,
    `showTime` time NOT NULL,
    `status`   enum('active','inactive') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'active',
    PRIMARY KEY (`id`) USING BTREE,
    INDEX      `movieId`(`movieId`) USING BTREE,
    INDEX      `roomId`(`roomId`) USING BTREE,
    CONSTRAINT `showtimes_ibfk_1` FOREIGN KEY (`movieId`) REFERENCES `movies` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
    CONSTRAINT `showtimes_ibfk_2` FOREIGN KEY (`roomId`) REFERENCES `rooms` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`
(
    `id`       int(11) NOT NULL AUTO_INCREMENT,
    `name`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `email`    varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `dob`      date                                                          NOT NULL,
    `phone`    varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci  NOT NULL,
    `role`     int(11) NOT NULL,
    `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
    `status`   enum('active','inactive') CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT 'active',
    PRIMARY KEY (`id`) USING BTREE,
    UNIQUE INDEX `email`(`email`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET
FOREIGN_KEY_CHECKS = 1;
