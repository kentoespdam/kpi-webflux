CREATE TABLE IF NOT EXISTS `m_level` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `level` varchar(100) DEFAULT NULL,
  `status` enum('Enabled','Disabled','Deleted') NOT NULL DEFAULT 'Disabled',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(32) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
);

CREATE TABLE IF NOT EXISTS `m_profesi` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `level_id` int(11) unsigned DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` enum('Enabled','Disabled','Deleted') NOT NULL DEFAULT 'Enabled',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(32) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `level_id_idx` (`level_id`),
  KEY `name_idx` (`name`),
  KEY `status_idx` (`status`),
  CONSTRAINT `fk_level_profesi` FOREIGN KEY (`level_id`) REFERENCES `m_level` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `m_grade` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `level_id` int(11) unsigned DEFAULT NULL,
  `grade` int(11) DEFAULT NULL,
  `tukin` double DEFAULT NULL,
  `status` enum('Enabled','Disabled','Deleted') NOT NULL DEFAULT 'Enabled',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(32) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `level_id_idx` (`level_id`),
  CONSTRAINT `fk_level_id` FOREIGN KEY (`level_id`) REFERENCES `m_level` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `m_kpi` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `org_id` int(11) DEFAULT NULL,
  `pos_id` int(11) DEFAULT NULL,
  `profesi_id` int(11) unsigned DEFAULT NULL,
  `name` tinytext DEFAULT NULL,
  `grade_id` int(11) unsigned DEFAULT NULL,
  `status` enum('Enabled','Disabled','Deleted') NOT NULL DEFAULT 'Enabled',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(32) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `profesi_id_idx` (`profesi_id`),
  KEY `grade_id_idx` (`grade_id`),
  KEY `org_id_idx` (`org_id`),
  KEY `pos_id_idx` (`pos_id`),
  CONSTRAINT `fk_grade_id` FOREIGN KEY (`grade_id`) REFERENCES `m_grade` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_profesi_id` FOREIGN KEY (`profesi_id`) REFERENCES `m_profesi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `m_indikator` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kpi_id` int(11) unsigned DEFAULT NULL,
  `indikator` tinytext DEFAULT NULL,
  `urut` int(1) DEFAULT NULL,
  `status` enum('Enabled','Disabled','Deleted') NOT NULL DEFAULT 'Enabled',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(32) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_kpi_id` (`kpi_id`),
  CONSTRAINT `fk_kpi_indikator` FOREIGN KEY (`kpi_id`) REFERENCES `m_kpi` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `m_uraian_indikator` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `indikator_id` int(11) unsigned DEFAULT NULL,
  `uraian` text DEFAULT NULL,
  `volume` float DEFAULT NULL,
  `satuan` varchar(100) DEFAULT NULL,
  `target` enum('MIN','MAX') DEFAULT 'MIN',
  `waktu` varchar(100) DEFAULT NULL,
  `bobot` float DEFAULT NULL,
  `status` enum('Enabled','Disabled','Deleted') NOT NULL DEFAULT 'Enabled',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(32) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `indikator_id_idx` (`indikator_id`),
  CONSTRAINT `fk_uraian_indikator` FOREIGN KEY (`indikator_id`) REFERENCES `m_indikator` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE IF NOT EXISTS `m_perilaku` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `urut` int(11) DEFAULT NULL,
  `kompetensi` text DEFAULT NULL,
  `uraian` text DEFAULT NULL,
  `status` enum('Enabled','Disabled','Deleted') NOT NULL DEFAULT 'Enabled',
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `created_by` varchar(32) DEFAULT NULL,
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `updated_by` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
);