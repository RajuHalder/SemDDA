# SemDDA: Semantics-based Database Dependecy Analyzer

SemDDA is a database dependency analyzer written in Java. It provides a user-friendly interface to compute both syntax and semantic-based database-database dependencies in various abstract domains of interest. 

The tool consists of following modules:
* __Proformat:__ It preprocesses input program file to add line numbers (starting from zero) to all statements, ignoring comments. Assuming input programs syntactically correct, the module separates program's statements based on the predefined delimiters and right braces [3]. During this process, it also computes Non-Comment Lines of Code (NCLOC) and the number of SQL statements present in the program. In particular, the presence of Data Manipulation Language (DML) statements is identified based on the presence of keywords such as **SELECT**, **UPDATE**, **DELETE** and **INSERT** in the statements.
* __ExtractInfo:__ This module extracts detail information about input programs, i.e. control statements, defined variables, used variables, etc. for all statements in the program.
* __Dependency:__ It computes syntax-based dependencies among program statements using the information computed by "ExtractInfo" module.
* __Tuning:__ The module automatically picks the best domain based on the  attributes relationship present in SQL statements.
* __Abstraction:__ The module "Abstraction" computes abstract semantics in the chosen abstract domain based on the data-flow analysis. Currently the module supports intervals, octagons and polyhedra abstract domains. 
* __Overlap:__ It identifies false dependency (if any) based on the semantics-based approximation of used and defined parts and their overlapping. 

# System requirements
- JDK version 7 or higher
- 4 GB RAM or higher

# How to run SemDDA
- Step 1: Install JDK 7 or higher  (https://docs.oracle.com/javase/7/docs/webnotes/install/).
- Step 2: Download the source code.
- Step 3: Compile the source code “SemDDA.java” and run. 

# Tool Usage
### Graphical Interface I (accepting inputs from users): 
This is the starting interface window accepting the input program, as shown below:

![alt text](https://github.com/angshumanjana/SemDDA/blob/master/Image/one.png)

With this interface, we have to browse two input files. One is .jsp program file and another one is database file. After browsing the input files, the user can select either syntax or semantic to produce database-database dependency results.  The database file is a simple .txt file that contains program file corresponding to the database tables with a specific format as follows:

1. Table name.
2. Attribute names separated by a comma. 
3. Domain range of each attribute in the form mentioning upper and lower limit.

```
   > Example:   
       events 
       
       eventid,no_of_days,year,no_of_presenters,no_of_perticipants 
       
       1,10,1,20,2000,2020,1,25,1,30
```
Note that, in case of multiple tables the same format as mention above will be repeated.       
      
### Graphical Interface II: 
After browsing the input files, the database-database dependency results in syntax-based approach is shown below: 
   
![alt text](https://github.com/angshumanjana/SemDDA/blob/master/Image/two.png)

### Graphical Interface III: 
After browsing the input files, we select the  semantics-based approach which is shown below: 
   
![alt text](https://github.com/angshumanjana/SemDDA/blob/master/Image/three.png)

### Graphical Interface IV: 
After selecting semantics-based approach, the next step is shown below where the user can choose any one of the abstract domain or the user can choose the tuning button for automatically selecting the best abstract domain. 
   
![alt text](https://github.com/angshumanjana/SemDDA/blob/master/Image/four.png)

### Graphical Interface V: 
After selecting the polyhedra abstract domain, the semantics-based database-database dependency results is shown below: 

![alt text](https://github.com/angshumanjana/SemDDA/blob/master/Image/five.png)

# Remarks
The current implementation accepts only database-driven JSP codes and databases with numerical values.  

# Contributors

- __Developed By:__ Angshuman Jana, Kalahasti Venkata Abhishekh, and Sanjeevini Devi Ganni
- __Release Date:__ July 2018
- __Contact:__ ajana.pcs13@iitp.ac.in / janaangshuman@gmail.com 

# References

1. Angshuman Jana, Raju Halder, K. V. Abhishekh, S. D. Ganni, and Agostino Cortesi. Extending Abstract Interpretation to Dependency Analysis of Database Applications. IEEE Transactions on Software Engineering, Volume xx: xxx-xxx. IEEE, 2018.

2. Bagnara, R., Hill, P.M., Zaffanella, E.: The ppl: Toward a complete set of numerical abstractions for the analysis and verification of hardware and software systems. Tech. rep., Dipartimento di Matematica, Universita' di Parma, Italy (2006). http://www.cs.unipr.it/ppl/

3. Jeannet., B., Mine', A.: Apron: A library of numerical abstract domains for static analysis. In: Proc. of the Int. Conf. on CAV. pp. 661–667 (2009). http://apron.cri.ensmp.fr/library/

4. https://sourceforge.net/p/locjava/wiki/Home/ This application computes the LOC of a Java source code file.

5. Cousot, P., Cousot, R.: Abstract interpretation: a unified lattice model for static analysis of programs by construction or approximation of fixpoints. In: Proc. of the POPL’77. pp. 238–252. ACM Press, Los Angeles, CA, USA (1977).

6. Chernikova, N.V.: Algorithm for discovering the set of all the solutions of a linear programming problem. vol. 8, pp. 282–293 (1968).

7. Ottenstein, K.J., Ottenstein, L.M.: The program dependence graph in a software development environment. ACM SIGPLAN Notices 19(5), 177–184 (1984).

8. Willmor, D., Embury, S.M., Shao, J.: Program slicing in the presence of a database state. In: Proc. of the IEEE ICSM. pp. 448–452 (2004).


