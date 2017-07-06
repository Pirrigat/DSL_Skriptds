job('ModelBus-SVNKit-p2-Git-2.0') {
    customWorkspace('workspace/ModelBus-Core-2.0-Seed/TychoBuild/')
    description 'ModelBus Core Build.'
    steps {
        maven {
            mavenInstallation("Maven")
            goals("clean package")
            properties(skipTest: true)
            rootPOM("TychoBuild/p2repositories/org.modelbus.svnkit.p2wrapper/pom.xml")
        }

}