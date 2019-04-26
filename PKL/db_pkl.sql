-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 26 Apr 2019 pada 09.11
-- Versi server: 10.1.38-MariaDB
-- Versi PHP: 7.3.2

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
-- Struktur dari tabel `p_guru`
--

CREATE TABLE `p_guru` (
  `kd_guru` int(3) NOT NULL,
  `nip` varchar(20) DEFAULT NULL,
  `nama_guru` varchar(40) DEFAULT NULL,
  `gol` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `p_guru`
--

INSERT INTO `p_guru` (`kd_guru`, `nip`, `nama_guru`, `gol`) VALUES
(1, '123', 'asdfg', '123');

-- --------------------------------------------------------

--
-- Struktur dari tabel `p_kelas`
--

CREATE TABLE `p_kelas` (
  `id_kelas` int(3) DEFAULT NULL,
  `nama_kelas` varchar(20) DEFAULT NULL,
  `wali_kelas` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `p_kelas`
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
-- Struktur dari tabel `p_login`
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
-- Dumping data untuk tabel `p_login`
--

INSERT INTO `p_login` (`id`, `name`, `username`, `password`, `log`, `waktuakses`) VALUES
(1, 'admin', 'admin', 'admin123', 'yes', '24-04-19  03:15:18'),
(2, 'ilham fidatama', 'ilham_fidatama', 'ilham123', 'yes', '24-04-19  03:19:44');

-- --------------------------------------------------------

--
-- Struktur dari tabel `p_mapel`
--

CREATE TABLE `p_mapel` (
  `kd_mapel` varchar(3) NOT NULL,
  `nama_mapel` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `p_mapel`
--

INSERT INTO `p_mapel` (`kd_mapel`, `nama_mapel`) VALUES
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
-- Struktur dari tabel `p_nilai`
--

CREATE TABLE `p_nilai` (
  `kd_nilai` int(3) NOT NULL,
  `n_nis` varchar(20) DEFAULT NULL,
  `n_nama_siswa` varchar(40) DEFAULT NULL,
  `n_guru` varchar(20) DEFAULT NULL,
  `n_mapel` varchar(30) DEFAULT NULL,
  `n_kelas` varchar(20) DEFAULT NULL,
  `n_tugas` float DEFAULT NULL,
  `n_kuis` float DEFAULT NULL,
  `n_uts` float DEFAULT NULL,
  `n_uas` float DEFAULT NULL,
  `n_total` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `p_nilai`
--

INSERT INTO `p_nilai` (`kd_nilai`, `n_nis`, `n_nama_siswa`, `n_guru`, `n_mapel`, `n_kelas`, `n_tugas`, `n_kuis`, `n_uts`, `n_uas`, `n_total`) VALUES
(3, '123', 'awad', '1', 'D', '2', 10, 10, 40, 40, 100),
(4, '1231431', 'ilham', '1', 'A', '2', 8.53, 10, 40, 40, 98.53);

-- --------------------------------------------------------

--
-- Struktur dari tabel `p_siswa`
--

CREATE TABLE `p_siswa` (
  `no_abs` varchar(3) DEFAULT NULL,
  `nis` varchar(10) DEFAULT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `s_kelas` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `p_siswa`
--

INSERT INTO `p_siswa` (`no_abs`, `nis`, `nama`, `s_kelas`) VALUES
('001', '1231431', 'ilham', 'X MIPA');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `p_guru`
--
ALTER TABLE `p_guru`
  ADD PRIMARY KEY (`kd_guru`);

--
-- Indeks untuk tabel `p_login`
--
ALTER TABLE `p_login`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `p_mapel`
--
ALTER TABLE `p_mapel`
  ADD PRIMARY KEY (`kd_mapel`);

--
-- Indeks untuk tabel `p_nilai`
--
ALTER TABLE `p_nilai`
  ADD PRIMARY KEY (`kd_nilai`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `p_login`
--
ALTER TABLE `p_login`
  MODIFY `id` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT untuk tabel `p_nilai`
--
ALTER TABLE `p_nilai`
  MODIFY `kd_nilai` int(3) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
