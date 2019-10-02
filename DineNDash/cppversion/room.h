#ifndef ROOM
#define ROOM
using namespace std;
#include <vector>
#include <string>
#include <fstream>

class Room {
public:
  Room();
  void setRoom(const int& x, const int& num) { room[x] = num; }
  double getAvailability(const int& x, const int& y) { return availability[x][y]; }
  void readLineOfInput(int x, fstream& fin);
  void calculateAvailability();
  void displayAvailability();
private:
  int room[16];
  double availability[10][17];
};

#endif
