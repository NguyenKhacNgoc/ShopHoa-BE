function timkiemgia() {
    tu = document.getElementById("giatu").value;
    den = document.getElementById("giaden").value;

    loi_timkiem = document.getElementById("loitimkiem");
    if (tu == "" || den == "") {
        alert("Không được để trống các ô tìm kiếm"); 
    }
    else if (isNaN(tu) || isNaN(den)) {
        alert("Giá phải là số");
    }
    else if (parseInt(tu) < 0 || parseInt(den) < 0) {
        alert("Giá trị phải lớn hơn 0");
    }
    else if (parseInt(tu) > parseInt(den)) {
        alert("Giá trị sau phải lớn hơn giá trị trước");
    }
}