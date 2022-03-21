# GerimedicaExample
## Description
you can call all endpoints by using  `Gerimedica.postman_collection.jsonl` file  on Postman.
you can reach the all endpoints  by using  Page : `http://localhost:8081/api/data`
you can run code using `gerimedica-1.0-SNAPSHOT.jar` file you should run command 
`java -jar gerimedica-1.0-SNAPSHOT.jar`
Of course you can run project on intellJ and Eclipse.

Also you can run this application on docker by using Dockerfile. you should change your path to Dockerfile path.
to create own image you can use command which is exist below.
`docker build image_name . `

For Run Test `mvn test`

For Reach h2 Db For web-ui `http://localhost:8081/h2-ui/`