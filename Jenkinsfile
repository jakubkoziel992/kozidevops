pipeline{
        agent any
        tools {
                maven "MAVEN3"
                jdk "OracleJDK21"
        }

	environment {
		awsCredential = "ecr:us-east-1:awscreds"
		appRegistry = "320183397498.dkr.ecr.us-east-1.amazonaws.com/kozidevopsregistry"
		registryUrl = "https://320183397498.dkr.ecr.us-east-1.amazonaws.com"
	}

        stages{
                stage("Fetch Code"){
                        steps{
                                git url: 'https://github.com/jakubkoziel992/kozidevops.git', branch: 'docker_ci'
                        }
                }

                stage ("Build") {
                    steps {
						dir("app"){
							sh 'mvn clean package'
						}			
					}

					post{
						success{
								echo 'Archiving artifacts now.'
								archiveArtifacts artifacts: '**/*.jar'
						}
					}
                }

                stage ("UNIT test"){
                        steps {
							dir("app"){
								sh 'mvn test'
							}		
                        }
                }

                stage ("Checkstyle Analysis"){
                        steps{
                            dir("app"){
								sh 'mvn checkstyle:checkstyle'
							}    
                        }
                }

                stage ('SonarQube analysis'){
                        environment {
                scannerHome = tool 'SonarScanner5.0.1'
            }
                        steps{
                                withSonarQubeEnv('SONAR'){
                                        sh '''${scannerHome}/bin/sonar-scanner \
                                        -Dsonar.projectKey=kozidevops \
                                        -Dsonar.projectName=kozidevops \
                                        -Dsonar.sources=app/src/ \
                                        -Dsonar.java.binaries=app/target/classes/pl/java_application/ \
                                        -Dsonar.java.checkstyle.reportPath=app/target/checkstyle-result.xml'''
                                }
                        }

                }

                stage ("Quality Gate") {
                        steps {
                                timeout(time: 1, unit: 'HOURS'){
                                        waitForQualityGate abortPipeline: true
                                }
                        }
                }

                stage ("Build App Image") {
                        steps {
                                script{
                                        app = docker.build("${env.appRegistry}:${env.BUILD_ID}"  ,"./app/")
                                      }

                                }
                        }

                                stage ("Deploy App Image to ECR"){
                                        steps{
                                                script {
                                                        docker.withRegistry(registryUrl,awsCredential){
                                                                app.push()
                                                        }
                                                }
                                        }
                                }

                }
                post {
                        success {
                                discordSend title: "Jenkins Pipeline Build", description: "${currentBuild.currentResult}: Build ${env.BUILD_NUMBER} More info at: ${env.BUILD_URL}", link: env.BUILD_URL, webhookURL: "https://discord.com/api/webhooks/1212030758491791441/cbslVZblFjHGCJFCMArTjyJgUmrUoXmkIze8c5lD2R9TeCZy2D2JFpxpv0ElJnMPUWJI"
                                }
                        failure {
                                discordSend title: "Jenkins Pipeline Build", description: "${currentBuild.currentResult}: Build ${env.BUILD_NUMBER} More info at: ${env.BUILD_URL}", link: env.BUILD_URL, webhookURL: "https://discord.com/api/webhooks/1212030758491791441/cbslVZblFjHGCJFCMArTjyJgUmrUoXmkIze8c5lD2R9TeCZy2D2JFpxpv0ElJnMPUWJI"
                                }
                        }
}
