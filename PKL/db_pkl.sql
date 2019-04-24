-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 22, 2019 at 05:19 AM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_pkl`
--

-- --------------------------------------------------------

--
-- Table structure for table `p_guru`
--

CREATE TABLE `p_guru` (
  `kd_guru` int(3) NOT NULL,
  `nip` varchar(20) DEFAULT NULL,
  `nama_guru` varchar(40) DEFAULT NULL,
  `gol` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `p_guru`
--

INSERT INTO `p_guru` (`kd_guru`, `nip`, `nama_guru`, `gol`) VALUES
(1, '123', 'asdfg', '123');

-- --------------------------------------------------------

--
-- Table structure for table `p_kelas`
--

CREATE TABLE `p_kelas` (
  `id_kelas` int(3) DEFAULT NULL,
  `nama_kelas` varchar(20) DEFAULT NULL,
  `wali_kelas` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `p_kelas`
--

INSERT INTO `p_kelas` (`id_kelas`, `nama_kelas`, `wali_kelas`) VALUES
(1, 'X IPS', NULL),
(2, 'X MIPA', NULL),
(3, 'XI IPS', NULL),
(4, 'XI MIPA', NULL),
(5, 'XII IPS', NULL),
(6, 'XII MIPA', NULL),
(7, 'X MIPA FILIAL', NULL),
(8, 'XI MIPA FILIAL', NULL),
(9, 'XII IPS FILIAL', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `p_login`
--

CREATE TABLE `p_login` (
  `id` int(3) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `log` enum('yes','no') DEFAULT NULL,
  `waktuakses` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `p_login`
--

INSERT INTO `p_login` (`id`, `name`, `username`, `password`, `log`, `waktuakses`) VALUES
(1, 'admin', 'admin', 'admin123', 'yes', '22-04-19  08:00:02');

-- --------------------------------------------------------

--
-- Table structure for table `p_mapel`
--

CREATE TABLE `p_mapel` (
  `kd_mapel` varchar(3) NOT NULL,
  `nama_mapel` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `p_mapel`
--

INSERT INTO `p_mapel` (`kd_mapel`, `nama_mapel`) VALUES
('-', ''),
('A', 'PA & BUDI PEKERTI'),
('B', 'PPKn'),
('C', 'BHS. INDONESIA'),
('D', 'MATEMATIKA WAJIB'),
('E', 'SEJARAH INDONESIA'),
('F', 'BHS. INGGRIS'),
('G', 'SENI BUDAYA'),
('H', 'PENJAS ORKES'),
('I', 'PRAKARYA & KWU'),
('J', 'MATEMATIKA MINAT'),
('K', 'BIOLOGI MINAT'),
('L', 'FISIKA'),
('M', 'KIMIA MINAT'),
('N', 'GEOGRAFI MINAT'),
('O', 'SEJARAH MINAT'),
('P', 'SOSIOLOGI MINAT'),
('Q', 'EKONOMI'),
('R', 'BIOLOGI LINTAS MINAT'),
('S', 'KIMIA LINTAS MINAT'),
('T', 'GEOGRAFI LINTAS MINAT'),
('U', 'SOSIOLOGI LINTAS MINAT'),
('V', 'MULOK (PEND. BHS. SASAK)');

-- --------------------------------------------------------

--
-- Table structure for table `p_nilai`
--

CREATE TABLE `p_nilai` (
  `kd_nilai` int(3) NOT NULL,
  `n_nis` varchar(20) DEFAULT NULL,
  `n_nama_siswa` varchar(40) DEFAULT NULL,
  `n_guru` varchar(20) DEFAULT NULL,
  `n_mapel` varchar(30) DEFAULT NULL,
  `n_kelas` varchar(20) DEFAULT NULL,
  `n_tugas` int(3) DEFAULT NULL,
  `n_kuis` int(3) DEFAULT NULL,
  `n_uts` int(3) DEFAULT NULL,
  `n_uas` int(3) DEFAULT NULL,
  `n_total` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `p_siswa`
--

CREATE TABLE `p_siswa` (
  `no_abs` varchar(3) DEFAULT NULL,
  `nis` varchar(10) DEFAULT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `s_kelas` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `p_guru`
--
ALTER TABLE `p_guru`
  ADD PRIMARY KEY (`kd_guru`);

--
-- Indexes for table `p_login`
--
ALTER TABLE `p_login`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `p_mapel`
--
ALTER TABLE `p_mapel`
  ADD PRIMARY KEY (`kd_mapel`);

--
-- Indexes for table `p_nilai`
--
ALTER TABLE `p_nilai`
  ADD PRIMARY KEY (`kd_nilai`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `p_login`
--
ALTER TABLE `p_login`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `p_nilai`
--
ALTER TABLE `p_nilai`
  MODIFY `kd_nilai` int(3) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
