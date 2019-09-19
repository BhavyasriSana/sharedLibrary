// def request = libraryResource 'data.json'
import groovy.json.JsonSlurperClassic 




def call(){
def request = libraryResource 'data.json'
    @NonCPS
def jsonParse(def json) {
    new groovy.json.JsonSlurperClassic().parseText(request)
}
def config =  jsonParse(request)

    def db = config["name"]
    println db

    
httpRequest authentication: 'jira_password', 
    customHeaders: [[maskValue: false, name: 'Content-Type', value: 'application/json'], 
                    [maskValue: false, name: 'Accept', value: 'application/json']], 
    httpMode: 'POST', requestBody: '''{
    "key": "PIZ",
    "name": $object.name,
    "projectTypeKey": "business",
    "projectTemplateKey": "com.atlassian.jira-core-project-templates:jira-core-project-management",
    "description": "Example Project description",
    "lead": "ashnim",
    "assigneeType": "PROJECT_LEAD"
}''', responseHandle: 'NONE', url: 'http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/api/2/project'
}
