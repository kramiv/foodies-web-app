# foodies-web-app
Dev10 Capstone Project: java, spring, react, MVC

Requirements
====================================
* Docker
* Npm

Running the application
====================================
1. Clone the repo
2. In a terminal, navigate to ./capstone-project/capstone-project-server
3. Run "docker compose -f .\docker-compose.yml up -d"
4. Run ./capstone-project/capstone-project-server/App.class
5. Navigate to ./capstone-project/capstone-project-client in the terminal
6. Install the project in ./capstone-project/capstone-project-client with "npm install"
7. Run "npm start"




**Technical Explanation of app:**
Purpose of this summary: review the technical details of Java Spring React bootcamp capstone to prepare to present it. Also, to review/learn Java, Spring, and React specifics.

The stack for this project is centered around Java in the back-end. 
IntelliJ was the IDE used to generate a Java project using Maven. (Maven is a common tool to manage dependencies, create jar files, and aid in deployment. It is similar to Gradle and Ant.)
The software design pattern used in the back-end/”capstone-project-server” is MVC. (Other common back-end software design patterns for web development include: Repository, Dependency Injection, Observer, Decorator).
	MVC is extremely common. 
My personal use-case summary of MVC: an app is concerned with data and how to validate data from users and how to validate updates from new features implemented by developers. User input is validated in the controller (“C” of MVC), and new features are validated through a test-driven approach. There are multiple ways to perform testing.
	M = Model: 
Models are classes/objects. Each class/object contains 1+ constructors. Each object/class also has its own getters/setters (which is standard for each field of an object). Access modifiers on each getter/setter help promote encapsulation (one of the pillars of OOP) because fields can only be updated through getters and setters specifically as needed throughout the app instead of accidentally updating the model directly. Access is limited through Java’s access modifiers (private = same class only, default = same package only, protected = same package or subpackage, public = whole app). These getters and setters are used in other parts of the app to perform this validation.
 Models are in their own package, “models”. It contains classes that are used in back-end data storage and business logic. 
The package “models” also contains a sub-package, “viewmodels”. The package “viewmodels” contains objects that are used to receive information from the client/user in the controller classes. (They are used in methods that are mapped by endpoints. The “requestmapping” endpoints are ‘live’ when the app is hosted. Spring has a built-in Tomcat server on a local port. Another tool similar to Tomcat is Jboss.) 
V = View: 
	C = Controller: Controller is the ‘live’ “requestmapping” endpoints described above. They are used to handle http requests. Spring framework has some pre-built ‘http’ functionality that is used in this project to return broad error messages to the user without revealing sensitive data. Each controller method also verifies whether the user can use the method through spring security (for non-public features). Controllers may use service/business logic/’domain’ layer methods that are called from these methods using object inputs from the “models.viewmodels” folder. 
		Domain/Service layer: business logic is implemented here. 

MVC was facilitated using the Spring Framework. A ‘framework’ refers to 


Ways to perform testing and set it up + JUnit. Sql + stored procedures. 


How does front-end connect to endpoints mapping in application server?
And how does app connect to server?
Docker is used for back-end connectivity. Normally, we used mysql workbench. In this project, we used mongodb which has built-in ORM syntax. https://spring.io/projects/spring-data-mongodb/
	Typically, Docker is used to create one container per process as a rule of thumb. For this app, that would be client, server, and database (this rule of thumb follows separation of responsibilities). Another container would be used to route the front-end to the back-end. Then, they are made ‘live’ using docker compose or kubernetes. 
		Kubernetes is typically used to run containers. It manages containers that fail and replaces them automatically. Kubernetes runs a container on multiple hosts whereas Docker runs a container on a single host. 
(what implications does this have for the database - parallel updates?) (I don’t fully understand what a “cluster” is)

Todo:
Global search method “corsConfigurer” to see where it is used
Note the error handling in each layer of the app
