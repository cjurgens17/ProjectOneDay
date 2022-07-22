let loginButton = document.getElementById("button");
console.log(loginButton);

loginButton.addEventListener("click", (event) => {

    event.preventDefault();


    let xhttp = new XMLHttpRequest();

    let username = document.getElementById("username_input_sign_in").value;

    let password = document.getElementById("password_input_sign_in").value;

    let loginInfo = {
        username: username,
        password: password,
    }

    console.log(loginInfo);

    xhttp.onreadystatechange = function(){

        if(this.readyState == 4 && xhttp.status === 200){
            console.log(xhttp.responseText);

            let data = JSON.parse(xhttp.responseText);
            console.log(data);

            localStorage.setItem('currentUser', JSON.stringify(data));

            window.location.replace("homepage.html");


        } else if(this.readyState == 4 && xhttp.status == 204){
            console.log(xhttp.responseText)
            alert("Failed to Login: Status Code - " + xhttp.status)
        }
    };

    xhttp.open("POST",`http://localhost:8080/OneDay/home`);

    xhttp.setRequestHeader("Access-Control-Allow-Origin","*");
    xhttp.setRequestHeader("Content-Type","application/json");

    console.log(xhttp)

    xhttp.send(JSON.stringify(loginInfo));

    




})

let loginButton2 = document.getElementById("register_button");

loginButton2.addEventListener("click", (event) => {
    event.preventDefault();

    window.location.replace("register.html");
})