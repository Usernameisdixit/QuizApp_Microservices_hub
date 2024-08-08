# QuizApp_Microservices_hub

This app is developed in microservice architecture

api gateway end point
http://localhost:8765/quiz-service/quiz/get/2(Get Request)
[ { "id": 5, "questionTitle": "Which of the following is not an OOPS concept in Java?", "option1": "Polymorphism", "option2": "Inheritance", "option3": "Compilation", "option4": "Encapsulation" }, { "id": 4, "questionTitle": "What will be the output of the program\nclass increment {\n public static void main(String args[]) {\n int g = 3;\n System.out.print(++g * 8);\n }\n}", "option1": "32", "option2": "34", "option3": "24", "option4": "25" } ]

service regsitry and quiz need to run and
question service can be run on multiple instances to check if services are communicating with each other or not(eureka server) and we can monitor whether 
the api gateway is working as we make reqest from quiz.(end point given above)

