def call (){
  sh "echo ${params.payload} > repo.json"
  cat repo.json
}
