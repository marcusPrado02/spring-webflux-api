package com.digitalinnovationone.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

import static com.digitalinnovationone.heroesapi.constants.HeroesConstants.DYNAMO_ENDPOINT;
import static com.digitalinnovationone.heroesapi.constants.HeroesConstants.DYNAMO_REGION;

@Configuration
@EnableDynamoDBRepositories
public class HeroesTable {
    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(
                        new AwsClientBuilder.EndpointConfiguration(DYNAMO_ENDPOINT, DYNAMO_REGION)
                )
                .build();

        var dynamoDB = new DynamoDB(client);
        var tableName = "Heroes_Table";

        try {
            var table = dynamoDB.createTable(
                    tableName,
                    Arrays.asList(
                            // "KeyType.HASH" Means partition key. "KeyType.RANGE" would create a sort key.
                            new KeySchemaElement("id", KeyType.HASH)
                    ),
                    Arrays.asList(
                            // "ScalarAttributeType.S" means string. "N" would be number and "B" binary.
                            new AttributeDefinition("id", ScalarAttributeType.S)
                    ),
                    // Maximum number of reads and writes per second in this order.
                    new ProvisionedThroughput(5L, 5L)
            );
            table.waitForActive();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
