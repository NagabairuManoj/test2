def call (){
  sh "echo ${params.payload} > repo.json"
  sh "cat repo.json"
}
