Spring Boot Application fetching/posting contents as JSON from/to mongo db database 

Usage - 

1. To build the repository - 

From the repository root, 

1. run `./gradlew build test`run the build
2. run `./gradlew bootjar` to create executable jar. The jar will be located inside build directories.
3. run `./gradlew bootrun` to directly start the spring boot application 

To run inside docker container, use below commands

To build docker image, use the command below - `docker build -t your_tag_name  .`

To run the generated container, use this command - `docker run -p8080:8080 your_tag_name`. This will run the server on 8080 port.. You can change the ports as per your needs. 

###Application Workflow:- 
####Dependencies: `Java JDK & MongoDB`

1. `./gradlew bootrun` : start the spring server on port 8081
2. List of REST APIs implemented 
    <br/>2.1 GET `http://localhost:8081/memes` : Returns list of top 100 memes on database.
    <br/>2.2 GET `http://localhost:8081/memes/1` : Returns meme with specified Id and Error:404 if not found.
    <br/>2.3 POST `http://localhost:8081/memes` : Post unique memes to mongo db (Name,Caption and URL should be unique) and returns the generated unique meme Id
        <br/>JSON Data posted to the server: 
        <br/>`{
            "name" : "sambit",
            "caption" : "smaple meme",
            "url" : "dummy url"
       }`

####To-Do : `FrontEnd & UnitTest Codes`

