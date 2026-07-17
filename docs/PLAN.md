messaging app

backend: spring boot
frontend: angular?
database: postgres

---

backend:
        user:
                service user, 
                - can send and receive message from all users including self
                - customize self profile (name, image)

        message:
                - text-based data, 
                - created by a user, 
                - all user can see whose message is it.
                
        group:
                - for now, use only 1 global group
                - display all message up to most recent

---

command:
        compose:
                podman compose -f backend/compose.yaml up 
        
link:
        http://localhost:8080

test:
        curl -iG http://localhost:8080/users
        curl -iG -d "userId=1" http://localhost:8080/user
        curl -iG http://localhost:8080/users/healm1
        curl -i -X POST http://localhost:8080/user \
                -H "Content-Type: application/json" \
                -d '{"name": "healm1"}'

        curl -i -X POST http://localhost:8080/message \
                -H "Content-Type: application/json" \
                -d '{"content": "i like pizza", "userId": 1}'

        curl -iG http://localhost:8080/group

add :
        validation
        unittest
        javafaker
        query
        modifying, transactional
        specification
        secrets for password
