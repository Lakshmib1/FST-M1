from asyncio import FastChildWatcher
from imp import reload
from socket import CAN_RAW


class car:
    'This is a car class'

    def __init__(self,manfacture,model,make,trans,color):
        self.manfacture = manfacture
        self.model = model
        self.make = make
        self.trans = trans
        self.color = color

    def Accelerate(self):
        print(self.manfacture +" "+self.model+ " "+ "has started moving")

    def stop(self):
        print(self.manfacture +" "+self.model+ " "+ "has stopped")

car1 = car("Toyota", "Corolla", "2015", "Manual", "White")
car2 = car("Honda", "something", "2018", "Auto", "black")

car1.Accelerate
car1.stop
