
def pull(values){
    sh 'sudo docker pull ${env.image_name}:${env.tag}'
    sh 'ls'
}

def push(values){
    sh 'sudo aws ecr get-login-password --region ${env.region} | sudo docker login --username AWS --password-stdin ${env.ecr_url}'
    sh 'sudo docker tag ${env.image_name}:${env.tag} ${env.repo_url}:${env.tag}'
    sh 'sudo docker push ${env.repo_url}'
            
}
