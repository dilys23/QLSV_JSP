<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Timkiemthongtin</title>
    <style>
        
.Timkiemthongtin 
{
    display: flex;
    flex-direction: column;
    justify-content: center; /* Canh giữa theo chiều ngang */
    align-items: center; /* Canh giữa theo chiều dọc */
    padding: 40px;
    height: 100px;
}
.Timkiemthongtin h4
{
    margin-bottom: 10px;
    display: flex;
}
    </style>
</head>
<body>
    <div class="Timkiemthongtin">
        <h4>Tìm Kiếm Nhân Viên</h4>
        <form method="post" action="?mod=5">
            <label for="search_criteria">Chọn tiêu chí tìm kiếm:</label>
            <input type="radio" name="search_criteria" value="IDSV"> IDSV
            <input type="radio" name="search_criteria" value="Name"> Họ Tên
            <input type="radio" name="search_criteria" value="Age"> Tuổi
            <input type="radio" name="search_criteria" value="University"> Trường
        
            <br>
            <label for="key">Nhập từ khóa tìm kiếm:</label>
            <input type="text" name="key" id="key">
            <input type="submit" name="submit" value="Tìm kiếm">

        </form>
    </div>
    <script>
        document.addEventListener("DOMContentLoaded", function () {
        const keywordInput = document.getElementById("key");
        const searchCriteriaRadios = document.getElementsByName("search_criteria");
    
        // Lắng nghe sự kiện khi người dùng chọn radiobutton
        searchCriteriaRadios.forEach(function (radio) {
            radio.addEventListener("change", function () {
                if (radio.checked) {
                    keywordInput.value = ""; // Xóa nội dung trong trường nhập văn bản
                }
            });
        });
    });
    </script>
   <p><a href="./Mainpage.jsp" style="display: flex;">Back</a></p>
</body>
</html>