messaging app

backend: spring boot
frontend: vite with react
database: postgres

---

TO-DO:
        ^ add ui for group chat
                - user can be active on 1 group only
                - render the chat dialog with id in ascending order

---

backend:
        user:
                - service user, 
                - can send and receive message from all users including self
                - customize self profile (name, image)

        message:
                - text-based data, 
                - created by a user, 
                - all user can see whose message is it.
                
        group:
                - display all message up to most recent
                - everytime creation of group, store all of its messages to a new table
                - have a separate table for group metadata

        login:
                - register user
                - login user

        security:
                - whitelist url path "/api/v1"
                - whitelist :3000 (frontend-react-web) in cors
                - csrf disabled

frontend:
        for now, display all messages from the database

---

add :
        validation
        unittest
        javafaker
        query
        modifying, transactional
        specification
        secrets for password

cmd:
        podman compose -f backend-boot/compose.yaml up 
        npm run dev
        
link:
        java-boot:
                http://localhost:8080
        web-react:
                http://localhost:3000
        cloudbeaver:
                http://localhost:8979

---

test:
        curl -iG http://localhost:8080/api/v1/users

        curl -iG -d "userUuid=b1141b96-bd62-413f-bcbf-ee4cd0dc008c" http://localhost:8080/api/v1/user
        
        curl -iG http://localhost:8080/api/v1/user/aaaaeda0-93b2-4ef9-826b-c51f36ff32ac

        curl -iG http://localhost:8080/api/v1/users/3
        
        
        ======
        
        [x] curl -i -X POST http://localhost:8080/api/v1/user \
                -H "Content-Type: application/json" \
                -d '{"name": "healm1"}'

        [x] curl -i -X POST http://localhost:8080/api/v1/register \
                -H "Content-Type: application/json" \
                -d '{"name": "healm1", "password": "12"}'

        ======

        curl -i -X POST http://localhost:8080/api/v1/message \
                -H "Content-Type: application/json" \
                -d '{"content": "i like pizza", "userId": 1}'


        curl -iG http://localhost:8080/api/v1/messages
                = [{"content":"i like pizza","userId":152},{"content":"i like pizza","userId":202}]

        curl -iG http://localhost:8080/api/v1/group

---





(index):1 Access to XMLHttpRequest at 'http://localhost:8080/messages' from origin 'http://localhost:3000' has been blocked by CORS policy: Response to preflight request doesn't pass access control check: No 'Access-Control-Allow-Origin' header is present on the requested resource.

curl -i -X POST http://localhost:8080/api/v1/register \
                -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZWFsbTEiLCJpYXQiOjE3ODY1MzgxMzYsImV4cCI6MTc4NjU0MTczNn0.SjC39xwnLCxAaNULfKPejNaeI2uuQZnZ4EFb3UDktjY" \
                -H "Content-Type: application/json" \
                -d '{"name": "healm1", "password": "12"}'

curl -iG http://localhost:8080/api/v1/users \
        -H "Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJoZWFsbTEiLCJpYXQiOjE3ODY1MzgxMzYsImV4cCI6MTc4NjU0MTczNn0.SjC39xwnLCxAaNULfKPejNaeI2uuQZnZ4EFb3UDktjY"
