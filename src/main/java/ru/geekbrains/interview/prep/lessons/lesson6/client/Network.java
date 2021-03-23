package ru.geekbrains.interview.prep.lessons.lesson6.client;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;

public class Network {

    private Socket socket;
    private OutputStream out;
    private BufferedReader in;
    private final String SERVER_ADDRESS = "localhost";
    private final int SERVER_PORT = 8189;


    private static Network instance;
    public synchronized static Network getInstance(){
        if(instance == null) instance = new Network();
        return instance;
    }
    private Network(){}

    public void connect(CountDownLatch connectCheck){
        try {
            socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = socket.getOutputStream();
            connectCheck.countDown();

            new Thread(new Runnable() {
                @Override
                public void run() {
                StringBuilder response = new StringBuilder();
                    try {
                        System.out.println("Ждем сообщение от сервера.");
                        int ch = in.read();
                        while (ch != -1) {
                            response.append((char)ch);
                            ch = in.read();
                        }
                        System.out.println(response.toString());
                    }catch (Exception e){
                        e.printStackTrace();
                        disconnect();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
            disconnect();
        }
    }

    public void disconnect(){
        if(out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(socket != null) {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendGET(){
        System.out.println("Отправляем запрос GET");

        String request =
                "GET / HTTP/1.1\r\n" +
                "Host: localhost:8189\r\n\r\n";
        try {
            out.write(request.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Запрос GET отправлен");
    }

    public void sendPOST(){
        System.out.println("Отправляем запрос POST");

        String request =
                "POST / HTTP/1.1\r\n" +
                "Host: localhost:8189\r\n\r\n";
        try {
            out.write(request.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Запрос POST отправлен");
    }

}
