import pandas as pd

data = {
  "Usernames": ["admin", "charles", "deku"],
  "password": ["pasword", "ch123", "deku"],
  
}
 
# Create a new DataFrame using the data
dataframe = pd.DataFrame(data)
 
# Write the data to a csv file
dataframe.to_csv("credentials.csv",index=False)