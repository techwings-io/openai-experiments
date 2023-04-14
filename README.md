# openai-experiments
Simple Spring Boot application that offers a Spring Controller and a
Spring Service to interact with Open AI API endpoint for
chat, using the gpt-3.5-turbo model. 

## Full documentation
If you want to see the full documentation about this code, please visit
[this link](https://techwings.io/2023/04/13/spring-boot-chatgpt-microservice/)

## How to run

### Prerequisites
#### Registering an account with Open AI
In order to run the application, you will need to register
an account with Open AI and get an API Key. You can 
register at the following url: https://openai.com/product

#### Obtain an API Key
Once registered, you can obtain an API key by visiting the
following url: https://platform.openai.com/account/api-keys

#### Setting up the key as an environment variable
At [techwings.io](https://techwings.io) we care about security, so this code relies on an 
environment variable named: **OPEN_AI_KEY**, which you
have to set to the value of the API key obtained in the
earlier step in order for the application to run. 

### How to run the application
You have few options: 
- You can run the integration tests to learn how the application works
- You can run the main application and use a HTTP client, like Postman, to test it

#### Using Postman
Once the application is up and running, you can send a 
*POST* request to the following URL: http://localhost:8080 
with the following body: 
```
{
  "model": "gpt-3.5-turbo",
  "messages": [{"role": "user", "content": "List BIAN domains for banking accounts and their main responsibilities"}]
}
```

At the time of writing, the response contains the following 
value: 
``` 
{
    "id": "chatcmpl-74mgzxzscBmXQYD5rJIzwssWCKUQk",
    "object": "chat.completion",
    "created": 1681374841,
    "choices": [
        {
            "index": 0,
            "message": {
                "role": "assistant",
                "content": "1. Customer Management: This domain is responsible for managing a bank’s customer accounts, including opening and closing accounts, maintaining personal information, and facilitating transactions.\n\n2. Financial Accounting: This domain is responsible for managing a bank’s financial accounting processes, including reconciling accounts, managing financial statements, and ensuring regulatory compliance.\n\n3. Credit Management: This domain is responsible for assessing the creditworthiness of potential borrowers and managing the loans and credit lines of existing borrowers.\n\n4. Payments and Collections: This domain is responsible for managing a bank’s payment and collection processes, including processing payments, managing collection efforts, and initiating automatic transfers.\n\n5. Risk Management: This domain is responsible for identifying and mitigating various types of financial risk within a bank, such as credit, market, liquidity, or operational risks.\n\n6. Fraud Management: This domain is responsible for detecting and preventing fraudulent activities within a bank, including transaction monitoring, customer profiling, and identifying potential fraudsters.\n\n7. Wealth Management: This domain is responsible for providing investment and financial planning services to high-net-worth clients, including wealth protection, wealth accumulation, and wealth distribution.\n\n8. Regulatory Compliance: This domain is responsible for ensuring that a bank complies with all applicable regulations and provides timely compliance training to its employees."
            },
            "finish_reason": "stop"
        }
    ],
    "usage": {
        "prompt_tokens": 19,
        "completion_tokens": 255,
        "total_tokens": 274
    }
}
```

Please send any feedback to [marco@techwings.io](mailto:marco@techwings.io)