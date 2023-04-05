# CPP
Customer Processing Project as Java Assessment 

# Repository URL:
  Find the project repository from the following url:
  https://github.com/ch0nch0l/cpp

# How to run the project:
  • Clone the project and open using IntelliJ idea.
  • Under Project Structure add postgresql-42.6.0.jar (available under lib folder) as library.
  • Connect to the Postgres DB server and create Database with desired name.
  • Go to the DBHelper.java file under helper package and update the database credentials
  as required.
  • Execute the create_script.sql available under data\db_scripts directory in your database.
  • Make two folders input and output under data directory.
  • Update the input and output file path in Main.java and FileManager.java file.
  • In input folder copy the provided data source .txt (1M-customers.txt) file.
  • In Main.java file update counter as required. In requirement document it was mentioned 
  100k. Default is 10k.
  • Build and run the project.
  • The project will read the input file, validate, remove duplicates and create output files of 
  valid and invalid customers in data\output folder.
  • Parallelly data will be inserted into two tables VALID_CUSTOMERS, INVALID_CUSTOMERS.

# Output at my environment:
  • Total time to build the project: 4 second and 901 milli-seconds
  • Total time taken to run the project: 25 second and 253 milli-seconds
  • Output of valid and invalid customer list after executing the project can be found here in 
  following URL:
    o https://bit.ly/3ZnrMIj
