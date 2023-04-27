def call(M values) {
    def globalVars = [:]
    globalVars.image_name = image-name
    globalVars.region= region
    globalVars.ecr_url = ecr_url
    globalVars.tag = tag
    globalVars.repo_url= repo_url
    

    // Now you can use `globalVars.myVar` in other functions
   pull(globalVars)
   push(globalvars)
   
}
def pull(values){
    sh 'sudo docker pull ${globalVars.image_name}:${globalVars.tag}'
    sh 'ls'
}

def push(values){
    sh 'sudo aws ecr get-login-password --region ${globalVars.region} | sudo docker login --username AWS --password-stdin ${globalVars.ecr_url}'
    sh 'sudo docker tag ${globalVars.image_name}:${globalVars.tag} ${globalVars.repo_url}:${globalVars.tag}'
    sh 'sudo docker push ${globalVars.repo_url}'
            
}
