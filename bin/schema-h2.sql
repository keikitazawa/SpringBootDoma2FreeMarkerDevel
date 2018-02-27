

DROP TABLE IF EXISTS `Users`;

DROP TABLE IF EXISTS `Taxonomies`;

DROP TABLE IF EXISTS `Terms`;

DROP TABLE IF EXISTS `TermTrees`;

CREATE TABLE `Users` (
   `version` bigint NOT NULL  DEFAULT '0' 
  ,`modified` timestamp NULL  DEFAULT CURRENT_TIMESTAMP 
  ,`deleted` timestamp NULL  
  ,`id` char(36) NOT NULL  
  ,`email` varchar(256) NOT NULL  
  ,`password` varchar(1000) NOT NULL  
  ,`role` varchar(1000) NOT NULL  
  ,CONSTRAINT PK_Users PRIMARY KEY (id)
);

CREATE TABLE `Taxonomies` (
   `version` bigint NOT NULL  DEFAULT '0' 
  ,`modified` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP 
  ,`deleted` timestamp NULL  
  ,`id` char(36) NOT NULL  
  ,`name` varchar(256) NOT NULL  
  ,`description` text NULL  
  ,`weight` int NOT NULL  DEFAULT '0' 
  ,CONSTRAINT PK_Taxonomies PRIMARY KEY (id)
  ,CONSTRAINT IK_Taxonomies_deletedasc_weightasc UNIQUE (deleted asc, weight asc)
);

CREATE TABLE `Terms` (
   `version` bigint NOT NULL  DEFAULT '0' 
  ,`modified` timestamp NOT NULL  DEFAULT CURRENT_TIMESTAMP 
  ,`deleted` timestamp NULL  
  ,`id` char(36) NOT NULL  
  ,`parent_id` char(36) NOT NULL  
  ,`name` varchar(64) NOT NULL  
  ,`description` text NULL  
  ,`weight` int NOT NULL  DEFAULT '0' 
  ,CONSTRAINT PK_Terms PRIMARY KEY (id)
  ,CONSTRAINT IK_Terms_deletedasc_parentidasc_weightasc UNIQUE (deleted asc, parent_id asc, weight asc)
);

CREATE TABLE `TermTrees` (
   `version` bigint NOT NULL  DEFAULT '0' 
  ,`parent_id` char(36) NOT NULL  
  ,`id` char(36) NOT NULL  
  ,CONSTRAINT PK_TermTrees PRIMARY KEY (parent_id, id)
);



--ALTER TABLE `Taxonomies` ADD CONSTRAINT FK_Taxonomies_id FOREIGN KEY (id) REFERENCES terms(parent_id);


--ALTER TABLE `TermTrees` ADD CONSTRAINT FK_TermTrees_id FOREIGN KEY (id) REFERENCES terms(id);
--ALTER TABLE `TermTrees` ADD CONSTRAINT FK_TermTrees_parentid FOREIGN KEY (parent_id) REFERENCES terms(id);

