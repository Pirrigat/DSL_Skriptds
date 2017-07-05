job('ModelBus-Manager-Git-2.0') {
    description 'ModelBus Manger Build.'
    customWorkspace('workspace/ModelBus-Core-2.0-Seed/')
    steps {
        maven {
            mavenInstallation("Maven")
            goals("clean package")
            properties(skipTest: true)
            rootPOM("TychoBulid/modelbus/build/org.modelbus.manager.build.master/pom.xml")
        }
                 
    }
    publishers {
    	droneRecorder {
    		serverUrl("http://10.147.66.165:8080")
    		channel("Test.ModelBus.Manager.Git.2.0")
    		deployKey("5c9a6cb4bfd9a006cd1987d90476f39df904a9c40fe1cc533d4416bab51ba048")
    		artifacts("TychoBuild/modelbus/p2repositories/org.modelbus.manager.build.category/target/*.zip")
			failsAsUpload(true)

        }
    }
}
