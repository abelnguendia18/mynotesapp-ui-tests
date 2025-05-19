pipeline {
    agent any

    environment {
        JAVA_HOME = "/Library/Java/JavaVirtualMachines/jdk-17.0.2.jdk/Contents/Home"
        ANDROID_HOME = "${HOME}/Library/Android/sdk"
        NODE_PATH = "${HOME}/.nvm/versions/node/v22.14.0/bin"
        PATH = "${NODE_PATH}:/opt/homebrew/bin:${env.PATH}:${ANDROID_HOME}/platform-tools"
    }

    triggers {
        githubPush() // Enables GitHub webhook triggering
    }

    stages {
        stage('Checkout App Repo') {
            steps {
                dir('app') {
                    git url: 'https://github.com/abelnguendia18/MyNotesApp.git', branch: 'development'
                }
            }
        }

        stage('Checkout Test Repo') {
            steps {
                dir('tests') {
                    git url: 'https://github.com/abelnguendia18/mynotesapp-ui-tests.git', branch: 'development'
                }
            }
        }

        stage('Build APK') {
            steps {
                dir('app') {
                    sh './gradlew assembleDebug'
                }
            }
        }

        stage('Start Appium Server') {
            steps {
                sh '/Users/abelnguendiat./.nvm/versions/node/v22.14.0/bin/appium --log-level info &'
                sleep time: 10, unit: 'SECONDS' // wait for server to be ready
            }
        }

        stage('Run Appium Tests') {
            steps {
                dir('tests') {
                    sh 'mvn clean test -Dapk.path=../app/app/build/outputs/apk/debug/app-debug.apk'
                }
            }
            post {
                always {
                    allure includeProperties: false, jdk: '', results: [[path: 'tests/target/allure-results']]
                }
            }
        }

    }

    post {
        always {
            sh 'pkill -f appium || true'
        }
    }
}
