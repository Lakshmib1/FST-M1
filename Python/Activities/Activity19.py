import pandas as pd
from pandas import ExcelFile
from pandas import ExcelWriter

data = {
  "First Name": ["Lathu", "Jeeva", "Reya"],
  "Last Name": ["Kamesh", "Kumar", "Kumar"],
  "Email": ["lathu@@gmail.com", "Jeeva@gmail.com", "Thunderbird@gmail.com"],
  "phonenumber": ["9791098855", "987897798","7676767676"]
}
 
# Create a new DataFrame using the data
	
dataframe = pd.DataFrame(data)
writer = ExcelWriter("sample.xlsx")

dataframe.to_excel(writer, "Sheet1", index=False)
	
writer.save()