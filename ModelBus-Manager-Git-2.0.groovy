job('ModelBus-Manager-Git-2.0') {
    description 'ModelBus Manger Build.'

    steps {
        maven {
            mavenInstallation("Maven")
            goals("clean package")
            properties(skipTest: true)
            rootPOM("modelbus/build/org.modelbus.manager.build.master/pom.xml")
        }
                 
    }
    publishers {
    	droneRecorder {
    		serverUrl("http://10.147.66.165:8080")
    		channel("TestJenkins")
    		deployKey("5c9a6cb4bfd9a006cd1987d90476f39df904a9c40fe1cc533d4416bab51ba048")
    		artifacts("modelbus/p2repositories/org.modelbus.manager.build.category/target/*.zip")
			failsAsUpload(True)

        }
    }
}