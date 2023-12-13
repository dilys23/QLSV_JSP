<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="Controller.C_Student"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mô hình MVC</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
    <header>
        <h1>Mô hình MVC-Quản lí Sinh Viên</h1>
    </header>
    <div class="wd-center">
        <div class="wd-top-header">
            <div class="wd-top-left">
                <ul class="wd-list-menu-l">
                    <li class="first"><a href="#Tintuc">Tin tức & Sự kiện</a></li>
                    <li><a href="#Thongbao">Thông báo</a></li>
                    <li><a href="#Vanban">Văn bản</a></li>
                    <li><a href="#Lichtuan">Lịch tuần</a></li>
                    <li><a href="#Danhba">Danh bạ</a></li>
                    <li><a href="#Tintuc">Liên hệ</a></li>
                </ul>
            </div>
        </div>
        <div class="Hompage">
            <header class="header">
                <div class="Homepage">
                    <a href="#">
                        <img src="logo-k_cntt.png" />
                    </a>
                </div>
            </header>
            <div class="Menu">
                <nav class="navbar">
                    <!-- Menu tương ứng -->
                    <a href="#Trangchu">HOME</a>
                    <a href="#Gioithieu">GIỚI THIỆU</a>
                    <a href="#Chuongtrinhdaotao">TUYỂN DỤNG</a>
                    <a href="#Tintuc">ĐÀO TẠO</a>
                    <a href="#Nghiencuukhoahoc">NGHIÊN CỨU KHOA HỌC</a>
                    <a href="#Hoptac">HỢP TÁC</a>
                    <a href="#Nhanvien">NHÂN VIÊN</a>
                    <a href="#Cuunhanvien">CỰU NHÂN VIÊN</a>
                    <a href="#Lienhe">LIÊN HỆ</a>
                </nav>
            </div>
        </div>
        <br>
        <div class="menu_ql">
            <ul class="menu_chucnang">
                <li><a href="C_Student?mod=1">Xem sinh viên</a></li>
                <li><a href="C_Student?mod=2">Thêm sinh viên</a></li>
                <li><a href="C_Student?mod=3">Cập nhật sinh viên</a></li>
                <li><a href="C_Student?mod=4">Xóa sinh viên</a></li>
                <li><a href="C_Student?mod=5">Tìm kiếm sinh viên</a></li>
            </ul>
        </div>
    </div>
</body>
</html>
