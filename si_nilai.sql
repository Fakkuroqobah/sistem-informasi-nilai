-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2021 at 04:59 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `si_nilai`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_insert_mahasiswa` (IN `nim` VARCHAR(10), `nama_mhs` VARCHAR(50), `jk` ENUM('Laki-laki','Perempuan'), `id_kelas` INT(11))  BEGIN
	INSERT INTO mahasiswa VALUES(nim, nama_mhs, jk, id_kelas);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_insert_matkul` (IN `kd_matkul` VARCHAR(5), `nama_matkul` VARCHAR(20))  BEGIN
	INSERT INTO matkul VALUES(kd_matkul, nama_matkul);
END$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `proc_insert_nilai` (IN `nim` VARCHAR(10), `kd_matkul` VARCHAR(5), `nilai` TINYINT(4), `nilai_huruf` CHAR(1))  BEGIN
	INSERT INTO nilai(nim, kd_matkul, nilai, nilai_huruf) VALUES(nim, kd_matkul, nilai, nilai_huruf);
END$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `func_nilai_huruf` (`nilai` INT(3)) RETURNS CHAR(1) CHARSET latin1 BEGIN
	DECLARE nilai_huruf CHAR;

	SET nilai_huruf = CASE
		WHEN nilai BETWEEN 81 AND 100 THEN 'A'
		WHEN nilai BETWEEN 61 AND 80 THEN 'B'
		WHEN nilai BETWEEN 41 AND 60 THEN 'C'
		WHEN nilai BETWEEN 21 AND 40 THEN 'D'
		WHEN nilai BETWEEN 0 AND 20 THEN 'E'
	END;
	
	return nilai_huruf;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`) VALUES
(1, 'admin', '123');

-- --------------------------------------------------------

--
-- Table structure for table `kelas`
--

CREATE TABLE `kelas` (
  `id_kelas` int(11) NOT NULL,
  `nama_kelas` varchar(3) NOT NULL,
  `kuota` tinyint(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kelas`
--

INSERT INTO `kelas` (`id_kelas`, `nama_kelas`, `kuota`) VALUES
(1, 'TIA', 19),
(2, 'TIB', 19),
(3, 'TIC', 20);

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `nim` varchar(10) NOT NULL,
  `nama_mhs` varchar(50) NOT NULL,
  `jk` enum('Laki-laki','Perempuan') NOT NULL,
  `id_kelas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`nim`, `nama_mhs`, `jk`, `id_kelas`) VALUES
('5190411000', 'Trafalgar Law', 'Laki-laki', 1),
('519041101', 'Lyoid Folger', 'Laki-laki', 2);

--
-- Triggers `mahasiswa`
--
DELIMITER $$
CREATE TRIGGER `dec_kuota_kelas` AFTER INSERT ON `mahasiswa` FOR EACH ROW BEGIN
    UPDATE kelas SET kuota = kuota-1 WHERE id_kelas = NEW.id_kelas;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `inc_kuota_kelas` AFTER DELETE ON `mahasiswa` FOR EACH ROW BEGIN
    UPDATE kelas SET kuota = kuota+1 WHERE id_kelas = OLD.id_kelas;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `upd_kuota_kelas` AFTER UPDATE ON `mahasiswa` FOR EACH ROW BEGIN
    UPDATE kelas SET kuota = kuota+1 WHERE id_kelas = OLD.id_kelas;
    UPDATE kelas SET kuota = kuota-1 WHERE id_kelas = NEW.id_kelas;
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `matkul`
--

CREATE TABLE `matkul` (
  `kd_matkul` varchar(5) NOT NULL,
  `nama_matkul` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matkul`
--

INSERT INTO `matkul` (`kd_matkul`, `nama_matkul`) VALUES
('BDT', 'Basis Data Teori'),
('BDTP', 'Basis Data Praktikum');

-- --------------------------------------------------------

--
-- Table structure for table `nilai`
--

