window.onload = function () {
    var messages = [];
    var message = document.getElementById("message");
    var sendButton = document.getElementById("send");
    var content = document.getElementById("content");
    var name = document.getElementById("name");
        alert(message.value +" "+name.value);
    var socket = io.connect('http://localhost:3700', {
        'force new connection': true
    });
  alert(2);
    socket.on('connect', function () {
        console.log('connected');
    });
	 alert(3);
 
    socket.on('message', function (data) {
        if (data.message) {
            messages.push(data);
            var html = '';
            for (var i = 0; i < messages.length; i++) {
                html += '<b>' + (messages[i].name ? messages[i].name : 'Server') + ': </b>';
                html += messages[i].message + '<br />';
            }
            content.innerHTML = html;
            content.scrollTop = content.scrollHeight;
        } else {
            console.log("There is a problem:", data);
        }
    });
   alert(4);
    sendButton.onclick = function () {
		alert("indi");
        if (name.value == "") {
            alert("Please type your name!");
        } else {
            var text = message.value;
            console.log(name.value + ': ' + text);
            socket.emit('send', {message: text, name: name.value});
        }
    };
  alert(5);
}