pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               bash 'java'
               //echo 'Building..'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}