public class GlobalMembers
{
	public static int Main()
	{
	  fstream fin = new fstream();
	  Room rooms = new Room();
	  String input = new String(new char[256]);
	  int totalInputs = 0;
	  fin.open("sample_data.csv");
	  if (fin.is_open())
	  {
		fin.getline(input, 256, ',');
		for (int i = 0; i < 16; ++i)
		{
		  fin.getline(input, 256, ',');
		  rooms.setRoom(i, Integer.parseInt(input));
		}
		while (!(fin.eof()))
		{
		  totalInputs += 1;
		  fin.getline(input, 256, ',');
		  switch (Integer.parseInt(input))
		  {
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
	  /*cout << rooms.getAvailability(0,16) << endl;
	    cout << rooms.getAvailability(1,16) << endl;
	    cout << rooms.getAvailability(2,16) << endl;
	    cout << rooms.getAvailability(3,16) << endl;
	    cout << rooms.getAvailability(4,16) << endl;
	    cout << rooms.getAvailability(5,16) << endl;
	    cout << rooms.getAvailability(6,16) << endl;
	    cout << rooms.getAvailability(7,16) << endl;
	    cout << rooms.getAvailability(8,16) << endl;
	    cout << rooms.getAvailability(9,16) << endl;*/
	  }
	  else
	  {
		System.out.print("File not found.");
		System.out.print("\n");
	  }
	}

}