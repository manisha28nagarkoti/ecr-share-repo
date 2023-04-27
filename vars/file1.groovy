def pull(){
    sh '''
        sudo docker pull ${env.image_name}:${env.tag}
        ls
    '''
    
}

def push(){
    sh'''
    sudo aws ecr get-login-password --region ${env.region} | sudo docker login --username AWS --password-stdin ${env.ecr_url}
    sudo docker tag ${env.image_name}:${env.tag} ${env.repo_url}:${env.tag}
    sudo docker push ${env.repo_url}:${env.tag}
    '''
}

