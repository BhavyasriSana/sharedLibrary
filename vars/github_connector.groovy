def call(){
  httpRequest acceptType: 'APPLICATION_JSON', authentication: 'connectors', consoleLogResponseBody: true, contentType: 'APPLICATION_JSON', httpMode: 'POST', requestBody: '''{
                "name": "vinu",
                  "description": "This is your first repository",
                  "homepage": "https://github.com",
                  "private": false,
                  "has_issues": true,
                  "has_projects": true,
                  "has_wiki": true
                }''', responseHandle: 'NONE', url: 'https://api.github.com/user/repos'
}



