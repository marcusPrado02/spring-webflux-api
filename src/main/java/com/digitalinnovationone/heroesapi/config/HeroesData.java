package com.digitalinnovationone.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;

import static com.digitalinnovationone.heroesapi.constants.HeroesConstants.DYNAMO_ENDPOINT;
import static com.digitalinnovationone.heroesapi.constants.HeroesConstants.DYNAMO_REGION;

public class HeroesData {
    public static void main(String[] args) throws Exception {
        var client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(DYNAMO_ENDPOINT, DYNAMO_REGION)
                )
                .build();

        var dynamoDB = new DynamoDB(client);

        var table = dynamoDB.getTable("Heroes_Table");

        var hero = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Mulher Maravilha")
                .withString("universe", "dc comics")
                .withNumber("films", 2);

        var hero2 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Viuva negra")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        var hero3 = new Item()
                .withPrimaryKey("id", "4")
                .withString("name", "Capita marvel")
                .withString("universe", "marvel")
                .withNumber("films", 2);

        table.putItem(hero);
        table.putItem(hero2);
        table.putItem(hero3);
    }
}
