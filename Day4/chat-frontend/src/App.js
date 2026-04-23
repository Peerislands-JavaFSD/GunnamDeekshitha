import React, { useEffect, useState, useRef } from "react";
import SockJS from "sockjs-client";
import { Client } from "@stomp/stompjs";

function App() {
  const [client, setClient] = useState(null);
  const [messages, setMessages] = useState([]);
  const [message, setMessage] = useState("");
  const [name, setName] = useState("");
  const messagesEndRef = useRef(null);

  useEffect(() => {
    const socket = new SockJS("http://localhost:8080/chat");

    const stompClient = new Client({
      webSocketFactory: () => socket,
      debug: (str) => console.log(str),

      onConnect: () => {
        console.log("Connected");

        stompClient.subscribe("/topic/messages", (msg) => {
          const body = JSON.parse(msg.body);
          setMessages((prev) => [...prev, body]);
        });
      }
    });

    stompClient.activate();
    setClient(stompClient);

    return () => {
      if (stompClient) stompClient.deactivate();
    };
  }, []);

  useEffect(() => {
    messagesEndRef.current?.scrollIntoView({ behavior: "smooth" });
  }, [messages]);

  const sendMessage = () => {
    if (client && message && name) {
      client.publish({
        destination: "/app/send",
        body: JSON.stringify({
          sender: name,
          content: message
        })
      });
      setMessage("");
    }
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>💬 Chat App</h2>

      {/* Name Input */}
      <input
        type="text"
        placeholder="Enter your name"
        onChange={(e) => setName(e.target.value)}
        style={{ marginBottom: "10px", padding: "5px" }}
      />

      {/* Chat Box */}
      <div
        style={{
          border: "1px solid #ccc",
          height: "350px",
          overflowY: "auto",
          padding: "10px",
          backgroundColor: "#f9f9f9",
          marginBottom: "10px"
        }}
      >
        {messages.map((msg, index) => (
          <div
            key={index}
            style={{
              textAlign: msg.sender === name ? "right" : "left",
              marginBottom: "8px"
            }}
          >
            <span
              style={{
                display: "inline-block",
                padding: "8px 12px",
                borderRadius: "10px",
                backgroundColor:
                  msg.sender === name ? "#DCF8C6" : "#E5E5EA",
                maxWidth: "60%"
              }}
            >
              <b>{msg.sender}</b>: {msg.content}
            </span>
          </div>
        ))}
        <div ref={messagesEndRef}></div>
      </div>

      {/* Input + Button */}
      <input
        type="text"
        placeholder="Type a message"
        value={message}
        onChange={(e) => setMessage(e.target.value)}
        style={{ padding: "5px", width: "70%" }}
      />

      <button
        onClick={sendMessage}
        style={{
          padding: "6px 12px",
          marginLeft: "10px",
          cursor: "pointer"
        }}
      >
        Send
      </button>
    </div>
  );
}

export default App;