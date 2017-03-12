echo 'Hallo Pipeline'

node {
	
	stage('Checkout') {
		checkout scm
	}
	
	stage('Build') {
		 execGradle('clean build');
	}
	
	stage('Results') {
	   junit '**/build/test-results/test/TEST-*.xml'
	   archive '**/build/libs/*.war'
	}

	stage('Postbuild') {
		if (isUnix()) {
			sh 'ls -la'
		} else {
			bat 'dir'
		}
	}
}
 
def execGradle(command) {
	if (isUnix()) {
		sh "./gradlew $command"
	} else {
		bat "./gradlew.bat $command"
	}
}