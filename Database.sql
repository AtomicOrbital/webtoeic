DROP DATABASE IF EXISTS webtoeic;
CREATE DATABASE webtoeic;
USE webtoeic;

DROP TABLE IF EXISTS `bai_grammar`;
CREATE TABLE `bai_grammar` (
  `baigrammarid` int NOT NULL AUTO_INCREMENT,
  `anhbaigrammar` varchar(255) DEFAULT NULL,
  `content_html` mediumtext,
  `content_mark_down` text,
  `tenbaigrammar` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`baigrammarid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8;



CREATE TABLE `nguoi_dung` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dia_chi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `so_dien_thoai` varchar(255) DEFAULT NULL,
  `vai_tro` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



CREATE TABLE `comment_grammar` (
  `cmtgrammarid` int NOT NULL AUTO_INCREMENT,
  `cmtgrammarcontent` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `baigrammarid` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`cmtgrammarid`),
  KEY `FKoqdhw1u7geuy8x02fteb4j8pg` (`baigrammarid`),
  KEY `FKfemqtykw679muo86sadwe7ec3` (`id`),
  CONSTRAINT `FKfemqtykw679muo86sadwe7ec3` FOREIGN KEY (`id`) REFERENCES `nguoi_dung` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKoqdhw1u7geuy8x02fteb4j8pg` FOREIGN KEY (`baigrammarid`) REFERENCES `bai_grammar` (`baigrammarid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;



CREATE TABLE `khoi_cam_bien` (
  `cam_bien_id` int AUTO_INCREMENT,
  `anh_cam_bien` varchar(255) DEFAULT NULL,
  `content_html` mediumtext,
  `content_mark_down` text,
  `ten_cam_bien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cam_bien_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `khoi_dieu_khien` (
  `dieu_khien_id` int AUTO_INCREMENT,
  `anh_dieu_khien` varchar(255) DEFAULT NULL,
  `content_html` mediumtext,
  `content_mark_down` text,
  `ten_dieu_khien` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dieu_khien_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `khoi_ngoai_vi` (
  `ngoai_vi_id` int AUTO_INCREMENT,
  `anh_ngoai_vi` varchar(255) DEFAULT NULL,
  `content_html` mediumtext,
  `content_mark_down` text,
  `ten_ngoai_vi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ngoai_vi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comment_cam_bien` (
  `cmt_cam_bien_id` int AUTO_INCREMENT,
  `cmt_cam_bien_content` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `cam_bien_id` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`cmt_cam_bien_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comment_dieu_khien` (
  `cmt_dieu_khien_id` int AUTO_INCREMENT,
  `cmt_dieu_khien_content` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `dieu_khien_id` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`cmt_dieu_khien_id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `comment_ngoai_vi` (
  `cmt_ngoai_vi_id` int AUTO_INCREMENT,
  `cmt_ngoai_vi_content` varchar(255) DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `ngoai_vi_id` int(11) NOT NULL,
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`cmt_ngoai_vi_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `video`(
	`video_id` int AUTO_INCREMENT,
	`video_path` varchar(255) NOT NULL,
	`title` varchar(255) DEFAULT NULL,
	`desciption` text DEFAULT NULL,
	`upload_time` datetime DEFAULT NULL,
	PRIMARY KEY(`video_id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `video_bai_grammar`(
	`video_id` int NOT NULL,
	`baigrammarid` int NOT NULL,
	PRIMARY KEY(`video_id`, `baigrammarid`),
	INDEX (`video_id`),
    INDEX (`baigrammarid`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `video_cam_bien` (
    `video_id` int NOT NULL,
    `cam_bien_id` int NOT NULL,
    PRIMARY KEY (`video_id`, `cam_bien_id`),
    INDEX (`video_id`),
    INDEX (`cam_bien_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `video_dieu_khien` (
    `video_id` int NOT NULL,
    `dieu_khien_id` int NOT NULL,
    PRIMARY KEY (`video_id`, `dieu_khien_id`),
    INDEX (`video_id`),
    INDEX (`dieu_khien_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `video_ngoai_vi` (
    `video_id` int NOT NULL,
    `ngoai_vi_id` int NOT NULL,
    PRIMARY KEY (`video_id`, `ngoai_vi_id`),
    INDEX (`video_id`),
    INDEX (`ngoai_vi_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE `video_bai_grammar`
ADD FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE,
ADD FOREIGN KEY (`baigrammarid`) REFERENCES `bai_grammar` (`baigrammarid`) ON DELETE CASCADE;

ALTER TABLE `video_cam_bien`
ADD FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE,
ADD FOREIGN KEY (`cam_bien_id`) REFERENCES `khoi_cam_bien` (`cam_bien_id`) ON DELETE CASCADE;

ALTER TABLE `video_cam_bien`
ADD FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE,
ADD FOREIGN KEY (`cam_bien_id`) REFERENCES `khoi_cam_bien` (`cam_bien_id`) ON DELETE CASCADE;


ALTER TABLE `video_dieu_khien`
ADD FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE,
ADD FOREIGN KEY (`dieu_khien_id`) REFERENCES `khoi_dieu_khien` (`dieu_khien_id`) ON DELETE CASCADE;


ALTER TABLE `video_ngoai_vi`
ADD FOREIGN KEY (`video_id`) REFERENCES `video` (`video_id`) ON DELETE CASCADE,
ADD FOREIGN KEY (`ngoai_vi_id`) REFERENCES `khoi_ngoai_vi` (`ngoai_vi_id`) ON DELETE CASCADE;



ALTER TABLE `comment_cam_bien`
ADD CONSTRAINT `FK_nguoi_dung_cam_bien` FOREIGN KEY (`id`) REFERENCES `nguoi_dung` (`id`) ON DELETE CASCADE,
ADD CONSTRAINT `FK_cam_bien` FOREIGN KEY (`cam_bien_id`) REFERENCES `khoi_cam_bien` (`cam_bien_id`) ON DELETE CASCADE;

ALTER TABLE `comment_dieu_khien`
ADD CONSTRAINT `FK_nguoi_dung_dieu_khien` FOREIGN KEY (`id`) REFERENCES `nguoi_dung` (`id`) ON DELETE CASCADE,
ADD CONSTRAINT `FK_dieu_khien` FOREIGN KEY (`dieu_khien_id`) REFERENCES `khoi_dieu_khien` (`dieu_khien_id`) ON DELETE CASCADE;

ALTER TABLE `comment_ngoai_vi`
ADD CONSTRAINT `FK_nguoi_dung_ngoai_vi` FOREIGN KEY (`id`) REFERENCES `nguoi_dung` (`id`) ON DELETE CASCADE,
ADD CONSTRAINT `FK_ngoai_vi` FOREIGN KEY (`ngoai_vi_id`) REFERENCES `khoi_ngoai_vi` (`ngoai_vi_id`) ON DELETE CASCADE;



ALTER TABLE bai_grammar MODIFY content_html MEDIUMTEXT;
-- SELECT grammar.tenbaigrammar 
-- FROM bai_grammar AS grammar 
-- WHERE grammar.tenbaigrammar LIKE CONCAT('%', :search, '%');
-- SELECT c FROM CommentGrammar c WHERE c.baiGrammar.baigrammarid = :baigrammarid;

ALTER TABLE video DROP COLUMN description;




