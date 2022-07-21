let button = document.getElementById("button")

button.addEventListener('click', async() => {

    // var inputValue = document.getElementById("field").value;

    try {



        const raw_response = await fetch(`http://sandipbgt.com/theastrologer/api/horoscope/pisces/today`);

        if(!raw_response.ok){
            throw new Error(raw_response.status)
        }

        const json_data = await raw_response.json();

        console.log(json_data)

        var input = document.getElementById("input");
        var horoscope = document.createElement('h2');

        horoscope.innerHTML = `Todays Scope: ${json_data.horoscope}`;
        input.append(horoscope);

        var b = document.createElement('br');
        input.append(b);

        // var id = document.createElement('h3');
        // id.innerHTML = `ID: ${json_data.id}`;
        // input.append(id);
        // input.append(b);

        // var image = document.createElement('img');
        // image.setAttribute("src", json_data.sprites.front_default);
        // image.setAttribute("height", "300");
        // image.setAttribute("width", "300");

        // input.append(image);
        // input.append(b);

        // var line = document.createElement('hr');
        // input.append(line);













    }catch(error){
        console.log(error);
    }


})