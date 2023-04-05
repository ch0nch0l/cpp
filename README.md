# CPP
Customer Processing Project as Java Assessment 

# Repository URL:
  Find the project repository from the following url:
  https://github.com/ch0nch0l/cpp

# How to run the project:
 <br /> • Clone the project and open using IntelliJ idea.
 <br /> • Under Project Structure add postgresql-42.6.0.jar (available under lib folder) as library.
 <br /> • Connect to the Postgres DB server and create Database with desired name.
 <br /> • Go to the DBHelper.java file under helper package and update the database credentials
 <br /> as required.
 <br /> • Execute the create_script.sql available under data\db_scripts directory in your database.
 <br /> • Make two folders input and output under data directory.
 <br /> • Update the input and output file path in Main.java and FileManager.java file.
 <br /> • In input folder copy the provided data source .txt (1M-customers.txt) file.
 <br /> • In Main.java file update counter as required. In requirement document it was mentioned 
 <br /> 100k. Default is 10k.
 <br /> • Build and run the project.
 <br /> • The project will read the input file, validate, remove duplicates and create output files of 
 <br /> valid and invalid customers in data\output folder.
 <br /> • Parallelly data will be inserted into two tables VALID_CUSTOMERS, INVALID_CUSTOMERS.

# Output at my environment:
  <br />• Total time to build the project: 4 second and 901 milli-seconds
  <br />• Total time taken to run the project: 25 second and 253 milli-seconds
  <br />• Output of valid and invalid customer list after executing the project can be found here in 
  <br />following URL:
  <br />  o https://bit.ly/3ZnrMIj
