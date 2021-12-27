-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 26, 2021 lúc 04:44 PM
-- Phiên bản máy phục vụ: 10.4.17-MariaDB
-- Phiên bản PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `qldl`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_admin`
--

CREATE TABLE `tbl_admin` (
  `TAIKHOAN` char(20) NOT NULL,
  `MATKHAU` text NOT NULL,
  `MANV` bigint(20) NOT NULL,
  `QUYEN` varchar(50) NOT NULL,
  `HINHANH` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_admin`
--

INSERT INTO `tbl_admin` (`TAIKHOAN`, `MATKHAU`, `MANV`, `QUYEN`, `HINHANH`) VALUES
('nguyenthihuyen', '12345', 2, 'Quản lý', 'NV2.jpg'),
('nv01', '123456', 1, 'nhân viên', 'NV2.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_chitietdiemdanh`
--

CREATE TABLE `tbl_chitietdiemdanh` (
  `MASODD` bigint(20) NOT NULL,
  `MANV` bigint(20) NOT NULL,
  `NGAY` date NOT NULL,
  `GIOVAO` time NOT NULL,
  `GIORA` time NOT NULL,
  `TRANGTHAI` varchar(50) NOT NULL,
  `GHICHU` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_chitietdiemdanh`
--

INSERT INTO `tbl_chitietdiemdanh` (`MASODD`, `MANV`, `NGAY`, `GIOVAO`, `GIORA`, `TRANGTHAI`, `GHICHU`) VALUES
(9, 1, '2021-11-22', '14:31:05', '14:31:29', 'ghi chú', 'trạng thái'),
(10, 2, '2021-11-22', '15:43:11', '15:45:49', 'ghi chú', 'trạng thái'),
(11, 5, '2021-11-22', '15:43:31', '15:46:15', 'ghi chú', 'trạng thái'),
(12, 6, '2021-11-22', '15:44:42', '15:46:25', 'ghi chú', 'trạng thái'),
(13, 3, '2021-11-22', '15:45:14', '15:47:02', 'ghi chú', 'trạng thái'),
(14, 1, '2021-11-25', '13:40:44', '13:43:22', 'ghi chú', 'trạng thái'),
(15, 2, '2021-11-25', '13:41:08', '13:43:45', 'ghi chú', 'trạng thái'),
(16, 5, '2021-11-25', '13:41:21', '13:44:13', 'ghi chú', 'trạng thái'),
(17, 6, '2021-11-25', '13:42:26', '13:44:25', 'ghi chú', 'trạng thái'),
(18, 3, '2021-11-25', '13:42:40', '13:44:36', 'ghi chú', 'trạng thái'),
(19, 1, '2021-11-26', '14:25:00', '14:26:21', 'ghi chú', 'trạng thái'),
(20, 2, '2021-11-26', '14:25:22', '14:26:35', 'ghi chú', 'trạng thái'),
(21, 5, '2021-11-26', '14:25:33', '14:26:48', 'ghi chú', 'trạng thái'),
(22, 6, '2021-11-26', '14:25:46', '14:26:58', 'ghi chú', 'trạng thái'),
(23, 3, '2021-11-26', '14:25:57', '14:27:32', 'ghi chú', 'trạng thái');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_chitiettinhluong`
--

CREATE TABLE `tbl_chitiettinhluong` (
  `MASOTINHLUONG` bigint(20) NOT NULL,
  `MANV` bigint(20) NOT NULL,
  `LUONGCANBAN` float NOT NULL,
  `SONGAYLAMVIEC` int(11) NOT NULL,
  `THUONG` float NOT NULL,
  `PHUCAP` float NOT NULL,
  `TRU` float NOT NULL,
  `THUE` float NOT NULL,
  `TONGLUONG` float NOT NULL,
  `NGAYPHAT` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_chitiettinhluong`
--

INSERT INTO `tbl_chitiettinhluong` (`MASOTINHLUONG`, `MANV`, `LUONGCANBAN`, `SONGAYLAMVIEC`, `THUONG`, `PHUCAP`, `TRU`, `THUE`, `TONGLUONG`, `NGAYPHAT`) VALUES
(3, 2, 3000000, 4, 0, 0, 0, 10, 300000, '2021-11-25'),
(4, 1, 30000, 5, 50000, 0, 0, 0.1, 350000, '2021-11-23'),
(5, 1, 300000, 6, 30000, 30000, 0, 0.2, 3660000, '2021-11-23'),
(6, 2, 300000, 6, 0, 0, 0, 0, 1800000, '2021-11-25');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_chucvu`
--

CREATE TABLE `tbl_chucvu` (
  `MACV` bigint(20) NOT NULL,
  `TENCV` varchar(100) NOT NULL,
  `HESO` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_chucvu`
--

INSERT INTO `tbl_chucvu` (`MACV`, `TENCV`, `HESO`) VALUES
(1, 'TRƯỞNG PHÒNG', 2),
(2, 'NHÂN VIÊN', 1),
(3, 'P.TRƯỞNG PHÒNG', 1),
(4, 'GIÁM ĐỐC', 3),
(5, 'P.GIÁM ĐỐC', 2),
(9, 'THƯ KÍ', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_dattour`
--

CREATE TABLE `tbl_dattour` (
  `MADATTOUR` bigint(20) NOT NULL,
  `MATOUR` bigint(20) NOT NULL,
  `MAKH` bigint(20) NOT NULL,
  `SOLUONG` int(11) NOT NULL,
  `THOIGIANBATDAU` date NOT NULL,
  `DIADIEMBATDAU` varchar(100) NOT NULL,
  `MANV` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_dattour`
--

INSERT INTO `tbl_dattour` (`MADATTOUR`, `MATOUR`, `MAKH`, `SOLUONG`, `THOIGIANBATDAU`, `DIADIEMBATDAU`, `MANV`) VALUES
(5, 2, 4, 3, '2021-11-03', 'Cà Mau', 2),
(9, 3, 2, 2, '2021-11-27', 'Cần thơ', 3),
(10, 4, 5, 3, '2021-11-20', 'Kiên giang', 1),
(11, 2, 5, 4, '2021-11-30', 'Bạc Liêu', 1),
(12, 2, 8, 3, '2021-11-29', 'Tp.HCM', 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_diadiem`
--

CREATE TABLE `tbl_diadiem` (
  `MADD` bigint(20) NOT NULL,
  `TENDD` varchar(100) NOT NULL,
  `MATINH` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_diadiem`
--

INSERT INTO `tbl_diadiem` (`MADD`, `TENDD`, `MATINH`) VALUES
(2, 'Hồ Tà Pạa', 2),
(3, 'Phú Quốc', 3),
(4, 'Hà tiên', 3),
(5, 'đà lạt', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_dichvu`
--

CREATE TABLE `tbl_dichvu` (
  `MADV` bigint(20) NOT NULL,
  `TENDV` varchar(100) NOT NULL,
  `DONGIA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_dichvu`
--

INSERT INTO `tbl_dichvu` (`MADV`, `TENDV`, `DONGIA`) VALUES
(2, 'Trọn gói', 400000),
(3, 'Thuê loa', 200000),
(5, 'Ăn sáng', 50000),
(6, 'Thuê xe', 200000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_hoadon`
--

CREATE TABLE `tbl_hoadon` (
  `MAHOADON` bigint(20) NOT NULL,
  `MADATTOUR` bigint(20) NOT NULL,
  `NGAYLAP` date NOT NULL,
  `MANV` bigint(20) NOT NULL,
  `TONGTIEN` float NOT NULL,
  `TRANGTHAI` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_hoadon`
--

INSERT INTO `tbl_hoadon` (`MAHOADON`, `MADATTOUR`, `NGAYLAP`, `MANV`, `TONGTIEN`, `TRANGTHAI`) VALUES
(15, 5, '2021-12-09', 2, 9000000, 'Đã thanh toán'),
(18, 9, '2021-09-22', 2, 7810000, 'Đã thanh toán'),
(19, 10, '2021-11-21', 2, 90000, 'Chưa thanh toán'),
(20, 11, '2021-07-16', 2, 9030000, 'Chưa thanh toán'),
(21, 12, '2021-10-14', 2, 6020700, 'Đã thanh toán'),
(22, 9, '2021-08-11', 2, 8000000, 'Đã thanh toán'),
(40, 9, '2021-01-25', 1, 4000000, 'Chưa thanh toán'),
(41, 11, '2021-02-02', 2, 40000000, 'Chưa thanh toán'),
(42, 9, '2021-03-30', 3, 30000000, 'Đã thanh toán'),
(43, 10, '2021-04-28', 6, 4000000, 'Chưa thanh toán'),
(44, 5, '2021-05-20', 5, 30000000, 'Chưa thanh toán'),
(45, 10, '2021-06-23', 6, 4500000, 'Đã thanh toán');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_khachhang`
--

CREATE TABLE `tbl_khachhang` (
  `MAKH` bigint(20) NOT NULL,
  `HOTENKH` varchar(100) NOT NULL,
  `GIOITINH` varchar(100) NOT NULL,
  `CMND` char(12) NOT NULL,
  `DIACHI` varchar(100) NOT NULL,
  `SDT` char(10) NOT NULL,
  `LOAI` varchar(50) NOT NULL,
  `HINHANH` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_khachhang`
--

INSERT INTO `tbl_khachhang` (`MAKH`, `HOTENKH`, `GIOITINH`, `CMND`, `DIACHI`, `SDT`, `LOAI`, `HINHANH`) VALUES
(2, 'NGUYỄN THỊ MỸ TIÊN', 'Nữ', '123456789011', 'Cần Thơ', '0123456789', 'VIP', 'KH1.jpg'),
(4, 'LÊ VĂN CƯƠNG', 'Nam', '32234324324', 'Bạc Liêu', '3423423124', 'Thường', 'NV1.jpg'),
(5, 'NGUYỄN THỊ HUYỀN', 'Nữ', '1234567890', 'Kiên giang', '1234567890', 'VIP', 'NV2.jpg'),
(6, 'TRẦN THẾ VINH', 'Nam', '2312312', 'Kiên Giang', '23123123', 'Thường', 'NV6.jpg'),
(8, 'NGUYỄN THỊ A', 'Nữ', '121212121', 'A', '1212121212', 'VIP', '62c222643e83c8dd9192.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_khachsan`
--

CREATE TABLE `tbl_khachsan` (
  `MAKS` bigint(20) NOT NULL,
  `TENKS` varchar(100) NOT NULL,
  `DIACHI` varchar(100) NOT NULL,
  `MATINH` bigint(20) NOT NULL,
  `DANHGIA` varchar(100) NOT NULL,
  `SDTLIENHE` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_khachsan`
--

INSERT INTO `tbl_khachsan` (`MAKS`, `TENKS`, `DIACHI`, `MATINH`, `DANHGIA`, `SDTLIENHE`) VALUES
(1, 'LINH ĐAN', '2/5 NCT', 1, 'Rất tốt', '3242342342'),
(3, 'HOA HỒNG', 'Nguyễn Văn Cừ', 4, 'a', '2121212121'),
(4, 'HƯỚNG DƯƠNG', '1/2/3 NTT', 1, 'Tốt', '123456789'),
(5, 'HÀ TIÊN', '123, QL80', 3, 'a', '123456789');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_nhanvien`
--

CREATE TABLE `tbl_nhanvien` (
  `MANV` bigint(20) NOT NULL,
  `HOTENNV` varchar(100) NOT NULL,
  `NGAYSINH` date NOT NULL,
  `GIOITINH` varchar(3) NOT NULL,
  `CMND` char(12) NOT NULL,
  `DIACHI` varchar(100) NOT NULL,
  `SDT` char(10) NOT NULL,
  `NGAYVAOLAM` date NOT NULL,
  `MAPTC` bigint(20) NOT NULL,
  `MACV` bigint(20) NOT NULL,
  `HINHANH` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_nhanvien`
--

INSERT INTO `tbl_nhanvien` (`MANV`, `HOTENNV`, `NGAYSINH`, `GIOITINH`, `CMND`, `DIACHI`, `SDT`, `NGAYVAOLAM`, `MAPTC`, `MACV`, `HINHANH`) VALUES
(1, 'LÊ VĂN CƯƠNG', '2000-09-01', 'Nam', '12345678921', 'Bạc Liêu', '1234567899', '2021-09-07', 1, 1, 'NV1.jpg'),
(2, 'NGUYỄN THỊ HUYỀN', '2000-07-16', 'Nữ', '12345678922', 'Kiên Giang', '0934234242', '2021-09-01', 1, 2, 'NV2.jpg'),
(3, 'NGUYỄN VŨ THẮNG', '2000-10-13', 'Nam', '432532345345', 'Hậu Giang', '8947239487', '2021-10-19', 2, 1, 'NV3.jpg'),
(5, 'TRẦN CÔNG ĐÀN', '2021-11-13', 'Nam', '1212121212', 'Kiên Giang', '3123123213', '2021-11-01', 1, 1, 'NV5.jpg'),
(6, 'TRẦN THẾ VINH', '2021-11-05', 'Nam', '12121212121', 'Kiên Giang', '212121212', '2021-11-11', 1, 1, 'NV6.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_phongkhachsan`
--

CREATE TABLE `tbl_phongkhachsan` (
  `MAPHONGKS` bigint(20) NOT NULL,
  `TENPHONG` varchar(100) NOT NULL,
  `LOAI` varchar(50) NOT NULL,
  `GIA` float NOT NULL,
  `MAKS` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_phongkhachsan`
--

INSERT INTO `tbl_phongkhachsan` (`MAPHONGKS`, `TENPHONG`, `LOAI`, `GIA`, `MAKS`) VALUES
(1, 'Phòng 1', 'PHÒNG VIP', 3000000, 1),
(2, 'Phòng 2', 'PHÒNG ĐÔI', 250000, 1),
(4, 'Phòng 3', 'PHÒNG ĐƠN', 150000, 1),
(5, 'Phòng 1', 'PHÒNG VIP', 3500000, 3),
(6, 'Phòng 2', 'PHÒNG ĐÔI', 250000, 3),
(7, 'Phòng 3', 'PHÒNG ĐƠN', 200000, 3),
(8, 'Phòng 4', 'PHÒNG TẬP THỂ', 550000, 3),
(9, 'Phòng 1', 'PHÒNG ĐÔI', 400000, 5),
(10, 'Phòng 4', 'PHÒNG TẬP THỂ', 500000, 1),
(11, 'Phòng 1', 'PHÒNG VIP', 4000000, 1),
(12, 'Phòng 1', 'PHÒNG VIP', 4000000, 4),
(13, 'Phòng 2', 'PHÒNG ĐÔI', 300000, 4),
(14, 'Phòng 3', 'PHÒNG ĐƠN', 150000, 4),
(15, 'Phòng 2', 'PHÒNG ĐÔI', 400000, 5),
(16, 'Phòng 3', 'PHÒNG ĐƠN', 200000, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_phongtochuc`
--

CREATE TABLE `tbl_phongtochuc` (
  `MAPTC` bigint(20) NOT NULL,
  `TENPTC` varchar(100) NOT NULL,
  `TRUONGPHONG` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_phongtochuc`
--

INSERT INTO `tbl_phongtochuc` (`MAPTC`, `TENPTC`, `TRUONGPHONG`) VALUES
(1, 'PHÒNG HÀNH CHÍNH', 'LÊ VĂN CƯƠNG'),
(2, 'PHÒNG TIẾP TÂN', 'NGUYỄN THỊ HUYỀN'),
(3, 'PHÒNG LẬP TOUR', 'TRẦN CÔNG ĐÀN'),
(7, 'PHÒNG TÀI CHÍNH', 'NGUYỄN VŨ THẮNG'),
(8, 'PHÒNG QUẢN LÝ NHÂN SỰ', 'TRẦN THẾ VINH');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_phuongtien`
--

CREATE TABLE `tbl_phuongtien` (
  `MAPHUONGTIEN` bigint(20) NOT NULL,
  `TENPHUONGTIEN` varchar(100) NOT NULL,
  `LOAI` char(50) NOT NULL,
  `TENTAIXE` varchar(100) NOT NULL,
  `SDTLIENLAC` char(10) NOT NULL,
  `TRANGTHAI` varchar(50) NOT NULL,
  `GIA` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_phuongtien`
--

INSERT INTO `tbl_phuongtien` (`MAPHUONGTIEN`, `TENPHUONGTIEN`, `LOAI`, `TENTAIXE`, `SDTLIENLAC`, `TRANGTHAI`, `GIA`) VALUES
(1, 'Xe đò', '30 chỗ', 'Hưng', '1234567890', 'Trống', 3000000),
(2, 'Xe hơi', '4 chỗ', 'a', '123456788', 'Đã cho thuê', 30000),
(4, 'Xe khách', '16 chỗ', 'b', '0192837345', 'Trống', 5000000);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_tinh`
--

CREATE TABLE `tbl_tinh` (
  `MATINH` bigint(20) NOT NULL,
  `TENTINH` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_tinh`
--

INSERT INTO `tbl_tinh` (`MATINH`, `TENTINH`) VALUES
(1, 'Lâm Đồng'),
(2, 'An Giang'),
(3, 'Kiên Giang'),
(4, 'Cần Thơ'),
(5, 'TP.Hồ Chí Minh'),
(6, 'Đà Nẵng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tbl_tour`
--

CREATE TABLE `tbl_tour` (
  `MATOUR` bigint(20) NOT NULL,
  `TENTOUR` varchar(100) NOT NULL,
  `THOIGIAN` date NOT NULL,
  `MAPHONGKS` bigint(20) NOT NULL,
  `MADV` bigint(20) NOT NULL,
  `MAPHUONGTIEN` bigint(20) NOT NULL,
  `DIADIEM` varchar(100) NOT NULL,
  `GIA` float NOT NULL,
  `GHICHU` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `tbl_tour`
--

INSERT INTO `tbl_tour` (`MATOUR`, `TENTOUR`, `THOIGIAN`, `MAPHONGKS`, `MADV`, `MAPHUONGTIEN`, `DIADIEM`, `GIA`, `GHICHU`) VALUES
(2, 'Đà lạt', '2021-10-29', 4, 2, 1, 'b', 3000000, 'không'),
(3, 'Kiên giang', '2021-11-17', 2, 2, 2, 'Kiengiang', 4000000, 'xa'),
(4, 'Hậu Giang', '2021-11-20', 4, 2, 2, 'a', 30000, '');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD PRIMARY KEY (`TAIKHOAN`),
  ADD KEY `MANV` (`MANV`);

--
-- Chỉ mục cho bảng `tbl_chitietdiemdanh`
--
ALTER TABLE `tbl_chitietdiemdanh`
  ADD PRIMARY KEY (`MASODD`,`MANV`,`NGAY`),
  ADD KEY `MANV` (`MANV`);

--
-- Chỉ mục cho bảng `tbl_chitiettinhluong`
--
ALTER TABLE `tbl_chitiettinhluong`
  ADD PRIMARY KEY (`MASOTINHLUONG`,`MANV`),
  ADD KEY `MANV` (`MANV`);

--
-- Chỉ mục cho bảng `tbl_chucvu`
--
ALTER TABLE `tbl_chucvu`
  ADD PRIMARY KEY (`MACV`);

--
-- Chỉ mục cho bảng `tbl_dattour`
--
ALTER TABLE `tbl_dattour`
  ADD PRIMARY KEY (`MADATTOUR`),
  ADD KEY `MAKH` (`MAKH`),
  ADD KEY `MANV` (`MANV`),
  ADD KEY `MATOUR` (`MATOUR`);

--
-- Chỉ mục cho bảng `tbl_diadiem`
--
ALTER TABLE `tbl_diadiem`
  ADD PRIMARY KEY (`MADD`),
  ADD KEY `MATINH` (`MATINH`);

--
-- Chỉ mục cho bảng `tbl_dichvu`
--
ALTER TABLE `tbl_dichvu`
  ADD PRIMARY KEY (`MADV`);

--
-- Chỉ mục cho bảng `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  ADD PRIMARY KEY (`MAHOADON`),
  ADD KEY `MADATTOUR` (`MADATTOUR`),
  ADD KEY `MANV` (`MANV`);

--
-- Chỉ mục cho bảng `tbl_khachhang`
--
ALTER TABLE `tbl_khachhang`
  ADD PRIMARY KEY (`MAKH`);

--
-- Chỉ mục cho bảng `tbl_khachsan`
--
ALTER TABLE `tbl_khachsan`
  ADD PRIMARY KEY (`MAKS`),
  ADD KEY `MATINH` (`MATINH`);

--
-- Chỉ mục cho bảng `tbl_nhanvien`
--
ALTER TABLE `tbl_nhanvien`
  ADD PRIMARY KEY (`MANV`),
  ADD KEY `MACV` (`MACV`),
  ADD KEY `MAPTC` (`MAPTC`);

--
-- Chỉ mục cho bảng `tbl_phongkhachsan`
--
ALTER TABLE `tbl_phongkhachsan`
  ADD PRIMARY KEY (`MAPHONGKS`),
  ADD KEY `MAKS` (`MAKS`);

--
-- Chỉ mục cho bảng `tbl_phongtochuc`
--
ALTER TABLE `tbl_phongtochuc`
  ADD PRIMARY KEY (`MAPTC`);

--
-- Chỉ mục cho bảng `tbl_phuongtien`
--
ALTER TABLE `tbl_phuongtien`
  ADD PRIMARY KEY (`MAPHUONGTIEN`);

--
-- Chỉ mục cho bảng `tbl_tinh`
--
ALTER TABLE `tbl_tinh`
  ADD PRIMARY KEY (`MATINH`);

--
-- Chỉ mục cho bảng `tbl_tour`
--
ALTER TABLE `tbl_tour`
  ADD PRIMARY KEY (`MATOUR`),
  ADD KEY `MAPHONGKS` (`MAPHONGKS`),
  ADD KEY `MADV` (`MADV`),
  ADD KEY `MAPHUONGTIEN` (`MAPHUONGTIEN`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `tbl_chitietdiemdanh`
--
ALTER TABLE `tbl_chitietdiemdanh`
  MODIFY `MASODD` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT cho bảng `tbl_chitiettinhluong`
--
ALTER TABLE `tbl_chitiettinhluong`
  MODIFY `MASOTINHLUONG` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `tbl_chucvu`
--
ALTER TABLE `tbl_chucvu`
  MODIFY `MACV` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `tbl_dattour`
--
ALTER TABLE `tbl_dattour`
  MODIFY `MADATTOUR` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `tbl_diadiem`
--
ALTER TABLE `tbl_diadiem`
  MODIFY `MADD` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `tbl_dichvu`
--
ALTER TABLE `tbl_dichvu`
  MODIFY `MADV` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  MODIFY `MAHOADON` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=46;

--
-- AUTO_INCREMENT cho bảng `tbl_khachhang`
--
ALTER TABLE `tbl_khachhang`
  MODIFY `MAKH` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `tbl_khachsan`
--
ALTER TABLE `tbl_khachsan`
  MODIFY `MAKS` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `tbl_nhanvien`
--
ALTER TABLE `tbl_nhanvien`
  MODIFY `MANV` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `tbl_phongkhachsan`
--
ALTER TABLE `tbl_phongkhachsan`
  MODIFY `MAPHONGKS` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `tbl_phongtochuc`
--
ALTER TABLE `tbl_phongtochuc`
  MODIFY `MAPTC` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT cho bảng `tbl_phuongtien`
--
ALTER TABLE `tbl_phuongtien`
  MODIFY `MAPHUONGTIEN` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `tbl_tinh`
--
ALTER TABLE `tbl_tinh`
  MODIFY `MATINH` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `tbl_tour`
--
ALTER TABLE `tbl_tour`
  MODIFY `MATOUR` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `tbl_admin`
--
ALTER TABLE `tbl_admin`
  ADD CONSTRAINT `tbl_admin_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `tbl_nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `tbl_chitietdiemdanh`
--
ALTER TABLE `tbl_chitietdiemdanh`
  ADD CONSTRAINT `tbl_chitietdiemdanh_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `tbl_nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `tbl_chitiettinhluong`
--
ALTER TABLE `tbl_chitiettinhluong`
  ADD CONSTRAINT `tbl_chitiettinhluong_ibfk_1` FOREIGN KEY (`MANV`) REFERENCES `tbl_nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `tbl_dattour`
--
ALTER TABLE `tbl_dattour`
  ADD CONSTRAINT `tbl_dattour_ibfk_1` FOREIGN KEY (`MAKH`) REFERENCES `tbl_khachhang` (`MAKH`),
  ADD CONSTRAINT `tbl_dattour_ibfk_2` FOREIGN KEY (`MANV`) REFERENCES `tbl_nhanvien` (`MANV`),
  ADD CONSTRAINT `tbl_dattour_ibfk_3` FOREIGN KEY (`MATOUR`) REFERENCES `tbl_tour` (`MATOUR`);

--
-- Các ràng buộc cho bảng `tbl_diadiem`
--
ALTER TABLE `tbl_diadiem`
  ADD CONSTRAINT `tbl_diadiem_ibfk_1` FOREIGN KEY (`MATINH`) REFERENCES `tbl_tinh` (`MATINH`);

--
-- Các ràng buộc cho bảng `tbl_hoadon`
--
ALTER TABLE `tbl_hoadon`
  ADD CONSTRAINT `tbl_hoadon_ibfk_1` FOREIGN KEY (`MADATTOUR`) REFERENCES `tbl_dattour` (`MADATTOUR`),
  ADD CONSTRAINT `tbl_hoadon_ibfk_2` FOREIGN KEY (`MANV`) REFERENCES `tbl_nhanvien` (`MANV`);

--
-- Các ràng buộc cho bảng `tbl_khachsan`
--
ALTER TABLE `tbl_khachsan`
  ADD CONSTRAINT `tbl_khachsan_ibfk_1` FOREIGN KEY (`MATINH`) REFERENCES `tbl_tinh` (`MATINH`);

--
-- Các ràng buộc cho bảng `tbl_nhanvien`
--
ALTER TABLE `tbl_nhanvien`
  ADD CONSTRAINT `tbl_nhanvien_ibfk_1` FOREIGN KEY (`MACV`) REFERENCES `tbl_chucvu` (`MACV`),
  ADD CONSTRAINT `tbl_nhanvien_ibfk_2` FOREIGN KEY (`MAPTC`) REFERENCES `tbl_phongtochuc` (`MAPTC`);

--
-- Các ràng buộc cho bảng `tbl_phongkhachsan`
--
ALTER TABLE `tbl_phongkhachsan`
  ADD CONSTRAINT `tbl_phongkhachsan_ibfk_1` FOREIGN KEY (`MAKS`) REFERENCES `tbl_khachsan` (`MAKS`);

--
-- Các ràng buộc cho bảng `tbl_tour`
--
ALTER TABLE `tbl_tour`
  ADD CONSTRAINT `tbl_tour_ibfk_1` FOREIGN KEY (`MAPHONGKS`) REFERENCES `tbl_phongkhachsan` (`MAPHONGKS`),
  ADD CONSTRAINT `tbl_tour_ibfk_2` FOREIGN KEY (`MADV`) REFERENCES `tbl_dichvu` (`MADV`),
  ADD CONSTRAINT `tbl_tour_ibfk_3` FOREIGN KEY (`MAPHUONGTIEN`) REFERENCES `tbl_phuongtien` (`MAPHUONGTIEN`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
