package com.example.javaconvert;
import java.io.*;

public class GlobalMembers
{
    public static void Main() {
        try {
            int i;
            Room rooms = new Room();
            InputStream fin = new FileInputStream("sample_data.csv");
            while ((i = fin.read()) != 1) {
                switch (i) {
                    case 8:
                        rooms.readLineOfInput(0, fin);
                        break;
                    case 9:
                        rooms.readLineOfInput(1, fin);
                        break;
                    case 10:
                        rooms.readLineOfInput(2, fin);
                        break;
                    case 11:
                        rooms.readLineOfInput(3, fin);
                        break;
                    case 12:
                        rooms.readLineOfInput(4, fin);
                        break;
                    case 13:
                        rooms.readLineOfInput(5, fin);
                        break;
                    case 14:
                        rooms.readLineOfInput(6, fin);
                        break;
                    case 15:
                        rooms.readLineOfInput(7, fin);
                        break;
                    case 16:
                        rooms.readLineOfInput(8, fin);
                        break;
                    case 17:
                        rooms.readLineOfInput(9, fin);
                        break;
                }
            }
            fin.close();
            rooms.calculateAvailability();
            rooms.displayAvailability();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
