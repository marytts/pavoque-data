import org.gradle.api.tasks.*

class ExtractWavTask extends ExtractTask {
    @OutputDirectory
    def destDir = project.file("$project.buildDir/wav")

    @TaskAction
    def extract() {
        yamlFiles.each { yamlFile ->
            yaml.load(yamlFile.newReader()).each { utterance ->
                project.exec {
                    commandLine 'sox',
                            project.file("${yamlFile.name - '.yaml' + '.flac'}"),
                            project.file("$destDir/$utterance.prompt-${utterance.style}.wav"),
                            'trim',
                            utterance.start,
                            '=' + utterance.end
                }
            }
        }
    }
}
