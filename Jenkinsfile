pipeline{
    agent any
    stages{
        stage("Git Cloning Stage"){
            steps{
                git 'https://github.com/shahJainam961/JAIRU-Backend.git'
            }
        }
        stage("Building Stage"){
            steps{
                sh 'mvn clean&&mvn compile&&mvn package'
            }
        }
        stage("Testing Stage"){
            steps{
                sh 'mvn test'
            }
        }
        stage("build image"){
            steps{
                sh 'docker login -u "murphy961" -p "Dockerhub@961"'
                sh 'docker build -t murphy961/jairu-backend:1.0 .'
                sh 'docker push murphy961/jairu-backend:1.0'
            }
        }
//         stage("Ansible Stage"){
//             steps{
//                 sh 'ansible-playbook -i inventory playbook.yaml'
//             }
//         }
    }
}