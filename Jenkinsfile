pipeline {
agent any
tools{
maven 'my_maven'
}
stages {
stage('Commit') {
steps {
echo 'This is the start of the pipeline'
sh 'mvn clean'
sh 'mvn compile'
sh 'mvn test'
}
}
stage('Deploy to Nexus') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'nexus-credentials',
                    usernameVariable: 'NEXUS_USER',
                    passwordVariable: 'NEXUS_PASS'
                )]) {
                    sh """
                    curl -v -u admin:admin \
                    --upload-file /var/lib/jenkins/workspace/integration_test/target/HelloWorld-0.0.1.jar \
                    http://localhost:8081/repository/maven-releases2/com/example/HelloWorld/0.0.1/HelloWorld-0.0.1.jar
                    """
                }
            }
        }

}
post {
    success {
      mail to: 'cheng.xiang@regnology.net',
           subject: "✅ SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
           body: "Build succeeded.\nSee: ${env.BUILD_URL}"
    }
    failure {
      mail to: 'cheng.xiang@regnology.net',
           subject: "❌ FAILURE: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
           body: "Build failed.\nConsole: ${env.BUILD_URL}console"
    }
  }
}
