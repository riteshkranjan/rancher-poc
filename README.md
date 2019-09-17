#Rancher related:
## make sure docker is installed 
## run sudo docker run -d --restart=unless-stopped -p 80:80 -p 443:443 rancher/rancher
## access rancher ui at 80 port



## sudo apt update
## sudo apt-get -y install apt-transport-https ca-certificates curl software-properties-common
## curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
## sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
## sudo apt-get -y install docker-ce
## run docker version to validate in installation was successful 
## curl -fsSL get.docker.com -o get-docker.sh
## chmod +x get-docker.sh
## sudo ./get-docker.sh
## sudo usermod -aG docker $USER
