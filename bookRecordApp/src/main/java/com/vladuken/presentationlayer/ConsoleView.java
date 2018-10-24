package com.vladuken.presentationlayer;


import com.vladuken.util.scanner.Reader;

public class ConsoleView {

    public ConsoleView() {
    }

    private void main(){
        String comand;
        while(true){
            comand = Reader.readString();

            switch (comand){
                case "help":
                    break;
                case "login":
                    break;
                case "register":
                    break;

                case "add":
                    break;
                case "update":
                    break;
                case "delete":
                    break;

                case "show":
                    break;
            }
        }
    }

}
