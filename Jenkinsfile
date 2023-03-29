pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               bat 'mvn clean package'
               //echo 'Building..'
            }
        }
        steps {
               bat 'mvn --version'
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