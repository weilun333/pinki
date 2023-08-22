CREATE DATABASE  IF NOT EXISTS `pinki` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pinki`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pinki
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `about_as`
--

DROP TABLE IF EXISTS `about_as`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `about_as` (
  `info_no` int NOT NULL AUTO_INCREMENT COMMENT '資訊編號',
  `contact_title` varchar(50) NOT NULL COMMENT '聯絡標題',
  `contact_content` text NOT NULL COMMENT '聯絡內容 ',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`info_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='關於我們';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `about_as`
--

LOCK TABLES `about_as` WRITE;
/*!40000 ALTER TABLE `about_as` DISABLE KEYS */;
/*!40000 ALTER TABLE `about_as` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_no` int NOT NULL AUTO_INCREMENT COMMENT '管理員編號',
  `admin_name` varchar(50) NOT NULL COMMENT '管理員名稱',
  `admin_account` varchar(20) NOT NULL COMMENT '管理員帳號',
  `admin_password` varchar(50) NOT NULL COMMENT '管理員密碼',
  `admin_status` tinyint(1) NOT NULL COMMENT '帳號狀態',
  `create_user` varchar(20) NOT NULL COMMENT '帳號創建者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間',
  PRIMARY KEY (`admin_no`),
  UNIQUE KEY `admin_account_UNIQUE` (`admin_account`),
  UNIQUE KEY `admin_name_UNIQUE` (`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理員帳號';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_permission`
--

DROP TABLE IF EXISTS `admin_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_permission` (
  `admin_no` int NOT NULL AUTO_INCREMENT COMMENT '管理員編號',
  `permission_no` int NOT NULL COMMENT '權限編號',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`admin_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理員權限';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_permission`
--

LOCK TABLES `admin_permission` WRITE;
/*!40000 ALTER TABLE `admin_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `admin_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bank_account`
--

DROP TABLE IF EXISTS `bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bank_account` (
  `account_no` int NOT NULL AUTO_INCREMENT COMMENT '帳戶編號',
  `payment_method_no` int NOT NULL COMMENT '支付方式編號',
  `account_number` varchar(20) NOT NULL COMMENT '卡號',
  `bank_no` varchar(3) DEFAULT NULL COMMENT '銀行代碼',
  `expire_date` varchar(4) DEFAULT NULL COMMENT '到期月年',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間',
  PRIMARY KEY (`account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='銀行帳號總表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bank_account`
--

LOCK TABLES `bank_account` WRITE;
/*!40000 ALTER TABLE `bank_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `bank_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `brand_no` int NOT NULL AUTO_INCREMENT COMMENT '品牌編號',
  `brand_name` varchar(100) NOT NULL COMMENT '品牌名稱',
  `designer_account` varchar(20) NOT NULL COMMENT '設計師帳號',
  `designer_password` varchar(50) NOT NULL COMMENT '設計師密碼',
  `tax_id_no` varchar(20) NOT NULL COMMENT '統一編號',
  `brand_tel` varchar(20) DEFAULT NULL COMMENT '電話',
  `brand_addr` varchar(50) DEFAULT NULL COMMENT '地址',
  `bank_account_no` int NOT NULL COMMENT '收款帳戶',
  `brand_story` varchar(500) NOT NULL COMMENT '品牌簡介',
  `brand_logo` blob NOT NULL COMMENT '品牌logo',
  `cover_pic` blob NOT NULL COMMENT '封面照片',
  `designer_status` tinyint(1) NOT NULL COMMENT '設計師帳號狀態',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間',
  PRIMARY KEY (`brand_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='品牌';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collected_designer`
--

DROP TABLE IF EXISTS `collected_designer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collected_designer` (
  `member_no` int NOT NULL COMMENT '會員編號',
  `brand_no` int NOT NULL COMMENT '品牌編號',
  PRIMARY KEY (`member_no`,`brand_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='使用者收藏設計師';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collected_designer`
--

LOCK TABLES `collected_designer` WRITE;
/*!40000 ALTER TABLE `collected_designer` DISABLE KEYS */;
/*!40000 ALTER TABLE `collected_designer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `collected_product`
--

DROP TABLE IF EXISTS `collected_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `collected_product` (
  `member_no` int NOT NULL COMMENT '會員編號',
  `prod_no` int NOT NULL COMMENT '商品編號',
  PRIMARY KEY (`member_no`,`prod_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='使用者收藏商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `collected_product`
--

LOCK TABLES `collected_product` WRITE;
/*!40000 ALTER TABLE `collected_product` DISABLE KEYS */;
/*!40000 ALTER TABLE `collected_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `common_question`
--

DROP TABLE IF EXISTS `common_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `common_question` (
  `question_no` int NOT NULL AUTO_INCREMENT COMMENT '常見問題編號',
  `question_title` varchar(200) NOT NULL COMMENT '問題名稱',
  `answer_content` text NOT NULL COMMENT '回覆內容',
  `sort` int NOT NULL COMMENT '排序',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`question_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='常見問題';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `common_question`
--

LOCK TABLES `common_question` WRITE;
/*!40000 ALTER TABLE `common_question` DISABLE KEYS */;
/*!40000 ALTER TABLE `common_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily_check_in_config`
--

DROP TABLE IF EXISTS `daily_check_in_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daily_check_in_config` (
  `check_in_no` int NOT NULL AUTO_INCREMENT COMMENT '簽報設定編號',
  `level_no` int NOT NULL COMMENT '等級編號',
  `check_in_point` int NOT NULL COMMENT '簽到點數',
  `increase_point` int NOT NULL COMMENT '連續簽到增加點數',
  `max_day` int NOT NULL COMMENT '最多簽到天數',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`check_in_no`),
  UNIQUE KEY `level_no_UNIQUE` (`level_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='每日簽到設定';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_check_in_config`
--

LOCK TABLES `daily_check_in_config` WRITE;
/*!40000 ALTER TABLE `daily_check_in_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_check_in_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `daily_check_in_log`
--

DROP TABLE IF EXISTS `daily_check_in_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `daily_check_in_log` (
  `check_in_no` int NOT NULL AUTO_INCREMENT COMMENT '簽到領取紀錄編號',
  `member_no` int NOT NULL COMMENT '會員編號',
  `receive_point` int NOT NULL COMMENT '領取點數',
  `total_receive_day` int NOT NULL COMMENT '領取天數 (累積)',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`check_in_no`),
  UNIQUE KEY `member_No_UNIQUE` (`member_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='每日簽到領取紀錄';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `daily_check_in_log`
--

LOCK TABLES `daily_check_in_log` WRITE;
/*!40000 ALTER TABLE `daily_check_in_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `daily_check_in_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_fee`
--

DROP TABLE IF EXISTS `delivery_fee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_fee` (
  `deliver_no` int NOT NULL AUTO_INCREMENT COMMENT '運費編號',
  `brand_no` int NOT NULL COMMENT '品牌編號',
  `prod_size` int NOT NULL COMMENT '商品體積',
  `deliver_fee` int NOT NULL COMMENT '運費金額',
  `free_delivery_amount` int NOT NULL COMMENT '免運金額',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  PRIMARY KEY (`deliver_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='運費';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_fee`
--

LOCK TABLES `delivery_fee` WRITE;
/*!40000 ALTER TABLE `delivery_fee` DISABLE KEYS */;
/*!40000 ALTER TABLE `delivery_fee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `member_no` int NOT NULL AUTO_INCREMENT COMMENT '會員編號',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `mail` varchar(100) NOT NULL COMMENT '信箱',
  `member_password` varchar(50) NOT NULL COMMENT '會員密碼',
  `subscription` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否訂閱最新消息 (1:訂閱 0:未訂閱)',
  `tel` varchar(20) DEFAULT NULL COMMENT '聯絡電話',
  `level_no` int NOT NULL DEFAULT '1' COMMENT '會員等級編號',
  `address` varchar(200) DEFAULT NULL COMMENT '地址',
  `member_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '帳號狀態 (:1啟用 0:未啟用)',
  `coins` int NOT NULL DEFAULT '0' COMMENT '點數',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '註冊時間',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`member_no`),
  UNIQUE KEY `mail_UNIQUE` (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='會員';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member_level`
--

DROP TABLE IF EXISTS `member_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member_level` (
  `level_no` int NOT NULL AUTO_INCREMENT COMMENT '等級編號',
  `level_name` varchar(50) NOT NULL COMMENT '等級名稱',
  `upper_total_amount` int NOT NULL COMMENT '累計消費金額上限',
  `lower_total_amount` int NOT NULL COMMENT '累計消費金額下限',
  `one_time_consumption` int NOT NULL COMMENT '單次消費金額',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`level_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='會員等級設定';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member_level`
--

LOCK TABLES `member_level` WRITE;
/*!40000 ALTER TABLE `member_level` DISABLE KEYS */;
/*!40000 ALTER TABLE `member_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment_method`
--

DROP TABLE IF EXISTS `payment_method`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment_method` (
  `payment_method_no` int NOT NULL AUTO_INCREMENT COMMENT '付款方式編號',
  `payment_method_name` varchar(100) NOT NULL COMMENT '付款方式名稱',
  `is_enable` tinyint(1) NOT NULL COMMENT '是否啟用 (0:不啟用 1:啟用)',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間',
  PRIMARY KEY (`payment_method_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='付款方式';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment_method`
--

LOCK TABLES `payment_method` WRITE;
/*!40000 ALTER TABLE `payment_method` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment_method` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `permission` (
  `permission_no` int NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(100) NOT NULL,
  PRIMARY KEY (`permission_no`),
  UNIQUE KEY `permission_name_UNIQUE` (`permission_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='權限列表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prod_category`
--

DROP TABLE IF EXISTS `prod_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prod_category` (
  `prod_category_no` int NOT NULL AUTO_INCREMENT COMMENT '商品類別編號',
  `prod_category_name` varchar(50) NOT NULL COMMENT '商品類別名稱',
  PRIMARY KEY (`prod_category_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品類別';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prod_category`
--

LOCK TABLES `prod_category` WRITE;
/*!40000 ALTER TABLE `prod_category` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prod_info`
--

DROP TABLE IF EXISTS `prod_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prod_info` (
  `prod_no` int NOT NULL AUTO_INCREMENT COMMENT '商品編號',
  `prod_pic_no` int NOT NULL COMMENT '商品圖片編號',
  `brand_no` int NOT NULL COMMENT '品牌編號',
  `prod_category_no` int NOT NULL COMMENT '商品類別編號',
  `prod_name` varchar(50) NOT NULL COMMENT '商品名稱',
  `prod_price` int NOT NULL COMMENT '商品價格',
  `prod_stock` int NOT NULL COMMENT '庫存數量',
  `prod_specification` varchar(200) NOT NULL COMMENT '商品規格',
  `prod_content` varchar(200) NOT NULL COMMENT '商品詳情',
  `prod_size` int NOT NULL COMMENT '商品體積',
  `prod_status` tinyint(1) NOT NULL DEFAULT '1' COMMENT '商品狀態 (0: 未上架 1:上架)',
  `prod_release_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '商品預定上架時間',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`prod_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品資訊';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prod_info`
--

LOCK TABLES `prod_info` WRITE;
/*!40000 ALTER TABLE `prod_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prod_order`
--

DROP TABLE IF EXISTS `prod_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prod_order` (
  `prod_order_no` int NOT NULL AUTO_INCREMENT COMMENT '訂單編號',
  `member_no` int NOT NULL COMMENT '會員編號',
  `brand_no` int NOT NULL COMMENT '品牌編號',
  `order_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '訂單狀態 (0: 未完成 1:已完成 2:貨物已送出 3:退貨 4: 取消訂單)',
  `prod_order_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '訂單成立時間',
  `prod_deliver_time` timestamp NULL DEFAULT NULL COMMENT '出貨時間',
  `prod_order_receive_time` timestamp NULL DEFAULT NULL COMMENT '送達時間',
  `deliver_fee` int NOT NULL COMMENT '運費',
  `total_amount` int NOT NULL COMMENT '訂單總金額',
  `used_coins` int NOT NULL COMMENT '使用點數',
  `activity_no` int DEFAULT NULL COMMENT '優惠活動編號',
  `discount_amount` int DEFAULT NULL COMMENT '折扣金額',
  `final_amount` int NOT NULL COMMENT '訂單最後金額',
  `bonus_point` int NOT NULL COMMENT '紅利點數',
  `receiver_name` varchar(20) NOT NULL COMMENT '收件者姓名',
  `receiver_tel` varchar(20) NOT NULL COMMENT '收件者電話',
  `receiver_mail` varchar(100) NOT NULL COMMENT '收件者mail',
  `receiver_addr` varchar(100) NOT NULL COMMENT '收件地址',
  `invoice_number` varchar(20) DEFAULT NULL COMMENT '發票號碼',
  `tax_id_number` varchar(8) DEFAULT NULL COMMENT '統一編號',
  `payment_method_no` int NOT NULL COMMENT '付款方式 (1: 貨到付款 2: 銀行轉帳 3: 信用卡付款)',
  `payment_time` timestamp NULL DEFAULT NULL,
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`prod_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品訂單';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prod_order`
--

LOCK TABLES `prod_order` WRITE;
/*!40000 ALTER TABLE `prod_order` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prod_order_detail`
--

DROP TABLE IF EXISTS `prod_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prod_order_detail` (
  `prod_order_no` int NOT NULL AUTO_INCREMENT COMMENT '商品訂單編號',
  `prod_no` int NOT NULL COMMENT '商品編號',
  `prod_qty` int NOT NULL COMMENT '商品數量',
  `prod_price` int NOT NULL COMMENT '商品價格',
  `order_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '訂單狀態 ',
  `prod_comment_rating` double DEFAULT NULL COMMENT '評論星等',
  `prod_comment_content` varchar(500) DEFAULT NULL COMMENT '評論內容',
  `prod_comment_pic` blob COMMENT '評論圖片',
  `prod_comment_time` timestamp NULL DEFAULT NULL COMMENT '評論時間',
  `designer_replay` varchar(500) DEFAULT NULL COMMENT '設計師回覆評論',
  `designer_replay_time` timestamp NULL DEFAULT NULL COMMENT '設計師回覆時間',
  PRIMARY KEY (`prod_order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品訂單明細';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prod_order_detail`
--

LOCK TABLES `prod_order_detail` WRITE;
/*!40000 ALTER TABLE `prod_order_detail` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_order_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prod_pic`
--

DROP TABLE IF EXISTS `prod_pic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prod_pic` (
  `prod_pic_no` int NOT NULL AUTO_INCREMENT COMMENT '商品圖片編號',
  `prod_no` int NOT NULL COMMENT '商品編號',
  `prod_pic` blob NOT NULL COMMENT '商品圖片',
  `prod_pic_remark` varchar(50) DEFAULT NULL COMMENT '商品圖片說明',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`prod_pic_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品圖片';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prod_pic`
--

LOCK TABLES `prod_pic` WRITE;
/*!40000 ALTER TABLE `prod_pic` DISABLE KEYS */;
/*!40000 ALTER TABLE `prod_pic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_supplement_notification`
--

DROP TABLE IF EXISTS `product_supplement_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_supplement_notification` (
  `supplement_notify_no` int NOT NULL AUTO_INCREMENT COMMENT '補貨通知編號',
  `prod_no` int NOT NULL,
  `member_no` int NOT NULL,
  `notify_status` tinyint(1) NOT NULL DEFAULT '0' COMMENT '通知狀態 (0: 未通知 1:已通知)',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`supplement_notify_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='商品補貨通知';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_supplement_notification`
--

LOCK TABLES `product_supplement_notification` WRITE;
/*!40000 ALTER TABLE `product_supplement_notification` DISABLE KEYS */;
/*!40000 ALTER TABLE `product_supplement_notification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `promotion_activity`
--

DROP TABLE IF EXISTS `promotion_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `promotion_activity` (
  `activity_no` int NOT NULL AUTO_INCREMENT COMMENT '活動編號',
  `brand_no` int NOT NULL COMMENT '品牌編號',
  `prod_category_no` int NOT NULL COMMENT '商品類別',
  `discount` double NOT NULL COMMENT '折價',
  `start_time` timestamp NOT NULL COMMENT '起始時間',
  `end_time` timestamp NOT NULL COMMENT '結束時間',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間',
  PRIMARY KEY (`activity_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='優惠活動';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `promotion_activity`
--

LOCK TABLES `promotion_activity` WRITE;
/*!40000 ALTER TABLE `promotion_activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `promotion_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recommend_prod`
--

DROP TABLE IF EXISTS `recommend_prod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recommend_prod` (
  `recommend_prod_no` int NOT NULL AUTO_INCREMENT COMMENT '推薦商品編號',
  `prod_no` int NOT NULL COMMENT '商品編號',
  PRIMARY KEY (`recommend_prod_no`),
  UNIQUE KEY `prod_UNIQUE` (`prod_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='推薦商品';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recommend_prod`
--

LOCK TABLES `recommend_prod` WRITE;
/*!40000 ALTER TABLE `recommend_prod` DISABLE KEYS */;
/*!40000 ALTER TABLE `recommend_prod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopping_cart` (
  `member_no` int NOT NULL COMMENT '會員編號',
  `prod_no` int NOT NULL COMMENT '商品編號',
  `prod_qty` int NOT NULL COMMENT '商品數量',
  PRIMARY KEY (`member_no`,`prod_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='購物車';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopping_cart`
--

LOCK TABLES `shopping_cart` WRITE;
/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `system_announcement`
--

DROP TABLE IF EXISTS `system_announcement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `system_announcement` (
  `announcement_no` int NOT NULL AUTO_INCREMENT COMMENT '公告編號',
  `announcement_title` varchar(200) NOT NULL COMMENT '公告標題',
  `announcement_content` text NOT NULL COMMENT '公告內容',
  `top_switch` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否置頂',
  `display_switch` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否顯示',
  `declaration_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `create_user` varchar(20) NOT NULL COMMENT '建立者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間',
  PRIMARY KEY (`announcement_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系統公告';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `system_announcement`
--

LOCK TABLES `system_announcement` WRITE;
/*!40000 ALTER TABLE `system_announcement` DISABLE KEYS */;
/*!40000 ALTER TABLE `system_announcement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `terms_of_service`
--

DROP TABLE IF EXISTS `terms_of_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `terms_of_service` (
  `terms_no` int NOT NULL AUTO_INCREMENT COMMENT '條款編號',
  `terms_title` varchar(100) NOT NULL COMMENT '條款標題',
  `terms_content` text NOT NULL COMMENT '條款內容',
  `create_user` varchar(20) NOT NULL COMMENT '建立者',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '建立時間',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間 ',
  PRIMARY KEY (`terms_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='服務條款';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `terms_of_service`
--

LOCK TABLES `terms_of_service` WRITE;
/*!40000 ALTER TABLE `terms_of_service` DISABLE KEYS */;
/*!40000 ALTER TABLE `terms_of_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usual_bank_account`
--

DROP TABLE IF EXISTS `usual_bank_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usual_bank_account` (
  `bank_account_no` int NOT NULL AUTO_INCREMENT COMMENT '常用帳戶編號',
  `member_type` tinyint(1) NOT NULL COMMENT '會員類別 (會員/品牌) (1: 會員 2:品牌)',
  `member_no` int NOT NULL COMMENT '會員/品牌編號',
  `account_no` varchar(45) NOT NULL COMMENT '帳戶編號',
  `process_user` varchar(20) NOT NULL COMMENT '最後更新者',
  `last_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '最後更新時間',
  PRIMARY KEY (`bank_account_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='常用帳號';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usual_bank_account`
--

LOCK TABLES `usual_bank_account` WRITE;
/*!40000 ALTER TABLE `usual_bank_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `usual_bank_account` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-08-22 14:25:33
