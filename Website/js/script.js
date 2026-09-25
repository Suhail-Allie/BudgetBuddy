// ==========================================
// WEB APP SOLUTIONS
// Client Management & Project Tracking System
// ==========================================


// LOGIN FUNCTIONALITY

const loginForm = document.getElementById("loginForm");

if (loginForm) {

    loginForm.addEventListener("submit", function(event) {

        event.preventDefault();

        const email = document.getElementById("email").value.trim();
        const password = document.getElementById("password").value.trim();

        if (email === "" || password === "") {

            alert("Please enter your username/email and password.");
            return;

        }

        alert("Login successful!");

        window.location.href = "dashboard.html";

    });

}


// REGISTRATION FUNCTIONALITY

const registerForm = document.getElementById("registerForm");

if (registerForm) {

    registerForm.addEventListener("submit", function(event) {

        event.preventDefault();

        const fullName =
            document.getElementById("fullname").value.trim();

        const email =
            document.getElementById("email").value.trim();

        const username =
            document.getElementById("username").value.trim();

        const password =
            document.getElementById("password").value;

        const confirmPassword =
            document.getElementById("confirmPassword").value;


        if (
            fullName === "" ||
            email === "" ||
            username === "" ||
            password === "" ||
            confirmPassword === ""
        ) {

            alert("Please complete all registration fields.");
            return;

        }


        if (password !== confirmPassword) {

            alert("Passwords do not match.");
            return;

        }


        alert(
            "Registration successful! You can now log in."
        );

        window.location.href = "index.html";

    });

}


// DOCUMENT UPLOAD PROTOTYPE

const uploadForm = document.getElementById("uploadForm");

if (uploadForm) {

    uploadForm.addEventListener("submit", function(event) {

        event.preventDefault();


        const project =
            document.getElementById("project").value;

        const documentName =
            document.getElementById("documentName").value.trim();

        const documentFile =
            document.getElementById("documentFile").files[0];


        if (
            project === "" ||
            documentName === "" ||
            !documentFile
        ) {

            alert(
                "Please select a project, enter a document name and choose a file."
            );

            return;

        }


        alert(
            "Document uploaded successfully for prototype demonstration."
        );


        uploadForm.reset();

    });

}