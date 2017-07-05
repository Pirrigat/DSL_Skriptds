job('Modelbus-Server-Product-Git-2.0') {
    description 'ModelBus Server Build.'
    customWorkspace('workspace/ModelBus-Core-2.0-Seed/')
    steps {
        maven {
            mavenInstallation("Maven")
            goals("clean package pmd:pmd checkstyle:checkstyle")
            properties(skipTest: true)
			property("platform-version-name", "neon")
			rootPOM("TychoBuild/modelbus/build/org.modelbus.build.server.product/pom.xml")
        }
                 
    }
    publishers {
	    artifactArchiver {
		artifacts("modelbus\build\org.modelbus.build.server.product\target\products\org.modelbus.server.product\*.zip")

        }
    }
}
