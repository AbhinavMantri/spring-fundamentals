package com.mycode.springboot.service;

import org.springframework.beans.factory.annotation.Value;

import com.mycode.springboot.entity.User;

import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AdminCreateUserResponse;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;

public class AuthServiceImpl implements AuthService {

    @Value("${aws.cogntio.userpool.id}")
    private String userPoolId;

    @Value("${aws.cognito.userpool.clientId}")
    private String clientId;

    @Override
    public String login(String userName, String password) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'login'");

       // AmazonCognitoIdentity client = AmazonCognitoIdentityClient.builder().build();
    
        return "";
    }

    @Override
    public boolean authenticate(String token) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'authenticate'");
    }

    @Override
    public String signUp(User user) {
        CognitoIdentityProviderClient client = CognitoIdentityProviderClient.builder().build();

        AttributeType userAttrs = AttributeType.builder()
            .name("email")
            .value(user.getEmail())
            .name("firstName")
            .value(user.getFirstName())
            .name("lastName")
            .value(user.getLastName())
            .build();

        AdminCreateUserRequest userRequest = AdminCreateUserRequest.builder()
            .userPoolId(userPoolId)
            .username(user.getUserName())
            .temporaryPassword(user.getPassword())
            .userAttributes(userAttrs)
            .messageAction("SUPPRESS")
            .build();

        // admin    
            
        // AdminCreateUserResponse response = client.adminConfirmSignUp(userRequest);    

        return "";
    }
    
}
