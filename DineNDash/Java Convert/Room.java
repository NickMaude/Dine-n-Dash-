package com.example.javaconvert;
import java.io.*;

public class Room
{
    public Room()
    {
        for (int i = 0; i < 17; ++i)
        {
            room[i] = 0;
            for (int j = 0; j < 10; ++j)
            {
                availability[j][i] = 0;
            }
        }
    }

    public void setRoom(final int x, final int num)
    {
        room[x] = num;
    }
    public double getAvailability(final int x, final int y)
    {
        return availability[x][y];
    }
    public final void readLineOfInput(int x, InputStream fin)
    {
        String input = new String(new char[256]);
        for (int i = 0; i < 16; ++i)
        {
            try {
                fin.read();
                availability[x][i] += Integer.parseInt(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        availability[x][16] = availability[x][16] + 1;
    }

    public final void calculateAvailability()
    {
        for (int i = 0; i < 16; ++i)
        {
            for (int j = 0; j < 10; ++j)
            {
                if (availability[j][16] == 0 || availability[j][i] <= 0)
                {
                    availability[j][i] = -1;
                }
                else
                {
                    availability[j][i] = availability[j][i] / availability[j][16];
                }
            }
        }
    }

    public final void displayAvailability()
    {
        System.out.print("     ");
        for (int i = 0; i < 16; ++i)
        {
            System.out.printf("%4d", room[i]);
        }
        System.out.printf("%4d", "\n");
        for (int hourIndex = 0; hourIndex < 10; ++hourIndex)
        {
            for (int roomIndex = 0; roomIndex < 16; ++roomIndex)
            {
                if (roomIndex == 0)
                {
                    switch (hourIndex)
                    {
                        case 0:
                            System.out.printf("%4d", "08:00");
                            break;
                        case 1:
                            System.out.printf("%4d", "09:00");
                            break;
                        case 2:
                            System.out.printf("%4d", "10:00");
                            break;
                        case 3:
                            System.out.printf("%4d", "11:00");
                            break;
                        case 4:
                            System.out.printf("%4d", "12:00");
                            break;
                        case 5:
                            System.out.printf("%4d", "01:00");
                            break;
                        case 6:
                            System.out.printf("%4d", "02:00");
                            break;
                        case 7:
                            System.out.printf("%4d", "03:00");
                            break;
                        case 8:
                            System.out.printf("%4d", "04:00");
                            break;
                        case 9:
                            System.out.printf("%4d", "05:00");
                            break;
                    }
                }
                System.out.printf("%4.1d", getAvailability(hourIndex, roomIndex));
            }
            System.out.printf("%4.1d", "\n");
        }
    }

    private int[] room = new int[16];
    private double[][] availability = new double[10][17];
}

