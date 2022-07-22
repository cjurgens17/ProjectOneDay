let registerButton = document.getElementById("new_user");
console.log(registerButton);

registerButton.addEventListener("click", (event) => {

    event.preventDefault();


    let xhttp = new XMLHttpRequest();

    let username = document.getElementById("username_input").value;

    let password = document.getElementById("password_input").value;

    let horoscope = document.getElementById("zodiac_sign").value;

    let nickname = document.getElementById("first_name").value;

    let newUser = {
        username: username,
        password: password,
        horoscope: horoscope,
        nickname: nickname,
    }

    console.log(newUser);

    xhttp.onreadystatechange = function(){

        if(this.readyState == 4 && xhttp.status === 200){
            console.log(xhttp.responseText);

            let data = JSON.parse(xhttp.responseText);
            console.log(data);

            // localStorage.setItem('currentUser', JSON.stringify(data));

            window.location.replace("index.html");


        } else if(this.readyState == 4 && xhttp.status == 204){
            console.log(xhttp.responseText)
            alert("Failed to Login: Status Code - " + xhttp.status)
        }
    };

    xhttp.open("POST",`http://localhost:8080/OneDay/newUser`);

    xhttp.setRequestHeader("Access-Control-Allow-Origin","*");
    xhttp.setRequestHeader("Content-Type","application/json");

    console.log(xhttp)

    xhttp.send(JSON.stringify(newUser));

    




})

    




