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




**Technical explanation of app**

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
Part of the Model layer involves database interactions. Data is stored based on the objects in the Models package. 
The Model layer is generally responsible for getting data. The controller and view layers do not care where the data comes from. Data can come from a database (through interactions in the repository/data layer using files with “repo” in the name), or through API callouts.
Normally, API requests to, say, get more data occur in this layer. In this project, callouts were done in the front-end which isn’t really correct. For Spring MVC (exact best practice differs per framework for MVC implementation), with an example: callouts should occur in the service layer (i.e. controllers) via an interface. A class implementing this can be created to execute the callout. In terms of more specific package structure and best practices for that, I’d need to research more examples. 
V = View: 
This layer is the client-side. It is built based on interactions with the DOM. This presents data and is implemented using javascript and a javascript framework, React, in this project. It is what the user directly sees and clicks, hovers, etc. on. 
	C = Controller: 
Controller is the ‘live’ “requestmapping” endpoints described above. They are used to handle http requests implemented from within the application (i.e. not external http requests). Spring framework has some pre-built ‘http’ functionality that is used in this project to return broad error messages to the user without revealing sensitive data. Each controller method also verifies whether the user can use the method through spring security (for non-public features). Controllers may use service/business logic/’domain’ l ayer methods that are called from these methods using object inputs from the “models.viewmodels” folder. As for specific folder structure or best practices specific to that, I’d need to research it more. 
		Domain/Service layer: business logic is implemented here to perform validation logic on back-end models/classes/objects in the models package. 
		‘Additional’ layers: Security, at least in this app. I’d need to research to see if there are more common packages.
		General notes: 
Implementing an MVC app was facilitated using the Spring Framework. A ‘framework’ is a pre-built structure to facilitate development. There are front-end frameworks as well, such as Angular and React. CSS framework example: bootstrap. 

How does the front-end connect to endpoints in application server’s controller files?
	I think that it uses Spring Framework’s built-in tomcat connectivity. The port is configured with some login somewhere in the IDE’s settings - I think. I don’t fully remember it. 


And how does the app connect to the database?
Docker is used for back-end connectivity. Normally, we used mysql workbench. In this project, we used mongodb which has built-in ORM syntax. https://spring.io/projects/spring-data-mongodb/
	Typically, Docker is used to create one container per process as a rule of thumb. For this app, that would be client, server, and database (this rule of thumb follows separation of responsibilities). Another container would be used to route the front-end to the back-end. Then, they are made ‘live’ using docker compose or kubernetes. 
		Kubernetes is typically used to run containers. It manages containers that fail and replaces them automatically. Kubernetes runs a container on multiple hosts whereas Docker runs a container on a single host. 
(what implications does this have for the database - parallel updates?) (I don’t fully understand what a “cluster” is)

Todo:
Ways to perform testing and set it up + JUnit. Sql + stored procedures.
Global search method “corsConfigurer” to see where it is used
Note the error handling in each layer of the app
What happens when user enters bad data i.e. where does that validatoni occur and how?
Todo: research the ‘addtional’ layers and objects they use
Todo: research specifics of how security is set up

Todo remaining for today: ^ this stuff above
And read saic interview prep + job posting. Summarize stuff
Tomorrow: read resume

‘Why should I hire you’ → outline requirements. 

How does a security filter chain work in Spring?
Spring Security maintains a filter chain internally where each of the filters has a particular responsibility and filters are added or removed from the configuration depending on which services are required. The ordering of the filters is important as there are dependencies between them.
→ there would be a security config class with @EnableWebSecurity
Why are roles useful in security?
Role-based security is a method of restricting access based on the roles of individual users within an enterprise. It ensures employees access only information they need to do their jobs and prevents them from accessing information that doesn't pertain to them.
Example: public, registered user, admin
How should passwords be stored? (I think this is just one way of doing it)
Hash the password using a secure 1-way algorithm and store the hash, throwing away the original password. Then, when you want to verify a password, hash the value (using the same hashing algorithm) and compare it to the hashed value in the database.
Example: can use json web tokens (jwt) and a converter that are configured with something like spring security’s WebSecurityConfigurerAdapter
JDK vs JRE vs JVM
JDK > JRE > JVM
JDK = has dev tools
JRE = an implementation of JVM
Contains: classes required to run java programs; property files
JVM = ‘ClassLoaders’, ‘Run-time data areas (stack, heap, method area, registers), execution engine (interpreter, JIT, GC) (??? what does any of this mean)
