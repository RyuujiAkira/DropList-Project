'use strict';

// Grab all of the elements I need
let parentDiv = document.querySelector('#cardDiv');
let newBtn = document.querySelector('#addCardBtn');
let newCardExample = document.querySelector('.card');
let submitBtn = document.querySelector('#submitBtn');
let viewBtn = document.querySelector('#viewAllBtn');

// Create a function to create my card
let createCardBrands = () => {
    // Creating elements
    let newCardDiv = document.createElement('div');
    let newCardLink = document.createElement('a');
    let newCard = document.createElement('div');
    let newCardImg = document.createElement('img');
    let newCardBody = document.createElement('div');
    let newTitle = document.createElement('h1');
    let newDeleteBtn = document.createElement('a');
    let newEditBtn = document.createElement('a');

    // Modifying class lists
    newCardDiv.classList = "col";
    newCard.classList = "card bg-black";
    newCardImg.classList = "card-img-top opacity-25";
    newCardBody.classList = "card-img-overlay";
    newTitle.classList = "card-title text-white position-absolute top-50 start-50 translate-middle";
    newDeleteBtn.classList = "btn btn-primary position-absolute top-0 end-0";
    newEditBtn.classList = "btn btn-primary position-absolute bottom-0 end-0";

    // Setting the element text content
    newTitle.textContent = document.getElementById('brandName').value;
    newCardImg.src = "data:image/jpeg;base64,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"

    newDeleteBtn.textContent = "Delete";
    newEditBtn.textContent = "Edit";

    newEditBtn.setAttribute('data-bs-toggle', "modal");
    newEditBtn.setAttribute('data-bs-target', "#staticBackdrop");

    newCardLink.setAttribute('href', "https://stockx.com/search?s=cdg");
    newCardLink.setAttribute('target', "_blank");

    // Append everything.. 
    newCardBody.appendChild(newDeleteBtn);
    newCardBody.appendChild(newEditBtn);
    newCardBody.appendChild(newTitle);

    newCard.appendChild(newCardImg);
    newCard.appendChild(newCardBody);

    newCardDiv.appendChild(newCard);
    newCardDiv.appendChild(newCardLink);

    parentDiv.appendChild(newCardDiv);
}

// A function that saves the value of the input field
let postData = () => {

    let brandNameValue = brandName.value;
    let brandTypeValue = brandType.value;

    let newObject = {
        brandName: brandNameValue,
        brandType: brandTypeValue,
    };

    // Run fetch function
    postFetch(newObject);

    return newObject
};

// POST request - Creating data and pushing it into a database
// POST request we also need to pass in a BODY of data
// Data we get back will likely be using the data we sent

// This is the object we are creating to post to the backend

let postFetch = (object) => {
    fetch("http://localhost:8080/brand/create", {
        method: "POST", // We are specifying we are POSTing data
        headers: {
            "Content-type": "application/JSON", // Telling the server we are sending JSON
        },
        body: JSON.stringify(object), // We will be creating an object and passing it in here
    }).then((response) => {
        if (response.status !== 201) {
            console.error(`Status: ${response.status}`);
            return;
        }
        response.json().then((data) => {
            console.log(data);
        });
    });
};

// Delete Request - ID of the thing we want to delete
// Isnt going to be submitted as a body, it is going to be submitted as a URL parameter 

// Get by ID    - URL or Query parameters
// Update by ID - URL or Query parameters

let deleteRequest = (brandID) => {

    fetch(`https://localhost:8080/brand/${id}`, {
        method: `DELETE`
    })
        .then((response) => {
            if (response.status !== 200) {
                console.error(`Status: ${response.statusText}`);
                return;
            }
            response.json()
                .then((data) => {
                    console.log(data);
                });
        });

};

// Get all request
let getAllRequest = () => {

}

// Tell our button to run this function when its clicked
submitBtn.addEventListener('click', createCardBrands);
submitBtn.addEventListener('click', postData);

newDeleteBtn.addEventListener('click', deleteRequest);

newEditBtn.addEventListener('click',);

viewBtn.addEventListener('click', getAllRequest)