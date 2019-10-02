#include <iostream>
#include <iomanip>
#include <cstdlib>
#include "room.h"

Room::Room() {
  for (int i = 0; i < 17; ++i) {
    room[i] = 0;
    for (int j = 0; j < 10; ++j) {
      availability[j][i] = 0;
    }
  }
}
void Room::readLineOfInput(int x, fstream& fin) {
  char input[256];
  for (int i = 0; i < 16; ++i) {
    fin.getline(input, 256, ',');
    availability[x][i] += atoi(input);
  }
  availability[x][16] = availability[x][16] + 1;
}
void Room::calculateAvailability() {
  for (int i = 0; i < 16; ++i) {
    for (int j = 0; j < 10; ++j) {
      if (availability[j][16] == 0 || availability[j][i] <= 0) {
        availability[j][i] = -1;
      } else {
        availability[j][i] = availability[j][i]/availability[j][16];
      }
    }
  }
}
void Room::displayAvailability() {
  cout << "     ";
  for (int i = 0; i < 16; ++i) {
    cout << setw(4) << room[i];
  }
  cout << endl;
  for (int hourIndex = 0; hourIndex < 10; ++hourIndex) {
    for (int roomIndex = 0; roomIndex < 16; ++roomIndex) {
      if (roomIndex == 0) {
        switch (hourIndex) {
          case 0:
            cout << "08:00";
            break;
          case 1:
            cout << "09:00";
            break;
          case 2:
            cout << "10:00";
            break;
          case 3:
            cout << "11:00";
            break;
          case 4:
            cout << "12:00";
            break;
          case 5:
            cout << "01:00";
            break;
          case 6:
            cout << "02:00";
            break;
          case 7:
            cout << "03:00";
            break;
          case 8:
            cout << "04:00";
            break;
          case 9:
            cout << "05:00";
            break;
        }
      }
      cout << setprecision(1) << setw(4) << getAvailability(hourIndex, roomIndex);
    }
    cout << endl;
  }
}
