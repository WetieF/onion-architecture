pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               bat 'java'
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