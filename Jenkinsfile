pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               bat 'mvn clean package'
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