# requesthandler

swagger url: http://localhost:8080/v2/api-docs

start api : post : http://localhost:8080/process
request: {
    "requestId": 1,
    "user": {
        "id": 1,
        "name": "anurag",
        "birthDate": "2020-30-09"
    }
}

end api : put : http://localhost:8080/end
request:{
    "requestId": 1,
    "user": {
        "id": 1,
        "name": "anurag",
        "birthDate": "2020-30-09"
    }
}
