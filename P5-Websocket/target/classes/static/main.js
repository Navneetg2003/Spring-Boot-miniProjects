var stompClient = null;

// Encryption and Decryption Key
const encryptionKey = "uov87GSQDvgkuOYVouv98QEWU";

// Function to encrypt messages
function encryptMessage(message) {
    return CryptoJS.AES.encrypt(message, encryptionKey).toString();
}

// Function to decrypt messages
function decryptMessage(encryptedMessage) {
    const bytes = CryptoJS.AES.decrypt(encryptedMessage, encryptionKey);
    return bytes.toString(CryptoJS.enc.Utf8);
}

// Send encrypted message
function sendMessage() {
    let messageContent = $("#message-value").val();
    const encryptedMessage = encryptMessage(messageContent); // Encrypt the message

    let jsonOb = {
        name: localStorage.getItem("name"),
        content: encryptedMessage // Send the encrypted message
    };

    stompClient.send("/app/message", {}, JSON.stringify(jsonOb)); // Send to the server
    $("#message-value").val(''); // Clear input field
}

// Function to display decrypted message
function showMessage(message) {
    const decryptedMessage = decryptMessage(message.content); // Decrypt the message content

    $("#message-container-table").prepend(`
        <tr>
            <td>
                <b>${message.name}:</b> ${decryptedMessage}
            </td>
        </tr>
    `);
}

// Function to handle incoming encrypted messages
function handleIncomingMessage(encryptedMessage) {
    const decryptedMessage = decryptMessage(encryptedMessage);
    $('#message-container-table').append('<tr><td>' + decryptedMessage + '</td></tr>');
}

// Connect to the server
function connect() {
    let socket = new SockJS("/server1");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log("Connected: " + frame);
        $("#name-from").addClass('d-none');
        $("#chat-room").removeClass('d-none');

        // Subscribe to messages
        stompClient.subscribe("/topic/return-to", function(response) {
            const message = JSON.parse(response.body);
            showMessage(message); // Use showMessage to decrypt and display the message
        });
    });
}

// Document Ready
$(document).ready(() => {
    const correctPassword = "1234";  // Replace with your desired password

    $("#login").click(() => {
        let name = $("#name-value").val();
        let password = $("#password-value").val();

        if (name.trim() === "") {
            alert("Please enter your name.");
            return;
        }

        if (password !== correctPassword) {
            alert("Incorrect password. Please try again.");
            return;
        }

        // If password is correct, save name and password, and allow entry
        localStorage.setItem("name", name);
        localStorage.setItem("password", password);  // Optional: save the password (but not recommended in production)
        $("#name-title").html(`Welcome, <b>${name}</b>`);
        connect();
    });

    $("#send-btn").click(() => {
        if ($("#message-value").val().trim() !== "") {
            sendMessage(); // Encrypt and send the message
        }
    });

    // Enter key functionality for sending messages
    $("#message-value").keypress((e) => {
        if (e.which === 13 && $("#message-value").val().trim() !== "") {
            sendMessage(); // Encrypt and send the message
        }
    });

    $("#logout").click(() => {
        localStorage.removeItem("name");
        localStorage.removeItem("password");
        if (stompClient !== null) {
            stompClient.disconnect();
            $("#name-from").removeClass('d-none');
            $("#chat-room").addClass('d-none');
        }
    });
});
