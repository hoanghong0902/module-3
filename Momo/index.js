function login(){
    let username = $(username).val();
    let password = $(password).val();
    let loginRequestDto = {
        username: username,
        password: password
    };

    // gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(loginRequestDto),
        //tên API
        url: "http://localhost:8080/login",
        //xử lý khi thành công
        success: (r) =>{ window.location.href = 'home.html';}

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}