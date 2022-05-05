create database autodialeralpha;
USE autodialeralpha

create table if not exists `oauth_user`(
`user_id` bigint(20) not null  auto_increment  ,
`email` varchar (255) not  null ,
`phone_number` varchar (255) not  NULL ,
`first_name` varchar (255)  not  null ,
`last_name` varchar (255) not  null ,
`created_at` timestamp,
`updated_at` timestamp,
primary  key (user_id) using  btree ,
unique  index  oauth_user_phone_email(phone_number,email) using  btree 
)


CREATE TABLE IF NOT EXISTS `user_licence`(
`user_licence_id` bigint(20) NOT NULL AUTO_INCREMENT  ,
`user_id` bigint(20) NULL,
`active` TINYINT(1) NOT NULL DEFAULT '0' ,
`created_at` TIMESTAMP ,
`updated_at` TIMESTAMP ,
primary  key (user_licence_id) USING   BTREE  ,
CONSTRAINT `FK_user_licence_oauth_user` FOREIGN KEY (`user_id`) REFERENCES `oauth_user`(`user_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)

CREATE TABLE IF NOT EXISTS `oauth_role`(
`role_id` bigint(20) NOT NULL AUTO_INCREMENT  ,
`role` VARCHAR(255) NOT NULL,
PRIMARY KEY (`role_id`) USING BTREE ,
UNIQUE INDEX ui_role (`role`) USING BTREE
)


CREATE TABLE IF NOT EXISTS `oauth_user_role`(
`user_role_id` bigint(20) NOT NULL AUTO_INCREMENT ,
`user_id` BIGINT(20) NOT NULL,
`role_id` BIGINT(20) NOT NULL,
PRIMARY KEY (`user_role_id`) USING BTREE ,
INDEX ui_role (`role_id`) USING BTREE,
INDEX ui_user (`user_id`) USING BTREE,
CONSTRAINT `FK_oauth_user_role_oauth_user` FOREIGN KEY (`user_id`) REFERENCES `oauth_user`(`user_id`) ON UPDATE NO ACTION ON DELETE NO ACTION,
CONSTRAINT `FK_oauth_user_role_oauth_role` FOREIGN KEY (`role_id`) REFERENCES `oauth_role`(`role_id`) ON UPDATE NO ACTION ON DELETE NO ACTION
)