curl --location --request GET 'http://localhost:8080/projects'

curl --location --request GET 'http://localhost:8080/projects/55eaa94f-eb44-42dc-92a8-8f7cd21bcc52'

curl --location --request POST 'http://localhost:8080/projects' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": "1f8f892d-510a-4d8b-b775-b45c844e5002",
    "name": "Project 2",
    "startedOn": "2021-09-04T09:12:42",
    "projectStatus": "ACTIVE"
}'

curl --location --request PUT 'http://localhost:8080/projects/2181cd83-7d13-4c4e-a54b-9180b7fcd0e4' \
--header 'Content-Type: application/json' \
--data-raw '{
    "userId": "1f8f892d-510a-4d8b-b775-b45c844e5002",
    "name": "Project 1",
    "startedOn": "2012-09-04T09:12:42.000+00:00",
    "projectStatus": "ON_HOLD"
}'

curl --location --request DELETE 'http://localhost:8080/projects/2181cd83-7d13-4c4e-a54b-9180b7fcd0e4'
