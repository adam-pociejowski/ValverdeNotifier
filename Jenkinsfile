pipeline {
    agent any

    stages {
        stage ('Build Stage') {
            steps {
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }

        stage ('Deploy Stage') {
            steps {
                 sh '
                 pwd=$(pwd)
                 echo $pwd
                 /home/valverde/scripts/notifier-run.sh'
            }
        }
    }
}