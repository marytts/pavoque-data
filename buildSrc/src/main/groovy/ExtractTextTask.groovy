import org.gradle.api.tasks.*

class ExtractTextTask extends ExtractTask {
    @OutputDirectory
    def destDir = project.file("$project.buildDir/text")

    @TaskAction
    def extract() {
        yamlFiles.each { yamlFile ->
            yaml.load(yamlFile.newReader()).each { utterance ->
                project.file("$destDir/${utterance.prompt}.txt").text = utterance.text
            }
        }
    }
}
