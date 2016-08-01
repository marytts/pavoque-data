import org.gradle.api.tasks.*

class ExtractLabTask extends ExtractTask {
    @OutputDirectory
    def destDir = project.file("$project.buildDir/lab")

    @TaskAction
    def extract() {
        yamlFiles.each { yamlFile ->
            yaml.load(yamlFile.newReader()).each { utterance ->
                if (utterance.segments) {
                    project.file("$destDir/$utterance.prompt-${utterance.style}.lab").withWriter { lab ->
                        lab.println '#'
                        utterance.segments.each { segment ->
                            lab.println sprintf("    %s  125 %s", segment.end, segment.lab)
                        }
                    }
                }
            }
        }
    }
}