CREATE TABLE `nilai` (
  `id_nilai` int(11) NOT NULL,
  `nim` varchar(10) NOT NULL,
  `kd_matkul` varchar(5) NOT NULL,
  `nilai` tinyint(4) NOT NULL,
  `nilai_huruf` char(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nilai`
--

INSERT INTO `nilai` (`id_nilai`, `nim`, `kd_matkul`, `nilai`, `nilai_huruf`) VALUES
(2, '5190411000', 'BDT', 100, 'A');

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_nama_kelas`
-- (See below for the actual view)
--
CREATE TABLE `view_nama_kelas` (
`id_kelas` int(11)
,`nim` varchar(10)
,`nama_mhs` varchar(50)
,`jk` enum('Laki-laki','Perempuan')
,`nama_kelas` varchar(3)
,`kuota` tinyint(3)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `view_tampil_nilai`
-- (See below for the actual view)
--
CREATE TABLE `view_tampil_nilai` (
`nim` varchar(10)
,`nama_mhs` varchar(50)
,`nama_matkul` varchar(20)
,`nama_kelas` varchar(3)
,`nilai` tinyint(4)
,`nilai_huruf` char(1)
);

-- --------------------------------------------------------

--
-- Structure for view `view_nama_kelas`
--
DROP TABLE IF EXISTS `view_nama_kelas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_nama_kelas`  AS  select `mahasiswa`.`id_kelas` AS `id_kelas`,`mahasiswa`.`nim` AS `nim`,`mahasiswa`.`nama_mhs` AS `nama_mhs`,`mahasiswa`.`jk` AS `jk`,`kelas`.`nama_kelas` AS `nama_kelas`,`kelas`.`kuota` AS `kuota` from (`mahasiswa` join `kelas` on((`mahasiswa`.`id_kelas` = `kelas`.`id_kelas`))) ;

-- --------------------------------------------------------

--
-- Structure for view `view_tampil_nilai`
--
DROP TABLE IF EXISTS `view_tampil_nilai`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `view_tampil_nilai`  AS  select `mahasiswa`.`nim` AS `nim`,`mahasiswa`.`nama_mhs` AS `nama_mhs`,`matkul`.`nama_matkul` AS `nama_matkul`,`kelas`.`nama_kelas` AS `nama_kelas`,`nilai`.`nilai` AS `nilai`,`nilai`.`nilai_huruf` AS `nilai_huruf` from (((`matkul` join `nilai` on((`matkul`.`kd_matkul` = `nilai`.`kd_matkul`))) join `mahasiswa` on((`mahasiswa`.`nim` = `nilai`.`nim`))) join `kelas` on((`mahasiswa`.`id_kelas` = `kelas`.`id_kelas`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indexes for table `kelas`
--
ALTER TABLE `kelas`
  ADD PRIMARY KEY (`id_kelas`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`nim`),
  ADD KEY `id_kelas` (`id_kelas`);

--
-- Indexes for table `matkul`
--
ALTER TABLE `matkul`
  ADD PRIMARY KEY (`kd_matkul`);

--
-- Indexes for table `nilai`
--
ALTER TABLE `nilai`
  ADD PRIMARY KEY (`id_nilai`),
  ADD KEY `nim` (`nim`),
  ADD KEY `kd_matkul` (`kd_matkul`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `kelas`
--
ALTER TABLE `kelas`
  MODIFY `id_kelas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `nilai`
--
ALTER TABLE `nilai`
  MODIFY `id_nilai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD CONSTRAINT `mahasiswa_ibfk_1` FOREIGN KEY (`id_kelas`) REFERENCES `kelas` (`id_kelas`);

--
-- Constraints for table `nilai`
--
ALTER TABLE `nilai`
  ADD CONSTRAINT `nilai_ibfk_1` FOREIGN KEY (`nim`) REFERENCES `mahasiswa` (`nim`) ON DELETE CASCADE,
  ADD CONSTRAINT `nilai_ibfk_2` FOREIGN KEY (`kd_matkul`) REFERENCES `matkul` (`kd_matkul`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
