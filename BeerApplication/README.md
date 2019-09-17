# Getting Started (env setup)   
1. checkout code   
2. run mvn clean install   
3. Go to target folder and test with `java -jar <appname>.jar`      
4. open `http://localhost:8080` to access this app


# Create docker   
1. make sure docker cli is installed   
2. run `mvn install dockerfile:build -DskipTests`     
OR   
2. docker build -t riteshkranjan/beerapplication .         
3. run `docker images` and note down image id    
4. tag image id `docker tag <imageId> riteshkranjan/beerapplication`       
5. finally push this image `docker push riteshkranjan/beerapplication`     

# Gcloud setup 
after installaiton of google cloud sdk run below commands
1. gcloud auth login    
2. gcloud config set project rancher-poc    
3. gcloud container clusters list    
4. gcloud container clusters get-credentials <cluster name> --zone <zone name>  
5. kubectl get pods   


