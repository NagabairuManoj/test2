def call (){
  sh "echo ${params.payload} > repo.json"
  def url = sh(script: "clone_url=\$(cat repo.json | grep -oP 'ssh_url:\\K\\S+' | cut -d' ' -f1); echo \$clone_url", returnStdout: true).trim()
  echo "The URL is: ${url}"
  env.URL = url // Store the URL in an environment variable for later use
  def repo_name = sh(returnStdout: true, script: "echo ${url} | awk -F/ '{ print \$(NF-0) }' | sed 's/\\.git\$//'").trim()
  env.REPO_NAME = repo_name
  echo "The repo name is: ${repo_name}"
}
