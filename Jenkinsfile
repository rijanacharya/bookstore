pipeline {
    agent any

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main', credentialsId: 'rijanacharya', url: 'https://github.com/rijanacharya/bookstore.git'
            }
        }
        stage('Build') {
            steps {
                sh 'gradle clean build' // Replace with 'gradle clean build' if using Gradle
            }
        }
        stage('Test') {
            steps {
                sh 'gradle test' // Replace with 'gradle test' if using Gradle
            }
        }
        // stage('Deploy') { //  This stage can be further customized for deployment to different environments
        //     steps {
        //         script {
        //             // Deploy your application to the target environment (e.g., using SSH or a deployment tool)
        //         }
        //     }
        //}
    }
}
