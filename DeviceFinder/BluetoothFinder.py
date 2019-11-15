import pyrebase
from bluetooth import *
import socket
import time
config = {
  "apiKey": "",
  "authDomain": "proxy-193e1.firebaseapp.com",
  "databaseURL": "https://proxy-193e1.firebaseio.com/",
  "storageBucket": "proxy-193e1.appspot.com"
}
while True:
    firebase = pyrebase.initialize_app(config)
    database = firebase.database()
    nearby_devices = discover_devices(lookup_names = False)
    print("found %d devices" % len(nearby_devices))
    #finds number of bluetooth devices and writes to firebase

    database.child("NUM DEVICES").set(str(len(nearby_devices)))
    time.sleep(60)



