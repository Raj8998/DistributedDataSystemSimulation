# Distributed Data System Simulation

* The goal of this project was to get some hands-on experience with  Spring Beans and Dependency Injection Concept. Also, one of the focus areas was implementing S.O.L.I.D. Programming Principles in the design.
* The idea behind this project is a primitve solution to the issue that arises when a certain dataset is too large to be processed on a single computing  system and has to be distributed and processed over multiple systems. In my project, I am proposing a solution for the issue of checking for duplicates in such dataset. 
* The solution is based on the idea of hashing each data instance and assigning it to a particular computing system. If the hash function is properly constructed, we will always assign the same values to the same computing system and therefore we can reckognize the duplicates. We can also be sure that the duplicate wasn't assigned to some other computing system, other than the one containing the initial value. 
## Components (Interfaces)
Components created to design this data distribution model are fairly simple. Let us first visualise and discuss the interfaces that govern the communication process between the components.
* FileHandlerEssentials -> (DataInstance) -> Receiver -> Distributer -> Consumer
* On the very top of the pipeline  is "FileHandlerEssentials" interface which ensures that the data being forwarded along the pipeline implements "DataInstance" interface. This data instance is then forwarded to the "Receiver". In my solution, the "Receiver" is simultaneously the "Distributer" as well, but that doesn't have to be the general case. Distributer has a line of communication with all "Consumers" and passes the data down the pipeline.  Consumers are able to receive the data and manipulate it accordingly to their specifications. 
## Components (Classes)
Each interface is implemented by only one class. I will visually represent the classes in the same manner as the interfaces, since they correspond to one another.
* [Interfaces] FileHandlerEssentials -> (DataInstance) -> Receiver -> Distributer -> Consumer
* [Classes]      FileHandler -> (GunOffender) -> DataArbiter -> ComputingSystem(s)
* In this solution, the FileHandler class handles the data input as a JSON formatted file and extracts the data about gun offenders (Gun Offender Registry databaseOpen Baltimore Persons convicted of at least one gun-related offense that are required to register their name and address with police). That provides the explanation for the GunOffender class. GunOffender instances are being passed to the DataArbiter which, based on each hashcode forwards them to the corresponding ComputingSystem.  
## Additional Notes
The design was created in such manner that we can easily replace, for example, FileHandler that handles JSON format with some handler that handles CSV or XML files. All we are required to do is implement the interface that governs the communication between file handler and data arbiter.
Additionally, Spring was used to inject the specifics of the code such as the number of available computing systems or the file that should be handled by the file handler.

## Getting Started
Getting started,prerequisites, tests and additional info will be provided soon...

## Authors

* **Jurica Kenda** - *Initial work* - [JuricaKenda](https://github.com/juricaKenda)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
