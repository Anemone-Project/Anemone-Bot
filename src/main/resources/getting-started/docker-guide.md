##This is a quick guide to build & run this application in a docker container.

   **Prerequisit**
   <br>
   - Download [Docker](https://www.docker.com/) and follow setup.
   
   <b> Step one </b> 
   - 
   Build image from root folder with the following cmd: 
   <br>
   `docker build -f Dockerfile -t <Choose a name for your container> .`
   
   e.g: `docker run -p <ApplicationPort>:<ContainerPort> <ImageName>`

       
       
   <b> Step two </b>
   -
   Run the image with following cmd: 
   <br> 
   `docker run -p <ApplicationPort>:<ContainerPort> <ImageName>`
   
   e.g: `docker run -p 8080:8080 anemone-bot`


   