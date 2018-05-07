## This is a quick guide to build & run this application in a docker container.

   **Prerequisit**
   <br>
   - Download [Docker](https://www.docker.com/) and follow setup.
   
   
  -
   
   **For easy setup inside IntelliJ**
  
   - Download Docker plugin for IntelliJ by going to: 
     <br>
     File > Settings > Plugins > Install Jetbrains plugin > Docker Integration.
   
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
   
   <b> Known issue </b>
   -
   The docker Json.config files DNS connection is by default set to null.
   This will prevent docker from building the image file. 
   
   <br>
   Modify this to a working DNS.  e.g:  `8.8.8.8` 

   