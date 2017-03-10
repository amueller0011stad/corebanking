echo 'Hallo Pipeline'

node {
	stage 'checkout'
	checkout scm

	stage 'build'
	if (isUnix()) {
		sh './gradlew clean build'
	} else {
		bat './gradlew.bat clean build'
	}

	stage 'test'
	if (isUnix()) {
		sh './gradlew test'
	} else {
		bat './gradlew.bat test'
	}
	step([$class: 'JUnitResultArchiver', testResults: '**/target/test-results/TEST-*.xml'])

	stage 'package'
	if (isUnix()) {
		sh './gradlew bootRepackage'
	} else {
		bat './gradlew.bat bootRepackage'
	}
	step([$class: 'ArtifactArchiver', artifacts: '**/build/libs/*.war', fingerprint: true])

	stage: 'postbuild'
	if (isUnix()) {
		sh 'ls -la'
	} else {
		bat 'dir'
	}
}