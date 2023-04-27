def pull(){
    sh 'sudo docker pull nginx:latest'
    sh 'ls'
}

def push(){
    sh 'sudo aws ecr get-login-password --region ap-south-1 | sudo docker login --username AWS --password-stdin 337764066236.dkr.ecr.ap-south-1.amazonaws.com'
    sh 'sudo docker tag nginx:latest 337764066236.dkr.ecr.ap-south-1.amazonaws.com/repo1:latest'
    sh 'sudo docker push 337764066236.dkr.ecr.ap-south-1.amazonaws.com/repo1'
            
}
