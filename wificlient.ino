/*
    This sketch sends a string to a TCP server, and prints a one-line response.
    You must run a TCP server in your local network.
    For example, on Linux you can use this command: nc -v -l 3000
*/

#include <ESP8266WiFi.h>
#include <ESP8266WiFiMulti.h>

#ifndef STASSID
#define STASSID "Number1"
#define STAPSK  "43-Engineering"
#endif

const char* ssid     = STASSID;
const char* password = STAPSK;

const char* host = "192.168.1.4";
const uint16_t port =5000;

ESP8266WiFiMulti WiFiMulti;
WiFiClient cl;

void setup() {
  Serial.begin(9600);
  // We start by connecting to a WiFi network
  WiFi.mode(WIFI_STA);
  WiFiMulti.addAP(ssid, password);

  Serial.println();
  Serial.print("Wait for WiFi... ");

  while (WiFiMulti.run() != WL_CONNECTED) {
    Serial.print(".");
    delay(500);
  }

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: ");
  Serial.println(WiFi.localIP());
  Serial.print("connecting to ");
  Serial.print(host);
  Serial.print(':');
  Serial.println(port);
  while(!cl.connect(host, port)) {
   Serial.println("connection failed");
   Serial.println("wait 5 sec...");
   delay(5000);
 } 
 Serial.println("Connected to server");
}


void loop() {
  String msg = Serial.readStringUntil('\n');
   if(msg.equalsIgnoreCase("close socket")){
     cl.println(msg);
    Serial.println("Socket is closed");
     cl.stop();
  }
  else {
    if(msg.equals("")){
      return;
    }
     else{
      if(cl.connected()){
        cl.println(msg);
        Serial.println("receiving from remote server");
        String line = cl.readStringUntil('\n');
        Serial.println(line);
      }
    }
  }
}
